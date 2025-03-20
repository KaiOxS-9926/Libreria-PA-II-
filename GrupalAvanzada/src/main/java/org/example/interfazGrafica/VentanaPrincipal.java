package org.example.interfazGrafica;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.example.db.Author;
import org.example.db.Book;
import org.example.precios.HighPrice;
import org.example.repository.interfaces.AuthorRepository;
import org.example.repository.interfaces.BookRepository;

import jakarta.enterprise.inject.spi.CDI;

import java.util.List;

public class VentanaPrincipal {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    private Shell shell;
    private Display display;

    private Table tablaAutores;
    private Table tablaLibros;

    public VentanaPrincipal(Display display) {
        this.display = display;
        this.authorRepository = CDI.current().select(AuthorRepository.class).get();
        this.bookRepository = CDI.current().select(BookRepository.class).get();
    }

    public void abrirVentana() {
        shell = new Shell(display);
        shell.setText("Authors - Books");
        shell.setSize(800, 600);
        shell.setLayout(new GridLayout(1, false));

        TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
        tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        crearTabAutores(tabFolder);
        crearTabLibros(tabFolder);

        refrescarTablaAutores();
        refrescarTablaLibros();

        shell.open();
    }

    public void runEventLoop() {
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    private void crearTabAutores(TabFolder tabFolder) {
        TabItem tabAutores = new TabItem(tabFolder, SWT.NONE);
        tabAutores.setText("Autores");
        Composite compAutores = new Composite(tabFolder, SWT.NONE);
        compAutores.setLayout(new GridLayout(2, false));
        tabAutores.setControl(compAutores);

        tablaAutores = new Table(compAutores, SWT.BORDER | SWT.FULL_SELECTION);
        tablaAutores.setHeaderVisible(true);
        tablaAutores.setLinesVisible(true);
        tablaAutores.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        TableColumn colId = new TableColumn(tablaAutores, SWT.NONE);
        colId.setText("ID");
        colId.setWidth(50);
        TableColumn colNombre = new TableColumn(tablaAutores, SWT.NONE);
        colNombre.setText("Nombre");
        colNombre.setWidth(150);
        TableColumn colApellido = new TableColumn(tablaAutores, SWT.NONE);
        colApellido.setText("Apellido");
        colApellido.setWidth(150);

        Composite compBotonesAutores = new Composite(compAutores, SWT.NONE);
        compBotonesAutores.setLayout(new GridLayout(1, false));
        compBotonesAutores.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));

        Button btnAgregarAutor = new Button(compBotonesAutores, SWT.PUSH);
        btnAgregarAutor.setText("Agregar Autor");
        Button btnEditarAutor = new Button(compBotonesAutores, SWT.PUSH);
        btnEditarAutor.setText("Editar Autor");
        Button btnEliminarAutor = new Button(compBotonesAutores, SWT.PUSH);
        btnEliminarAutor.setText("Eliminar Autor");

        btnAgregarAutor.addListener(SWT.Selection, e -> {
            DialogoAutor dialogo = new DialogoAutor(shell, null, authorRepository);
            dialogo.open();
            refrescarTablaAutores();
        });

        btnEditarAutor.addListener(SWT.Selection, e -> {
            TableItem[] seleccion = tablaAutores.getSelection();
            if (seleccion.length > 0) {
                Author autor = (Author) seleccion[0].getData();
                DialogoAutor dialogo = new DialogoAutor(shell, autor, authorRepository);
                dialogo.open();
                refrescarTablaAutores();
            } else {
                mostrarMensaje("Seleccione un autor a editar.");
            }
        });

        btnEliminarAutor.addListener(SWT.Selection, e -> {
            TableItem[] seleccion = tablaAutores.getSelection();
            if (seleccion.length > 0) {
                Author autor = (Author) seleccion[0].getData();
                MessageBox confirm = new MessageBox(shell, SWT.ICON_WARNING | SWT.YES | SWT.NO);
                confirm.setMessage("¿Está seguro de eliminar el autor?");

                if (confirm.open() == SWT.YES) {
                    try {
                        Author managedAutor = authorRepository.findBy(autor.getId());
                        if (managedAutor != null) {
                            authorRepository.remove(managedAutor);
                            refrescarTablaAutores();
                        } else {
                            mostrarMensaje("El autor no existe o ya fue eliminado.");
                        }
                    } catch (Exception ex) {
                        mostrarMensaje("No se puede eliminar el autor porque tiene libros asociados.");
                    }
                }
            } else {
                mostrarMensaje("Seleccione un autor a eliminar.");
            }
        });


    }

    private void crearTabLibros(TabFolder tabFolder) {
        TabItem tabLibros = new TabItem(tabFolder, SWT.NONE);
        tabLibros.setText("Libros");
        Composite compLibros = new Composite(tabFolder, SWT.NONE);
        compLibros.setLayout(new GridLayout(2, false));
        tabLibros.setControl(compLibros);

        // Tabla para libros
        tablaLibros = new Table(compLibros, SWT.BORDER | SWT.FULL_SELECTION);
        tablaLibros.setHeaderVisible(true);
        tablaLibros.setLinesVisible(true);
        tablaLibros.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        TableColumn colLibroId = new TableColumn(tablaLibros, SWT.NONE);
        colLibroId.setText("ID");
        colLibroId.setWidth(50);
        TableColumn colTitulo = new TableColumn(tablaLibros, SWT.NONE);
        colTitulo.setText("Título");
        colTitulo.setWidth(150);
        TableColumn colISBN = new TableColumn(tablaLibros, SWT.NONE);
        colISBN.setText("ISBN");
        colISBN.setWidth(100);
        TableColumn colPrecio = new TableColumn(tablaLibros, SWT.NONE);
        colPrecio.setText("Precio");
        colPrecio.setWidth(100);
        TableColumn colAutor = new TableColumn(tablaLibros, SWT.NONE);
        colAutor.setText("Autor");
        colAutor.setWidth(150);

        // Panel de botones para libros
        Composite compBotonesLibros = new Composite(compLibros, SWT.NONE);
        compBotonesLibros.setLayout(new GridLayout(1, false));
        compBotonesLibros.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));

        Button btnAgregarLibro = new Button(compBotonesLibros, SWT.PUSH);
        btnAgregarLibro.setText("Agregar Libro");
        Button btnEditarLibro = new Button(compBotonesLibros, SWT.PUSH);
        btnEditarLibro.setText("Editar Libro");
        Button btnEliminarLibro = new Button(compBotonesLibros, SWT.PUSH);
        btnEliminarLibro.setText("Eliminar Libro");
        Button btnBuscarLibroCaro = new Button(compBotonesLibros, SWT.PUSH);
        btnBuscarLibroCaro.setText("Libro con mayor precio");

        // Acciones para los botones de Libros
        btnAgregarLibro.addListener(SWT.Selection, e -> {
            DialogoLibro dialogo = new DialogoLibro(shell, null, authorRepository, bookRepository);
            dialogo.open();
            refrescarTablaLibros();
        });

        btnEditarLibro.addListener(SWT.Selection, e -> {
            TableItem[] seleccion = tablaLibros.getSelection();
            if (seleccion.length > 0) {
                Book libro = (Book) seleccion[0].getData();
                DialogoLibro dialogo = new DialogoLibro(shell, libro, authorRepository, bookRepository);
                dialogo.open();
                refrescarTablaLibros();
            } else {
                mostrarMensaje("Seleccione un libro a editar.");
            }
        });

        btnEliminarLibro.addListener(SWT.Selection, e -> {
            TableItem[] seleccion = tablaLibros.getSelection();
            if (seleccion.length > 0) {
                Book libro = (Book) seleccion[0].getData();
                MessageBox confirm = new MessageBox(shell, SWT.ICON_WARNING | SWT.YES | SWT.NO);
                confirm.setMessage("¿Está seguro de eliminar el libro?");
                if (confirm.open() == SWT.YES) {
                    bookRepository.borrar(libro.getId());
                    refrescarTablaLibros();
                }
            } else {
                mostrarMensaje("Seleccione un libro a eliminar.");
            }
        });

        btnBuscarLibroCaro.addListener(SWT.Selection, e -> {
            List<HighPrice> resultado = bookRepository.MayorPrecioConcurrente();
            if (resultado.isEmpty()) {
                mostrarMensaje("No se encontró libro con mayor precio.");
            } else {
                HighPrice dto = resultado.get(0);
                mostrarMensaje("Libro con mayor precio:\nTítulo: " + dto.getTitulo() +
                        "\nPrecio: " + dto.getPrecio() +
                        "\nISBN: " + dto.getIsbn());
            }
        });
    }

    private void refrescarTablaAutores() {
        tablaAutores.removeAll();
        List<Author> autores = (List<Author>) authorRepository.findAll();
        for (Author a : autores) {
            TableItem item = new TableItem(tablaAutores, SWT.NONE);
            item.setText(new String[]{String.valueOf(a.getId()), a.getNombre(), a.getApellido()});
            item.setData(a);
        }
    }

    private void refrescarTablaLibros() {
        tablaLibros.removeAll();
        List<Book> libros = bookRepository.findAll();
        for (Book b : libros) {
            String autorNombre = (b.getAuthor() != null) ? b.getAuthor().getNombre() : "";
            TableItem item = new TableItem(tablaLibros, SWT.NONE);
            item.setText(new String[]{String.valueOf(b.getId()), b.getTitulo(), b.getIsbn(), b.getPrecio().toString(), autorNombre});
            item.setData(b);
        }
    }

    private void mostrarMensaje(String mensaje) {
        MessageBox msg = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
        msg.setMessage(mensaje);
        msg.open();
    }
}
