package com.microservicio.microservicio.controller;


import com.microservicio.microservicio.model.entity.Producto;
import com.microservicio.microservicio.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    //Instancia de Slf4j para esta clase
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @GetMapping("/listado")
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> getAllProducts(){
        LOGGER.info("Hizo la petición de listado");
        return productoRepository.findAll();
    }

    @PostMapping("/nuevo")
    @ResponseStatus(HttpStatus.OK)
    public void createProduc(@RequestBody Producto producto){
        LOGGER.info("Hizo la petición de nuevo");
        productoRepository.save(producto);
    }

    @GetMapping("/obtener/{idProducto}")
    public ResponseEntity<Producto> getProduct(@PathVariable(value = "idProducto") String idProducto) {
        LOGGER.info("Hizo la petición de obtener por Id");
        Optional<Producto> producto = productoRepository.findById(idProducto);
        if(producto.isPresent()){
            return new ResponseEntity<>(producto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(producto.get(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("eliminar/{idProducto}")
    public String deleteProduct(@PathVariable(value = "idProducto")String idProducto) {
        LOGGER.info("Hizo la petición eliminar por Id");
        productoRepository.deleteById(idProducto);
        return "Se eliminó correctamente el producto";
    }

    @PutMapping("/actualizar/{idProducto}")
    public Producto updateProduct(@RequestBody Producto producto, @PathVariable(value = "idProducto") String idProducto){
        LOGGER.info("Hizo la petición actualizar por Id");
        producto.setIdProducto(idProducto);
        productoRepository.save(producto);
        return producto;
    }


}
