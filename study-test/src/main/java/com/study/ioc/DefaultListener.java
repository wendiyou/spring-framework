package com.study.ioc;

import org.springframework.stereotype.Component;

@Component
public class DefaultListener implements IListener {
	@Override
	public void listener() {
		System.out.println("监听任务！");
	}
}
