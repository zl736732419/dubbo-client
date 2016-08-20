package com.zheng.service;

import com.zheng.domain.Person;

/**
 * 客户端在调用服务端时的事件处理
 * @author zhenglian
 *
 */
public interface MyEventNotifyService {

	public void onreturn(Person person);

	public void onthrow(Throwable x);

}
