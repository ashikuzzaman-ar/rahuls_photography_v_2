package com.studevs.utils.providers.services;

import com.studevs.mvc.models.Admin;
import com.studevs.utils.providers.ServiceProvider;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ashik
 */
public class AdminProvider implements ServiceProvider {

    private Admin admin;
    private Session session;
    private Transaction transaction;
    private Query query;
    private String hql;
    private List resultList = null;

    public boolean isAdmin(Admin admin) {

        this.session = sessionFactory.openSession();
        this.transaction = null;

        try {

            this.transaction = this.session.beginTransaction();

            this.hql = "FROM Admin A WHERE "
                    + "A.username = :a_username";

            this.query = this.session.createQuery(this.hql);
            this.query.setParameter("a_username", admin.getUsername());

            this.resultList = this.query.list();

            this.transaction.commit();
        } catch (Exception e) {

            if (this.transaction != null) {

                this.transaction.rollback();
            }
        } finally {

            this.session.close();
        }

        if (this.resultList != null && this.resultList.size() > 0) {

            this.admin = (Admin) this.resultList.get(0);

            return this.admin.equals(admin);
        } else {

            return false;
        }
    }
}
