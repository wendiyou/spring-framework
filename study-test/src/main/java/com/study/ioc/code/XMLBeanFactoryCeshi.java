package com.study.ioc.code;

import com.study.ioc.DefaultProvider;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * xml配置格式的加载
 */
public class XMLBeanFactoryCeshi {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
		BeanFactory container = bindViaXMLFile(beanRegistry);
		DefaultProvider provider = (DefaultProvider) container.getBean("provider");
		provider.work();
	}

	public static BeanFactory bindViaXMLFile(BeanDefinitionRegistry registry) {
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		reader.loadBeanDefinitions("classpath:ioc-test.xml");
		return (BeanFactory) registry;

		//return new XmlBeanFactory(new ClassPathResource("ioc-test.xml"));
	}
}
