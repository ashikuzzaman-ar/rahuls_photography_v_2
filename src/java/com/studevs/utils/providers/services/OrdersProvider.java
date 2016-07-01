package com.studevs.utils.providers.services;

import com.studevs.mvc.models.Orders;
import com.studevs.utils.providers.ServiceProvider;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ashik
 */
public class OrdersProvider implements ServiceProvider {

    private Session session;
    private Transaction transaction;
    private Query query;
    private String hql;

    public boolean insertOrders(Orders orders) {

        boolean isOk = false;
        this.session = sessionFactory.openSession();
        this.transaction = null;

        try {

            this.transaction = this.session.beginTransaction();
            this.session.save(orders);
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
