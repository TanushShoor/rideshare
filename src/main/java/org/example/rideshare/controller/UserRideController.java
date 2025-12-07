
package org.example.rideshare.controller;

import org.example.rideshare.model.Ride;
import org.example.rideshare.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserRideController {

    @Autowired
    private RideService rideService;

    @GetMapping("/rides")
    public ResponseEntity<List<Ride>> getMyRides(Authentication authentication) {
        String username = authentication.getName();
        List<Ride> rides = rideService.getUserRides(username);
        return ResponseEntity.ok(rides);
    }
}
