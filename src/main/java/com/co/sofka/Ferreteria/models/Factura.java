package com.co.sofka.Ferreteria.models;

import io.swagger.models.auth.In;
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
    private Integer total ;



    public Factura(LocalDate fecha, Cliente cliente, Asesor asesor, List<Productos> productosList) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.asesor = asesor;
        this.productosList = productosList;
        this.total =setTotal();
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

    public Integer setTotal()
    {
        int totalCont = 0;
//        this.productosList.forEach(
//                totalCont =  productosList.stream().map(Productos::getPrecio).
//        );

        for (int i = 0; i < this.productosList.size(); i++)
        {
            totalCont = totalCont + (productosList.get(i).getPrecio()* productosList.get(i).getCantidad());
        }


       return this.total = totalCont;
    }
}


