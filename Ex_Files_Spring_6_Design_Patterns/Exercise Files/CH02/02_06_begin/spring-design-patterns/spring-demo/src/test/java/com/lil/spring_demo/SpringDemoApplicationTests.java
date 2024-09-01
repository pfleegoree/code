package com.lil.spring_demo;

import com.lil.spring_demo.singleton.SingletonA;
import com.lil.spring_demo.singleton.SingletonB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	SingletonB singletonB1;

	@Autowired
	SingletonB singletonB2;

	@Test
	public void setSingletonB(){
		SingletonA singletonA1 = SingletonA.getInstance();
		SingletonA singletonA2 = SingletonA.getInstance();
		Assertions.assertNotNull(singletonA1);
		Assertions.assertNotNull(singletonB1);
		Assertions.assertSame(singletonA1, singletonA2);
		Assertions.assertSame(singletonB1, singletonB2);
	}


}
