package passwordGenerator.windows;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

import passwordGenerator.Language;
import passwordGenerator.Main;

/**
 * This JFrame shows the current change log that are downloaded from the Internet.<br/>
 * <p/>
 * 
 * @author Kevin Weis
 * @version 2013-10-08
 */
public class JFrameChangeLog extends JFrame {
	private static final long serialVersionUID = 8038568184370743981L;

	/**
	 * Create the frame and download the text content.
	 */
	public JFrameChangeLog() {
		currentLanguage = Main.currentLanguage;
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameChangeLog.class.getResource("res/Password.png")));
		setTitle(Main.titlePrefix + "Change Log");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNews = new JLabel("Change Log");
		lblNews.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNews.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblHomepage = new JLabel("<HTML>" + currentLanguage.WindowAboutHomepage
				+ ":    <FONT color=\"#000099\"><U>http://sourceforge.net/p/java-pwgen/</U></FONT></HTML>");
		lblHomepage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (Desktop.isDesktopSupported()) {
					try {
						Desktop.getDesktop().browse(new URI("http://sourceforge.net/projects/java-pwgen/"));
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		lblHomepage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomepage.setFont(new Font("Dialog", Font.PLAIN, 14));

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		jLabelStatus = new JLabel("Lable");
		jLabelStatus.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelStatus.setHorizontalAlignment(SwingConstants.CENTER);

		JScrollPane scrollPane = new JScrollPane();

		this.buttonReload = new JButton();
		this.buttonReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				workerLoad = new WorkerDownload();
				workerLoad.execute();
			}
		});
		this.buttonReload.setIcon(new ImageIcon(JFrameChangeLog.class.getResource("res/reload.png")));
		this.buttonReload.setName("buttonReload");

		this.jProgressBar = new JProgressBar();
		this.jProgressBar.setName("jProgressBar");
		this.jProgressBar.setVisible(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane
				.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNews, GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
				.addComponent(lblHomepage, GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
				.addGroup(
						gl_contentPane.createSequentialGroup().addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(this.buttonReload, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE).addGap(47)
								.addComponent(this.jLabelStatus, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE).addGap(18)
								.addComponent(this.jProgressBar, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE).addGap(0))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_contentPane
								.createSequentialGroup()
								.addComponent(lblNews, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblHomepage, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_contentPane
												.createParallelGroup(Alignment.LEADING, false)
												.addComponent(this.jProgressBar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
												.addGroup(
														gl_contentPane
																.createParallelGroup(Alignment.BASELINE, false)
																.addComponent(btnOk)
																.addComponent(this.jLabelStatus)
																.addComponent(this.buttonReload, GroupLayout.PREFERRED_SIZE, 23,
																		GroupLayout.PREFERRED_SIZE)))));

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Dialog", Font.PLAIN, 12));
		textArea.setEditable(false);
		contentPane.setLayout(gl_contentPane);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		java.awt.Dimension DefaultDimension = new java.awt.Dimension(700, 550);
		setBounds((screenSize.width - DefaultDimension.width) / 2, (screenSize.height - DefaultDimension.height) / 2, DefaultDimension.width,
				DefaultDimension.height);
		setMinimumSize(new java.awt.Dimension(250, 100));
		setPreferredSize(DefaultDimension);
		try {
			urlChangeLog = new URL("https://dl.dropbox.com/u/27159788/PasswordGenerator/change.log");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(JFramePasswordGenerator.getPasswordGui(), currentLanguage.MessageCantConnectToServer, ex.getClass()
					.getSimpleName(), 0);
			ex.printStackTrace();
		}
		workerLoad = new WorkerDownload();
		workerLoad.execute();
		frame = this;
	}

	private void load() {
		InputStream ina = null;
		buttonReload.setEnabled(false);
		textArea.setText("");
		jLabelStatus.setText("Connecting to Server...");
		try {
			jProgressBar.setIndeterminate(true);
			jProgressBar.setVisible(true);
			URLConnection con = urlChangeLog.openConnection();
			con.connect();
			int available = con.getContentLength();
			ina = con.getInputStream();
			jProgressBar.setMaximum(available);
			byte[] buffer = new byte[1];
			int bytesRead = 0;
			int downloaded = 0; // number of bytes downloaded
			jLabelStatus.setText("Downloading...");
			jProgressBar.setIndeterminate(false);
			while ((bytesRead = ina.read(buffer)) != -1) {
				textArea.append(new String(new String(buffer).getBytes("ISO-8859-1")));
				downloaded += bytesRead;
				jProgressBar.setValue(downloaded);
				buffer = new byte[1];
			}
			jLabelStatus.setText("Finnished");
			Thread.sleep(500);
		} catch (Exception ex) {
			jLabelStatus.setText(ex.getClass().getSimpleName());
			JOptionPane.showMessageDialog(JFramePasswordGenerator.getPasswordGui(), currentLanguage.MessageCantConnectToServer, ex.getClass()
					.getSimpleName(), JOptionPane.ERROR_MESSAGE);
			jLabelStatus.setText("Finnished");
		}
		try {
			Thread.sleep(1500L);
		} catch (InterruptedException e) {
		}
		// }

		jProgressBar.setVisible(false);
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
		}
		jLabelStatus.setText("");
		buttonReload.setEnabled(true);
	}

	/**
	 * @return returns this frame
	 */
	public static JFrame getJframeNews() {
		return frame;
	}

	private static JFrame frame;
	private Language currentLanguage;
	private JTextArea textArea;
	private JLabel jLabelStatus;
	private URL urlChangeLog;
	private SwingWorker<Void, Void> workerLoad;
	private JPanel contentPane;
	private JButton buttonReload;
	protected JProgressBar jProgressBar;

	private class WorkerDownload extends SwingWorker<Void, Void> {

		@Override
		public Void doInBackground() {
			load();
			return null;
		}
	}
}
