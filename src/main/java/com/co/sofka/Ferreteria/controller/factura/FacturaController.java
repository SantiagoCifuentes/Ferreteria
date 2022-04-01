package com.co.sofka.Ferreteria.controller.factura;


import com.co.sofka.Ferreteria.models.Factura;
import com.co.sofka.Ferreteria.models.Productos;
import com.co.sofka.Ferreteria.models.Volante;
import com.co.sofka.Ferreteria.services.factura.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RequestMapping("/ferreteria")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FacturaController
{
    @Autowired
    FacturaService facturaService;

    @PostMapping("/factura/")
    private Mono<Factura> facturaAgregado(@RequestParam("clienteId")String clienteId, @RequestParam("asesorId")String asesorId, @RequestBody List<Productos> productosList)
    {
       return facturaService.agregarFactura( clienteId,asesorId,productosList).flatMap(productos -> {return Mono.just(productos);});




        //return "hola";
    }
}
