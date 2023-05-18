package com.madeeasy.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "book")
@ToString
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence_gen")
    @SequenceGenerator(name = "book_sequence_gen", sequenceName = "book_sequence", initialValue = 1, allocationSize = 1)
    @Column(name = "book_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    @Valid
    @ToString.Exclude
    private List<CategoryEntity> categoryEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @Valid
    @ToString.Exclude
    private AuthorEntity authorEntity;


}
