package com.microservicio.microservicio.model.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("producto")
@Data
@NoArgsConstructor
public class Producto {

    @Id
    private String idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private Double precioProducto;

}
