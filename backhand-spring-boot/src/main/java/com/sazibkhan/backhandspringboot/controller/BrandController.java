package com.sazibkhan.backhandspringboot.controller;
import com.sazibkhan.backhandspringboot.dto.request.BrandDTO;
import com.sazibkhan.backhandspringboot.dto.response.BrandRest;
import com.sazibkhan.backhandspringboot.entity.core.RestResponse;
import com.sazibkhan.backhandspringboot.factory.ResponseFactory;
import com.sazibkhan.backhandspringboot.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin
@RestController
@RequestMapping("api/v1/brands")
@AllArgsConstructor
public class BrandController {
     private  final BrandService brandService;
    @PostMapping
    public ResponseEntity<?> createNewBrand(@RequestBody @Valid BrandDTO brandDTO) {
        return ResponseFactory.saveResponse(  brandService.createNewBrand(brandDTO));
    }
    @GetMapping
    public ResponseEntity<?> getBrandList() {
        return ResponseFactory.restResponse(brandService.getBrandList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBrandById(@PathVariable Long id) {
        return ResponseFactory.saveResponse(brandService.getBrandById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBrand(@PathVariable Long id, @RequestBody @Valid BrandDTO brandDTO) {
        return ResponseFactory.updateResponse(brandService.updateBarnd(id, brandDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id) {
        brandService.deleteBrand(id);
        return ResponseFactory.deleteResponse();
    }


}
