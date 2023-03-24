package com.sazibkhan.backhandspringboot.service;

import com.sazibkhan.backhandspringboot.dto.request.CustomerDTO;
import com.sazibkhan.backhandspringboot.dto.response.CustomerRest;
import com.sazibkhan.backhandspringboot.entity.CustomerEntity;
import com.sazibkhan.backhandspringboot.repository.CustomerRepository;
import com.sazibkhan.backhandspringboot.service.transforms.BrandTransform;
import com.sazibkhan.backhandspringboot.service.transforms.CustomerTransform;
import com.sazibkhan.backhandspringboot.service.validators.CustomerValidationService;
import com.sazibkhan.backhandspringboot.service.validators.EntityValidationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerValidationService customerValidationService;
    private final Environment environment;

    public CustomerRest createNewCustomer(CustomerDTO customerDTO) {
        var customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customerDTO, customerEntity);
        customerRepository.save(customerEntity);
        return CustomerTransform.toCustomerRest(customerEntity);
    }

    public List<CustomerRest> getCustomerList() {
        return customerRepository.findAll().stream()
                .map(itm -> {
                    var res = new CustomerRest();
                    BeanUtils.copyProperties(itm, res);
                    return res;
                }).collect(Collectors.toList());
    }
    public CustomerRest getCustomerById(Long id) {
        var customerEntity = customerValidationService.ifFoundByIdReturnElseThrow(id);
        var response = new CustomerRest();
        BeanUtils.copyProperties(customerEntity, response);
       return  response;
    }
    public CustomerRest updateCustomer(Long id, CustomerDTO customerDto) {
        var customerEntity = customerValidationService.ifFoundByIdReturnElseThrow(id);
        BeanUtils.copyProperties(customerDto, customerEntity);
        customerRepository.save(customerEntity);
        return CustomerTransform.toCustomerRest(customerEntity);
    }

    public void deleteCustomer(Long id) {
        var customerEntity = customerValidationService.ifFoundByIdReturnElseThrow(id);
        customerEntity.setDeleted(Boolean.TRUE);
        customerRepository.save(customerEntity);
    }



}
