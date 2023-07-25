package com.sctp.module3project2.controller;

import java.util.ArrayList;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sctp.module3project2.entity.ShippingRoute;
import com.sctp.module3project2.services.ShippingRouteService;

// Edited by Wei Kang
@RestController
@RequestMapping("/api/shippingRoute")
public class ShippingRouteController {
    private ShippingRouteService shippingRouteService;

    public ShippingRouteController(ShippingRouteService shippingRouteService) {
        this.shippingRouteService = shippingRouteService;
    }

    @PostMapping("")
    public ResponseEntity<ShippingRoute> saveShippingRoute(@RequestBody ShippingRoute shippingRoute)
            throws AuthenticationException {
        ShippingRoute newShippingRoute = shippingRouteService.saveShippingRoute(shippingRoute);
        return new ResponseEntity<>(newShippingRoute, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingRoute> getShippingRoute(@PathVariable int id)
            throws AuthenticationException {
        ShippingRoute foundShippingRoute = shippingRouteService.getShippingRoute(id);
        return new ResponseEntity<>(foundShippingRoute, HttpStatus.OK);
    }

    // Experimenting
    // @GetMapping(path = "/myrequestheaders", produces =
    // {MediaType.APPLICATION_JSON_VALUE} )
    // public ResponseEntity<Map<String, String>> getMyRequestHeaders(
    // @RequestHeader(value="Accept") String acceptHeader,
    // @RequestHeader(value="Authorization") String authorizationHeader
    // )
    // {
    // Map<String, String> returnValue = new HashMap<>();
    // returnValue.put("Accept", acceptHeader);
    // returnValue.put("Authorization", authorizationHeader);

    // return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    // }

    @GetMapping("")
    public ResponseEntity<ArrayList<ShippingRoute>> getAllShippingRoute()
            throws AuthenticationException {
        ArrayList<ShippingRoute> allShippingRoute = (ArrayList<ShippingRoute>) shippingRouteService
                .getAllShippingRoutes();

        return new ResponseEntity<>(allShippingRoute, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShippingRoute> updateShippingRoute(@PathVariable int id,
            @RequestBody ShippingRoute shippingRoute)
            throws AuthenticationException {
        ShippingRoute updatedShippingRoute = shippingRouteService.updateShippingRoute(id, shippingRoute);
        return new ResponseEntity<>(updatedShippingRoute, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteShippingRoute(@PathVariable int id)
            throws AuthenticationException {
        shippingRouteService.deleteShippingRoute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
