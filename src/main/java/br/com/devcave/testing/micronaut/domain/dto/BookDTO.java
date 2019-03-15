package br.com.devcave.testing.micronaut.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookDTO {

    private String url;

    private String name;

    private Long numberOfPages;

    private String isbn;

    private List<String> povCharacters;
}
