package passwordGenerator.windows;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;

import passwordGenerator.Main;

/**
 * This JFrame shows additional information to the author and the project.<br/>
 * <p/>
 * 
 * @version 2012.10.08
 * @author Kevin Weis
 */
public class JFrameAbout extends JFrame {
	private static final long serialVersionUID = -1992348801035269449L;

	/**
	 * Creates new form JFrameAbout
	 */
	public JFrameAbout() {
		setAlwaysOnTop(true);
		setTitle(Main.titlePrefix + Main.currentLanguage.WindowAboutTitle);
		setResizable(false);
		jLabel = new javax.swing.JLabel();
		jLabelAuthor = new javax.swing.JLabel();
		jLabelHomePage = new javax.swing.JLabel();
		jLabelVersion = new javax.swing.JLabel();
		jButtonOK = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				JFrameAbout.class.getResource("res/Password.png")));

		jLabel.setFont(new java.awt.Font("Tahoma", 1, 24));
		jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel.setText("PasswordGenerator");

		jLabelAuthor.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabelAuthor.setText(Main.currentLanguage.WindowAboutAuthor + ":       Kevin Weis");

		jLabelHomePage.setFont(new java.awt.Font("Tahoma", 0, 14));
		jLabelHomePage.setText("<HTML>" + Main.currentLanguage.WindowAboutHomepage + ":    <FONT color=\"#000099\"><U>http://sourceforge.net/p/java-pwgen/</U></FONT></HTML>");
		jLabelHomePage.addMouseListener(new java.awt.event.MouseListener() {
			public void mouseClicked(MouseEvent evt) {
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop().browse(
								new URI("http://sourceforge.net/projects/java-pwgen/"));
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
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

		jButtonOK.setText(Main.currentLanguage.WindowAboutOKButton);
		jButtonOK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dispose();
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(
				Alignment.LEADING).addComponent(
				this.jLabel, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE).addComponent(
				this.jLabelVersion, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE).addGroup(
				layout.createSequentialGroup().addGap(
						19).addGroup(
						layout.createParallelGroup(
								Alignment.TRAILING, false).addComponent(
								this.jLabelHomePage, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(
								this.jLabelAuthor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)).addContainerGap(
						19, Short.MAX_VALUE)).addGroup(
				Alignment.TRAILING, layout.createSequentialGroup().addGap(
						137).addComponent(
						this.jButtonOK, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(
						135)));
		layout.setVerticalGroup(layout.createParallelGroup(
				Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(
						this.jLabel).addPreferredGap(
						ComponentPlacement.RELATED).addComponent(
						this.jLabelVersion).addPreferredGap(
						ComponentPlacement.UNRELATED).addComponent(
						this.jLabelAuthor).addPreferredGap(
						ComponentPlacement.RELATED).addComponent(
						this.jLabelHomePage).addGap(
						18).addComponent(
						this.jButtonOK).addGap(
						0, 0, Short.MAX_VALUE)));
		getContentPane().setLayout(
				layout);

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(
				(screenSize.width - 375) / 2, (screenSize.height - 185) / 2, 375, 185);
		jLabelVersion.setText("Version " + Main.version);
		frameAbout = this;
	}

	/**
	 * @return returns this frame
	 */
	public static JFrame getJFrameAbout() {
		return frameAbout;
	}

	private static JFrame frameAbout;
	private javax.swing.JLabel jLabelVersion;
	private javax.swing.JLabel jLabelHomePage;
	private javax.swing.JLabel jLabelAuthor;
	private javax.swing.JLabel jLabel;
	private javax.swing.JButton jButtonOK;
}
