package passwordgenerator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * this class can do:<br/> - shows a file open dialog<br/> - shows a file save
 * and save as dialog<br/> - write into a textfile<br/> - create a new emtx file
 * if not exist<br/> - shows a wirtten done dialog<br/> - can write the values
 * of a defaultlistmodel out into a textfile<br/> - can read from a textfile
 * into a defaultlistmodel.<br/>
 * <p/>
 * @version 2.3b4
 * @author Kevin Weis
 */
public final class FileIO {

    private static JFileChooser fc = new JFileChooser();
    /**
     * - if true: tells the writer that the next line it will write... overwride
     * the file
     */
    public static boolean firstLine = true;

    /**
     * shows a file open dialog.<br/>
     * <p/>
     * @return (as File) the selected file.
     */
    public static File dialogOpen() {
        fc.showOpenDialog(null);
        return fc.getSelectedFile();
    }

    /**
     * shows a file save and save as dialog.<br/>
     * <p/>
     * @return (as File) the selected file.
     */
    public static File dialogSave() {
        fc.showSaveDialog(null);
        return fc.getSelectedFile();
    }

    /**
     * shows a dialog of success.<br/>
     * <p/>
     * @param file (as File) the file what what have been written.
     */
    public static void dialogWritten(File file) {
        JOptionPane.showMessageDialog(null, "Data has been written into " + file.getName() + "at" + file.getAbsolutePath(), "Finished!", 1);
    }

    /**
     * to write a string into a file. File will be created if not exists.<br/>
     * <p/>
     * @param file (as File) the file to write into.
     * @param zeile (as String) the content to write.
     */
    private static void WriteLine(File file, String zeile) {
        if (!firstLine) {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(file, true))) {
                if (!zeile.isEmpty()) {
                    file.createNewFile();
                    out.write(zeile);
                    out.newLine();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
            }
        }
        if (firstLine) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                file.createNewFile();
                writer.write(zeile);
                writer.newLine();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
            } finally {
                firstLine = false;
            }
        }
    }

    /**
     * to read a file into a DefaultListModel(String).
     * <p/>
     * @param file the file to read from.
     * @return returns (as List(ArrayList)) the content.
     * @deprecated not jet been tested !!!
     */
    @SuppressWarnings("unchecked")
    public static DefaultListModel<String> ReadDefaultListModel(File file) {
        String zeile;
        DefaultListModel list = new DefaultListModel<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            while (!(zeile = in.readLine()).isEmpty()) {
                list.addElement(zeile);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
        } catch (NullPointerException ex) {
            /*
             * hier nix machen... wurde ja auch nichts ausgewählt.
             */
        }
        return list;
    }

    /**
     * ask via filechooser where to write into and write the data.<br/>
     * <p/>
     * @param listModel (as DefaultListModel(String)) each line in this list
     * will be written.
     */
    public static void writeDefaultListModel(DefaultListModel<String> listModel) {
        writeDefaultListModel(listModel, dialogSave());
    }

    /**
     * @param listModel the DefaultListModel to write.
     * @param file the file to write into (will be created if not already
     * exists.
     */
    public static void writeDefaultListModel(DefaultListModel<String> listModel, File file) {
        if (file != null) {
            for (int i = 0; i < listModel.getSize(); i++) {
                WriteLine(file, listModel.getElementAt(i));
            }
        }
    }
}
