/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.c4reto01.service;



import com.usa.c4reto01.model.User;
import com.usa.c4reto01.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alberto
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    /**
     * 
     * @return 
     */
    public List<User> getAll(){
        return repository.getAll();
    }
    /**
     * 
     * @param email
     * @return 
     */
    public boolean getUserByEmail(String email){
        return repository.getUserByEmail(email).isPresent();
    }
    
    public User getUserByEmailAndPassword(String email, String password){
        
        Optional<User> user = repository.getUserByEmailAndPassword(email,password);
        if(user.isPresent()){
            return user.get();
        }else{
            return new User(null,email,password,"NO DEFINIDO");
        }
    }
    /**
     * 
     * @param user
     * @return 
     */
    public User save(User user){
        if(user.getId()==null){
            List<User> existUsers = repository.getUserByNameOrEmail(user.getName(), user.getEmail());
            if(existUsers.isEmpty()){
                return repository.save(user);
            }else{
                return user;
            }
           
        }else{
           Optional<User> existUser = repository.getById(user.getId());
           if(existUser.isEmpty()){
                return repository.save(user);
            }else{
                return user;
            }
        }
    }
}