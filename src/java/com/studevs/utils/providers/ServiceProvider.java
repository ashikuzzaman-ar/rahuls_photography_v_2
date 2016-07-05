/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studevs.utils.providers;

import java.io.Serializable;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author ashik
 */
public interface ServiceProvider extends Serializable {

    public static final SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    public BeanProvider beanProvider = new BeanProvider();
}
