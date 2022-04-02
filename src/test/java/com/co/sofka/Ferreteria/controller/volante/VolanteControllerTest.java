package com.co.sofka.Ferreteria.controller.volante;

import com.co.sofka.Ferreteria.models.Asesor;
import com.co.sofka.Ferreteria.models.Productos;
import com.co.sofka.Ferreteria.models.Proveedor;
import com.co.sofka.Ferreteria.models.Volante;
import com.co.sofka.Ferreteria.services.productos.ProductosServices;
import com.co.sofka.Ferreteria.services.volante.VolanteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VolanteControllerTest
{


    @Autowired
    WebTestClient webClient;

    @Autowired
    VolanteService volanteService;


    @Test
    @DisplayName("Trae todas los volantes")
    void traerAsesores() throws Exception {
        webClient.get().uri("/ferreteria/volante")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON_VALUE)
                .expectBodyList(Asesor.class);
    }




}