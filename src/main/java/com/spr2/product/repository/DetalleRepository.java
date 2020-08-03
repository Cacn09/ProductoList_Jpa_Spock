package com.spr2.product.repository;

import com.spr2.product.model.Detalle_Prod_Usu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle_Prod_Usu, Integer> {

    @Query("select d from Detalle_Prod_Usu d where d.usuario.phone =:phoneNumb")
    public List<Detalle_Prod_Usu> findByPhoneNumb(@Param("phoneNumb") String phoneNumb);

}
