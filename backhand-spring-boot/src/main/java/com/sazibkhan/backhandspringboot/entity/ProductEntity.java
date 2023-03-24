package com.sazibkhan.backhandspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name="products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "product_name")
    private String productName;


    @ManyToOne
    @JoinColumn(
            name = "brand_id",
            foreignKey = @ForeignKey(
                    name = "products_brand_fk"
            )
    )
    private BrandEntity brand;

    @Column(name = "brand_id", insertable = false, updatable = false)
    private Long brandId;

    @Column(name = "purchase_price")
    private Double purchasePrice;

    @Column(name = "sales_price")
    private Double salesPrice;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "update_by")
    private String updateBy;


    @Column(name = "deleted")
    private Boolean deleted = Boolean.FALSE;
}
