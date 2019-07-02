package com.gabi.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
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
    UnitOfMeasure unitOfMeasure;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description=description;
        this.amount = amount;
        this.unitOfMeasure = uom;
    }

    public Ingredient(Long id, String description, BigDecimal amount, Recipe recipe, UnitOfMeasure unitOfMeasure) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.recipe = recipe;
        this.unitOfMeasure = unitOfMeasure;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", recipe=" + recipe +
                ", unitOfMeasure=" + unitOfMeasure +
                '}';
    }

}
