package org.example;

import org.example.controllers.*;
import org.example.model.*;
import org.example.providers.InMemorySeatLockProvider;
import org.example.providers.SeatLockProvider;
import org.example.service.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Movie Ticket Booking LLD machine coding!");


        TheaterService theaterService = new TheaterService();
        TheaterController theaterController = new TheaterController(theaterService);

        Theater theater = theaterController.addTheater("Drama House");

        Screen screen = theaterController.addScreenInTheater(theater.getId());

        Seat seat1 = theaterController.addSeatInScreen(0, 0, screen.getId());
        Seat seat2 = theaterController.addSeatInScreen(0, 1, screen.getId());

        MovieService movieService = new MovieService();
        MovieController movieController = new MovieController(movieService);
        Movie movie = movieController.addMovie("Interstellar");

        SeatLockProvider seatLockProvider = new InMemorySeatLockProvider(3);

        BookingService bookingService = new BookingService(seatLockProvider);

        ShowService showService = new ShowService();

        SeatAvailabilityService seatAvailabilityService = new SeatAvailabilityService(bookingService, seatLockProvider);

        ShowController showController = new ShowController(showService, movieService, theaterService, seatAvailabilityService);
        Show show = showController.addShowInScreen(movie.getId(), 120,
                LocalDateTime.parse(("2024-02-20T00:00:00")),
                screen.getId());

        BookingController bookingController = new BookingController(bookingService, showService, theaterService);

        PaymentService paymentService = new PaymentService(0, seatLockProvider);
        PaymentController paymentController = new PaymentController(paymentService, bookingService);

        System.out.println("CASE 1");

//        System.out.println("u1 book 1 seat");
//        Booking booking1 = bookingController.createBooking(show.getId(), "u1", Arrays.asList(seat1.getId()));
//
//        List<String> seatIds = showController.getAvailableSeatsForShow(show.getId());
//        System.out.println("Available seats after 1st booking");
//
//        for (String id : seatIds) {
//            System.out.println(id);
//        }
//
//        Booking booking2 = bookingController.createBooking(show.getId(), "u2", Arrays.asList(seat2.getId()));
//
//        paymentController.onPaymentSuccess(booking1.getId(), "u1");

//        System.out.println("CASE 2");
//
//        System.out.println("Available seats for a show:");
//        System.out.println();
//        List<String> seatIds = showController.getAvailableSeatsForShow(show.getId());
//
//        for (String id : seatIds) {
//            System.out.println(id);
//        }
//
//        Booking booking1 = bookingController.createBooking(show.getId(), "u1", Arrays.asList(seat1.getId()));
//
//        System.out.println("Seats after u1 booking:");
//        System.out.println();
//
//        seatIds = showController.getAvailableSeatsForShow(show.getId());
//
//        for (String id : seatIds) {
//            System.out.println(id);
//        }
//
//        paymentController.onPaymentFailure(booking1.getId(), "u1");
//
//        System.out.println("Seats after u1 payment failure");
//        System.out.println();
//
//        seatIds = showController.getAvailableSeatsForShow(show.getId());
//
//        for (String id : seatIds) {
//            System.out.println(id);
//        }

        System.out.println("CASE 3");
        System.out.println("Available seats for a show:");
        System.out.println();
        List<String> seatIds = showController.getAvailableSeatsForShow(show.getId());

        for (String id : seatIds) {
            System.out.println(id);
        }

        Booking booking1 = bookingController.createBooking(show.getId(), "u1", Arrays.asList(
                seat2.getId()));

        try {
            Booking booking2 = bookingController.createBooking(show.getId(), "u2", Arrays.asList(
                    seat2.getId()));
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Seats after u1 booking:");
        System.out.println();

        seatIds = showController.getAvailableSeatsForShow(show.getId());

        for (String id : seatIds) {
            System.out.println(id);
        }

        paymentController.onPaymentSuccess(booking1.getId(), "u1");

        try {
            Booking booking2 = bookingController.createBooking(show.getId(), "u2", Arrays.asList(
                    seat2.getId()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}