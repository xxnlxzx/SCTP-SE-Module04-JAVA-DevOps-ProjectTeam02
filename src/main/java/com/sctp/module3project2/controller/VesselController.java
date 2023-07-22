package com.sctp.module3project2.controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sctp.module3project2.entity.ShippingRoute;
import com.sctp.module3project2.entity.Vessel;
import com.sctp.module3project2.services.VesselService;

import java.util.List;
import java.util.Optional;
// Edited by Afif
@RestController
@RequestMapping("/api/vessels")
public class VesselController {
    private final VesselService vesselService; 

public VesselController(VesselService vesselService ) 
    {this.vesselService = vesselService;
}

@GetMapping
public List<Vessel> findAllVessels(){
    return vesselService.findAllVessels();
}

@GetMapping("/{id}")
public ResponseEntity<Vessel> findVesselById(@PathVariable("id") Long id){
    Optional<Vessel> optionalVessel = vesselService.findById(id); 
    return optionalVessel.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
}

@PostMapping
public ResponseEntity<Vessel> saveVessel(@RequestBody Vessel vessel){
    Vessel newVessel = vesselService.saveVessel(vessel);
    return new ResponseEntity<>(newVessel, HttpStatus.CREATED);
}


@PutMapping("/{id}")
public ResponseEntity<Vessel> updateVessel(@PathVariable Long id, @RequestBody Vessel vessel){
    Vessel updatedVessel = vesselService.updateVessel(id);
    return new ResponseEntity<>(updatedVessel, HttpStatus.OK);
}

@DeleteMapping("/{id}")
public ResponseEntity<HttpStatus> deleteVessel(@PathVariable("id") Long id) {
    vesselService.deleteVessel(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

@PostMapping("/{id}/shippingroute")
public ResponseEntity<ShippingRoute> addShippingRouteToVessel(@PathVariable Long id, @RequestBody ShippingRoute shippingRoute){
    ShippingRoute newShippingRoute = vesselService.addShippingRouteToVessel(id, shippingRoute);
    return new ResponseEntity<>(newShippingRoute, HttpStatus.OK);
}
}
