package com.co.sofka.Ferreteria.repositories;

import com.co.sofka.Ferreteria.models.Volante;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolanteRepository  extends ReactiveMongoRepository<Volante,String>
{

}
