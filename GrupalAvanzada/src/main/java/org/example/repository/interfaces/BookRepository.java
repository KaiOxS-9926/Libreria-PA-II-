package org.example.repository.interfaces;

import org.example.db.Book;
import org.example.precios.HighPrice;

import java.util.List;

public interface BookRepository {

    // CRUD
    void guardar(Book obj);
    void actualizar(Book obj);
    void borrar(Integer id);

    // CONSULTAS
    Book findById(Integer id);
    List<Book> findAll();
    List<HighPrice> libroMayorPrecio();
    List<HighPrice> MayorPrecioConcurrente();

}
