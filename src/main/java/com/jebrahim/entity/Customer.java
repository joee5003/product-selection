package com.jebrahim.entity;

import com.jebrahim.coverter.LocationConverter;
import com.jebrahim.values.Location;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer
{
    @Id
    private String id;
    @Convert( converter = LocationConverter.class )
    private Location location;

    Customer(){}

    public Customer(String id, Location location) {
        this.id = id;
        this.location = location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }
}
