package com.co.sofka.Ferreteria.services.proveedor;

import com.co.sofka.Ferreteria.models.Proveedor;
import com.co.sofka.Ferreteria.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProveedorServices
{
    @Autowired
    public ProveedorRepository proveedorRepository;

    public Mono<Proveedor> agregarProveedor(Proveedor proveedor)
    {
        return  proveedorRepository.save(proveedor);
    }



    public Mono<Proveedor> actualizarProveedor(String id, Proveedor proveedor)
    {
        return  proveedorRepository.findById(id)
                .flatMap(proveedor1 -> {
                    proveedor1.setId(id);
                    return agregarProveedor(proveedor);
                }).switchIfEmpty(Mono.empty());
    }

    public Mono<Proveedor> eliminarProveedor(String id){
        return  proveedorRepository.findById(id)
                .flatMap(proveedor -> proveedorRepository.deleteById(proveedor.getId()).thenReturn(proveedor));
    }

    public Flux<Proveedor> encontrarATodos()
    {
        return  proveedorRepository.findAll();
    }
}
