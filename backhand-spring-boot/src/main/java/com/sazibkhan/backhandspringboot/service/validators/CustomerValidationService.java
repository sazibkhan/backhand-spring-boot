package com.sazibkhan.backhandspringboot.service.validators;

import com.sazibkhan.backhandspringboot.dto.I18NService;
import com.sazibkhan.backhandspringboot.entity.BrandEntity;
import com.sazibkhan.backhandspringboot.entity.CustomerEntity;
import com.sazibkhan.backhandspringboot.exception.ResourceNotFoundException;
import com.sazibkhan.backhandspringboot.repository.BrandRepository;
import com.sazibkhan.backhandspringboot.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerValidationService {

    private final CustomerRepository customerRepository;
    private  final I18NService i18NService;
    public CustomerEntity ifFoundByIdReturnElseThrow(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(i18NService
                        .getMessage("Customer.Not.Found.ById")));
    }
}
