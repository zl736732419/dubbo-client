package com.zheng.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zheng.domain.Person;
import com.zheng.service.MyEventNotifyService;


@Service("myEventNotifyService")
public class MyEventNotifyServiceImpl implements MyEventNotifyService {

	private List<Person> persons = new ArrayList<>();
	private List<Throwable> errors = new ArrayList<>();

	@Override
	public void onreturn(Person person) {
		persons.add(person);
		System.out.println("onreturn ....");
	}

	@Override
	public void onthrow(Throwable x) {
		errors.add(x);
		System.out.println("onthrow....");
	}

}
