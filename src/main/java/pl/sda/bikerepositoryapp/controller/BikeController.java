package pl.sda.bikerepositoryapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.bikerepositoryapp.model.Bike;
import pl.sda.bikerepositoryapp.service.BikeService;

import java.util.Collection;

@Controller
@RequestMapping("/bikes")
public class BikeController {

    private static final Logger LOG = LoggerFactory.getLogger(BikeService.class);

    @Autowired
    private BikeService bikeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Collection<Bike> getBikes() {
        LOG.info("Controller: Displaying bikes.");
        return bikeService.getBikes();
    }

    @GetMapping("/bikes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Bike getBike(@PathVariable String id) {
        LOG.info("Controller: Displaying specific bike.");
        int index = Integer.parseInt(id);
        return bikeService.findBike(index);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBike(@RequestBody Bike bike) {
        bikeService.addBike(bike);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeBike(String id) {
        LOG.info("Controller: Removing specific bike.");
        int index = Integer.parseInt(id);
        bikeService.deleteBike(index);
    }
}