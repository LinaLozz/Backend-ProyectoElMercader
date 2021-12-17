
package com.reto4.service;

import com.reto4.model.Client;
import com.reto4.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author linal
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository service;
    
    /*Este sería el Get y nos retorna una lista de clientes*/
    public List<Client> getAll(){
        return service.getAll();
    }

    /*Este sería el Get con Id*/
    public Optional<Client> getById(int ClienteId){
        return service.getById(ClienteId);
    }

    public Client save(Client client) {

        //obtiene el maximo id existente en la coleccion
        Optional<Client> clientIdMaximo = service.lastClientId();
        
        if (client.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (!clientIdMaximo.isPresent())
                client.setId(1);
                //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo del usuario
            else
                client.setId(clientIdMaximo.get().getId() + 1);
        }

        Optional<Client> e = service.getById(client.getId());
        if (!e.isPresent()) {
            if (getByEmail(client.getEmail())==false){
                return service.save(client);
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public Client update(Client client){
        //si el Id no es null, es decir existe
        if(client.getId()!=null){
            //obtener el cliente por id,creamos un objeto de la clase Optional de java.util y obtenemos el usuario
            Optional<Client> existClient= service.getById(client.getId());
            //comprobamos que los campos no sean null y los modifica por los nuevos
            if(existClient.isPresent()){
                if(client.getName()!=null){
                    existClient.get().setName(client.getName());
                }
                if(client.getEmail()!=null){
                    existClient.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    existClient.get().setPassword(client.getPassword());
                }
                if(client.getIdentification()!=null){
                    existClient.get().setIdentification(client.getIdentification());
                }

                if(client.getAddress()!=null){
                    existClient.get().setAddress(client.getAddress());
                }
                if(client.getCellPhone()!=null){
                    existClient.get().setCellPhone(client.getCellPhone());
                }
                if(client.getZone()!=null){
                    existClient.get().setZone(client.getZone());
                }
                if(client.getType()!=null){
                    existClient.get().setType(client.getType());
                }

                //retorne los datos con el update implementado
                return service.save(existClient.get());

            }else{//si hay datos null retorna los datos recibidos
                return client;
            }

        }else{//si no se envío el Id retorne los datos enviados
            return client;
        }
    }
    
    /*este sería el Delete*/
    public void delete(Integer ClientId){
        //si obtiene el id, lo borramos y retornamos true
        Optional<Client> ov= service.getById(ClientId);
        if(ov.isPresent()){
            service.delete(ov.get());
        }


    }
    public Client getByEmailAndPassword(String email, String password){
        Optional<Client> cliente= service.getByEmailAndPassword(email,password);
        if(cliente.isPresent()){
            return cliente.get();
        }else{//si la combinación no existe
            Client client = new Client();
            client.setPassword(password);
            client.setEmail(email);
            client.setName("NO DEFINIDO");
            return client;
        }
    }
    public boolean getByEmail(String email){
        Optional<Client> client = service.getByEmail(email);
        if(client.isPresent()){
            return true;
        }else{
            return false;
        }
    }
    
}
