package passwordGenerator.windows;

import java.awt.Toolkit;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

/**
 * This JFrame download a file from the web and include a progressbar.<br/>
 * don't forget to set the URL, with "setUpdateURL"!!!<br/>
 * with the method "setSelectedFile" you are able to choose the default filename.<br/>
 * 
 * @version 2012-08-18
 * @author Kevin Weis
 */
@SuppressWarnings("serial")
public class JFrameDownloadUpdate extends javax.swing.JFrame {

	/**
	 * Creates new form JFrameDownloadUpdate
	 */
	public JFrameDownloadUpdate() {
		// setAlwaysOnTop(false);
		// setType(Type.NORMAL);
		setResizable(false);
		jLabel = new javax.swing.JLabel();
		jLabelStatus = new javax.swing.JLabel();
		jProgressBar = new javax.swing.JProgressBar();

		setTitle("Downloading in progress...");

		jLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel.setText("Downloading the new Version, have fun with it ;-)");

		jProgressBar.setFocusable(false);
		jProgressBar.setIndeterminate(true);
		jProgressBar.setStringPainted(true);

		jLabelStatus.setText("Waiting for selecting a destination...");
		jLabelStatus.setHorizontalAlignment(SwingConstants.CENTER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(
				Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addGroup(
						layout.createParallelGroup(
								Alignment.LEADING).addComponent(
								jProgressBar, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE).addComponent(
								jLabelStatus, GroupLayout.PREFERRED_SIZE, 442, GroupLayout.PREFERRED_SIZE).addComponent(
								jLabel, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(
						61, Short.MAX_VALUE).addComponent(
						jLabel).addGap(
						18).addComponent(
						jLabelStatus).addPreferredGap(
						ComponentPlacement.RELATED).addComponent(
						jProgressBar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE).addContainerGap()));
		getContentPane().setLayout(
				layout);

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(
				(screenSize.width - 468) / 2, (screenSize.height - 106) / 2, 468, 124);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				JFrameDownloadUpdate.class.getResource("res/Password.png")));
		worker = new WorkerDownload();
		worker.execute();
	}

	/**
	 * @param url
	 *            (as String) the URL, where the file is you want to download.
	 * @throws MalformedURLException
	 *             if you entered a illegal URL
	 */
	public void setUpdateURL(String url) throws MalformedURLException {
		this.url = new URL(url);
	}

	/**
	 * @param url
	 *            (as URL) the URL, where the file is you want to download.
	 * @throws MalformedURLException
	 *             if can't read from stream
	 */
	public void setUpdateURL(URL url) throws MalformedURLException {
		this.url = url;
	}

	/**
	 * set the default name of the selected file.
	 * 
	 * @param file
	 *            (as File) the file.
	 */
	public void setSelectedFile(File file) {
		this.file = file;
	}

	/**
	 * set the size of the buffer who read the content from the url.
	 * 
	 * @param size
	 *            (as int) the size.
	 */
	public void setDefaultBufferSize(int size) {
		this.DEFAULT_BUFFER_SIZE = size;
	}

	private void saveUrl() {
		JFileChooser jFileChooser = new JFileChooser();
		if (file != null) {
			jFileChooser.setSelectedFile(this.file);
		}
		if (jFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			try {
				File selectedFile = jFileChooser.getSelectedFile();
				jLabelStatus.setText("Connecting to Server...");
				URLConnection con = url.openConnection();
				con.connect();
				int available = con.getContentLength();
				InputStream ina = con.getInputStream();
				jProgressBar.setMaximum(available);
				RandomAccessFile outFile = new RandomAccessFile(selectedFile, "rw");
				byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
				int bytesRead = 0;
				int downloaded = 0; // number of bytes downloaded
				jLabelStatus.setText("Downloading...");
				jProgressBar.setIndeterminate(false);
				while ((bytesRead = ina.read(buffer)) != -1) {
					outFile.write(
							buffer, 0, bytesRead);
					downloaded += bytesRead;
					jProgressBar.setValue(downloaded);
					buffer = new byte[DEFAULT_BUFFER_SIZE];
				}
				ina.close();
				outFile.close();
				jLabelStatus.setText("Finnished");
				JOptionPane.showMessageDialog(
						JFramePasswordGenerator.getPasswordGui(), "You found it at:\n" + selectedFile.getAbsolutePath(), "Downloading finished", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(
						JFramePasswordGenerator.getPasswordGui(), ex.getMessage(), ex.getClass().getSimpleName(), 0);
			}
		}
		this.dispose();
	}

	private URL url; // download URL
	private SwingWorker<Void, Void> worker;
	private javax.swing.JProgressBar jProgressBar;
	private javax.swing.JLabel jLabelStatus;
	private javax.swing.JLabel jLabel;
	private int DEFAULT_BUFFER_SIZE = 1024;
	private File file = null;

	private class WorkerDownload extends SwingWorker<Void, Void> {

		@Override
		public Void doInBackground() {
			saveUrl();
			return null;
		}
	}
}
