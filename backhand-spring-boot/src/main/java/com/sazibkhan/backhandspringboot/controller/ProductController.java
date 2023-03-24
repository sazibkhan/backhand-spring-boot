package com.sazibkhan.backhandspringboot.controller;
import com.sazibkhan.backhandspringboot.dto.request.BrandDTO;
import com.sazibkhan.backhandspringboot.dto.request.ProductDTO;
import com.sazibkhan.backhandspringboot.dto.response.ProductRest;
import com.sazibkhan.backhandspringboot.factory.ResponseFactory;
import com.sazibkhan.backhandspringboot.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ProductController {

    private  final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createNewBrand(@RequestBody @Valid ProductDTO productDTO) {
        return ResponseFactory.saveResponse( productService.createNewProduct(productDTO));
    }
    @GetMapping
    public ResponseEntity<?> getCustomerList() {
        return ResponseFactory.restResponse(productService.getProductList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        return ResponseFactory.saveResponse(productService.getProductById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductDTO productDTO) {
        return ResponseFactory.updateResponse(productService.updateProduct(id, productDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseFactory.deleteResponse();
    }




}
