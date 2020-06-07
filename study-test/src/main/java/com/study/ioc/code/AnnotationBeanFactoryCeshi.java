package com.study.ioc.code;

import com.study.ioc.DefaultProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注解方式测试
 */
public class AnnotationBeanFactoryCeshi {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ioc-annotation-test.xml");
		DefaultProvider provider = (DefaultProvider) context.getBean("defaultProvider");
		provider.work();
	}
}
