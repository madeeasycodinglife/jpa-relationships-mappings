package com.madeeasy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "category",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_name",columnNames = {"name"})
        }
)
@JsonIgnoreProperties({"bookEntity"})
@ToString
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "category_sequence_gen")
    @SequenceGenerator(name = "category_sequence_gen", sequenceName = "category_sequence", initialValue = 1, allocationSize = 1)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categoryEntity")
    @ToString.Exclude
    private List<BookEntity> bookEntity;


}
