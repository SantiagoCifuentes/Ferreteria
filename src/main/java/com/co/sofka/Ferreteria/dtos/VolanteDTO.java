package com.co.sofka.Ferreteria.dtos;

import com.co.sofka.Ferreteria.models.Productos;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class VolanteDTO
{
    private String id = UUID.randomUUID().toString();
    private List<ProductosDTO> productosList;
    private LocalDate Fecha;
    private String identificacionProveedor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ProductosDTO> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<ProductosDTO> productosList) {
        this.productosList = productosList;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    public String getIdentificacionProveedor() {
        return identificacionProveedor;
    }

    public void setIdentificacionProveedor(String identificacionProveedor) {
        this.identificacionProveedor = identificacionProveedor;
    }

    public VolanteDTO(String id, List<ProductosDTO> productosList, LocalDate fecha, String identificacionProveedor) {
        this.id = id;
        this.productosList = productosList;
        Fecha = fecha;
        this.identificacionProveedor = identificacionProveedor;
    }

    public VolanteDTO() {
    }
}
