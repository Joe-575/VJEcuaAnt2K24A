package VJUIC.VJForm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import VJBLC.VJCatalogo;
import VJDAC.VJHormigueroDAC;
import VJDAC.VJDAO.*;
import VJDAC.VJDTO.*;
import VJInfra.VJConfig;
import VJUIC.VJEcuaAntStyle;

public class VJHormigaPanel extends JPanel {

    private JLabel titleLabel;
    private JTable tableHormiga;
    private JScrollPane scrollPane;
    private JComboBox<String> comboBox1, comboBox2;
    private JButton btnCrearLarva, btnAlimentar, btnEntrenar, btnEliminar, btnGuardar;
    private JLabel footerLabel;
    private JPanel tablePanel;
    private Map<Integer, Boolean> entrenar = new HashMap<>();

    public VJHormigaPanel() {

        setLayout(new BorderLayout());
        
        // inserta la imagen
        ImageIcon imageIcon = new ImageIcon(VJEcuaAntStyle.VJURL_MAIN);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(400, 250, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.NORTH);
        
        
        JPanel titleAndTablePanel = new JPanel();
        titleAndTablePanel.setLayout(new BorderLayout());

        titleLabel = new JLabel("GENO HORMIGUERO EXPERIMENTAL", SwingConstants.CENTER);
        titleLabel.setForeground(VJEcuaAntStyle.VJCOLOR_CURSOR);
        titleAndTablePanel.add(titleLabel, BorderLayout.NORTH);

        tablePanel = new JPanel(new BorderLayout());
        titleAndTablePanel.add(tablePanel, BorderLayout.CENTER);

        add(titleAndTablePanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        JPanel comboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        comboBox1 = new JComboBox<>();
        comboBox2 = new JComboBox<>();
        comboBox1.setPreferredSize(new Dimension(150, 30));
        comboBox2.setPreferredSize(new Dimension(150, 30));
        comboPanel.add(comboBox1);
        comboPanel.add(comboBox2);
        bottomPanel.add(comboPanel);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        btnCrearLarva = new JButton("Crear Larva");
        btnCrearLarva.setBackground(VJEcuaAntStyle.VJCOLOR_FONT_LIGHT);

        btnAlimentar = new JButton("Alimentar");
        btnAlimentar.setBackground(VJEcuaAntStyle.VJCOLOR_FONT_LIGHT);

        btnEntrenar = new JButton("Entrenar");
        btnEntrenar.setBackground(VJEcuaAntStyle.VJCOLOR_FONT_LIGHT);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(VJEcuaAntStyle.VJCOLOR_FONT_LIGHT);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(VJEcuaAntStyle.VJCOLOR_FONT_LIGHT);

        btnCrearLarva.addActionListener(e -> vjCrearLarva());
        btnAlimentar.addActionListener(e -> vjAlimentar());
        btnEntrenar.addActionListener(e -> vjEntrenarHormiga());
        btnEliminar.addActionListener(e -> vjEliminar());
        btnGuardar.addActionListener(e -> vjGuardar());

        buttonPanel.add(btnCrearLarva);
        buttonPanel.add(btnAlimentar);
        buttonPanel.add(btnEntrenar);
        buttonPanel.add(btnEliminar);
        buttonPanel.add(btnGuardar);
        bottomPanel.add(buttonPanel);

        footerLabel = new JLabel("PROGRAMACION II | Cedula: 1754711958 | Joel Velez");
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        footerPanel.add(footerLabel);
        bottomPanel.add(footerPanel);
        add(bottomPanel, BorderLayout.SOUTH);

        // Carga de datos iniciales en la tabla y carga de combos
        try {
            vjShowData();
            vjLoadComboBoxes();
            vjUpdateComboBoxes();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void vjShowData() throws Exception {
        String[] columnNames = { "ID", "TIPOHORMIGA", "SEXO", "ALIMENTO", "ESTADO", "ENTRENADA" };

        List<VJHormigaDTO> hormigasList = new VJHormigaDAO().readVw();

        Object[][] data = new Object[hormigasList.size()][6];

        int index = 0;
        for (VJHormigaDTO VJhor : hormigasList) {
            data[index][0] = VJhor.getIdHormiga();
            data[index][1] = VJhor.getNombre();
            data[index][2] = VJhor.getSexo();
            data[index][3] = VJhor.getIngestaNativa();
            data[index][4] = VJhor.getEstado();
            data[index][5] = VJhor.getEntrenada();
            index++;
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        if (tableHormiga != null) {
            tableHormiga.setModel(model);
        } else {
            tableHormiga = new JTable(model);
            scrollPane = new JScrollPane(tableHormiga);
            tablePanel.add(scrollPane, BorderLayout.CENTER);
        }

        JTableHeader header = tableHormiga.getTableHeader();
        header.setFont(VJEcuaAntStyle.VJFONT);

        tableHormiga.getSelectionModel().clearSelection();
        vjUpdateComboBoxes();

        tablePanel.revalidate();
        tablePanel.repaint();
        vjEntrenada();
    }


    private void vjLoadComboBoxes() throws Exception{
        comboBox1.removeAllItems();
        comboBox2.removeAllItems();

        VJCatalogo catalogo = new VJCatalogo();
        Map<Integer, String> genoAlimentoMap = catalogo.raGetAllHormigaTipoGeno();
        Map<Integer, String> ingestaNativaMap = catalogo.raGetAllHormigaTipoIngesta();
    
        for (String geno : genoAlimentoMap.values()) {
            comboBox1.addItem(geno);
        }
        for (String ingesta : ingestaNativaMap.values()) {
            comboBox2.addItem(ingesta);
        }
    }


    private void vjUpdateComboBoxes() {
        tableHormiga.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && tableHormiga.getSelectedRow() != -1) {
                int selectedRow = tableHormiga.getSelectedRow();
    
                String vjsexo = (String) tableHormiga.getValueAt(selectedRow, 2); 
                String vjalimentacion = (String) tableHormiga.getValueAt(selectedRow, 3); 
                String vjgenoAlimento;
                switch (vjsexo.toLowerCase()) {
                    case "asexual": vjgenoAlimento = "X"; break;
                    case "hembra": vjgenoAlimento = "XY";break;
                    default: vjgenoAlimento = ""; break;
                }
    
                comboBox1.setSelectedItem(vjgenoAlimento);
                comboBox2.setSelectedItem(vjalimentacion);
            }
        });
    }

    private void vjCrearLarva() {
        if (!VJConfig.showConfirmYesNo("¿Está seguro de crear una Hormiga larva?")) {
            return;
        }
    
        try {
            VJHormigaDAO dao = new VJHormigaDAO();
            VJHormigaDTO nuevaLarva = new VJHormigaDTO();
    
            // Corrección de los valores según la tabla proporcionada
            nuevaLarva.setIdCatalogoTipo(7);  // HLarva
            nuevaLarva.setIdCatalogoSexo(10); // Asexual
            nuevaLarva.setIdCatalogoEstado(11); // Viva
            nuevaLarva.setIdCatalogoGenoAlimento(16); // Genoma X
            nuevaLarva.setIdCatalogoIngestaNativa(14); // Nectarívoro
            nuevaLarva.setEntrenada("NO"); // No entrenada
            nuevaLarva.setEstado("A"); // Activa
    
            // Intentar crear la larva en la BD
            if (dao.vjcreate(nuevaLarva)) {
                VJConfig.showMsg("Larva creada exitosamente.");
                vjShowData();  //  Actualizar la tabla para reflejar el nuevo dato
            } else {
                VJConfig.showMsgError("Error al crear la larva.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            VJConfig.showMsgError("Error: " + e.getMessage());
        }
    }
    
    
    private void vjAlimentar() {
        try {
            int selectedRow = tableHormiga.getSelectedRow();
            if (selectedRow == -1) {
                VJConfig.showMsg("Por favor, selecciona una hormiga.");
                return;
            }
    
            int idHormiga = (Integer) tableHormiga.getValueAt(selectedRow, 0);
            System.out.println("ID de la hormiga seleccionada: " + idHormiga);
    
            VJHormigaDAO dao = new VJHormigaDAO();
            VJHormigaDTO hormiga = dao.vjreadBy(idHormiga);
    
            if (hormiga == null) {
                VJConfig.showMsgError("No se encontró la hormiga con el ID seleccionado.");
                return;
            }
    
            // Definir constantes para IDs de catálogos
            final int ESTADO_MUERTA = 12;
            final int ESTADO_VIVA = 11;
            final int TIPO_LARVA = 7;
            final int TIPO_SOLDADO = 8;
            final int SEXO_MACHO = 9;
            final int ALIMENTO_CARNIVORO = 13;
            final int ALIMENTO_NECTARIVORO = 14;
            
            // Verificar si la hormiga está muerta
            if (hormiga.getIdCatalogoEstado() == ESTADO_MUERTA) {
                VJConfig.showMsgError("No se puede alimentar a una hormiga muerta.");
                return;
            }
    
            // Obtener los valores seleccionados en los comboboxes
            String genoAlimento = (String) comboBox1.getSelectedItem();
            String ingestaNativa = (String) comboBox2.getSelectedItem();
    
            if (genoAlimento == null || ingestaNativa == null) {
                VJConfig.showMsgError("Selecciona una opción válida para la alimentación.");
                return;
            }
    
            boolean isCarnivoro = "Carnivoro".equals(ingestaNativa);
            boolean isNectarivoro = "Nectarívoros".equals(ingestaNativa);
            boolean isGenomaXY = "XY".equals(genoAlimento);
            boolean isGenomaX = "X".equals(genoAlimento);
            boolean isGenomaXX = "XX".equals(genoAlimento);
    
            boolean isUpdated = false;
    
            // Lógica de alimentación e inyección de genoma
            if (hormiga.getIdCatalogoTipo() == TIPO_LARVA) {
                if (isCarnivoro && isGenomaXY) {
                    //  Larva + Carnívoro (inyectado con XY) -> Soldado, Macho, Viva
                    hormiga.setIdCatalogoTipo(TIPO_SOLDADO);
                    hormiga.setIdCatalogoSexo(SEXO_MACHO);
                    hormiga.setIdCatalogoEstado(ESTADO_VIVA);
                    VJConfig.showMsg("La Larva ha evolucionado a Soldado.");
                } else if (isNectarivoro && (isGenomaX || isGenomaXY || isGenomaXX)) {
                    //  Larva + Nectarívoro (inyectado con cualquier genoma) -> Sigue viva
                    VJConfig.showMsg("Alimentaste a la Larva, sigue viva.");
                } else {
                    //  Cualquier otro caso -> Muere
                    hormiga.setIdCatalogoEstado(ESTADO_MUERTA);
                    VJConfig.showMsgError("Ups...! La Larva ha muerto.");
                }
                isUpdated = true;
            } else if (hormiga.getIdCatalogoTipo() == TIPO_SOLDADO) {
                if (isCarnivoro && isGenomaXY) {
                    // Soldado + Carnívoro (inyectado con XY) -> Sigue vivo
                    VJConfig.showMsg("El Soldado ha comido correctamente.");
                } else {
                    // Cualquier otro caso -> Muere
                    hormiga.setIdCatalogoEstado(ESTADO_MUERTA);
                    VJConfig.showMsgError("Ups...! El Soldado ha muerto.");
                    isUpdated = true;
                }
            } else {
                VJConfig.showMsg("Esta hormiga no necesita alimentación especial.");
            }
    
            // Actualizar en la BD solo si hubo cambios
            if (isUpdated && dao.vjupdate(hormiga)) {
                vjShowData();
            } else if (isUpdated) {
                VJConfig.showMsgError("Error al actualizar la hormiga.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            VJConfig.showMsgError("Error: " + e.getMessage());
        }
    }
    
    

    private void vjEntrenarHormiga() {
        try {
            int selectedRow = tableHormiga.getSelectedRow();
            if (selectedRow == -1) {
                VJConfig.showMsgError("Por favor, selecciona una hormiga.");
                return;
            }
    
            int idHormiga = (Integer) tableHormiga.getValueAt(selectedRow, 0);
            String tipoHormiga = (String) tableHormiga.getValueAt(selectedRow, 1);
    
            VJHormigaDAO dao = new VJHormigaDAO();
            VJHormigaDTO hormiga = dao.vjreadBy(idHormiga);
    
            if (hormiga == null) {
                VJConfig.showMsgError("No se encontró la hormiga con el ID seleccionado.");
                return;
            }
    
            if (hormiga.getIdCatalogoTipo() == 6) {
                VJConfig.showMsgError("Las larvas no pueden ser entrenadas.");
                return;
            }
            if (hormiga.getIdCatalogoEstado() != 12) {  
                tableHormiga.setValueAt("SI", selectedRow, 5);  
                hormiga.setEntrenada("SI");  

                if (dao.vjupdate(hormiga)) {
                    VJConfig.showMsg(tipoHormiga + " entrenada y sumisa.");
                } else {
                    VJConfig.showMsgError("Error al entrenar la hormiga.");
                }
            } else {
                VJConfig.showMsgError("La hormiga está muerta y no puede ser entrenada.");
            }
    
        } catch (Exception ex) {
            ex.printStackTrace();
            VJConfig.showMsgError("Error: " + ex.getMessage());
        }
    }
       
    private void vjEliminar() {
        try {
            int selectedRow = tableHormiga.getSelectedRow();
            if (selectedRow == -1) {
                VJConfig.showMsgError( "Por favor, selecciona una hormiga.");
                return;
            }

            int idHormiga = (Integer) tableHormiga.getValueAt(selectedRow, 0);
            String tipoHormiga = (String) tableHormiga.getValueAt(selectedRow, 1);
            String estadoActual = (String) tableHormiga.getValueAt(selectedRow, 4);

            if ("MUERTA".equalsIgnoreCase(estadoActual)) {
                VJConfig.showMsgError( "La hormiga está muerta.");
                return;
            }

            int response = JOptionPane.showConfirmDialog(
                null, 
                "¿Está seguro de eliminar a " + tipoHormiga + "?",
                "Confirmar Eliminación",
                JOptionPane.YES_NO_OPTION
            );

            if (response == JOptionPane.NO_OPTION) {
                return;
            }

            VJHormigaDAO dao = new VJHormigaDAO();
            VJHormigaDTO hormiga = dao.vjreadBy(idHormiga);

            if (hormiga == null) {
                VJConfig.showMsgError( "No se ha encontró la hormiga.");
                return;
            }

            hormiga.setIdCatalogoEstado(12); 
            if (dao.vjupdate(hormiga)) {
                VJConfig.showMsg("Hormiga eliminada correctamente.");
                vjShowData();
            } else {
                VJConfig.showMsgError("Error al eliminar la hormiga.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            VJConfig.showMsgError("Error: " + e.getMessage());
        }
    }

    private void vjGuardar() {
        try {
            if (tableHormiga.getRowCount() == 0) {
                VJConfig.showMsgError( "No hay datos para guardar.");
                return;
            }

            VJHormigueroDAC VJhormigueroD = new VJHormigueroDAC();
            List<String> dataToSave = new ArrayList<>();

            for (int i = 0; i < tableHormiga.getRowCount(); i++) {
                int id = (Integer) tableHormiga.getValueAt(i, 0);
                String tipo = (String) tableHormiga.getValueAt(i, 1);
                String sexo = (String) tableHormiga.getValueAt(i, 2);
                String alimentacion = (String) tableHormiga.getValueAt(i, 3);
                String estado = (String) tableHormiga.getValueAt(i, 4);
                String entrenada = (String) tableHormiga.getValueAt(i, 5);

                String rowData = String.format("%d,%s,%s,%s,%s,%s", id, tipo, sexo, alimentacion, estado, entrenada);
                dataToSave.add(rowData);
            }

            VJhormigueroD.saveHormigueroCSV(dataToSave);
            VJConfig.showMsg("Datos guardados en CSV correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
            VJConfig.showMsgError("Error al guardar: " + e.getMessage());
        }
    }

    private void vjEntrenada() {
        for (int i = 0; i < tableHormiga.getRowCount(); i++) {
            int idHormiga = (Integer) tableHormiga.getValueAt(i, 0);
            if (entrenar.containsKey(idHormiga)) {
                tableHormiga.setValueAt(entrenar.get(idHormiga) ? "SI" : "NO", i, 5);
            }
        }
    }
    

}
