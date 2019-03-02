package pl.sda.bikerepositoryapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getBike(@PathVariable String id) {
        int index = Integer.parseInt(id);
        if (index == 418) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
        Bike bike = bikeService.findBike(index);
        if (bike == null) {
            LOG.error("Controller: No bike with index " + index + " found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        LOG.info("Controller: Displaying specific bike.");
        return ResponseEntity.ok(bike);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBike(@RequestBody Bike bike) {
        bikeService.addBike(bike);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Bike> removeBike(@PathVariable String id) {
        int index = Integer.parseInt(id);
        if (index == 418) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
        if (bikeService.findBike(index) == null) {
            LOG.error("Controller: No bike with index " + index + " have been found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        LOG.info("Controller: Removing specified bike.");
        bikeService.deleteBike(index);
        return null;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleIllegalArgument() {
        LOG.error("Resolving IllegalArgumentException.");
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleFormatException() {
        LOG.error("Resolving NumberFormatException.");
    }
}