package passwordgenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * this class can do:<br/> - shows a file open dialog<br/> - shows a file save
 * dialog<br/> - shows a wirtten done dialog<br/> - can write a line (as String)
 * out into a textfile<br/> - can appand a line (as String) out into a
 * textfile<br/> - can appand (with a tab bevore) a line (as String) out into a
 * textfile<br/>
 * <p/>
 * @version 2.4.1
 * @author Kevin Weis
 */
public final class FileIO {

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
     * - shows a file save dialog.<br/> - create a new file if not exist<br/>
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
        JOptionPane.showMessageDialog(null, "Data has been written at " + file.getAbsolutePath(), "Finished!", 1);
    }

    /**
     * Appand a string (as new line) to a linkedlist.<br/>
     * <p/>
     * @param line (as String) the content to write.
     */
    public static void lineWrite(String line) {
        list.addLast(line);
    }

    /**
     * To write the linkedlist into a file.<br/> File will be created if not
     * exists.<br/> 
     * <p/>
     * @param file (as File) the file to write into.
     */
    public static void write(File file) {
        BufferedWriter out = null;
        try {
            if (!list.isEmpty()) {
                out = new BufferedWriter(new FileWriter(file, true));
                file.createNewFile();
                while (!list.isEmpty()) {
                    out.write(list.pollFirst());
                    out.newLine();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
        } finally {
            try {
                out.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
            }
        }
    }

    /**
     * Appand a string to a linkedlist but first add a space (tab).<br/>
     *
     * @param text (as String) the content to appand.
     */
    public static void lineAppandTab(String text) {
        list.addLast(list.getLast() + "    " + text);
    }

    /**
     * Appand a string to a linkedlist.<br/>
     *
     * @param text (as String) the content to write.
     */
    public static void lineAppand(String text) {
        list.addLast(list.getLast() + text);
    }

    /**
     * Appand the linked list to a textfile.<br/> File will be created if not
     * exists.<br/>
     *
     * @param file (as File) the file to write into.
     */
    public static void writeAppand(File file) {
        BufferedWriter out = null;
        try {
            if (!list.isEmpty()) {
                out = new BufferedWriter(new FileWriter(file, true));
                file.createNewFile();
                out.newLine();
                while (!list.isEmpty()) {
                    out.append(list.pollFirst());
                    out.newLine();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
        } finally {
            try {
                out.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
            }
        }
    }
    private static JFileChooser fc = new JFileChooser();
    private static LinkedList<String> list = new LinkedList<String>();
}
