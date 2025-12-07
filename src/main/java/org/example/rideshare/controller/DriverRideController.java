
package org.example.rideshare.controller;

import org.example.rideshare.model.Ride;
import org.example.rideshare.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverRideController {

    @Autowired
    private RideService rideService;

    // DRIVER: view pending requests
    @GetMapping("/rides/requests")
    public ResponseEntity<List<Ride>> getPendingRides() {
        List<Ride> rides = rideService.getPendingRides();
        return ResponseEntity.ok(rides);
    }

    // DRIVER: accept a ride
    @PostMapping("/rides/{rideId}/accept")
    public ResponseEntity<Ride> acceptRide(@PathVariable String rideId,
                                           Authentication authentication) {
        String driverUsername = authentication.getName();
        Ride ride = rideService.acceptRide(rideId, driverUsername);
        return ResponseEntity.ok(ride);
    }
}
