package passwordgenerator;

import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 * Here are the main logic operations... and the GUI.<br/>
 * <p/>
 * @author Kevin Weis
 * @version 2.4
 */
public class PasswordGenerator extends JFrame {

    /**
     * Constructor: It will create the Frame and set all to default.
     */
    public PasswordGenerator() {
        initComponents();// generiert das gesammte layout des fensters und die erforderlichen objekte wie buttons etc.
        setIconImage(Toolkit.getDefaultToolkit().getImage(url));
        java.awt.Dimension DefaultDimension = new java.awt.Dimension(550, 550);// original 330 zu 550
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - DefaultDimension.width) / 2,
                (screenSize.height - DefaultDimension.height) / 2,
                DefaultDimension.width, DefaultDimension.height);
        setSize(DefaultDimension.width, DefaultDimension.height);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTextFieldEnterPW.setEnabled(false);
        jLabelSliderInt.setText("12");
        jProgressBar.setVisible(false);
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
        jComboBoxAlg = new javax.swing.JComboBox<String>();
        jCheckBoxGenHash = new javax.swing.JCheckBox();
        jLabelPleaseWait = new javax.swing.JLabel();
        jButtonDelete = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jProgressBar = new javax.swing.JProgressBar();
        jLabelPasswordCount = new javax.swing.JLabel();
        jButtonSelect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Password Generator V2.4"); // NOI18N
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(463, 500));
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

        jComboBoxAlg.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "SHA-1", "SHA-256", "MD5"}));
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

        jTable.setModel(tableModel = new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Password", "Hash"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setColumnSelectionAllowed(true);
        jScrollPane.setViewportView(jTable);
        jTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jProgressBar.setFocusable(false);
        jProgressBar.setRequestFocusEnabled(false);
        jProgressBar.setStringPainted(true);

        jLabelPasswordCount.setText("Password Count");

        jButtonSelect.setText("Select All");
        jButtonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButtonGenOwnPW)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEnterPW))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jSliderPasswordLength, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelSliderInt, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jRadioButtonGenPW)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxGenHash)))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jComboBoxAlg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jCheckBoxNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxaz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxAZ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxSpezial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelPasswordCount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerCountOf, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelHint, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPWCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonImport, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPleaseWait, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExport, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxAlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelSliderInt)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxNum)
                    .addComponent(jCheckBoxaz)
                    .addComponent(jCheckBoxAZ)
                    .addComponent(jCheckBoxSpezial)
                    .addComponent(jSpinnerCountOf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPasswordCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButtonImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPleaseWait, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSelect)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHint)
                    .addComponent(jLabelPWCount))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-709)/2, (screenSize.height-557)/2, 709, 557);
    }// </editor-fold>//GEN-END:initComponents
    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        worker = new workerClear();
        worker.execute();
    }//GEN-LAST:event_jButtonClearActionPerformed
    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
        worker = new workerGenerate();
        worker.execute();
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
        worker = new workerExport();
        worker.execute();
    }//GEN-LAST:event_jButtonExportActionPerformed

    @SuppressWarnings("unchecked")
    private void jButtonImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportActionPerformed
        //TODO Import...
        File file = FileIO.dialogOpen();
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You want to generate a hash of what you import?", "Generate hash", 0, 3);
    }//GEN-LAST:event_jButtonImportActionPerformed

    private void jTextFieldEnterPWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEnterPWActionPerformed
        worker = new workerGenerate();
        worker.execute();
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
        class workerDelete extends SwingWorker<Void, Void> {

            @Override
            public Void doInBackground() {
                if (Password.getCount() >= 1) {

                    int[] rows = jTable.getSelectedRows();
                    if (!(rows.length <= 0)) {
                        jButtonClear.setEnabled(false);
                        jButtonGenerate.setEnabled(false);
                        jButtonExport.setVisible(false);
                        jButtonSelect.setVisible(false);
                        jButtonDelete.setVisible(false);
                        for (int i = 0; i < rows.length; i++) {
                            tableModel.removeRow(rows[0]);
                            Password.setCount(Password.getCount() - 1);
                            jLabelPWCountSetText();
                        }
                        jLabelPleaseWait.setVisible(false);
                        jButtonExport.setVisible(true);
                        jButtonDelete.setVisible(true);
                        jButtonClear.setEnabled(true);
                        jButtonGenerate.setEnabled(true);
                        jButtonSelect.setVisible(true);
                    }
                }
                return null;
            }
        }
        worker = new workerDelete();
        worker.execute();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectActionPerformed
        jTable.selectAll();
    }//GEN-LAST:event_jButtonSelectActionPerformed

    private void jLabelPWCountSetText() {
        jLabelPWCount.setText(Integer.toString(Password.getCount()));
    }

    /**
     * This method clear all data of the output table.
     */
    public void clear() {
        int count = Password.getCount();
        jButtonClear.setEnabled(false);
        jButtonGenerate.setEnabled(false);
        jButtonExport.setVisible(false);
        jButtonDelete.setVisible(false);
        jButtonSelect.setVisible(false);
        if (tableModel.getRowCount() <= 100000) {
            for (int i = 0; i < count; i++) {
                tableModel.removeRow(0);
                Password.setCount(Password.getCount() - 1);
                jLabelPWCountSetText();
            }
        }
        if (tableModel.getRowCount() > 100000) {
            tableModel.getDataVector().removeAllElements();
            jScrollPane.repaint();
        }
        jLabelPleaseWait.setVisible(false);
        jButtonExport.setVisible(true);
        jButtonDelete.setVisible(true);
        jButtonClear.setEnabled(true);
        jButtonGenerate.setEnabled(true);
        jButtonSelect.setVisible(true);
        Password.resetCount();
        jLabelPWCountSetText();
    }

    /**
     * will verify some input and choose what to do, depending on user input,
     * selected boxes etc...
     */
    private void generate() {
        chars = "";
        jButtonSelect.setVisible(false);
        if (jRadioButtonGenOwnPW.isSelected()) {
            if (!jTextFieldEnterPW.getText().isEmpty()) {
                Password GenOwnpw = new Password(jTextFieldEnterPW.getText());
                if (jCheckBoxGenHash.isSelected()) {
                    if (jComboBoxAlg.getSelectedIndex() == 0) {
                        GenOwnpw.setSHA1();
                        tableModel.addRow(new Object[]{GenOwnpw.getPassword(), GenOwnpw.getSHA1()});
                        jLabelPWCountSetText();
                    }
                    if (jComboBoxAlg.getSelectedIndex() == 1) {
                        GenOwnpw.setSHA256();
                        tableModel.addRow(new Object[]{GenOwnpw.getPassword(), GenOwnpw.getSHA256()});
                        jLabelPWCountSetText();
                    }
                    if (jComboBoxAlg.getSelectedIndex() == 2) {
                        GenOwnpw.setMD5();
                        tableModel.addRow(new Object[]{GenOwnpw.getPassword(), GenOwnpw.getMD5()});
                        jLabelPWCountSetText();
                    }
                }// jCheckBoxGenHash.isSelected()
                if (!jCheckBoxGenHash.isSelected()) {
                    tableModel.addRow(new Object[]{GenOwnpw.getPassword(), ""});
                    jLabelPWCountSetText();
                }
            }// Wenn TextFeldEnterPW NICHT leer und wenn Inhalt nicht schon in der Liste vorhanden.
            jTextFieldEnterPW.setText("");
        }// jRadioButtonGenOwnPW.isSelected()
        if (jRadioButtonGenPW.isSelected()) {
            int count = Integer.parseInt(jSpinnerCountOf.getValue().toString());
            if (count > 1000000) {
                JOptionPane.showMessageDialog(null, "Oh... you choosen too much Passwords... I´ll set it for you back to 1.000.000", "Tooooooo much Passwords!", 2);
                jSpinnerCountOf.setValue(1000000);
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
                jButtonExport.setVisible(false);
                jButtonDelete.setVisible(false);
                jButtonClear.setEnabled(false);
                jButtonGenerate.setEnabled(false);
                jButtonImport.setEnabled(false);
                jProgressBar.setVisible(true);
                jProgressBar.setValue(0);
                jProgressBar.setMinimum(0);
                jProgressBar.setMaximum(count);
            }
            if (!chars.isEmpty()) {
                while (Integer.parseInt(jSpinnerCountOf.getValue().toString()) >= 1) {
                    try {
                        Password Genpw = new Password(chars.toCharArray(), jSliderPasswordLength.getValue());
                        //zählt die anzahl zu generierenden passwörter um einen runter.
                        jSpinnerCountOf.setValue((Integer.parseInt(jSpinnerCountOf.getValue().toString())) - 1);
                        if (jCheckBoxGenHash.isSelected()) {
                            if (jComboBoxAlg.getSelectedIndex() == 0) {
                                Genpw.setSHA1();
                                tableModel.addRow(new Object[]{Genpw.getPassword(), Genpw.getSHA1()});
                                jLabelPWCountSetText();

                            }
                            if (jComboBoxAlg.getSelectedIndex() == 1) {
                                Genpw.setSHA256();
                                tableModel.addRow(new Object[]{Genpw.getPassword(), Genpw.getSHA256()});
                                jLabelPWCountSetText();
                            }
                            if (jComboBoxAlg.getSelectedIndex() == 2) {
                                Genpw.setMD5();
                                tableModel.addRow(new Object[]{Genpw.getPassword(), Genpw.getMD5()});
                                jLabelPWCountSetText();
                            }
                        }// jCheckBoxGenHash.isSelected()
                        if (!jCheckBoxGenHash.isSelected()) {
                            tableModel.addRow(new Object[]{Genpw.getPassword(), ""});
                            jLabelPWCountSetText();
                        }
                        Thread.sleep(0, 0);
                    } // try
                    catch (Exception ex) { //doing nothing...
                    }
                    jProgressBar.setValue(jProgressBar.getValue() + 1);
                }// While
            }// !chars.isEmpty()
            jSpinnerCountOf.setValue(1);
            jSpinnerCountOf.requestFocus();
        }// jRadioButtonGenPW.isSelected()
        jLabelPleaseWait.setVisible(false);
        jButtonExport.setVisible(true);
        jButtonDelete.setVisible(true);
        jButtonClear.setEnabled(true);
        jButtonGenerate.setEnabled(true);
        jButtonImport.setEnabled(true);
        jProgressBar.setVisible(false);
        jButtonSelect.setVisible(true);
    }// generate()
    private static PasswordGenerator PasswordGui;
    private String chars = "";
    private DefaultTableModel tableModel;
    private String numbers = "0123456789";
    private String lowAlphabet = "abcdefghijklmnopqrstuvwxyz";
    private String upAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String special = "!\"#$%&'()*+,-./:;<=>?@";
    private SwingWorker<Void, Void> worker;
    private URL url = PasswordGenerator.class.getResource("Password.png");
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonExport;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JButton jButtonImport;
    private javax.swing.JButton jButtonSelect;
    private javax.swing.JCheckBox jCheckBoxAZ;
    private javax.swing.JCheckBox jCheckBoxGenHash;
    private javax.swing.JCheckBox jCheckBoxNum;
    private javax.swing.JCheckBox jCheckBoxSpezial;
    private javax.swing.JCheckBox jCheckBoxaz;
    /*
    private javax.swing.JComboBox jComboBoxAlg;
    */
    private javax.swing.JLabel jLabelHint;
    private javax.swing.JLabel jLabelPWCount;
    private javax.swing.JLabel jLabelPasswordCount;
    private javax.swing.JLabel jLabelPleaseWait;
    private javax.swing.JLabel jLabelSliderInt;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JRadioButton jRadioButtonGenOwnPW;
    private javax.swing.JRadioButton jRadioButtonGenPW;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JSlider jSliderPasswordLength;
    private javax.swing.JSpinner jSpinnerCountOf;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldEnterPW;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JComboBox<String> jComboBoxAlg;

    private class workerClear extends SwingWorker<Void, Void> {

        @Override
        public Void doInBackground() {
            clear();
            return null;
        }
    }

    private class workerExport extends SwingWorker<Void, Void> {

        @Override
        public Void doInBackground() {
            int count = Password.getCount();
            if (count != 0) {
                if (count > 5000) {
                    jLabelPleaseWait.setVisible(true);
                    jButtonExport.setVisible(false);
                    jButtonImport.setVisible(false);
                    jButtonDelete.setVisible(false);
                    jButtonSelect.setVisible(false);
                    jProgressBar.setVisible(true);
                    jProgressBar.setValue(0);
                    jProgressBar.setMinimum(0);
                    jProgressBar.setMaximum(count);
                }
                File file = FileIO.dialogSave();
                if (file != null) {
                    FileIO.setFirstLine(true);
                    for (int i = 0; i < count; i++) {
                        FileIO.lineWrite(file, tableModel.getValueAt(i, 0).toString());
                        if (!tableModel.getValueAt(i, 1).toString().isEmpty()) {
                            FileIO.lineAppandTab(file, tableModel.getValueAt(i, 1).toString());
                        }
                        jProgressBar.setValue(jProgressBar.getValue() + 1);
                    }
                    FileIO.dialogWritten(file);
                }
                jLabelPleaseWait.setVisible(false);
                jProgressBar.setVisible(false);
                jButtonExport.setVisible(true);
                jButtonDelete.setVisible(true);
                jButtonSelect.setVisible(true);
//                jButtonImport.setVisible(false);
            }
            return null;
        }
    }

    private class workerGenerate extends SwingWorker<Void, Void> {

        @Override
        public Void doInBackground() {
            generate();
            return null;
        }
    }
}
