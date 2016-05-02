package com.jebrahim.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductSelectionController
{
    @RequestMapping("/productSelection")
    public String getProductSelectionPage(@CookieValue(name = "customerId", required = false) String pCustomerId, Model pModel) {
        pModel.addAttribute("customerId", pCustomerId);
        return "productSelection";
    }

    @RequestMapping(value = "/productSelection", method = RequestMethod.POST)
    public String submitBasket(@RequestParam("customerId") String pCustomerId,
                               @RequestParam("products") String[] pProducts,
                               Model pModel) {
        pModel.addAttribute("products", pProducts);
        pModel.addAttribute("customerId", pCustomerId);
        return "basket";
    }
}
