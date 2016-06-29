<%
    if (admin == null) {
        response.sendRedirect("index");
%>


<%} else{%>

<!--=========== BEGAIN PRICING SECTION ================-->
<section id="pricing">
    <div class="container">
        <div class="row col-lg-12 col-md-12">
            <!-- START ABOUT HEADING -->
            <div class="heading">
                <h2 class="wow fadeInLeftBig">Our Packages</h2>
            </div>
        </div>
        <div class="row col-lg-12 col-md-12">
            <div class="pricing_area">
                <div class="row">

                    <% if (featurePage.getOurPackages().size() == 0) { %>
                    <h1>No Package Is Present!</h1>
                    <h1>Please Add Packages From Below</h1>

                    <%

                    } else if (featurePage.getOurPackages().size() > 0) {

                        for (OurPackages ourPackages : featurePage.getOurPackages()) {
                    %>
                    <div class="col-lg-3 col-md-3 col-sm-3">
                        <div class="single_price wow fadeInUp">
                            <h3>Package ID:<%= ourPackages.getId()%></h3>
                            <h3><%= ourPackages.getPackageName()%></h3>
                            <div class="price">
                                <h4><%= ourPackages.getPackagePrice()%> BDT</h4>
                                <span>per event</span>
                            </div>
                            <ul class="price_features">

                                <% for (String feature : ourPackages.getFeatureList()) {%>

                                <li><%= feature%></li>

                                <% } %>
                            </ul>
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
</section>
<!--=========== END PRICING SECTION ================-->

<!--Delete Team Member Start-->
<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12">
                <!-- START LOGIN HEADING -->
                <div class="heading">
                    <h2 class="wow fadeInLeftBig">Delete A Package</h2>
                </div>
            </div>
        </div>
        <div class="row">

            <div class="contact_content">

                <div class="col-lg-5 col-md-5 col-sm-5">
                    <div class="contact_form">

                        <div id="form-messages"></div>

                        <form action="packages_remove" method="POST">
                            Enter Package ID To Remove<input class="form-control" type="number" name="package_id" placeholder="Package ID" >
                            <input class="submit_btn" type="reset" value="Refresh">
                            <input class="submit_btn" type="submit" value="Delete Package">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>             
</section>
<!--Delete Team Member End-->

<!--Add Packages Start-->
<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12">
                <!-- START LOGIN HEADING -->
                <div class="heading">
                    <h2 class="wow fadeInLeftBig">Add a new Package</h2>
                </div>
            </div>
        </div>
        <div class="row">

            <div class="contact_content">

                <div class="col-lg-5 col-md-5 col-sm-5">
                    <div class="contact_form">

                        <div id="form-messages"></div>

                        <form action="packages_add" method="POST">

                            Choose Name<input class="form-control" type="text" name="packageName" placeholder="Package Name" >
                            Package Price<input class="form-control" type="number" name="packagePrice" placeholder="Package Price" >
                            <br/>
                            <br/>
                            <br/>
                            <div>
                                Enter Package Features
                                <ul>
                                    <li>
                                        <input class="form-control" type="text" name="featureList" placeholder="Feature" >
                                    </li>
                                    <li>
                                        <input class="form-control" type="text" name="featureList" placeholder="Feature" >
                                    </li>
                                    <li>
                                        <input class="form-control" type="text" name="featureList" placeholder="Feature" >
                                    </li>
                                    <li>
                                        <input class="form-control" type="text" name="featureList" placeholder="Feature" >
                                    </li>
                                    <li>
                                        <input class="form-control" type="text" name="featureList" placeholder="Feature" >
                                    </li>
                                    <li>
                                        <input class="form-control" type="text" name="featureList" placeholder="Feature" >
                                    </li>
                                    <li>
                                        <input class="form-control" type="text" name="featureList" placeholder="Feature" >
                                    </li>
                                    <li>
                                        <input class="form-control" type="text" name="featureList" placeholder="Feature" >
                                    </li>
                                    <li>
                                        <input class="form-control" type="text" name="featureList" placeholder="Feature" >
                                    </li>
                                    <li>
                                        <input class="form-control" type="text" name="featureList" placeholder="Feature" >
                                    </li>
                                    <li>
                                        <input class="form-control" type="text" name="featureList" placeholder="Feature" >
                                    </li>
                                    <li>
                                        <input class="form-control" type="text" name="featureList" placeholder="Feature" >
                                    </li>
                                    <li>
                                        <input class="form-control" type="text" name="featureList" placeholder="Feature" >
                                    </li>
                                    <li>
                                        <input class="form-control" type="text" name="featureList" placeholder="Feature" >
                                    </li>
                                    <li>
                                        <input class="form-control" type="text" name="featureList" placeholder="Feature" >
                                    </li>
                                </ul>
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
<!--Add Packages End-->


<% }%>