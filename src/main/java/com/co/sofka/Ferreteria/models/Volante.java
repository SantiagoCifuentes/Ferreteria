package com.co.sofka.Ferreteria.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Document(collection = "volantes")
public class Volante
{

    @Id
    private String id = UUID.randomUUID().toString();
    private List<Productos> productosList;
    private LocalDate Fecha;
    private String identificacionProveedor;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Volante)) return false;

        Volante volante = (Volante) o;

        if (id != null ? !id.equals(volante.id) : volante.id != null) return false;
        if (productosList != null ? !productosList.equals(volante.productosList) : volante.productosList != null)
            return false;
        if (Fecha != null ? !Fecha.equals(volante.Fecha) : volante.Fecha != null) return false;
        return identificacionProveedor != null ? identificacionProveedor.equals(volante.identificacionProveedor) : volante.identificacionProveedor == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productosList != null ? productosList.hashCode() : 0);
        result = 31 * result + (Fecha != null ? Fecha.hashCode() : 0);
        result = 31 * result + (identificacionProveedor != null ? identificacionProveedor.hashCode() : 0);
        return result;
    }
}
