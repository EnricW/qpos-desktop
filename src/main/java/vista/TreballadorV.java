package vista;

import controlador.TreballadorC;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.AuthorizationM;
import model.TreballadorM;
import util.GestorErrors;

/**
 *
 * @author Enric
 */
public class TreballadorV extends javax.swing.JFrame {

    TreballadorC treballadorC = new TreballadorC();

    public TreballadorV() {
        initComponents();
        mostrarTreballador();
    }

    private void mostrarTreballador() {
        TreballadorM treballador = treballadorC.getTreballador(AuthorizationM.getInstance().getId());
        usuariRText.setText(treballador.getDni());
        nomRText.setText(treballador.getNom());
        cognomsRText.setText(treballador.getCognoms());

        // Format the date of birth
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String formattedDate = dateFormat.format(treballador.getDataNaixement());
            dataRText.setText(formattedDate);
        } catch (Exception e) {
            // Handle the exception if needed
            e.printStackTrace();
        }

        telefonRText.setText(treballador.getTelefon());
        mailRText.setText(treballador.getEmail());

        //System.out.println("Token de " + treballador.getUser() + ": " + AuthorizationM.getInstance().getToken());
    }

    private boolean isValidDateFormat(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pantalla = new javax.swing.JPanel();
        registrePanel = new javax.swing.JPanel();
        usuariRText = new javax.swing.JTextField();
        iconoUsuari1 = new javax.swing.JLabel();
        iconoNom = new javax.swing.JLabel();
        nomRText = new javax.swing.JTextField();
        cognomsRText = new javax.swing.JTextField();
        iconoCognoms = new javax.swing.JLabel();
        iconoTelefon = new javax.swing.JLabel();
        telefonRText = new javax.swing.JTextField();
        mailRText = new javax.swing.JTextField();
        iconoMail = new javax.swing.JLabel();
        iconoPassword1 = new javax.swing.JLabel();
        passwordRText = new javax.swing.JPasswordField();
        password2RText = new javax.swing.JPasswordField();
        iconoPassword2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        botoDesferCanvis = new javax.swing.JButton();
        botoDesarCanvis = new javax.swing.JButton();
        botoRetrocedir = new javax.swing.JToggleButton();
        dataRText = new javax.swing.JTextField();
        iconoData = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(43, 45, 66));

        Pantalla.setBackground(new java.awt.Color(43, 45, 66));

        registrePanel.setBackground(new java.awt.Color(43, 45, 66));

        usuariRText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        usuariRText.setForeground(new java.awt.Color(141, 153, 174));
        usuariRText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usuariRText.setText("DNI");

        iconoUsuari1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/usuari.png"))); // NOI18N

        iconoNom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/nom.png"))); // NOI18N

        nomRText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        nomRText.setForeground(new java.awt.Color(141, 153, 174));
        nomRText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomRText.setText("NOM");

        cognomsRText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        cognomsRText.setForeground(new java.awt.Color(141, 153, 174));
        cognomsRText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cognomsRText.setText("COGNOMS");

        iconoCognoms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/cognoms.png"))); // NOI18N

        iconoTelefon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/telefon.png"))); // NOI18N

        telefonRText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        telefonRText.setForeground(new java.awt.Color(141, 153, 174));
        telefonRText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telefonRText.setText("TELÈFON");

        mailRText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        mailRText.setForeground(new java.awt.Color(141, 153, 174));
        mailRText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mailRText.setText("CORREU ELECTRÒNIC");
        mailRText.setToolTipText("");

        iconoMail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/mail.png"))); // NOI18N

        iconoPassword1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/password.png"))); // NOI18N

        passwordRText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        passwordRText.setForeground(new java.awt.Color(141, 157, 174));
        passwordRText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordRText.setText("Password");

        password2RText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        password2RText.setForeground(new java.awt.Color(141, 157, 174));
        password2RText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password2RText.setText("Password");

        iconoPassword2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/password.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(141, 153, 174));
        jLabel1.setText("DADES D'USUARI");

        botoDesferCanvis.setBackground(new java.awt.Color(255, 153, 153));
        botoDesferCanvis.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        botoDesferCanvis.setForeground(new java.awt.Color(43, 45, 66));
        botoDesferCanvis.setText("DESFER CANVIS");
        botoDesferCanvis.setActionCommand("");
        botoDesferCanvis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoDesferCanvisActionPerformed(evt);
            }
        });

        botoDesarCanvis.setBackground(new java.awt.Color(153, 255, 153));
        botoDesarCanvis.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 24)); // NOI18N
        botoDesarCanvis.setForeground(new java.awt.Color(43, 45, 66));
        botoDesarCanvis.setText("DESAR CANVIS");
        botoDesarCanvis.setActionCommand("");
        botoDesarCanvis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoDesarCanvisActionPerformed(evt);
            }
        });

        botoRetrocedir.setBackground(new java.awt.Color(43, 45, 66));
        botoRetrocedir.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 16)); // NOI18N
        botoRetrocedir.setForeground(new java.awt.Color(141, 153, 174));
        botoRetrocedir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/retrocedir.png"))); // NOI18N
        botoRetrocedir.setContentAreaFilled(false);
        botoRetrocedir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botoRetrocedir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        botoRetrocedir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botoRetrocedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoRetrocedirActionPerformed(evt);
            }
        });

        dataRText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        dataRText.setForeground(new java.awt.Color(141, 153, 174));
        dataRText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dataRText.setText("DATA NAIXEMENT YYYY-MM-DD");

        iconoData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/data.png"))); // NOI18N

        javax.swing.GroupLayout registrePanelLayout = new javax.swing.GroupLayout(registrePanel);
        registrePanel.setLayout(registrePanelLayout);
        registrePanelLayout.setHorizontalGroup(
            registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrePanelLayout.createSequentialGroup()
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(registrePanelLayout.createSequentialGroup()
                            .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(iconoPassword1)
                                .addComponent(iconoPassword2)
                                .addComponent(iconoMail)
                                .addComponent(iconoTelefon))
                            .addGap(18, 18, 18)
                            .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(telefonRText, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(mailRText, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordRText, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(password2RText, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(registrePanelLayout.createSequentialGroup()
                            .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(registrePanelLayout.createSequentialGroup()
                                    .addGap(71, 71, 71)
                                    .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(iconoCognoms)
                                        .addComponent(iconoNom)
                                        .addComponent(iconoUsuari1)
                                        .addComponent(iconoData)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, registrePanelLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(botoRetrocedir)))
                            .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(registrePanelLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nomRText, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cognomsRText, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(usuariRText, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(registrePanelLayout.createSequentialGroup()
                                    .addGap(53, 53, 53)
                                    .addComponent(jLabel1))))
                        .addComponent(dataRText, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(registrePanelLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(botoDesferCanvis, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botoDesarCanvis, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        registrePanelLayout.setVerticalGroup(
            registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrePanelLayout.createSequentialGroup()
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registrePanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(botoRetrocedir))
                    .addGroup(registrePanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)))
                .addGap(38, 38, 38)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(iconoUsuari1)
                    .addComponent(usuariRText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(iconoNom)
                    .addComponent(nomRText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(iconoCognoms)
                    .addComponent(cognomsRText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataRText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconoData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(iconoTelefon)
                    .addComponent(telefonRText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(iconoMail)
                    .addComponent(mailRText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(iconoPassword1)
                    .addComponent(passwordRText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(iconoPassword2)
                    .addComponent(password2RText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botoDesferCanvis, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botoDesarCanvis, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout PantallaLayout = new javax.swing.GroupLayout(Pantalla);
        Pantalla.setLayout(PantallaLayout);
        PantallaLayout.setHorizontalGroup(
            PantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PantallaLayout.createSequentialGroup()
                .addComponent(registrePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PantallaLayout.setVerticalGroup(
            PantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registrePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pantalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Pantalla.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botoDesferCanvisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoDesferCanvisActionPerformed
        mostrarTreballador();
    }//GEN-LAST:event_botoDesferCanvisActionPerformed

    private void botoDesarCanvisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoDesarCanvisActionPerformed
        // Get values from the form
        String dni = usuariRText.getText();
        String nom = nomRText.getText();
        String cognoms = cognomsRText.getText();
        String dataNaixement = dataRText.getText();
        String telefon = telefonRText.getText();
        String email = mailRText.getText();
        String password = String.valueOf(passwordRText.getPassword());
        String password2 = String.valueOf(password2RText.getPassword());

        // Check if the date format is valid
        if (!isValidDateFormat(dataNaixement)) {
            GestorErrors.displayError(email);
            System.out.println("Format de data no vàlida. Fes servir YYYY-MM-DD.");
            return;
        }

        // Check if passwords match
        if (!password.equals(password2)) {
            GestorErrors.displayError("Les contrasenyes no coincideixen.");
            return;
        }

        // Create a TreballadorM object with the updated values
        TreballadorM treballador = new TreballadorM();
        treballador.setDni(dni);
        treballador.setNom(nom);
        treballador.setCognoms(cognoms);

        try {
            // Parse the date string to a Date object
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(dataNaixement);
            treballador.setDataNaixement(date);
        } catch (ParseException e) {
            // Handle parsing exception if needed
            e.printStackTrace();
            return;
        }

        treballador.setTelefon(telefon);
        treballador.setEmail(email);
        treballador.setPassword(password);

        // Call the method in TreballadorC to edit the Treballador
        treballadorC.editaTreballador(AuthorizationM.getInstance().getId(), treballador);

        // Optionally, update the form with the edited values
        mostrarTreballador();
    }//GEN-LAST:event_botoDesarCanvisActionPerformed

    private void botoRetrocedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoRetrocedirActionPerformed
        dispose();
    }//GEN-LAST:event_botoRetrocedirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pantalla;
    private javax.swing.JButton botoDesarCanvis;
    private javax.swing.JButton botoDesferCanvis;
    private javax.swing.JToggleButton botoRetrocedir;
    private javax.swing.JTextField cognomsRText;
    private javax.swing.JTextField dataRText;
    private javax.swing.JLabel iconoCognoms;
    private javax.swing.JLabel iconoData;
    private javax.swing.JLabel iconoMail;
    private javax.swing.JLabel iconoNom;
    private javax.swing.JLabel iconoPassword1;
    private javax.swing.JLabel iconoPassword2;
    private javax.swing.JLabel iconoTelefon;
    private javax.swing.JLabel iconoUsuari1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField mailRText;
    private javax.swing.JTextField nomRText;
    private javax.swing.JPasswordField password2RText;
    private javax.swing.JPasswordField passwordRText;
    private javax.swing.JPanel registrePanel;
    private javax.swing.JTextField telefonRText;
    private javax.swing.JTextField usuariRText;
    // End of variables declaration//GEN-END:variables
}
