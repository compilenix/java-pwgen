package passwordGenerator.windows;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;

import passwordGenerator.Language;
import passwordGenerator.Main;

/**
 * This JFrame shows additional information to the author and the project.<br/>
 * <p/>
 * 
 * @version 2012-08-18
 * @author Kevin Weis
 */
public class JFrameAbout extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1992348801035269449L;

	/**
	 * Creates new form JFrameAbout
	 */
	public JFrameAbout() {
		currentLanguage = Main.currentLanguage;
		setAlwaysOnTop(true);
		// setType(Type.NORMAL);
		setTitle(Main.titlePrefix + currentLanguage.WindowAboutTitle);
		setResizable(false);
		jLabel = new javax.swing.JLabel();
		jLabelAuthor = new javax.swing.JLabel();
		jLabelHomePage = new javax.swing.JLabel();
		jLabelVersion = new javax.swing.JLabel();
		jButtonOK = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				JFrameAbout.class.getResource("res/Password.png")));

		jLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
		jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel.setText("PasswordGenerator");

		jLabelAuthor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabelAuthor.setText(currentLanguage.WindowAboutAuthor + ":       Kevin Weis");

		jLabelHomePage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jLabelHomePage.setText("<HTML>" + currentLanguage.WindowAboutHomepage + ":    <FONT color=\"#000099\"><U>http://sourceforge.net/p/java-pwgen/</U></FONT></HTML>");
		jLabelHomePage.addMouseListener(new java.awt.event.MouseListener() {
			public void mouseClicked(MouseEvent evt) {
				open();
			}

			public void mouseEntered(MouseEvent evt) {
			}

			public void mouseExited(MouseEvent evt) {
			}

			public void mousePressed(MouseEvent evt) {
			}

			public void mouseReleased(MouseEvent evt) {
			}
		});

		jLabelVersion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jLabelVersion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelVersion.setText("Version");

		jButtonOK.setText("OK");
		jButtonOK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dispose();
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(
				Alignment.LEADING).addComponent(
				jLabel, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE).addComponent(
				jLabelVersion, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE).addGroup(
				layout.createSequentialGroup().addGap(
						19).addGroup(
						layout.createParallelGroup(
								Alignment.TRAILING, false).addComponent(
								jLabelHomePage, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(
								jLabelAuthor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)).addContainerGap(
						19, Short.MAX_VALUE)).addGroup(
				Alignment.TRAILING, layout.createSequentialGroup().addGap(
						149).addComponent(
						jButtonOK, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE).addContainerGap(
						147, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(
						jLabel).addPreferredGap(
						ComponentPlacement.RELATED).addComponent(
						jLabelVersion).addPreferredGap(
						ComponentPlacement.UNRELATED).addComponent(
						jLabelAuthor).addPreferredGap(
						ComponentPlacement.RELATED).addComponent(
						jLabelHomePage).addGap(
						18).addComponent(
						jButtonOK).addContainerGap(
						36, Short.MAX_VALUE)));
		getContentPane().setLayout(
				layout);

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(
				(screenSize.width - 379) / 2, (screenSize.height - 202) / 2, 375, 180);
		jLabelVersion.setText("Version " + Main.version);
		frameAbout = this;
	}

	private static void open() {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(
						new URI("http://sourceforge.net/projects/java-pwgen/"));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
		}
	}

	/**
	 * @return returns this frame
	 */
	public static JFrame getJFrameAbout() {
		return frameAbout;
	}

	private static JFrame frameAbout;
	private Language currentLanguage;
	private javax.swing.JLabel jLabelVersion;
	private javax.swing.JLabel jLabelHomePage;
	private javax.swing.JLabel jLabelAuthor;
	private javax.swing.JLabel jLabel;
	private javax.swing.JButton jButtonOK;
}
