package passwordgenerator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Its a jFileChooser to choose a import or a export chooser frame.
 * @author Kevin Weis
 * @version 2012-05-02
 */
public class JFileChooser extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private DefaultListModel<String> list;
    private javax.swing.JFileChooser jFileChooserEX;
    private javax.swing.JFileChooser jFileChooserIM;

    /**
     * Creates new form JFileChooser (EXport)
     *
     * @param alist a list of what to write out, into the file
     */
    public JFileChooser(DefaultListModel<String> alist) {
        list = alist;
        initComponentsEX();
    }

    /**
     * Creates new form JFileChooser (IMport)
     */
    public JFileChooser() {
        initComponentsIM();
    }

    private void initComponentsEX() {
        jFileChooserEX = new javax.swing.JFileChooser();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jFileChooserEX.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        jFileChooserEX.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
        jFileChooserEX.setDialogTitle("Export");
        jFileChooserEX.setFileFilter(new FileNameExtensionFilter(".txt files", "txt"));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jFileChooserEX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jFileChooserEX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 630) / 2, (screenSize.height - 457) / 2, 630, 457);
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                javax.swing.JFileChooser theFileChooser = (javax.swing.JFileChooser) actionEvent.getSource();
                String command = actionEvent.getActionCommand();
                if (command.equals(javax.swing.JFileChooser.APPROVE_SELECTION)) {
                    try {
                        theFileChooser.getSelectedFile().createNewFile();
                        write(theFileChooser.getSelectedFile(), list);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(new JFrame("IOException!"), ex.getMessage());
                    }
                }
                if (command.equals(javax.swing.JFileChooser.CANCEL_SELECTION)) {
                    jFileChooserEX.setVisible(false);
                }
            }
        };
        jFileChooserEX.addActionListener(actionListener);
    }

    private void initComponentsIM() {
        jFileChooserIM = new javax.swing.JFileChooser();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jFileChooserIM.setDialogType(javax.swing.JFileChooser.OPEN_DIALOG);
        jFileChooserIM.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
        jFileChooserIM.setDialogTitle("Export");
        jFileChooserIM.setFileFilter(new FileNameExtensionFilter(".txt files", "txt"));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jFileChooserIM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jFileChooserIM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 630) / 2, (screenSize.height - 457) / 2, 630, 457);
        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                javax.swing.JFileChooser theFileChooser = (javax.swing.JFileChooser) actionEvent.getSource();
                String command = actionEvent.getActionCommand();
                if (command.equals(javax.swing.JFileChooser.APPROVE_SELECTION)) {
                    if (theFileChooser.getSelectedFile().exists()) {
                        read(theFileChooser.getSelectedFile());
                    }
                } if (command.equals(javax.swing.JFileChooser.CANCEL_SELECTION)) {
                    jFileChooserIM.setVisible(false);
                }
            }
        };
        jFileChooserIM.addActionListener(actionListener);
    }

    /**
     *
     * @param file the file where writing into
     * @param list the list of passwords and MD5 hashes.
     */
    private void write(File file, DefaultListModel<String> list) {
        int x = 0;
        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), Charset.defaultCharset())) {
            while (x < list.getSize()) {
                writer.write(list.getElementAt(x));
                writer.newLine();
                x++;
            }
            writer.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(new JFrame("IOException!"), ex.getMessage());
        }
    }
    
    /**
     * 
     * @param file the file where reading from
     */
    private void read(File file) {
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), Charset.defaultCharset())) {
            while (reader.readLine() != null) {
                PasswordGenerator.PasswordGui.addToList(new Password(reader.readLine()));
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(new JFrame("IOException!"), ex.getMessage());
        }
    }
}
