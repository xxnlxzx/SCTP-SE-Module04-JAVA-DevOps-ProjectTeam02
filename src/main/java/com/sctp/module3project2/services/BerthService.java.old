package com.sctp.module3project2.services;

import org.springframework.stereotype.Service;

import com.sctp.module3project2.dto.BerthDto;
import com.sctp.module3project2.entity.Berth;
import com.sctp.module3project2.repository.BerthRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BerthService {
    private final BerthRepository repository;

    public BerthService(BerthRepository repository) {
        this.repository = repository;
    }

    public List<Berth> getAllBerthPortLocations() {
        return repository.findAll();
    }

    public Berth createBerthPortLocation(BerthDto berthDto) {
        Berth berth = new Berth();
        berth.setName(berthDto.getName());
        berth.setLocation(berthDto.getLocation());
        berth.setAvailability(true); // Assuming availability is always set to true for new berths.
        return repository.save(berth);
    }

    public Berth getBerthPortLocationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Berth updateBerthPortLocation(Long id, Berth updatedBerth) {
        Berth berth = repository.findById(id).orElse(null);
        if (berth != null) {
            berth.setName(updatedBerth.getName());
            return repository.save(berth);
        }
        return null;
    }

    public boolean deleteBerthPortLocation(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<BerthDto> getAllBerthPortLocationsWithAvailability() {
        List<Berth> berths = repository.findAll();
        List<BerthDto> berthDtos = new ArrayList<>();

        for (Berth berth : berths) {
            BerthDto berthDto = new BerthDto();
            berthDto.setId(berth.getId());
            berthDto.setName(berth.getName());
            berthDto.setAvailability(berth.isAvailability());
            berthDtos.add(berthDto);
        }

        return berthDtos;
    }
}
