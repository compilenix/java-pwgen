package passwordgenerator;

//TODO statt Outputliste eine tabelle (zwei spalten)
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 * This program can generate a MD5 Hash from a known String or generate a
 * password (incl. a MD5 Hash).<br/>
 * <p/>
 * @author Kevin Weis
 * @version 2.3b4
 */
public class PasswordGenerator extends JFrame {

    /**
     * Constructor: It will create the Frame and set all to default.
     */
    public PasswordGenerator() {
        listModel = new DefaultListModel<>();
        initComponents();// generiert das gesammte layout des fensters und die erforderlichen objekte wie buttons etc.
        jTextFieldEnterPW.setEnabled(false);
        jLabelSliderInt.setText("12");
//        jButtonExport.setEnabled(true);
        jButtonImport.setVisible(false);
        jComboBoxAlg.setEnabled(false);
        jLabelPleaseWait.setVisible(false);
        jSpinnerCountOf.setValue(1);
        jButtonGenerate.requestFocus();
    }

    /**
     * @return the PasswordGui.
     */
    public static PasswordGenerator getPasswordGui() {
        return PasswordGui;
    }

    /**
     * @param aPasswordGui the PasswordGui to set.
     */
    public static void setPasswordGui(PasswordGenerator aPasswordGui) {
        PasswordGui = aPasswordGui;
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
        jSpinnerCountOf = new javax.swing.JSpinner();
        jLabelHint = new javax.swing.JLabel();
        jLabelPWCount = new javax.swing.JLabel();
        jButtonExport = new javax.swing.JButton();
        jButtonImport = new javax.swing.JButton();
        jComboBoxAlg = new javax.swing.JComboBox();
        jCheckBoxGenHash = new javax.swing.JCheckBox();
        jLabelPleaseWait = new javax.swing.JLabel();
        jButtonDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Password Generator V2.4b"); // NOI18N
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
        jRadioButtonGenOwnPW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jRadioButtonGenOwnPWMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jRadioButtonGenOwnPWMouseExited(evt);
            }
        });
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
        jListOut.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
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

        jComboBoxAlg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SHA-1", "SHA-256", "MD5"}));
        jComboBoxAlg.setSelectedIndex(0);
        jComboBoxAlg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBoxAlgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jComboBoxAlgMouseExited(evt);
            }
        });

        jCheckBoxGenHash.setText("Gen. Hash");
        jCheckBoxGenHash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jCheckBoxGenHashMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jCheckBoxGenHashMouseExited(evt);
            }
        });
        jCheckBoxGenHash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxGenHashActionPerformed(evt);
            }
        });

        jLabelPleaseWait.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelPleaseWait.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPleaseWait.setText("Please Wait!");
        jLabelPleaseWait.setFocusable(false);

        jButtonDelete.setText("Delete Selected Element");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPleaseWait, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonGenOwnPW, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldEnterPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonGenerate)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonExport, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jButtonImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPleaseWait, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHint)
                    .addComponent(jLabelPWCount))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-341)/2, (screenSize.height-557)/2, 341, 557);
    }// </editor-fold>//GEN-END:initComponents
    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        clear();
    }//GEN-LAST:event_jButtonClearActionPerformed
    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
        new Worker().execute();
//        generate();
    }//GEN-LAST:event_jButtonGenerateActionPerformed

    private void jSliderPasswordLengthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderPasswordLengthStateChanged
        jLabelSliderInt.setText(Integer.toString(
                jSliderPasswordLength.getValue())); //sorgt für die aktuallisierung der anzeige des aktuellen wertes der zeichenlängenfestlegung
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
        if (!listModel.isEmpty()) {
            FileIO.writeDefaultListModel(listModel);
            FileIO.firstLine = true;
        }
    }//GEN-LAST:event_jButtonExportActionPerformed

    @SuppressWarnings("unchecked")
    private void jButtonImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportActionPerformed
//        clear();
//TODO für importierete passwote hash generieren.
//        jListOut.setModel(FileIO.ReadDefaultListModel(FileIO.dialogOpen()));
    }//GEN-LAST:event_jButtonImportActionPerformed

    private void jTextFieldEnterPWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEnterPWActionPerformed
        new Worker().execute();
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
            jTextFieldEnterPW.setEnabled(false);
            jCheckBoxNum.setEnabled(true);
            jCheckBoxaz.setEnabled(true);
            jCheckBoxAZ.setEnabled(true);
            jCheckBoxSpezial.setEnabled(true);
            jSliderPasswordLength.setEnabled(true);
            jLabelSliderInt.setEnabled(true);
            jSpinnerCountOf.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButtonGenPWActionPerformed

    private void jRadioButtonGenOwnPWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGenOwnPWActionPerformed
        if (jRadioButtonGenOwnPW.isEnabled()) {
            jTextFieldEnterPW.setEnabled(true);
            jCheckBoxNum.setEnabled(false);
            jCheckBoxaz.setEnabled(false);
            jCheckBoxAZ.setEnabled(false);
            jCheckBoxSpezial.setEnabled(false);
            jSliderPasswordLength.setEnabled(false);
            jLabelSliderInt.setEnabled(false);
            jSpinnerCountOf.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButtonGenOwnPWActionPerformed

    private void jRadioButtonGenOwnPWMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonGenOwnPWMouseEntered
        jLabelHint.setText("Add the password to the list and optional a hash of it");
    }//GEN-LAST:event_jRadioButtonGenOwnPWMouseEntered

    private void jRadioButtonGenOwnPWMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonGenOwnPWMouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jRadioButtonGenOwnPWMouseExited

    private void jCheckBoxGenHashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxGenHashActionPerformed
        if (jCheckBoxGenHash.isSelected()) {
            jComboBoxAlg.setEnabled(true);
        }
        if (!jCheckBoxGenHash.isSelected()) {
            jComboBoxAlg.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxGenHashActionPerformed

    private void jCheckBoxGenHashMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxGenHashMouseEntered
        jLabelHint.setText("Calculate a hash of the password");
    }//GEN-LAST:event_jCheckBoxGenHashMouseEntered

    private void jCheckBoxGenHashMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxGenHashMouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jCheckBoxGenHashMouseExited

    private void jComboBoxAlgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxAlgMouseEntered
        jLabelHint.setText("Choose what algorithm you want");
    }//GEN-LAST:event_jComboBoxAlgMouseEntered

    private void jComboBoxAlgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxAlgMouseExited
        jLabelHint.setText(" ");
    }//GEN-LAST:event_jComboBoxAlgMouseExited

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        if (!listModel.isEmpty()) {
            int selected = jListOut.getSelectedIndex();
            if (selected != -1) {
                listModel.remove(selected);
                Password.setCount(Password.getCount() - 1);
                jLabelPWCount.setText(
                        Integer.toString(Password.getCount()));
            }
            if (jListOut.getSelectedIndex() < 0) {
                jListOut.setSelectedIndex(selected);
                jListOut.ensureIndexIsVisible(selected);
            }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    /**
     * @param text will be added to listModel.
     */
    public void addToList(String text) {
        listModel.addElement(text);
        jLabelPWCount.setText(
                Integer.toString(Password.getCount()));
    }

    /**
     * This method clear all data of the output list.
     */
    public void clear() {
        listModel.clear();
        Password.resetCount();
        jLabelPWCount.setText(
                Integer.toString(Password.getCount()));
        jSpinnerCountOf.setValue(1);
    }

    /**
     * will verify some input and choose what to do, depending on user input,
     * selected boxes etc...
     */
    private void generate() {
        jButtonDelete.setVisible(false);
        chars = "";
        if (jRadioButtonGenOwnPW.isSelected()) {
            if (!jTextFieldEnterPW.getText().isEmpty() && !listModel.contains(jTextFieldEnterPW.getText())) {
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
                }// jCheckBoxGenHash.isSelected()
            }// Wenn TextFeldEnterPW NICHT leer und wenn Inhalt nicht schon in der Liste vorhanden.
            jTextFieldEnterPW.setText("");
        }// jRadioButtonGenOwnPW.isSelected()
        if (jRadioButtonGenPW.isSelected()) {
            int count = Integer.parseInt(jSpinnerCountOf.getValue().toString());
            if (count > 10000) {
                JOptionPane.showMessageDialog(null, "Oh... you choosen too much Passwords... I´ll set it for you back to 10.000", "Tooooooo much Passwords!", 2);
                jSpinnerCountOf.setValue(10000);
            } else if (count < 0) {
                JOptionPane.showMessageDialog(null, "Oh... you choosen a negative count... I´ll set it for you back to 1", "Negative count!", 2);
                jSpinnerCountOf.setValue(1);
            } else if (count == 0) {
                JOptionPane.showMessageDialog(null, "Oh... you choosen... zero. I´ll set it for you back to 1", "Zero count!", 2);
                jSpinnerCountOf.setValue(1);
            }
            if (jCheckBoxNum.isSelected()) { //Wenn ChechBoxNummern aktiv
                chars += numbers;
            }
            if (jCheckBoxaz.isSelected()) {
                chars += lowAlphabet;
            }
            if (jCheckBoxAZ.isSelected()) {
                chars += upAlphabet;
            }
            if (jCheckBoxSpezial.isSelected()) {
                chars += special; // die Zeichen !\"#$%&'()*+,-./:;<=>?@
            }
            if (Integer.parseInt(jSpinnerCountOf.getValue().toString()) >= 1000) {
                jLabelPleaseWait.setVisible(true);
                PasswordGui.paint(PasswordGui.getGraphics());
            }
            if (!chars.isEmpty()) {
                while (Integer.parseInt(jSpinnerCountOf.getValue().toString()) >= 1) {
                    try {
                        Password Genpw = new Password(chars.toCharArray(), jSliderPasswordLength.getValue());
                        //zählt die anzahl zu generierenden passwörter um einen runter.
                        jSpinnerCountOf.setValue((Integer.parseInt(jSpinnerCountOf.getValue().toString())) - 1);
                        addToList(Genpw.getPassword());
                        if (jCheckBoxGenHash.isSelected()) {
                            if (jComboBoxAlg.getSelectedIndex() == 0) {
                                Genpw.setSHA1();
                                addToList(Genpw.getSHA1());
                            }
                            if (jComboBoxAlg.getSelectedIndex() == 1) {
                                Genpw.setSHA256();
                                addToList(Genpw.getSHA256());
                            }
                            if (jComboBoxAlg.getSelectedIndex() == 2) {
                                Genpw.setMD5();
                                addToList(Genpw.getMD5());
                            }
                        }// jCheckBoxGenHash.isSelected()
                        Thread.sleep(0, 0);
                    } // try
                    catch (NumberFormatException | InterruptedException ex) {/*
                         * doing nothing
                         */

                    }
                }// While
            }// !chars.isEmpty()
            jSpinnerCountOf.setValue(1);
            jSpinnerCountOf.requestFocus();
        }// jRadioButtonGenPW.isSelected()
        jLabelPleaseWait.setVisible(false);
        jButtonDelete.setVisible(true);
    }// generate()
    private static PasswordGenerator PasswordGui;
    private String chars = "";
    private DefaultListModel<String> listModel;
    private String numbers = "0123456789";
    private String lowAlphabet = "abcdefghijklmnopqrstuvwxyz";
    private String upAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String special = "!\"#$%&'()*+,-./:;<=>?@";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDelete;
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
    private javax.swing.JLabel jLabelPleaseWait;
    private javax.swing.JLabel jLabelSliderInt;
    private javax.swing.JList jListOut;
    private javax.swing.JRadioButton jRadioButtonGenOwnPW;
    private javax.swing.JRadioButton jRadioButtonGenPW;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSliderPasswordLength;
    private javax.swing.JSpinner jSpinnerCountOf;
    private javax.swing.JTextField jTextFieldEnterPW;
    // End of variables declaration//GEN-END:variables

    private class Worker extends SwingWorker<Void, Void> {

        @Override
        public Void doInBackground() {
            generate();
            return null;
        }
    }
}
