package com.jebrahim.repository;

import com.jebrahim.entity.Customer;
import com.jebrahim.values.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String>
{
    List<Customer> findByLocation(Location pLocation);
}