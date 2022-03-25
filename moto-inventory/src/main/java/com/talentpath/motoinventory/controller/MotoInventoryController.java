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
}
