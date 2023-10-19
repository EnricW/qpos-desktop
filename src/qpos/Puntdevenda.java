/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qpos;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enric
 */
public class Puntdevenda extends javax.swing.JPanel {

    public Puntdevenda() {
        initComponents();
    }

    private void actualitzaTotal() {
        DefaultTableModel model = (DefaultTableModel) taulaProductesTicket.getModel();

        double total = 0.0;

        for (int row = 0; row < model.getRowCount(); row++) {
            Object preuProducte = model.getValueAt(row, 2);

            if (preuProducte instanceof Number) {
                total += ((Number) preuProducte).doubleValue();
            } else if (preuProducte instanceof String) {
                try {
                    total += Double.parseDouble((String) preuProducte);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }

        subtotalQuantitat.setText(String.format("%.2f", total));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productePanel = new javax.swing.JPanel();
        buscadorProductes = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taulaProductes = new javax.swing.JTable();
        separador1 = new javax.swing.JPanel();
        separador2 = new javax.swing.JPanel();
        separador3 = new javax.swing.JPanel();
        botoNetejaBuscadorProducte = new javax.swing.JButton();
        botoBuscaProducte = new javax.swing.JButton();
        operacionsPanel = new javax.swing.JPanel();
        clientPanel = new javax.swing.JPanel();
        buscadorClients = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        taulaProductesTicket = new javax.swing.JTable();
        separador4 = new javax.swing.JPanel();
        separador5 = new javax.swing.JPanel();
        botoBuscaClient = new javax.swing.JButton();
        botoNetejaBuscadorClient = new javax.swing.JButton();
        calculsPanel = new javax.swing.JPanel();
        subtotalQuantitat = new javax.swing.JLabel();
        cupoText = new javax.swing.JTextField();
        subtotalLabel = new javax.swing.JLabel();
        cupoQuantitat = new javax.swing.JLabel();
        liniesDiscontinues = new javax.swing.JLabel();
        totalQuantitat = new javax.swing.JLabel();
        totalText = new javax.swing.JLabel();
        subtotalEur = new javax.swing.JLabel();
        cupoEur = new javax.swing.JLabel();
        totalEur = new javax.swing.JLabel();
        pagamentPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(217, 4, 41));

        productePanel.setBackground(new java.awt.Color(217, 4, 41));

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
        buscadorProductes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscadorProductesKeyReleased(evt);
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
        if (taulaProductes.getColumnModel().getColumnCount() > 0) {
            taulaProductes.getColumnModel().getColumn(0).setMinWidth(70);
            taulaProductes.getColumnModel().getColumn(0).setPreferredWidth(70);
            taulaProductes.getColumnModel().getColumn(0).setMaxWidth(70);
            taulaProductes.getColumnModel().getColumn(1).setMinWidth(400);
            taulaProductes.getColumnModel().getColumn(1).setPreferredWidth(400);
            taulaProductes.getColumnModel().getColumn(1).setMaxWidth(400);
            taulaProductes.getColumnModel().getColumn(2).setMinWidth(120);
            taulaProductes.getColumnModel().getColumn(2).setPreferredWidth(120);
            taulaProductes.getColumnModel().getColumn(2).setMaxWidth(120);
            taulaProductes.getColumnModel().getColumn(3).setMinWidth(70);
            taulaProductes.getColumnModel().getColumn(3).setPreferredWidth(70);
            taulaProductes.getColumnModel().getColumn(3).setMaxWidth(70);
            taulaProductes.getColumnModel().getColumn(4).setMinWidth(50);
            taulaProductes.getColumnModel().getColumn(4).setPreferredWidth(50);
            taulaProductes.getColumnModel().getColumn(4).setMaxWidth(50);
            taulaProductes.getColumnModel().getColumn(5).setResizable(false);
            taulaProductes.getColumnModel().getColumn(5).setPreferredWidth(200);
        }
        taulaProductes.setRowHeight(30);

        separador1.setBackground(new java.awt.Color(217, 4, 41));

        javax.swing.GroupLayout separador1Layout = new javax.swing.GroupLayout(separador1);
        separador1.setLayout(separador1Layout);
        separador1Layout.setHorizontalGroup(
            separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separador1Layout.setVerticalGroup(
            separador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        separador2.setBackground(new java.awt.Color(217, 4, 41));

        javax.swing.GroupLayout separador2Layout = new javax.swing.GroupLayout(separador2);
        separador2.setLayout(separador2Layout);
        separador2Layout.setHorizontalGroup(
            separador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );
        separador2Layout.setVerticalGroup(
            separador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        separador3.setBackground(new java.awt.Color(217, 4, 41));

        javax.swing.GroupLayout separador3Layout = new javax.swing.GroupLayout(separador3);
        separador3.setLayout(separador3Layout);
        separador3Layout.setHorizontalGroup(
            separador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );
        separador3Layout.setVerticalGroup(
            separador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        botoNetejaBuscadorProducte.setBackground(new java.awt.Color(43, 45, 66));
        botoNetejaBuscadorProducte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/XB.png"))); // NOI18N
        botoNetejaBuscadorProducte.setBorder(null);
        botoNetejaBuscadorProducte.setBorderPainted(false);

        botoBuscaProducte.setBackground(new java.awt.Color(43, 45, 66));
        botoBuscaProducte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/lupaB.png"))); // NOI18N
        botoBuscaProducte.setBorder(null);
        botoBuscaProducte.setBorderPainted(false);

        javax.swing.GroupLayout productePanelLayout = new javax.swing.GroupLayout(productePanel);
        productePanel.setLayout(productePanelLayout);
        productePanelLayout.setHorizontalGroup(
            productePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(productePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(separador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, productePanelLayout.createSequentialGroup()
                        .addComponent(botoBuscaProducte, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscadorProductes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botoNetejaBuscadorProducte, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        productePanelLayout.setVerticalGroup(
            productePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscadorProductes, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(botoNetejaBuscadorProducte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botoBuscaProducte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(productePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(separador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
        );

        operacionsPanel.setBackground(new java.awt.Color(217, 4, 41));

        javax.swing.GroupLayout operacionsPanelLayout = new javax.swing.GroupLayout(operacionsPanel);
        operacionsPanel.setLayout(operacionsPanelLayout);
        operacionsPanelLayout.setHorizontalGroup(
            operacionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        operacionsPanelLayout.setVerticalGroup(
            operacionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        clientPanel.setBackground(new java.awt.Color(217, 4, 41));

        buscadorClients.setBackground(new java.awt.Color(237, 242, 244));
        buscadorClients.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        buscadorClients.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscadorClients.setText("Busca client per DNI");
        buscadorClients.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscadorClientsFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                buscadorClientsFocusLost(evt);
            }
        });
        buscadorClients.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscadorClientsKeyReleased(evt);
            }
        });

        taulaProductesTicket.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        taulaProductesTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codi", "Nom", "Preu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        taulaProductesTicket.getTableHeader().setReorderingAllowed(false);
        taulaProductesTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taulaProductesTicketMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(taulaProductesTicket);
        if (taulaProductesTicket.getColumnModel().getColumnCount() > 0) {
            taulaProductesTicket.getColumnModel().getColumn(0).setMinWidth(40);
            taulaProductesTicket.getColumnModel().getColumn(0).setPreferredWidth(40);
            taulaProductesTicket.getColumnModel().getColumn(0).setMaxWidth(40);
            taulaProductesTicket.getColumnModel().getColumn(1).setResizable(false);
            taulaProductesTicket.getColumnModel().getColumn(2).setMinWidth(70);
            taulaProductesTicket.getColumnModel().getColumn(2).setPreferredWidth(70);
            taulaProductesTicket.getColumnModel().getColumn(2).setMaxWidth(70);
        }
        taulaProductesTicket.setRowHeight(30);

        separador4.setBackground(new java.awt.Color(217, 4, 41));

        javax.swing.GroupLayout separador4Layout = new javax.swing.GroupLayout(separador4);
        separador4.setLayout(separador4Layout);
        separador4Layout.setHorizontalGroup(
            separador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separador4Layout.setVerticalGroup(
            separador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );

        separador5.setBackground(new java.awt.Color(217, 4, 41));

        javax.swing.GroupLayout separador5Layout = new javax.swing.GroupLayout(separador5);
        separador5.setLayout(separador5Layout);
        separador5Layout.setHorizontalGroup(
            separador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 68, Short.MAX_VALUE)
        );
        separador5Layout.setVerticalGroup(
            separador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        botoBuscaClient.setBackground(new java.awt.Color(43, 45, 66));
        botoBuscaClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/lupaB.png"))); // NOI18N
        botoBuscaClient.setBorder(null);
        botoBuscaClient.setBorderPainted(false);

        botoNetejaBuscadorClient.setBackground(new java.awt.Color(43, 45, 66));
        botoNetejaBuscadorClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/XB.png"))); // NOI18N
        botoNetejaBuscadorClient.setBorder(null);
        botoNetejaBuscadorClient.setBorderPainted(false);

        javax.swing.GroupLayout clientPanelLayout = new javax.swing.GroupLayout(clientPanel);
        clientPanel.setLayout(clientPanelLayout);
        clientPanelLayout.setHorizontalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(separador4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(clientPanelLayout.createSequentialGroup()
                        .addComponent(botoBuscaClient, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscadorClients)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botoNetejaBuscadorClient, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separador5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        clientPanelLayout.setVerticalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clientPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buscadorClients, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(botoBuscaClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botoNetejaBuscadorClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(separador5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))))
        );

        calculsPanel.setBackground(new java.awt.Color(217, 4, 41));

        subtotalQuantitat.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        subtotalQuantitat.setForeground(new java.awt.Color(237, 242, 244));
        subtotalQuantitat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        subtotalQuantitat.setText("0");

        cupoText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        cupoText.setForeground(new java.awt.Color(141, 153, 174));
        cupoText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cupoText.setText("VALIDA CUPÓ");
        cupoText.setToolTipText("VALIDA CUPÓ");

        subtotalLabel.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        subtotalLabel.setForeground(new java.awt.Color(237, 242, 244));
        subtotalLabel.setText("SUBTOTAL");

        cupoQuantitat.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        cupoQuantitat.setForeground(new java.awt.Color(237, 242, 244));
        cupoQuantitat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cupoQuantitat.setText("0");

        liniesDiscontinues.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        liniesDiscontinues.setForeground(new java.awt.Color(237, 242, 244));
        liniesDiscontinues.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        liniesDiscontinues.setText("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");

        totalQuantitat.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        totalQuantitat.setForeground(new java.awt.Color(237, 242, 244));
        totalQuantitat.setText("0");

        totalText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        totalText.setForeground(new java.awt.Color(237, 242, 244));
        totalText.setText("TOTAL");

        subtotalEur.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        subtotalEur.setForeground(new java.awt.Color(237, 242, 244));
        subtotalEur.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        subtotalEur.setText("€");

        cupoEur.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        cupoEur.setForeground(new java.awt.Color(237, 242, 244));
        cupoEur.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cupoEur.setText("€");

        totalEur.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        totalEur.setForeground(new java.awt.Color(237, 242, 244));
        totalEur.setText("€");

        javax.swing.GroupLayout calculsPanelLayout = new javax.swing.GroupLayout(calculsPanel);
        calculsPanel.setLayout(calculsPanelLayout);
        calculsPanelLayout.setHorizontalGroup(
            calculsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calculsPanelLayout.createSequentialGroup()
                .addComponent(liniesDiscontinues, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calculsPanelLayout.createSequentialGroup()
                .addGroup(calculsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(calculsPanelLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(subtotalLabel))
                    .addGroup(calculsPanelLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(cupoText, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(calculsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(subtotalQuantitat)
                    .addComponent(cupoQuantitat, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(calculsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(subtotalEur)
                    .addComponent(cupoEur))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calculsPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(totalQuantitat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalEur)
                .addGap(26, 26, 26))
            .addGroup(calculsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(calculsPanelLayout.createSequentialGroup()
                    .addGap(122, 122, 122)
                    .addComponent(totalText)
                    .addContainerGap(302, Short.MAX_VALUE)))
        );
        calculsPanelLayout.setVerticalGroup(
            calculsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calculsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(calculsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subtotalQuantitat)
                    .addComponent(subtotalLabel)
                    .addComponent(subtotalEur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(calculsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cupoText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cupoQuantitat)
                    .addComponent(cupoEur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(liniesDiscontinues)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(calculsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalQuantitat)
                    .addComponent(totalEur)))
            .addGroup(calculsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calculsPanelLayout.createSequentialGroup()
                    .addContainerGap(101, Short.MAX_VALUE)
                    .addComponent(totalText)
                    .addGap(1, 1, 1)))
        );

        pagamentPanel.setBackground(new java.awt.Color(217, 4, 41));

        jButton1.setBackground(new java.awt.Color(43, 45, 66));
        jButton1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(237, 242, 244));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/efectiu_1.png"))); // NOI18N
        jButton1.setText("EFECTIU");

        jButton2.setBackground(new java.awt.Color(43, 45, 66));
        jButton2.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(237, 242, 244));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imatges/tarjeta_1.png"))); // NOI18N
        jButton2.setText("TARJETA");

        javax.swing.GroupLayout pagamentPanelLayout = new javax.swing.GroupLayout(pagamentPanel);
        pagamentPanel.setLayout(pagamentPanelLayout);
        pagamentPanelLayout.setHorizontalGroup(
            pagamentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagamentPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pagamentPanelLayout.setVerticalGroup(
            pagamentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagamentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(operacionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(clientPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pagamentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(calculsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clientPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calculsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(operacionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pagamentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscadorClientsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorClientsFocusGained
        if (buscadorClients.getText().matches("Busca client per DNI")) {
            buscadorClients.setText("");
        }
    }//GEN-LAST:event_buscadorClientsFocusGained

    private void buscadorClientsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorClientsFocusLost
        if (buscadorClients.getText().isEmpty()) {
            buscadorClients.setText("Busca client per DNI");
        }
    }//GEN-LAST:event_buscadorClientsFocusLost

    private void buscadorProductesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorProductesFocusGained
        buscadorProductes.setText("");
    }//GEN-LAST:event_buscadorProductesFocusGained

    private void buscadorProductesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorProductesFocusLost
        if (buscadorProductes.getText().isEmpty()) {
            buscadorProductes.setText("Busca producte per nom o codi EAN");
        }

    }//GEN-LAST:event_buscadorProductesFocusLost

    private void taulaProductesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taulaProductesMouseClicked

        int filaSeleccionada = taulaProductes.getSelectedRow();

        if (filaSeleccionada != -1) {
            DefaultTableModel sourceTableModel = (DefaultTableModel) taulaProductes.getModel();
            DefaultTableModel destinationTableModel = (DefaultTableModel) taulaProductesTicket.getModel();

            Object[] dadesFila = new Object[3];
            dadesFila[0] = sourceTableModel.getValueAt(filaSeleccionada, 0);
            dadesFila[1] = sourceTableModel.getValueAt(filaSeleccionada, 1);
            dadesFila[2] = sourceTableModel.getValueAt(filaSeleccionada, 3);

            destinationTableModel.addRow(dadesFila);
        }
        actualitzaTotal();
    }//GEN-LAST:event_taulaProductesMouseClicked

    private void buscadorProductesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorProductesKeyReleased
        String producteABuscar = buscadorProductes.getText();

        try {

            DefaultTableModel dt = (DefaultTableModel) taulaProductes.getModel();
            dt.setRowCount(0);

            if (producteABuscar.length() >= 3) {

                Statement s = ConnexioBD.mycon().createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM productes WHERE nomProducte LIKE '" + producteABuscar + "%' OR codiEAN LIKE '" + producteABuscar + "%'");

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

    private void buscadorClientsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorClientsKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String clientABuscar = buscadorClients.getText();

            try {
                Statement s = ConnexioBD.mycon().createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM clients WHERE dni LIKE '" + clientABuscar + "%'");

                if (rs.next()) {
                    String nomClient = rs.getString("nom");
                    String cognomsClient = rs.getString("cognoms");

                    buscadorClients.setText(nomClient + " " + cognomsClient);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_buscadorClientsKeyReleased

    private void taulaProductesTicketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taulaProductesTicketMouseClicked
        int filaSeleccionada = taulaProductesTicket.getSelectedRow();

        if (filaSeleccionada != -1) {
            DefaultTableModel destinationTableModel = (DefaultTableModel) taulaProductesTicket.getModel();

            destinationTableModel.removeRow(filaSeleccionada);
        }
        actualitzaTotal();
    }//GEN-LAST:event_taulaProductesTicketMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoBuscaClient;
    private javax.swing.JButton botoBuscaProducte;
    private javax.swing.JButton botoNetejaBuscadorClient;
    private javax.swing.JButton botoNetejaBuscadorProducte;
    private javax.swing.JTextField buscadorClients;
    private javax.swing.JTextField buscadorProductes;
    private javax.swing.JPanel calculsPanel;
    private javax.swing.JPanel clientPanel;
    private javax.swing.JLabel cupoEur;
    private javax.swing.JLabel cupoQuantitat;
    private javax.swing.JTextField cupoText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel liniesDiscontinues;
    private javax.swing.JPanel operacionsPanel;
    private javax.swing.JPanel pagamentPanel;
    private javax.swing.JPanel productePanel;
    private javax.swing.JPanel separador1;
    private javax.swing.JPanel separador2;
    private javax.swing.JPanel separador3;
    private javax.swing.JPanel separador4;
    private javax.swing.JPanel separador5;
    private javax.swing.JLabel subtotalEur;
    private javax.swing.JLabel subtotalLabel;
    private javax.swing.JLabel subtotalQuantitat;
    private javax.swing.JTable taulaProductes;
    private javax.swing.JTable taulaProductesTicket;
    private javax.swing.JLabel totalEur;
    private javax.swing.JLabel totalQuantitat;
    private javax.swing.JLabel totalText;
    // End of variables declaration//GEN-END:variables
}
