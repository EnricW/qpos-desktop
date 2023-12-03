package vista;

import controlador.ProducteC;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import model.ProducteM;
import model.nouProducteM;
import util.GestorErrors;

/**
 * Classe que representa la pantalla de productes
 *
 * @author Enric
 */
public class ProducteV extends javax.swing.JPanel {

    /**
     * Instància de ProducteC
     */
    ProducteC producteC = new ProducteC();

    /**
     * Map per guardar la relació entre idProveidor i nomProveidor
     */
    private Map<Integer, String> proveidorMap;

    /**
     * Set per a detectar proveidors únics
     */
    private Set<String> nomsProveidorUnics;

    private List<ProducteM> producteList; // New List to store products

    private String missatgeBuscador = "Busca tots els productes o busca per ID";

    /**
     * Constructor sense paràmetres
     */
    public ProducteV() {
        initComponents();
        inicialitzaProveidorMap();
        producteList = new ArrayList<>(); // Initialize the producteList
    }

    /**
     * Constructor amb paràmetres
     *
     * @param producteM
     * @param producteC
     */
    public ProducteV(ProducteM producteM, ProducteC producteC) {
        this(); // Truca al constructor sense paràmetres
        this.producteC = producteC;
        inicialitzaProveidorMap();
    }

    /**
     * Mètode per inicialitzar el Map de proveidors
     */
    private void inicialitzaProveidorMap() {
        // Inicialitza el proveidorMap i nomsProveidorUnics
        proveidorMap = new HashMap<>();
        nomsProveidorUnics = new HashSet<>();
    }

    /**
     * Mètode per mostrar productes a la taula
     */
    public void actualitzaModelDeTaula() {
        DefaultTableModel modelDeTaula = (DefaultTableModel) taulaProductes.getModel();
        modelDeTaula.setRowCount(0); // Esborra les dades existents

        // Crida el mètode getProductes a ProducteC per obtenir les dades actualitzades del producte
        ProducteM producteM = producteC.getProductes();

        if (producteM != null && producteM.getProductes() != null) {

            // Esborra els elements existents al JComboBox
            proveidorComboBox.removeAllItems();
            // Esborra el conjunt nomsProveidorUnics
            nomsProveidorUnics.clear();

            // Omple el proveidorMap i el JComboBox
            for (ProducteM producte : producteM.getProductes()) {
                int proveidorId = producte.getProveidor().getId();
                String proveidorNom = producte.getProveidor().getNom();

                // Comprova si el nom del proveidor encara no s'ha afegit
                if (nomsProveidorUnics.add(proveidorNom)) {
                    proveidorMap.put(proveidorId, proveidorNom);
                    proveidorComboBox.addItem(proveidorNom);
                }
            }

            producteList = Arrays.asList(producteM.getProductes()); // Convert array to List

            // Omple el model de la taula amb les dades de l'array de ProducteM
            for (ProducteM producte : producteM.getProductes()) {
                Object[] dadesFila = {
                    producte.getId(),
                    producte.getNom(),
                    producte.getCodiBarres(),
                    producte.getPreu(),
                    producte.getEstoc(),
                    // Mostra el nomProveidor a la taula
                    proveidorMap.get(producte.getProveidor().getId())
                };
                modelDeTaula.addRow(dadesFila);
            }

        } else {
            GestorErrors.displayError("Error en recuperar les dades del producte.");
        }
    }

    /**
     * Mètode per obtenir i mostrar un producte específic a la taula
     *
     * @param idProducte
     */
    private void mostrarProducte(int idProducte) {
        // Obté el producte utilitzant el mètode getProducte a ProducteC
        ProducteM producte = producteC.getProducte(idProducte);

        // Comprova si el producte no és nul
        if (producte != null) {
            // Esborra els elements existents al JComboBox
            proveidorComboBox.removeAllItems();
            // Esborra el conjunt nomsProveidorUnics
            nomsProveidorUnics.clear();

            // Omple el proveidorMap i el JComboBox amb el proveidor del producte individual
            int proveidorId = producte.getProveidor().getId();
            String proveidorNom = producte.getProveidor().getNom();

            // Comprova si el nom del proveidor encara no s'ha afegit
            if (nomsProveidorUnics.add(proveidorNom)) {
                proveidorMap.put(proveidorId, proveidorNom);
                proveidorComboBox.addItem(proveidorNom);
            }

            // Esborra el model de la taula
            DefaultTableModel modelDeTaula = (DefaultTableModel) taulaProductes.getModel();
            modelDeTaula.setRowCount(0);

            // Omple la taula amb les dades del producte individual
            Object[] dadesFila = {
                producte.getId(),
                producte.getNom(),
                producte.getCodiBarres(),
                producte.getPreu(),
                producte.getEstoc(),
                proveidorNom
            };
            modelDeTaula.addRow(dadesFila);

            // Store the single product in the list
            producteList = new ArrayList<>(Arrays.asList(producte));
            producteList.add(producte);
        } else {
            GestorErrors.displayError("Error en recuperar les dades del producte amb ID: " + idProducte);
        }
    }

    /**
     * Mètode per buidar el formulari
     */
    public void buidaFormulari() {
        taulaProductes.clearSelection();

        nomText.setText("");
        descripcioText.setText("");
        eanText.setText("");
        preuText.setText("");
        estocText.setText("");
    }

    /**
     * Mètode per buidar la taula
     */
    public void buidaTaula() {
        DefaultTableModel modelDeTaula = (DefaultTableModel) taulaProductes.getModel();
        modelDeTaula.setRowCount(0);

        // Clear the product list
        producteList = new ArrayList<>(producteList);
        producteList.clear();
    }

    /**
     * Mètode per retornar el valor Integer en el Map per els proveidors
     *
     * @param value
     * @return La id del proveidor
     */
    private Integer getKeyByValue(String value) {
        for (Map.Entry<Integer, String> entry : proveidorMap.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buscadorPanel = new javax.swing.JPanel();
        buscadorProductes = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taulaProductes = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        botoNetejaBuscadorProducte = new javax.swing.JButton();
        botoBuscaProducte = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        nomLabel = new javax.swing.JLabel();
        eanLabel = new javax.swing.JLabel();
        descripcioLabel = new javax.swing.JLabel();
        preuLabel = new javax.swing.JLabel();
        estocLabel = new javax.swing.JLabel();
        proveidorLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        nomText = new javax.swing.JTextField();
        separadorLabel = new javax.swing.JLabel();
        netejaBoto = new javax.swing.JButton();
        eanText = new javax.swing.JTextField();
        descripcioText = new javax.swing.JTextField();
        preuText = new javax.swing.JTextField();
        estocText = new javax.swing.JTextField();
        proveidorComboBox = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        editarBoto = new javax.swing.JButton();
        afegirBoto = new javax.swing.JButton();
        eliminarBoto = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(217, 4, 41));

        buscadorPanel.setBackground(new java.awt.Color(217, 4, 41));

        buscadorProductes.setBackground(new java.awt.Color(237, 242, 244));
        buscadorProductes.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        buscadorProductes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscadorProductes.setText("Busca tots els productes o busca per ID");
        buscadorProductes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscadorProductesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                buscadorProductesFocusLost(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N

        taulaProductes.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        taulaProductes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codi", "Nom", "Codi de barres", "Preu", "Estoc", "Proveidor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        taulaProductes.getTableHeader().setReorderingAllowed(false);
        taulaProductes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taulaProductesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(taulaProductes);
        taulaProductes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (taulaProductes.getColumnModel().getColumnCount() > 0) {
            taulaProductes.getColumnModel().getColumn(0).setResizable(false);
            taulaProductes.getColumnModel().getColumn(0).setPreferredWidth(4);
            taulaProductes.getColumnModel().getColumn(1).setResizable(false);
            taulaProductes.getColumnModel().getColumn(1).setPreferredWidth(280);
            taulaProductes.getColumnModel().getColumn(2).setResizable(false);
            taulaProductes.getColumnModel().getColumn(2).setPreferredWidth(110);
            taulaProductes.getColumnModel().getColumn(3).setResizable(false);
            taulaProductes.getColumnModel().getColumn(3).setPreferredWidth(30);
            taulaProductes.getColumnModel().getColumn(4).setResizable(false);
            taulaProductes.getColumnModel().getColumn(4).setPreferredWidth(10);
            taulaProductes.getColumnModel().getColumn(5).setResizable(false);
            taulaProductes.getColumnModel().getColumn(5).setPreferredWidth(160);
        }
        taulaProductes.setRowHeight(30);

        jPanel6.setBackground(new java.awt.Color(217, 4, 41));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(217, 4, 41));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(217, 4, 41));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        botoNetejaBuscadorProducte.setBackground(new java.awt.Color(43, 45, 66));
        botoNetejaBuscadorProducte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/XB.png"))); // NOI18N
        botoNetejaBuscadorProducte.setBorder(null);
        botoNetejaBuscadorProducte.setBorderPainted(false);
        botoNetejaBuscadorProducte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoNetejaBuscadorProducteActionPerformed(evt);
            }
        });

        botoBuscaProducte.setBackground(new java.awt.Color(43, 45, 66));
        botoBuscaProducte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/lupaB.png"))); // NOI18N
        botoBuscaProducte.setBorder(null);
        botoBuscaProducte.setBorderPainted(false);
        botoBuscaProducte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoBuscaProducteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buscadorPanelLayout = new javax.swing.GroupLayout(buscadorPanel);
        buscadorPanel.setLayout(buscadorPanelLayout);
        buscadorPanelLayout.setHorizontalGroup(
            buscadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscadorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(buscadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buscadorPanelLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscadorPanelLayout.createSequentialGroup()
                        .addGroup(buscadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(buscadorPanelLayout.createSequentialGroup()
                                .addComponent(botoBuscaProducte, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscadorProductes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botoNetejaBuscadorProducte, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)))
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        buscadorPanelLayout.setVerticalGroup(
            buscadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buscadorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(buscadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buscadorPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(buscadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buscadorProductes, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(botoNetejaBuscadorProducte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botoBuscaProducte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscadorPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buscadorPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
        );

        jPanel2.setBackground(new java.awt.Color(217, 4, 41));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        infoPanel.setBackground(new java.awt.Color(217, 4, 41));

        jPanel8.setBackground(new java.awt.Color(217, 4, 41));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(217, 4, 41));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        nomLabel.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        nomLabel.setForeground(new java.awt.Color(237, 242, 244));
        nomLabel.setText("Nom");

        eanLabel.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        eanLabel.setForeground(new java.awt.Color(237, 242, 244));
        eanLabel.setText("Codi EAN");

        descripcioLabel.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        descripcioLabel.setForeground(new java.awt.Color(237, 242, 244));
        descripcioLabel.setText("Descripcio");

        preuLabel.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        preuLabel.setForeground(new java.awt.Color(237, 242, 244));
        preuLabel.setText("Preu");

        estocLabel.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        estocLabel.setForeground(new java.awt.Color(237, 242, 244));
        estocLabel.setText("Estoc");

        proveidorLabel.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        proveidorLabel.setForeground(new java.awt.Color(237, 242, 244));
        proveidorLabel.setText("Proveïdor");

        jLabel14.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(237, 242, 244));
        jLabel14.setText("INFORMACIÓ DEL PRODUCTE");

        nomText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        nomText.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        separadorLabel.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        separadorLabel.setForeground(new java.awt.Color(237, 242, 244));
        separadorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        separadorLabel.setText("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");

        netejaBoto.setBackground(new java.awt.Color(43, 45, 66));
        netejaBoto.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        netejaBoto.setForeground(new java.awt.Color(237, 242, 244));
        netejaBoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/buida2.png"))); // NOI18N
        netejaBoto.setText(" BUIDA FORMULARI");
        netejaBoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netejaBotoActionPerformed(evt);
            }
        });

        eanText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        eanText.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        descripcioText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        descripcioText.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        preuText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        preuText.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        estocText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        estocText.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        proveidorComboBox.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 29, Short.MAX_VALUE))
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomLabel)
                                    .addComponent(eanLabel)
                                    .addComponent(descripcioLabel)
                                    .addComponent(preuLabel)
                                    .addComponent(estocLabel)
                                    .addComponent(proveidorLabel))
                                .addGap(38, 38, 38)
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(proveidorComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(estocText)
                                    .addComponent(preuText)
                                    .addComponent(descripcioText)
                                    .addComponent(eanText)
                                    .addComponent(nomText))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel14))
                            .addComponent(separadorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(netejaBoto, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorLabel)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eanText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eanLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descripcioText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descripcioLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(preuText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(preuLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estocText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estocLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(proveidorLabel)
                            .addComponent(proveidorComboBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(netejaBoto, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))))
        );

        jPanel4.setBackground(new java.awt.Color(217, 4, 41));

        editarBoto.setBackground(new java.awt.Color(43, 45, 66));
        editarBoto.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        editarBoto.setForeground(new java.awt.Color(237, 242, 244));
        editarBoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/editar2.png"))); // NOI18N
        editarBoto.setText(" EDITAR");
        editarBoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBotoActionPerformed(evt);
            }
        });

        afegirBoto.setBackground(new java.awt.Color(43, 45, 66));
        afegirBoto.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        afegirBoto.setForeground(new java.awt.Color(237, 242, 244));
        afegirBoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/afegir2.png"))); // NOI18N
        afegirBoto.setText(" AFEGIR");
        afegirBoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afegirBotoActionPerformed(evt);
            }
        });

        eliminarBoto.setBackground(new java.awt.Color(43, 45, 66));
        eliminarBoto.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        eliminarBoto.setForeground(new java.awt.Color(237, 242, 244));
        eliminarBoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/eliminar2.png"))); // NOI18N
        eliminarBoto.setText(" ELIMINAR");
        eliminarBoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(editarBoto, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(afegirBoto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminarBoto)
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editarBoto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(afegirBoto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarBoto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(217, 4, 41));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscadorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscadorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void afegirBotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afegirBotoActionPerformed
        try {
            // Comprova si el ComboBox de proveïdor està buit
            if (proveidorComboBox.getItemCount() == 0) {
                // Gestionar l'error quan no hi ha proveïdors disponibles
                GestorErrors.displayError("No hi ha proveïdors disponibles.");
            } else {
                int proveidor_id = getKeyByValue(proveidorComboBox.getSelectedItem().toString());
                String nom = nomText.getText();
                String descripcio = descripcioText.getText();
                String preuTextValue = preuText.getText();
                String eanTextValue = eanText.getText();
                String estocTextValue = estocText.getText();

                // Comprova si hi ha algun camp buit
                if (nom.isEmpty() || descripcio.isEmpty() || preuTextValue.isEmpty() || eanTextValue.isEmpty() || estocTextValue.isEmpty()) {
                    // Gestionar l'error quan algun camp està buit
                    GestorErrors.displayError("Cal omplir tots els camps abans d'afegir un nou producte.");
                } else {
                    double preu = Double.parseDouble(preuTextValue);
                    String codiean = eanTextValue;
                    int estoc = Integer.parseInt(estocTextValue);

                    // Crea un objecte nouProducteM amb les dades del formulari
                    nouProducteM nouproducte = new nouProducteM();
                    nouproducte.setProveidor_id(proveidor_id);
                    nouproducte.setNom(nom);
                    nouproducte.setDescripcio(descripcio);
                    nouproducte.setPreu(preu);
                    nouproducte.setCodiBarres(codiean);
                    nouproducte.setEstoc(estoc);

                    // Crida al mètode afegeixProducte a ProducteC
                    producteC.afegeixProducte(nouproducte);
                    
                    // Actualitzar la taula després de l'eliminació
                    actualitzaModelDeTaula();
                }
            }
        } catch (NumberFormatException e) {
            // Gestiona l'error en cas de que no sigui un valor numèric
            GestorErrors.displayError("Entrada no vàlida per a valors numèrics");
        }
    }//GEN-LAST:event_afegirBotoActionPerformed

    private void netejaBotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netejaBotoActionPerformed
        buidaFormulari();
    }//GEN-LAST:event_netejaBotoActionPerformed

    private void eliminarBotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBotoActionPerformed
        // Obtenir l'índex de la fila seleccionada
        int filaSeleccionada = taulaProductes.getSelectedRow();

        // Comprovar si s'ha seleccionat una fila
        if (filaSeleccionada != -1 && filaSeleccionada < producteList.size()) {
            // Obtenir l'ID del producte de la fila seleccionada
            int idProducte = producteList.get(filaSeleccionada).getId();

            // Cridar al mètode eliminarProducte a ProducteC amb aquest ID
            producteC.eliminarProducte(idProducte);

            // Actualitzar la taula després de l'eliminació i buida formulari
            actualitzaModelDeTaula();
            buidaFormulari();
        } else {
            // Si no s'ha seleccionat cap fila, mostrar un missatge d'error
            GestorErrors.displayError("Cal seleccionar un producte per eliminar-lo.");
        }
    }//GEN-LAST:event_eliminarBotoActionPerformed

    private void editarBotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBotoActionPerformed
        try {
            // Obté l'índex de la fila seleccionada
            int filaSeleccionada = taulaProductes.getSelectedRow();

            // Comprova si s'ha seleccionat una fila
            if (filaSeleccionada != -1) {
                // Obté l'objecte ProducteM de la llista
                ProducteM selectedProduct = producteList.get(filaSeleccionada);

                // Comprova si el ComboBox de proveïdor està buit
                if (proveidorComboBox.getItemCount() == 0) {
                    // Gestiona l'error quan no hi ha proveïdors disponibles
                    GestorErrors.displayError("No hi ha proveïdors disponibles.");
                } else {
                    int proveidor_id = getKeyByValue(proveidorComboBox.getSelectedItem().toString());
                    String nom = nomText.getText();
                    String descripcio = descripcioText.getText();
                    String preuTextValue = preuText.getText();
                    String eanTextValue = eanText.getText();
                    String estocTextValue = estocText.getText();

                    // Comprova si hi ha algun camp buit
                    if (nom.isEmpty() || descripcio.isEmpty() || preuTextValue.isEmpty() || eanTextValue.isEmpty() || estocTextValue.isEmpty()) {
                        // Gestionar l'error quan algun camp està buit
                        GestorErrors.displayError("Cal omplir tots els camps abans d'editar un producte.");
                    } else {
                        double preu = Double.parseDouble(preuTextValue);
                        String codiean = eanTextValue;
                        int estoc = Integer.parseInt(estocTextValue);

                        // Crea un objecte nouProducteM amb la informació actualitzada
                        nouProducteM producteEditat = new nouProducteM();
                        producteEditat.setProveidor_id(proveidor_id);
                        producteEditat.setNom(nom);
                        producteEditat.setDescripcio(descripcio);
                        producteEditat.setPreu(preu);
                        producteEditat.setCodiBarres(codiean);
                        producteEditat.setEstoc(estoc);

                        // Crida al mètode editarProducte a ProducteC
                        producteC.editarProducte(selectedProduct.getId(), producteEditat);

                        // Actualitza la taula després de l'edició
                        actualitzaModelDeTaula();
                    }
                }
            } else {
                // Si no s'ha seleccionat cap fila, mostra un missatge d'error
                GestorErrors.displayError("Cal seleccionar un producte per editar-lo.");
            }
        } catch (NumberFormatException e) {
            // Gestionar el cas en què el text no sigui un número vàlid
            GestorErrors.displayError("Entrada no vàlida per a valors numèrics");
        }
    }//GEN-LAST:event_editarBotoActionPerformed

    private void taulaProductesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taulaProductesMouseClicked
        // Omplir el formulari
        int fila = taulaProductes.getSelectedRow();

        if (fila != -1 && fila < producteList.size()) {
            ProducteM selectedProduct = producteList.get(fila);

            nomText.setText(selectedProduct.getNom());
            descripcioText.setText(selectedProduct.getDescripcio());
            eanText.setText(selectedProduct.getCodiBarres());
            preuText.setText(String.valueOf(selectedProduct.getPreu()));
            estocText.setText(String.valueOf(selectedProduct.getEstoc()));
            proveidorComboBox.setSelectedItem(proveidorMap.get(selectedProduct.getProveidor().getId()));
        }
    }//GEN-LAST:event_taulaProductesMouseClicked

    private void buscadorProductesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorProductesFocusLost
        if (buscadorProductes.getText().isEmpty()) {
            buscadorProductes.setText(missatgeBuscador);
        }
    }//GEN-LAST:event_buscadorProductesFocusLost

    private void buscadorProductesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorProductesFocusGained
        buscadorProductes.setText("");
    }//GEN-LAST:event_buscadorProductesFocusGained

    private void botoBuscaProducteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoBuscaProducteActionPerformed
        // Obtenir el text del camp de text BuscadorProductes
        String idProducteText = buscadorProductes.getText();

        // Comprovar si el text no és buit 
        if (!idProducteText.isEmpty()) {
            try {
                // Intenta analitzar el text per obtenir la identificació del producte
                int idProducte = Integer.parseInt(idProducteText);

                // Crida al mètode per mostrar el producte individual a la taula
                mostrarProducte(idProducte);
            } catch (NumberFormatException e) {
                // Gestionar el cas en què idProducteText no sigui un enter vàlid
                System.out.println("Format d'ID de producte no vàlid. Mostrant tots els productes en lloc d'això.");

                // Mostra tots els productes
                actualitzaModelDeTaula();
            }
        } else {
            // Si el text és buit, obtenir tots els productes i omplir la taula
            actualitzaModelDeTaula();
        }
    }//GEN-LAST:event_botoBuscaProducteActionPerformed

    private void botoNetejaBuscadorProducteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoNetejaBuscadorProducteActionPerformed
        buscadorProductes.setText(missatgeBuscador);
        proveidorComboBox.removeAllItems();
        buidaFormulari();
        buidaTaula();
    }//GEN-LAST:event_botoNetejaBuscadorProducteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton afegirBoto;
    private javax.swing.JButton botoBuscaProducte;
    private javax.swing.JButton botoNetejaBuscadorProducte;
    private javax.swing.JPanel buscadorPanel;
    private javax.swing.JTextField buscadorProductes;
    private javax.swing.JLabel descripcioLabel;
    private javax.swing.JTextField descripcioText;
    private javax.swing.JLabel eanLabel;
    private javax.swing.JTextField eanText;
    private javax.swing.JButton editarBoto;
    private javax.swing.JButton eliminarBoto;
    private javax.swing.JLabel estocLabel;
    private javax.swing.JTextField estocText;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton netejaBoto;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JTextField nomText;
    private javax.swing.JLabel preuLabel;
    private javax.swing.JTextField preuText;
    private javax.swing.JComboBox<String> proveidorComboBox;
    private javax.swing.JLabel proveidorLabel;
    private javax.swing.JLabel separadorLabel;
    private javax.swing.JTable taulaProductes;
    // End of variables declaration//GEN-END:variables
}
