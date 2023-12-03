package qpos;

/**
 *
 * @author Enric
 */
public class RegistreV extends javax.swing.JFrame {

    public RegistreV() {
        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(43, 45, 66));

        Pantalla.setBackground(new java.awt.Color(43, 45, 66));

        registrePanel.setBackground(new java.awt.Color(43, 45, 66));

        usuariRText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        usuariRText.setForeground(new java.awt.Color(141, 153, 174));
        usuariRText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usuariRText.setText("DNI");
        usuariRText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usuariRTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usuariRTextFocusLost(evt);
            }
        });

        iconoUsuari1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/usuari.png"))); // NOI18N

        iconoNom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/nom.png"))); // NOI18N

        nomRText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        nomRText.setForeground(new java.awt.Color(141, 153, 174));
        nomRText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomRText.setText("NOM");
        nomRText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomRTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomRTextFocusLost(evt);
            }
        });
        nomRText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomRTextActionPerformed(evt);
            }
        });

        cognomsRText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        cognomsRText.setForeground(new java.awt.Color(141, 153, 174));
        cognomsRText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cognomsRText.setText("COGNOMS");
        cognomsRText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cognomsRTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cognomsRTextFocusLost(evt);
            }
        });

        iconoCognoms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/cognoms.png"))); // NOI18N

        iconoTelefon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/telefon.png"))); // NOI18N

        telefonRText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        telefonRText.setForeground(new java.awt.Color(141, 153, 174));
        telefonRText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        telefonRText.setText("TELÈFON");
        telefonRText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                telefonRTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                telefonRTextFocusLost(evt);
            }
        });

        mailRText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        mailRText.setForeground(new java.awt.Color(141, 153, 174));
        mailRText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mailRText.setText("CORREU ELECTRÒNIC");
        mailRText.setToolTipText("");
        mailRText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mailRTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                mailRTextFocusLost(evt);
            }
        });

        iconoMail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/mail.png"))); // NOI18N

        iconoPassword1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/password.png"))); // NOI18N

        passwordRText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        passwordRText.setForeground(new java.awt.Color(141, 157, 174));
        passwordRText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordRText.setText("Password");
        passwordRText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordRTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordRTextFocusLost(evt);
            }
        });

        password2RText.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        password2RText.setForeground(new java.awt.Color(141, 157, 174));
        password2RText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password2RText.setText("Password");
        password2RText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                password2RTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                password2RTextFocusLost(evt);
            }
        });

        iconoPassword2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/password.png"))); // NOI18N

        javax.swing.GroupLayout registrePanelLayout = new javax.swing.GroupLayout(registrePanel);
        registrePanel.setLayout(registrePanelLayout);
        registrePanelLayout.setHorizontalGroup(
            registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registrePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(iconoPassword1)
                    .addComponent(iconoPassword2)
                    .addComponent(iconoMail)
                    .addComponent(iconoTelefon)
                    .addComponent(iconoCognoms)
                    .addComponent(iconoNom)
                    .addComponent(iconoUsuari1))
                .addGap(18, 18, 18)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomRText, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cognomsRText, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefonRText, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mailRText, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordRText, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password2RText, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuariRText, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        registrePanelLayout.setVerticalGroup(
            registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrePanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(iconoUsuari1)
                    .addComponent(usuariRText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(iconoNom)
                    .addComponent(nomRText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(iconoCognoms)
                    .addComponent(cognomsRText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(iconoTelefon)
                    .addComponent(telefonRText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(iconoMail)
                    .addComponent(mailRText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(iconoPassword1)
                    .addComponent(passwordRText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(registrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(iconoPassword2)
                    .addComponent(password2RText, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(151, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PantallaLayout = new javax.swing.GroupLayout(Pantalla);
        Pantalla.setLayout(PantallaLayout);
        PantallaLayout.setHorizontalGroup(
            PantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registrePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void password2RTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password2RTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_password2RTextFocusLost

    private void password2RTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_password2RTextFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_password2RTextFocusGained

    private void passwordRTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordRTextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordRTextFocusLost

    private void passwordRTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordRTextFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordRTextFocusGained

    private void mailRTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mailRTextFocusLost
        if (mailRText.getText().isEmpty()) {
            mailRText.setText("CORREU ELECTRÒNIC");
        }
    }//GEN-LAST:event_mailRTextFocusLost

    private void mailRTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mailRTextFocusGained
        mailRText.setText("");
    }//GEN-LAST:event_mailRTextFocusGained

    private void telefonRTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonRTextFocusLost
        if (telefonRText.getText().isEmpty()) {
            telefonRText.setText("TELÉFON");
        }
    }//GEN-LAST:event_telefonRTextFocusLost

    private void telefonRTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telefonRTextFocusGained
        telefonRText.setText("");
    }//GEN-LAST:event_telefonRTextFocusGained

    private void cognomsRTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cognomsRTextFocusLost
        if (cognomsRText.getText().isEmpty()) {
            cognomsRText.setText("COGNOMS");
        }
    }//GEN-LAST:event_cognomsRTextFocusLost

    private void cognomsRTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cognomsRTextFocusGained
        cognomsRText.setText("");
    }//GEN-LAST:event_cognomsRTextFocusGained

    private void nomRTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomRTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomRTextActionPerformed

    private void nomRTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomRTextFocusLost
        if (nomRText.getText().isEmpty()) {
            nomRText.setText("NOM");
        }
    }//GEN-LAST:event_nomRTextFocusLost

    private void nomRTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomRTextFocusGained
        nomRText.setText("");
    }//GEN-LAST:event_nomRTextFocusGained

    private void usuariRTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usuariRTextFocusLost
        if (usuariRText.getText().isEmpty()) {
            usuariRText.setText("DNI");
        }
    }//GEN-LAST:event_usuariRTextFocusLost

    private void usuariRTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usuariRTextFocusGained
        usuariRText.setText("");
    }//GEN-LAST:event_usuariRTextFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Pantalla;
    private javax.swing.JTextField cognomsRText;
    private javax.swing.JLabel iconoCognoms;
    private javax.swing.JLabel iconoMail;
    private javax.swing.JLabel iconoNom;
    private javax.swing.JLabel iconoPassword1;
    private javax.swing.JLabel iconoPassword2;
    private javax.swing.JLabel iconoTelefon;
    private javax.swing.JLabel iconoUsuari1;
    private javax.swing.JTextField mailRText;
    private javax.swing.JTextField nomRText;
    private javax.swing.JPasswordField password2RText;
    private javax.swing.JPasswordField passwordRText;
    private javax.swing.JPanel registrePanel;
    private javax.swing.JTextField telefonRText;
    private javax.swing.JTextField usuariRText;
    // End of variables declaration//GEN-END:variables
}
