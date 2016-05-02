package com.jebrahim.controller;

import com.jebrahim.exception.CustomerIdNotFoundException;
import com.jebrahim.dto.LocationDTO;
import com.jebrahim.service.CustomerLocationService;
import com.jebrahim.values.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController
{
    private final CustomerLocationService theCustomerLocationService;

    @Autowired
    public LocationController(CustomerLocationService theCustomerLocationService) {
        this.theCustomerLocationService = theCustomerLocationService;
    }

    @RequestMapping("/")
    public ResponseEntity<LocationDTO > getLocation(@RequestParam( "customerId" ) String pCustomerId ) {
        try
        {
            Location lLocation = theCustomerLocationService.getUserLocation( pCustomerId );
            return new ResponseEntity<>(new LocationDTO(lLocation), HttpStatus.OK);
        }
        catch (CustomerIdNotFoundException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}