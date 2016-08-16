package com.zheng.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zheng.domain.Person;
import com.zheng.service.HelloService;
import com.zheng.service.ValidationService;

@Controller
public class HelloController {
	@Autowired
	private HelloService helloService;
	
	@Autowired
	private ValidationService validationService;
	
	@RequestMapping("/hello")
	public void sayHello() {
		String hello = helloService.sayHello("world");
		System.out.println(hello);
	}
	
	@RequestMapping("/validation")
	public void validation() {
		Person person = new Person("zl", 18);
		String desc = validationService.descs(person);
		System.out.println(desc);
		
		validationService.delete(1);
	}
	
}
