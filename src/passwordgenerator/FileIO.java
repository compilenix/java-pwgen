package passwordGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;

import javax.swing.JOptionPane;

/**
 * this class can do:<br/>
 * - shows a file open dialog<br/>
 * - shows a file save dialog<br/>
 * - shows a written done dialog<br/>
 * - can write a line (as String) out into a text file<br/>
 * - can append a line (as String) out into a text file<br/>
 * - can append (with a tab before) a line (as String) out into a text file<br/>
 * <p/>
 * 
 * @version 2.4.1
 * @author Kevin Weis
 */
public final class FileIO {

	/**
	 * shows a dialog of success.<br/>
	 * <p/>
	 * 
	 * @param file
	 *            (as File) the file what what have been written.
	 */
	public static void dialogWritten(File file) {
		JOptionPane.showMessageDialog(
				null, "Data has been written at " + file.getAbsolutePath(), "Finished!", 1);
	}

	/**
	 * append a string (as new line) to a linked list.<br/>
	 * <p/>
	 * 
	 * @param line
	 *            (as String) the content to write.
	 * @return returning true upon success and throwing an IllegalStateException if no space is currently available.
	 */
	public static Boolean lineWrite(String line) {
		boolean add = list.add(line);
		return add;
	}

	/**
	 * To write the linked list into a file.<br/>
	 * File will be created if not exists.<br/>
	 * File will be overwritten if exists!!!<br/>
	 * <p/>
	 * 
	 * @param file
	 *            (as File) the file to write into.
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
			JOptionPane.showMessageDialog(
					null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
		} finally {
			try {
				out.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(
						null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
			}
		}
	}

	/**
	 * append a string to a linked list but first add a space (tab).<br/>
	 * 
	 * @param text
	 *            (as String) the content to append.
	 */
	public static void lineAppandTab(String text) {
		list.addLast(list.getLast() + "    " + text);
	}

	/**
	 * append a string to a linked list.<br/>
	 * 
	 * @param text
	 *            (as String) the content to write.
	 */
	public static void lineAppand(String text) {
		list.addLast(list.getLast() + text);
	}

	/**
	 * Append the linked list to a text file.<br/>
	 * File will be created if not exists.<br/>
	 * 
	 * @param file
	 *            (as File) the file to write into.
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
			JOptionPane.showMessageDialog(
					null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
		} finally {
			try {
				out.close();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(
						null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
			}
		}
	}

	private static LinkedList<String> list = new LinkedList<String>();
}
