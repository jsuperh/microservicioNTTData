package com.microservicio.microservicio.controller;


import com.microservicio.microservicio.model.entity.Producto;
import com.microservicio.microservicio.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;


    @GetMapping("/listado")
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> getAllProducts(){
        return productoRepository.findAll();
    }

    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public void createProduc(@RequestBody Producto producto){
        productoRepository.save(producto);
    }





}
