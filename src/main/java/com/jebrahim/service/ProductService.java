package com.jebrahim.service;

import com.jebrahim.dto.ProductDTO;
import com.jebrahim.values.Category;
import com.jebrahim.values.Location;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService
{
    private static final Map< Location, List< ProductDTO > > LOCATION_PRODUCTS_MAP = new HashMap<>();
    private static final List< ProductDTO > COMMON_PRODUCTS = new ArrayList<>();

    static
    {
        List<ProductDTO> lCommon = new ArrayList<>();
        lCommon.add( new ProductDTO( Category.News, "Sky News", null ) );
        lCommon.add( new ProductDTO( Category.News, "Sky Sports News", null ) );

        List< ProductDTO > lLondon = new ArrayList<>();
        lLondon.add( new ProductDTO( Category.Sports, "Arsenal TV", Location.LONDON ) );
        lLondon.add( new ProductDTO( Category.Sports, "Chelsea TV", Location.LONDON ) );
        lLondon.addAll( lCommon );

        List< ProductDTO > lLiverpool = new ArrayList<>();
        lLiverpool.add( new ProductDTO( Category.Sports, "Liverpool TV", Location.LIVERPOOL ) );
        lLiverpool.addAll( lCommon );

        LOCATION_PRODUCTS_MAP.put( Location.LONDON, lLondon );
        LOCATION_PRODUCTS_MAP.put( Location.LIVERPOOL, lLiverpool );
        COMMON_PRODUCTS.addAll( lCommon );
    }
    
    public List<ProductDTO> getProductsForLocation(Location pLocation) {
        List< ProductDTO > lProducts = LOCATION_PRODUCTS_MAP.get( pLocation );
        return lProducts == null ? COMMON_PRODUCTS : lProducts;
    }
}
