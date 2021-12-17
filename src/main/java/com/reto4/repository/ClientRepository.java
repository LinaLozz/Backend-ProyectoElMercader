
package com.reto4.repository;

import com.reto4.model.Client;
import com.reto4.repository.crud.ClientInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author linal
 */
@Repository
public class ClientRepository {
    @Autowired
    private ClientInterface repository;
//Listar o mostrar lista de clientes
    public List<Client> getAll(){
        return (List<Client>) repository.findAll();//busca todos los registros de la tabla admin
    }

    /*select * from table where ID=id
     * buscar cliente por id*/
    //devuelve algo opcional devuelve nulo o e valor

    public Optional<Client> getById(int id){
        return repository.findById(id);
    }

  //retorna el cliente si el mail y el password coinciden
    public Optional<Client> getByEmailAndPassword(String email, String password){
        return repository.findByEmailAndPassword(email,password);
    }
    //retorna el cliente si el email existe
    public Optional<Client> getByEmail(String  email){
        return repository.findByEmail(email);
    }

    /*Insert y Update
     * actualiza cliente o crea nuevo registro*/
    public Client save(Client client){
        return repository.save(client);
    }

    /*delete from table
    * Borrar cliente*/
    public void delete(Client client){
        repository.delete(client);
    }

    public Optional<Client> lastClientId(){
        return repository.findTopByOrderByIdDesc();
    }
}