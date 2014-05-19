package com.ibatis.poc.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class BeanManager implements BeanFactoryAware {

	private BeanFactory beanFactory;

	public Object createBeanObject(String beanName) {
		return this.beanFactory.getBean(beanName);
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

}
