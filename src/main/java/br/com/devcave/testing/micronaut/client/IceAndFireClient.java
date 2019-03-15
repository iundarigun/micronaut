package br.com.devcave.testing.micronaut.client;

import br.com.devcave.testing.micronaut.domain.dto.BookDTO;
import br.com.devcave.testing.micronaut.domain.dto.CharacterDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.IOException;

@Slf4j
@Singleton
public class IceAndFireClient {

    @Inject
    @Client("https://anapioficeandfire.com/api")
    private RxHttpClient httpClient;

    private ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public BookDTO getBook(Long id) {
        try {
            return mapper.readValue(httpClient.retrieve("/books/" + id).firstElement().blockingGet(), BookDTO.class);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public CharacterDTO getCharacter(Long id) {
        try {
            return mapper.readValue(httpClient.retrieve("/characters/" + id).firstElement().blockingGet(), CharacterDTO.class);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }

    }
}
