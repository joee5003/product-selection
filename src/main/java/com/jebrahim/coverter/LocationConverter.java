package com.jebrahim.coverter;

import com.jebrahim.values.Location;

import javax.persistence.AttributeConverter;

public class LocationConverter implements AttributeConverter<Location, String >
{
    @Override
    public String convertToDatabaseColumn(Location attribute) {
        return attribute.name();
    }

    @Override
    public Location convertToEntityAttribute(String dbData) {
        return Location.valueOf(dbData);
    }
}
