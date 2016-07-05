package com.studevs.utils.providers.services;

import com.studevs.mvc.models.Orders;
import com.studevs.utils.providers.ServiceProvider;
import java.util.List;
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
    private Orders orders;
    private List resultList;

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

    public Orders getSingleOrders(Long id) {

        this.orders = null;

        this.session = sessionFactory.openSession();
        this.transaction = null;

        try {

            this.transaction = this.session.beginTransaction();
            this.orders = (Orders) this.session.get(Orders.class, id);
            this.transaction.commit();
        } catch (Exception e) {

            if (this.transaction != null) {

                this.transaction.rollback();
            }
        } finally {

            this.session.close();
        }

        return this.orders;
    }

    public boolean updateOrders(Orders orders) {

        boolean isOk = false;

        this.session = sessionFactory.openSession();
        this.transaction = null;

        try {

            this.transaction = this.session.beginTransaction();
            this.orders = (Orders) this.session.get(Orders.class, orders.getId());

            if (orders.getAdvancedAmount() != null) {

                this.orders.setAdvancedAmount(orders.getAdvancedAmount());
            }

            if (orders.getEventVenue() != null) {

                this.orders.setEventVenue(orders.getEventVenue());
            }

            if (orders.getEventDate() != null) {

                this.orders.setEventDate(orders.getEventDate());
            }

            if (orders.getDeliveryDate() != null) {

                this.orders.setDeliveryDate(orders.getDeliveryDate());
            }

            if (orders.getIsFullPaid() != null) {

                this.orders.setIsFullPaid(orders.getIsFullPaid());
            }

            if (orders.getIsAppointed() != null) {

                this.orders.setIsAppointed(orders.getIsAppointed());
            }

            if (orders.getIsdelivered() != null) {

                this.orders.setIsdelivered(orders.getIsdelivered());
            }

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

    public List getCurrentOrders() {

        this.resultList = null;
        this.session = sessionFactory.openSession();
        this.transaction = null;
        this.query = null;
        this.hql = null;

        try {

            this.transaction = this.session.beginTransaction();
            this.hql = "FROM Orders O WHERE O.isdelivered = :is_delivered ORDER BY O.id DESC";
            this.query = this.session.createQuery(this.hql);
            this.query.setParameter("is_delivered", false);
            this.resultList = this.query.list();
            this.transaction.commit();
        } catch (Exception e) {

            if (this.transaction != null) {

                this.transaction.rollback();
            }
        } finally {

            this.session.close();
        }

        return this.resultList;
    }

    public List getDeliveredOrders() {

        this.resultList = null;
        this.session = sessionFactory.openSession();
        this.transaction = null;
        this.query = null;
        this.hql = null;

        try {

            this.transaction = this.session.beginTransaction();
            this.hql = "FROM Orders O WHERE O.isdelivered = :is_delivered ORDER BY O.id DESC";
            this.query = this.session.createQuery(this.hql);
            this.query.setParameter("is_delivered", true);
            this.resultList = this.query.list();
            this.transaction.commit();
        } catch (Exception e) {

            if (this.transaction != null) {

                this.transaction.rollback();
            }
        } finally {

            this.session.close();
        }

        return this.resultList;
    }
}
