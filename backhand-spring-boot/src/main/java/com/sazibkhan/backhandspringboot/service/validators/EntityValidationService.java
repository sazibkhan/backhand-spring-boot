package com.sazibkhan.backhandspringboot.service.validators;
import com.sazibkhan.backhandspringboot.entity.BrandEntity;
import com.sazibkhan.backhandspringboot.entity.CustomerEntity;
import com.sazibkhan.backhandspringboot.entity.ProductEntity;
import com.sazibkhan.backhandspringboot.repository.BrandRepository;
import com.sazibkhan.backhandspringboot.repository.CustomerRepository;
import com.sazibkhan.backhandspringboot.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@AllArgsConstructor
public class  EntityValidationService {
    private final ProductRepository productRepository;
    private  final BrandRepository brandRepository;
    private  final CustomerRepository customerRepository;

    public ProductEntity validateProduct(Long id) {
        Objects.requireNonNull(id);
        return productRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException(String
                        .format("Product not found with id [%s]", id)));
    }


    public BrandEntity validateBrand(Long id) {
        Objects.requireNonNull(id);
        return brandRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException(String
                        .format("Brand not found with id [%s]", id)));
    }

    public CustomerEntity validateCustomer(Long id) {
        Objects.requireNonNull(id);
        return customerRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException(String
                        .format("Customer not found with id [%s]", id)));
    }


}
