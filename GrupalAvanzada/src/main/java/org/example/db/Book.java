package org.example.db;

import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "books")
@ToString(exclude = "author")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String isbn;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    //Casi siempre se mapea de muchos a uno
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authors_id", nullable = false)
    private Author author;

}
