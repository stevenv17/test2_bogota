/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;



/**
 *
 * @author steven
 */
public class Location {
    
    private final UUID id;
    
    @NotBlank
    private final String name;
    
    @PositiveOrZero
    private final float area_m2;
    
    private UUID parentLoc;
    
    public Location(@JsonProperty("id") UUID id, 
                    @JsonProperty("name") String name,
                    @JsonProperty("area_m2") float area_m2
                    
    ){
        this.id = id;
        this.name = name;
        this.area_m2 = area_m2;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getArea_m2() {
        return area_m2;
    }

    public UUID getParentLoc() {
        return parentLoc;
    }

    public void setParentLoc(UUID parentLoc) {
        this.parentLoc = parentLoc;
    }
    
    
}
