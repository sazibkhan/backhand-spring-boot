package com.sazibkhan.backhandspringboot.service.transforms;

import com.sazibkhan.backhandspringboot.dto.response.BrandRest;
import com.sazibkhan.backhandspringboot.dto.response.ProductRest;
import com.sazibkhan.backhandspringboot.entity.BrandEntity;
import com.sazibkhan.backhandspringboot.entity.ProductEntity;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ProductTransform {

    public static ProductRest toProductRest(ProductEntity productEntity) {
        var rest = new ProductRest();
        BeanUtils.copyProperties(productEntity, rest);
        return rest;
    }

    public static List<ProductRest> toProductRestList(List<ProductEntity> list) {
        return list.stream()
                .map(ProductTransform::toProductRest)
                .collect(Collectors.toList());
    }

}
