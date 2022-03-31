package com.co.sofka.Ferreteria.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document(collection = "asesores")
public class Asesor
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

    public Asesor(String id, String identificacion, String nombre, String contacto) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.contacto = contacto;
    }
}
