package com.cg;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
//Spring Boot provides the @SpringBootTest annotation which we can use to create an application context containing all the objects we need for all of the above test types.
@SpringBootTest
class EurekaServerServiceApplicationTests {
	//Test annotation tells JUnit that the public void method to which it is attached can be run as a test case.
	@Test
	void contextLoads() {
	}

}
