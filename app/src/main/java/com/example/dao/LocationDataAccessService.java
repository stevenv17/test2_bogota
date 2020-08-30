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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author steven
 */

@Repository("postgres")
public class LocationDataAccessService implements LocationDao {
    
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public LocationDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertLocation(UUID id, Location location) {
        final String sql = "INSERT INTO location (id, name, area_m2) VALUES (?,?,?)";
        Object[] args = new Object[] {id ,location.getName(), location.getArea_m2()};
        // °°°°°° cambiar por otra cosa o ya vere que hacer
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public List<Location> selectAllLocations() {
        final String sql = "SELECT id, name, area_m2 FROM location";
        return jdbcTemplate.query(sql, (resultSet, i) ->{
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            float area_m2 = resultSet.getFloat("area_m2");
            return new Location(id, name, area_m2);
        });
    }

    @Override
    public Optional<Location> selectLocationById(UUID id) {
        final String sql = "SELECT id, name, area_m2 FROM location WHERE id = ?";
        Location location =  jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            UUID locationId = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            float area_m2 = resultSet.getFloat("area_m2");
            return new Location(locationId, name, area_m2);
        });
        return Optional.ofNullable(location);
    }

    @Override
    public int deleteLocationById(UUID id) {
        final String sql = "DELETE FROM location WHERE id = ?";
        Object[] args = new Object[] {id};
        // °°°°°° cambiar por booleano o ya vere que hacer
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int updateLocationById(UUID id, Location location) {
        final String sql = "UPDATE location SET name = ? WHERE id = ?";
        Object[] args = new Object[] {location.getName(), id};
        // °°°°°° cambiar por booleano o ya vere que hacer
        return jdbcTemplate.update(sql, args);
    }
    
}
