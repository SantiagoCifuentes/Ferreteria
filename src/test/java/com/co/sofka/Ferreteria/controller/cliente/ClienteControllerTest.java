package com.co.sofka.Ferreteria.controller.cliente;

import com.co.sofka.Ferreteria.models.Asesor;
import com.co.sofka.Ferreteria.models.Cliente;
import com.co.sofka.Ferreteria.services.asesor.AsesorService;
import com.co.sofka.Ferreteria.services.cliente.ClienteServices;
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
class ClienteControllerTest {

    @Autowired
    WebTestClient webClient;

    @Autowired
    ClienteServices clienteServices;

    @Test
    @DisplayName("Trae todas las clientes")
    void traerClientes() throws Exception {
        webClient.get().uri("/ferreteria/cliente")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON_VALUE)
                .expectBodyList(Cliente.class);
    }

    @Test
    void genererCliente()
    {
        Cliente cliente = new Cliente();

        cliente.setId("1");
        cliente.setIdentificacion("123456");
        cliente.setNombre("santiago");
        cliente.setContacto("123456");

        Mono<Cliente> asesorMono = clienteServices.agregarCliente(cliente);
        StepVerifier.create(asesorMono).expectNext(cliente).verifyComplete();

    }

}