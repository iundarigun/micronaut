package br.com.devcave.testing.micronaut.domain.entity;

import br.com.devcave.testing.micronaut.domain.dto.ProductDTO;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Product {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotEmpty
    private String name;

    @Column
    private String description;

    @Column
    private BigDecimal price;

    @Column
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @Column
    @CreationTimestamp
    private LocalDateTime createDate;

    public ProductDTO toDTO(){
        return ProductDTO.builder()
                .name(this.name)
                .description(this.description)
                .price(this.price)
                .build();
    }

    public void fromDTO(ProductDTO dto){
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.price = dto.getPrice();
    }
}
