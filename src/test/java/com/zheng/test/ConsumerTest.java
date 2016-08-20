package com.zheng.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.service.EchoService;
import com.zheng.service.HelloService;

public class ConsumerTest {

	@Test
	@SuppressWarnings("resource")
	public void consume() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] {"spring-mvc.xml", "applicationContext.xml"});
		ctx.start();
		HelloService helloService = (HelloService) ctx.getBean("helloService");
		String hello = helloService.sayHello("world");
		System.out.println(hello);
		
	}
	
	@Test
	public void echoTest() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] {"spring-mvc.xml", "applicationContext.xml"});
		ctx.start();
		HelloService helloService = (HelloService) ctx.getBean("helloService");
		EchoService echoService = (EchoService) helloService;
		
		String resp = (String) echoService.$echo("hello");
		System.out.println(resp);
	}
}
