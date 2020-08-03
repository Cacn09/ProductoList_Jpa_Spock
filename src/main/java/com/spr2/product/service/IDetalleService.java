package com.spr2.product.service;

import com.spr2.product.model.Detalle_Prod_Usu;

import java.util.List;

public interface IDetalleService {

    List<Detalle_Prod_Usu> listaDetallebyPhone(String phoneNumb);
    List<Detalle_Prod_Usu> listarDetalleProductoUsuario();
    void guardarDetalle(Detalle_Prod_Usu detalle);
    void eliminarDetalle(int idDetalle) ;
    Detalle_Prod_Usu editarDetalle(int idDetalle) ;
}
