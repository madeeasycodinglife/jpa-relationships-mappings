package com.madeeasy.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "author")
@Component
@ToString
@JsonIgnoreProperties({"bookEntity","hibernateLazyInitializer","handler"})
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "author_sequence_gen")
    @SequenceGenerator(name = "author_sequence_gen", sequenceName = "author_sequence", initialValue = 1, allocationSize = 1)
    @Column(name = "author_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "authorEntity")
    @ToString.Exclude
    private List<BookEntity> bookEntity;

}
