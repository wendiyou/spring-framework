package com.study.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MainCeshi {

	public static void main(String[] args) {
		BeanFactory container = new XmlBeanFactory(new ClassPathResource("ioc-test.xml"));
		DefaultProvider provider = (DefaultProvider)container.getBean("provider");
		provider.work();

		/*ApplicationContext container = new ClassPathXmlApplicationContext("ioc-test.xml");
		DefaultProvider provider = (DefaultProvider)container.getBean("provider");
		provider.work();*/

		/*ApplicationContext container = new FileSystemXmlApplicationContext("classpath:ioc-test.xml");
		DefaultProvider provider = (DefaultProvider)container.getBean("provider");
		provider.work();*/
	}
}
