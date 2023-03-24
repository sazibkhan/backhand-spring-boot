package com.sazibkhan.backhandspringboot.service;
import com.sazibkhan.backhandspringboot.dto.request.ProductDTO;
import com.sazibkhan.backhandspringboot.dto.response.ProductRest;
import com.sazibkhan.backhandspringboot.entity.ProductEntity;
import com.sazibkhan.backhandspringboot.repository.ProductRepository;
import com.sazibkhan.backhandspringboot.service.transforms.ProductTransform;
import com.sazibkhan.backhandspringboot.service.validators.BrandValidationService;
import com.sazibkhan.backhandspringboot.service.validators.EntityValidationService;
import com.sazibkhan.backhandspringboot.service.validators.ProductValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductValidationService productValidationService;
    private final BrandValidationService brandValidationService;
    public ProductRest createNewProduct(ProductDTO productDTO) {
        var productEntity = new ProductEntity();
        var brandEntity = brandValidationService.ifFoundByIdReturnElseThrow(productDTO.getBrandId());
        BeanUtils.copyProperties(productDTO, productEntity);
        productEntity.setBrand(brandEntity);
        productRepository.save(productEntity);
        return ProductTransform.toProductRest(productEntity);
    }
    public List<ProductRest> getProductList() {
            return productRepository.findAll().stream()
                    .map(itm->getProductRest(itm))
                    .sorted(Comparator.comparing(ProductRest::getProductName))
                    .collect(Collectors.toList());
    }
    public ProductRest getProductById(Long id) {
        var productEntity=productValidationService.ifFoundByIdReturnElseThrow(id);
        var responce=new ProductRest();
        BeanUtils.copyProperties(productEntity,responce);
        return ProductTransform.toProductRest(productEntity);
    }

    public ProductRest updateProduct(Long id,ProductDTO productDTO) {
        var productEntity=productValidationService.ifFoundByIdReturnElseThrow(id);
        var brandEntity = brandValidationService.ifFoundByIdReturnElseThrow(productDTO.getBrandId());
        productEntity.setProductName(productDTO.getProductName());
        productEntity.setBrand(brandEntity);
        productEntity.setPurchasePrice(productDTO.getPurchasePrice());
        productEntity.setSalesPrice(productDTO.getSalesPrice());
        productRepository.save(productEntity);
        return ProductTransform.toProductRest(productEntity);
    }
    public void deleteProduct(Long id) {
        var productEntity=productValidationService.ifFoundByIdReturnElseThrow(id);
        productEntity.setDeleted(Boolean.TRUE);
        productRepository.save(productEntity);
    }

    private ProductRest getProductRest(ProductEntity itm){
        var res=new ProductRest();
        BeanUtils.copyProperties(itm,res);
        Optional.ofNullable(itm.getBrand())
                .ifPresent(brand->{
                    res.setBrandId(brand.getId());
                });
        return res;
    }

}
