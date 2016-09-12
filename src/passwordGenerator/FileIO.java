package passwordGenerator;

import passwordGenerator.windows.JFramePasswordGenerator;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * <p>
 * this class do:<br>
 * - shows a written done dialog<br>
 * - can write a line (as String) out into a text file<br>
 * - can append a line (as String) out into a text file<br>
 * - can append (with four spaces before) a line (as String) into a text file<br>
 * </p>
 * 
 * @version 2013-11-06
 * @author Kevin Weis
 */
public final class FileIO {
	private static LinkedList<String> list = new LinkedList<String>();

	/**
	 * shows a dialog of success.<br>
	 * 
	 * @param file (as File) the file what what have been written.
	 */
	public static void dialogWritten(File file) {
		// TODO differentiate between GUI and CLI mode
		JOptionPane.showMessageDialog(JFramePasswordGenerator.GetPasswordGui(),
				Main.currentLanguage.MessageFileWritten_Part1 + file.getAbsolutePath(), Main.currentLanguage.MessageFileWritten_Part2,
                JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * append a string (as new line) to a linked list.<br>
	 * 
	 * @param line (as String) the content to write.
	 * @return returning true upon success and throwing an IllegalStateException if no space is currently available.
	 */
	public static Boolean lineWrite(String line) {
		return list.add(line);
	}

	/**
	 * append a string to a linked list but first add four spaces.<br>
	 * 
	 * @param text (as String) the content to append.
	 */
	public static void lineAppandTab(String text) {
		// TODO Check if it make sense
		list.addLast(list.getLast() + "    " + text);
	}

	/**
	 * append a string to a linked list.<br>
	 * 
	 * @param text (as String) the content to write.
	 */
	public static void lineAppand(String text) {
		// TODO Check if it make sense
		list.addLast(list.getLast() + text);
	}

	/**
	 * To write the linked list, of Passwords, into a file.<br>
	 * File will be created if not exists.<br>
	 * 
	 * @param file (as File) the file to write into.
	 * @param append (as boolean) true = append to file. false = overwrite the file.
	 * @throws IOException
	 */
	public static void write(File file, boolean append) throws IOException {
		// TODO Javadoc
		BufferedWriter out = null;

		if (!list.isEmpty()) {

			out = new BufferedWriter(new FileWriter(file, true));
			file.createNewFile();

			// Overwrite the file with the first entry
			if (!append) {
				out.write(list.pollFirst());
				out.newLine();
			}

			while (!list.isEmpty()) {
				out.append(list.pollFirst());
				out.newLine();
			}
		}

        if (out != null) {
            out.close();
        }
    }
}
