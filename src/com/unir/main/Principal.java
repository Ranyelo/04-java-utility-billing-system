package com.unir.main;

import com.unir.modelo.*;
import com.unir.vista.InterfazCalculadora;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Principal {


    private static ArrayList<ServicioPublico> registroServicios = new ArrayList<>();

    public static void main(String[] args) {
        InterfazCalculadora vista = new InterfazCalculadora();
        vista.setVisible(true);

        // -------------------------------------------------
        // ACCIÓN: BOTÓN GUARDAR (Agregar a la Tabla y al Registro)
        // -------------------------------------------------
        vista.btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ServicioPublico servicio = obtenerServicioDesdeVista(vista);
                    double total = servicio.calcularPago();

                    // 1. Guardar el objeto en nuestro REGISTRO
                    registroServicios.add(servicio);

                    // 2. Mostrarlo visualmente en la fila de la tabla
                    Object[] fila = {
                            servicio.getNombreUsuario(),
                            "Ref: " + vista.txtReferencia.getText(),
                            vista.cmbServicio.getSelectedItem().toString(),
                            servicio.getConsumo(),
                            "$" + total
                    };
                    vista.modeloTabla.addRow(fila);

                    // 3. Limpiar los campos para ingresar el siguiente
                    vista.txtNombre.setText("");
                    vista.txtReferencia.setText("");
                    vista.txtConsumo.setText("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(vista, "Faltan datos numéricos o textos.");
                }
            }
        });

        // -------------------------------------------------
        // ACCIÓN: BOTÓN GENERAR
        // -------------------------------------------------
        vista.btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verificar si hay datos en el registro
                if (registroServicios.isEmpty()) {
                    JOptionPane.showMessageDialog(vista, "El registro está vacío. Por favor guarde servicios primero.");
                    return;
                }

                // Armar el texto del reporte final
                StringBuilder reporte = new StringBuilder();
                reporte.append("--- REGISTRO FINAL DE SERVICIOS CALCULADOS ---\n\n");

                double sumaTotal = 0; // Para sumar todo lo recaudado

                // Recorrer nuestra lista de registro para mostrar cada uno
                for (ServicioPublico s : registroServicios) {
                    double pago = s.calcularPago();
                    sumaTotal += pago; // Acumular el total

                    reporte.append("Usuario: ").append(s.getNombreUsuario())
                            .append(" | Consumo: ").append(s.getConsumo())
                            .append(" | Pago: $").append(pago).append("\n");
                }

                reporte.append("\n====================================\n");
                reporte.append("TOTAL GENERAL FACTURADO: $").append(sumaTotal);

                // Mostrar el registro en un Pop-up
                JOptionPane.showMessageDialog(vista, reporte.toString(), "Reporte de Registro", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // -------------------------------------------------
        // ACCIÓN: BOTÓN SALIR
        // -------------------------------------------------
        vista.btnSalir.addActionListener(e -> System.exit(0));
    }

    // Metodo auxiliar para no repetir código al crear el objeto
    private static ServicioPublico obtenerServicioDesdeVista(InterfazCalculadora vista) {
        String nombre = vista.txtNombre.getText();
        String ref = vista.txtReferencia.getText();
        double consumo = Double.parseDouble(vista.txtConsumo.getText());
        int seleccion = vista.cmbServicio.getSelectedIndex();

        if (seleccion == 0) return new Energia(nombre, ref, consumo);
        if (seleccion == 1) return new Agua(nombre, ref, consumo);
        return new Gas(nombre, ref, consumo);
    }
}
