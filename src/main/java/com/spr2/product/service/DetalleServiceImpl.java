package com.spr2.product.service;

import com.spr2.product.model.Detalle_Prod_Usu;
import com.spr2.product.model.Producto;
import com.spr2.product.repository.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleServiceImpl implements IDetalleService{

    @Autowired
    private DetalleRepository detalleRepo ;

    @Override
    public List<Detalle_Prod_Usu> listaDetallebyPhone(String phoneNumb) {
        return detalleRepo.findByPhoneNumb(phoneNumb) ;
    }

    @Override
    public List<Detalle_Prod_Usu> listarDetalleProductoUsuario() {
        return detalleRepo.findAll();
    }

    @Override
    public void guardarDetalle(Detalle_Prod_Usu detalle) {
        detalleRepo.save(detalle) ;
    }

    @Override
    public void eliminarDetalle(int idDetalle) {
        Optional<Detalle_Prod_Usu> detalle = detalleRepo.findById(idDetalle);

        if(detalle.isPresent()) {
            detalleRepo.delete(detalle.get());
        }else {

        }
    }

    @Override
    public Detalle_Prod_Usu editarDetalle(int idDetalle) {
        Optional<Detalle_Prod_Usu> detalle = detalleRepo.findById(idDetalle);
        return detalle.get();
    }
}
