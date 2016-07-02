package com.studevs.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetBeans<T> {

    private ClassPathXmlApplicationContext context;

    public void setFileName(String classpathBeanFile) {
        context = new ClassPathXmlApplicationContext(classpathBeanFile);
    }

    public T getBean(String beanName) {
        return (T) context.getBean(beanName);
    }

}
