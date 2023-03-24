package com.sazibkhan.backhandspringboot.service.validators;

import com.sazibkhan.backhandspringboot.dto.I18NService;
import com.sazibkhan.backhandspringboot.entity.BrandEntity;
import com.sazibkhan.backhandspringboot.exception.ResourceNotFoundException;
import com.sazibkhan.backhandspringboot.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandValidationService {
    private final BrandRepository brandRepository;
    private  final I18NService i18NService;
    public BrandEntity ifFoundByIdReturnElseThrow(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(i18NService
                        .getMessage("Brand.Not.Found.ById")));
    }



}
