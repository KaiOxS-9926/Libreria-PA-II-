package org.example.interfazGrafica;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.example.db.Book;
import org.example.db.Author;
import org.example.repository.interfaces.AuthorRepository;
import org.example.repository.interfaces.BookRepository;

import java.math.BigDecimal;
import java.util.List;

public class DialogoLibro {

    private Shell parent;
    private Shell shell;
    private Book libro;
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DialogoLibro(Shell parent, Book libro, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.parent = parent;
        this.libro = libro;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public void open() {
        shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
        shell.setText(libro == null ? "Agregar Libro" : "Editar Libro");
        shell.setSize(350, 250);
        shell.setLayout(new GridLayout(2, false));

        Label lblTitulo = new Label(shell, SWT.NONE);
        lblTitulo.setText("Título:");
        Text txtTitulo = new Text(shell, SWT.BORDER);
        txtTitulo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        Label lblISBN = new Label(shell, SWT.NONE);
        lblISBN.setText("ISBN:");
        Text txtISBN = new Text(shell, SWT.BORDER);
        txtISBN.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        Label lblPrecio = new Label(shell, SWT.NONE);
        lblPrecio.setText("Precio:");
        Text txtPrecio = new Text(shell, SWT.BORDER);
        txtPrecio.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        Label lblAutor = new Label(shell, SWT.NONE);
        lblAutor.setText("Autor:");
        Combo comboAutor = new Combo(shell, SWT.DROP_DOWN | SWT.READ_ONLY);
        comboAutor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        List<Author> autores = (List<Author>) authorRepository.findAll();
        for (Author a : autores) {
            comboAutor.add(a.getNombre() + " " + a.getApellido());
        }

        if (libro != null) {
            txtTitulo.setText(libro.getTitulo() != null ? libro.getTitulo() : "");
            txtISBN.setText(libro.getIsbn() != null ? libro.getIsbn() : "");
            txtPrecio.setText(libro.getPrecio() != null ? libro.getPrecio().toString() : "");
            if (libro.getAuthor() != null) {
                String autorStr = libro.getAuthor().getNombre() + " " + libro.getAuthor().getApellido();
                int index = comboAutor.indexOf(autorStr);
                if (index >= 0) {
                    comboAutor.select(index);
                }
            }
        }

        Composite compBotones = new Composite(shell, SWT.NONE);
        compBotones.setLayout(new GridLayout(2, true));
        compBotones.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

        Button btnGuardar = new Button(compBotones, SWT.PUSH);
        btnGuardar.setText("Guardar");
        btnGuardar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        Button btnCancelar = new Button(compBotones, SWT.PUSH);
        btnCancelar.setText("Cancelar");
        btnCancelar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        btnGuardar.addListener(SWT.Selection, e -> {
            String titulo = txtTitulo.getText().trim();
            String isbn = txtISBN.getText().trim();
            String precioStr = txtPrecio.getText().trim();
            int selectedIndex = comboAutor.getSelectionIndex();

            if (titulo.isEmpty() || isbn.isEmpty() || precioStr.isEmpty() || selectedIndex < 0) {
                mostrarMensaje("Todos los campos son obligatorios.");
                return;
            }

            BigDecimal precio;
            try {
                precio = new BigDecimal(precioStr);
            } catch (NumberFormatException ex) {
                mostrarMensaje("Precio inválido.");
                return;
            }

            Author autor = autores.get(selectedIndex);

            if (libro == null) {
                libro = new Book();
            }
            libro.setTitulo(titulo);
            libro.setIsbn(isbn);
            libro.setPrecio(precio);
            libro.setAuthor(autor);

            if (libro.getId() == null) {
                bookRepository.guardar(libro);
            } else {
                bookRepository.actualizar(libro);
            }
            shell.close();
        });

        btnCancelar.addListener(SWT.Selection, e -> shell.close());

        shell.open();
        Display display = parent.getDisplay();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    private void mostrarMensaje(String mensaje) {
        MessageBox msg = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
        msg.setMessage(mensaje);
        msg.open();
    }
}
