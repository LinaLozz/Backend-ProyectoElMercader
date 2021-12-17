package com.reto4;

import com.reto4.repository.crud.ClientInterface;
import com.reto4.repository.crud.GadgetInterface;
import com.reto4.repository.crud.OrderInterface;
import com.reto4.repository.crud.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto4Application implements CommandLineRunner {
    @Autowired
    private GadgetInterface gadgetInterface;
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private OrderInterface orderInterface;
    @Autowired
    private ClientInterface clientInterface;
    public static void main(String[] args) {
        SpringApplication.run(Reto4Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        gadgetInterface.deleteAll();
        userInterface.deleteAll();
        orderInterface.deleteAll();
        clientInterface.deleteAll();
    }
}
