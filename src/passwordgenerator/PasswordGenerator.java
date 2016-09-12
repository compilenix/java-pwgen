package passwordgenerator;
// <editor-fold defaultstate="collapsed" desc="CMD Version">
//import java.util.Scanner;
// </editor-fold>
import javax.swing.DefaultListModel;
/*
 *
 * This program can generate a MD5 Hash from a known String or generate a ~8
 * char long String (incl. a MD5 Hash).
 @author Kevin Weis
 @version 2012-04-18
 */

public class PasswordGenerator extends javax.swing.JFrame {
// <editor-fold defaultstate="collapsed" desc="CMD Version">
// private static Scanner read = new Scanner(System.in);
// private static String answer = "";
// </editor-fold>

    /**
     *
     * the main method to run the program and create the GUI
     */
    public PasswordGenerator() {
        listModel = new DefaultListModel<>();
        initComponents();
        jTextFieldEnterPW.setEnabled(!isEnabled());
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Password Generator"); // NOI18N
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(350, 259));

        buttonGroup1.add(jRadioButtonGenPW);
        jRadioButtonGenPW.setSelected(true);
        jRadioButtonGenPW.setText("Gen. Password");
        jRadioButtonGenPW.setToolTipText("");
        jRadioButtonGenPW.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRadioButtonGenPW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGenPWActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonGenMD5);
        jRadioButtonGenMD5.setText("Gen. MD5 Hash");
        jRadioButtonGenMD5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGenMD5ActionPerformed(evt);
            }
        });

        jTextFieldEnterPW.setToolTipText("Type here the password");

        jButtonGenerate.setText("Generate");
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });

        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jListOut.setModel(listModel);
        jScrollPane1.setViewportView(jListOut);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEnterPW, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButtonGenPW)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonGenMD5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
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
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        listModel.clear();
    }//GEN-LAST:event_jButtonClearActionPerformed
    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
        if (jRadioButtonGenMD5.isSelected()) {
            if (jTextFieldEnterPW.getText().length() != 0 && !jTextFieldEnterPW.getText().equals(normalPassword.getClear())) {
                normalPassword = new Password(jTextFieldEnterPW.getText());
                addToList();
            }
        }
        if (jRadioButtonGenPW.isSelected()) {
            normalPassword = new Password();
            addToList();
        }
    }//GEN-LAST:event_jButtonGenerateActionPerformed
    private void jRadioButtonGenPWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGenPWActionPerformed
        jTextFieldEnterPW.setEnabled(!isEnabled());
    }//GEN-LAST:event_jRadioButtonGenPWActionPerformed
    private void jRadioButtonGenMD5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGenMD5ActionPerformed
        jTextFieldEnterPW.setEnabled(isEnabled());
    }//GEN-LAST:event_jRadioButtonGenMD5ActionPerformed
    private void addToList() {
        listModel.addElement(normalPassword.getClear());
        listModel.addElement(normalPassword.getPassword());
    }

    /**
     * @param args No Arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc="GUI Version">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
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
            public void run() {
                new PasswordGenerator().setVisible(true);
            }
        }); //</editor-fold>
        // <editor-fold defaultstate="collapsed" desc="CMD Version">
//        String ans1 = "pw";
//        String ans2 = "md5";
//        while (!answer.equals(ans1) && !answer.equals(ans2)) { //solange answer nicht pw ist und auch nicht md5 führe die schleife aus
//            ask();
//            //System.out.println(answer); // für debuging um auszugeben wie sich der User entschieden hat
//        }
//        if (answer.equals(ans1)) {
//            genpw();
//        } else if (answer.equals(ans2)) {
//            genhash();
//        }
//        read.next();
//        System.exit(0); 
        // </editor-fold>
    }
    // <editor-fold defaultstate="collapsed" desc="CMD Version">
//    private static void genpw(){
//        Password normalPassword = new Password();
//        System.out.println("The password is:" + normalPassword.getClear());
//        System.out.println("The MD5 hash is:" + normalPassword.getPassword());
//	}
//        private static void genhash() {
//            System.out.print("Passwort:");
//            String pw = read.next();
//            Password normalPassword = new Password(pw);
//            System.out.println("The MD5 hash is:" + normalPassword.getPassword());
//	}
//        private static String ask() {
//            System.out.println("Do you want to generate a password and than a MD5 hash? type: pw");
//            System.out.println("Do you want to generate a hash of a known password? type: md5");
//            answer = read.nextLine();
//            return answer;
//	} 
    // </editor-fold>
    private DefaultListModel<String> listModel;
    private Password normalPassword;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JList jListOut;
    private javax.swing.JRadioButton jRadioButtonGenMD5;
    private javax.swing.JRadioButton jRadioButtonGenPW;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldEnterPW;
    // End of variables declaration//GEN-END:variables
}
