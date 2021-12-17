package com.reto4.repository.crud;

import com.reto4.model.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.Query;

public interface UserInterface extends MongoRepository<User, Integer> {
    @Query("{email:?0}")
    Optional<User> findByEmail(String email);
    
    @Query("{email:?0}/{password:?1}")
    Optional<User> findByEmailAndPassword(String email,String password);
    
    @Query("{monthBirthtDay:?0}")
    List<User> findByMonth(String month);
}
