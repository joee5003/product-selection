package com.jebrahim;

import com.jebrahim.controller.LocationController;
import com.jebrahim.controller.ProductController;
import com.jebrahim.service.CustomerLocationServiceStubImpl;
import com.jebrahim.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class ProductControllerTest
{
    private MockMvc theMvc;

    @Before
    public void setUp() {
        theMvc = MockMvcBuilders.standaloneSetup(
                new ProductController(new ProductService()),
                new LocationController(new CustomerLocationServiceStubImpl())
        ).build();
    }

    @Test
    public void getLocationsFromLondonCustomerId() throws Exception {
        theMvc.perform(MockMvcRequestBuilders.get("/location/").param("customerId", "LN0001").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.location", is("LONDON")));
    }

    @Test
    public void getLocationsFromLiverpoolCustomerId() throws Exception {
        theMvc.perform(MockMvcRequestBuilders.get("/location/").param("customerId", "LP0001").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.location", is("LIVERPOOL")));
    }

    @Test
    public void getLocationsFromOtherCustomerId() throws Exception {
        theMvc.perform(MockMvcRequestBuilders.get("/location/").param("customerId", "EX0001").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andExpect(jsonPath("$.location", is("OTHER")));
    }

    @Test
    public void getLondonList() throws Exception {
        isLondonList(
                theMvc.perform(
                        MockMvcRequestBuilders.get("/products/")
                                .param("l", "LONDON")
                                .accept(MediaType.APPLICATION_JSON)
                )
        );
    }

    @Test
    public void getLiverpoolList() throws Exception {
        isLiverpoolList(
                theMvc.perform(
                        MockMvcRequestBuilders.get("/products/")
                                .param("l", "LIVERPOOL")
                                .accept(MediaType.APPLICATION_JSON)
                )
        );

    }


    @Test
    public void getUnknownLocation() throws Exception {
        isUnknownList(
                theMvc.perform(
                        MockMvcRequestBuilders.get("/products/")
                                .param("l", "LEEDS")
                                .accept(MediaType.APPLICATION_JSON)
                )
        );
    }

    private void isLondonList(ResultActions pResultActions) throws Exception {
        pResultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].category", is("Sports")))
                .andExpect(jsonPath("$[0].name", is("Arsenal TV")))
                .andExpect(jsonPath("$[0].location", is("LONDON")))

                .andExpect(jsonPath("$[1].category", is("Sports")))
                .andExpect(jsonPath("$[1].name", is("Chelsea TV")))
                .andExpect(jsonPath("$[1].location", is("LONDON")))

                .andExpect(jsonPath("$[2].category", is("News")))
                .andExpect(jsonPath("$[2].name", is("Sky News")))
                .andExpect(jsonPath("$[2].location", nullValue()))

                .andExpect(jsonPath("$[3].category", is("News")))
                .andExpect(jsonPath("$[3].name", is("Sky Sports News")))
                .andExpect(jsonPath("$[3].location", nullValue()));
    }

    private void isLiverpoolList(ResultActions pResultActions) throws Exception {
        pResultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].category", is("Sports")))
                .andExpect(jsonPath("$[0].name", is("Liverpool TV")))
                .andExpect(jsonPath("$[0].location", is("LIVERPOOL")))

                .andExpect(jsonPath("$[1].category", is("News")))
                .andExpect(jsonPath("$[1].name", is("Sky News")))
                .andExpect(jsonPath("$[1].location", nullValue()))

                .andExpect(jsonPath("$[2].category", is("News")))
                .andExpect(jsonPath("$[2].name", is("Sky Sports News")))
                .andExpect(jsonPath("$[2].location", nullValue()));
    }

    private void isUnknownList(ResultActions pResultActions) throws Exception {
        pResultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].category", is("News")))
                .andExpect(jsonPath("$[0].name", is("Sky News")))
                .andExpect(jsonPath("$[0].location", nullValue()))

                .andExpect(jsonPath("$[1].category", is("News")))
                .andExpect(jsonPath("$[1].name", is("Sky Sports News")))
                .andExpect(jsonPath("$[1].location", nullValue()));
    }


}
