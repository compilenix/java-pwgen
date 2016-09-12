package passwordGenerator;

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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

/**
 * This JFrame shows the current news that are downloaded from the Internet.<br/>
 * <p/>
 * 
 * @author Kevin Weis
 * @version 2.4.2
 */
public class JFrameNews extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame and download the text content.
	 */
	public JFrameNews() {
		setAlwaysOnTop(true);
		setType(Type.UTILITY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				JFrameNews.class.getResource("res/Password.png")));
		setTitle("PasswordGenerator - News");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(
				100, 100, 600, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNews = new JLabel("NEWS");
		lblNews.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNews.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblHomepage = new JLabel("<HTML>Homepage:    <FONT color=\"#000099\"><U>http://sourceforge.net/p/java-pwgen/</U></FONT></HTML>");
		lblHomepage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
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
		});
		lblHomepage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomepage.setFont(new Font("Dialog", Font.PLAIN, 14));

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		jLabelStatus = new JLabel("STATUS");
		jLabelStatus.setFont(new Font("Dialog", Font.PLAIN, 12));
		jLabelStatus.setHorizontalAlignment(SwingConstants.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addComponent(
				lblNews, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE).addComponent(
				lblHomepage, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE).addGroup(
				gl_contentPane.createSequentialGroup().addComponent(
						btnOk, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE).addPreferredGap(
						ComponentPlacement.RELATED).addComponent(
						jLabelStatus, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)).addComponent(
				scrollPane, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_contentPane.createSequentialGroup().addComponent(
						lblNews, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addPreferredGap(
						ComponentPlacement.RELATED).addComponent(
						lblHomepage, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE).addPreferredGap(
						ComponentPlacement.RELATED).addComponent(
						scrollPane, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE).addPreferredGap(
						ComponentPlacement.RELATED).addGroup(
						gl_contentPane.createParallelGroup(
								Alignment.BASELINE).addComponent(
								btnOk).addComponent(
								jLabelStatus))));

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Dialog", Font.PLAIN, 12));
		textArea.setEditable(false);
		contentPane.setLayout(gl_contentPane);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		java.awt.Dimension DefaultDimension = new java.awt.Dimension(700, 550);// original 330px x 550px
		setBounds(
				(screenSize.width - DefaultDimension.width) / 2, (screenSize.height - DefaultDimension.height) / 2, DefaultDimension.width, DefaultDimension.height);
		setMinimumSize(new java.awt.Dimension(250, 100));
		setPreferredSize(DefaultDimension);
		try {
			newNews = new URL("https://dl.dropbox.com/u/27159788/PasswordGenerator/News.txt");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(
					null, "Could not connect or download news...", ex.getClass().getSimpleName(), 0);
			ex.printStackTrace();
		}
		worker = new WorkerDownload();
		worker.execute();
	}

	private void load() {
		InputStream ina = null;
		jLabelStatus.setText("Connecting to Server...");
		try {
			URLConnection con = newNews.openConnection();
			con.connect();
			// int available = con.getContentLength();
			ina = con.getInputStream();
			// jProgressBar.setMaximum(available);
			byte[] buffer = new byte[1];
			int bytesRead = 0;
			int downloaded = 0; // number of bytes downloaded
			jLabelStatus.setText("Downloading...");
			// jProgressBar.setIndeterminate(false);
			while ((bytesRead = ina.read(buffer)) != -1) {
				textArea.append(new String(buffer));
				downloaded += bytesRead;
				// jProgressBar.setValue(downloaded);
				buffer = new byte[1];
			}
			// jLabelStatus.setText("Finnished");
		} catch (Exception ex) {
			jLabelStatus.setText(ex.getClass().getSimpleName());
			JOptionPane.showMessageDialog(
					null, "Could not connect or download news...", ex.getClass().getSimpleName(), 0);
		}
		jLabelStatus.setText("");
	}

	private JTextArea textArea;
	private JLabel jLabelStatus;
	private URL newNews;
	private SwingWorker<Void, Void> worker;

	private class WorkerDownload extends SwingWorker<Void, Void> {

		@Override
		public Void doInBackground() {
			load();
			return null;
		}
	}
}
