package com.reto4.controller;

import com.reto4.model.Order;
import com.reto4.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * 
 * @author linal
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id){
        return orderService.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order){
        return orderService.create(order);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return orderService.update(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return orderService.delete(id);
    }

    @GetMapping("/zona/{zone}")
    public  List<Order> getOrdersByZone(@PathVariable("zone") String zone){
        return orderService.getOrderByZone(zone);
    }

    @GetMapping("/salesman/{id}")
    public List<Order> getBySalesMAnId(@PathVariable("id") Integer id){
        return orderService.getBySalesManId(id);
    }

    @GetMapping("/state/{status}/{id}")
    public  List<Order> getBySalesManIdAndStatus(@PathVariable("status")String status, @PathVariable("id") Integer id){
        return orderService.getBySalesManIdAndStatus(id, status);
    }

    @GetMapping("/date/{registerDay}/{id}")
    public  List<Order> getByRegisterDayAndSalesManId(@PathVariable("registerDay") String registerDay, @PathVariable("id")Integer id){
        return orderService.getRegisterDayAndSalesManId(registerDay, id);
    }
}