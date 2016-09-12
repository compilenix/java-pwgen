package passwordGenerator.windows;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import passwordGenerator.Main;

/**
 * This JFrame shows the commandline syntax.<br/>
 * <p/>
 * 
 * @version 2012.09.30
 * @author Kevin Weis
 */
public class JFrameCommandlineHelp extends JFrame {
	private static final long serialVersionUID = -3016453120900824503L;
	private JPanel contentPane;
	private JTextPane txtpnUsage;
	private JButton btnOk;

	/** Create the frame. */
	public JFrameCommandlineHelp() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				JFrameAbout.class.getResource("res/Password.png")));
		setTitle(Main.titlePrefix + Main.currentLanguage.MenuBarHelpCommandline);

		this.txtpnUsage = new JTextPane();
		this.txtpnUsage.setEditable(false);
		this.txtpnUsage.setText("Usage:\r\nThe first number is the count of how much passwords will be generated\r\nThe second number is how long each password\r\n\r\n--no-gui  -S   Get a default password\r\n--help            Prints this help\r\n-n                   Set numbers\r\n-a                   Set all lowercase\r\n-A                  Set all UPPERCASE\r\n-s                   Set spezial chars\r\n--MD2      <Password>  Get the MD2-Hash of the password\r\n--MD5      <Password>  Get the MD5-Hash of the password\r\n--SHA1     <Password>  Get the SHA1-Hash of the password\r\n--SHA256 <Password>  Get the SHA256-Hash of the password\r\n--SHA384 <Password>  Get the SHA384-Hash of the password\r\n--SHA512 <Password>  Get the SHA512-Hash of the password\r\n\r\nTo use multiple charsets use this: -Aans (or simular)\r\njava -jar PassworGenerator.jar 3 6 -an\r\njava -jar PassworGenerator.jar --sha256 PASSWORD\r\n");

		this.btnOk = new JButton("OK");
		this.btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane.createSequentialGroup().addGap(
						138).addComponent(
						this.btnOk, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE).addContainerGap(
						156, Short.MAX_VALUE)).addComponent(
				this.txtpnUsage, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane.createSequentialGroup().addComponent(
						this.txtpnUsage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(
						ComponentPlacement.UNRELATED).addComponent(
						this.btnOk).addContainerGap(
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		this.contentPane.setLayout(gl_contentPane);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		java.awt.Dimension DefaultDimension = new java.awt.Dimension(380, 375);
		setBounds(
				(screenSize.width - DefaultDimension.width) / 2, (screenSize.height - DefaultDimension.height) / 2, DefaultDimension.width, DefaultDimension.height);
	}
}
