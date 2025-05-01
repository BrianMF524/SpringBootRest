package com.application.rest.controller;


import com.application.rest.controller.dto.MakerDTO;
import com.application.rest.controller.dto.ProductDTO;
import com.application.rest.entities.Product;
import com.application.rest.repo.ProductRepo;
import com.application.rest.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/find")
    private ResponseEntity<?> getProducts(){
        List<ProductDTO> productDTOList=productService.findAll().stream().map(product ->
                ProductDTO.builder()
                        .price(product.getPrice())
                        .id(product.getId())
                        .name(product.getName())
                        .maker(product.getMaker()).build()).toList();
        return ResponseEntity.ok(productDTOList);
    }
    @GetMapping("/find/{id}")
    private ResponseEntity<?> getProductById(@PathVariable Long id){
        if(productService.findById(id).isPresent()){
            Product product=productService.findById(id).get();
            ProductDTO productDTO=ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .maker(product.getMaker())
                    .price(product.getPrice()).build();
            return ResponseEntity.ok(productDTO);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/save")
    private ResponseEntity<?> saveProduct(@RequestBody ProductDTO productDTO){
        if(!productDTO.getName().isEmpty()) {
            productService.save(Product.builder()
                    .maker(productDTO.getMaker())
                    .price(productDTO.getPrice())
                    .name(productDTO.getName())
                    .build());
        return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> deleteProduct(@PathVariable Long id){
        if (productService.findById(id).isPresent()){
            productService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/update/{id}")
    private ResponseEntity<?> updateProduct(@PathVariable Long id,@RequestBody ProductDTO productDTO){
        if(productService.findById(id).isPresent()){
            Product product =productService.findById(id).get();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setMaker(productDTO.getMaker());
            productService.save(product);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
