
package com.reto4.controller;

import com.reto4.model.Client;
import com.reto4.service.ClientService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author linal
 */
@RestController
@RequestMapping("/api/client")//le damos una URL base, no importa si lleva o no el / antes
@CrossOrigin(origins = "*",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientController {
    
    @Autowired
    private ClientService service;
    
    @GetMapping("/all")
    public List<Client> getClient(){
        return service.getAll();
    }

    /**
     * obtenemos el get con Id, le indicamos que le vamos a pasar un parámetro
     * @param id pasamos el Id por parámetro a la variable adminId
     * @return 
     */
    @GetMapping("/{id}")         
    public Optional<Client> getById(@PathVariable("id") int id){
        return service.getById(id);
    }

    @GetMapping("/{email}/{password}")
    private Client getByEmailAndPassword(@PathVariable("email") String email,@PathVariable("password") String password){
        return service.getByEmailAndPassword(email,password);
    }

    @GetMapping("/emailexist/{email}")
    private boolean getByEmail(@PathVariable("email") String email){
        return  service.getByEmail(email);
    }
    
    /**
     * este es el Post
     * @param client
     * @return 
     */
    @PostMapping("/new")
    public ResponseEntity save(@RequestBody Client client){
        return new ResponseEntity (service.save(client), HttpStatus.CREATED);
    }
    
    /**
     * @RequestBody significa requiéralo del cuerpo de la consulta
     * este es el put
     * @param client
     * @return client
     */
    @PutMapping("/update")
    public ResponseEntity<Client> update(@RequestBody Client client){
        return new ResponseEntity(service.update(client),HttpStatus.CREATED);
    }
    
/**estos dos métodos son lo mismo, se puede usar el @ResponseStatus(HttpStatus....) o el
 * ResponseEntity(HttpStatus....);
 * @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//Retorna Status 204
    public void delete(@PathVariable("id") Integer UsuarioId){
    * (con @PathVariable le indicamos que le vamos a enviar una variable a través del parámetro)
         service.delete(UsuarioId);
    }
*/
    /**
     * Metodo Delete
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}