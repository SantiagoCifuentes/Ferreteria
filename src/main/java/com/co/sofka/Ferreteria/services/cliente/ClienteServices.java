package com.co.sofka.Ferreteria.services.cliente;

import com.co.sofka.Ferreteria.dtos.ClienteDTO;
import com.co.sofka.Ferreteria.models.Cliente;
import com.co.sofka.Ferreteria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServices
{
    @Autowired
    public ClienteRepository clienteRepository;

    public Mono<Cliente> agregarCliente(Cliente cliente)
    {
        return  clienteRepository.save(cliente);
    }



    public Mono<Cliente> actualizarCliente(String id, Cliente cliente)
    {
        return  clienteRepository.findById(id)
                .flatMap(cliente1 -> {
                    cliente1.setId(id);
                    return agregarCliente(cliente);
                }).switchIfEmpty(Mono.empty());
    }

    public Mono<Cliente> eliminarCliente(String id){
        return  clienteRepository .findById(id)
                .flatMap(cliente -> clienteRepository.deleteById(cliente.getId()).thenReturn(cliente));
    }


    public Flux<Cliente> encontrarATodos()
    {
        return  clienteRepository.findAll();
    }



}
