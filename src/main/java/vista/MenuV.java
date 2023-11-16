package vista;

import util.JPanelLoader;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;

/**
 *
 * @author Enric
 */
public class MenuV extends javax.swing.JFrame {

    private JPanelLoader JPLoader = new JPanelLoader();
    private ButtonGroup buttonGroup = new ButtonGroup();
    private static final Color SELECTED_COLOR = new Color(217, 4, 41);
    private static final Color DEFAULT_COLOR = null;

    private enum ButtonAction {
        PUNT_DE_VENDA, CLIENTS, MAGATZEM, VENDES, ESDEVENIMENTS
    }

    // Constructor de la classe
    public MenuV() {

        initComponents();
        getContentPane().setBackground(new java.awt.Color(217, 4, 41));
        this.setExtendedState(MenuV.MAXIMIZED_BOTH);

        // Afegir els JToggleButtons al ButtonGroup
        buttonGroup.add(botoPuntDeVenda);
        buttonGroup.add(botoClients);
        buttonGroup.add(botoMagatzem);
        buttonGroup.add(botoVendes);
        buttonGroup.add(botoEsdeveniments);

        // Afegir un ItemListener a cada JToggleButton
        addToggleButtonListener(botoPuntDeVenda);
        addToggleButtonListener(botoClients);
        addToggleButtonListener(botoMagatzem);
        addToggleButtonListener(botoVendes);
        addToggleButtonListener(botoEsdeveniments);

        // Establir el botó per defecte seleccionat i el color de fons
        botoPuntDeVenda.setSelected(true);
        botoPuntDeVenda.setBackground(new Color(217, 4, 41));

        // Carregar el panell inicial
        PuntdevendaV pdv = new PuntdevendaV();
        JPLoader.jPanelLoader(pantalla, pdv);

    }

    public void setSessio(String usuari, Boolean esAdmin) {
        usuariText.setText(usuari);
        botoEsdeveniments.setEnabled(esAdmin);
    }

    private void addToggleButtonListener(JToggleButton button) {
        button.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                handleButtonSelection(button, e);
            }
        });
    }

    private void handleButtonSelection(JToggleButton button, ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            highlightSelectedButton(button);
            resetOtherButtons(button);
            loadCorrespondingPanel(button);
        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
            unhighlightButton(button);
        }
    }

    private void highlightSelectedButton(JToggleButton button) {
        button.setBackground(SELECTED_COLOR);
        button.setContentAreaFilled(true);
    }

    private void resetOtherButtons(JToggleButton selectedButton) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton currentButton = buttons.nextElement();
            if (currentButton instanceof JToggleButton && currentButton != selectedButton) {
                unhighlightButton((JToggleButton) currentButton);
            }
        }
    }

    private void unhighlightButton(JToggleButton button) {
        button.setBackground(DEFAULT_COLOR);
        button.setContentAreaFilled(false);
    }

    private void loadCorrespondingPanel(JToggleButton button) {
        ButtonAction action = getButtonAction(button);
        switch (action) {
            case PUNT_DE_VENDA:
                PuntdevendaV pdv = new PuntdevendaV();
                JPLoader.jPanelLoader(pantalla, pdv);
                break;
            case CLIENTS:
                ClientsV cli = new ClientsV();
                JPLoader.jPanelLoader(pantalla, cli);
                break;
            case MAGATZEM:
                ProducteV mag = new ProducteV();
                JPLoader.jPanelLoader(pantalla, mag);
                break;
            case VENDES:
                VendesV pdvVendes = new VendesV();
                JPLoader.jPanelLoader(pantalla, pdvVendes);
                break;
            case ESDEVENIMENTS:
                EsdevenimentsV esdeveniments = new EsdevenimentsV();
                JPLoader.jPanelLoader(pantalla, esdeveniments);
                break;
        }
    }

    private ButtonAction getButtonAction(JToggleButton button) {
        // Determineu l'acció basada en el botó
        // Torneu el valor d'enum corresponent
        if (button == botoPuntDeVenda) {
            return ButtonAction.PUNT_DE_VENDA;
        } else if (button == botoClients) {
            return ButtonAction.CLIENTS;
        } else if (button == botoMagatzem) {
            return ButtonAction.MAGATZEM;
        } else if (button == botoVendes) {
            return ButtonAction.VENDES;
        } else {
            return ButtonAction.ESDEVENIMENTS;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuLateral = new javax.swing.JPanel();
        infoUsuari = new javax.swing.JPanel();
        usuariText = new javax.swing.JLabel();
        botoUsuari = new javax.swing.JToggleButton();
        botoPuntDeVenda = new javax.swing.JToggleButton();
        botoClients = new javax.swing.JToggleButton();
        botoMagatzem = new javax.swing.JToggleButton();
        botoVendes = new javax.swing.JToggleButton();
        botoEsdeveniments = new javax.swing.JToggleButton();
        pantalla = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(217, 4, 41));

        menuLateral.setBackground(new java.awt.Color(43, 45, 66));
        menuLateral.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        infoUsuari.setBackground(new java.awt.Color(43, 45, 66));

        usuariText.setBackground(new java.awt.Color(141, 153, 174));
        usuariText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 20)); // NOI18N
        usuariText.setForeground(new java.awt.Color(249, 249, 249));
        usuariText.setText("USUARI");

        botoUsuari.setBackground(new java.awt.Color(43, 45, 66));
        botoUsuari.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        botoUsuari.setForeground(new java.awt.Color(141, 153, 174));
        botoUsuari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/usuariout_1.png"))); // NOI18N
        botoUsuari.setContentAreaFilled(false);
        botoUsuari.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botoUsuari.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        botoUsuari.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botoUsuari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoUsuariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infoUsuariLayout = new javax.swing.GroupLayout(infoUsuari);
        infoUsuari.setLayout(infoUsuariLayout);
        infoUsuariLayout.setHorizontalGroup(
            infoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoUsuariLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botoUsuari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuariText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        infoUsuariLayout.setVerticalGroup(
            infoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoUsuariLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(infoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(usuariText)
                    .addComponent(botoUsuari))
                .addGap(10, 10, 10))
        );

        botoPuntDeVenda.setBackground(new java.awt.Color(43, 45, 66));
        botoPuntDeVenda.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        botoPuntDeVenda.setForeground(new java.awt.Color(141, 153, 174));
        botoPuntDeVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/punt_de_venda.png"))); // NOI18N
        botoPuntDeVenda.setText("PUNT DE VENDA");
        botoPuntDeVenda.setContentAreaFilled(false);
        botoPuntDeVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botoPuntDeVenda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        botoPuntDeVenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        botoClients.setBackground(new java.awt.Color(43, 45, 66));
        botoClients.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        botoClients.setForeground(new java.awt.Color(141, 153, 174));
        botoClients.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/clients_1.png"))); // NOI18N
        botoClients.setText("CLIENTS");
        botoClients.setContentAreaFilled(false);
        botoClients.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botoClients.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        botoClients.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        botoMagatzem.setBackground(new java.awt.Color(43, 45, 66));
        botoMagatzem.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        botoMagatzem.setForeground(new java.awt.Color(141, 153, 174));
        botoMagatzem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/magatzem_1.png"))); // NOI18N
        botoMagatzem.setText("MAGATZEM");
        botoMagatzem.setContentAreaFilled(false);
        botoMagatzem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botoMagatzem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        botoMagatzem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        botoVendes.setBackground(new java.awt.Color(43, 45, 66));
        botoVendes.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        botoVendes.setForeground(new java.awt.Color(141, 153, 174));
        botoVendes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/vendes_1.png"))); // NOI18N
        botoVendes.setText("VENDES");
        botoVendes.setContentAreaFilled(false);
        botoVendes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botoVendes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        botoVendes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        botoEsdeveniments.setBackground(new java.awt.Color(43, 45, 66));
        botoEsdeveniments.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        botoEsdeveniments.setForeground(new java.awt.Color(141, 153, 174));
        botoEsdeveniments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/esdeveniments.png"))); // NOI18N
        botoEsdeveniments.setText("ESDEVENIMENTS");
        botoEsdeveniments.setContentAreaFilled(false);
        botoEsdeveniments.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botoEsdeveniments.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        botoEsdeveniments.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout menuLateralLayout = new javax.swing.GroupLayout(menuLateral);
        menuLateral.setLayout(menuLateralLayout);
        menuLateralLayout.setHorizontalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLateralLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botoPuntDeVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botoClients, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botoMagatzem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botoVendes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoUsuari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botoEsdeveniments, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        menuLateralLayout.setVerticalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLateralLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(infoUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(botoPuntDeVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(botoClients, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(botoMagatzem, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(botoVendes, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(botoEsdeveniments, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pantallaLayout = new javax.swing.GroupLayout(pantalla);
        pantalla.setLayout(pantallaLayout);
        pantallaLayout.setHorizontalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
        );
        pantallaLayout.setVerticalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(menuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botoUsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoUsuariActionPerformed
        // Tancar
        dispose();

        // Obrir de nou el Login
        LoginV login = new LoginV();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }//GEN-LAST:event_botoUsuariActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botoClients;
    private javax.swing.JToggleButton botoEsdeveniments;
    private javax.swing.JToggleButton botoMagatzem;
    private javax.swing.JToggleButton botoPuntDeVenda;
    private javax.swing.JToggleButton botoUsuari;
    private javax.swing.JToggleButton botoVendes;
    private javax.swing.JPanel infoUsuari;
    private javax.swing.JPanel menuLateral;
    private javax.swing.JPanel pantalla;
    private javax.swing.JLabel usuariText;
    // End of variables declaration//GEN-END:variables
}
