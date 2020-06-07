package com.study.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultProvider {

	@Autowired
	private IListener listener;
	@Autowired
	private IPersister persister;

	public DefaultProvider(IListener listener,IPersister persister) {
		this.listener = listener;
		this.persister = persister;
	}

	public void work() {
		System.out.println("工作开始：");
		listener.listener();
		persister.persister();
		System.out.println("工作结束！");
	}
}
