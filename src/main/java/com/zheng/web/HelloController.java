package com.zheng.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zheng.domain.FileWrapper;
import com.zheng.domain.Person;
import com.zheng.service.FileService;
import com.zheng.service.HelloService;
import com.zheng.service.ValidationService;

@Controller
public class HelloController {
	@Autowired
	private HelloService helloService;
	
	@Autowired
	private FileService fileService;
	
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
	
	@RequestMapping("/file")
	public String upload() throws Exception {
		InputStream input = fileService.getFileStream();
		System.out.println(input);
		int len = -1;
		File outFile = new File("I:\\test.java");
		if(!outFile.exists()) {
			outFile.createNewFile();
		}
		FileOutputStream output = new FileOutputStream(outFile);
		while((len = input.read()) != -1) {
			output.write(len);
		}
		
		output.close();
		input.close();
		System.out.println("ok");
		return "文件上传完毕...";
	}
	
	@RequestMapping("/files")
	public void uploads() throws Exception {
		FileWrapper wrapper = fileService.getFileStreams();
		List<byte[]> inputs = wrapper.getInputs();
		byte[] data = null;
		for(int i = 0; i < inputs.size(); i++) {
			data = inputs.get(i);
			File outFile = new File("I:\\test"+i + ".java");
			if(!outFile.exists()) {
				outFile.createNewFile();
			}
			
			FileOutputStream output = new FileOutputStream(outFile);
			output.write(data);
			
			output.close();
			System.out.println("ok");
		}
	}
	
}
