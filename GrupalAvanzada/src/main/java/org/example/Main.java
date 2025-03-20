package org.example;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import org.eclipse.swt.widgets.Display;
import org.example.interfazGrafica.VentanaPrincipal;
import org.example.repository.impl.BookRepositoryImpl;

public class Main {

    public static void main(String[] args) {

        /* TRABAJO GRUPAL FINAL PROGRAMACIÓN AVANZADA II

            GRUPO 3

            FRANK ANTHONY CAJAMARCA SANTACRUZ
            NELSON ARMANDO VALLE GARCÍA

         */

        SeContainer container = SeContainerInitializer.newInstance().initialize();
        var servicioBooks = container.select(BookRepositoryImpl.class).get();

        Display display = new Display();
        VentanaPrincipal ventana = new VentanaPrincipal(display);
        ventana.abrirVentana();
        ventana.runEventLoop();
        display.dispose();

    }
}