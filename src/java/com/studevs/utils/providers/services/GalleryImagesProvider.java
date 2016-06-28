/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studevs.utils.providers.services;

import com.studevs.mvc.models.GalleryImages;
import com.studevs.utils.providers.ServiceProvider;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ashik
 */
public class GalleryImagesProvider implements ServiceProvider {

    private GalleryImages galleryImages;
    private Session session;
    private Transaction transaction;
    private Query query;
    private String hql;
    private List resultList;

    public boolean insertNewImage(GalleryImages galleryImages) {

        boolean isOk = false;

        this.session = sessionFactory.openSession();
        this.transaction = null;

        try {

            this.transaction = this.session.beginTransaction();

            this.session.save(galleryImages);

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

    public boolean deleteImage(Long photoID) {

        boolean isOk = false;

        this.session = sessionFactory.openSession();
        this.transaction = null;
        this.galleryImages = (GalleryImages) beanProvider.getBean("galleryImages");
        this.galleryImages.setId(photoID);

        try {

            this.transaction = this.session.beginTransaction();

            this.session.delete(this.galleryImages);

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

    public GalleryImages getGalleryImage(Long id) {

        this.galleryImages = null;
        this.session = sessionFactory.openSession();
        this.transaction = null;
        this.query = null;

        try {

            this.transaction = this.session.beginTransaction();

            this.hql = "FROM GalleryImages GI WHERE GI.id = :image_id";
            this.query = this.session.createQuery(this.hql);
            this.query.setParameter("image_id", id);

            this.resultList = this.query.list();
            this.transaction.commit();

            if (this.resultList != null && this.resultList.size() > 0) {

                this.galleryImages = (GalleryImages) this.resultList.get(0);
            }
        } catch (Exception e) {

            if (this.transaction != null) {

                this.transaction.rollback();
            }
            throw new ExceptionInInitializerError(e);
        } finally {

            this.session.close();
        }

        return this.galleryImages;
    }

    public List getGalleryImages(int initialValue, int terminalValue) {

        this.resultList = null;
        this.session = sessionFactory.openSession();
        this.transaction = null;
        this.query = null;

        try {

            this.transaction = this.session.beginTransaction();

            this.hql = "FROM GalleryImages GI ORDER BY GI.id DESC";
            this.query = this.session.createQuery(this.hql);
            this.query.setFirstResult(initialValue);
            this.query.setMaxResults(terminalValue);

            this.resultList = this.query.list();
            this.transaction.commit();
        } catch (Exception e) {

            if (this.transaction != null) {

                this.transaction.rollback();
            }
            throw new ExceptionInInitializerError(e);
        } finally {

            this.session.close();
        }

        return this.resultList;
    }
}
