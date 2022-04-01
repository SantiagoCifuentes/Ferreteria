package com.co.sofka.Ferreteria.controller.asesor;

import com.co.sofka.Ferreteria.models.Asesor;
import com.co.sofka.Ferreteria.models.Cliente;
import com.co.sofka.Ferreteria.services.asesor.AsesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/ferreteria")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AsesorController
{

    @Autowired
    AsesorService asesorService;

    @PostMapping("/asesor")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Asesor> save(@RequestBody Asesor asesor)
    {
        return  asesorService.agregarAsesor(asesor);
    }

    @PutMapping("/asesor/{id}")
    private Mono<Asesor> update(@PathVariable("id") String id, @RequestBody Asesor asesor)
    {
        return  asesorService.actualizarAsesor(id,asesor)
                .flatMap(asesor1 -> {
                    return  Mono.just(asesor1);
                });
    }

    @DeleteMapping ("/asesor/{id}")
    private Mono<Asesor>delete(@PathVariable("id") String id)
    {
        return asesorService.eliminarAsesor(id).flatMap(asesor -> Mono.just(asesor));
    }

    @GetMapping ("/asesor")
    private Flux<Asesor> encontrarTodos()
    {
        return  asesorService.encontrarATodos();
    }
}
