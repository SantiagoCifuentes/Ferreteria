package com.co.sofka.Ferreteria.controller.volante;


import com.co.sofka.Ferreteria.models.Productos;
import com.co.sofka.Ferreteria.models.Volante;
import com.co.sofka.Ferreteria.services.asesor.AsesorService;
import com.co.sofka.Ferreteria.services.volante.VolanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequestMapping("/ferreteria")
@RestController
public class VolanteController
{

    @Autowired
    VolanteService volanteService;





    @PutMapping("/volante/productos/{id}")
    private Mono<Volante> volanteAgregado(@PathVariable("id") String id, @RequestBody List <Productos>productosList)
    {
        return volanteService.agregarVolante(id, productosList)
                .flatMap(productos -> {return Mono.just(productos);});
    }


    @GetMapping("/volante/{id}")
    private Mono<Volante> buscarVolantePorId(@PathVariable String id)
    {
        return  volanteService.buscarVolantePorId(id);
    }

    @GetMapping ("/volante")
    private Flux<Volante> encontrarTodos()
    {
        return  volanteService.encontrarATodos();
    }



}
