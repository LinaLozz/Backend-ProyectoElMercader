
package com.reto4.repository.crud;

import com.reto4.model.Client;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author linal
 */
public interface ClientInterface extends MongoRepository<Client, Integer> {
    // @Query("select u from Cliente u where u.email=?1 and u.password=?2")

    @Query("{email:?0}/{password:?1}")
     Optional<Client> findByEmailAndPassword(String email, String password);

    //@Query("select u from Cliente u where u.email=?1")
    @Query("{email:?0}")
     Optional<Client>findByEmail(String email);

      //para seleccionar el cliente con id maximo o mayor y así poder enviar el id siguiente
      Optional<Client> findTopByOrderByIdDesc();
}
