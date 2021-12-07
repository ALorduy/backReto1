/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usa.c4reto01.crud;

import com.usa.c4reto01.model.HairProduct;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author alberto
 */
public interface HairProductCrudRepository extends MongoRepository <HairProduct,String> {
    
}
