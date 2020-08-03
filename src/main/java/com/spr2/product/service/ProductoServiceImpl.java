package com.spr2.product.service;

import com.spr2.product.model.Producto;
import com.spr2.product.model.Usuario;
import com.spr2.product.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ProductoRepository productoRepo ;

    @Override
    public List<Producto> listarProductos() {
        return productoRepo.findAll();
    }

    @Override
    public void guardarProducto(Producto producto) {
        productoRepo.save(producto) ;
    }

    @Override
    public void eliminarProducto(int idProducto) {
        Optional<Producto> producto = productoRepo.findById(idProducto);

        if(producto.isPresent()) {
            productoRepo.delete(producto.get());
        }else {

        }
    }

    @Override
    public Producto editarProducto(int idProducto) {
        Optional<Producto> producto = productoRepo.findById(idProducto);
        return producto.get();
    }
}
