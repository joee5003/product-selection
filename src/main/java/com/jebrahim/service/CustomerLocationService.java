package com.jebrahim.service;

import com.jebrahim.exception.CustomerIdNotFoundException;
import com.jebrahim.values.Location;
import org.springframework.stereotype.Service;

@Service
public interface CustomerLocationService
{
    Location getUserLocation(String pUserId) throws CustomerIdNotFoundException;
}
