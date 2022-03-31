package com.co.sofka.Ferreteria.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Document(collection = "volantes")
public class Volante
{

    @Id
    private String id = UUID.randomUUID().toString();
    private List<Productos> productosList;
    private LocalDate Fecha;
    private Proveedor proveedor;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Volante(List<Productos> productosList, LocalDate fecha, Proveedor proveedor) {
        this.productosList = productosList;
        Fecha = fecha;
        this.proveedor = proveedor;
    }

    public Volante(String id, List<Productos> productosList, LocalDate fecha, Proveedor proveedor) {
        this.id = id;
        this.productosList = productosList;
        Fecha = fecha;
        this.proveedor = proveedor;
    }

    public Volante() {
    }
}
