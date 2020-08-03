package com.spr2.product.model;

import javax.persistence.*;

@Entity
@Table(name = "detalle_producto_usuario")
public class Detalle_Prod_Usu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddet_pro_us ;

    @ManyToOne
    @JoinColumn(name = "idproducto")
    private Producto producto ;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario ;

    public int getIddet_pro_us() {
        return iddet_pro_us;
    }

    public void setIddet_pro_us(int iddet_pro_us) {
        this.iddet_pro_us = iddet_pro_us;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
