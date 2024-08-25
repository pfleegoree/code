package com.frankmoley.lil.api.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.frankmoley.lil.api.web.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class CustomerControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllCustomers() throws Exception{
        this.mockMvc.perform(get("/customers")).andExpect(status().isOk())
                .andExpect(content().string(containsString("054b145c-ddbc-4136-a2bd-7bf45ed1bef7")))
                .andExpect(content().string(containsString("38124691-9643-4f10-90a0-d980bca0b27d")));
    }
    @Test
    void getCustomer() throws Exception{
        this.mockMvc.perform(get("/customers/054b145c-ddbc-4136-a2bd-7bf45ed1bef7")).andExpect(status().isOk())
                .andExpect(content().string(containsString("054b145c-ddbc-4136-a2bd-7bf45ed1bef7"))) ;
    }

    @Test
    void getCustomer_notFound() throws Exception{
        this.mockMvc.perform(get("/customers/2b31469c-da3d-469f-9900-d00b5e4e352f")).andExpect(status().isNotFound());
    }
    @Test
    void addCustomer() throws Exception{
        Customer customer = new Customer("054b145c-ddbc-4136-a2bd-7bf45ed1bef7", "John", "Doe", "jDoe2@test.com", "111-222-3456", "6th Street of Austin");
        ObjectMapper mapper = new  ObjectMapper();
        String jsonString = mapper.writeValueAsString(customer);
        this.mockMvc.perform(get("/customers").content(jsonString).contentType("application/json")).andExpect(status().isOk());
    }
    @Test
    void updateCustomer() throws Exception{
        Customer customer = new Customer("c04ca077-8c40-4437-b77a-41f510f3f185","Jack","Bower","quam.quis.diam@facilisisfacilisis.org","(831) 996-1240","2 Rockefeller Avenue, Waco, TX 76796");
        ObjectMapper mapper = new  ObjectMapper();
        String jsonString = mapper.writeValueAsString(customer);
        this.mockMvc.perform(put("/customers/c04ca077-8c40-4437-b77a-41f510f3f185").content(jsonString).contentType("application/json")).andExpect(status().isOk())
                .andExpect(content().string(containsString("Jack")))
                .andExpect(content().string(containsString("Bower")));
    }

    @Test
    void updateCustomer_badRequest() throws Exception{
        Customer customer = new Customer("c04ca077-8c40-4437-b77a-41f510f3f185","Jack","Bower","quam.quis.diam@facilisisfacilisis.org","(831) 996-1240","2 Rockefeller Avenue, Waco, TX 76796");
        ObjectMapper mapper = new  ObjectMapper();
        String jsonString = mapper.writeValueAsString(customer);
        this.mockMvc.perform(put("/customers/054b145c-ddbc-4136-a2bd-7bf45ed1bef7").content(jsonString).contentType("application/json")).andExpect((status().isBadRequest()));
        }
    @Test
    void deleteCustomer() throws Exception {
        this.mockMvc.perform(delete("/customers/054b145c-ddbc-4136-a2bd-7bf45ed1bef7")).andExpect(status().isResetContent());
    }
}
