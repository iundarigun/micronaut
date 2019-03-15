package br.com.devcave.testing.micronaut.service;

import br.com.devcave.testing.micronaut.domain.dto.ProductDTO;
import br.com.devcave.testing.micronaut.domain.entity.Product;
import br.com.devcave.testing.micronaut.repository.ProductRepository;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class ProductService {

    @Inject
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        return productRepository.findAll()
                .stream()
                .map(Product::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void persist(ProductDTO product) {
        Product entity = new Product();
        entity.fromDTO(product);
        productRepository.save(entity);
    }

    @Transactional
    public void update(Long id, ProductDTO product) {
        Product entity = productRepository.findById(id);
        entity.fromDTO(product);
        productRepository.save(entity);
    }


}
