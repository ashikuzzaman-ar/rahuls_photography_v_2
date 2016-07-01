package com.studevs.mvc.controllers;

import com.studevs.mvc.models.FeaturePage;
import com.studevs.mvc.models.GalleryImages;
import com.studevs.utils.providers.ServiceProvider;
import com.studevs.utils.providers.services.FeaturePageProvider;
import com.studevs.utils.providers.services.GalleryImagesProvider;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ashik
 */
@Controller
public class AdminPanel implements ServiceProvider {

    private FeaturePage featurePage;
    private FeaturePageProvider featurePageProvider;
    private GalleryImagesProvider galleryImagesProvider;
    private GalleryImages galleryImages;

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

    @RequestMapping("admin_panel")
    public String doGET1() {
        return "admin_panel";
    }

//    @RequestMapping(value = "admin_panel_change_password")
//    protected String doPost3(Model model,
//            @RequestParam(value = "password") String password) {
//
//        this.setFeaturePage(model);
//
//        try {
//
//            this.adminProvider = (AdminProvider) beanProvider.getBean("adminProvider");
//
//            this.admin.setPassword(password);
//            this.adminProvider.updatePassword(this.admin);
//
//            return "admin_panel";
//        } catch (Exception e) {
//
//            request.getSession().setAttribute("admin", null);
//            return "admin_panel";
//        }
//    }
    @RequestMapping(value = "admin_panel_upload_new_photos")
    protected String doPost4(Model model,
            @RequestParam(value = "image") MultipartFile[] images,
            @RequestParam(value = "category") List<String> category) {

        this.setFeaturePage(model);

        try {

            this.galleryImagesProvider = (GalleryImagesProvider) beanProvider.getBean("galleryImagesProvider");

            if (images != null && images.length > 0) {

                for (int i = 0; i < images.length; i++) {

                    if (images[i].getBytes().length > 0) {

                        this.galleryImages = (GalleryImages) beanProvider.getBean("galleryImages");
                        this.galleryImages.setImage(images[i].getBytes());
                        this.galleryImages.setImageFormat(images[i].getContentType());
                        this.galleryImages.setCategory(category.get(i));

                        this.galleryImagesProvider.insertNewImage(this.galleryImages);
                    }
                }
            }
            return "admin_panel";

        } catch (Exception e) {

            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_delete_photo")
    protected String doPost5(Model model,
            @RequestParam(value = "photoID") Long photoID) {

        this.setFeaturePage(model);

        try {

            this.galleryImagesProvider = (GalleryImagesProvider) beanProvider.getBean("galleryImagesProvider");

            if (photoID != null) {

                this.galleryImagesProvider.deleteImage(photoID);
            }
            return "admin_panel";
        } catch (Exception e) {

            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_background_slide_update")
    protected String doPost6(Model model,
            @RequestParam(value = "image") MultipartFile[] images) {

        this.setFeaturePage(model);

        try {

            this.featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            byte[][] imageByte = new byte[3][];

            if (images != null && images.length > 0) {

                for (int i = 0; i < images.length; i++) {

                    if (images[i].getBytes().length > 0) {

                        imageByte[i] = images[i].getBytes();
                    }
                }

                this.featurePage.setCoverPhotos(imageByte);
                this.featurePageProvider.updateCoverPhotosOfFeaturePage(this.featurePage);
            }
            return "admin_panel";
        } catch (Exception e) {

            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_about_us_slides_update")
    protected String doPost7(Model model,
            @RequestParam(value = "image") MultipartFile[] images) {

        this.setFeaturePage(model);

        try {

            this.featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            byte[][] imageByte = new byte[5][];

            if (images != null && images.length > 0) {

                for (int i = 0; i < images.length; i++) {

                    if (images[i].getBytes().length > 0) {

                        imageByte[i] = images[i].getBytes();
                    }
                }

                this.featurePage.setAboutUsPhotos(imageByte);
                this.featurePageProvider.updateAboutUsPhotosOfFeaturePage(this.featurePage);
            }
            return "admin_panel";
        } catch (Exception e) {

            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_our_skills_background_update")
    protected String doPost8(Model model,
            @RequestParam(value = "image") MultipartFile image) {

        this.setFeaturePage(model);

        try {

            this.featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            byte[] imageByte;

            if (image != null && image.getBytes().length > 0) {

                imageByte = image.getBytes();

                this.featurePage.setOurSkillsPhoto(imageByte);
                this.featurePageProvider.updateOurSkillsPhotoOfFeaturePage(this.featurePage);
            }
            return "admin_panel";

        } catch (Exception e) {

            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_some_milestone_works_backgroud_update")
    protected String doPost9(Model model,
            @RequestParam(value = "image") MultipartFile image) {

        this.setFeaturePage(model);

        try {

            this.featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            byte[] imageByte;

            if (image != null && image.getBytes().length > 0) {

                imageByte = image.getBytes();

                this.featurePage.setSomeMilestoneWorksPhoto(imageByte);
                this.featurePageProvider.updateSomeMilestoneWorksPhotoOfFeaturePage(this.featurePage);
            }
            return "admin_panel";
        } catch (Exception e) {

            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_contacts_background_update")
    protected String doPost10(Model model,
            @RequestParam(value = "image") MultipartFile image) {

        this.setFeaturePage(model);

        try {

            this.featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            byte[] imageByte;

            if (image != null && image.getBytes().length > 0) {

                imageByte = image.getBytes();

                this.featurePage.setContactUsPhoto(imageByte);
                this.featurePageProvider.updateContactUsPhotoOfFeaturePage(this.featurePage);
            }
            return "admin_panel";

        } catch (Exception e) {

            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_starting_gif_update")
    protected String doPost11(Model model,
            @RequestParam(value = "image") MultipartFile image) {

        this.setFeaturePage(model);

        try {

            this.featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            byte[] imageByte;

            if (image != null && image.getBytes().length > 0) {

                imageByte = image.getBytes();

                this.featurePage.setStartingGifAnimation(imageByte);
                this.featurePageProvider.updateStartingGifAnimationOfFeaturePage(this.featurePage);
            }
            return "admin_panel";

        } catch (Exception e) {

            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_some_milestone_works_counter_update")
    protected String doPost12(Model model,
            @RequestParam Map<String, String> someMilestoneWorks) {

        this.setFeaturePage(model);

        try {

            this.featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            this.featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            Integer[] someMilestoneWork = new Integer[4];

            if (someMilestoneWorks != null) {

                someMilestoneWork[0] = Integer.parseInt(someMilestoneWorks.get("clients"));
                someMilestoneWork[1] = Integer.parseInt(someMilestoneWorks.get("photos"));
                someMilestoneWork[2] = Integer.parseInt(someMilestoneWorks.get("events"));
                someMilestoneWork[3] = Integer.parseInt(someMilestoneWorks.get("subscribers"));

                this.featurePage.setSomeMilestoneWorksCounter(someMilestoneWork);
                this.featurePageProvider.updateSomeMilestoneWorksCounterOfFeaturePage(this.featurePage);
            }
            return "admin_panel";

        } catch (Exception e) {
            return "admin_panel";
        }
    }
}
