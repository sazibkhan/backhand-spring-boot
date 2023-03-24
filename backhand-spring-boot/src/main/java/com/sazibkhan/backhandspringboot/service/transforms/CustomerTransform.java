package com.sazibkhan.backhandspringboot.service.transforms;


import com.sazibkhan.backhandspringboot.dto.response.CustomerRest;
import com.sazibkhan.backhandspringboot.entity.CustomerEntity;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerTransform {

    public  static CustomerRest toCustomerRest(CustomerEntity  customerEntity){
        var rest =new CustomerRest();
        BeanUtils.copyProperties(customerEntity,rest);
        return rest;
    }

    public  static List<CustomerRest> tpCustomerRestList(List<CustomerEntity>  list){
        return list.stream()
                .map(CustomerTransform::toCustomerRest)
                .collect(Collectors.toList());
    }
}
