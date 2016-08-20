package com.zheng.test;

import java.util.concurrent.Future;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.zheng.domain.Person;
import com.zheng.service.CallbackListener;
import com.zheng.service.CallbackService;
import com.zheng.service.EventService;
import com.zheng.service.HelloService;

public class ConsumerTest extends BaseTest {

	@Autowired
	private HelloService helloService;
	@Autowired
	private CallbackService callbackService;
	@Autowired
	private EventService eventService;
	
	@Test
	public void hello() throws Exception {
		String hello = helloService.sayHello("world");
		System.out.println(hello);
	}

	@Test
	public void echoTest() throws Exception {
		EchoService echoService = (EchoService) helloService;
		String resp = (String) echoService.$echo("hello");
		System.out.println(resp);

		boolean status = RpcContext.getContext().isConsumerSide();
		System.out.println(status);
		String serverIp = RpcContext.getContext().getRemoteHost();
		System.out.println(serverIp);
		String application = RpcContext.getContext().getUrl().getParameter("application");
		System.out.println(application);
	}

	@Test
	public void testCallback() throws Exception {
		callbackService.addListener("callback-client", new CallbackListener() {
			@Override
			public void changed(String msg) {
				System.out.println("dubbo 参数回调：" + msg);
			}
		});
	}
	
	@Test
	public void testEvent() throws Exception {
		Person p = eventService.get("zl", 24);
		System.out.println(p);
		Future<Person> personFuture = RpcContext.getContext().getFuture();
		Person person = personFuture.get();
		System.out.println("客户端调用: " + personFuture.get());
		
	}
	
	
}
