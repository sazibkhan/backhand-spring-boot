package com.sazibkhan.backhandspringboot.service;

import com.sazibkhan.backhandspringboot.dto.request.BrandDTO;
import com.sazibkhan.backhandspringboot.dto.response.BrandRest;
import com.sazibkhan.backhandspringboot.entity.BrandEntity;
import com.sazibkhan.backhandspringboot.repository.BrandRepository;
import com.sazibkhan.backhandspringboot.service.transforms.BrandTransform;
import com.sazibkhan.backhandspringboot.service.validators.BrandValidationService;
import com.sazibkhan.backhandspringboot.service.validators.EntityValidationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.core.env.Environment;

import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class BrandService {
    private final BrandRepository brandRepository;
    private final BrandValidationService brandValidationService;
    private final Environment environment;


    public BrandRest createNewBrand(BrandDTO brandDTO) {
        var brandEntity= new BrandEntity();
        BeanUtils.copyProperties(brandDTO,brandEntity);
        brandRepository.save(brandEntity);
        return BrandTransform.toBrandRest(brandEntity);
    }


    public BrandRest getBrandById(long id){
        var brandEntity=brandValidationService.ifFoundByIdReturnElseThrow(id);
        var response =new BrandRest();
        BeanUtils.copyProperties(brandEntity,response);
        return response;
    }


    public BrandRest updateBarnd(Long id, BrandDTO brandDto) {
        var brandEntity=brandValidationService.ifFoundByIdReturnElseThrow(id);
        brandEntity.setBrandName(brandDto.getBrandName());
        brandRepository.save(brandEntity);
        return BrandTransform.toBrandRest(brandEntity);
    }


    public void deleteBrand(Long id) {
        var brandEntity = brandValidationService.ifFoundByIdReturnElseThrow(id);
        brandEntity.setDeleted(Boolean.TRUE);
        brandRepository.save(brandEntity);
    }
    public List<BrandRest> getBrandList() {
        return brandRepository.findAll().stream()
                .map(itm -> {
                    var res = new BrandRest();
                    BeanUtils.copyProperties(itm, res);
                    return res;
                }).collect(Collectors.toList());
    }



}
