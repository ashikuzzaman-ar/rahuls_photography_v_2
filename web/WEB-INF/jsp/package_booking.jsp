<!--Package Booking Start-->
<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12">
                <!-- START LOGIN HEADING -->
                <div class="heading">
                    <h2 class="wow fadeInLeftBig">Online Booking</h2>
                </div>
            </div>
        </div>
        <div class="row">

            <div class="contact_content">

                <div class="col-lg-6 col-md-6 col-sm-12 col-lg-offset-3 col-md-offset-3">
                    <div class="contact_form">

                        <p>You must complete all required field correctly. You must Bkash <strong>50%</strong> of Package price to <strong>+8801831076800</strong> before submitting this form. Your advanced payment will not be looted and a confirmation mail will be send to your provided mail.</p>
                        <div id="form-messages"></div>


                        <form action="package_booking_submit" method="POST">
                            <label>Package Name</label>
                            <input class="form-control" type="text" name="packageName" value="${packageName}" disabled="true" >


                            <label>Package Price</label>
                            <input class="form-control" type="text" name="packagePrice" value="${packagePrice}" disabled="true" >


                            <input type="hidden" name="packageId" value="${packageId}"/>


                            <label>Client Name</label>
                            <input required="true" class="form-control" type="text" name="clientName" placeholder="Enter Your Name">


                            <label>Phone Number</label>
                            <input required="true" class="form-control" type="text" name="clientPhoneNumber" placeholder="Enter Your Phoen Number">


                            <label>Email ID [Confirmation Mail Will be Send Here]</label>
                            <input required="true" class="form-control" type="email" name="clientEmail" placeholder="Enter Your Email ID">


                            <label>Your BKash Number [From where you advanced]</label>
                            <input required="true" class="form-control" type="text" name="clientBkshNumber" placeholder="BKash Number">


                            <label>BKash Transaction Number</label>
                            <input required="true" class="form-control" type="text" name="transactionNumber" placeholder="BKash Transaction Number">


                            <label>Advanced Amount [Must be 50% of Package Price]</label>
                            <input required="true" class="form-control" type="number" name="advancedAmount" min="${packagePrice/2}" placeholder="Advanced Amount">


                            <label>Event Venue</label>
                            <textarea required="true" class="form-control" name="eventVenue" placeholder="Enter your Event Venue" rows="4" cols="20"></textarea>


                            <labe>Choose Event Date</labe>
                            <input id="datepicker" required="true" class="form-control" type="date" name="eventDate" placeholder="Click Here To Choose Date" />

                            <input class="btn btn-lg btn-info" type="reset" value="Reset">
                            <input class="submit_btn" type="submit" value="Submit Your Form">  
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>             
</section>
<!--Package Booking End-->




<section class="about_area">
    <div>
        <br/>
        <form>

        </form>
        <br/>
    </div>
</section>