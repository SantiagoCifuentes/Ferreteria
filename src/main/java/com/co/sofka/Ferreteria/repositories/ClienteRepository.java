package com.co.sofka.Ferreteria.repositories;

import com.co.sofka.Ferreteria.dtos.ClienteDTO;
import com.co.sofka.Ferreteria.models.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends ReactiveMongoRepository<Cliente,String>
{

}
