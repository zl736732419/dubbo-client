package com.zheng.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zheng.service.HelloService;

@Controller
public class HelloController {
	@Autowired
	private HelloService helloService;
	
	@RequestMapping("/hello")
	public void sayHello() {
		String hello = helloService.sayHello("world");
		System.out.println(hello);
	}
	
}
