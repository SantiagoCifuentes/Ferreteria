package com.co.sofka.Ferreteria.dtos;

public class ProductosDTO
{
    private String id;
    private String nombre;
    private Integer precio;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductosDTO(String id, String nombre, Integer precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public ProductosDTO() {
    }
}
