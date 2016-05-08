package com.jebrahim.service;

import com.jebrahim.entity.Customer;
import com.jebrahim.exception.CustomerIdNotFoundException;
import com.jebrahim.repository.CustomerRepository;
import com.jebrahim.values.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerLocationServiceImpl implements CustomerLocationService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Location getUserLocation(String pUserId) throws CustomerIdNotFoundException {
        Customer customer = customerRepository.findOne( pUserId );
        if( customer == null )
        {
            throw new CustomerIdNotFoundException( pUserId );
        }
        else
        {
            return customer.getLocation();
        }
    }
}
