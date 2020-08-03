package com.spr2.product.service;


import com.spr2.product.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> listarUsuarios();
    void guardarUsuario(Usuario usuario);
    void eliminarUsuario(int idUsuario) ;
    Usuario editarUsuario(int idUsuario) ;

}
