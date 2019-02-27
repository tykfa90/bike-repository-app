package pl.sda.bikerepositoryapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.bikerepositoryapp.model.Bike;
import pl.sda.bikerepositoryapp.repository.BikeRepository;

import java.util.Collection;

@Service
public class BikeService {

    private static final Logger LOG = LoggerFactory.getLogger(BikeService.class);

    @Autowired
    private BikeRepository bikeRepository;

    public Collection<Bike> getBikes() {
        LOG.info("Service: Accessing bike listing.");
        return bikeRepository.getBikes();
    }

    public Bike findBike(int index) {
        LOG.info("Service: Searching for a bike by it's Index.");
        return bikeRepository.findBike(index);
    }

    public void addBike(Bike bike) {
        LOG.info("Service: Adding bike to listing.");
        bikeRepository.storeBike(bike);
    }

    public void deleteBike(int index) {
        LOG.info("Service: Deleting bike from listing.");
        bikeRepository.deleteBike(index);
    }
}
