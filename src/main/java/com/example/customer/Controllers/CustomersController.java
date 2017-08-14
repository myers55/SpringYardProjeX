package com.example.customer.Controllers;

import com.example.customer.Model.Customer;
import com.example.customer.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomersController {
    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(path = "/customers", method = RequestMethod.GET)
    public String customers(Model model){
        List<Customer> customers = customerRepository.findAll();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @RequestMapping(path = "/customers/add", method = RequestMethod.GET)
    public String customersAdd(){


        return "customers-add";
    }
    @Secured({"ROLE_REGULAR_USER", "ROLE_ADMIN"})
    @RequestMapping(path = "/customers", method = RequestMethod.POST)
    public String customersAdd(@ModelAttribute Customer customer){
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @RequestMapping(path = "/customers/{id}", method = RequestMethod.GET)
    public String customer(@PathVariable ("id") int id, Model model){
        Customer customer = customerRepository.findOne(id);
        model.addAttribute("customer", customer);

        return "customer";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

//    @RequestMapping(path = "/customers", method = RequestMethod.GET)
//    public String customers(Model model){
//        List<Customer> customerList;
//
//    }
//
//    public static List<Customer> getCustomers(String route){
//        RestTemplate restTemplate = new RestTemplate();
//        CustomerService response = restTemplate.getForObject(route, CustomerService.class);
//        return response.getById(Customer);
//    }
private void showPrinciple() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    System.out.println("\n\n\n ===========>");
    System.out.println("name " + authentication.getName());
    System.out.println("details " + authentication.getDetails());
    System.out.println("authorties " + authentication.getAuthorities());
    System.out.println("credentials " + authentication.getCredentials());
    System.out.println("principal " + authentication.getPrincipal());
    System.out.println("is authenticated " + authentication.isAuthenticated());
}
}
