package com.reto4.repository;

import com.reto4.repository.crud.UserInterface;
import com.reto4.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * 
 * @author linal
 */

@Repository
public class UserRepository {
    @Autowired
    private UserInterface userCrudRepository;
    
    /**
     * Trae todos los usuarios
     * @return User
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    /**
     * select * from table where ID=id
     * buscar usuario por id
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    
    /**
     * crea un nuevo usuario POST
     * @param user
     * @return usuario nuevo
     */
    public User create(User user) {
        return userCrudRepository.save(user);
    }
    
    /**
     * Actualiza el usuario PUT
     * @param user 
     */
    public void update(User user) {
        userCrudRepository.save(user);
    }
    
    /**
     * Borra el usuario
     * @param user 
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }
    
    /**
     * Metodo que verifica si el email existe
     * @param email
     * @return 
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }
    
    /**
     * Metodo para autenticar usuario
     * @param email
     * @param password
     * @return email y password
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    /**
     * Encuentra un usuario por fecha
     * @param month
     * @return Month 
     */
    public List<User>findByMonth(String month){
       return userCrudRepository.findByMonth(month);
    }
}
