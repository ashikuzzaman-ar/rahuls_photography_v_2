<!--=========== BEGAIN GALLERY SECTION ================-->
<section id="about" class="gal-im-single">
    <div class="container">
        <div class="row">

            <% if (galleryImageses.size() > 0) {%>

            <div class="col-lg-12 col-md-12">
                <div class="about_area">
                    <!-- START ABOUT HEADING -->
                    <div class="heading">
                        <h2 class="wow fadeInLeftBig">Welcome to Photo Gallery</h2>
                        <p>There have many sample works done by us. Here is a small parts of our working sample or demo. You can visit full gallery to see more of our astonishing works.<br/><strong>Click on a photo to see in full HD quality.</strong></p>
                    </div>

                    <!-- START ABOUT CONTENT -->
                    <div class="about_content">
                        <div class="row">
                            <!--style="height: 20px"-->
                            <% for (GalleryImages gi : galleryImageses) {%>

                            <div class="col-lg-4 col-md-4 col-sm-12">
                                <div class="">
                                    <div class="featured_slider">
                                        <div class="single_iteam">
                                            <a class="" href="<%= gi.getId()%>" target="_blank">
                                                <img class="img-responsive img-thumbnail gal-im-margin" src="data:<%= gi.getImageFormat()%>;base64,<%= encodedByteToString.getStringImage(gi.getImage())%>" alt="img">
                                            </a>                           
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
            <div class="col-lg-12 col-md-12">
                <div class="row">
                    <div class="col-lg-4 col-md-4 col-sm-12 col-lg-offset-4 col-md-offset-4">
                        <form action="gallery" method="POST">
                            <table border="0">
                                <tr>
                                    <td>
                                        <input size="6" class="form-control" type="text" name="initialValue" value="${initialValue}">
                                    </td>
                                    <td align="center">
                                        -----
                                    </td>
                                    <td>
                                        <input size="6" class="form-control" type="text" name="terminalValue" value="${terminalValue}">
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td>
                                        <input class="submit_btn" type="submit" name="next" value="Load More">  
                                    </td>
                                    <td></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>

            <% } else { %>

            <div class="col-lg-12 col-md-12">
                <div class="about_area">
                    <div class="heading">
                        <h2 class="wow fadeInLeftBig">No Photo In Gallery To Display!</h2>
                    </div>
                    <div class="about_content">
                        <div class="row">
                            <div class="col-lg-4 col-md-4 col-sm-12 col-lg-offset-4 col-md-offset-4">
                                <div class="">
                                    <div class="featured_slider">
                                        <div class="single_iteam">
                                            <a class="btn submit_btn" href="gallery">Try To Refresh?</a>                           
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <% }%>
        </div>       
    </div>
</section>
<!--=========== END GALLERY SECTION ================-->