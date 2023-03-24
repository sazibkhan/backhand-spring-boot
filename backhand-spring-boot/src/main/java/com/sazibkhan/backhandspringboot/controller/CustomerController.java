package com.sazibkhan.backhandspringboot.controller;

import com.sazibkhan.backhandspringboot.dto.request.BrandDTO;
import com.sazibkhan.backhandspringboot.dto.request.CustomerDTO;
import com.sazibkhan.backhandspringboot.dto.response.CustomerRest;
import com.sazibkhan.backhandspringboot.factory.ResponseFactory;
import com.sazibkhan.backhandspringboot.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @PostMapping
    public ResponseEntity<?> createNewCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        return ResponseFactory.saveResponse(customerService.createNewCustomer(customerDTO));
    }
    @GetMapping
    public ResponseEntity<?> getCustomerList() {
        return ResponseFactory.restResponse(customerService.getCustomerList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        return ResponseFactory.saveResponse(customerService.getCustomerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody @Valid CustomerDTO customerDTO) {
        return ResponseFactory.updateResponse(customerService.updateCustomer(id, customerDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseFactory.deleteResponse();
    }









}
