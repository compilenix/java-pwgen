package passwordGenerator;

import javax.swing.JOptionPane;

import passwordGenerator.windows.JFramePasswordGenerator;

/**
 * Doing nothing else create a new JFramePasswordGenerator and shows the GUI<br/>
 * 
 * @version 2012-08-18
 * @author Kevin Weis
 */
public final class Main {

	/**
	 * @param args
	 *            not jet been implemented.
	 */
	public static void main(String[] args) {
		String os = System.getProperty(
				"os.name").toLowerCase();
		if (args.length != 0) {
			System.out.println("Command line arguments are not jet been implemented!");
			JOptionPane.showMessageDialog(
					null, "Command line arguments are not jet been implemented!");
		}
		if (os.indexOf("win") >= 0) {
			try {
				setLookAndFeel("Windows");
			} catch (Exception ex) {
				try {
					setLookAndFeel("Nimbus");
				} catch (Exception ex1) {
					ex1.printStackTrace();
				}
			}
			// } else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0) {
			// try {
			// setLookAndFeel("GTK+");
			// } catch (Exception ex) {
			// try {
			// setLookAndFeel("Nimbus");
			// } catch (Exception ex1) {
			// ex1.printStackTrace();
			// }
			// }
		} else {
			try {
				setLookAndFeel("Nimbus");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		JFramePasswordGenerator.setPasswordGui(new JFramePasswordGenerator());
		JFramePasswordGenerator.getPasswordGui().setVisible(
				true);
	}

	private static void setLookAndFeel(String style) throws Exception {
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			if (style.equals(info.getName())) {
				javax.swing.UIManager.setLookAndFeel(info.getClassName());
				break;
			}
		}
	}

	/**
	 * contains the version of this application.
	 */
	public static final String version = "2.4.3";
	/**
	 * contains the version of the current latest application version. IMPORTANT: to use this you must verify the version
	 */
	public static String newVersion;
	/**
	 * contains the default JFrame window title prefix
	 */
	public static final String titlePrefix = "PasswordGenerator - ";
	/**
	 * contains the default JFrame window title
	 */
	public static final String title = "PasswordGenerator";
	/**
	 * holds the current language
	 */
	public static Language currentLanguage = new Language(Language.ENGLISH);
}
