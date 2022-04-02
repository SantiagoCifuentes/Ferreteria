package com.co.sofka.Ferreteria.repositories;

import com.co.sofka.Ferreteria.models.Productos;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductosRepository extends ReactiveMongoRepository<Productos,String>
{

}
