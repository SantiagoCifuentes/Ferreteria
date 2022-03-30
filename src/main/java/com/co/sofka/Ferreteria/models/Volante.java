package com.co.sofka.Ferreteria.models;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Volante
{
    @Id
    private String id = UUID.randomUUID().toString();
    private List<Productos> productosList;
    private LocalDate Fecha;
    private String identificacionProveedor;
}
