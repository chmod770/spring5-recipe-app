package com.gabi.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@ToString
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER)
    UnitOfMeasure uom;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description=description;
        this.amount = amount;
        this.uom = uom;
    }

    public Ingredient(Long id, String description, BigDecimal amount, Recipe recipe, UnitOfMeasure uom) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.recipe = recipe;
        this.uom = uom;
    }

}
