package com.spr2.product.controller;

import com.spr2.product.model.Detalle_Prod_Usu;
import com.spr2.product.service.IDetalleService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ProductController {

    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";
    private final String SECRET = "VASS2020Key";

    @Autowired
    IDetalleService detalleService ;

    @GetMapping("listproducts")
    public List<Detalle_Prod_Usu> mainpage(HttpServletRequest request){
        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "")  ;
        String subjectphone = Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody().getSubject();

        //llamamos a la bd para buscar los productos asociados con el # de celular
        return detalleService.listaDetallebyPhone(subjectphone) ;

    }
}
