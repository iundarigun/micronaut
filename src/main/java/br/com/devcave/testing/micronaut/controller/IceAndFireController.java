package br.com.devcave.testing.micronaut.controller;

import br.com.devcave.testing.micronaut.domain.dto.BookDTO;
import br.com.devcave.testing.micronaut.domain.dto.CharacterDTO;
import br.com.devcave.testing.micronaut.service.BookService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;

@Controller("/ice-and-fire")
public class IceAndFireController {

    @Inject
    private BookService bookService;

    @Get("books/{id}")
    public HttpResponse<BookDTO> getBook(Long id){
        return HttpResponse.ok(bookService.getBook(id));
    }

    @Get("characters/{id}")
    public HttpResponse<CharacterDTO> getCharacter(Long id){
        return HttpResponse.ok(bookService.getCharacter(id));
    }
}
