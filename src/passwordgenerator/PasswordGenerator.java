package passwordgenerator;

import javax.swing.DefaultListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * This program can generate a MD5 Hash from a known String or generate a
 * password (incl. a MD5 Hash).
 *
 * @author Kevin Weis
 * @version 2012-04-26
 */
public class PasswordGenerator extends javax.swing.JFrame {

    /**
     *
     * Constructor: It will create the Frame.
     */
    public PasswordGenerator() {
        listModel = new DefaultListModel<>(); // ist für die instaziierung der Liste für die ausgabe.
        initComponents(); // generiert das gesammte layout des fensters und die erforderlichen objekte wie buttons etc.
        jTextFieldEnterPW.setEnabled(false); //setzt das eingabefeld für das bekannte passwort inaktiv (default)
        jLabelSliderInt.setText("12"); // setzt die zu generierende zeichenlänge auf den standard 12        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButtonGenPW = new javax.swing.JRadioButton();
        jRadioButtonGenMD5 = new javax.swing.JRadioButton();
        jTextFieldEnterPW = new javax.swing.JTextField();
        jButtonGenerate = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListOut = new javax.swing.JList();
        jSliderPasswordLength = new javax.swing.JSlider();
        jCheckBoxNum = new javax.swing.JCheckBox();
        jCheckBoxaz = new javax.swing.JCheckBox();
        jCheckBoxAZ = new javax.swing.JCheckBox();
        jCheckBoxSpezial = new javax.swing.JCheckBox();
        jLabelSliderInt = new javax.swing.JLabel();
        jSpinnerCountOf = new javax.swing.JSpinner(sm);
        jLabelHint = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Password Generator"); // NOI18N
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(350, 400));

        buttonGroup1.add(jRadioButtonGenPW);
        jRadioButtonGenPW.setSelected(true);
        jRadioButtonGenPW.setText("Gen. Password");
        jRadioButtonGenPW.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButtonGenPW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButtonGenPWMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jRadioButtonGenPWMouseExited(evt);
            }
        });
        jRadioButtonGenPW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGenPWActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonGenMD5);
        jRadioButtonGenMD5.setText("Gen. MD5 Hash");
        jRadioButtonGenMD5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButtonGenMD5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jRadioButtonGenMD5MouseExited(evt);
            }
        });
        jRadioButtonGenMD5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGenMD5ActionPerformed(evt);
            }
        });

        jTextFieldEnterPW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextFieldEnterPWMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextFieldEnterPWMouseExited(evt);
            }
        });

        jButtonGenerate.setText("Generate");
        jButtonGenerate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonGenerateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonGenerateMouseExited(evt);
            }
        });
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });

        jButtonClear.setText("Clear");
        jButtonClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonClearMouseExited(evt);
            }
        });
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jListOut.setModel(listModel);
        jScrollPane1.setViewportView(jListOut);

        jSliderPasswordLength.setMaximum(50);
        jSliderPasswordLength.setMinimum(3);
        jSliderPasswordLength.setPaintLabels(true);
        jSliderPasswordLength.setPaintTicks(true);
        jSliderPasswordLength.setSnapToTicks(true);
        jSliderPasswordLength.setValue(12);
        jSliderPasswordLength.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSliderPasswordLength.setValueIsAdjusting(true);
        jSliderPasswordLength.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jSliderPasswordLengthMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jSliderPasswordLengthMouseExited(evt);
            }
        });
        jSliderPasswordLength.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderPasswordLengthStateChanged(evt);
            }
        });

        jCheckBoxNum.setSelected(true);
        jCheckBoxNum.setText("Numbers");
        jCheckBoxNum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCheckBoxNumMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jCheckBoxNumMouseExited(evt);
            }
        });

        jCheckBoxaz.setSelected(true);
        jCheckBoxaz.setText("a-z");
        jCheckBoxaz.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCheckBoxazMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jCheckBoxazMouseExited(evt);
            }
        });

        jCheckBoxAZ.setSelected(true);
        jCheckBoxAZ.setText("A-Z");
        jCheckBoxAZ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCheckBoxAZMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jCheckBoxAZMouseExited(evt);
            }
        });

        jCheckBoxSpezial.setText("Spezial");
        jCheckBoxSpezial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCheckBoxSpezialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jCheckBoxSpezialMouseExited(evt);
            }
        });

        jLabelSliderInt.setText("0");

        jSpinnerCountOf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jSpinnerCountOfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jSpinnerCountOfMouseExited(evt);
            }
        });

        jLabelHint.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEnterPW, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButtonGenPW)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonGenMD5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBoxNum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxaz)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxAZ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxSpezial))
                            .addComponent(jSliderPasswordLength, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelSliderInt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(55, 55, 55))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jSpinnerCountOf, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabelHint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEnterPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGenerate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonGenPW)
                    .addComponent(jRadioButtonGenMD5)
                    .addComponent(jButtonClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSliderPasswordLength, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelSliderInt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxNum)
                    .addComponent(jCheckBoxaz)
                    .addComponent(jCheckBoxAZ)
                    .addComponent(jCheckBoxSpezial)
                    .addComponent(jSpinnerCountOf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelHint)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-334)/2, (screenSize.height-387)/2, 334, 387);
    }// </editor-fold>//GEN-END:initComponents
    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        listModel.clear(); //leert die gesamt liste (ausgabe)
    }//GEN-LAST:event_jButtonClearActionPerformed
    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
        int i = 1;
        while (Integer.parseInt(jSpinnerCountOf.getValue().toString()) >= i) {
            jSpinnerCountOf.setValue((Integer.parseInt(jSpinnerCountOf.getValue().toString())) - 1);
            if (jRadioButtonGenMD5.isSelected()) { //Wenn RadioButton GenMD5 aktiv
                if (!jTextFieldEnterPW.getText().isEmpty() && !listModel.contains(jTextFieldEnterPW.getText())) { //Wenn TextFeldEnterPW NICHT leer und wenn Inhalt nicht schon in Liste vorhanden.
                    normalPassword = new Password(jTextFieldEnterPW.getText()); //erzeuge Password Objekt
                    addToList(); //füge Password und dann MD5 Hash der Liste hinzu
                }
            }
            if (jRadioButtonGenPW.isSelected()) { //Wenn RadioButton GenPW aktiv
                String chars = "";
                if (jCheckBoxNum.isSelected()) { //Wenn ChechBoxNummern aktiv
                    chars = chars + numbers; // füge zur Zeichenauswahl die Zeichen 0 bis 9 hinzu
                }
                if (jCheckBoxaz.isSelected()) { //Wenn ChechBox a-z (klein) aktiv
                    chars = chars + lowAlphabet; // füge zur Zeichenauswahl die Zeichen a bis z hinzu
                }
                if (jCheckBoxAZ.isSelected()) { //Wenn ChechBox A-Z (Groß) aktiv
                    chars = chars + upAlphabet; // füge zur Zeichenauswahl die Zeichen A bis Z hinzu
                }
                if (jCheckBoxSpezial.isSelected()) { //Wenn ChechBox Sonderzeichen aktiv
                    chars = chars + special;// füge zur Zeichenauswahl die Zeichen !\"#$%&'()*+,-./:;<=>?@ hinzu
                }
                if (!chars.equals("")) { //macht nur weiter wenn mindestens ei n zeichensatz (checkboxen) aktiv ist
                    normalPassword = new Password(chars.toCharArray(), jSliderPasswordLength.getValue()); //erzeuge Password Objekt
                    addToList(); //füge Password und dann MD5 Hash der Liste hinzu
                } //else {jDialog1.setVisible(true);}
            }
        }
    jSpinnerCountOf.setValue(1);
    }//GEN-LAST:event_jButtonGenerateActionPerformed
    private void jRadioButtonGenPWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGenPWActionPerformed
        jTextFieldEnterPW.setEnabled(false); //schaltet das Texteingabefeld aus
        jCheckBoxNum.setEnabled(true); //schaltet die Checkbox Numbers ein
        jCheckBoxaz.setEnabled(true); //schaltet die checkbox klein a-z ein
        jCheckBoxAZ.setEnabled(true); //schaltet die checkbox groß A-Z ein
        jCheckBoxSpezial.setEnabled(true); //schaltet die checkbox Spezial ein
        jSliderPasswordLength.setEnabled(true); //schaltet den schieberegler zur zeichenlängenfestlegung ein
        jLabelSliderInt.setEnabled(true); //schaltet die anzeige des aktuellen werdes des schiebereglers ein
        jSpinnerCountOf.setEnabled(true);
    }//GEN-LAST:event_jRadioButtonGenPWActionPerformed
    private void jRadioButtonGenMD5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGenMD5ActionPerformed
        jTextFieldEnterPW.setEnabled(true); //schaltet das Texteingabefeld ein
        jCheckBoxNum.setEnabled(false); //schaltet die Checkbox Numbers aus
        jCheckBoxaz.setEnabled(false); //schaltet die checkbox klein a-z aus
        jCheckBoxAZ.setEnabled(false); //schaltet die checkbox groß A-Z aus
        jCheckBoxSpezial.setEnabled(false); //schaltet die checkbox Spezial aus
        jSliderPasswordLength.setEnabled(false); //schaltet den schieberegler zur zeichenlängenfestlegung aus
        jLabelSliderInt.setEnabled(false); //schaltet die anzeige des aktuellen werdes des schiebereglers aus
        jSpinnerCountOf.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonGenMD5ActionPerformed

    private void jSliderPasswordLengthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderPasswordLengthStateChanged
        jLabelSliderInt.setText(Integer.toString(jSliderPasswordLength.getValue())); //sorgt für die aktuallisierung der anzeige des aktuellen wertes der zeichenlängenfestlegung
    }//GEN-LAST:event_jSliderPasswordLengthStateChanged

    private void jRadioButtonGenPWMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonGenPWMouseEntered
        jLabelHint.setText("Generate a random password");
    }//GEN-LAST:event_jRadioButtonGenPWMouseEntered

    private void jRadioButtonGenPWMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonGenPWMouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jRadioButtonGenPWMouseExited

    private void jRadioButtonGenMD5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonGenMD5MouseEntered
        jLabelHint.setText("Generate a MD5 Hash of the text on the top");
    }//GEN-LAST:event_jRadioButtonGenMD5MouseEntered

    private void jRadioButtonGenMD5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonGenMD5MouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jRadioButtonGenMD5MouseExited

    private void jTextFieldEnterPWMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldEnterPWMouseEntered
        jLabelHint.setText("Type here the password");
    }//GEN-LAST:event_jTextFieldEnterPWMouseEntered

    private void jTextFieldEnterPWMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldEnterPWMouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jTextFieldEnterPWMouseExited

    private void jButtonGenerateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGenerateMouseEntered
        jLabelHint.setText("Generate !!!");
    }//GEN-LAST:event_jButtonGenerateMouseEntered

    private void jButtonGenerateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGenerateMouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jButtonGenerateMouseExited

    private void jButtonClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClearMouseEntered
        jLabelHint.setText("Will reset the whole ouput list !");
    }//GEN-LAST:event_jButtonClearMouseEntered

    private void jButtonClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClearMouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jButtonClearMouseExited

    private void jSliderPasswordLengthMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSliderPasswordLengthMouseEntered
        jLabelHint.setText("set length of generated password");
    }//GEN-LAST:event_jSliderPasswordLengthMouseEntered

    private void jSliderPasswordLengthMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSliderPasswordLengthMouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jSliderPasswordLengthMouseExited

    private void jCheckBoxNumMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxNumMouseEntered
        jLabelHint.setText("Includes numbers from 0 to 9");
    }//GEN-LAST:event_jCheckBoxNumMouseEntered

    private void jCheckBoxNumMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxNumMouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jCheckBoxNumMouseExited

    private void jCheckBoxazMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxazMouseEntered
        jLabelHint.setText("Includes characters from a to z (lowercase)");
    }//GEN-LAST:event_jCheckBoxazMouseEntered

    private void jCheckBoxazMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxazMouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jCheckBoxazMouseExited

    private void jCheckBoxAZMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxAZMouseEntered
        jLabelHint.setText("Includes characters from A to Z (uppercase)");
    }//GEN-LAST:event_jCheckBoxAZMouseEntered

    private void jCheckBoxAZMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxAZMouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jCheckBoxAZMouseExited

    private void jCheckBoxSpezialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxSpezialMouseEntered
        jLabelHint.setText("Includes spezial characters (!\"#$%&'()*+,-./:;<=>?@)");
    }//GEN-LAST:event_jCheckBoxSpezialMouseEntered

    private void jCheckBoxSpezialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxSpezialMouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jCheckBoxSpezialMouseExited

    private void jSpinnerCountOfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinnerCountOfMouseEntered
        jLabelHint.setText("Count of passwords");
    }//GEN-LAST:event_jSpinnerCountOfMouseEntered

    private void jSpinnerCountOfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinnerCountOfMouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jSpinnerCountOfMouseExited
    private void addToList() { //fügt das passwort und die dazugehörige MD5 Summe der Liste (ausgabe) hinzu
        listModel.addElement(normalPassword.getPassword()); //fügt das passwort der liste (ausgabe) hinzu
        listModel.addElement(normalPassword.getMD5()); //fügt die dazugehörige MD5 Summe der Liste (ausgabe) hinzu
    }

    /**
     * @param args No Arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            /**
             * create a new object of the extended frame (PasswordGenerator)
             */
            public void run() {
                new PasswordGenerator().setVisible(true);
            }
        });
    }
    private DefaultListModel<String> listModel; // deklariert die Variable listModel vom typ DefaultListModel<String>
    private Password normalPassword; //deklariert die variable normalPassword vom Typ Password
    private String numbers = "0123456789"; //
    private String lowAlphabet = "abcdefghijklmnopqrstuvwxyz";
    private String upAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String special = "!\"#$%&'()*+,-./:;<=>?@";
    private SpinnerModel sm = new SpinnerNumberModel(1, 1, 100000, 1);
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JCheckBox jCheckBoxAZ;
    private javax.swing.JCheckBox jCheckBoxNum;
    private javax.swing.JCheckBox jCheckBoxSpezial;
    private javax.swing.JCheckBox jCheckBoxaz;
    private javax.swing.JLabel jLabelHint;
    private javax.swing.JLabel jLabelSliderInt;
    private javax.swing.JList jListOut;
    private javax.swing.JRadioButton jRadioButtonGenMD5;
    private javax.swing.JRadioButton jRadioButtonGenPW;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSliderPasswordLength;
    private javax.swing.JSpinner jSpinnerCountOf;
    private javax.swing.JTextField jTextFieldEnterPW;
    // End of variables declaration//GEN-END:variables
}
