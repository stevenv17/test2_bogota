/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api;


import com.example.model.Location;
import com.example.service.LocationService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author steven
 */

@RequestMapping("api/v1/location")
@RestController
public class LocationController {
    
    private final LocationService locationService;
    
    @Autowired
    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }
    
    @PostMapping
    public void addLocation(@RequestBody Location location){
        locationService.addLocation(location);
    }
    
    @GetMapping
    public List<Location> getAllLocations(){
        return locationService.getAllLocations();
    }
    
    @GetMapping(path = "{id}")
    public Location getLocationById(@PathVariable("id") UUID id){
        return locationService.getLocationById(id)
                .orElse(null);
    }
}
