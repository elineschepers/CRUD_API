package com.example.springbootcrudrestfulapi.controller;

import com.example.springbootcrudrestfulapi.exception.ResourceNotFoundException;
import com.example.springbootcrudrestfulapi.model.Product;
import com.example.springbootcrudrestfulapi.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/all")
    public List<Product> getProducts()
    {
        return productRepo.findAll();
    }

    @PostMapping("/create")
    public Product createProduct(@Validated @RequestBody Product product)
    {
        return productRepo.save(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        Product p = productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("this product doesn't exist"));
        //System.out.println(p.getPrice());
        //System.out.println(productRepo.count());
        return ResponseEntity.ok().body(p);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> editProduct(@PathVariable(value = "id") int id, @RequestBody Product pDetails) throws ResourceNotFoundException {
        Product p = productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("this product doesn't exist"));
        if(pDetails!=null&&pDetails.getName()!= null){
            p.setName(pDetails.getName());}
        if(pDetails!=null&&pDetails.getPrice() > 0){
            //System.out.println("ik kom hier");
            p.setPrice(pDetails.getPrice());
            //System.out.println(productRepo.getOne(id).getPrice());
            }
        if(pDetails!=null&&pDetails.getDescription() != null){ p.setDescription(pDetails.getDescription());}
        final Product updatedProduct = productRepo.save(p);
        return ResponseEntity.ok().body(updatedProduct);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("this product doesn't exist"));

        productRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
