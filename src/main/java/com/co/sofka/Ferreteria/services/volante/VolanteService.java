package com.co.sofka.Ferreteria.services.volante;

import com.co.sofka.Ferreteria.models.Asesor;
import com.co.sofka.Ferreteria.models.Volante;
import com.co.sofka.Ferreteria.repositories.VolanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VolanteService
{
    @Autowired
    public VolanteRepository volanteRepository;

    public Mono<Volante> agregarVolante(Volante volante)
    {
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
