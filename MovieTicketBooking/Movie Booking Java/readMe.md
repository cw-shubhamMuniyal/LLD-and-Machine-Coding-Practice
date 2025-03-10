## Requirements:
Implement a Movie Ticket Booking Application for a Theatre. Refer to the following details:
* A Theatre has Screens that run Shows for different Movies. Each Show has a particular Movie, start time, duration, and is played in a particular Screen in the theatre. Each Screen has an arrangement of Seats that can be booked by Users.
* Assume all Users are registered, authenticated, and logged in to the Application.
* Once a User selects a particular show to book tickets for, a UserBookingSession starts. Within this UserBookingSession, a User will be able to get the Available Seats for the show and select the Seats he wishes to book. It is a ‘good to have’ for the Application to have limits on the number of seats a User can book in a Ticket.
* Once the user has selected a group of seats, these seats should become TEMPORARILY_UNAVAILABLE to all other Users.
* The User then proceeds to make payment which can either be SUCCESS or FAILURE.
* If Payment FAILED, user can retry Payment for a maximum number of times. Beyond maximum retries, the seats are made AVAILABLE.
* If Payment SUCCEEDS, Ticket or Booking Confirmation is generated and made available to the User. The UserBookingSession is closed and the Seats are made PERMANENTLY_UNAVAILABLE.
* A User can also explicitly close the UserBookingSession after selecting seats and before making payment. In this case, the seats selected are made AVAILABLE once again.

### Problems:
Demonstrate the following scenarios:  
2 concurrent Users U1, U2 in the application. The Users can retrieve Available Shows and select one show.

#### Case 1:
1. Say U1 and U2 select same show.
2. U1 requests for and gets all Available Seats for this show.
3. U1 selects group of seats and proceeds to pay.
4. U2 requests for and gets all Available Seats for this show. U2 should not see the seats selected by U1 as AVAILABLE.
   5 .Payment succeeded for U1.
6. U1 receives Ticket with Seats confirmed.

#### Case 2:
1. Say U1 and U2 select same show.
2. U1 and U2 requests for and gets all Available Seats for this show.
3. U1 selects group of seats.
4. U1 proceeds to pay.
5. U2 requests for and gets all Available Seats for this show. U2 should NOT see the seats selected by U1 as AVAILABLE.
6. Payment failed for U1. Assume maximum retries as zero just for the demo. Also show in another scenario where U1’s UserBookingSession is explicitly closed by U1 before payment is completed.
7. U2 again requests for and gets all Available Seats for this show. U2 should now see the seats previously selected by U1 as AVAILABLE.

#### Case 3:
1. Say U1 and U2 select same show.
2. U1 and U2 request for and get all Available Seats for this show.
3. U1 selects group of seats and proceeds to pay.
4. U2 selects overlapping group of seats and proceeds to pay. U2 should be notified that
   “one or more of the selected seats are not available at this moment”.

# Reference:

Practiced learning this problem from https://github.com/anomaly2104/ticket-booking-low-level-system-design