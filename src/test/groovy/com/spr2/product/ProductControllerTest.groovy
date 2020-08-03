package com.spr2.product

import com.spr2.product.controller.ProductController
import com.spr2.product.model.Detalle_Prod_Usu
import com.spr2.product.model.Producto
import com.spr2.product.model.Usuario
import com.spr2.product.repository.DetalleRepository
import com.spr2.product.service.IDetalleService
import com.spr2.product.service.IProductoService
import groovy.json.JsonSlurper
import org.junit.Assert
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.client.RestTemplate
import spock.lang.Shared
import spock.lang.Specification

import java.util.stream.Collectors
import java.util.stream.Stream

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

@AutoConfigureMockMvc
//@WebMvcTest
@SpringBootTest
class ProductControllerTest extends Specification {

    @Autowired
    private MockMvc mvc

    @Autowired
    IProductoService productoService ;


    def "GetlistUser" (){
        when:
        productoService.listarProductos().collect()
        then:
        print(productoService.listarProductos().size())
        5 == productoService.listarProductos().size()
    }


    def "ListProduct"() {
        expect: "Status is 200 and the response is 'Hello world!'"

        def res = mvc.perform(get("/listproducts")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0ZWVrSldUIiwic3ViIjoiOTgzNDgyMDk4IiwiaWF0IjoxNTk2MjQzODAzfQ.sbkt0OlCnzcX2wmR84tont277cLvQQwmscQ5-tK14wT0F1jv1WSV947zzQsDMVmfpaghpopqRG-ElOde6425eQ")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())

       // print(res.andReturn().response.contentAsString)
        def jsontocast = res.andReturn().response.contentAsString

        def jsonSlurper = new JsonSlurper()
        def object = jsonSlurper.parseText(jsontocast)

        //Casteamos a Objeto Java
        def list2 = new ArrayList<Detalle_Prod_Usu>(object)

        println list2.get(1).producto.product_name

        assert list2.get(1).producto.product_name == "PRO_F30"


   }

    }
