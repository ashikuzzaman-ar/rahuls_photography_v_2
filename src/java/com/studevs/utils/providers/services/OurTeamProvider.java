package com.studevs.utils.providers.services;

import com.studevs.mvc.models.OurTeam;
import com.studevs.utils.providers.ServiceProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ashik
 */
public class OurTeamProvider implements ServiceProvider {

    private Session session;
    private Transaction transaction;

    public boolean removeOurTeam(OurTeam ourTeam) {

        boolean isOk = false;
        this.session = sessionFactory.openSession();
        this.transaction = null;

        try {

            this.transaction = this.session.beginTransaction();
            this.session.delete(ourTeam);
            this.transaction.commit();
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
