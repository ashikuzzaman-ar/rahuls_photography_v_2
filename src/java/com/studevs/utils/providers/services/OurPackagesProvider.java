/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studevs.utils.providers.services;

import com.studevs.mvc.models.OurPackages;
import com.studevs.utils.providers.ServiceProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ashik
 */
public class OurPackagesProvider implements ServiceProvider {

    private Session session;
    private Transaction transaction;

    public boolean removeOurPackages(OurPackages ourPackages) {

        boolean isOk = false;
        this.session = sessionFactory.openSession();
        this.transaction = null;

        try {

            this.transaction = this.session.beginTransaction();
            this.session.delete(ourPackages);
            this.transaction.commit();

            isOk = true;
        } catch (Exception e) {

            if (this.transaction != null) {

                this.transaction.rollback();
            }
        } finally {

            this.session.close();
        }

        return isOk;
    }
}
