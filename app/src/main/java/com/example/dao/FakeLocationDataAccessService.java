/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.model.Location;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 *
 * @author steven
 */
@Repository("fakeDao")
public class FakeLocationDataAccessService implements LocationDao{

    private static List<Location> DB = new ArrayList<>();
    
    @Override
    public int insertLocation(UUID id, Location location) {
        DB.add(new Location(id, location.getName(), location.getArea_m2()));
        return 1;
    }

    @Override
    public List<Location> selectAllLocations() {
        return DB;
    }

    @Override
    public Optional<Location> selectLocationById(UUID id) {
        return DB.stream()
                .filter(location -> location.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteLocationById(UUID id) {
        Optional<Location> locationMaybe = selectLocationById(id); 
        if(!locationMaybe.isPresent()){
            return 0;
        }
        DB.remove(locationMaybe.get());
        return 1;
    }

    @Override
    public int updateLocationById(UUID id, Location location) {
        return selectLocationById(id)
                .map(loc -> {
                    int indexOfLocationToUpdate = DB.indexOf(loc);
                    if(indexOfLocationToUpdate >= 0){
                        DB.set(indexOfLocationToUpdate, new Location(id, location.getName(), location.getArea_m2()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
    
}
