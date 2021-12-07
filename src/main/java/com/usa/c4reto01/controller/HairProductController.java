/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.c4reto01.controller;

import com.usa.c4reto01.model.HairProduct;

import com.usa.c4reto01.service.HairProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alberto
 */
@RestController
@RequestMapping("hairproducts")
@CrossOrigin("*")
public class HairProductController {
    @Autowired
    private HairProductService service;
    
    @GetMapping("/all")
    public List<HairProduct> getAll(){
      return service.getAll();
    }
    
    @PostMapping("/new")   
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct save(@RequestBody HairProduct product){
        return service.save(product);
    }
    
    @PutMapping("/update")   
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct update(@RequestBody HairProduct product){
        return service.update(product);
    }
    
  
    
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return service.delete(reference);
    }
    
  
}
