package com.co.sofka.Ferreteria.services.productos;


import com.co.sofka.Ferreteria.models.Productos;
import com.co.sofka.Ferreteria.models.Proveedor;
import com.co.sofka.Ferreteria.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductosServices
{

    @Autowired
    public ProductosRepository productosRepository;

    public Mono<Productos> agregarProducto(Productos productos)
    {
        return  productosRepository.save(productos);
    }


    public Mono<Productos> actualizarProductos(String id, Productos productos)
    {
        return  productosRepository.findById(id)
                .flatMap(productos1 -> {
                    productos1.setId(id);
                    return agregarProducto(productos);
                }).switchIfEmpty(Mono.empty());
    }

//    public Mono<Productos> actualizarProductosporCantidad(String id, Integer cantidad)
//    {
//        return  productosRepository.findById(id)
//                .flatMap(productos1 -> {
//                    if(productos1.getCantidad() < productos1.getCantidadMax()
//                    productos1.setCantidad(cantidad);
//                    return agregarProducto(productos);
//                }).switchIfEmpty(Mono.empty());
//    }




    public Mono<Productos> eliminarProductos(String id){
        return  productosRepository.findById(id)
                .flatMap(productos -> productosRepository.deleteById(productos.getId()).thenReturn(productos));
    }

    public Flux<Productos> encontrarATodos()
    {
        return  productosRepository.findAll();
    }

}
