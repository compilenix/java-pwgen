package passwordGenerator;

import passwordGenerator.windows.JFramePasswordGenerator;

/**
 * @author Kevin Weis
 * @version 09.12.2012
 * <p>
 * Handling commandline args or/and shows the GUI<br/>
 * <p>
 */
public final class Main {

	/**
	 * @param args
	 *            (as String[]) see following help:
	 *            <p>
	 *            Usage: The first number is the count of how much passwords will be generated<br>
	 *            The second number is how long each password
	 *            <p>
	 *            --no-gui -S Get a default password<br>
	 *            --help Prints this help<br>
	 *            -n Set numbers<br>
	 *            -a Set all lowercase<br>
	 *            -A Set all UPPERCASE<br>
	 *            -s Set spezial chars<br>
	 *            --MD2 PASSWORD Get the MD2-Hash of the password<br>
	 *            --MD5 PASSWORD Get the MD5-Hash of the password<br>
	 *            --SHA1 PASSWORD Get the SHA1-Hash of the password<br>
	 *            --SHA256 PASSWORD Get the SHA256-Hash of the password<br>
	 *            --SHA384 PASSWORD Get the SHA384-Hash of the password<br>
	 *            --SHA512 PASSWORD Get the SHA512-Hash of the password
	 *            <p>
	 *            To use multiple charsets use this: -Aans (or simular)<br>
	 *            java -jar PassworGenerator.jar 3 6 -an<br>
	 *            java -jar PassworGenerator.jar --sha256 PASSWORD<br>
	 */
	public static void main(String[] args) {
		boolean fistNumberSet = false;
		int pwLength = 12;
		int pwCount = 1;
		String charChoice = Password.Numbers + Password.AlphabetLOW + Password.AlphabetUP;
		// String stringPassword;
		String os = System.getProperty(
				"os.name").toLowerCase();
		if (args.length != 0) {
			try {
				if (args[0].equals("--help")) {
					printHelp();
				}
				for (int i = 0; i < args.length; i++) {
					String string = String.valueOf(args[i]);
					// if ((string.equals("--no-gui") || string.equals("-S")) & args.length == 1) {
					if (string.equals("--no-gui") || string.equals("-S")) {
						printDefaultPassword();
						// continue;
					} else if (string.startsWith("-") && (args.length != 1)) {
						charChoice = "";
						if (string.contains("n")) {
							charChoice += Password.Numbers;
						}
						if (string.contains("a")) {
							charChoice += Password.AlphabetLOW;
						}
						if (string.contains("A")) {
							charChoice += Password.AlphabetUP;
						}
						if (string.contains("s")) {
							charChoice += Password.Special;
						}
					} else if (args[0].startsWith("--") && args.length == 2) {
						String string1 = args[0];
						Password pw;
						if (string1.contains("md2") || string1.contains("MD2")) {
							pw = new Password(args[1]);
							pw.setMD2();
							System.out.println(pw.getMD2());
							System.exit(0);
						} else if (string1.contains("md5") || string1.contains("MD5")) {
							pw = new Password(args[1]);
							pw.setMD5();
							System.out.println(pw.getMD5());
							System.exit(0);
						} else if (string1.contains("sha1") || string1.contains("SHA1")) {
							pw = new Password(args[1]);
							pw.setSHA1();
							System.out.println(pw.getSHA1());
							System.exit(0);
						} else if (string1.contains("sha256") || string1.contains("SHA256")) {
							pw = new Password(args[1]);
							pw.setSHA256();
							System.out.println(pw.getSHA256());
							System.exit(0);
						} else if (string1.contains("sha384") || string1.contains("SHA384")) {
							pw = new Password(args[1]);
							pw.setSHA384();
							System.out.println(pw.getSHA384());
							System.exit(0);
						} else if (string1.contains("sha512") || string1.contains("SHA512")) {
							pw = new Password(args[1]);
							pw.setSHA512();
							System.out.println(pw.getSHA512());
							System.exit(0);
						} else {
							printHelp();
						}
					} else {
						try {
							if (fistNumberSet) {
								pwLength = Integer.parseInt(string);
							} else {
								pwCount = Integer.parseInt(string);
								fistNumberSet = true;
							}
						} catch (Exception ex) {
							printHelp();
							System.exit(0);
						}
					}
				}
				new Worker(charChoice.toCharArray(), pwLength, pwCount).run();
				System.exit(0);
			} catch (Exception ex) {
			}
			// System.out.println("Command line arguments are not jet been implemented!");
			// JOptionPane.showMessageDialog(null, "Command line arguments are not jet been implemented!");
		} else if (os.indexOf("win") >= 0) {
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
		if (args.length == 0) {
			JFramePasswordGenerator.setPasswordGui(new JFramePasswordGenerator());
			JFramePasswordGenerator.getPasswordGui().setVisible(
					true);
		} else {
			printHelp();
		}
	}

	private static void setLookAndFeel(String style) throws Exception {
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			if (style.equals(info.getName())) {
				javax.swing.UIManager.setLookAndFeel(info.getClassName());
				break;
			}
		}
	}

	private static void printDefaultPassword() {
		System.out.println(new Password((Password.Numbers + Password.AlphabetLOW + Password.AlphabetUP).toCharArray(), 12));
		System.exit(0);
	}

	private static void printHelp() {
		// System.out.println("Usage:");
		// System.out.println("The first number is the count of how much passwords will be generated");
		// System.out.println("The second number is how long each password");
		// System.out.println();
		// System.out.println("--no-gui  -S         Get a default password");
		// System.out.println("--help               Prints this help");
		// System.out.println("-n                   Set numbers");
		// System.out.println("-a                   Set all lowercase");
		// System.out.println("-A                   Set all UPPERCASE");
		// System.out.println("-s                   Set spezial chars");
		// System.out.println("--MD2    PASSWORD  Get the MD2-Hash of the password");
		// System.out.println("--MD5    PASSWORD  Get the MD5-Hash of the password");
		// System.out.println("--SHA1   PASSWORD  Get the SHA1-Hash of the password");
		// System.out.println("--SHA256 PASSWORD  Get the SHA256-Hash of the password");
		// System.out.println("--SHA384 PASSWORD  Get the SHA384-Hash of the password");
		// System.out.println("--SHA512 PASSWORD  Get the SHA512-Hash of the password");
		// System.out.println();
		// System.out.println("To use multiple charsets use this: -Aans (or simular)");
		// System.out.println("java -jar PassworGenerator.jar 3 6 -an");
		// System.out.println("java -jar PassworGenerator.jar --sha256 PASSWORD");
		System.out.print("Usage:\r\nThe first number is the count of how much passwords will be generated\r\nThe second number is how long each password\r\n\r\n--no-gui  -S         Get a default password\r\n--help               Prints this help\r\n-n                   Set numbers\r\n-a                   Set all lowercase\r\n-A                   Set all UPPERCASE\r\n-s                   Set spezial chars\r\n--MD2    PASSWORD  Get the MD2-Hash of the password\r\n--MD5    PASSWORD  Get the MD5-Hash of the password\r\n--SHA1   PASSWORD  Get the SHA1-Hash of the password\r\n--SHA256 PASSWORD  Get the SHA256-Hash of the password\r\n--SHA384 PASSWORD  Get the SHA384-Hash of the password\r\n--SHA512 PASSWORD  Get the SHA512-Hash of the password\r\n\r\nTo use multiple charsets use this: -Aans (or simular)\r\njava -jar PassworGenerator.jar 3 6 -an\r\njava -jar PassworGenerator.jar --sha256 PASSWORD\r\n");
		System.exit(1);
	}

	/**
	 * contains the current version of this application (hard coded).
	 */
	public static final String version = "2.4.5";
	/**
	 * contains the version of the current latest application version. IMPORTANT: to use this you must verify the version
	 * 
	 * @see JFramePasswordGenerator (setUpdateURL(URL url) & checkUpdate())
	 */
	public static String newVersion;
	/**
	 * contains the default JFrame window title with suffix " - "
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
	
	private static class Worker extends Thread {
		public Worker(char[] ch, int pwlen, int pwcnt) {
			this.choice = ch;
			this.pwLength = pwlen;
			this.pwCount = pwcnt;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < pwCount; i++) {
				System.out.print(new Password(choice, pwLength));
				System.out.println();
			}
		}
		private char[] choice;
		private int pwLength;
		private int pwCount;
	}
}