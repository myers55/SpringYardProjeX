package com.example.customer.Service;

import com.example.customer.Model.Customer;
import com.example.customer.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CustomerServiceimpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    @Override
    public void add(Customer customer) {

        customerRepository.add(customer);
    }

    @Transactional
    @Override
    public void add(List<Customer> people) {
        for (Customer customer : people) {
            customerRepository.add(customer);
        }
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.getById(id);
    }

    @Override
    public List<Customer> get() {
        return customerRepository.get();
    }

    @Transactional
    @Override
    public void update(Customer customer) {

        customerRepository.update(customer);
    }

    @Transactional
    @Override
    public void delete(int id) {

        customerRepository.delete(id);
    }

    @Override
    public void deleteAll(List<Integer> ids) {

    }

}
