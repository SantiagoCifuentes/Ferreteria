package com.co.sofka.Ferreteria.repositories;

import com.co.sofka.Ferreteria.models.Asesor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AsesorRepository extends ReactiveMongoRepository<Asesor,String> {
}
