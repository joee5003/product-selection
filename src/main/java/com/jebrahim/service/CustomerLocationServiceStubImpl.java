package com.jebrahim.service;

import com.jebrahim.exception.CustomerIdNotFoundException;
import com.jebrahim.values.Location;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Stub implementation of the {@link com.jebrahim.service.CustomerLocationService CustomerLocationService}.
 * Uses hash map to emulate getting data from a database.
 */
public class CustomerLocationServiceStubImpl implements CustomerLocationService
{
    private static Map<String, Location> USERS = new HashMap<>();

    static
    {
        USERS.put("LN0001", Location.LONDON);
        USERS.put("LN0002", Location.LONDON);
        USERS.put("LP0001", Location.LIVERPOOL);
        USERS.put("LP0002", Location.LIVERPOOL);
        USERS.put("BH0001", Location.OTHER);
        USERS.put("EX0001", Location.OTHER);
    }

    @Override
    public Location getUserLocation(String pUserId) throws CustomerIdNotFoundException {
        if (pUserId == null)
        {
            throw new CustomerIdNotFoundException(pUserId);
        }
        else
        {
            Location lLocation = USERS.get(pUserId);
            if (lLocation == null)
            {
                throw new CustomerIdNotFoundException(pUserId);
            }
            else
            {
                return lLocation;
            }
        }
    }
}
