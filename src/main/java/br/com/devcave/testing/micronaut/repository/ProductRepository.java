package br.com.devcave.testing.micronaut.repository;

import br.com.devcave.testing.micronaut.domain.entity.Product;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Singleton
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Product product){
        if (product.getId() == null){
            entityManager.persist(product);
        }else{
            entityManager.merge(product);
        }
    }

    public List<Product> findAll() {
        return entityManager.createQuery("Select t from Product t").getResultList();
    }

    public Product findById(Long id){
        return entityManager.find(Product.class, id);
    }
}

