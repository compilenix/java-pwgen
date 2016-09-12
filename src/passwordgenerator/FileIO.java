package passwordgenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * this class can do:<br/> 
 * - shows a file open dialog<br/> 
 * - shows a file save dialog<br/>
 * - shows a wirtten done dialog<br/>
 * - can write a line (as String) out into a textfile<br/>
 * - can appand a line (as String) out into a textfile<br/>
 * - can appand (with a tab bevore) a line (as String) out into a textfile<br/>
 * <p/>
 * @version 2.4
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
     * - shows a file save dialog.<br/>
     * - create a new file if not exist<br/>
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
     * @return returns if the next line will overwrite the file(if it exists)
     */
    public static boolean isFirstLine() {
        return firstLine;
    }

    /**
     * To write a string into a file.<br/> 
     * File will be created if not exists.<br/> 
     * File will be overwritten if exists!!!<br/>
     * <p/>
     * @param file (as File) the file to write into.
     * @param zeile (as String) the content to write.
     */
    public static void lineWrite(File file, String zeile) {
        if (!isFirstLine()) {
            BufferedWriter out = null;
            try {
                if (!zeile.isEmpty()) {
                    out = new BufferedWriter(new FileWriter(file, true));
                    file.createNewFile();
                    out.newLine();
                    out.write(zeile);
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
        if (isFirstLine()) {
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(file));
                file.createNewFile();
                writer.write(zeile);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
            } finally {
                try {
                    writer.close();
                    setFirstLine(false);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
                }
            }
        }
    }

    /**
     * @param aFirstLine (as Boolean) if true, next written line will overwrite the file(if exists).
     */
    public static void setFirstLine(boolean aFirstLine) {
        firstLine = aFirstLine;
    }

    /**
     * Appand a string to a textfile but first add a space (tab).<br/> 
     * File will be created if not exists.<br/>
     *
     * @param file (as File) the file to write into.
     * @param text (as String) the content to write.
     */
    public static void lineAppandTab(File file, String text) {
        BufferedWriter out = null;
        try {
            if (!text.isEmpty()) {
                out = new BufferedWriter(new FileWriter(file, true));
                file.createNewFile();
                out.append("    ");
                out.append(text);
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
     * Appand a string to a textfile.<br/> 
     * File will be created if not exists.<br/>
     *
     * @param file (as File) the file to write into.
     * @param text (as String) the content to write.
     */
    public static void lineAppand(File file, String text) {
        BufferedWriter out = null;
        try {
            if (!text.isEmpty()) {
                out = new BufferedWriter(new FileWriter(file, true));
                file.createNewFile();
                out.append(text);
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
    /**
     * - if true: tells the writer that the next line it will write... overwride the file
     */
    private static boolean firstLine;
}
