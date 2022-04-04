package com.talentpath.motoinventory.controller;


import com.talentpath.motoinventory.dao.MotoInventoryDao;
import com.talentpath.motoinventory.models.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MotoInventoryController {
    @Autowired
    private MotoInventoryDao dao;

    @RequestMapping(path = "/motorcycle", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Motorcycle createMotorcycle(@RequestBody Motorcycle moto) {
        return dao.addMotorcycle(moto);
    }

    @RequestMapping(path = "/motorcycle", method = RequestMethod.GET)
    public List<Motorcycle> getAllMotorcycles() {
        return dao.getAllMotorcycles();
    }

    @RequestMapping(path = "/motorcycle/{id}", method = RequestMethod.GET)
    public  Motorcycle getMotorcycle(@PathVariable int id) {
        return dao.getMotorcycle(id);
    }
    @RequestMapping (value = "/motorcycle/{id}", method = RequestMethod.PUT)
    @ResponseStatus (value = HttpStatus.OK)
    public void updateMotorcycle(@PathVariable int id, @RequestBody Motorcycle motorcycle) {
        dao.updateMotorcycle(motorcycle);
    }

    @RequestMapping (value = "/motorcycle/{id}", method = RequestMethod.DELETE)
    @ResponseStatus (value = HttpStatus.OK)
    public void deleteMotorcycle(@PathVariable int id) {
        System.out.println("Deleted " + id);
    }

    @RequestMapping(path = "/motorcycle/make", method = RequestMethod.GET)
    public List<Motorcycle> getMotorcycleByMake(@PathVariable String make) {
        return dao.getMotorcyclesByMake(make);
    }

    @RequestMapping(path = "/motorcycle/type", method = RequestMethod.GET)
    public List<Motorcycle> getMotorcycleByType(@PathVariable String type) {
        return dao.getMotorcyclesByType(type);
    }

    @RequestMapping(path = "/motorcycle/vin", method = RequestMethod.GET)
    public List<Motorcycle> getMotorcycleByVin(@PathVariable String vin) {
        return dao.getMotorcyclesByVin(vin);
    }
//
//    @RequestMapping (value = "/motorcycle/{id}", method = RequestMethod.PUT)
//    @ResponseStatus (value = HttpStatus.OK)
//    public void motorcycleStatus(@PathVariable Boolean sold, @RequestBody Motorcycle motorcycle) {
//        dao.motorcycleStatus(sold);
//    }

}