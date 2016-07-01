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
                <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                    <div class="contact_form">

                        <!-- FOR LOGIN FORM MESSAGE -->
                        <div id="form-messages">
                            <%if (request.getParameter("error") == null) {%>
                            Enter Username and Password If you are an admin
                            <%}%>
                            <%if (request.getParameter("error") != null) {%>
                            Wrong Credentials..Please try again
                            <%}%>
                        </div>

                        <!--here starts the main part of login from-->
                        <form action="login" method="POST">
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

