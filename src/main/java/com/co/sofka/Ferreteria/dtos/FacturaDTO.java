package com.co.sofka.Ferreteria.dtos;

import com.co.sofka.Ferreteria.models.Productos;

import java.time.LocalDate;
import java.util.List;

public class FacturaDTO
{

    private LocalDate fecha;
    private String nombreCliente;
    private String nombreAsesor;
    private List<ProductosDTO> productosList;
    private Integer total;


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

    public List<ProductosDTO> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<ProductosDTO> productosList) {
        this.productosList = productosList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public FacturaDTO(LocalDate fecha, String nombreCliente, String nombreAsesor, List<ProductosDTO> productosList, Integer total) {
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.nombreAsesor = nombreAsesor;
        this.productosList = productosList;
        this.total = total;
    }

    public FacturaDTO() {
    }
}
