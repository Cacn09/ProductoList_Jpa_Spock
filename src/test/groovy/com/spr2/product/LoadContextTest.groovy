package com.spr2.product

import com.spr2.product.controller.ProductController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class LoadContextTest extends Specification {

    @Autowired (required = false)
    private ProductController webController

    def "when context is loaded then all expected beans are created"() {
        expect: "the WebController is created"
        webController
    }

}
