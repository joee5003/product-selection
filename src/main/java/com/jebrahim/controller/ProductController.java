package com.jebrahim.controller;

import com.jebrahim.dto.ProductDTO;
import com.jebrahim.service.ProductService;
import com.jebrahim.values.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{
    private final ProductService theProductService;

    @Autowired
    public ProductController(ProductService pService) {
        theProductService = pService;
    }

    @RequestMapping("/")
    public ResponseEntity<List<ProductDTO>> getProductsForLocation(@RequestParam("l") String pLocation) {
        if (pLocation == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else
        {
            Location lLocation;
            try
            {
               lLocation = Location.valueOf(pLocation);
            }
            catch (IllegalArgumentException pIAE)
            {
                lLocation = Location.OTHER;
            }
            List<ProductDTO> lProducts = theProductService.getProductsForLocation( lLocation );
            return new ResponseEntity<>(lProducts, HttpStatus.OK);
        }
    }
}
