package org.example.repository.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.example.db.Book;
import org.example.precios.HighPrice;
import org.example.repository.interfaces.BookRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

@ApplicationScoped
public class BookRepositoryImpl implements BookRepository {

    @Inject
    private EntityManager entityManager;

    public BookRepositoryImpl() {
    }

    // CRUD

    @Override
    @Transactional
    public void guardar(Book book) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(book);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    @Transactional
    public void actualizar(Book book) {
        try {
            entityManager.getTransaction().begin();
            Book act = entityManager.find(Book.class, book.getId());
            if (act != null) {
                act.setTitulo(book.getTitulo());
                act.setPrecio(book.getPrecio());
                act.setIsbn(book.getIsbn());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    @Transactional
    public void borrar(Integer id) {
        try {
            entityManager.getTransaction().begin();
            Book borrar = entityManager.find(Book.class, id);
            if (borrar != null) {
                entityManager.remove(borrar);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    // BUSQUEDAS

    @Override
    public Book findById(Integer id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> findAll() {
        String queryStr = "SELECT b FROM Book b";
        TypedQuery<Book> query = entityManager.createQuery(queryStr, Book.class);
        return query.getResultList();
    }

    @Override
    public List<HighPrice> libroMayorPrecio() {
        String jpql = "SELECT new org.example.precios.HighPrice(b.titulo, b.precio, b.isbn) " +
                "FROM Book b " +
                "WHERE b.precio = (SELECT MAX(b2.precio) FROM Book b2)";
        TypedQuery<HighPrice> query = entityManager.createQuery(jpql, HighPrice.class);
        return query.getResultList();
    }

    @Override
    public List<HighPrice> MayorPrecioConcurrente() {
        List<Book> books = findAll();
        if (books.isEmpty()) {
            return new ArrayList<HighPrice>();
        }

        ForkJoinPool pool = ForkJoinPool.commonPool();
        BigDecimal precioMaximo = pool.invoke(new PrecioMaximo(books, 0, books.size()));
        List<Book> librosFiltrados = pool.invoke(new LibrosMayorPrecio(books, precioMaximo, 0, books.size()));

        List<HighPrice> result = new ArrayList<HighPrice>();
        for (int i = 0; i < librosFiltrados.size(); i++) {
            Book b = librosFiltrados.get(i);
            HighPrice dto = new HighPrice(b.getTitulo(), b.getPrecio(), b.getIsbn());
            result.add(dto);
        }
        return result;
    }

    // FORK-JOIN

    private static class PrecioMaximo extends RecursiveTask<BigDecimal> {
        private List<Book> books;
        private int inicio;
        private int fin;

        public PrecioMaximo(List<Book> books, int inicio, int fin) {
            this.books = books;
            this.inicio = inicio;
            this.fin = fin;
        }

        @Override
        protected BigDecimal compute() {
            if ((fin - inicio) <= 1) {
                return books.get(inicio).getPrecio();
            } else {
                int mitad = (inicio + fin) / 2;

                PrecioMaximo izqTask = new PrecioMaximo(books, inicio, mitad);
                PrecioMaximo derTask = new PrecioMaximo(books, mitad, fin);

                izqTask.fork();

                BigDecimal der = derTask.compute();
                BigDecimal izq = izqTask.join();

                return izq.max(der);
            }
        }
    }

    private static class LibrosMayorPrecio extends RecursiveTask<List<Book>> {
        private List<Book> books;
        private BigDecimal precio;
        private int inicio;
        private int fin;

        public LibrosMayorPrecio(List<Book> books, BigDecimal precio, int inicio, int fin) {
            this.books = books;
            this.precio = precio;
            this.inicio = inicio;
            this.fin = fin;
        }

        @Override
        protected List<Book> compute() {
            if ((fin - inicio) <= 10) {
                List<Book> tmp = new ArrayList<Book>();

                for (int i = inicio; i < fin; i++) {
                    Book actual = books.get(i);
                    if (actual.getPrecio().compareTo(precio) == 0) {
                        tmp.add(actual);
                    }
                }
                return tmp;

            } else {
                int mitad = (inicio + fin) / 2;
                LibrosMayorPrecio izqTask = new LibrosMayorPrecio(books, precio, inicio, mitad);
                LibrosMayorPrecio derTask = new LibrosMayorPrecio(books, precio, mitad, fin);

                izqTask.fork();

                List<Book> der = derTask.compute();
                List<Book> izq = izqTask.join();
                izq.addAll(der);

                return izq;
            }
        }
    }
}
