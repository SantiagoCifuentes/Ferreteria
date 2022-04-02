package com.co.sofka.Ferreteria.controller.factura;

import com.co.sofka.Ferreteria.models.Asesor;
import com.co.sofka.Ferreteria.models.Factura;
import com.co.sofka.Ferreteria.services.volante.VolanteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FacturaControllerTest {

    @Autowired
    WebTestClient webClient;

    @Autowired
    VolanteService volanteService;


    @Test
    @DisplayName("Trae todas los facturas")
    void traerFacturas() throws Exception {
        webClient.get().uri("/ferreteria/factura")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON_VALUE)
                .expectBodyList(Factura.class);
    }


}