package com.co.sofka.Ferreteria.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document(collection = "productos")
public class Productos
{
    @Id
    private String id = UUID.randomUUID().toString();
    private String nombre;
    private Integer precio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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


    public Productos(String id, String nombre, Integer precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }


    public Productos() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Productos)) return false;

        Productos productos = (Productos) o;

        if (id != null ? !id.equals(productos.id) : productos.id != null) return false;
        if (nombre != null ? !nombre.equals(productos.nombre) : productos.nombre != null) return false;
        return precio != null ? precio.equals(productos.precio) : productos.precio == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        return result;
    }
}
