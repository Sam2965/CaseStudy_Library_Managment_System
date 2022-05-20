package com.cg.utility;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.function.Function;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
//@Component is an annotation that allows Spring to automatically detect our custom beans.
@Component
public class JWTUtility implements Serializable {

	private static final long serialVersionUID = 234234523523L;

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
  //@Value is used to automatically assign a value from multiple environment such as spring environment, system environment, property files, bean objects, default value etc
    @Value("${jwt.secret}")
    private String secretKey;
	
  //retrieve username from jwt token
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }
        //retrieve expiration date from jwt token
        public Date getExpirationDateFromToken(String token) {
            return getClaimFromToken(token, Claims::getExpiration);
        }


        public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
            final Claims claims = getAllClaimsFromToken(token);
            return claimsResolver.apply(claims);
        }


        //for retrieving any information from token we will need the secret key
        private Claims getAllClaimsFromToken(String token) {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        }


        //check if the token has expired
        private Boolean isTokenExpired(String token) {
            final Date expiration = getExpirationDateFromToken(token);
            return expiration.before(new Date());
        }

        //validate token
        public Boolean validateToken(String token, UserDetails userDetails) {
            final String username = getUsernameFromToken(token);
            return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
        }
}
