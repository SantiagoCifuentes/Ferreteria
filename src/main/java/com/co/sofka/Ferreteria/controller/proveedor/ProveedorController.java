package com.co.sofka.Ferreteria.controller.proveedor;

import com.co.sofka.Ferreteria.models.Cliente;
import com.co.sofka.Ferreteria.models.Proveedor;
import com.co.sofka.Ferreteria.services.cliente.ClienteServices;
import com.co.sofka.Ferreteria.services.proveedor.ProveedorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ferreteria")
@CrossOrigin(origins = "http://localhost:3000")
public class ProveedorController
{
    @Autowired
    ProveedorServices proveedorServices;

    @PostMapping("/proveedor")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Proveedor> save(@RequestBody Proveedor proveedor)
    {
        return  proveedorServices.agregarProveedor(proveedor);
    }


    @PutMapping("/proveedor/{id}")
    private Mono<Proveedor> update(@PathVariable("id") String id, @RequestBody Proveedor proveedor)
    {
        return  proveedorServices.actualizarProveedor(id,proveedor)
                .flatMap(proveedor1 -> {
                    return  Mono.just(proveedor1);
                });
    }

    @DeleteMapping ("/proveedor/{id}")
    private Mono<Proveedor>delete(@PathVariable("id") String id)
    {
        return proveedorServices.eliminarProveedor(id).flatMap(proveedor -> Mono.just(proveedor));
    }

    @GetMapping ("/proveedor")
    private Flux<Proveedor> encontrarTodos()
    {
        return  proveedorServices.encontrarATodos();
    }



}
