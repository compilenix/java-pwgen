package passwordGenerator;

import java.text.DecimalFormat;
import java.util.ArrayList;

import passwordGenerator.Password.Hash;
import passwordGenerator.windows.JFramePasswordGenerator;

/**
 * @author Kevin Weis
 * @version 2013-10-13
 * <p>
 * Handling commandline args or/and shows the GUI<br/>
 * <p>
 */
public final class Main {

	/**
	 * @param args (as String[]) see following help:
	 * <p>
	 * Usage: The first number is the count of how much passwords will be generated<br>
	 * The second number is how long each password
	 * <p>
	 * --no-gui -S Get a default password<br>
	 * --help Prints this help<br>
	 * -n Set numbers<br>
	 * -a Set all lowercase<br>
	 * -A Set all UPPERCASE<br>
	 * -s Set special chars<br>
	 * --all Get all supported Hash-Algorithms, of the password<br>
	 * --MD2 PASSWORD Get the MD2-Hash of the password<br>
	 * --MD5 PASSWORD Get the MD5-Hash of the password<br>
	 * --SHA1 PASSWORD Get the SHA1-Hash of the password<br>
	 * --SHA256 PASSWORD Get the SHA256-Hash of the password<br>
	 * --SHA384 PASSWORD Get the SHA384-Hash of the password<br>
	 * --SHA512 PASSWORD Get the SHA512-Hash of the password
	 * <p>
	 * To use multiple Charset use this: -Aans (or similar)<br>
	 * java -jar PassworGenerator.jar 3 6 -an<br>
	 * java -jar PassworGenerator.jar --sha256 PASSWORD<br>
	 */
	public static void main(String[] args) {
		boolean fistNumberSet = false;
		int pwLength = 12;
		int pwCount = 1;
		String charChoice = Password.Numbers + Password.AlphabetLOW + Password.AlphabetUP;
		String os = System.getProperty("os.name").toLowerCase();

		if (args.length != 0) {
			try {
				if (args[0].toLowerCase().equals("--help")) {
					printHelp();
					System.exit(0);
				}

				for (int i = 0; i < args.length; i++) {
					String string = args[i];

					if (string.toLowerCase().equals("--no-gui") || string.equals("-S")) {
						printDefaultPassword();

					} else if (string.startsWith("-") && (!string.startsWith("--")) && (args.length != 1)) {
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

					} else if (string.startsWith("--") && (args.length == 2)) {
						String string1 = string.toLowerCase();

						if (string1.contains("all")) {
							for (Hash alg : Password.Hash.values()) {
								System.out.println(alg.toString() + "\t" + alg.Get(args[1].getBytes()));
							}

						} else if (string1.contains("md2")) {
							System.out.println(Password.Hash.MD2.Get(args[1].getBytes()));
						} else if (string1.contains("md5")) {
							System.out.println(Password.Hash.MD5.Get(args[1].getBytes()));
						} else if (string1.contains("sha1")) {
							System.out.println(Password.Hash.SHA1.Get(args[1].getBytes()));
						} else if (string1.contains("sha256")) {
							System.out.println(Password.Hash.SHA256.Get(args[1].getBytes()));
						} else if (string1.contains("sha384")) {
							System.out.println(Password.Hash.SHA384.Get(args[1].getBytes()));
						} else if (string1.contains("sha512")) {
							System.out.println(Password.Hash.SHA512.Get(args[1].getBytes()));
						} else {
							printHelp();
							System.exit(1);
						}

					} else {
						try {
							if (fistNumberSet) {
								pwLength = Integer.parseInt(args[0]);
							} else {
								pwCount = Integer.parseInt(args[0]);
								fistNumberSet = true;
							}
						} catch (Exception ex) {
							printHelp();
							System.exit(1);
						}
					}
				}

				new Worker(charChoice.toCharArray(), pwLength, pwCount, args).run();
				System.exit(0);
			} catch (Exception ex) {
			}
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
		} else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0) {
			try {
				setLookAndFeel("GTK+");
			} catch (Exception ex) {
				try {
					setLookAndFeel("Nimbus");
				} catch (Exception ex1) {
					ex1.printStackTrace();
				}
			}
		} else {
			try {
				setLookAndFeel("Nimbus");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if (args.length == 0) {
			mainFrame = new JFramePasswordGenerator();
			mainFrame.setVisible(true);
		} else {
			printHelp();
		}
	}

	/**
	 * Author Kevin Weis<br>
	 * Version 2013-11-13<br>
	 * <p>
	 * switch to a other look and feel
	 * <p>
	 * @param style name of the look and feel
	 * @throws Exception if something went wrong, see javax.swing.UIManager.setLookAndFeel(String className)
	 */
	public static void setLookAndFeel(String style) throws Exception {
		for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			if (style.equals(info.getName())) {
				javax.swing.UIManager.setLookAndFeel(info.getClassName());
				lookAndFeel = info.getName();
				break;
			}
		}
	}
	
	/**
	 * Author Kevin Weis<br>
	 * Version 2013-11-13<br>
	 * @return The name of the current LookAndFeel
	 */
	public static String getLookAndFeel() {
		return lookAndFeel;
	}

	private static void printDefaultPassword() {
		System.out.println(new Password((Password.Numbers + Password.AlphabetLOW + Password.AlphabetUP).toCharArray(), 12));
		System.exit(0);
	}

	private static void printHelp() {
		System.out
				.print("Usage:\r\nThe first number is the count of how much passwords will be generated\r\nThe second number is how long each password\r\n\r\n--no-gui  -S         Get a default password\r\n--help               Prints this help\r\n-n                   Set numbers\r\n-a                   Set all lowercase\r\n-A                   Set all UPPERCASE\r\n-s                   Set spezial chars\r\n--MD2    PASSWORD  Get the MD2-Hash of the password\r\n--MD5    PASSWORD  Get the MD5-Hash of the password\r\n--SHA1   PASSWORD  Get the SHA1-Hash of the password\r\n--SHA256 PASSWORD  Get the SHA256-Hash of the password\r\n--SHA384 PASSWORD  Get the SHA384-Hash of the password\r\n--SHA512 PASSWORD  Get the SHA512-Hash of the password\r\n\r\nTo use multiple charsets use this: -Aans (or simular)\r\njava -jar PassworGenerator.jar 3 6 -an\r\njava -jar PassworGenerator.jar --sha256 PASSWORD\r\n");
	}

	/**
	 * contains the current version of this application (hard coded).
	 */
	public static final String version = "2.4.6";
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
	/**
	 * Decimal separator, of the current locale.
	 */
	public static String DecimalSeparator = String.valueOf((((DecimalFormat) DecimalFormat.getInstance()).getDecimalFormatSymbols())
			.getGroupingSeparator());
	protected static JFramePasswordGenerator mainFrame;
	private static String lookAndFeel = "";

	private static class Worker extends Thread {

		public Worker(char[] ch, int pwlen, int pwcnt, String[] args) {
			this.choice = ch;
			this.pwLength = pwlen;
			this.pwCount = pwcnt;
			this.algosToGen = new ArrayList<Password.Hash>();

			for (int i = 0; i < args.length; i++) {
				String string = args[i].toLowerCase();

				if (string.startsWith("--")) {
					if (string.contains("all")) {

						for (Hash alg : Password.Hash.values()) {
							algosToGen.add(alg);
						}

						break;
					} else if (string.contains("md2")) {
						algosToGen.add(Password.Hash.MD2);
					} else if (string.contains("md5")) {
						algosToGen.add(Password.Hash.MD5);
					} else if (string.contains("sha1")) {
						algosToGen.add(Password.Hash.SHA1);
					} else if (string.contains("sha256")) {
						algosToGen.add(Password.Hash.SHA256);
					} else if (string.contains("sha384")) {
						algosToGen.add(Password.Hash.SHA384);
					} else if (string.contains("sha512")) {
						algosToGen.add(Password.Hash.SHA512);
					}
				}
			}
		}

		@Override
		public void run() {
			if (algosToGen.isEmpty()) {
				for (int i = 0; i < pwCount; i++) {
					System.out.println(new Password(choice, pwLength));
				}
			} else {
				for (int i = 0; i < pwCount; i++) {
					String pw = new Password(choice, pwLength).toString();
					System.out.print(pw);

					for (Hash alg : algosToGen) {
						System.out.print("\t" + alg.toString() + "\t" + alg.Get(pw.getBytes()));
					}
					System.out.print("\n");
				}
			}
		}

		private char[] choice;
		private ArrayList<Password.Hash> algosToGen;
		private int pwLength;
		private int pwCount;
	}
}
