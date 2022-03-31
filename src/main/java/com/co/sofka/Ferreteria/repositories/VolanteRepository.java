package com.co.sofka.Ferreteria.repositories;

import com.co.sofka.Ferreteria.models.Volante;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VolanteRepository  extends ReactiveMongoRepository<Volante,String>
{

}
