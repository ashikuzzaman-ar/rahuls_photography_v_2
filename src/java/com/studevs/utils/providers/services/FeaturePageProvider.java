package com.studevs.utils.providers.services;

import com.studevs.mvc.models.FeaturePage;
import com.studevs.utils.providers.ServiceProvider;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ashik
 */
public class FeaturePageProvider implements ServiceProvider {

    private Session session;
    private Transaction transaction;
    private Query query;
    private String hql;
    private FeaturePage featurePage;
    private List resultList;

    public boolean updateCoverPhotosOfFeaturePage(FeaturePage featurePage) {

        boolean isOk = false;

        try {

            if (this.getFeaturePage() == null) {

                this.session = sessionFactory.openSession();
                this.transaction = null;
                this.transaction = this.session.beginTransaction();
                this.session.save(featurePage);
            } else {

                this.session = sessionFactory.openSession();
                this.transaction = null;
                this.transaction = this.session.beginTransaction();

                this.featurePage.setCoverPhotos(featurePage.getCoverPhotos());

                this.session.update(this.featurePage);
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

    public boolean updateAboutUsPhotosOfFeaturePage(FeaturePage featurePage) {

        boolean isOk = false;

        try {

            if (this.getFeaturePage() == null) {

                this.session = sessionFactory.openSession();
                this.transaction = null;
                this.transaction = this.session.beginTransaction();
                this.session.save(featurePage);
            } else {

                this.session = sessionFactory.openSession();
                this.transaction = null;
                this.transaction = this.session.beginTransaction();

                this.featurePage.setAboutUsPhotos(featurePage.getAboutUsPhotos());

                this.session.update(this.featurePage);
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

    public boolean updateOurSkillsPhotoOfFeaturePage(FeaturePage featurePage) {

        boolean isOk = false;

        try {

            if (this.getFeaturePage() == null) {

                this.session = sessionFactory.openSession();
                this.transaction = null;
                this.transaction = this.session.beginTransaction();
                this.session.save(featurePage);
            } else {

                this.session = sessionFactory.openSession();
                this.transaction = null;
                this.transaction = this.session.beginTransaction();

                this.featurePage.setOurSkillsPhoto(featurePage.getOurSkillsPhoto());

                this.session.update(this.featurePage);
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

    public boolean updateSomeMilestoneWorksPhotoOfFeaturePage(FeaturePage featurePage) {

        boolean isOk = false;

        try {

            if (this.getFeaturePage() == null) {

                this.session = sessionFactory.openSession();
                this.transaction = null;
                this.transaction = this.session.beginTransaction();
                this.session.save(featurePage);
            } else {

                this.session = sessionFactory.openSession();
                this.transaction = null;
                this.transaction = this.session.beginTransaction();

                this.featurePage.setSomeMilestoneWorksPhoto(featurePage.getSomeMilestoneWorksPhoto());

                this.session.update(this.featurePage);
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

    public boolean updateContactUsPhotoOfFeaturePage(FeaturePage featurePage) {

        boolean isOk = false;

        try {

            if (this.getFeaturePage() == null) {

                this.session = sessionFactory.openSession();
                this.transaction = null;
                this.transaction = this.session.beginTransaction();
                this.session.save(featurePage);
            } else {

                this.session = sessionFactory.openSession();
                this.transaction = null;
                this.transaction = this.session.beginTransaction();

                this.featurePage.setContactUsPhoto(featurePage.getContactUsPhoto());

                this.session.update(this.featurePage);
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

    public boolean updateStartingGifAnimationOfFeaturePage(FeaturePage featurePage) {

        boolean isOk = false;

        try {

            if (this.getFeaturePage() == null) {

                this.session = sessionFactory.openSession();
                this.transaction = null;
                this.transaction = this.session.beginTransaction();
                this.session.save(featurePage);
            } else {

                this.session = sessionFactory.openSession();
                this.transaction = null;
                this.transaction = this.session.beginTransaction();

                this.featurePage.setStartingGifAnimation(featurePage.getStartingGifAnimation());

                this.session.update(this.featurePage);
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

    public boolean updateSomeMilestoneWorksCounterOfFeaturePage(FeaturePage featurePage) {

        boolean isOk = false;

        try {

            if (this.getFeaturePage() == null) {

                this.session = sessionFactory.openSession();
                this.transaction = null;
                this.transaction = this.session.beginTransaction();
                this.session.save(featurePage);
            } else {

                this.session = sessionFactory.openSession();
                this.transaction = null;
                this.transaction = this.session.beginTransaction();

                this.featurePage.setSomeMilestoneWorksCounter(featurePage.getSomeMilestoneWorksCounter());

                this.session.update(this.featurePage);
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

    public FeaturePage getFeaturePage() {

        this.featurePage = null;
        this.session = sessionFactory.openSession();
        this.transaction = null;
        this.query = null;
        this.resultList = null;

        try {

            this.transaction = this.session.beginTransaction();
            this.hql = "FROM FeaturePage FP";
            this.query = this.session.createQuery(this.hql);

            this.resultList = this.query.list();

            this.transaction.commit();

            if (this.resultList != null && this.resultList.size() > 0) {

                this.featurePage = (FeaturePage) this.resultList.get(0);
            }
        } catch (Exception e) {

            if (this.transaction != null) {

                this.transaction.rollback();
            }
        } finally {

            this.session.close();
        }

        return this.featurePage;
    }
}
