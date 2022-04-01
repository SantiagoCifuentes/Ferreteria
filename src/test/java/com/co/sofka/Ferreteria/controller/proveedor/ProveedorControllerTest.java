package com.co.sofka.Ferreteria.controller.proveedor;

import com.co.sofka.Ferreteria.models.Asesor;
import com.co.sofka.Ferreteria.models.Proveedor;
import com.co.sofka.Ferreteria.services.asesor.AsesorService;
import com.co.sofka.Ferreteria.services.proveedor.ProveedorServices;
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
class ProveedorControllerTest {


    @Autowired
    WebTestClient webClient;

    @Autowired
    ProveedorServices proveedorServices;


    @Test
    @DisplayName("Trae todas los proveedores")
    void traerAsesores() throws Exception {
        webClient.get().uri("/ferreteria/proveedor")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON_VALUE)
                .expectBodyList(Asesor.class);
    }

    @Test
    void genererProveedor()
    {
        Proveedor proveedor = new Proveedor();

        proveedor.setId("1");
        proveedor.setIdentificacion("123456");
        proveedor.setNombre("santiago");
        proveedor.setContacto("123456");

        Mono<Proveedor> proveedorMono = proveedorServices.agregarProveedor(proveedor);
        StepVerifier.create(proveedorMono).expectNext(proveedor).verifyComplete();

    }
}