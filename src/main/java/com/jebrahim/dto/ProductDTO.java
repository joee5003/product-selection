package com.jebrahim.dto;

import com.jebrahim.values.Category;
import com.jebrahim.values.Location;

public class ProductDTO
{
    private Category category;
    private String name;
    private Location location;

    public ProductDTO( Category pCategory, String pName, Location pLocation) {
        this.category = pCategory;
        this.name = pName;
        this.location = pLocation;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
