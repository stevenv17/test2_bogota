/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.model.Location;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 *
 * @author steven
 */
public interface LocationDao 
{
    int insertLocation(UUID id, Location location);
    
    default int insertLocation(Location location){
        UUID id = UUID.randomUUID();
        return insertLocation(id, location);
    }
    
    List<Location> selectAllLocations();
    
    Optional<Location> selectLocationById(UUID id);
    
    int deleteLocationById(UUID id);
    
    int updateLocationById(UUID id, Location location);
}
