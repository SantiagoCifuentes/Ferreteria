package com.co.sofka.Ferreteria.services.volante;

import com.co.sofka.Ferreteria.models.Asesor;
import com.co.sofka.Ferreteria.models.Productos;
import com.co.sofka.Ferreteria.models.Proveedor;
import com.co.sofka.Ferreteria.models.Volante;
import com.co.sofka.Ferreteria.repositories.ProveedorRepository;
import com.co.sofka.Ferreteria.repositories.VolanteRepository;
import com.co.sofka.Ferreteria.services.productos.ProductosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

@Service
public class VolanteService
{
    @Autowired
    public VolanteRepository volanteRepository;

    @Autowired
    public ProveedorRepository proveedorRepository;

    @Autowired
    ProductosServices productosServices;

    public Mono<Volante> agregarVolante(String id, List<Productos> productosList)
    {

        Proveedor proveedor = proveedorRepository.findById(id).block();
        productosList.stream().map(productos -> productosServices.actualizarProductosporCantidad(productos.getId(),productos.getCantidad()).subscribe());

        Volante volante = new Volante(productosList, LocalDate.now(),proveedor);
        return  volanteRepository.save(volante);
    }




    public Mono<Volante> buscarVolantePorId(String id)
    {
        return  volanteRepository.findById(id);
    }




    public Flux<Volante> encontrarATodos()
    {
        return  volanteRepository.findAll();
    }
}
