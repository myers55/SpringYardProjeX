package com.example.customer.Service;

import com.example.customer.Model.Customer;
import com.example.customer.Repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.example.customer.common.CustomerUtils.createTestCustomer;
import static com.example.customer.common.CustomerUtils.findInList;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testAddGet() {
        // Get unique names every time this test runs
        String firstName = Long.toString(System.currentTimeMillis());
        String lastName = Long.toString(System.currentTimeMillis());

        Customer customer1 = new Customer();
        customer1.setFirstName(firstName);
        customer1.setLastName(lastName);
        customerRepository.save(customer1);

        List<Customer> people = customerRepository.findAll();

        Customer customer2 = findInList(people, firstName, lastName);
        Assert.assertNotNull(customer2);

        Customer customer3 = customerRepository.findOne(customer2.getId());
        Assert.assertNotNull(customer3);
        Assert.assertEquals(firstName, customer3.getFirstName());
        Assert.assertEquals(lastName, customer3.getLastName());
    }
    }

