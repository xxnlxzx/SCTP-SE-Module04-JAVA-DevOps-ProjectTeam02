package com.sctp.module3project2.services;

import java.util.List;
import java.util.Optional;

import com.sctp.module3project2.entity.ShippingRoute;
import com.sctp.module3project2.entity.Vessel;
// Edited by Afif
public interface VesselService {
    List<Vessel> findAllVessels();
    Vessel saveVessel(Vessel vessel);
    Optional <Vessel> findById(Long id);
    Vessel updateVessel(Long id);
    void deleteVessel(Long id);
    ShippingRoute addShippingRouteToVessel(Long id, ShippingRoute ShippingRoute);
    
    
}
