package com.example.customer.Controllers;

import com.example.customer.Model.Customer;
import com.example.customer.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class HomeController {
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
