package com.unir.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InterfazCalculadora extends JFrame {

    // Componentes del Formulario (Izquierda)
    public JTextField txtNombre, txtReferencia, txtConsumo;
    public JComboBox<String> cmbServicio;

    // Botones de Acción
    public JButton btnGuardar, btnCargar, btnModificar, btnGenerar, btnSalir;

    // Botones de Filtro (Derecha)
    public JButton btnSortAlfabetico, btnSortConsumo, btnSortNombre;

    // Componentes de la Tabla
    public JTable tablaResultados;
    public DefaultTableModel modeloTabla;

    public InterfazCalculadora() {
        setTitle("Sistema UNIR S.A. - Gestión de Servicios Públicos");
        setSize(950, 600); // Ventana más ancha para caber la tabla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Color de fondo gris claro moderno
        getContentPane().setBackground(new Color(240, 240, 245));

        // --- TÍTULO ---
        JLabel titulo = new JLabel("Bienvenido al Sistema");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titulo.setForeground(new Color(50, 50, 50));
        titulo.setBounds(320, 20, 400, 40);
        add(titulo);

        // =======================================================
        // PANEL IZQUIERDO (Formulario)
        // =======================================================
        int xIzq = 40;

        crearEtiqueta("Nombre:", xIzq, 80);
        txtNombre = crearInput(xIzq, 110);

        crearEtiqueta("Referencia:", xIzq, 150);
        txtReferencia = crearInput(xIzq, 180);

        crearEtiqueta("Consumo:", xIzq, 220);
        txtConsumo = crearInput(xIzq, 250);

        crearEtiqueta("Servicio Público:", xIzq, 290);
        String[] servicios = {"Energía ($536)", "Agua ($730)", "Gas ($710)"};
        cmbServicio = new JComboBox<>(servicios);
        cmbServicio.setBounds(xIzq, 320, 250, 35);
        cmbServicio.setBackground(Color.WHITE);
        add(cmbServicio);

        // --- BOTONES DE ACCIÓN (Abajo Izquierda) ---
        btnGuardar = crearBoton("Guardar", xIzq, 380, new Color(0, 120, 215)); // Azul
        btnCargar = crearBoton("Cargar", xIzq + 130, 380, new Color(100, 100, 100));

        btnModificar = crearBoton("Modificar", xIzq, 430, new Color(100, 100, 100));
        btnGenerar = crearBoton("Generar", xIzq + 130, 430, new Color(0, 150, 0)); // Verde

        btnSalir = crearBoton("Salir", xIzq + 65, 480, new Color(200, 50, 50)); // Rojo

        // =======================================================
        // PANEL DERECHO (Tabla y Filtros)
        // =======================================================
        int xDer = 350;

        crearEtiqueta("Selecciona servicio a visualizar:", xDer, 80);

        // Botones de Filtro
        btnSortAlfabetico = crearBotonPeque("Alfabético", xDer, 110);
        btnSortConsumo = crearBotonPeque("Consumo", xDer + 110, 110);
        btnSortNombre = crearBotonPeque("Nombre", xDer + 220, 110);

        // --- TABLA ---
        String[] columnas = {"Nombre", "Referencia", "Servicio", "Consumo", "Total ($)"};
        modeloTabla = new DefaultTableModel(null, columnas);
        tablaResultados = new JTable(modeloTabla);

        // Scroll para la tabla
        JScrollPane scroll = new JScrollPane(tablaResultados);
        scroll.setBounds(xDer, 150, 540, 350);
        add(scroll);

        JLabel footer = new JLabel("©2026 TecMD - Miguel Peralta");
        footer.setBounds(xDer, 520, 300, 20);
        footer.setForeground(Color.GRAY);
        add(footer);

        setLocationRelativeTo(null);
    }

    // Métodos auxiliares para diseño limpio
    private void crearEtiqueta(String texto, int x, int y) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lbl.setForeground(new Color(60, 60, 60));
        lbl.setBounds(x, y, 250, 20);
        add(lbl);
    }

    private JTextField crearInput(int x, int y) {
        JTextField txt = new JTextField();
        txt.setBounds(x, y, 250, 30);
        txt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(txt);
        return txt;
    }

    private JButton crearBoton(String texto, int x, int y, Color colorFondo) {
        JButton btn = new JButton(texto);
        btn.setBounds(x, y, 120, 35);
        btn.setBackground(colorFondo);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn.setFocusPainted(false);
        add(btn);
        return btn;
    }

    private JButton crearBotonPeque(String texto, int x, int y) {
        JButton btn = new JButton(texto);
        btn.setBounds(x, y, 100, 30);
        btn.setBackground(new Color(220, 220, 220));
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        add(btn);
        return btn;
    }
}