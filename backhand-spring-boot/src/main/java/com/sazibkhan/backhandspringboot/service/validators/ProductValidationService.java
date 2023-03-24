package com.sazibkhan.backhandspringboot.service.validators;

import com.sazibkhan.backhandspringboot.dto.I18NService;
import com.sazibkhan.backhandspringboot.entity.BrandEntity;
import com.sazibkhan.backhandspringboot.entity.CustomerEntity;
import com.sazibkhan.backhandspringboot.entity.ProductEntity;
import com.sazibkhan.backhandspringboot.exception.ResourceNotFoundException;
import com.sazibkhan.backhandspringboot.repository.CustomerRepository;
import com.sazibkhan.backhandspringboot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductValidationService {
    private final ProductRepository productRepository;
    private  final I18NService i18NService;
    public ProductEntity ifFoundByIdReturnElseThrow(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(i18NService
                        .getMessage("Product.Not.Found.ById")));
    }

}
