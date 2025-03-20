package org.example.interfazGrafica;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.example.db.Author;
import org.example.repository.interfaces.AuthorRepository;

public class DialogoAutor {

    private Shell parent;
    private Shell shell;
    private Author autor;
    private AuthorRepository authorRepository;

    public DialogoAutor(Shell parent, Author autor, AuthorRepository authorRepository) {
        this.parent = parent;
        this.autor = autor;
        this.authorRepository = authorRepository;
    }

    public void open() {
        shell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
        shell.setText(autor == null ? "Agregar Autor" : "Editar Autor");
        shell.setSize(300, 200);
        shell.setLayout(new GridLayout(2, false));

        Label lblNombre = new Label(shell, SWT.NONE);
        lblNombre.setText("Nombre:");
        Text txtNombre = new Text(shell, SWT.BORDER);
        txtNombre.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        Label lblApellido = new Label(shell, SWT.NONE);
        lblApellido.setText("Apellido:");
        Text txtApellido = new Text(shell, SWT.BORDER);
        txtApellido.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        if (autor != null) {
            txtNombre.setText(autor.getNombre() != null ? autor.getNombre() : "");
            txtApellido.setText(autor.getApellido() != null ? autor.getApellido() : "");
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
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            if (nombre.isEmpty()) {
                mostrarMensaje("El nombre es obligatorio.");
                return;
            }
            if (autor == null) {
                autor = new Author();

            }
            autor.setNombre(nombre);
            autor.setApellido(apellido);

            authorRepository.save(autor);
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
