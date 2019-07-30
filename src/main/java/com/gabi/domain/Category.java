package com.gabi.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@EqualsAndHashCode(exclude = {"recipes"})
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;

    @ManyToMany(mappedBy = "categories")
    Set<Recipe> recipes;
}
