package com.jebrahim.dto;

import com.jebrahim.values.Location;

public class LocationDTO
{
    private Location location;

    public LocationDTO(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
