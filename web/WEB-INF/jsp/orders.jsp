<%
    if (admin == null) {
        response.sendRedirect("index");
%>


<%} else {%>

<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                <!-- START LOGIN HEADING -->
                <div class="heading">
                    <h2 class="wow fadeInLeftBig">------</h2>
                    <p><a class="btn btn-primary btn-lg" href="orders">Refresh List</a></p>
                    <h2 class="wow fadeInLeftBig">------</h2>
                </div>
            </div>
        </div>
    </div>
</section>

<!--Orders Start-->
<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12">
                <!-- START LOGIN HEADING -->
                <div class="heading">
                    <h2 class="wow fadeInLeftBig">Order Booking Information</h2>
                </div>
            </div>
        </div>
        <div class="row">

            <div class="contact_content">

                <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                    <div class="contact_form">

                        <% if (currentOrderList != null && currentOrderList.size() > 0) { %>

                        <p></p>
                        <div id="form-messages"><h4>Current Orders:</h4></div>
                        <table class="table table-hover table-responsive table-striped table-bordered">
                            <% for (Orders orders : currentOrderList) {%>
                            <tr>
                                <td>
                                    <div title="Click to see full record" class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                            <span class="" aria-hidden="true">
                                                <strong>ID: <%= orders.getId()%> | Name: <%= orders.getClientName()%> | Email: <%= orders.getClientEmail()%> | Phone: <%= orders.getClientPhoneNumber()%></strong>
                                            </span>
                                        </a>
                                        <div class="dropdown-menu">
                                            <form class="navbar-form navbar-left" action="orders_update" method="POST">
                                                <div class="form-group form-group-lg">
                                                    <table class="table table-hover table-responsive">
                                                        <tr>
                                                            <td>Order ID</td>

                                                            <td>
                                                                <%= orders.getId()%>
                                                                <input type="hidden" name="id" value="<%= orders.getId()%>"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Client Name</td>
                                                            <td>
                                                                <%= orders.getClientName()%>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Package Name</td>
                                                            <td>
                                                                <%= orders.getOurPackages().getPackageName()%>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Package Price</td>
                                                            <td>
                                                                <%= orders.getOurPackages().getPackagePrice()%>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Client Phone Number</td>
                                                            <td>
                                                                <%= orders.getClientPhoneNumber()%>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Client Email Address</td>
                                                            <td>
                                                                <%= orders.getClientEmail()%>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Client BKash Number</td>
                                                            <td>
                                                                <%= orders.getClientBkshNumber()%>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>BKash Transaction Number</td>
                                                            <td>
                                                                <%= orders.getTransactionNumber()%>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Advanced Amount</td>
                                                            <td>
                                                                <input type="number" name="advancedAmount" value="<%= orders.getAdvancedAmount()%>"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Event Venue</td>
                                                            <td>
                                                                <textarea name="eventVenue" rows="4" cols="20"><%= orders.getEventVenue()%></textarea>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Event Date</td>
                                                            <td>
                                                                <input type="date" name="eventDate" onclick="$(document).ready(function () {
                                                                            $(document.getElementsByName('eventDate')).datepicker();
                                                                        });"  value="<%= orders.getEventDate()%>"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Delivery Date</td>
                                                            <td>
                                                                <input type="date" name="deliveryDate" onclick="$(document).ready(function () {
                                                                            $(document.getElementsByName('deliveryDate')).datepicker();
                                                                        });" value="<%= orders.getDeliveryDate()%>"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Full Paid</td>
                                                            <% if (orders.getIsFullPaid()) { %>
                                                            <td>
                                                                <input type="checkbox" name="isFullPaid" checked="true" />
                                                            </td>
                                                            <% } else { %>
                                                            <td>
                                                                <input type="checkbox" name="isFullPaid" />
                                                            </td>
                                                            <% } %>
                                                        </tr>
                                                        <tr>
                                                            <td>Appointed</td>
                                                            <% if (orders.getIsAppointed()) { %>
                                                            <td>
                                                                <input type="checkbox" name="isAppointed" checked="true" />
                                                            </td>
                                                            <% } else { %>
                                                            <td>
                                                                <input type="checkbox" name="isAppointed" />
                                                            </td>
                                                            <% } %>
                                                        </tr>
                                                        <tr>
                                                            <td>Delivered</td>
                                                            <% if (orders.getIsdelivered()) { %>
                                                            <td>
                                                                <input type="checkbox" name="isdelivered" checked="true" />
                                                            </td>
                                                            <% } else { %>
                                                            <td>
                                                                <input type="checkbox" name="isdelivered" />
                                                            </td>
                                                            <% } %>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <br/>
                                                <div>
                                                    <input type="submit" class="btn btn-primary" name="button" value="Update" />
                                                    <input type="submit" class="btn btn-primary" name="button" value="Update And Send Mail" />
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                        <%
                        } else {
                        %>

                        <p>No Order Available!</p>

                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </div>             
</section>
<!--Orders End-->



<!--Delivered Orders Start-->
<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12">
                <!-- START LOGIN HEADING -->
                <div class="heading">
                    <h2 class="wow fadeInLeftBig">Delivered Order Information</h2>
                </div>
            </div>
        </div>
        <div class="row">

            <div class="contact_content">

                <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                    <div class="contact_form">

                        <% if (deliveredOrderList != null && deliveredOrderList.size() > 0) { %>

                        <p></p>
                        <div id="form-messages"><h4>Delivered Orders:</h4></div>
                        <table class="table table-hover table-responsive table-striped table-bordered">
                            <% for (Orders orders : deliveredOrderList) {%>
                            <tr>
                                <td>
                                    <div title="Click to see full record" class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                            <span class="" aria-hidden="true">
                                                <strong>ID: <%= orders.getId()%> | Name: <%= orders.getClientName()%> | Email: <%= orders.getClientEmail()%> | Phone: <%= orders.getClientPhoneNumber()%></strong>
                                            </span>
                                        </a>
                                        <div class="dropdown-menu">
                                            <form class="navbar-form navbar-left" action="orders_update" method="POST">
                                                <div class="form-group form-group-lg">
                                                    <table class="table table-hover table-responsive">
                                                        <tr>
                                                            <td>Order ID</td>

                                                            <td>
                                                                <%= orders.getId()%>
                                                                <input type="hidden" name="id" value="<%= orders.getId()%>"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Client Name</td>
                                                            <td>
                                                                <%= orders.getClientName()%>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Package Name</td>
                                                            <td>
                                                                <%= orders.getOurPackages().getPackageName()%>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Package Price</td>
                                                            <td>
                                                                <%= orders.getOurPackages().getPackagePrice()%>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Client Phone Number</td>
                                                            <td>
                                                                <%= orders.getClientPhoneNumber()%>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Client Email Address</td>
                                                            <td>
                                                                <%= orders.getClientEmail()%>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Client BKash Number</td>
                                                            <td>
                                                                <%= orders.getClientBkshNumber()%>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>BKash Transaction Number</td>
                                                            <td>
                                                                <%= orders.getTransactionNumber()%>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Advanced Amount</td>
                                                            <td>
                                                                <input type="number" name="advancedAmount" value="<%= orders.getAdvancedAmount()%>"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Event Venue</td>
                                                            <td>
                                                                <textarea name="eventVenue" rows="4" cols="20"><%= orders.getEventVenue()%></textarea>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Event Date</td>
                                                            <td>
                                                                <input type="date" name="eventDate" onclick="$(document).ready(function () {
                                                                            $(document.getElementsByName('eventDate')).datepicker();
                                                                        });"  value="<%= orders.getEventDate()%>"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Delivery Date</td>
                                                            <td>
                                                                <input type="date" name="deliveryDate" onclick="$(document).ready(function () {
                                                                            $(document.getElementsByName('deliveryDate')).datepicker();
                                                                        });" value="<%= orders.getDeliveryDate()%>"/>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Full Paid</td>
                                                            <% if (orders.getIsFullPaid()) { %>
                                                            <td>
                                                                <input type="checkbox" name="isFullPaid" checked="true" />
                                                            </td>
                                                            <% } else { %>
                                                            <td>
                                                                <input type="checkbox" name="isFullPaid" />
                                                            </td>
                                                            <% } %>
                                                        </tr>
                                                        <tr>
                                                            <td>Appointed</td>
                                                            <% if (orders.getIsAppointed()) { %>
                                                            <td>
                                                                <input type="checkbox" name="isAppointed" checked="true" />
                                                            </td>
                                                            <% } else { %>
                                                            <td>
                                                                <input type="checkbox" name="isAppointed" />
                                                            </td>
                                                            <% } %>
                                                        </tr>
                                                        <tr>
                                                            <td>Delivered</td>
                                                            <% if (orders.getIsdelivered()) { %>
                                                            <td>
                                                                <input type="checkbox" name="isdelivered" checked="true" />
                                                            </td>
                                                            <% } else { %>
                                                            <td>
                                                                <input type="checkbox" name="isdelivered" />
                                                            </td>
                                                            <% } %>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <br/>
                                                <div>
                                                    <input type="submit" class="btn btn-primary" name="button" value="Update" />
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </table>
                        <%
                        } else {
                        %>

                        <p>No Order Delivered Yet!</p>

                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </div>             
</section>
<!--Delivered Orders End-->

<% }%>