package com.lil.spring_demo;

import com.lil.spring_demo.adapter.Apple;
import com.lil.spring_demo.adapter.AppleAdapter;
import com.lil.spring_demo.adapter.MoroOrange;
import com.lil.spring_demo.adapter.Orange;
import com.lil.spring_demo.decorator.Pepperoni;
import com.lil.spring_demo.decorator.Pizza;
import com.lil.spring_demo.decorator.ThickCrustPizza;
import com.lil.spring_demo.prototype.NotPrototype;
import com.lil.spring_demo.prototype.Prototype;
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
	public void testSingleton(){
		SingletonA singletonA1 = SingletonA.getInstance();
		SingletonA singletonA2 = SingletonA.getInstance();
		Assertions.assertNotNull(singletonA1);
		Assertions.assertNotNull(singletonB1);

		Assertions.assertSame(singletonA1, singletonA2);
		Assertions.assertSame(singletonB1, singletonB2);

	}

	@Autowired
	Prototype protoA;
	@Autowired
	Prototype protoB;
	@Autowired
	NotPrototype notProtoA;
	@Autowired
	NotPrototype notProtoB;

	@Test
	public void testPrototype(){
		Assertions.assertSame(notProtoA, notProtoB);
		Assertions.assertNotSame(protoA, protoB);
	}

	@Test
	public void testAdapter(){
		Orange orange = new MoroOrange();
		Apple apple = new AppleAdapter(orange);
		System.out.println(apple.getVariety());
		apple.eat();
	}

	@Test
	public void testDecorator(){
		Pizza pizza = new ThickCrustPizza();
		System.out.println(pizza.getCost());
		System.out.println(pizza.getDescription());

		Pepperoni pepperoniPizza = new Pepperoni(pizza);
		System.out.println(pepperoniPizza.getCost());
		System.out.println(pepperoniPizza.getDescription());

		Pepperoni doublePepperoniPizza = new Pepperoni(pepperoniPizza);
		System.out.println(doublePepperoniPizza.getCost());
		System.out.println(doublePepperoniPizza.getDescription());
	}
}
