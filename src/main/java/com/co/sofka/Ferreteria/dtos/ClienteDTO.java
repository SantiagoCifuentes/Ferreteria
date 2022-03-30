package com.co.sofka.Ferreteria.dtos;

public class ClienteDTO
{
    private String id;
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

    public ClienteDTO(String id, String identificacion, String nombre, String contacto) {
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public ClienteDTO() {
    }
}
