package org.example;

import org.example.controllers.DriverController;
import org.example.controllers.RiderController;
import org.example.model.DriverStatus;
import org.example.model.Location;
import org.example.service.DriverService;
import org.example.service.RideService;
import org.example.service.RiderService;
import org.example.service.strategies.DistanceBasedPricingStrategy;
import org.example.service.strategies.DriverMatchingStrategy;
import org.example.service.strategies.FirstDriverMatchingStrategy;
import org.example.service.strategies.PricingStrategy;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Cab Booking LLD");

        PricingStrategy pricingStrategy = new DistanceBasedPricingStrategy();
        RideService rideService = new RideService(pricingStrategy);

        DriverService driverService = new DriverService();
        DriverController driverController = new DriverController(driverService, rideService);

        String driverId1 = driverController.register("1234567890", new Location(10.0, 10.0));
        String driverId2 = driverController.register("0987654321", new Location(100.0, 100.0));

        driverService.updateAvailability(driverId1, DriverStatus.IDLE);
        driverService.updateAvailability(driverId2, DriverStatus.IDLE);

        DriverMatchingStrategy driverMatchingStrategy = new FirstDriverMatchingStrategy(driverService);
        RiderService riderService = new RiderService(rideService, driverMatchingStrategy);
        RiderController riderController = new RiderController(riderService, rideService);

        String riderId1 = riderController.register("6789054321");
        String riderId2 = riderController.register("5432167890");

        riderController.bookCab(riderId1,
                new Location(20.0, 30.0),
                new Location(200.0, 300.0));

        driverController.endRide(driverService.fetchDriver(driverId1));

        riderController.bookCab(riderId2,
                new Location(90.0, 90.0),
                new Location(200.0, 300.0));

        driverController.endRide(driverService.fetchDriver(driverId2));


    }
}