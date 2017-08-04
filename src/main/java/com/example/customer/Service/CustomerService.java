package com.example.customer.Service;

import com.example.customer.Model.Customer;

import java.util.List;

public interface CustomerService {
    void add(Customer customer);
    void add(List<Customer> people);
    Customer getById(int id);
    List<Customer> get();
    void update(Customer customer);
    void delete(int id);


    void deleteAll(List<Integer> ids);
}
