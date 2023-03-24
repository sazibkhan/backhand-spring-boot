package com.sazibkhan.backhandspringboot.service.transforms;

import com.sazibkhan.backhandspringboot.dto.response.BrandRest;
import com.sazibkhan.backhandspringboot.entity.BrandEntity;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BrandTransform {

    public static BrandRest toBrandRest(BrandEntity brandEntity) {
        var rest = new BrandRest();
        BeanUtils.copyProperties(brandEntity, rest);
        return rest;
    }

    public static List<BrandRest> toBrandRestList(List<BrandEntity> list) {
        return list.stream()
                .map(BrandTransform::toBrandRest)
                .collect(Collectors.toList());
    }

}
