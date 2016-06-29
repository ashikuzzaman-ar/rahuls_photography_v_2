<%
    if (admin == null) {
        response.sendRedirect("index");
%>


<%} else{%>


<!--=========== BEGAIN TEAM SECTION ================-->
<section id="team">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12">
                <!-- BEGAIN ABOUT HEADING -->
                <div class="heading">
                    <h2 class="wow fadeInLeftBig">Current Team Members</h2>            
                </div>
                <div class="team_area">
                    <!-- BEGAIN TEAM SLIDER -->
                    <div class="team_slider">  

                        <% if (featurePage.getOurTeamMembers().size() == 0) { %>
                        <h1>No Team Member Is Present!</h1>
                        <h1>Please Add Team Members From Below</h1>

                        <%

                        } else if (featurePage.getOurTeamMembers().size() > 0) {

                            for (OurTeam ourTeam : featurePage.getOurTeamMembers()) {
                        %>

                        <!-- BEGAIN SINGLE TEAM SLIDE#1 -->              
                        <div class="col-lg-3 col-md-3 col-sm-4">
                            <div class="single_team wow fadeInUp">
                                <h5>Member ID: <%= ourTeam.getId()%></h5>
                                <div class="team_img">
                                    <img src="data:image/jpeg;base64,<%= encodedByteToString.getStringImage(ourTeam.getProfilePicture())%>" alt="img">
                                </div>
                                <h5 class=""><%= ourTeam.getName()%></h5>
                                <span><%= ourTeam.getPosition()%></span>                        
                                <p><%= ourTeam.getMessage()%></p>
                                <div class="team_social">
                                    <a href="<%= ourTeam.getSocialMediaLinks()[0]%>" target="_blank"><i class="fa fa-facebook"></i></a>
                                    <a href="<%= ourTeam.getSocialMediaLinks()[1]%>" target="_blank"><i class="fa fa-twitter"></i></a>
                                    <a href="<%= ourTeam.getSocialMediaLinks()[2]%>" target="_blank"><i class="fa fa-google-plus"></i></a>
                                    <a href="<%= ourTeam.getSocialMediaLinks()[3]%>" target="_blank"><i class="fa fa-linkedin"></i></a>
                                </div>
                            </div>
                        </div>
                        <%

                                }
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--=========== END TEAM SECTION ================-->

<!--Delete Team Member Start-->
<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12">
                <!-- START LOGIN HEADING -->
                <div class="heading">
                    <h2 class="wow fadeInLeftBig">Delete A Team Member</h2>
                </div>
            </div>
        </div>
        <div class="row">

            <div class="contact_content">

                <div class="col-lg-5 col-md-5 col-sm-5">
                    <div class="contact_form">

                        <div id="form-messages"></div>

                        <form action="team_members_remove" method="POST">
                            Enter Member ID To Remove<input class="form-control" type="number" name="member_id" placeholder="Member ID" >
                            <input class="submit_btn" type="reset" value="Refresh">
                            <input class="submit_btn" type="submit" value="Delete Member">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>             
</section>
<!--Delete Team Member End-->

<!--Add Team Member Start-->
<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12">
                <!-- START LOGIN HEADING -->
                <div class="heading">
                    <h2 class="wow fadeInLeftBig">Add a new Member</h2>
                </div>
            </div>
        </div>
        <div class="row">

            <div class="contact_content">

                <div class="col-lg-5 col-md-5 col-sm-5">
                    <div class="contact_form">

                        <div id="form-messages"></div>

                        <form action="team_members_add" enctype="multipart/form-data" method="POST">

                            Choose Profile Picture<input class="form-control" type="file" name="profilePicture" >
                            Choose Name<input class="form-control" type="text" name="name" placeholder="Full Name" >
                            Define Position<input class="form-control" type="text" name="position" placeholder="Position" >
                            Description Of This Member<textarea class="form-control" name="message" rows="4" cols="20"></textarea>
                            <div>
                                Facebook Link<input class="form-control" type="text" name="socialMediaLinks" placeholder="Facebook Profile" >
                                Twitter Link<input class="form-control" type="text" name="socialMediaLinks" placeholder="Twitter Profile" >
                                Google+ Link<input class="form-control" type="text" name="socialMediaLinks" placeholder="Google+ Profile" >
                                Linkedin Link<input class="form-control" type="text" name="socialMediaLinks" placeholder="Linkedin Profile" >
                            </div>
                            <input class="submit_btn" type="reset" value="Refresh">
                            <input class="submit_btn" type="submit" value="Add Member">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>             
</section>
<!--Add New Team Member End-->

<% }%>