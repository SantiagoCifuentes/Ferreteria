package com.co.sofka.Ferreteria.repositories;

import com.co.sofka.Ferreteria.models.Factura;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends ReactiveMongoRepository <Factura,String> {
}
