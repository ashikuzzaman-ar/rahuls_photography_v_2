<!--=========== BEGAIN GALLERY SECTION ================-->
<section id="about">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12">
                <div class="about_area">
                    <!-- START ABOUT HEADING -->
                    <div class="heading">
                        <h2 class="wow fadeInLeftBig">Welcome to Photo Gallery</h2>
                        <p>There have many sample works done by us. Here is a small parts of our working sample or demo. You can visit full gallery to see more of our astonishing works.</p>
                    </div>

                    <!-- START ABOUT CONTENT -->
                    <div class="about_content">
                        <div class="row">

                            <% for (GalleryImages gi : galleryImageses) {%>

                            <div class="col-lg-4 col-md-4 col-sm-12">
                                <div class="">
                                    <div class="featured_slider">
                                        <div class="single_iteam">
                                            <a href="<%= gi.getId()%>"> <img src="data:<%= gi.getImageFormat()%>;base64,<%= encodedByteToString.getStringImage(gi.getImage())%>" alt="img"></a>                           
                                        </div>
                                    </div>
                                    <!-- END FEATURED SLIDER -->
                                </div>
                            </div>

                            <% }%>
                        </div>
                    </div>
                </div>
            </div>
        </div>       
    </div>
</section>
<!--=========== END GALLERY SECTION ================-->