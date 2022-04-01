package com.co.sofka.Ferreteria.controller.productos;

import com.co.sofka.Ferreteria.models.Asesor;
import com.co.sofka.Ferreteria.models.Productos;
import com.co.sofka.Ferreteria.models.Proveedor;
import com.co.sofka.Ferreteria.services.productos.ProductosServices;
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
class ProductosControllerTest {

    @Autowired
    WebTestClient webClient;

    @Autowired
    ProductosServices productosServices;


    @Test
    @DisplayName("Trae todas los productos")
    void traerAsesores() throws Exception {
        webClient.get().uri("/ferreteria/productos")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(APPLICATION_JSON_VALUE)
                .expectBodyList(Asesor.class);
    }


    @Test
    void genererProveedor()
    {
        Productos productos = new Productos();


        productos.setNombre("martillos");
        productos.setCantidad(6);
        productos.setCantidadMin(5);
        productos.setCantidadMax(20);
        productos.setPrecio(20000);
        productos.setAlerta("Tienes pocos productos");


        Mono<Productos> productosMono = productosServices.agregarProducto(productos);
        StepVerifier.create(productosMono).expectNext(productos).verifyComplete();

    }

}