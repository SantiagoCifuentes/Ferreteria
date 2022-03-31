package com.co.sofka.Ferreteria.services.asesor;


import com.co.sofka.Ferreteria.models.Asesor;
import com.co.sofka.Ferreteria.models.Cliente;
import com.co.sofka.Ferreteria.repositories.AsesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AsesorService
{

    @Autowired
    public AsesorRepository asesorRepository;

    public Mono<Asesor> agregarAsesor(Asesor asesor)
    {
        return  asesorRepository.save(asesor);
    }



    public Mono<Asesor> actualizarAsesor(String id, Asesor asesor)
    {
        return  asesorRepository.findById(id)
                .flatMap(asesor1 -> {
                    asesor1.setId(id);
                    return agregarAsesor(asesor);
                }).switchIfEmpty(Mono.empty());
    }

    public Mono<Asesor> eliminarAsesor(String id){
        return  asesorRepository.findById(id)
                .flatMap(asesor -> asesorRepository.deleteById(asesor.getId()).thenReturn(asesor));
    }


    public Flux<Asesor> encontrarATodos()
    {
        return  asesorRepository.findAll();
    }
}
