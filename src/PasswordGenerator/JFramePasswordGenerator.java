package passwordGenerator;

import static passwordGenerator.FileIO.dialogWritten;
import static passwordGenerator.FileIO.lineWrite;
import static passwordGenerator.FileIO.write;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 * Here are the main logic operations... and the GUI.<br/>
 * <p/>
 * 
 * @author Kevin Weis
 * @version 2.4.2
 */
public class JFramePasswordGenerator extends JFrame {

	/**
	 * Constructor: It will create the Frame and set all to default.
	 */
	public JFramePasswordGenerator() {
		jTextFieldEnterPW = new javax.swing.JTextField();
		jTable = new javax.swing.JTable();
		jSpinnerCountOf = new javax.swing.JSpinner();
		jSliderPasswordLength = new javax.swing.JSlider();
		jScrollPane = new javax.swing.JScrollPane();
		jRadioButtonGenPW = new javax.swing.JRadioButton();
		jRadioButtonGenOwnPW = new javax.swing.JRadioButton();
		jProgressBar = new javax.swing.JProgressBar();
		jMenuItemExit = new javax.swing.JMenuItem();
		jMenuItemCheckUpdate = new javax.swing.JMenuItem();
		jMenuItemAbout = new javax.swing.JMenuItem();
		jMenuHelp = new javax.swing.JMenu();
		jMenuFile = new javax.swing.JMenu();
		jMenuEdit = new javax.swing.JMenu();
		jMenuChangeLanguage = new javax.swing.JMenu();
		jMenuChangeLanguage.setEnabled(false);
		jMenuBar1 = new javax.swing.JMenuBar();
		jLabelSliderInt = new javax.swing.JLabel();
		jLabelPWCount = new javax.swing.JLabel();
		jLabelPleaseWait = new javax.swing.JLabel();
		jLabelPasswordCount = new javax.swing.JLabel();
		jLabelHint = new javax.swing.JLabel();
		jComboBoxAlg = new javax.swing.JComboBox<String>();
		jCheckBoxSpezial = new javax.swing.JCheckBox();
		jCheckBoxNum = new javax.swing.JCheckBox();
		jCheckBoxGenHash = new javax.swing.JCheckBox();
		jCheckBoxaz = new javax.swing.JCheckBox();
		jCheckBoxAZ = new javax.swing.JCheckBox();
		jButtonSelect = new javax.swing.JButton();
		jButtonImport = new javax.swing.JButton();
		jButtonGenerate = new javax.swing.JButton();
		jButtonExport = new javax.swing.JButton();
		jButtonDelete = new javax.swing.JButton();
		jButtonClear = new javax.swing.JButton();
		buttonGroupChars = new javax.swing.ButtonGroup();
		buttonGroupLang = new javax.swing.ButtonGroup();
		buttonGroupChars.add(jRadioButtonGenPW);
		jRadioButtonGenPW.setSelected(true);
		jRadioButtonGenPW.setText("Gen. Password");
		jRadioButtonGenPW.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jRadioButtonGenPW.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText("Generate random password(s)");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});
		jRadioButtonGenPW.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (jRadioButtonGenPW.isEnabled()) {
					jTextFieldEnterPW.setEnabled(false);
					jCheckBoxNum.setEnabled(true);
					jCheckBoxaz.setEnabled(true);
					jCheckBoxAZ.setEnabled(true);
					jCheckBoxSpezial.setEnabled(true);
					jSliderPasswordLength.setEnabled(true);
					jLabelSliderInt.setEnabled(true);
					jSpinnerCountOf.setEnabled(true);
				}
			}
		});

		buttonGroupChars.add(jRadioButtonGenOwnPW);
		jRadioButtonGenOwnPW.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText("Add the password to the list and optional a hash of it");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});
		jRadioButtonGenOwnPW.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (jRadioButtonGenOwnPW.isEnabled()) {
					jTextFieldEnterPW.setEnabled(true);
					jCheckBoxNum.setEnabled(false);
					jCheckBoxaz.setEnabled(false);
					jCheckBoxAZ.setEnabled(false);
					jCheckBoxSpezial.setEnabled(false);
					jSliderPasswordLength.setEnabled(false);
					jLabelSliderInt.setEnabled(false);
					jSpinnerCountOf.setEnabled(false);
					jCheckBoxGenHash.setSelected(true);
					jComboBoxAlg.setEnabled(true);
				}
			}
		});

		jTextFieldEnterPW.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText("Type a password");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});
		jTextFieldEnterPW.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				worker = new workerGenerate();
				worker.execute();
			}
		});

		jButtonGenerate.setText("Generate");
		jButtonGenerate.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText("Generate...");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});
		jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				worker = new workerGenerate();
				worker.execute();
			}
		});

		jButtonClear.setText("Clear");
		jButtonClear.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText("Reset table!");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});
		jButtonClear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				worker = new workerClear();
				worker.execute();
			}
		});

		jSliderPasswordLength.setMaximum(50);
		jSliderPasswordLength.setMinimum(3);
		jSliderPasswordLength.setPaintLabels(true);
		jSliderPasswordLength.setPaintTicks(true);
		jSliderPasswordLength.setSnapToTicks(true);
		jSliderPasswordLength.setValue(12);
		jSliderPasswordLength.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jSliderPasswordLength.setValueIsAdjusting(true);
		jSliderPasswordLength.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText("Set length of generated password");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});
		jSliderPasswordLength.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				jLabelSliderInt.setText(Integer.toString(jSliderPasswordLength.getValue())); // sorgt fuer die aktuallisierung der anzeige des aktuellen wertes der zeichenlaengenfestlegung
			}
		});

		jCheckBoxNum.setSelected(true);
		jCheckBoxNum.setText("Numbers");
		jCheckBoxNum.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText("Includes numbers from \"0\" to \"9\"");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});

		jCheckBoxaz.setSelected(true);
		jCheckBoxaz.setText("a-z");
		jCheckBoxaz.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText("Includes characters from \"a\" to \"z\" (lowercase)");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});

		jCheckBoxAZ.setSelected(true);
		jCheckBoxAZ.setText("A-Z");
		jCheckBoxAZ.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText("Includes characters from \"A\" to \"Z\" (uppercase)");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});

		jCheckBoxSpezial.setText("Spezial");
		jCheckBoxSpezial.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText("Includes spezial characters (!\"#$%&'()*+,-./:;<=>?@)");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});

		jLabelSliderInt.setText("0");

		jLabelPWCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		jLabelPWCount.setText("0");
		jLabelPWCount.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
		jLabelPWCount.setRequestFocusEnabled(false);

		jButtonExport.setText("Export");
		jButtonExport.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText("Export all elements from the table into a text file(UTF-8)");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}

			@Override
			public void mousePressed(MouseEvent evt) {
				popupMenuExport.show(
						evt.getComponent(), evt.getX(), evt.getY());
			}
		});

		jButtonImport.setText("Import");
		jButtonImport.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText("Import all elements from a text file (UTF-8) into the table");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});
		jButtonImport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// TODO Import...
				int showOpenDialog = fc.showOpenDialog(null);
				if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					int showConfirmDialog = JOptionPane.showConfirmDialog(
							null, "You want to generate a hash of what you import?", "Generate hash", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		jComboBoxAlg.setModel(new javax.swing.DefaultComboBoxModel<String>(new String[] { "SHA-1", "SHA-256", "SHA-384", "SHA-512", "MD2", "MD5" }));
		jComboBoxAlg.setSelectedIndex(0);
		jComboBoxAlg.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText("Choose an algorythm");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});

		jCheckBoxGenHash.setText("Gen. Hash");
		jCheckBoxGenHash.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText("Calculate a hash of the password");
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});
		jCheckBoxGenHash.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (jCheckBoxGenHash.isSelected()) {
					jComboBoxAlg.setEnabled(true);
				}
				if (!jCheckBoxGenHash.isSelected()) {
					jComboBoxAlg.setEnabled(false);
				}
			}
		});

		jLabelPleaseWait.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		jLabelPleaseWait.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelPleaseWait.setText("Please Wait!");
		jLabelPleaseWait.setFocusable(false);

		jButtonDelete.setText("Delete Selected Element");
		jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				worker = new workerDelete();
				worker.execute();
			}
		});

		jTable.setModel(tableModel = new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Password", "Hash type", "Hash" }) {
		});
		jTable.setColumnSelectionAllowed(true);
		jScrollPane.setViewportView(jTable);
		jTable.getColumnModel().getSelectionModel().setSelectionMode(
				javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		jProgressBar.setFocusable(false);
		jProgressBar.setRequestFocusEnabled(false);
		jProgressBar.setStringPainted(true);

		jLabelPasswordCount.setText("Password Count");

		jButtonSelect.setText("Select All");
		jButtonSelect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTable.selectAll();
			}
		});

		jMenuFile.setText("File");

		jMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
		jMenuItemExit.setText("Exit");
		jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});
		jMenuFile.add(jMenuItemExit);

		jMenuBar1.add(jMenuFile);

		jMenuEdit.setText("Edit");

		jMenuChangeLanguage.setText("Change Language");

		jMenuEdit.add(jMenuChangeLanguage);

		jRadioButtonMenuItemEnglish = new JRadioButtonMenuItem("English");
		jMenuChangeLanguage.add(jRadioButtonMenuItemEnglish);
		buttonGroupLang.add(jRadioButtonMenuItemEnglish);
		jRadioButtonMenuItemEnglish.setSelected(true);

		jRadioButtonMenuItemGerman = new JRadioButtonMenuItem("German");
		jMenuChangeLanguage.add(jRadioButtonMenuItemGerman);
		buttonGroupLang.add(jRadioButtonMenuItemGerman);

		jMenuBar1.add(jMenuEdit);

		jMenuHelp.setText("Help");

		jMenuItemCheckUpdate.setText("Check for updates");
		jMenuItemCheckUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				worker = new workerCheckUpdate();
				worker.execute();
			}
		});
		jMenuHelp.add(jMenuItemCheckUpdate);

		jMenuItemAbout.setText("About...");
		jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				new JFrameAbout().setVisible(true);
			}
		});

		mntmNews = new JMenuItem("News");
		mntmNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				new JFrameNews().setVisible(true);
			}
		});
		jMenuHelp.add(mntmNews);
		jMenuHelp.add(jMenuItemAbout);

		jMenuBar1.add(jMenuHelp);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(
				Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addGroup(
						layout.createParallelGroup(
								Alignment.TRAILING).addGroup(
								layout.createSequentialGroup().addGroup(
										layout.createParallelGroup(
												Alignment.LEADING).addGroup(
												layout.createSequentialGroup().addComponent(
														jRadioButtonGenOwnPW).addPreferredGap(
														ComponentPlacement.RELATED).addComponent(
														jTextFieldEnterPW, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE).addPreferredGap(
														ComponentPlacement.RELATED)).addGroup(
												layout.createSequentialGroup().addComponent(
														jSliderPasswordLength, GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE).addPreferredGap(
														ComponentPlacement.RELATED).addComponent(
														jLabelSliderInt, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)).addGroup(
												layout.createSequentialGroup().addComponent(
														jRadioButtonGenPW).addPreferredGap(
														ComponentPlacement.RELATED, 308, Short.MAX_VALUE).addComponent(
														jCheckBoxGenHash))).addGap(
										3).addGroup(
										layout.createParallelGroup(
												Alignment.LEADING).addGroup(
												layout.createSequentialGroup().addGap(
														3).addGroup(
														layout.createParallelGroup(
																Alignment.LEADING, false).addComponent(
																jButtonGenerate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(
																jButtonClear, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))).addComponent(
												jComboBoxAlg, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))).addGroup(
								layout.createSequentialGroup().addComponent(
										jCheckBoxNum).addPreferredGap(
										ComponentPlacement.RELATED).addComponent(
										jCheckBoxaz).addPreferredGap(
										ComponentPlacement.RELATED).addComponent(
										jCheckBoxAZ).addPreferredGap(
										ComponentPlacement.RELATED).addComponent(
										jCheckBoxSpezial).addPreferredGap(
										ComponentPlacement.RELATED, 167, Short.MAX_VALUE).addComponent(
										jLabelPasswordCount).addPreferredGap(
										ComponentPlacement.RELATED).addComponent(
										jSpinnerCountOf, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)).addGroup(
								layout.createSequentialGroup().addComponent(
										jLabelHint, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE).addPreferredGap(
										ComponentPlacement.RELATED).addComponent(
										jLabelPWCount, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)).addComponent(
								jScrollPane, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE).addGroup(
								layout.createSequentialGroup().addComponent(
										jButtonImport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addPreferredGap(
										ComponentPlacement.RELATED).addComponent(
										jLabelPleaseWait, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addPreferredGap(
										ComponentPlacement.RELATED).addComponent(
										jProgressBar, GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE).addPreferredGap(
										ComponentPlacement.RELATED).addComponent(
										jButtonSelect, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(
										6).addComponent(
										jButtonDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addPreferredGap(
										ComponentPlacement.RELATED).addComponent(
										jButtonExport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))).addGap(
						10)));
		layout.setVerticalGroup(layout.createParallelGroup(
				Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addGroup(
						layout.createParallelGroup(
								Alignment.LEADING).addGroup(
								layout.createParallelGroup(
										Alignment.BASELINE).addComponent(
										jTextFieldEnterPW, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(
										jButtonGenerate)).addComponent(
								jRadioButtonGenOwnPW)).addPreferredGap(
						ComponentPlacement.RELATED).addGroup(
						layout.createParallelGroup(
								Alignment.BASELINE).addComponent(
								jRadioButtonGenPW).addComponent(
								jButtonClear).addComponent(
								jCheckBoxGenHash)).addPreferredGap(
						ComponentPlacement.RELATED).addGroup(
						layout.createParallelGroup(
								Alignment.LEADING).addComponent(
								jSliderPasswordLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGroup(
								layout.createParallelGroup(
										Alignment.BASELINE).addComponent(
										jComboBoxAlg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(
										jLabelSliderInt))).addPreferredGap(
						ComponentPlacement.RELATED).addGroup(
						layout.createParallelGroup(
								Alignment.BASELINE).addComponent(
								jCheckBoxNum).addComponent(
								jCheckBoxaz).addComponent(
								jCheckBoxAZ).addComponent(
								jCheckBoxSpezial).addComponent(
								jSpinnerCountOf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(
								jLabelPasswordCount)).addPreferredGap(
						ComponentPlacement.RELATED).addComponent(
						jScrollPane, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE).addPreferredGap(
						ComponentPlacement.UNRELATED).addGroup(
						layout.createParallelGroup(
								Alignment.LEADING, false).addGroup(
								layout.createParallelGroup(
										Alignment.BASELINE).addComponent(
										jButtonExport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(
										jButtonDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addComponent(
								jButtonImport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(
								jLabelPleaseWait, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(
								layout.createParallelGroup(
										Alignment.BASELINE).addComponent(
										jProgressBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(
										jButtonSelect))).addGap(
						9).addGroup(
						layout.createParallelGroup(
								Alignment.BASELINE).addComponent(
								jLabelHint).addComponent(
								jLabelPWCount)).addContainerGap()));

		popupMenuExport = new JPopupMenu();
		addPopup(
				jButtonExport, popupMenuExport);

		jButtonExportPopupMenuItemAsText = new JMenuItem("As Text (UTF-8)");
		jButtonExportPopupMenuItemAsText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				worker = new workerExport();
				worker.execute();
			}
		});
		popupMenuExport.add(jButtonExportPopupMenuItemAsText);
		JPopupMenu popupMenujTable = new JPopupMenu();
		addPopup(
				jTable, popupMenujTable);

		jTablePopupMenuItemCopy = new JMenuItem("Copy");
		jTablePopupMenuItemCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
						new StringSelection(jTable.getValueAt(
								jTable.getSelectedRow(), jTable.getSelectedColumn()).toString()), null);
			}
		});
		popupMenujTable.add(jTablePopupMenuItemCopy);
		getContentPane().setLayout(
				layout);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				JFramePasswordGenerator.class.getResource("res/Password.png")));
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Password Generator V" + APP_VERSION);
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setMinimumSize(new java.awt.Dimension(463, 310));
		setPreferredSize(new java.awt.Dimension(330, 500));
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		java.awt.Dimension DefaultDimension = new java.awt.Dimension(550, 550);// original 330px x 550px
		setBounds(
				(screenSize.width - DefaultDimension.width) / 2, (screenSize.height - DefaultDimension.height) / 2, DefaultDimension.width, DefaultDimension.height);
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		clearHintText();
		jTextFieldEnterPW.setEnabled(false);
		jLabelSliderInt.setText("12");
		jProgressBar.setVisible(false);
		jButtonImport.setVisible(false);
		jComboBoxAlg.setEnabled(false);
		jLabelPleaseWait.setVisible(false);
		jSpinnerCountOf.setValue(1);
		jButtonGenerate.requestFocus();
		setUpdateURL("http://dl.dropbox.com/u/27159788/PasswordGenerator/CurrentVersion.ini");
		worker = new workerCheckUpdateSilent();
		worker.execute();
	}

	/**
	 * @return the PasswordGui.
	 */
	public static JFramePasswordGenerator getPasswordGui() {
		return PasswordGui;
	}

	/**
	 * @param aPasswordGui
	 *            the PasswordGui to set.
	 */
	public static void setPasswordGui(JFramePasswordGenerator aPasswordGui) {
		PasswordGui = aPasswordGui;
	}

	private void clearHintText() {
		jLabelHint.setText(" ");
	}

	/**
	 * This method connecting to the internet, check if a new version of this application is available and shows the user if his version is up to date or not.<br/>
	 * if its up to date a dialog will be shown to visual the user that there is no update.<br/>
	 * if its NOT up to date a dialog will be shown, inform the user that there is new version to downlload and if he want to download the new version<br/>
	 * - if the user want to download, a new updater will fired (JFrameDownloadUpdate)<br/>
	 * 
	 * @throws UnknownHostException
	 * @throws Exception
	 * @see JFrameDownloadUpdate
	 */
	public void checkForUpdate() throws UnknownHostException, Exception {
		boolean versionCompare = false;
		try {
			versionCompare = check();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(
					null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
		}
		if (!versionCompare) {
			JOptionPane.showMessageDialog(
					this, "Your version is up to date, no need to update...", "Check for Update...", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private boolean check() throws MalformedURLException, IOException {
		newVersion = getLastestVersion();
		int showOptionDialog;
		boolean versionCompare = versionCompare(
				APP_VERSION, newVersion);
		if (versionCompare) {
			showOptionDialog = JOptionPane.showOptionDialog(
					this, "Please update your version !!!\n\nYour version is:\n" + APP_VERSION + "\nNew version is:\n" + newVersion + "\n\ndo you want to download the last version?", "Check for update", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
			if (showOptionDialog == JOptionPane.OK_OPTION) {
				JFrameDownloadUpdate updater = new JFrameDownloadUpdate();
				updater.setUpdateURL("http://sourceforge.net/projects/java-pwgen/files/" + newVersion + "/PasswordGenerator.jar");
				// updater.setDefaultBufferSize(1);
				updater.setSelectedFile(new File("PasswordGenerator" + newVersion + ".jar"));
				updater.setVisible(true);
			}
		}
		return versionCompare;
	}

	/**
	 * This method connecting to the internet, check if a new version of this application is available and shows the user if his version IS NOT up to date.<br/>
	 * if its up to date nothing happands.<br/>
	 * if its NOT up to date a dialog will be shown, inform the user that there is new version to downlload and if he want to download the new version<br/>
	 * - if the user want to download, a new updater will fired (JFrameDownloadUpdate)<br/>
	 * 
	 * @see JFrameDownloadUpdate
	 */
	public void checkForUpdateSilent() {
		try {
			check();
		} catch (Exception ex) {
			// a error occured... so dont disturb the user
		}
	}

	/**
	 * @param url
	 *            (as String) the url to the update file.
	 * @see getLastestVersion
	 */
	public void setUpdateURL(String url) {
		try {
			this.updateURL = new URL(url);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(
					null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
		}
	}

	/**
	 * @param url
	 *            (as URL) the url to the update file.
	 * @see getLastestVersion
	 */
	public void setUpdateURL(URL url) {
		this.updateURL = url;
	}

	/**
	 * to see in wich syntax you must write the update file...<br/>
	 * see Properties<br/>
	 * this method is looking only in that update file for a Propertie named "version"!!!
	 * 
	 * @return (as String) the lastest version of this application.
	 * @throws MalformedURLException
	 * @throws IOException
	 * @see Properties
	 */
	public String getLastestVersion() throws MalformedURLException, IOException {
		Properties propertie = new Properties();
		propertie.load(new BufferedReader(new InputStreamReader(updateURL.openStream())));
		return propertie.getProperty("version");
	}

	/**
	 * compares two versions as string.
	 * 
	 * @param versionOld
	 *            the first value.<br/>
	 * @param versionNew
	 *            the second value.<br/>
	 * @return (as boolean) true if versionOld lower than versionNew.<br/>
	 */
	public static boolean versionCompare(String versionOld, String versionNew) {
		String[] splitVersionOld = versionOld.split("\\.");
		String versionString = "0.0";
		Double versionDouble = 0.0;
		if (splitVersionOld.length == 1) {
			versionDouble = Double.parseDouble(versionOld);
		} else if (splitVersionOld.length > 1) {
			versionString = splitVersionOld[0] + ".";
			for (int i = 0; i < splitVersionOld.length; i++) {
				versionString += splitVersionOld[i];
			}
			versionDouble = Double.parseDouble(versionString);
		}
		String[] splitVersionNew = versionNew.split("\\.");
		String versionNewString = "0.0";
		Double versionNewDouble = 0.0;
		if (splitVersionNew.length == 1) {
			versionNewDouble = Double.parseDouble(versionNew);
		} else if (splitVersionNew.length > 1) {
			versionNewString = splitVersionNew[0] + ".";
			for (int i = 0; i < splitVersionNew.length; i++) {
				versionNewString += splitVersionNew[i];
			}
			versionNewDouble = Double.parseDouble(versionNewString);
		}
		if (versionDouble < versionNewDouble) {
			return true;
		} else {
			return false;
		}
	}

	private void jLabelPWCountSetText() {
		jLabelPWCount.setText(Integer.toString(Password.getCount()));
	}

	/**
	 * This method clear all data of the output table.
	 */
	public void clear() {
		int count = Password.getCount();
		jButtonClear.setEnabled(false);
		jButtonGenerate.setEnabled(false);
		jButtonExport.setVisible(false);
		jButtonDelete.setVisible(false);
		jButtonSelect.setVisible(false);
		if (tableModel.getRowCount() <= 100000) {
			for (int i = 0; i < count; i++) {
				tableModel.removeRow(0);
				Password.setCount(Password.getCount() - 1);
				jLabelPWCountSetText();
			}
		}
		if (tableModel.getRowCount() > 100000) {
			tableModel.getDataVector().removeAllElements();
			jScrollPane.repaint();
		}
		jLabelPleaseWait.setVisible(false);
		jButtonExport.setVisible(true);
		jButtonDelete.setVisible(true);
		jButtonClear.setEnabled(true);
		jButtonGenerate.setEnabled(true);
		jButtonSelect.setVisible(true);
		Password.resetCount();
		jLabelPWCountSetText();
	}

	/**
	 * will verify some input and choose what to do, depending on user input, selected boxes etc...
	 */
	private void generate() {
		chars = "";
		jButtonSelect.setVisible(false);
		if (!(Password.getCount() >= 2000000)) { // 2.0 Mio.
			if (jRadioButtonGenOwnPW.isSelected()) {
				if (!jTextFieldEnterPW.getText().isEmpty()) {
					Password GenOwnpw = new Password(jTextFieldEnterPW.getText());
					if (jCheckBoxGenHash.isSelected()) {
						switch (jComboBoxAlg.getSelectedIndex()) {
						case 0:
							GenOwnpw.setSHA1();
							tableModel.addRow(new Object[] { GenOwnpw.getPassword(), "SHA-1", GenOwnpw.getSHA1() });
							jLabelPWCountSetText();
							break;
						case 1:
							GenOwnpw.setSHA256();
							tableModel.addRow(new Object[] { GenOwnpw.getPassword(), "SHA-256", GenOwnpw.getSHA256() });
							jLabelPWCountSetText();
							break;
						case 2:
							GenOwnpw.setSHA384();
							tableModel.addRow(new Object[] { GenOwnpw.getPassword(), "SHA-384", GenOwnpw.getSHA384() });
							jLabelPWCountSetText();
							break;
						case 3:
							GenOwnpw.setSHA512();
							tableModel.addRow(new Object[] { GenOwnpw.getPassword(), "SHA-512", GenOwnpw.getSHA512() });
							jLabelPWCountSetText();
							break;
						case 4:
							GenOwnpw.setMD2();
							tableModel.addRow(new Object[] { GenOwnpw.getPassword(), "MD2", GenOwnpw.getMD2() });
							jLabelPWCountSetText();
							break;
						case 5:
							GenOwnpw.setMD5();
							tableModel.addRow(new Object[] { GenOwnpw.getPassword(), "MD5", GenOwnpw.getMD5() });
							jLabelPWCountSetText();
							break;
						}
					}// jCheckBoxGenHash.isSelected()
					if (!jCheckBoxGenHash.isSelected()) {
						tableModel.addRow(new Object[] { GenOwnpw.getPassword(), "" });
						jLabelPWCountSetText();
					}
				}// Wenn TextFeldEnterPW NICHT leer und wenn Inhalt nicht schon in der Liste vorhanden.
				jTextFieldEnterPW.setText("");
			}// jRadioButtonGenOwnPW.isSelected()
			if (jRadioButtonGenPW.isSelected()) {
				int count = Integer.parseInt(jSpinnerCountOf.getValue().toString());
				if (count > 1000000) {
					JOptionPane.showMessageDialog(
							null, "Oh... you choosen too much Passwords... I set it for you back to 1.000.000", "Tooooooo much Passwords!", 2);
					jSpinnerCountOf.setValue(1000000);
				} else if (count < 0) {
					JOptionPane.showMessageDialog(
							null, "Oh... you choosen a negative count... I set it for you back to 1", "Negative count!", 2);
					jSpinnerCountOf.setValue(1);
				} else if (count == 0) {
					JOptionPane.showMessageDialog(
							null, "Oh... you choosen... zero. I set it for you back to 1", "Zero count!", 2);
					jSpinnerCountOf.setValue(1);
				}
				if (jCheckBoxNum.isSelected()) { // Wenn ChechBoxNummern aktiv
					chars += numbers;
				}
				if (jCheckBoxaz.isSelected()) {
					chars += lowAlphabet;
				}
				if (jCheckBoxAZ.isSelected()) {
					chars += upAlphabet;
				}
				if (jCheckBoxSpezial.isSelected()) {
					chars += special; // die Zeichen !\"#$%&'()*+,-./:;<=>?@
				}
				if (Integer.parseInt(jSpinnerCountOf.getValue().toString()) >= 1000) {
					jLabelPleaseWait.setVisible(true);
					jButtonExport.setVisible(false);
					jButtonDelete.setVisible(false);
					jButtonClear.setEnabled(false);
					jButtonGenerate.setEnabled(false);
					jButtonImport.setEnabled(false);
					jProgressBar.setVisible(true);
					jProgressBar.setValue(0);
					jProgressBar.setMinimum(0);
					jProgressBar.setMaximum(count);
				}
				if (!chars.isEmpty()) {
					while (Integer.parseInt(jSpinnerCountOf.getValue().toString()) >= 1) {
						try {
							if (Password.getCount() >= 2000000) { // 2.0 Mio.
								JOptionPane.showMessageDialog(
										null, "Oh... too much Passwords.\nWould you add much more passwords the JAVA VM could be realy Laggy!", "Too much...", 2);
								break;
							}
							Password Genpw = new Password(chars.toCharArray(), jSliderPasswordLength.getValue());
							// zaelt die anzahl zu generierenden passwoerter um einen runter.
							jSpinnerCountOf.setValue((Integer.parseInt(jSpinnerCountOf.getValue().toString())) - 1);
							if (jCheckBoxGenHash.isSelected()) {
								switch (jComboBoxAlg.getSelectedIndex()) {
								case 0:
									Genpw.setSHA1();
									tableModel.addRow(new Object[] { Genpw.getPassword(), "SHA-1", Genpw.getSHA1() });
									jLabelPWCountSetText();
									break;
								case 1:
									Genpw.setSHA256();
									tableModel.addRow(new Object[] { Genpw.getPassword(), "SHA-256", Genpw.getSHA256() });
									jLabelPWCountSetText();
									break;
								case 2:
									Genpw.setSHA384();
									tableModel.addRow(new Object[] { Genpw.getPassword(), "SHA-384", Genpw.getSHA384() });
									jLabelPWCountSetText();
									break;
								case 3:
									Genpw.setSHA512();
									tableModel.addRow(new Object[] { Genpw.getPassword(), "SHA-512", Genpw.getSHA512() });
									jLabelPWCountSetText();
									break;
								case 4:
									Genpw.setMD2();
									tableModel.addRow(new Object[] { Genpw.getPassword(), "MD2", Genpw.getMD2() });
									jLabelPWCountSetText();
									break;
								case 5:
									Genpw.setMD5();
									tableModel.addRow(new Object[] { Genpw.getPassword(), "MD5", Genpw.getMD5() });
									jLabelPWCountSetText();
									break;
								}// jCheckBoxGenHash.isSelected()
							} else if (!jCheckBoxGenHash.isSelected()) {
								tableModel.addRow(new Object[] { Genpw.getPassword(), "" });
								jLabelPWCountSetText();
							}
							// Thread.sleep(
							// 0, 0);
						} // try
						catch (Exception ex) { // doing nothing...
						}
						jProgressBar.setValue(jProgressBar.getValue() + 1);
					}// While
				}// !chars.isEmpty()
				jSpinnerCountOf.setValue(1);
				jButtonGenerate.requestFocus();
			}// jRadioButtonGenPW.isSelected()
			jLabelPleaseWait.setVisible(false);
			jButtonExport.setVisible(true);
			jButtonDelete.setVisible(true);
			jButtonClear.setEnabled(true);
			jButtonGenerate.setEnabled(true);
			jButtonImport.setEnabled(true);
			jProgressBar.setVisible(false);
			jButtonSelect.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(
					null, "Oh... too much Passwords.\nWould you add much more passwords the JAVA VM could be realy Laggy!", "Too much...", 2);
		}
	}// generate()

	private static JFramePasswordGenerator PasswordGui;
	/**
	 * contains the version of this application.
	 */
	public static final String APP_VERSION = "2.4";
	/**
	 * contains the version of the current latest application version. IMPORTANT: to use this you must verify the version
	 */
	public static String newVersion;
	protected URL updateURL = null;
	protected URL iconUrl = JFramePasswordGenerator.class.getResource("res/Password.png");
	protected SwingWorker<Void, Void> worker;
	protected String upAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	protected String special = "!\"#$%&'()*+,-./:;<=>?@";
	protected String numbers = "0123456789";
	protected String lowAlphabet = "abcdefghijklmnopqrstuvwxyz";
	protected String chars = "";
	protected JFileChooser fc = new JFileChooser();
	protected javax.swing.JComboBox<String> jComboBoxAlg;
	protected DefaultTableModel tableModel;

	protected JRadioButtonMenuItem jRadioButtonMenuItemGerman;
	protected JRadioButtonMenuItem jRadioButtonMenuItemEnglish;
	protected javax.swing.JTextField jTextFieldEnterPW;
	protected javax.swing.JTable jTable;
	protected javax.swing.JSpinner jSpinnerCountOf;
	protected javax.swing.JSlider jSliderPasswordLength;
	protected javax.swing.JScrollPane jScrollPane;
	protected javax.swing.JRadioButton jRadioButtonGenPW;
	protected javax.swing.JRadioButton jRadioButtonGenOwnPW;
	protected javax.swing.JProgressBar jProgressBar;
	protected javax.swing.JMenuItem jMenuItemExit;
	protected javax.swing.JMenuItem jMenuItemCheckUpdate;
	protected javax.swing.JMenuItem jMenuItemAbout;
	protected javax.swing.JMenuBar jMenuBar1;
	protected javax.swing.JMenu jMenuHelp;
	protected javax.swing.JMenu jMenuFile;
	protected javax.swing.JMenu jMenuEdit;
	protected javax.swing.JMenu jMenuChangeLanguage;
	protected javax.swing.JLabel jLabelSliderInt;
	protected javax.swing.JLabel jLabelPWCount;
	protected javax.swing.JLabel jLabelPleaseWait;
	protected javax.swing.JLabel jLabelPasswordCount;
	protected javax.swing.JLabel jLabelHint;
	protected javax.swing.JCheckBox jCheckBoxSpezial;
	protected javax.swing.JCheckBox jCheckBoxNum;
	protected javax.swing.JCheckBox jCheckBoxGenHash;
	protected javax.swing.JCheckBox jCheckBoxAZ;
	protected javax.swing.JCheckBox jCheckBoxaz;
	protected javax.swing.JButton jButtonSelect;
	protected javax.swing.JButton jButtonImport;
	protected javax.swing.JButton jButtonGenerate;
	protected javax.swing.JButton jButtonExport;
	protected javax.swing.JButton jButtonDelete;
	protected javax.swing.JButton jButtonClear;
	protected javax.swing.ButtonGroup buttonGroupLang;
	protected javax.swing.ButtonGroup buttonGroupChars;
	protected JPopupMenu popupMenuExport;
	protected JMenuItem jButtonExportPopupMenuItemAsText;
	protected JMenuItem jTablePopupMenuItemCopy;
	private JMenuItem mntmNews;

	// End of variables declaration

	private class workerClear extends SwingWorker<Void, Void> {

		@Override
		public Void doInBackground() {
			clear();
			return null;
		}
	}

	private class workerExport extends SwingWorker<Void, Void> {

		@Override
		public Void doInBackground() {
			int count = Password.getCount();
			if (count != 0) {
				if (count > 5000) {
					jLabelPleaseWait.setVisible(true);
					jButtonExport.setVisible(false);
					jButtonImport.setVisible(false);
					jButtonDelete.setVisible(false);
					jButtonSelect.setVisible(false);
					jProgressBar.setVisible(true);
					jProgressBar.setValue(0);
					jProgressBar.setMinimum(0);
					jProgressBar.setMaximum(count);
				}
				int showSaveDialog = fc.showSaveDialog(null);
				if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					if (file != null) {
						String line;
						if (file.exists()) {
							int showConfirmDialog = JOptionPane.showConfirmDialog(
									null, "The file already exists... you want to overwrite it?\nchoosing no, appand it.", "Save", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
							if (showConfirmDialog == JOptionPane.YES_OPTION) {
								file.delete();
							} else if (showConfirmDialog == JOptionPane.NO_OPTION) {
								lineWrite("");
								write(file);
							}
						}
						for (int i = 0; i < count; i++) {
							line = tableModel.getValueAt(
									i, 0).toString();
							if (!tableModel.getValueAt(
									i, 1).toString().isEmpty()) {
								line += "	" + tableModel.getValueAt(
										i, 1).toString() + "	" + tableModel.getValueAt(
										i, 2).toString();
							}
							lineWrite(line);
							jProgressBar.setValue(jProgressBar.getValue() + 1);
						}
						write(file);
						dialogWritten(file);
					}
				}
				jLabelPleaseWait.setVisible(false);
				jProgressBar.setVisible(false);
				jButtonExport.setVisible(true);
				jButtonDelete.setVisible(true);
				jButtonSelect.setVisible(true);
				// jButtonImport.setVisible(false);
			}
			return null;
		}
	}

	private class workerGenerate extends SwingWorker<Void, Void> {

		@Override
		public Void doInBackground() {
			generate();
			return null;
		}
	}

	private class workerCheckUpdateSilent extends SwingWorker<Void, Void> {

		@Override
		public Void doInBackground() {
			try {
				checkForUpdateSilent();
			} catch (Exception ex) {
			}
			return null;
		}
	}

	private class workerCheckUpdate extends SwingWorker<Void, Void> {

		@Override
		public Void doInBackground() {
			try {
				checkForUpdate();
				return null;
			} catch (UnknownHostException ex) {
				JOptionPane.showMessageDialog(
						null, "Can not connect to server, please verify your internet connection!", ex.getClass().getSimpleName(), 0);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(
						null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
			}
			return null;
		}
	}

	class workerDelete extends SwingWorker<Void, Void> {

		@Override
		public Void doInBackground() {
			if (Password.getCount() >= 1) {
				int[] rows = jTable.getSelectedRows();
				if (!(rows.length <= 0)) {
					jButtonClear.setEnabled(false);
					jButtonGenerate.setEnabled(false);
					jButtonExport.setVisible(false);
					jButtonSelect.setVisible(false);
					jButtonDelete.setVisible(false);
					for (int i = 0; i < rows.length; i++) {
						tableModel.removeRow(rows[0]);
						Password.setCount(Password.getCount() - 1);
						jLabelPWCountSetText();
					}
					jLabelPleaseWait.setVisible(false);
					jButtonExport.setVisible(true);
					jButtonDelete.setVisible(true);
					jButtonClear.setEnabled(true);
					jButtonGenerate.setEnabled(true);
					jButtonSelect.setVisible(true);
				}
			}
			return null;
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(
						e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
