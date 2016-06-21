/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studevs.utils.providers;

import com.studevs.falgun.frameworks.persistence.interfaces.SessionFactoryProvider;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author ashik
 */
public class SessionFactoryProviderImplementation implements SessionFactoryProvider {

    private final SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

    @Override
    public SessionFactory getSessionFactory() {

        return this.sessionFactory;
    }
}
