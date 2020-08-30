/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.service;

import com.example.dao.LocationDao;
import com.example.model.Location;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author steven
 */

@Service
public class LocationService 
{
    private final LocationDao locationDao;
    
    @Autowired
    public LocationService(@Qualifier("postgres") LocationDao locationDao){
        this.locationDao = locationDao;
    }
    
    public int addLocation(Location location){
        return locationDao.insertLocation(location);
    }
    
    public List<Location> getAllLocations(){
        return locationDao.selectAllLocations();
    }
    
    public Optional<Location> getLocationById(UUID id){
        return locationDao.selectLocationById(id);
    }
    
    public int deleteLocation(UUID id){
        return locationDao.deleteLocationById(id);
    }
    
    public int updateLocation(UUID id, Location location){
        return locationDao.updateLocationById(id, location); 
    }
}
