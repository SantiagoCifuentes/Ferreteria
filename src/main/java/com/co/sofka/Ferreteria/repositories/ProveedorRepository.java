package com.co.sofka.Ferreteria.repositories;

import com.co.sofka.Ferreteria.models.Proveedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends ReactiveMongoRepository<Proveedor,String> {
}
