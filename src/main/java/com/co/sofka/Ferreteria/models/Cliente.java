package com.co.sofka.Ferreteria.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "clientes")
public class Cliente
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


    public Cliente(String id, String identificacion, String nombre, String contacto) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public Cliente() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;

        Cliente cliente = (Cliente) o;

        if (id != null ? !id.equals(cliente.id) : cliente.id != null) return false;
        if (identificacion != null ? !identificacion.equals(cliente.identificacion) : cliente.identificacion != null)
            return false;
        if (nombre != null ? !nombre.equals(cliente.nombre) : cliente.nombre != null) return false;
        return contacto != null ? contacto.equals(cliente.contacto) : cliente.contacto == null;
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
