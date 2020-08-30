/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api;


import com.example.model.Location;
import com.example.service.LocationService;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HashMap<String, Object> addLocation(@Valid @NonNull @RequestBody Location location){
        int result = locationService.addLocation(location);
        HashMap<String, Object> map = new HashMap<>();
        map.put("Success", result == 1);
        return map;

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
    
    @DeleteMapping(path = "{id}")
    public HashMap<String, Object> deleteLocationById(@PathVariable("id") UUID id){
        int result = locationService.deleteLocation(id);
        
        HashMap<String, Object> map = new HashMap<>();
        map.put("Success", result == 1);
        return map;
    }
    
    
    @PutMapping(path = "{id}")
    public HashMap<String, Object> updateLocation(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Location locationToUpdate){
        int result = locationService.updateLocation(id, locationToUpdate);
        
        HashMap<String, Object> map = new HashMap<>();
        map.put("Success", result == 1);
        return map;
    }
    
}
