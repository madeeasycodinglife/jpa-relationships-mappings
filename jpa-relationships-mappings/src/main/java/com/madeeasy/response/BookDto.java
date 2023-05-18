package com.madeeasy.response;

import com.madeeasy.model.AuthorEntity;
import com.madeeasy.model.CategoryEntity;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private LocalDate publicationDate;
    private String description;
    private Double price;
    private Integer quantity;

    private List<CategoryEntity> categorieEntity;
    private AuthorEntity authorEntity;

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publicationDate=" + publicationDate +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", categorieEntity=" + categorieEntity +
                ", authorEntity=" + authorEntity +
                '}';
    }
}
