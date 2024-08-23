package com.frankmoley.lil.api.service;

import com.frankmoley.lil.api.web.error.ConflictException;
import com.frankmoley.lil.api.web.error.NotFoundException;
import com.frankmoley.lil.api.web.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class CustomerServiceIntegrationTest {
@Autowired
    CustomerService service;
@Test
    void GetAllCustomers(){
    List<Customer> customers = this.service.getAllCustomers();
    assertEquals(5, customers.size());
}
@Test
void getCustomer(){
    Customer customer = this.service.getCustomer("054b145c-ddbc-4136-a2bd-7bf45ed1bef7");
    assertNotNull(customer);
    assertEquals("Cally", customer.getFirstName());
}
    @Test
    void getCustomer_NotExist(){
       assertThrows(NotFoundException.class,()->this.service.getCustomer("054b145c-ddbc-4136-a2bd-7bf45ed1beff"));

    }
    @Test
    void addCustomer(){
    Customer customer = new Customer("", "John", "Doe", "jDoe2@test.com", "111-222-3456", "6th Street of Austin");
    customer = this.service.addCustomer(customer);
    assertTrue(StringUtils.isNotBlank(customer.getCustomerId()));
    assertEquals("John", customer.getFirstName());
    this.service.deleteCustomer(customer.getCustomerId());
    }
    @Test
    void addCustomer_alreadyExists(){
    Customer customer = new Customer("", "John", "Doe", "penatibus.et@lectusa.com", "111-222-3456", "6th Street of Austin");
    assertThrows(ConflictException.class, ()-> this.service.addCustomer(customer));
    }
    @Test
    void updateCustomer(){
    Customer customer = new Customer("", "John", "Doe", "jDoe1@test.com", "111-222-3456", "6th Street of Austin");
    customer = this.service.addCustomer(customer);
    customer.setFirstName("Jane");
    customer = this.service.updateCustomer(customer);
    assertEquals("Jane", customer.getFirstName());
    //Cleaning up
        this.service.deleteCustomer(customer.getCustomerId());
    }
}
