package com.talentpath.motoinventory.dao;

import com.talentpath.motoinventory.models.Motorcycle;

import java.util.List;

public interface MotoInventoryDao {
    Motorcycle getMotorcycle(int id);
    List<Motorcycle> getAllMotorcycles();
    Motorcycle addMotorcycle(Motorcycle motorcycle);
    void deleteMotorcycle(int id);
    void updateMotorcycle(Motorcycle motorcycle);
    List<Motorcycle> getMotorcyclesByMake(String make);
    List<Motorcycle> getMotorcyclesByType(String type);
    List<Motorcycle> getMotorcyclesByVin(String vin);
}
