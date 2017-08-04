package com.example.customer.common;

import com.example.customer.Model.Customer;

import java.util.List;

public class CustomerUtils {
    public static Customer createTestCustomer() {
        // Get unique names every time this test runs
        String firstName = Long.toString(System.currentTimeMillis());
        String lastName = Long.toString(System.currentTimeMillis());

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return customer;
    }


    public static Customer findInList(List<Customer> people, String first, String last) {
        // Find the new person in the list
        boolean found = false;
        for (Customer customer : people) {
            if (customer.getFirstName().equals(first) && customer.getLastName().equals(last)) {
                return customer;
            }
        }
        return null;
    }
}
