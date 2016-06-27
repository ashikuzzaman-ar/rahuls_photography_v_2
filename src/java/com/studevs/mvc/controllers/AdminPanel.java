package com.studevs.mvc.controllers;

import com.studevs.mvc.models.Admin;
import com.studevs.mvc.models.FeaturePage;
import com.studevs.mvc.models.GalleryImages;
import com.studevs.utils.providers.ServiceProvider;
import com.studevs.utils.providers.services.AdminProvider;
import com.studevs.utils.providers.services.FeaturePageProvider;
import com.studevs.utils.providers.services.GalleryImagesProvider;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ashik
 */
@Controller
public class AdminPanel implements ServiceProvider {

    @RequestMapping(value = "admin_panel")
    protected String doGet1(HttpServletRequest request) {

        try {

            return "admin_panel";
        } catch (Exception e) {

            request.getSession().setAttribute("admin", null);
            return "index";
        }
    }

    @RequestMapping(value = "admin_panel_logged_in")
    protected String doPost1(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("admin") Admin admin,
            BindingResult bindingResult) {

        try {

            AdminProvider adminProvider = (AdminProvider) beanProvider.getBean("adminProvider");

            if (!bindingResult.hasErrors() && adminProvider.isAdmin(admin)) {

                request.getSession().setAttribute("admin", admin);
            } else {

                request.getSession().setAttribute("admin", null);
            }

            return "admin_panel";
        } catch (Exception e) {

            request.getSession().setAttribute("admin", null);
            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_logged_out")
    protected String doGet2(HttpServletRequest request) {

        try {

            request.getSession().setAttribute("admin", null);
            return "admin_panel";//admin_panel
        } catch (Exception e) {

            request.getSession().setAttribute("admin", null);
            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_change_password")
    protected String doPost3(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "password") String password) {

        try {

            Admin admin = (Admin) request.getSession().getAttribute("admin");
            AdminProvider adminProvider = (AdminProvider) beanProvider.getBean("adminProvider");

            if (admin == null) {

                return "admin_panel";
            } else {

                admin.setPassword(password);
                adminProvider.updatePassword(admin);

                return "admin_panel";
            }
        } catch (Exception e) {

            request.getSession().setAttribute("admin", null);
            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_upload_new_photos")
    protected String doPost4(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "image") MultipartFile[] images,
            @RequestParam(value = "category") List<String> category) {

        try {

            Admin admin = (Admin) request.getSession().getAttribute("admin");
            GalleryImages galleryImages;
            GalleryImagesProvider galleryImagesProvider = (GalleryImagesProvider) beanProvider.getBean("galleryImagesProvider");

            if (admin == null) {

                return "admin_panel";
            } else {

                if (images != null && images.length > 0) {

                    for (int i = 0; i < images.length; i++) {

                        if (images[i].getBytes().length > 0) {

                            galleryImages = (GalleryImages) beanProvider.getBean("galleryImages");
                            galleryImages.setImage(images[i].getBytes());
                            galleryImages.setImageFormat(images[i].getContentType());
                            galleryImages.setCategory(category.get(i));

                            galleryImagesProvider.insertNewImage(galleryImages);
                        }
                    }
                }
                return "admin_panel";
            }
        } catch (Exception e) {

            request.getSession().setAttribute("admin", null);
            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_delete_photo")
    protected String doPost5(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "photoID") Long photoID) {

        try {

            Admin admin = (Admin) request.getSession().getAttribute("admin");
            GalleryImagesProvider galleryImagesProvider = (GalleryImagesProvider) beanProvider.getBean("galleryImagesProvider");

            if (admin == null) {

                return "admin_panel";
            } else {

                if (photoID != null) {

                    galleryImagesProvider.deleteImage(photoID);
                }
                return "admin_panel";
            }
        } catch (Exception e) {

            request.getSession().setAttribute("admin", null);
            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_background_slide_update")
    protected String doPost6(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "image") MultipartFile[] images) {

        try {

            Admin admin = (Admin) request.getSession().getAttribute("admin");
            FeaturePage featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            FeaturePageProvider featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            byte[][] imageByte = new byte[3][];

            if (admin == null) {

                return "admin_panel";
            } else {

                if (images != null && images.length > 0) {

                    for (int i = 0; i < images.length; i++) {

                        if (images[i].getBytes().length > 0) {

                            imageByte[i] = images[i].getBytes();
                        }
                    }

                    featurePage.setCoverPhotos(imageByte);
                    featurePageProvider.updateCoverPhotosOfFeaturePage(featurePage);
                }
                return "admin_panel";
            }
        } catch (Exception e) {

            request.getSession().setAttribute("admin", null);
            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_about_us_slides_update")
    protected String doPost7(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "image") MultipartFile[] images) {

        try {

            Admin admin = (Admin) request.getSession().getAttribute("admin");
            FeaturePage featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            FeaturePageProvider featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            byte[][] imageByte = new byte[5][];

            if (admin == null) {

                return "admin_panel";
            } else {

                if (images != null && images.length > 0) {

                    for (int i = 0; i < images.length; i++) {

                        if (images[i].getBytes().length > 0) {

                            imageByte[i] = images[i].getBytes();
                        }
                    }

                    featurePage.setAboutUsPhotos(imageByte);
                    featurePageProvider.updateAboutUsPhotosOfFeaturePage(featurePage);
                }
                return "admin_panel";
            }
        } catch (Exception e) {

            request.getSession().setAttribute("admin", null);
            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_our_skills_background_update")
    protected String doPost8(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "image") MultipartFile image) {

        try {

            Admin admin = (Admin) request.getSession().getAttribute("admin");
            FeaturePage featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            FeaturePageProvider featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            byte[] imageByte;

            if (admin == null) {

                return "admin_panel";
            } else {

                if (image != null && image.getBytes().length > 0) {

                    imageByte = image.getBytes();

                    featurePage.setOurSkillsPhoto(imageByte);
                    featurePageProvider.updateOurSkillsPhotoOfFeaturePage(featurePage);
                }
                return "admin_panel";
            }
        } catch (Exception e) {

            request.getSession().setAttribute("admin", null);
            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_some_milestone_works_backgroud_update")
    protected String doPost9(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "image") MultipartFile image) {

        try {

            Admin admin = (Admin) request.getSession().getAttribute("admin");
            FeaturePage featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            FeaturePageProvider featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            byte[] imageByte;

            if (admin == null) {

                return "admin_panel";
            } else {

                if (image != null && image.getBytes().length > 0) {

                    imageByte = image.getBytes();

                    featurePage.setSomeMilestoneWorksPhoto(imageByte);
                    featurePageProvider.updateSomeMilestoneWorksPhotoOfFeaturePage(featurePage);
                }
                return "admin_panel";
            }
        } catch (Exception e) {

            request.getSession().setAttribute("admin", null);
            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_contacts_background_update")
    protected String doPost10(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "image") MultipartFile image) {

        try {

            Admin admin = (Admin) request.getSession().getAttribute("admin");
            FeaturePage featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            FeaturePageProvider featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            byte[] imageByte;

            if (admin == null) {

                return "admin_panel";
            } else {

                if (image != null && image.getBytes().length > 0) {

                    imageByte = image.getBytes();

                    featurePage.setContactUsPhoto(imageByte);
                    featurePageProvider.updateContactUsPhotoOfFeaturePage(featurePage);
                }
                return "admin_panel";
            }
        } catch (Exception e) {

            request.getSession().setAttribute("admin", null);
            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_starting_gif_update")
    protected String doPost11(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "image") MultipartFile image) {

        try {

            Admin admin = (Admin) request.getSession().getAttribute("admin");
            FeaturePage featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            FeaturePageProvider featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            byte[] imageByte;

            if (admin == null) {

                return "admin_panel";
            } else {

                if (image != null && image.getBytes().length > 0) {

                    imageByte = image.getBytes();

                    featurePage.setStartingGifAnimation(imageByte);
                    featurePageProvider.updateStartingGifAnimationOfFeaturePage(featurePage);
                }
                return "admin_panel";
            }
        } catch (Exception e) {

            request.getSession().setAttribute("admin", null);
            return "admin_panel";
        }
    }

    @RequestMapping(value = "admin_panel_some_milestone_works_counter_update")
    protected String doPost12(Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam Map<String, String> someMilestoneWorks) {

        try {

            Admin admin = (Admin) request.getSession().getAttribute("admin");
            FeaturePage featurePage = (FeaturePage) beanProvider.getBean("featurePage");
            FeaturePageProvider featurePageProvider = (FeaturePageProvider) beanProvider.getBean("featurePageProvider");
            Integer[] someMilestoneWork = new Integer[4];

            if (admin == null) {

                return "admin_panel";
            } else {

                if (someMilestoneWorks != null) {

                    someMilestoneWork[0] = Integer.parseInt(someMilestoneWorks.get("clients"));
                    someMilestoneWork[1] = Integer.parseInt(someMilestoneWorks.get("photos"));
                    someMilestoneWork[2] = Integer.parseInt(someMilestoneWorks.get("events"));
                    someMilestoneWork[3] = Integer.parseInt(someMilestoneWorks.get("subscribers"));

                    featurePage.setSomeMilestoneWorksCounter(someMilestoneWork);
                    featurePageProvider.updateSomeMilestoneWorksCounterOfFeaturePage(featurePage);
                }
                return "admin_panel";
            }
        } catch (Exception e) {

            request.getSession().setAttribute("admin", null);
            return "admin_panel";
        }
    }
}
