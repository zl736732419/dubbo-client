package com.zheng.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zheng.service.HelloService;

public class ConsumerTest {

	@Test
	@SuppressWarnings("resource")
	public void consume() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "consumer.xml" });
		ctx.start();
		HelloService helloService = (HelloService) ctx.getBean("helloService");
		String hello = helloService.sayHello("world");
		
		System.out.println(hello);
	}
}
