package com.microservicio.microservicio.repository;

import com.microservicio.microservicio.model.entity.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String> {
}
