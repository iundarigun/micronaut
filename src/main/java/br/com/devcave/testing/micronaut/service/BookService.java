package br.com.devcave.testing.micronaut.service;

import br.com.devcave.testing.micronaut.client.IceAndFireClient;
import br.com.devcave.testing.micronaut.domain.dto.BookDTO;
import br.com.devcave.testing.micronaut.domain.dto.CharacterDTO;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class BookService {

    @Inject
    private IceAndFireClient iceAndFireClient;

    public BookDTO getBook(Long id){
        BookDTO book = iceAndFireClient.getBook(id);

        List<String> characterList = book.getPovCharacters()
                .stream()
                .map(c -> iceAndFireClient.getCharacter(getIdFromUrl(c)).getName())
                .collect(Collectors.toList());

        book.setPovCharacters(characterList);
        return book;
    }

    public CharacterDTO getCharacter(Long id){
        return iceAndFireClient.getCharacter(id);
    }

    private Long getIdFromUrl(String url) {
        String[] split = url.split("/");
        return Long.valueOf(split[split.length - 1]);
    }
}
