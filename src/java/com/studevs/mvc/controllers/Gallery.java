package com.studevs.mvc.controllers;

import com.studevs.mvc.models.FeaturePage;
import com.studevs.mvc.models.GalleryImages;
import static com.studevs.utils.providers.ServiceProvider.beanProvider;
import com.studevs.utils.providers.services.FeaturePageProvider;
import com.studevs.utils.providers.services.GalleryImagesProvider;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ashik
 */
@Controller
public class Gallery {
    
    private FeaturePage featurePage;
    private FeaturePageProvider featurePageProvider;
    private List<GalleryImages> galleryImageses;
    private GalleryImagesProvider galleryImagesProvider ;
    
    
    
    private void setComponents(Model model, int initialValue, int terminalValue){
        
        try {
            
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            this.featurePage = this.featurePageProvider.getFeaturePage();
            
            this.galleryImagesProvider = (GalleryImagesProvider) beanProvider.getBean("galleryImagesProvider");
            this.galleryImageses = this.galleryImagesProvider.getGalleryImages(initialValue, terminalValue);
            
            model.addAttribute("galleryImageses", this.galleryImageses);
            model.addAttribute("featurePage", this.featurePage);
            model.addAttribute("encodedByteToString", beanProvider.getBean("encodedByteToString"));
        } catch (Exception e) {
            
            throw new ExceptionInInitializerError(e);
        }
    }
    
    
    
    @RequestMapping(value = "gallery")
    protected String doGet1(Model model){
        
        try {
            
            this.setComponents(model, 0, 30);
            
            return "gallery";
        } catch (Exception e) {
            
            return "index";
        }
    }
}
