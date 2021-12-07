/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.c4reto01.service;

import com.usa.c4reto01.model.HairProduct;
import com.usa.c4reto01.repository.HairProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alberto
 */
@Service
public class HairProductService {
    @Autowired
    private HairProductRepository repository;
    
    public List<HairProduct>getAll(){
        return repository.getAll();
    }
    
    /**
     * 
     * @param product
     * @return 
     */
    
    public HairProduct save(HairProduct product){
        if(product.getReference()==null){
            return product;
        }else{
           
            Optional<HairProduct> existProduct = repository.getByReference(product.getReference());
                if (existProduct.isEmpty()){
                    return repository.save(product);
                }else{
                    return product;
                }
            
            }
    }
    
    public HairProduct update(HairProduct product){
        Optional<HairProduct> existsProduct=repository.getByReference(product.getReference());
        if(existsProduct.isPresent()){
            if(product.getReference()!=null){
                existsProduct.get().setReference(product.getReference());
            }
            if(product.getName()!=null){
                existsProduct.get().setName(product.getName());
            }
            if(product.getBrand()!=null){
                existsProduct.get().setBrand(product.getBrand());
            }
            if(product.getDescription()!=null){
                existsProduct.get().setDescription(product.getDescription());
            }
            if(product.getCategory()!=null){
                existsProduct.get().setCategory(product.getCategory());
            }
            if(product.getPhotography()!=null){
                existsProduct.get().setPhotography(product.getPhotography());
            }
            if(product.getPrice()!=0.0){
                existsProduct.get().setPrice(product.getPrice());
            }
            
            if(product.getQuantity()!=0){
                existsProduct.get().setQuantity(product.getQuantity());
            }
            
            existsProduct.get().setAvailability(product.isAvailability());
                
            return repository.save(existsProduct.get());
        }else{
            return product;
        }
        
    }
    
   
   public Optional<HairProduct> getHairProduct(String reference){
        return repository.getByReference(reference);
    }
   
    public boolean delete(String reference) {
        Boolean aBoolean = getHairProduct(reference).map(product -> {
            repository.delete(product);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
