package com.usa.c4reto01;
import com.usa.c4reto01.crud.HairProductCrudRepository;
import com.usa.c4reto01.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
@Component
@SpringBootApplication
public class C4reto01Application implements CommandLineRunner {
    @Autowired
    private HairProductCrudRepository hairProductCrudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;
	public static void main(String[] args) {
		SpringApplication.run(C4reto01Application.class, args);
	}
    @Override
	    public void run(String... args) throws Exception {
	        hairProductCrudRepository.deleteAll();
	        userCrudRepository.deleteAll();
	    }

}
