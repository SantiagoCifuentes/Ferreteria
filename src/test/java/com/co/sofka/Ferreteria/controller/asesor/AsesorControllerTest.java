package com.co.sofka.Ferreteria.controller.asesor;

import com.co.sofka.Ferreteria.models.Asesor;
import com.co.sofka.Ferreteria.services.asesor.AsesorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AsesorControllerTest
{

    @Autowired
    WebTestClient webClient;

    @Autowired
    AsesorService asesorService;

    @Test
    @DisplayName("Trae todas las asesores")
    void traerAsesores() throws Exception {
        webClient.get().uri("/ferreteria/asesor")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON_VALUE)
                .expectBodyList(Asesor.class);
    }

    @Test
    void genererAsesor()
    {
        Asesor asesor = new Asesor();

        asesor.setId("1");
        asesor.setIdentificacion("123456");
        asesor.setNombre("santiago");
        asesor.setContacto("123456");

        Mono<Asesor> asesorMono = asesorService.agregarAsesor(asesor);
        StepVerifier.create(asesorMono).expectNext(asesor).verifyComplete();

    }




}