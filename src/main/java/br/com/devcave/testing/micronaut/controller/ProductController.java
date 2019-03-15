package br.com.devcave.testing.micronaut.controller;

import br.com.devcave.testing.micronaut.domain.dto.ProductDTO;
import br.com.devcave.testing.micronaut.service.ProductService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.List;

@Slf4j
@Controller(value = "products")
public class ProductController {

    @Inject
    private ProductService productService;

    @Get
    public HttpResponse<List<ProductDTO>> getProducts(){
        log.info("getproducts");
        return HttpResponse.ok(productService.findAll());
    }

    @Post
    public HttpResponse create(@Body ProductDTO product){
        log.info("create");
        productService.persist(product);
        return HttpResponse.status(HttpStatus.CREATED);
    }
    @Put("{id}")
    public HttpResponse create(Long id, @Body ProductDTO product){
        log.info("create");
        productService.update(id, product);
        return HttpResponse.ok();
    }

}
