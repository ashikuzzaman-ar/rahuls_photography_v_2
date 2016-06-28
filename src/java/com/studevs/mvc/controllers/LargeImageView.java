package com.studevs.mvc.controllers;

import com.studevs.mvc.models.FeaturePage;
import com.studevs.utils.providers.ServiceProvider;
import static com.studevs.utils.providers.ServiceProvider.beanProvider;
import com.studevs.utils.providers.services.FeaturePageProvider;
import com.studevs.utils.providers.services.GalleryImagesProvider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ashik
 */
@Controller
public class LargeImageView implements ServiceProvider {

    private FeaturePage featurePage;
    private FeaturePageProvider featurePageProvider;
    private GalleryImagesProvider galleryImagesProvider;

    private void setFeaturePage(Model model) {

        try {

            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            this.featurePage = this.featurePageProvider.getFeaturePage();

            model.addAttribute("featurePage", this.featurePage);
            model.addAttribute("encodedByteToString", beanProvider.getBean("encodedByteToString"));
        } catch (Exception e) {

            throw new ExceptionInInitializerError(e);
        }
    }

    @RequestMapping(value = "{image_id}")
    protected String doGet1(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable(value = "image_id") Long imageID) {

        this.setFeaturePage(model);

        try {

            this.galleryImagesProvider = (GalleryImagesProvider) beanProvider.getBean("galleryImagesProvider");
            model.addAttribute("galleryImages", this.galleryImagesProvider.getGalleryImage(imageID));
            model.addAttribute("imageView", "imageView");
            
            return "large_image_view";
        } catch (Exception e) {

            return "index";
        }
    }
}
