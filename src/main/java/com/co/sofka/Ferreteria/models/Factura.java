package com.co.sofka.Ferreteria.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Document(collection = "facturas")
public class Factura {
    @Id
    private String id = UUID.randomUUID().toString();
    private LocalDate fecha;
    private Cliente cliente;
    private String nombreAsesor;
    private List<Productos> productosList;
    private Integer total;



}


