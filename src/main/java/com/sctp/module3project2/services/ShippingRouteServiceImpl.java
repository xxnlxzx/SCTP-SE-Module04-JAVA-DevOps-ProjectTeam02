package com.sctp.module3project2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sctp.module3project2.entity.ShippingRoute;
import com.sctp.module3project2.exception.ShippingRouteNotFoundException;
import com.sctp.module3project2.repository.ShippingRouteRepository;

@Service
public class ShippingRouteServiceImpl implements ShippingRouteService{
    private ShippingRouteRepository shippingRouteRepository;

    public ShippingRouteServiceImpl(ShippingRouteRepository shippingRouteRepository) {
        this.shippingRouteRepository = shippingRouteRepository;
    }

    @Override
    public ShippingRoute saveShippingRoute(ShippingRoute shippingRoute) {
        ShippingRoute newShippingRoute = shippingRouteRepository.save(shippingRoute);
        return newShippingRoute;
    }

    @Override
    public ShippingRoute getShippingRoute(int id) {
        Optional<ShippingRoute> wrappedShippingRoute = shippingRouteRepository.findById(id);
        if (!wrappedShippingRoute.isPresent()){
            throw new ShippingRouteNotFoundException("Shipping Route not found");
        }

        ShippingRoute foundShippingRoute = wrappedShippingRoute.get();

        return foundShippingRoute;
    }

    @Override
    public List<ShippingRoute> getAllShippingRoutes() {
        List<ShippingRoute> allShippingRoute = (ArrayList<ShippingRoute>) shippingRouteRepository.findAll();
        return allShippingRoute;
    }

    @Override
    public ShippingRoute updateShippingRoute(int id, ShippingRoute shippingRoute) {
        Optional<ShippingRoute> wrappedShippingRouteToUpdate = shippingRouteRepository.findById(id);

        if (!wrappedShippingRouteToUpdate.isPresent()){
            throw new ShippingRouteNotFoundException("Shipping Route not found");
        }

        ShippingRoute shippingRouteToUpdate = wrappedShippingRouteToUpdate.get();

        shippingRouteToUpdate.setDate_of_arrival(shippingRoute.getDate_of_arrival());
        shippingRouteToUpdate.setPort(shippingRoute.getPort());
        shippingRouteToUpdate.setPurpose_of_travel(shippingRoute.getPurpose_of_travel());
        shippingRouteToUpdate.setTax_fees_port_expenses(shippingRoute.getTax_fees_port_expenses());
        return shippingRouteRepository.save(shippingRouteToUpdate);
    }

    @Override
    public void deleteShippingRoute(int id) {
        shippingRouteRepository.deleteById(id);
    }

    
}
