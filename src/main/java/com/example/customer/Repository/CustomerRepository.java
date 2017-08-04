package com.example.customer.Repository;

import com.example.customer.Model.Customer;

import java.util.List;

public interface CustomerRepository {
    void add(Customer customer);
    Customer getById(int id);
    List<Customer> get();
    void update(Customer customer);
    void delete(int id);


    void deleteAll(List<Integer> ids);
}
