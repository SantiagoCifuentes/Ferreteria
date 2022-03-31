package com.co.sofka.Ferreteria.services.factura;


import com.co.sofka.Ferreteria.models.Asesor;
import com.co.sofka.Ferreteria.models.Cliente;
import com.co.sofka.Ferreteria.models.Factura;
import com.co.sofka.Ferreteria.models.Productos;
import com.co.sofka.Ferreteria.repositories.AsesorRepository;
import com.co.sofka.Ferreteria.repositories.ClienteRepository;
import com.co.sofka.Ferreteria.repositories.FacturaRepository;
import com.co.sofka.Ferreteria.repositories.ProductosRepository;
import com.co.sofka.Ferreteria.services.productos.ProductosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

@Service
public class FacturaService
{
    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    ClienteRepository clienteRepository;



    @Autowired
    AsesorRepository asesorRepository;

    @Autowired
    ProductosServices productosServices;


    public Mono<Factura> agregarFactura ( String clienteid,String asesorid,List<Productos> productosList)
    {
        System.out.println(clienteid);
        Cliente cliente1 = clienteRepository.findById(clienteid).block();
        Asesor asesor1  = asesorRepository.findById(asesorid).block();
        productosList.stream().map(productos -> productosServices.actualizarProductosVendidos(productos.getId(),productos.getCantidad()).subscribe());

        Factura factura = new Factura( LocalDate.now(),cliente1,asesor1,productosList);
        return  facturaRepository.save(factura);
    }

}
