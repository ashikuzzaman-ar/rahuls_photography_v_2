<%@page import="com.studevs.mvc.models.Admin"%>
<%
    Admin admin = (Admin) request.getSession().getAttribute("admin");
%>


<% if (admin != null) {%>

<!--Control Panel Heading-->
<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12">
                <!-- START LOGIN HEADING -->
                <div class="heading">
                    <h2 class="wow fadeInLeftBig">Welcome to Control Panel</h2>
                    <br/>
                    <p>Username: <%= admin.getUsername()%></p>
                    <a class="btn btn-lg btn-danger" href="admin_panel_logged_out">Log Out</a>
                    <p>As admin power you can change each content of your site. Insert, Edit or Delete whatever you want!</p>
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

                <div class="col-lg-5 col-md-5 col-sm-5">
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

                <div class="col-lg-5 col-md-5 col-sm-5">
                    <div class="contact_form">

                        <div id="form-messages"></div>

                        <form action="admin_panel_logged_in" enctype="multipart/form-data" method="POST">
                            Slide-1<input class="form-control" type="file" name="image" >
                            Slide-2<input class="form-control" type="file" name="image" >
                            Slide-3<input class="form-control" type="file" name="image" >
                            Slide-4<input class="form-control" type="file" name="image" >
                            Slide-5<input class="form-control" type="file" name="image" >
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

                <div class="col-lg-5 col-md-5 col-sm-5">
                    <div class="contact_form">

                        <div id="form-messages"></div>

                        <form action="admin_panel_logged_in" enctype="multipart/form-data" method="POST">
                            <input class="form-control" type="number" name="photoID" placeholder="Photo ID">
                            <input class="btn btn-lg btn-info" type="reset" value="Reset">
                            <input class="submit_btn" type="submit" value="Delete Photos">  
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>             
</section>
<!--Delete Photos End-->



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

                <div class="col-lg-5 col-md-5 col-sm-5">
                    <div class="contact_form">

                        <div id="form-messages"></div>

                        <form action="admin_panel_logged_in" enctype="multipart/form-data" method="POST">
                            Slide-1<input class="form-control" type="file" name="image1" >
                            Slide-2<input class="form-control" type="file" name="image2" >
                            Slide-3<input class="form-control" type="file" name="image3" >
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

                <div class="col-lg-5 col-md-5 col-sm-5">
                    <div class="contact_form">

                        <div id="form-messages"></div>

                        <form action="admin_panel_logged_in" enctype="multipart/form-data" method="POST">
                            Slide-1<input class="form-control" type="file" name="image1" >
                            Slide-2<input class="form-control" type="file" name="image2" >
                            Slide-3<input class="form-control" type="file" name="image3" >
                            Slide-4<input class="form-control" type="file" name="image4" >
                            Slide-5<input class="form-control" type="file" name="image5" >
                            Slide-6<input class="form-control" type="file" name="image6" >
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

                <div class="col-lg-5 col-md-5 col-sm-5">
                    <div class="contact_form">

                        <div id="form-messages"></div>

                        <form action="admin_panel_logged_in" enctype="multipart/form-data" method="POST">
                            Background Image<input class="form-control" type="file" name="image1" >
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

                <div class="col-lg-5 col-md-5 col-sm-5">
                    <div class="contact_form">

                        <div id="form-messages"></div>

                        <form action="admin_panel_logged_in" enctype="multipart/form-data" method="POST">
                            Background Image<input class="form-control" type="file" name="image1" >
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

                <div class="col-lg-5 col-md-5 col-sm-5">
                    <div class="contact_form">

                        <div id="form-messages"></div>

                        <form action="admin_panel_logged_in" enctype="multipart/form-data" method="POST">
                            <input class="submit_btn" type="submit" value="Add a team member">
                            <br/>
                            <input class="submit_btn" type="submit" value="Update a team member">
                            <br/>
                            <input class="submit_btn" type="submit" value="Delete a team member">  
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

                <div class="col-lg-5 col-md-5 col-sm-5">
                    <div class="contact_form">

                        <div id="form-messages"></div>

                        <form action="admin_panel_logged_in" enctype="multipart/form-data" method="POST">
                            <input class="submit_btn" type="submit" value="Add a package">
                            <br/>
                            <input class="submit_btn" type="submit" value="Update a package"> 
                            <br/>
                            <input class="submit_btn" type="submit" value="Delete a package">  
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

                <div class="col-lg-5 col-md-5 col-sm-5">
                    <div class="contact_form">

                        <div id="form-messages"></div>

                        <form action="admin_panel_logged_in" enctype="multipart/form-data" method="POST">
                            Background Image<input class="form-control" type="file" name="image1" >
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




<% } else {%>

<!--This Part is Done--> 
<!--=========== BEGAIN ADMIN LOGIN SECTION ================-->
<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12">
                <!-- START LOGIN HEADING -->
                <div class="heading">
                    <h2 class="wow fadeInLeftBig">Control Panel Authentication</h2>
                    <p>This page is not for general users. If you are an admin then please enter your username and password for accessing authentication of this site.</p>
                </div>
            </div>
        </div>       
        <div class="row">
            <!-- BEGAIN LOGIN CONTENT -->
            <div class="contact_content">
                <!-- BEGAIN LOGIN FORM -->
                <div class="col-lg-5 col-md-5 col-sm-5">
                    <div class="contact_form">

                        <!-- FOR LOGIN FORM MESSAGE -->
                        <div id="form-messages"></div>

                        <!--here starts the main part of login from-->
                        <form action="admin_panel_logged_in" method="POST">
                            <input required="true" class="form-control" type="text" name="username" placeholder="Username">
                            <input required="true" class="form-control" type="password" name="password" placeholder="Password">
                            <input class="btn btn-lg btn-info" type="reset" value="Reset">  
                            <input class="submit_btn" type="submit" value="Login">  
                        </form>
                    </div>
                </div>
            </div>
        </div>      
    </div>             
</section>
<!--=========== END ADMIN LOGIN SECTION ================-->


<% }%>