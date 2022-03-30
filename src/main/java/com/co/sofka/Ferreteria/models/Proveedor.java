package com.co.sofka.Ferreteria.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document(collection = "proveedores")
public class Proveedor
{
    @Id
    private String id = UUID.randomUUID().toString();
    private String identificacion;
    private String nombre;
    private String contacto;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }


    public Proveedor(String id, String identificacion, String nombre, String contacto) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public Proveedor() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proveedor)) return false;

        Proveedor proveedor = (Proveedor) o;

        if (id != null ? !id.equals(proveedor.id) : proveedor.id != null) return false;
        if (identificacion != null ? !identificacion.equals(proveedor.identificacion) : proveedor.identificacion != null)
            return false;
        if (nombre != null ? !nombre.equals(proveedor.nombre) : proveedor.nombre != null) return false;
        return contacto != null ? contacto.equals(proveedor.contacto) : proveedor.contacto == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (identificacion != null ? identificacion.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (contacto != null ? contacto.hashCode() : 0);
        return result;
    }
}
