package passwordgenerator;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

/**
 * This program can generate a MD5 Hash from a known String or generate a password (incl. a MD5 Hash).
 * <p/>
 * @author Kevin Weis
 * @version 2012-04-26
 */
public class PasswordGenerator extends JFrame implements Runnable {
    /**
     * Constructor: It will create the Frame.
     */
    public PasswordGenerator() {
        listModel = new DefaultListModel<>(); // ist für die instaziierung der Liste für die ausgabe.
        initComponents(); // generiert das gesammte layout des fensters und die erforderlichen objekte wie buttons etc.
        jTextFieldEnterPW.setEnabled(false); //setzt das eingabefeld für das bekannte passwort inaktiv (default)
        jLabelSliderInt.setText("12");// setzt die zu generierende zeichenlänge auf den standard 12
        jButtonExport.setEnabled(false);
        jButtonImport.setEnabled(false);
    }

    /**
     * @return the Object of the GUI
     */
    protected static PasswordGenerator getPasswordGui() {
        return PasswordGui;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButtonGenPW = new javax.swing.JRadioButton();
        jRadioButtonGenOwnPW = new javax.swing.JRadioButton();
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
        jLabelPWCount = new javax.swing.JLabel();
        jButtonExport = new javax.swing.JButton();
        jButtonImport = new javax.swing.JButton();
        jComboBoxAlg = new javax.swing.JComboBox();
        jCheckBoxGenHash = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Password Generator"); // NOI18N
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(400, 500));
        setPreferredSize(new java.awt.Dimension(330, 500));

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

        buttonGroup1.add(jRadioButtonGenOwnPW);
        jRadioButtonGenOwnPW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGenOwnPWActionPerformed(evt);
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
        jTextFieldEnterPW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEnterPWActionPerformed(evt);
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

        jLabelHint.setText(" ");

        jLabelPWCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPWCount.setText("0");
        jLabelPWCount.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabelPWCount.setRequestFocusEnabled(false);

        jButtonExport.setText("Export");
        jButtonExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonExportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonExportMouseExited(evt);
            }
        });
        jButtonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportActionPerformed(evt);
            }
        });

        jButtonImport.setText("Import");
        jButtonImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonImportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonImportMouseExited(evt);
            }
        });
        jButtonImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportActionPerformed(evt);
            }
        });

        jProgressBar.setForeground(new java.awt.Color(44, 147, 250));
        jProgressBar.setMaximum(500);
        jProgressBar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jProgressBar.setFocusable(false);
        jProgressBar.setMinimumSize(new java.awt.Dimension(10, 17));
        jProgressBar.setStringPainted(true);

        jComboBoxAlg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SHA-1", "MD5"}));
        jComboBoxAlg.setSelectedIndex(0);

        jCheckBoxGenHash.setText("Gen. Hash");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSliderPasswordLength, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jRadioButtonGenOwnPW)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEnterPW))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBoxNum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxaz)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxAZ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxSpezial)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButtonGenPW)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxGenHash)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelSliderInt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxAlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSpinnerCountOf)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelHint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPWCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonImport, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEnterPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGenerate)
                    .addComponent(jRadioButtonGenOwnPW))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonGenPW)
                    .addComponent(jButtonClear)
                    .addComponent(jCheckBoxGenHash))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSliderPasswordLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabelSliderInt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxAlg, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxNum)
                    .addComponent(jCheckBoxaz)
                    .addComponent(jCheckBoxAZ)
                    .addComponent(jCheckBoxSpezial)
                    .addComponent(jSpinnerCountOf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHint)
                    .addComponent(jLabelPWCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-341)/2, (screenSize.height-557)/2, 341, 557);
    }// </editor-fold>//GEN-END:initComponents
    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        listModel.clear(); //leert die gesamt liste (ausgabe)
        Password.resetCount();
        jProgressBar.setValue(0);
        jLabelPWCount.setText(Integer.toString(Password.getCount())); //textausgabe für die anzahl der generiwerten passwörtern
        jSpinnerCountOf.setValue(1);
    }//GEN-LAST:event_jButtonClearActionPerformed
    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
        generate();
    }//GEN-LAST:event_jButtonGenerateActionPerformed

    private void jSliderPasswordLengthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderPasswordLengthStateChanged
        jLabelSliderInt.setText(Integer.toString(jSliderPasswordLength.getValue())); //sorgt für die aktuallisierung der anzeige des aktuellen wertes der zeichenlängenfestlegung
    }//GEN-LAST:event_jSliderPasswordLengthStateChanged

    private void jRadioButtonGenPWMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonGenPWMouseEntered
        jLabelHint.setText("Generate a random password");
    }//GEN-LAST:event_jRadioButtonGenPWMouseEntered

    private void jRadioButtonGenPWMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonGenPWMouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jRadioButtonGenPWMouseExited

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

    private void jButtonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportActionPerformed
//        if (!listModel.isEmpty()) {
//            new JFileChooser(listModel).setVisible(true);
//        }
    }//GEN-LAST:event_jButtonExportActionPerformed

    private void jButtonImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportActionPerformed
//        new JFileChooser().setVisible(true);
    }//GEN-LAST:event_jButtonImportActionPerformed

    private void jTextFieldEnterPWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEnterPWActionPerformed
        generate();
    }//GEN-LAST:event_jTextFieldEnterPWActionPerformed

    private void jButtonExportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExportMouseEntered
        jLabelHint.setText("Export all elements from the list into a text file");
    }//GEN-LAST:event_jButtonExportMouseEntered

    private void jButtonExportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExportMouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jButtonExportMouseExited

    private void jButtonImportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonImportMouseEntered
        jLabelHint.setText("Import all elements from a text file into the list");
    }//GEN-LAST:event_jButtonImportMouseEntered

    private void jButtonImportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonImportMouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jButtonImportMouseExited

    private void jRadioButtonGenPWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGenPWActionPerformed
        if (jRadioButtonGenPW.isEnabled()) {
            jTextFieldEnterPW.setEnabled(false); //schaltet das Texteingabefeld aus
            jCheckBoxNum.setEnabled(true); //schaltet die Checkbox Numbers ein
            jCheckBoxaz.setEnabled(true); //schaltet die checkbox klein a-z ein
            jCheckBoxAZ.setEnabled(true); //schaltet die checkbox groß A-Z ein
            jCheckBoxSpezial.setEnabled(true); //schaltet die checkbox Spezial ein
            jSliderPasswordLength.setEnabled(true); //schaltet den schieberegler zur zeichenlängenfestlegung ein
            jLabelSliderInt.setEnabled(true); //schaltet die anzeige des aktuellen werdes des schiebereglers ein
            jSpinnerCountOf.setEnabled(true); //schaltet den counter für die anzahl zu generierdenen passwörter ein
        }
    }//GEN-LAST:event_jRadioButtonGenPWActionPerformed

    private void jRadioButtonGenOwnPWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGenOwnPWActionPerformed
        if (jRadioButtonGenOwnPW.isEnabled()) {
            jTextFieldEnterPW.setEnabled(true); //schaltet das Texteingabefeld aus
            jCheckBoxNum.setEnabled(false); //schaltet die Checkbox Numbers ein
            jCheckBoxaz.setEnabled(false); //schaltet die checkbox klein a-z ein
            jCheckBoxAZ.setEnabled(false); //schaltet die checkbox groß A-Z ein
            jCheckBoxSpezial.setEnabled(false); //schaltet die checkbox Spezial ein
            jSliderPasswordLength.setEnabled(false); //schaltet den schieberegler zur zeichenlängenfestlegung ein
            jLabelSliderInt.setEnabled(false); //schaltet die anzeige des aktuellen werdes des schiebereglers ein
            jSpinnerCountOf.setEnabled(true); //schaltet den counter für die anzahl zu generierdenen passwörter ein
        }
    }//GEN-LAST:event_jRadioButtonGenOwnPWActionPerformed

    /**
     * 
     * @param text will be added to list
     */
    protected void addToList(String text) { //fügt das passwort und die dazugehörige Prüf Summe der Liste (ausgabe) hinzu
        this.listModel.addElement(text); //fügt das passwort der liste (ausgabe) hinzu
        this.jLabelPWCount.setText(Integer.toString(Password.getCount()));
    }

    /**
     * creates a new GUI Window.
     */
    @Override
    public void run() {
        new PasswordGenerator().setVisible(true);
    }

    /**
     * will verify some input and choose what to do, depending on user input.
     */
    private void generate() {
        total = Integer.parseInt(jSpinnerCountOf.getValue().toString()); //setzt total mit der anzahl zu generierender passwörter
        jProgressBar.setValue(0); //setzt den fortschritsbalken zurrück
        jProgressBar.setMaximum(total); //setzt das maximum des fortschrittbalkens auf die anzahl zu generierender passwörter
        if (jRadioButtonGenOwnPW.isSelected()) { //Wenn RadioButton GenMD5 aktiv
            if (!jTextFieldEnterPW.getText().isEmpty() && !listModel.contains(jTextFieldEnterPW.getText())) { //Wenn TextFeldEnterPW NICHT leer und wenn Inhalt nicht schon in Liste vorhanden.
                //TODO unterscheidung zwischen MD5 und SHA-1 oder auch garkeine
                Password GenOwnpw = new Password(jTextFieldEnterPW.getText());
                addToList(GenOwnpw.getPassword());
                if (jCheckBoxGenHash.isSelected()) {
                    if (jComboBoxAlg.getSelectedIndex() == 0) {
                        GenOwnpw.setMD5();
                        addToList(GenOwnpw.getMD5());
                    }
                    if (jComboBoxAlg.getSelectedIndex() == 1) {
                        GenOwnpw.setSHA1();
                        addToList(GenOwnpw.getSHA1());
                    }
                }
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        jProgressBar.setValue(jProgressBar.getValue() + 1);
                    }
                });
            }
            jTextFieldEnterPW.setText(null);
        }
        if (jRadioButtonGenPW.isSelected()) { //Wenn RadioButton GenPW aktiv
            if (jCheckBoxNum.isSelected()) { //Wenn ChechBoxNummern aktiv
                chars += numbers;
            } // füge zur Zeichenauswahl die Zeichen 0 bis 9 hinzu
            if (jCheckBoxaz.isSelected()) { //Wenn ChechBox a-z (klein) aktiv
                chars += lowAlphabet;
            } // füge zur Zeichenauswahl die Zeichen a bis z hinzu
            if (jCheckBoxAZ.isSelected()) { //Wenn ChechBox A-Z (Groß) aktiv
                chars += upAlphabet;
            } // füge zur Zeichenauswahl die Zeichen A bis Z hinzu
            if (jCheckBoxSpezial.isSelected()) { //Wenn ChechBox Sonderzeichen aktiv
                chars += special;
            } // füge zur Zeichenauswahl die Zeichen !\"#$%&'()*+,-./:;<=>?@ hinzu
            if (!chars.isEmpty()) { //macht nur weiter wenn mindestens ei n zeichensatz (checkboxen) aktiv ist
                while (Integer.parseInt(jSpinnerCountOf.getValue().toString()) >= 1) { //vergleich ob die anzahl zu generierenden passwoörtern großer oder gleich 1 ist.
//                    Thread passwordworker = new Thread(new WorkerPassword()); //neuer worker zum passwordgenerieren und hinzufügen
//                    Thread statusworker = new Thread(new WorkerStatus()); //neueer worker zum aktualisieren einiger GUI Elemente und des zählers für diese Schleife
//                    passwordworker.start(); //startet den passwordworker
//                    try {
//                        passwordworker.join(); //hier wird gewartet bis der passwordworker fertig ist
//                        statusworker.start(); //startet den statusworker
//                        statusworker.join(); //hier wird gewartet bis der statusworker fetig ist
//                    } catch (InterruptedException ex) {
//                        JOptionPane.showMessageDialog(new JFrame("InterruptedException!"), ex.getMessage()); //erzeugt ein fenster mit inhalt der fehlermeldung, kann auftreten wenn beim warten auf einen thread, dieser unterbrochen wird.
//                    }
                    Password Genpw = new Password(getChars().toCharArray(), jSliderPasswordLength.getValue());
                    addToList(Genpw.getPassword());
                    if (jCheckBoxGenHash.isSelected()) {
                        if (jComboBoxAlg.getSelectedIndex() == 0) {
                            Genpw.setMD5();
                            addToList(Genpw.getMD5());
                        }
                        if (jComboBoxAlg.getSelectedIndex() == 1) {
                            Genpw.setSHA1();
                            addToList(Genpw.getSHA1());
                        }
                    }
                    jSpinnerCountOf.setValue((Integer.parseInt(jSpinnerCountOf.getValue().toString())) - 1); //zählt die anzahl zu generierenden passwörter um einen runter.
                    //TODO unterscheidung zwischen MD5 und SHA-1 oder auch garkeine
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            jProgressBar.setValue(jProgressBar.getValue() + 1);
                        }
                    });
                }
                jSpinnerCountOf.setValue(1); //setzt die anzahl zu generierenden passwörter zurück auf 1.
            }
        }
    }

    /**
     *
     * @return (as String) returns alls chars of choice
     */
    protected String getChars() {
        return this.chars;
    }

    /**
     *
     * @return (as int) JSliderPasswordLength Value
     */
    protected int getJSliderPasswordLength() {
        return this.jSliderPasswordLength.getValue();
    }

    /**
     *
     * @param count (as int) to set the value.
     */
    protected void setJSpinnerCountOf(int count) {
        this.jSpinnerCountOf.setValue(count);
    }

    /**
     *
     * @return (as int) JSpinnerCountOf Value
     */
    protected int getJSpinnerCountOf() {
        return Integer.parseInt(this.jSpinnerCountOf.getValue().toString());
    }

    /**
     *
     * @return (as int) jProgressBar Value
     */
    protected int getJProgressBar() {
        return this.jProgressBar.getValue();
    }

    /**
     *
     * @param count (as int) to set value.
     */
    protected void setJProgressBar(int count) {
        this.jProgressBar.setValue(count);
    }

    /**
     * @param args No Arguments run this program...
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame("ClassNotFoundException!"), ex.getMessage());
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(new JFrame("InstantiationException!"), ex.getMessage());
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(new JFrame("IllegalAccessException!"), ex.getMessage());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(new JFrame("UnsupportedLookAndFeelException!"), ex.getMessage());
        }
        //<editor-fold defaultstate="collapsed" desc="GUI MIT extra Thread">
//        PasswordGui = new PasswordGenerator();
//        Thread PwGen = new Thread(PasswordGui); //erstellt ein neues objekt der GUI (als Thread)
//        PwGen.start(); //startet die GUI (den Thread)//</editor-fold>
        // <editor-fold defaultstate="collapsed" desc="GUI OHNE extra Thread"> 
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            /**
             * create a new object of the extended frame (PasswordGenerator)
             */
            public void run() {
                PasswordGui = new PasswordGenerator();
                PasswordGui.setVisible(true);
            }
        });// </editor-fold>  
    }
    protected static PasswordGenerator PasswordGui;
    private String chars = "";
    private int total; //die anzahl zu generierenden passwöreter (nich nicht beötigt)
    private DefaultListModel<String> listModel; // deklariert die Variable listModel vom typ DefaultListModel<String>
    private String numbers = "0123456789";
    private String lowAlphabet = "abcdefghijklmnopqrstuvwxyz";
    private String upAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String special = "!\"#$%&'()*+,-./:;<=>?@";
    private SpinnerModel sm = new SpinnerNumberModel(1, 1, 100000, 1);
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonExport;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JButton jButtonImport;
    private javax.swing.JCheckBox jCheckBoxAZ;
    private javax.swing.JCheckBox jCheckBoxGenHash;
    private javax.swing.JCheckBox jCheckBoxNum;
    private javax.swing.JCheckBox jCheckBoxSpezial;
    private javax.swing.JCheckBox jCheckBoxaz;
    private javax.swing.JComboBox jComboBoxAlg;
    private javax.swing.JLabel jLabelHint;
    private javax.swing.JLabel jLabelPWCount;
    private javax.swing.JLabel jLabelSliderInt;
    private javax.swing.JList jListOut;
    private final javax.swing.JProgressBar jProgressBar = new javax.swing.JProgressBar();
    private javax.swing.JRadioButton jRadioButtonGenOwnPW;
    private javax.swing.JRadioButton jRadioButtonGenPW;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSliderPasswordLength;
    private javax.swing.JSpinner jSpinnerCountOf;
    private javax.swing.JTextField jTextFieldEnterPW;
    // End of variables declaration//GEN-END:variables
}
