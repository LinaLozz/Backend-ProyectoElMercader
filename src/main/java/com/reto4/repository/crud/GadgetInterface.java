package com.reto4.repository.crud;

import com.reto4.model.Gadget;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface GadgetInterface extends MongoRepository<Gadget, Integer> {
    //filtra los productos por una cadena de caracteres
    @Query("{ description : { $regex : ?0 } }")
    List<Gadget> getGadgetByDescription(final String description);

     //filtra los productos por un precio menor que, para menor que es lt, para mayor que es gte
    @Query("{ price : { $lt: ?0 } }")
    List<Gadget> getGadgetByPrice(final double price);

}
