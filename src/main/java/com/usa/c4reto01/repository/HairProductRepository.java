/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.c4reto01.repository;

import com.usa.c4reto01.crud.HairProductCrudRepository;
import com.usa.c4reto01.model.HairProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alberto
 */
@Repository
public class HairProductRepository {
    @Autowired
    private HairProductCrudRepository repository;
    
    
    /**
     * 
     * @return 
     */
    public List<HairProduct> getAll(){
        return (List<HairProduct>) repository.findAll();
    }
    
    public Optional<HairProduct> getByReference(String reference){
        return repository.findById(reference);
    }
 
    
    public HairProduct save(HairProduct hairProduct){
        return repository.save(hairProduct);
    }
    
    public void update(HairProduct product) {
        repository.save(product);
    }

    
    public void delete(HairProduct product){
        repository.delete(product);
    }
}
