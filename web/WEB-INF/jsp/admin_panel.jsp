<sec:authorize access="isAuthenticated()">

    <!--Control Panel Heading-->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <!-- START LOGIN HEADING -->
                    <div class="heading">
                        <h2 class="wow fadeInLeftBig">Welcome to Control Panel</h2>
                        <br/>
                        <!--Add username here-->
                        Username : <%=request.getAttribute("username")%>
                        <br>
                        <a class="btn btn-lg btn-danger" href="logout">Log Out</a>
                        <p>As admin authority , you can change each content of your site. Insert, Edit or Delete whatever you want!</p>
                    </div>
                </div>
            </div>       
        </div>             
    </section>
    <!--End Control Panel Heading-->



    <!--Change Password Start-->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <!-- START LOGIN HEADING -->
                    <div class="heading">
                        <h2 class="wow fadeInLeftBig">Change Your Password</h2>
                    </div>
                </div>
            </div>
            <div class="row">

                <div class="contact_content">

                    <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                        <div class="contact_form">

                            <div id="form-messages"></div>

                            <form action="admin_panel_change_password" method="POST">
                                <input required="true" class="form-control" type="password" name="password" placeholder="New Password" >
                                <input class="btn btn-lg btn-info" type="reset" value="Reset">  
                                <input class="submit_btn" type="submit" value="Update Password">  
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>             
    </section>
    <!--Change Password End-->




    <!--Upload New Photos Start-->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <!-- START LOGIN HEADING -->
                    <div class="heading">
                        <h2 class="wow fadeInLeftBig">Upload New Photos</h2>
                    </div>
                </div>
            </div>
            <div class="row">

                <div class="contact_content">

                    <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                        <div class="contact_form">

                            <div id="form-messages"></div>

                            <form action="admin_panel_upload_new_photos" enctype="multipart/form-data" method="POST">
                                <div class="form-control-static">
                                    Image-1<input class="form-control" type="file" name="image" >
                                    <select class="form-control" name="category">
                                        <option>Wedding</option>
                                        <option>Fashion</option>
                                        <option>Card</option>
                                        <option>Product</option>
                                    </select>
                                </div>
                                <div class="form-control-static">
                                    Image-2<input class="form-control" type="file" name="image" >
                                    <select class="form-control" name="category">
                                        <option>Wedding</option>
                                        <option>Fashion</option>
                                        <option>Card</option>
                                        <option>Product</option>
                                    </select>
                                </div>
                                <div class="form-control-static">
                                    Image-3<input class="form-control" type="file" name="image" >
                                    <select class="form-control" name="category">
                                        <option>Wedding</option>
                                        <option>Fashion</option>
                                        <option>Card</option>
                                        <option>Product</option>
                                    </select>
                                </div>
                                <div class="form-control-static">
                                    Image-4<input class="form-control" type="file" name="image" >
                                    <select class="form-control" name="category">
                                        <option>Wedding</option>
                                        <option>Fashion</option>
                                        <option>Card</option>
                                        <option>Product</option>
                                    </select>
                                </div>
                                <div class="form-control-static">
                                    Image-5<input class="form-control" type="file" name="image" >
                                    <select class="form-control" name="category">
                                        <option>Wedding</option>
                                        <option>Fashion</option>
                                        <option>Card</option>
                                        <option>Product</option>
                                    </select>
                                </div>

                                <input class="btn btn-lg btn-info" type="reset" value="Reset">  
                                <input class="submit_btn" type="submit" value="Upload">  
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>             
    </section>
    <!--Upload New Photos End-->


    <!--Delete Photos Start-->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <!-- START LOGIN HEADING -->
                    <div class="heading">
                        <h2 class="wow fadeInLeftBig">Delete Photos</h2>
                    </div>
                </div>
            </div>
            <div class="row">

                <div class="contact_content">

                    <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                        <div class="contact_form">

                            <div id="form-messages"></div>

                            <form action="admin_panel_delete_photo" enctype="multipart/form-data" method="POST">
                                <input required="true" class="form-control" type="number" name="photoID" placeholder="Photo ID">
                                <input class="btn btn-lg btn-info" type="reset" value="Reset">
                                <input class="submit_btn" type="submit" value="Delete Photo">  
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>             
    </section>
    <!--Delete Photos End-->



    <!--Starting GIF Update Start-->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <!-- START LOGIN HEADING -->
                    <div class="heading">
                        <h2 class="wow fadeInLeftBig">Update Starting GIF [Must Be GIF Image]</h2>
                    </div>
                </div>
            </div>
            <div class="row">

                <div class="contact_content">

                    <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                        <div class="contact_form">

                            <div id="form-messages"></div>

                            <form action="admin_panel_starting_gif_update" enctype="multipart/form-data" method="POST">
                                Background Image<input class="form-control" type="file" name="image" >
                                <input class="btn btn-lg btn-info" type="reset" value="Reset">  
                                <input class="submit_btn" type="submit" value="Update">  
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>             
    </section>
    <!--Starting GIF Update End-->



    <!--Background Slide Update Start-->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <!-- START LOGIN HEADING -->
                    <div class="heading">
                        <h2 class="wow fadeInLeftBig">Update Sliding Background</h2>
                    </div>
                </div>
            </div>
            <div class="row">

                <div class="contact_content">

                    <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                        <div class="contact_form">

                            <div id="form-messages"></div>

                            <form action="admin_panel_background_slide_update" enctype="multipart/form-data" method="POST">
                                Slide-1<input class="form-control" type="file" name="image" >
                                Slide-2<input class="form-control" type="file" name="image" >
                                Slide-3<input class="form-control" type="file" name="image" >
                                <input class="btn btn-lg btn-info" type="reset" value="Reset">  
                                <input class="submit_btn" type="submit" value="Update">  
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>             
    </section>
    <!--Background Slide Update End-->


    <!--About Us Slide Update Start-->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <!-- START LOGIN HEADING -->
                    <div class="heading">
                        <h2 class="wow fadeInLeftBig">Update About Us Slides</h2>
                    </div>
                </div>
            </div>
            <div class="row">

                <div class="contact_content">

                    <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                        <div class="contact_form">

                            <div id="form-messages"></div>

                            <form action="admin_panel_about_us_slides_update" enctype="multipart/form-data" method="POST">
                                Slide-1<input class="form-control" type="file" name="image" >
                                Slide-2<input class="form-control" type="file" name="image" >
                                Slide-3<input class="form-control" type="file" name="image" >
                                Slide-4<input class="form-control" type="file" name="image" >
                                Slide-5<input class="form-control" type="file" name="image" >
                                <input class="btn btn-lg btn-info" type="reset" value="Reset">  
                                <input class="submit_btn" type="submit" value="Update">  
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>             
    </section>
    <!--About Us Slide Update End-->



    <!--Our Skills Background Update Start-->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <!-- START LOGIN HEADING -->
                    <div class="heading">
                        <h2 class="wow fadeInLeftBig">Update Our Skills Background</h2>
                    </div>
                </div>
            </div>
            <div class="row">

                <div class="contact_content">

                    <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                        <div class="contact_form">

                            <div id="form-messages"></div>

                            <form action="admin_panel_our_skills_background_update" enctype="multipart/form-data" method="POST">
                                Background Image<input class="form-control" type="file" name="image" >
                                <input class="btn btn-lg btn-info" type="reset" value="Reset">  
                                <input class="submit_btn" type="submit" value="Update">  
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>             
    </section>
    <!--Our Skills Background Update End-->



    <!--Some Milestone Works Counter Update Start-->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <!-- START LOGIN HEADING -->
                    <div class="heading">
                        <h2 class="wow fadeInLeftBig">Update Some Milestone Works</h2>
                    </div>
                </div>
            </div>
            <div class="row">

                <div class="contact_content">

                    <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                        <div class="contact_form">

                            <div id="form-messages"></div>

                            <form action="admin_panel_some_milestone_works_counter_update" method="POST">
                                Number of Clients<input class="form-control" type="number" name="clients" >
                                Number of Photos<input class="form-control" type="number" name="photos" >
                                Number of Events<input class="form-control" type="number" name="events" >
                                Number of Subscribers<input class="form-control" type="number" name="subscribers" >
                                <input class="btn btn-lg btn-info" type="reset" value="Reset">  
                                <input class="submit_btn" type="submit" value="Update">  
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>             
    </section>
    <!--Some Milestone Works Counter Update End-->




    <!--Some Milestone Works Background Update Start-->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <!-- START LOGIN HEADING -->
                    <div class="heading">
                        <h2 class="wow fadeInLeftBig">Update Some Milestone Works Background</h2>
                    </div>
                </div>
            </div>
            <div class="row">

                <div class="contact_content">

                    <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                        <div class="contact_form">

                            <div id="form-messages"></div>

                            <form action="admin_panel_some_milestone_works_backgroud_update" enctype="multipart/form-data" method="POST">
                                Background Image<input class="form-control" type="file" name="image" >
                                <input class="btn btn-lg btn-info" type="reset" value="Reset">  
                                <input class="submit_btn" type="submit" value="Update">  
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>             
    </section>
    <!--Some Milestone Works Background Update End-->




    <!--Team Member Update Start-->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <!-- START LOGIN HEADING -->
                    <div class="heading">
                        <h2 class="wow fadeInLeftBig">Update Team Member</h2>
                    </div>
                </div>
            </div>
            <div class="row">

                <div class="contact_content">

                    <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                        <div class="contact_form">

                            <div id="form-messages"></div>

                            <form action="team_members" method="POST">
                                <input class="submit_btn" name="button" type="submit" value="Edit team member">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>             
    </section>
    <!--Team Member Update End-->




    <!--Packages Update Start-->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <!-- START LOGIN HEADING -->
                    <div class="heading">
                        <h2 class="wow fadeInLeftBig">Update Packages</h2>
                    </div>
                </div>
            </div>
            <div class="row">

                <div class="contact_content">

                    <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                        <div class="contact_form">

                            <div id="form-messages"></div>

                            <form action="packages" method="POST">
                                <input class="submit_btn" type="submit" value="Edit package">  
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>             
    </section>
    <!--Packages Update End-->




    <!--Contacts Background Update Start-->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <!-- START LOGIN HEADING -->
                    <div class="heading">
                        <h2 class="wow fadeInLeftBig">Update Contacts Background</h2>
                    </div>
                </div>
            </div>
            <div class="row">

                <div class="contact_content">

                    <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                        <div class="contact_form">

                            <div id="form-messages"></div>

                            <form action="admin_panel_contacts_background_update" enctype="multipart/form-data" method="POST">
                                Background Image<input class="form-control" type="file" name="image" >
                                <input class="btn btn-lg btn-info" type="reset" value="Reset">  
                                <input class="submit_btn" type="submit" value="Update">  
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>             
    </section>
    <!--Contacts Background Update End-->




</sec:authorize>
