package com.sctp.module3project2.services;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sctp.module3project2.entity.ShippingRoute;
import com.sctp.module3project2.entity.Vessel;
import com.sctp.module3project2.repository.ShippingRouteRepository;
import com.sctp.module3project2.repository.VesselRepository;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
// Edited by Afif
@Service
public class VesselServiceImpl implements VesselService {

    private final VesselRepository vesselRepository;
    private final ShippingRouteRepository shippingRouteRepository;


    public VesselServiceImpl(VesselRepository vesselRepository, ShippingRouteRepository shippingRouteRepository) {
        this.vesselRepository = vesselRepository;
        this.shippingRouteRepository = shippingRouteRepository;
    }

    @Override
    public List<Vessel> findAllVessels() {
    return vesselRepository.findAll();
    }

    @Override
    public  Vessel saveVessel(Vessel vessel) {
    return vesselRepository.save(vessel);
    }

    @Override
    public Optional <Vessel> findById(Long id) {
        return vesselRepository.findById(id);
    }

    @Override
    public Vessel updateVessel(Long id) {
        Optional<Vessel> optionalVessel = vesselRepository.findById(id);
        if (optionalVessel.isPresent()) {
            Vessel existingVessel = optionalVessel.get();
            existingVessel.setName(existingVessel.getName());
            existingVessel.setType(existingVessel.getType());
            List<ShippingRoute> shippingRouteInfo = existingVessel.getShippingRoutes();
            List<ShippingRoute> shippingRoute = new ArrayList<ShippingRoute>();
            for (ShippingRoute route : shippingRouteInfo) {
                ShippingRoute newRoute = new ShippingRoute();
                newRoute.setDate_of_arrival(route.getDate_of_arrival());
                newRoute.setPort(route.getPort());
                newRoute.setPurpose_of_travel(route.getPurpose_of_travel());
                newRoute.setTax_fees_port_expenses(route.getTax_fees_port_expenses());
                shippingRoute.add(newRoute);
            };
            existingVessel.setShippingRoutes(shippingRoute);
            return vesselRepository.save(existingVessel);
        } else {
            throw new IllegalArgumentException("Vessel not found with ID: " + id);
        }
    }

    @Override
    public void deleteVessel(Long id) {
        vesselRepository.deleteById(id);
    }

    @Override
    public ShippingRoute addShippingRouteToVessel(Long id, ShippingRoute ShippingRoute) {
        Optional<Vessel> wrappedVessel = vesselRepository.findById(id);
        if (!wrappedVessel.isPresent()){
            throw new IllegalArgumentException("Vessel not Found with ID: "+ id);
        }

        Vessel selectedVessel = wrappedVessel.get();

        ShippingRoute.setVessel(selectedVessel);
        return shippingRouteRepository.save(ShippingRoute);
    }
    


    }