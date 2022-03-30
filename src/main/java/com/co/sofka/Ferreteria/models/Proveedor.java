package com.co.sofka.Ferreteria.models;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Proveedor
{
    @Id
    private String id = UUID.randomUUID().toString();
    private String identificacion;
    private String nombre;
    private String contacto;
}
