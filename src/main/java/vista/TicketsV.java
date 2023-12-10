package vista;

import controlador.CompraC;
import java.awt.Component;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.CompraM;
import model.LiniaCompraM;
import model.ProducteM;
import util.GestorErrors;

/**
 * Classe que representa la pantalla del punt de venda
 *
 * @author Enric
 */
public class TicketsV extends javax.swing.JPanel {

    String missatgeBuscador = "Busca tickets o busca per ID";

    CompraC compraC = new CompraC();

    List<CompraM> compres;

    /**
     * Constructor
     */
    public TicketsV() {
        initComponents();
        // Set the custom renderer for the "Pagament" column
        TableColumnModel columnModel = taulaVendes.getColumnModel();
        columnModel.getColumn(PAGAMENT_COLUMN_INDEX).setCellRenderer(new PagamentRenderer());
    }

    public void actualitzaModelTaula() {
        DefaultTableModel modelDeTaula = (DefaultTableModel) taulaVendes.getModel();
        modelDeTaula.setRowCount(0); // Clears existing data

        // Crida el mètode getCompres a CompraC per obtenir les dades actualitzades de les compres
        compres = compraC.getCompres(); // Initialize the class variable

        if (!compres.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            for (CompraM compra : compres) {
                Object[] dadesFila = {
                    compra.getId(),
                    dateFormat.format(compra.getData()),
                    compra.getTreballador().getUsername(),
                    compra.getClient().getNom()+" "+compra.getClient().getCognoms(),
                    compra.getMetodePagament(),
                    compra.getImportFinal()
                };
                modelDeTaula.addRow(dadesFila);
            }
        } else {
            GestorErrors.displayError("Error en recuperar les dades de les compres.");
        }
    }

    /**
     * Mètode per actualitzar la taulaTicket amb els productes, quantitat i preu
     * quan es fa clic en un tiquet a la taulaVendes.
     */
    public void actualitzaTaulaTicket() {
        // Obté la fila seleccionada de la taulaVendes
        int filaSeleccionada = taulaVendes.getSelectedRow();

        // Verifica si hi ha una fila seleccionada
        if (filaSeleccionada != -1) {
            // Obté l'objecte CompraM de la fila seleccionada
            CompraM compraSeleccionada = compres.get(filaSeleccionada);

            // Obté la llista de linies de compra per a la compra seleccionada
            LiniaCompraM[] liniesCompra = compraSeleccionada.getLiniesCompra();

            // Obté el model de la taulaTicket
            DefaultTableModel taulaAssistentsModel = (DefaultTableModel) taulaTicket.getModel();

            // Netega les dades existents de la taulaTicket
            taulaAssistentsModel.setRowCount(0);

            // Omple la taulaTicket amb les dades dels productes, quantitat i preu
            for (LiniaCompraM liniaCompra : liniesCompra) {
                ProducteM producte = liniaCompra.getProducte();
                int quantitat = liniaCompra.getQuantitat();

                Object[] rowData = {
                    producte.getId(),
                    producte.getNom(),
                    quantitat,
                    producte.getPreu()
                };
                taulaAssistentsModel.addRow(rowData);
            }
        } else {
            // Si no hi ha cap fila seleccionada a taulaVendes, neteja la taulaTicket
            DefaultTableModel taulaAssistentsModel = (DefaultTableModel) taulaTicket.getModel();
            taulaAssistentsModel.setRowCount(0);
        }
    }

    private static final int PAGAMENT_COLUMN_INDEX = 4;

    /**
     * Custom cell renderer for displaying icons in the "Pagament" column
     */
    private static class PagamentRenderer extends DefaultTableCellRenderer {

        private static final Icon EFECTIU_ICON = loadIcon("/media/efectiu_b.png");
        private static final Icon TARJETA_ICON = loadIcon("/media/tarjeta_b.png");

        private static Icon loadIcon(String filename) {
            try {
                URL resource = PagamentRenderer.class.getResource(filename);
                if (resource != null) {
                    return new ImageIcon(resource);
                } else {
                    System.err.println("Icon not found: " + filename);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (column == PAGAMENT_COLUMN_INDEX && value instanceof String) {
                String pagamentType = (String) value;

                if ("Efectiu".equals(pagamentType)) {
                    setIcon(EFECTIU_ICON);
                } else if ("Targeta".equals(pagamentType)) {
                    setIcon(TARJETA_ICON);
                } else {
                    setIcon(null);
                }

                setText("");
            } else {
                setIcon(null);
            }

            return rendererComponent;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vendesPanel = new javax.swing.JPanel();
        buscadorVendes = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taulaVendes = new javax.swing.JTable();
        separador1 = new javax.swing.JPanel();
        separador2 = new javax.swing.JPanel();
        separador3 = new javax.swing.JPanel();
        botoNetejaBuscadorVendes = new javax.swing.JButton();
        botoBuscaVendes = new javax.swing.JButton();
        operacionsPanel = new javax.swing.JPanel();
        ticketPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taulaTicket = new javax.swing.JTable();
        separador4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        separador5 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(217, 4, 41));

        vendesPanel.setBackground(new java.awt.Color(217, 4, 41));

        buscadorVendes.setBackground(new java.awt.Color(237, 242, 244));
        buscadorVendes.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        buscadorVendes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscadorVendes.setText("Busca tickets o busca per ID");
        buscadorVendes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscadorVendesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                buscadorVendesFocusLost(evt);
            }
        });

        taulaVendes.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        taulaVendes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codi", "Data", "Empleat", "Client", "Pagament", "Import"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        taulaVendes.getTableHeader().setReorderingAllowed(false);
        taulaVendes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taulaVendesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(taulaVendes);
        if (taulaVendes.getColumnModel().getColumnCount() > 0) {
            taulaVendes.getColumnModel().getColumn(0).setPreferredWidth(15);
            taulaVendes.getColumnModel().getColumn(1).setPreferredWidth(150);
            taulaVendes.getColumnModel().getColumn(2).setPreferredWidth(70);
            taulaVendes.getColumnModel().getColumn(3).setPreferredWidth(150);
            taulaVendes.getColumnModel().getColumn(4).setPreferredWidth(20);
            taulaVendes.getColumnModel().getColumn(5).setPreferredWidth(30);
        }
        taulaVendes.setRowHeight(40);

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

        botoNetejaBuscadorVendes.setBackground(new java.awt.Color(43, 45, 66));
        botoNetejaBuscadorVendes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/XB.png"))); // NOI18N
        botoNetejaBuscadorVendes.setBorder(null);
        botoNetejaBuscadorVendes.setBorderPainted(false);

        botoBuscaVendes.setBackground(new java.awt.Color(43, 45, 66));
        botoBuscaVendes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/lupaB.png"))); // NOI18N
        botoBuscaVendes.setBorder(null);
        botoBuscaVendes.setBorderPainted(false);
        botoBuscaVendes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoBuscaVendesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vendesPanelLayout = new javax.swing.GroupLayout(vendesPanel);
        vendesPanel.setLayout(vendesPanelLayout);
        vendesPanelLayout.setHorizontalGroup(
            vendesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vendesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(vendesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(separador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vendesPanelLayout.createSequentialGroup()
                        .addComponent(botoBuscaVendes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscadorVendes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botoNetejaBuscadorVendes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        vendesPanelLayout.setVerticalGroup(
            vendesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vendesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vendesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscadorVendes, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(botoNetejaBuscadorVendes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botoBuscaVendes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(vendesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vendesPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vendesPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vendesPanelLayout.createSequentialGroup()
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
            .addGap(0, 112, Short.MAX_VALUE)
        );

        ticketPanel.setBackground(new java.awt.Color(217, 4, 41));
        ticketPanel.setPreferredSize(new java.awt.Dimension(544, 425));

        taulaTicket.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        taulaTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codi", "Nom", "Quantitat", "Preu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        taulaTicket.getTableHeader().setReorderingAllowed(false);
        taulaTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taulaTicketMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(taulaTicket);
        if (taulaTicket.getColumnModel().getColumnCount() > 0) {
            taulaTicket.getColumnModel().getColumn(0).setResizable(false);
            taulaTicket.getColumnModel().getColumn(0).setPreferredWidth(3);
            taulaTicket.getColumnModel().getColumn(1).setResizable(false);
            taulaTicket.getColumnModel().getColumn(1).setPreferredWidth(250);
            taulaTicket.getColumnModel().getColumn(2).setResizable(false);
            taulaTicket.getColumnModel().getColumn(2).setPreferredWidth(10);
            taulaTicket.getColumnModel().getColumn(3).setResizable(false);
            taulaTicket.getColumnModel().getColumn(3).setPreferredWidth(35);
        }
        taulaTicket.setRowHeight(40);

        separador4.setBackground(new java.awt.Color(217, 4, 41));

        jLabel14.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(237, 242, 244));
        jLabel14.setText("PRODUCTES DEL TICKET");

        javax.swing.GroupLayout separador4Layout = new javax.swing.GroupLayout(separador4);
        separador4.setLayout(separador4Layout);
        separador4Layout.setHorizontalGroup(
            separador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(separador4Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        separador4Layout.setVerticalGroup(
            separador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, separador4Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap())
        );

        javax.swing.GroupLayout ticketPanelLayout = new javax.swing.GroupLayout(ticketPanel);
        ticketPanel.setLayout(ticketPanelLayout);
        ticketPanelLayout.setHorizontalGroup(
            ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ticketPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(separador4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
                .addGap(86, 86, 86))
        );
        ticketPanelLayout.setVerticalGroup(
            ticketPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ticketPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        separador5.setBackground(new java.awt.Color(217, 4, 41));

        javax.swing.GroupLayout separador5Layout = new javax.swing.GroupLayout(separador5);
        separador5.setLayout(separador5Layout);
        separador5Layout.setHorizontalGroup(
            separador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separador5Layout.setVerticalGroup(
            separador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vendesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(operacionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ticketPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                    .addComponent(separador5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vendesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ticketPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(separador5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(operacionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscadorVendesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorVendesFocusGained
        buscadorVendes.setText("");
    }//GEN-LAST:event_buscadorVendesFocusGained

    private void buscadorVendesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscadorVendesFocusLost
        if (buscadorVendes.getText().isEmpty()) {
            buscadorVendes.setText(missatgeBuscador);
        }

    }//GEN-LAST:event_buscadorVendesFocusLost

    private void taulaVendesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taulaVendesMouseClicked

        actualitzaTaulaTicket();

    }//GEN-LAST:event_taulaVendesMouseClicked

    private void taulaTicketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taulaTicketMouseClicked

    }//GEN-LAST:event_taulaTicketMouseClicked

    private void botoBuscaVendesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoBuscaVendesActionPerformed
        actualitzaModelTaula();
    }//GEN-LAST:event_botoBuscaVendesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoBuscaVendes;
    private javax.swing.JButton botoNetejaBuscadorVendes;
    private javax.swing.JTextField buscadorVendes;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel operacionsPanel;
    private javax.swing.JPanel separador1;
    private javax.swing.JPanel separador2;
    private javax.swing.JPanel separador3;
    private javax.swing.JPanel separador4;
    private javax.swing.JPanel separador5;
    private javax.swing.JTable taulaTicket;
    private javax.swing.JTable taulaVendes;
    private javax.swing.JPanel ticketPanel;
    private javax.swing.JPanel vendesPanel;
    // End of variables declaration//GEN-END:variables
}
