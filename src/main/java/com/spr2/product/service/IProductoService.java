package com.spr2.product.service;

import com.spr2.product.model.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> listarProductos();
    void guardarProducto(Producto producto);
    void eliminarProducto(int idProducto) ;
    Producto editarProducto(int idProducto) ;
}
