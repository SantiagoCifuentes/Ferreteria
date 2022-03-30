package com.co.sofka.Ferreteria.models;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Factura
{
    @Id
    private String id = UUID.randomUUID().toString();
    private LocalDate fecha;
    private String nombreCliente;
    private String nombreAsesor;
    private List<Productos> productosList;
    private Integer total;


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

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreAsesor() {
        return nombreAsesor;
    }

    public void setNombreAsesor(String nombreAsesor) {
        this.nombreAsesor = nombreAsesor;
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

    public Factura(String id, LocalDate fecha, String nombreCliente, String nombreAsesor, List<Productos> productosList, Integer total) {
        this.id = id;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.nombreAsesor = nombreAsesor;
        this.productosList = productosList;
        this.total = total;
    }

    public Factura() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Factura)) return false;

        Factura factura = (Factura) o;

        if (id != null ? !id.equals(factura.id) : factura.id != null) return false;
        if (fecha != null ? !fecha.equals(factura.fecha) : factura.fecha != null) return false;
        if (nombreCliente != null ? !nombreCliente.equals(factura.nombreCliente) : factura.nombreCliente != null)
            return false;
        if (nombreAsesor != null ? !nombreAsesor.equals(factura.nombreAsesor) : factura.nombreAsesor != null)
            return false;
        if (productosList != null ? !productosList.equals(factura.productosList) : factura.productosList != null)
            return false;
        return total != null ? total.equals(factura.total) : factura.total == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (nombreCliente != null ? nombreCliente.hashCode() : 0);
        result = 31 * result + (nombreAsesor != null ? nombreAsesor.hashCode() : 0);
        result = 31 * result + (productosList != null ? productosList.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }
}
