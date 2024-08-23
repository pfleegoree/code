package com.frankmoley.lil.api.service;

import com.frankmoley.lil.api.data.entity.CustomerEntity;
import com.frankmoley.lil.api.data.repository.CustomerRepository;
import com.frankmoley.lil.api.web.error.ConflictException;
import com.frankmoley.lil.api.web.error.NotFoundException;
import com.frankmoley.lil.api.web.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class CustomerServiceTest {
    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Test
    void getAllCustomers(){
        Mockito.doReturn(getMockCustomers(2)).when(customerRepository).findAll();
        List<Customer> customers = this.customerService.getAllCustomers();
        assertEquals(2, customers.size());
    }
    private Iterable<CustomerEntity> getMockCustomers(int size){
        List<CustomerEntity> customers = new ArrayList<>(size);
        for(int i=0; i<size; i++){
            customers.add(new CustomerEntity(UUID.randomUUID(),
                    "firstName"+i, "lstName"+i,
                    "email"+i+"@test.com", "555-5555-0505",
                    "1234 Main Street"));


        }
        return customers;
    }
    @Test
    void getCustomer(){
        CustomerEntity entity = getMockCustomerEntity();
        Optional<CustomerEntity> optional = Optional.of(entity);
        Mockito.doReturn(optional).when(customerRepository).findById(entity.getCustomerId());

        Customer customer = this.customerService.getCustomer(entity.getCustomerId().toString());
        assertNotNull(customer);
        assertEquals("testFirst", customer.getFirstName());
    }
    @Test
    void getCustomer_NotExist(){
        CustomerEntity entity = getMockCustomerEntity();
        Optional<CustomerEntity> optional = Optional.empty();
        Mockito.doReturn(optional).when(customerRepository).findById(entity.getCustomerId());
        assertThrows(NotFoundException.class, () ->customerService.getCustomer(entity.getCustomerId().toString()));
    }
    @Test
    void findByEmailAddress(){
        CustomerEntity entity = getMockCustomerEntity();
        Optional<CustomerEntity> optional = Optional.of(entity);
        Mockito.doReturn(optional).when(customerRepository).findByEmailAddress(entity.getEmailAddress());

        Customer customer = this.customerService.findByEmailAddress(entity.getEmailAddress());
        assertNotNull(customer);
        assertEquals("testFirst", customer.getFirstName());
    }
    @Test
    void addCustomer_existing(){
        CustomerEntity entity = getMockCustomerEntity();
        when(customerRepository.findByEmailAddress(entity.getEmailAddress())).thenReturn(entity);
        Customer customer = new Customer(entity.getCustomerId().toString(), entity.getFirstName(), entity.getLastName(),
                entity.getEmailAddress(), entity.getPhoneNumber(), entity.getAddress());
       assertThrows(ConflictException.class, ()-> customerService.addCustomer(customer));
    }

    @Test
    void updateCustomer(){
        CustomerEntity entity = getMockCustomerEntity();
        when(customerRepository.save(any(CustomerEntity.class))).thenReturn(entity);
        Customer customer = new Customer(entity.getCustomerId().toString(), entity.getFirstName(), entity.getLastName(),
                entity.getEmailAddress(), entity.getPhoneNumber(), entity.getAddress());
        customer = customerService.updateCustomer(customer);
        assertNotNull(customer);
        assertNotNull("testLast", customer.getCustomerId());
    }

    @Test
    void deleteCustomer(){
        UUID    id = UUID.randomUUID();
        doNothing().when(customerRepository).deleteById(id);
        customerService.deleteCustomer(id.toString());
    }

    private CustomerEntity getMockCustomerEntity(){
        return new CustomerEntity(UUID.randomUUID(),
                "testFirst", "testLast",
                "email@test.com", "111-5555-0505",
                "1111 Main Street");
    }


}
