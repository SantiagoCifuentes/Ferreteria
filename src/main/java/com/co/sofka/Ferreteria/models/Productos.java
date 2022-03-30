package com.co.sofka.Ferreteria.models;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Productos
{
    @Id
    private String id = UUID.randomUUID().toString();
    private String nombre;
    private Integer precio;
}
