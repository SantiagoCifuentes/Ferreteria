package com.co.sofka.Ferreteria.controller.productos;

import com.co.sofka.Ferreteria.models.Cliente;
import com.co.sofka.Ferreteria.models.Productos;
import com.co.sofka.Ferreteria.services.productos.ProductosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/ferreteria")
@RestController
public class ProductosController
{
    @Autowired
    ProductosServices productosServices;

    @PostMapping("/productos")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Productos> save(@RequestBody Productos productos)
    {
        return  productosServices.agregarProducto(productos);
    }

    @PutMapping("/productos/{id}")
    private Mono<Productos> update(@PathVariable("id") String id, @RequestBody Productos productos)
    {
        return  productosServices.actualizarProductos(id,productos)
                .flatMap(productos1 -> {
                    return  Mono.just(productos1);
                });
    }

    @DeleteMapping ("/productos/{id}")
    private Mono<Productos>delete(@PathVariable("id") String id)
    {
        return productosServices.eliminarProductos(id).flatMap(productos -> Mono.just(productos));
    }

    @GetMapping ("/productos")
    private Flux<Productos> encontrarTodos()
    {
        return  productosServices.encontrarATodos();
    }

}
