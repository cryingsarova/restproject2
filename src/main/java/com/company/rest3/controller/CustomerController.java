package com.company.rest3.controller;


import com.company.rest3.domain.Customer;
import com.company.rest3.repo.CustomerRepo;
import org.apache.catalina.connector.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/buyer")
public class CustomerController {

    private final CustomerRepo customerRepo;

    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping
    public List<Customer> list(){
        return customerRepo.findAll();
    }

    @GetMapping("{id}")
    public Customer getOne(@PathVariable("id") Customer customer){
        return customer;
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Customer customer){
        customerRepo.save(customer);
        return new ResponseEntity<>("Added successfully", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteOne(@PathVariable("id") int id){
        customerRepo.deleteById(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Object> delete(){
        customerRepo.deleteAll();
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }


}
