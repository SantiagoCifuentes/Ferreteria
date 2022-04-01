package com.co.sofka.Ferreteria.controller.cliente;


import com.co.sofka.Ferreteria.dtos.ClienteDTO;
import com.co.sofka.Ferreteria.models.Cliente;
import com.co.sofka.Ferreteria.services.cliente.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequestMapping("/ferreteria")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ClienteController
{
    @Autowired
    ClienteServices clienteServices;

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Cliente>save(@RequestBody Cliente cliente)
    {
        return  clienteServices.agregarCliente(cliente);
    }

    @PutMapping("/cliente/{id}")
    private Mono<Cliente> update(@PathVariable("id") String id, @RequestBody Cliente cliente)
    {
        return  clienteServices.actualizarCliente(id,cliente)
                .flatMap(cliente1 -> {
                     return  Mono.just(cliente1);
                });
    }

    @DeleteMapping ("/cliente/{id}")
    private Mono<Cliente>delete(@PathVariable("id") String id)
    {
        return clienteServices.eliminarCliente(id).flatMap(cliente -> Mono.just(cliente));
    }

    @GetMapping ("/cliente")
    private Flux<Cliente> encontrarTodos()
    {
        return  clienteServices.encontrarATodos();
    }





}
