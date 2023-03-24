package com.sazibkhan.backhandspringboot.dto.request;

import lombok.Data;

@Data
public class ProductDTO {

    private String productName;
    private Double purchasePrice;
    private Double salesPrice;
    private Long brandId;
}
