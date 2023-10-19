/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qpos;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enric
 */
public class Magatzem extends javax.swing.JPanel {

    public Magatzem() {
        initComponents();
        //////omplirTaula();
        omplirTaula();
        
    }

    public void omplirTaula() {

        try {

            DefaultTableModel dt = (DefaultTableModel) taulaProductes.getModel();
            dt.setRowCount(0);

            Statement s = ConnexioBD.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM productes");

            while (rs.next()) {

                ArrayList<String> row = new ArrayList<>();

                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(rs.getString(6));

                dt.addRow(row.toArray());

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void buidaFormulari() {
        
        taulaProductes.clearSelection();
        
        codiText.setText("");
        nomText.setText("");
        eanText.setText("");
        preuText.setText("");
        quantitatText.setText("");
        proveidorText.setText("");
        
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
        jPanel2 = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        codiLabel = new javax.swing.JLabel();
        eanLabel = new javax.swing.JLabel();
        nomLabel = new javax.swing.JLabel();
        preuLabel = new javax.swing.JLabel();
        quantitatLabel = new javax.swing.JLabel();
        proveidorLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        codiText = new javax.swing.JTextField();
        separadorLabel = new javax.swing.JLabel();
        netejaBoto = new javax.swing.JButton();
        eanText = new javax.swing.JTextField();
        nomText = new javax.swing.JTextField();
        preuText = new javax.swing.JTextField();
        quantitatText = new javax.swing.JTextField();
        proveidorText = new javax.swing.JTextField();
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
        buscadorProductes.setText("Busca producte per nom o codi EAN");
        buscadorProductes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscadorProductesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                buscadorProductesFocusLost(evt);
            }
        });
        buscadorProductes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorProductesActionPerformed(evt);
            }
        });
        buscadorProductes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscadorProductesKeyReleased(evt);
            }
        });

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        taulaProductes.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        taulaProductes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codi", "Nom", "EAN", "Preu", "Quantitat", "Proveidor"
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
            taulaProductes.getColumnModel().getColumn(0).setPreferredWidth(2);
            taulaProductes.getColumnModel().getColumn(1).setPreferredWidth(300);
            taulaProductes.getColumnModel().getColumn(2).setPreferredWidth(35);
            taulaProductes.getColumnModel().getColumn(3).setPreferredWidth(3);
            taulaProductes.getColumnModel().getColumn(4).setPreferredWidth(3);
            taulaProductes.getColumnModel().getColumn(5).setPreferredWidth(40);
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
                    .addGroup(buscadorPanelLayout.createSequentialGroup()
                        .addGroup(buscadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buscadorProductes)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
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
                        .addComponent(buscadorProductes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        codiLabel.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        codiLabel.setForeground(new java.awt.Color(237, 242, 244));
        codiLabel.setText("Codi");

        eanLabel.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        eanLabel.setForeground(new java.awt.Color(237, 242, 244));
        eanLabel.setText("Codi EAN");

        nomLabel.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        nomLabel.setForeground(new java.awt.Color(237, 242, 244));
        nomLabel.setText("Nom");

        preuLabel.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        preuLabel.setForeground(new java.awt.Color(237, 242, 244));
        preuLabel.setText("Preu");

        quantitatLabel.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        quantitatLabel.setForeground(new java.awt.Color(237, 242, 244));
        quantitatLabel.setText("Quantitat");

        proveidorLabel.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        proveidorLabel.setForeground(new java.awt.Color(237, 242, 244));
        proveidorLabel.setText("Proveïdor");

        jLabel14.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(237, 242, 244));
        jLabel14.setText("INFORMACIÓ DEL PRODUCTE");

        codiText.setEditable(false);
        codiText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        codiText.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        separadorLabel.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        separadorLabel.setForeground(new java.awt.Color(237, 242, 244));
        separadorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        separadorLabel.setText("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");

        netejaBoto.setBackground(new java.awt.Color(43, 45, 66));
        netejaBoto.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        netejaBoto.setForeground(new java.awt.Color(237, 242, 244));
        netejaBoto.setText("NETEJA");
        netejaBoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netejaBotoActionPerformed(evt);
            }
        });

        eanText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        eanText.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        nomText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        nomText.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        nomText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomTextActionPerformed(evt);
            }
        });

        preuText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        preuText.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        quantitatText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        quantitatText.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        proveidorText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        proveidorText.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        proveidorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveidorTextActionPerformed(evt);
            }
        });

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
                                .addComponent(proveidorLabel)
                                .addGap(34, 34, 34)
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(infoPanelLayout.createSequentialGroup()
                                        .addComponent(netejaBoto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE))
                                    .addComponent(proveidorText)))
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codiLabel)
                                    .addComponent(eanLabel)
                                    .addComponent(nomLabel)
                                    .addComponent(preuLabel)
                                    .addComponent(quantitatLabel))
                                .addGap(38, 38, 38)
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quantitatText)
                                    .addComponent(preuText)
                                    .addComponent(nomText)
                                    .addComponent(eanText)
                                    .addComponent(codiText))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel14))
                            .addComponent(separadorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(codiText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codiLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eanText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eanLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(preuText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(preuLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantitatText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantitatLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(proveidorLabel)
                            .addComponent(proveidorText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(netejaBoto)
                        .addContainerGap())))
        );

        jPanel4.setBackground(new java.awt.Color(217, 4, 41));

        editarBoto.setBackground(new java.awt.Color(43, 45, 66));
        editarBoto.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        editarBoto.setForeground(new java.awt.Color(237, 242, 244));
        editarBoto.setText("EDITAR");
        editarBoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBotoActionPerformed(evt);
            }
        });

        afegirBoto.setBackground(new java.awt.Color(43, 45, 66));
        afegirBoto.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        afegirBoto.setForeground(new java.awt.Color(237, 242, 244));
        afegirBoto.setText("AFEGIR");
        afegirBoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afegirBotoActionPerformed(evt);
            }
        });

        eliminarBoto.setBackground(new java.awt.Color(43, 45, 66));
        eliminarBoto.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        eliminarBoto.setForeground(new java.awt.Color(237, 242, 244));
        eliminarBoto.setText("ELIMINAR");
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
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(editarBoto, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(afegirBoto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminarBoto)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
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
            .addGap(0, 58, Short.MAX_VALUE)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void buscadorProductesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscadorProductesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscadorProductesActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked


    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void taulaProductesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taulaProductesMouseClicked

        // OMPLIR FORMULARI
        
        int fila = taulaProductes.getSelectedRow();

        String codi = taulaProductes.getValueAt(fila, 0).toString();
        String nom = taulaProductes.getValueAt(fila, 1).toString();
        String ean = taulaProductes.getValueAt(fila, 2).toString();
        String preu = taulaProductes.getValueAt(fila, 3).toString();
        String quantitat = taulaProductes.getValueAt(fila, 4).toString();
        String proveidor = taulaProductes.getValueAt(fila, 5).toString();

        codiText.setText(codi);
        nomText.setText(nom);
        eanText.setText(ean);
        preuText.setText(preu);
        quantitatText.setText(quantitat);
        proveidorText.setText(proveidor);

    }//GEN-LAST:event_taulaProductesMouseClicked

    private void nomTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomTextActionPerformed

    private void proveidorTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveidorTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proveidorTextActionPerformed

    private void afegirBotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afegirBotoActionPerformed

        // AFEGIR PRODUCTE
        
        String nom = nomText.getText();
        String ean = eanText.getText();
        String preu = preuText.getText();
        String quantitat = quantitatText.getText();
        String proveidor = proveidorText.getText();

        try {
            
            Statement s = ConnexioBD.mycon().createStatement();
            s.executeUpdate("INSERT INTO productes (nomProducte,codiEAN,preu,quantitat,proveidor) VALUES ('" + nom + "','" + ean + "','" + preu + "','" + quantitat + "','" + proveidor + "')");
            
        } catch (SQLException e) {
            
            System.out.println(e);
            
        }

        omplirTaula();
        
    }//GEN-LAST:event_afegirBotoActionPerformed

    private void netejaBotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netejaBotoActionPerformed

        buidaFormulari();
        
    }//GEN-LAST:event_netejaBotoActionPerformed

    private void eliminarBotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBotoActionPerformed
        
        // ELIMINAR PRODUCTE

        String codiProducte = codiText.getText();

        try {
            
            Statement s = ConnexioBD.mycon().createStatement();
            s.executeUpdate("DELETE FROM productes WHERE codiProducte = '" + codiProducte + "' ");

        } catch (HeadlessException | SQLException e) {
            
            System.out.println(e);
            
        }

        omplirTaula();

    }//GEN-LAST:event_eliminarBotoActionPerformed

    private void editarBotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBotoActionPerformed

        // EDITAR PRODUCTE
        
        String codiProducte = codiText.getText();
        String nom = nomText.getText();
        String ean = eanText.getText();
        String preu = preuText.getText();
        String quantitat = quantitatText.getText();
        String proveidor = proveidorText.getText();

        try {

            Statement s = ConnexioBD.mycon().createStatement();
            s.executeUpdate("UPDATE productes SET nomProducte='" + nom + "',codiEAN='" + ean + "' ,preu='" + preu + "',quantitat='" + quantitat + "',proveidor='" + proveidor + "' WHERE codiProducte ='" + codiProducte + "' ");

        } catch (SQLException e) {
            
            System.out.println(e);
            
        }

        omplirTaula();
        
    }//GEN-LAST:event_editarBotoActionPerformed

    private void buscadorProductesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorProductesKeyReleased
        String producteABuscar = buscadorProductes.getText();
        
        try {
            
            DefaultTableModel dt = (DefaultTableModel) taulaProductes.getModel();
            dt.setRowCount(0);
            
            if (producteABuscar.length() >= 3) {
                
                Statement s = ConnexioBD.mycon().createStatement();           
                ResultSet rs = s.executeQuery("SELECT * FROM productes WHERE nomProducte LIKE '"+producteABuscar+"%' OR codiEAN LIKE '"+producteABuscar+"%'");

                while (rs.next()) {

                    ArrayList<String> row = new ArrayList<>();

                    row.add(rs.getString(1));
                    row.add(rs.getString(2));
                    row.add(rs.getString(3));
                    row.add(rs.getString(4));
                    row.add(rs.getString(5));
                    row.add(rs.getString(6));

                    dt.addRow(row.toArray());

                }
                
            }
           
        } catch (SQLException e) {
            
        }
    }//GEN-LAST:event_buscadorProductesKeyReleased

    private void buscadorProductesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorProductesFocusGained
        buscadorProductes.setText("");
    }//GEN-LAST:event_buscadorProductesFocusGained

    private void buscadorProductesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorProductesFocusLost
        if (buscadorProductes.getText().isEmpty()){
            buscadorProductes.setText("Busca producte per nom o codi EAN");
        } 
    }//GEN-LAST:event_buscadorProductesFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton afegirBoto;
    private javax.swing.JPanel buscadorPanel;
    private javax.swing.JTextField buscadorProductes;
    private javax.swing.JLabel codiLabel;
    private javax.swing.JTextField codiText;
    private javax.swing.JLabel eanLabel;
    private javax.swing.JTextField eanText;
    private javax.swing.JButton editarBoto;
    private javax.swing.JButton eliminarBoto;
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
    private javax.swing.JLabel proveidorLabel;
    private javax.swing.JTextField proveidorText;
    private javax.swing.JLabel quantitatLabel;
    private javax.swing.JTextField quantitatText;
    private javax.swing.JLabel separadorLabel;
    private javax.swing.JTable taulaProductes;
    // End of variables declaration//GEN-END:variables
}
