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
    private Asesor asesor;
    private List<Productos> productosList;
    private Integer total;


    public Factura(String id, LocalDate fecha, Cliente cliente, Asesor asesor, List<Productos> productosList, Integer total) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.asesor = asesor;
        this.productosList = productosList;
        this.total = total;
    }

    public Factura() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }

    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}


