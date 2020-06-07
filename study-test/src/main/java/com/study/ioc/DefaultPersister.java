package com.study.ioc;

import org.springframework.stereotype.Component;

@Component
public class DefaultPersister implements IPersister {
	@Override
	public void persister() {
		System.out.println("持久化！");
	}
}
