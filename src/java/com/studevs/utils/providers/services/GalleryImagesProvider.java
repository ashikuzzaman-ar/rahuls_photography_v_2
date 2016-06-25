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
    private List resultList = null;

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
}
