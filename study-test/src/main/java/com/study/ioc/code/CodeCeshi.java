package com.study.ioc.code;

import com.study.ioc.DefaultListener;
import com.study.ioc.DefaultPersister;
import com.study.ioc.DefaultProvider;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * BeanFactory的对象注册与依赖绑定方式---直接编码方式
 */
public class CodeCeshi {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
		BeanFactory container = bindViaCode(beanRegistry);
		DefaultProvider provider = (DefaultProvider) container.getBean("provider");
		provider.work();
	}

	public static BeanFactory bindViaCode(BeanDefinitionRegistry registry) {
		AbstractBeanDefinition provider = new RootBeanDefinition(DefaultProvider.class);
		AbstractBeanDefinition listener = new RootBeanDefinition(DefaultListener.class);
		AbstractBeanDefinition persister = new RootBeanDefinition(DefaultPersister.class);

		// 将bean定义注册到容器中
		registry.registerBeanDefinition("provider",provider);
		registry.registerBeanDefinition("listener",listener);
		registry.registerBeanDefinition("persister",persister);

		// 指定依赖关系：构造方法注入、setter方法注入
		// 1、方法注入
		ConstructorArgumentValues argValues = new ConstructorArgumentValues();
		argValues.addIndexedArgumentValue(0,listener);
		argValues.addIndexedArgumentValue(1,persister);
		provider.setConstructorArgumentValues(argValues);

		// 2、setter方法注入
		/*MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("listener",listener));
		propertyValues.addPropertyValue(new PropertyValue("persister",persister));
		provider.setPropertyValues(propertyValues);*/

		return (BeanFactory) registry;
	}
}
