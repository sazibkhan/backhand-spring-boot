package com.sazibkhan.backhandspringboot.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "brands")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "brand_name")
    private String brandName;


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
