package passwordGenerator.windows;

import static passwordGenerator.FileIO.dialogWritten;
import static passwordGenerator.FileIO.lineWrite;
import static passwordGenerator.FileIO.write;

import java.awt.Component;
import java.awt.Rectangle;
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
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import passwordGenerator.Language;
import passwordGenerator.Main;
import passwordGenerator.Password;

/**
 * Here are the main logic operations... and the GUI.<br/>
 * <p/>
 * 
 * @author Kevin Weis
 * @version 04.02.2013
 */
public class JFramePasswordGenerator extends JFrame {
	private static final long serialVersionUID = -5730437296736291058L;

	/**
	 * Constructor: It will create the Frame and set all to default.
	 */
	public JFramePasswordGenerator() {
		buttonGroupChars = new javax.swing.ButtonGroup();
		buttonGroupLang = new javax.swing.ButtonGroup();
		jButtonClear = new javax.swing.JButton();
		jButtonDelete = new javax.swing.JButton();
		jButtonExport = new javax.swing.JButton();
		jButtonGenerate = new javax.swing.JButton();
		jButtonImport = new javax.swing.JButton();
		jButtonSelect = new javax.swing.JButton();
		jCheckBoxaz = new javax.swing.JCheckBox();
		jCheckBoxAZ = new javax.swing.JCheckBox();
		jCheckBoxNum = new javax.swing.JCheckBox();
		jCheckBoxSpezial = new javax.swing.JCheckBox();
		jLabelHint = new javax.swing.JLabel();
		jLabelPasswordCount = new javax.swing.JLabel();
		jLabelPleaseWait = new javax.swing.JLabel();
		jLabelPWCount = new javax.swing.JLabel();
		jLabelSliderInt = new javax.swing.JLabel();
		jMenuBar = new javax.swing.JMenuBar();
		jMenuChangeLanguage = new javax.swing.JMenu();
		jMenuFile = new javax.swing.JMenu();
		jMenuFileMenuItemExit = new javax.swing.JMenuItem();
		jMenuHelp = new javax.swing.JMenu();
		jMenuItemAbout = new javax.swing.JMenuItem();
		jMenuItemCheckUpdate = new javax.swing.JMenuItem();
		jProgressBar = new javax.swing.JProgressBar();
		jRadioButtonGenOwnPW = new javax.swing.JRadioButton();
		jRadioButtonGenPW = new javax.swing.JRadioButton();
		jScrollPane = new javax.swing.JScrollPane();
		jSliderPasswordLength = new javax.swing.JSlider();
		jSpinnerCountOf = new javax.swing.JSpinner();
		jTable = new javax.swing.JTable();
		jTextFieldEnterOwnPW = new javax.swing.JTextField();

		currentLanguage = Main.currentLanguage;

		buttonGroupChars.add(jRadioButtonGenPW);
		jRadioButtonGenPW.setSelected(true);
		jRadioButtonGenPW.setText(currentLanguage.RadioButtonGeneratePassword);
		jRadioButtonGenPW.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jRadioButtonGenPW.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText(currentLanguage.HintRadioButtonGeneratePassword);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});
		jRadioButtonGenPW.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (jRadioButtonGenPW.isSelected()) {
					jTextFieldEnterOwnPW.setEnabled(false);
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
				jLabelHint.setText(currentLanguage.HintRadioButtonOwnPW);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});
		jRadioButtonGenOwnPW.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (jRadioButtonGenOwnPW.isSelected()) {
					jTextFieldEnterOwnPW.setEnabled(true);
					jCheckBoxNum.setEnabled(false);
					jCheckBoxaz.setEnabled(false);
					jCheckBoxAZ.setEnabled(false);
					jCheckBoxSpezial.setEnabled(false);
					jSliderPasswordLength.setEnabled(false);
					jLabelSliderInt.setEnabled(false);
					jSpinnerCountOf.setEnabled(false);
				}
			}
		});

		jTextFieldEnterOwnPW.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText(currentLanguage.HintTextFieldEnterOwnPW);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});
		jTextFieldEnterOwnPW.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				worker = new workerGenerate();
				worker.execute();
			}
		});

		jButtonGenerate.setText(currentLanguage.ButtonGenerate);
		jButtonGenerate.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText(currentLanguage.HintButtonGenerate);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});
		jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (jButtonGenerate.getText().equals(currentLanguage.ButtonGenerate)) {
					worker = new workerGenerate();
					worker.execute();
				} else if (jButtonGenerate.getText().equals(currentLanguage.ButtonCancel)) {
					worker.cancel(true);
					jButtonGenerate.setText(currentLanguage.ButtonGenerate);
					jLabelPleaseWait.setVisible(false);
					jButtonExport.setVisible(true);
					jButtonExport.setEnabled(true);
					jButtonDelete.setVisible(true);
					jButtonClear.setEnabled(true);
					jButtonImport.setEnabled(true);
					jProgressBar.setVisible(false);
					jButtonSelect.setVisible(true);
					jMenuFile.setVisible(true);
					jMenuView.setVisible(true);
				}
			}
		});

		jButtonClear.setText(currentLanguage.ButtonClear);
		jButtonClear.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText(currentLanguage.HintButtonClear);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});
		jButtonClear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				worker = new workerDeleteAll();
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
				jLabelHint.setText(currentLanguage.HintSlider);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});
		jSliderPasswordLength.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				jLabelSliderInt.setText(Integer.toString(jSliderPasswordLength.getValue()));
			}
		});

		jCheckBoxNum.setSelected(true);
		jCheckBoxNum.setText(currentLanguage.CheckBoxNumbers);

		jCheckBoxNum.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText(currentLanguage.HintCheckBoxNumbers);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});

		jCheckBoxaz.setSelected(true);
		jCheckBoxaz.setText("a-z");

		jCheckBoxaz.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText(currentLanguage.HintCheckBoxLowerCase);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});

		jCheckBoxAZ.setSelected(true);
		jCheckBoxAZ.setText("A-Z");
		jCheckBoxAZ.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText(currentLanguage.HintCheckBoxUpperCase);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});

		jCheckBoxSpezial.setText("Spezial");

		jCheckBoxSpezial.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText(currentLanguage.HintCheckBoxSpecial);
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

		jButtonExport.setText(currentLanguage.ButtonExport);

		jButtonExport.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText(currentLanguage.HintButtonExport);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}

			@Override
			public void mousePressed(MouseEvent evt) {
				if (Password.getCount() > 0) {
					popupMenuExport.show(evt.getComponent(), evt.getX(), evt.getY());
				}
			}
		});

		jButtonImport.setText(currentLanguage.ButtonImport);
		jButtonImport.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jLabelHint.setText(currentLanguage.HintButtonImport);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				clearHintText();
			}
		});

		jButtonImport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				fc = new JFileChooser();
				int showOpenDialog = fc.showOpenDialog(getPasswordGui());
				if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
					@SuppressWarnings("unused")
					File file = fc.getSelectedFile();
					@SuppressWarnings("unused")
					int showConfirmDialog = JOptionPane.showConfirmDialog(getPasswordGui(), currentLanguage.MessageImportGenerateHash,
							currentLanguage.MessageImportGenerateHashTitle, JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		jLabelPleaseWait.setFont(new java.awt.Font("Tahoma", 1, 18));
		jLabelPleaseWait.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabelPleaseWait.setText(currentLanguage.LabelWait);
		jLabelPleaseWait.setFocusable(false);

		jButtonDelete.setText(currentLanguage.ButtonDeleteSelected);
		jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				worker = new workerDeleteSelected();
				worker.execute();
			}
		});

		tableModel = new DefaultTableModel(new String[] { currentLanguage.TablePassword, "SHA-1", "SHA-256", "SHA-384", "SHA-512", "MD2", "MD5" }, 0) {
			private static final long serialVersionUID = 5904972289006429181L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class, String.class, String.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};

		jTable.setModel(tableModel);
		jTable.getColumnModel().getColumn(0).setPreferredWidth(150);
		jTable.setColumnSelectionAllowed(true);
		jScrollPane.setViewportView(jTable);

		jProgressBar.setFocusable(false);
		jProgressBar.setRequestFocusEnabled(false);
		jProgressBar.setStringPainted(true);

		jLabelPasswordCount.setText(currentLanguage.PasswordCounter);

		jButtonSelect.setText(currentLanguage.ButtonSelectAll);
		jButtonSelect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTable.selectAll();
			}
		});

		jMenuFile.setText(currentLanguage.MenuBarFile);

		jMenuFileMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));

		jMenuFileMenuItemExit.setText(currentLanguage.MenuBarFileExit);
		jMenuFileMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});

		jMenuFileMenuItemExport = new JMenuItem(currentLanguage.MenuBarFileExport);
		jMenuFileMenuItemExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				worker = new workerExport();
				worker.execute();
			}
		});
		jMenuFile.add(jMenuFileMenuItemExport);

		JSeparator separator = new JSeparator();
		jMenuFile.add(separator);
		jMenuFile.add(jMenuFileMenuItemExit);

		jMenuBar.add(jMenuFile);

		jMenuChangeLanguage.setText(currentLanguage.MenuBarViewChangeLanguage);

		jRadioButtonMenuItemEnglish = new JRadioButtonMenuItem(currentLanguage.MenuBarViewChangeLanguageEN);
		this.jRadioButtonMenuItemEnglish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Main.currentLanguage = new Language(Language.ENGLISH);
				currentLanguage = new Language(Language.ENGLISH);
				Language.CURRENT_LANG = Language.ENGLISH;
				new workerReloadFrame().execute();
			}
		});

		jMenuChangeLanguage.add(jRadioButtonMenuItemEnglish);
		buttonGroupLang.add(jRadioButtonMenuItemEnglish);

		jRadioButtonMenuItemGerman = new JRadioButtonMenuItem(currentLanguage.MenuBarViewChangeLanguageGER);
		this.jRadioButtonMenuItemGerman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Main.currentLanguage = new Language(Language.GERMAN);
				currentLanguage = new Language(Language.GERMAN);
				Language.CURRENT_LANG = Language.GERMAN;
				new workerReloadFrame().execute();
			}
		});
		jMenuChangeLanguage.add(jRadioButtonMenuItemGerman);
		buttonGroupLang.add(jRadioButtonMenuItemGerman);

		switch (Language.CURRENT_LANG) {
		case Language.ENGLISH:
			jRadioButtonMenuItemEnglish.setSelected(true);
			jRadioButtonMenuItemGerman.setSelected(false);
			break;
		case Language.GERMAN:
			jRadioButtonMenuItemEnglish.setSelected(false);
			jRadioButtonMenuItemGerman.setSelected(true);
			break;
		}

		this.jMenuView = new JMenu(currentLanguage.MenuBarView);
		this.jMenuBar.add(this.jMenuView);
		this.jMenuView.add(this.jMenuChangeLanguage);

		this.jMenuWindowStyle = new JMenu(currentLanguage.MenuBarViewWindowStyle);
		this.jMenuView.add(this.jMenuWindowStyle);

		for (final javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
			JMenuItem item = new JMenuItem(info.getName());
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					try {
						javax.swing.UIManager.setLookAndFeel(info.getClassName());
						new workerReloadFrame().execute();
					} catch (Exception ex) {
						// Doing nothing
					}
				}
			});
			this.jMenuWindowStyle.add(item);
		}

		jMenuHelp.setText(currentLanguage.MenuBarHelp);

		jMenuItemCheckUpdate.setText(currentLanguage.MenuBarHelpCheckUpdate);
		jMenuItemCheckUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				worker = new workerCheckUpdate();
				worker.execute();
			}
		});
		jMenuHelp.add(jMenuItemCheckUpdate);

		jMenuItemAbout.setText(currentLanguage.MenuBarHelpAbout);
		jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				new JFrameAbout().setVisible(true);
			}
		});

		mntmNews = new JMenuItem(currentLanguage.MenuBarHelpNews);
		mntmNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				new JFrameNews().setVisible(true);
			}
		});

		this.mntmCommandline = new JMenuItem(Main.currentLanguage.MenuBarHelpCommandline);
		this.mntmCommandline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				new JFrameCommandlineHelp().setVisible(true);
			}
		});
		this.mntmCommandline.setName("mntmCommandline");
		this.jMenuHelp.add(this.mntmCommandline);

		this.mntmChangeLog = new JMenuItem("Change Log");
		this.mntmChangeLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				new JFrameChangeLog().setVisible(true);
			}
		});
		this.mntmChangeLog.setName("mntmChangeLog");
		this.jMenuHelp.add(this.mntmChangeLog);
		jMenuHelp.add(mntmNews);
		jMenuHelp.add(jMenuItemAbout);

		jMenuBar.add(jMenuHelp);

		setJMenuBar(jMenuBar);

		jCheckBoxSHA1 = new JCheckBox("SHA-1");
		jCheckBoxSHA1.setSelected(true);

		jCheckBoxSHA256 = new JCheckBox("SHA-256");

		jCheckBoxSHA384 = new JCheckBox("SHA-384");

		jCheckBoxSHA512 = new JCheckBox("SHA-512");

		jCheckBoxMD2 = new JCheckBox("MD2");

		jCheckBoxMD5 = new JCheckBox("MD5");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								layout.createParallelGroup(Alignment.TRAILING)
										.addGroup(
												layout.createSequentialGroup()
														.addGroup(
																layout.createParallelGroup(Alignment.TRAILING)
																		.addGroup(
																				layout.createSequentialGroup()
																						.addComponent(jRadioButtonGenPW)
																						.addPreferredGap(ComponentPlacement.RELATED,
																								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																						.addComponent(jCheckBoxSHA512)
																						.addPreferredGap(ComponentPlacement.RELATED)
																						.addComponent(jCheckBoxSHA384)
																						.addPreferredGap(ComponentPlacement.RELATED)
																						.addComponent(jCheckBoxSHA256)
																						.addPreferredGap(ComponentPlacement.RELATED)
																						.addComponent(jCheckBoxSHA1).addGap(38))
																		.addGroup(
																				layout.createSequentialGroup()
																						.addComponent(jSliderPasswordLength,
																								GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
																						.addPreferredGap(ComponentPlacement.RELATED)
																						.addComponent(jLabelSliderInt, GroupLayout.PREFERRED_SIZE,
																								19, GroupLayout.PREFERRED_SIZE).addGap(18)
																						.addComponent(jCheckBoxMD2).addGap(6)))
														.addPreferredGap(ComponentPlacement.RELATED).addComponent(jCheckBoxMD5))
										.addGroup(
												layout.createSequentialGroup().addComponent(jCheckBoxNum).addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jCheckBoxaz).addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jCheckBoxAZ).addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jCheckBoxSpezial)
														.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
														.addComponent(jLabelPasswordCount).addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jSpinnerCountOf, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
										.addGroup(
												layout.createSequentialGroup()
														.addComponent(jLabelHint, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jLabelPWCount, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
										.addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
										.addGroup(
												layout.createSequentialGroup()
														.addComponent(jButtonImport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jLabelPleaseWait, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jProgressBar, GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jButtonSelect, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGap(6)
														.addComponent(jButtonDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jButtonExport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addGroup(
												layout.createSequentialGroup()
														.addComponent(jRadioButtonGenOwnPW)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(jTextFieldEnterOwnPW, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(
																layout.createParallelGroup(Alignment.LEADING, false)
																		.addComponent(jButtonGenerate, GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(jButtonClear, GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))).addGap(10)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								layout.createParallelGroup(Alignment.LEADING)
										.addGroup(
												layout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(jRadioButtonGenOwnPW, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(jButtonGenerate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addComponent(jTextFieldEnterOwnPW, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								layout.createParallelGroup(Alignment.BASELINE).addComponent(jRadioButtonGenPW).addComponent(jButtonClear)
										.addComponent(jCheckBoxSHA1).addComponent(jCheckBoxSHA256).addComponent(jCheckBoxSHA384)
										.addComponent(jCheckBoxSHA512))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								layout.createParallelGroup(Alignment.LEADING)
										.addGroup(
												layout.createParallelGroup(Alignment.BASELINE).addComponent(jCheckBoxMD5).addComponent(jCheckBoxMD2)
														.addComponent(jLabelSliderInt))
										.addComponent(jSliderPasswordLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(jCheckBoxNum)
										.addComponent(jCheckBoxaz)
										.addComponent(jCheckBoxAZ)
										.addComponent(jCheckBoxSpezial)
										.addComponent(jSpinnerCountOf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE).addComponent(jLabelPasswordCount))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(
								layout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(
												layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(jButtonExport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(jButtonDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addComponent(jButtonImport, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jLabelPleaseWait, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(
												layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(jProgressBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE).addComponent(jButtonSelect))).addGap(9)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabelHint).addComponent(jLabelPWCount))
						.addContainerGap()));

		popupMenuExport = new JPopupMenu();
		addPopup(jButtonExport, popupMenuExport);

		jButtonExportPopupMenuItemAsText = new JMenuItem(currentLanguage.ButtonExportPopupMenuItemAsText);
		jButtonExportPopupMenuItemAsText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				worker = new workerExport();
				worker.execute();
			}
		});
		popupMenuExport.add(jButtonExportPopupMenuItemAsText);
		popupMenujTable = new JPopupMenu();
		addPopup(jTable, popupMenujTable);

		jTable.setAutoscrolls(true);
		jTablePopupMenuItemCopy = new JMenuItem(currentLanguage.TablePopupMenuItemCopy);
		jTablePopupMenuItemCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String line = "";
				String content = "";
				int[] selected = jTable.getSelectedRows();
				for (int i = 0; i < selected.length; i++) {
					line = tableModel.getValueAt(selected[i], 0).toString();
					if (!tableModel.getValueAt(selected[i], 1).toString().isEmpty()) {
						line += "	" + "SHA-1:" + "	" + tableModel.getValueAt(selected[i], 1).toString();
					}
					if (!tableModel.getValueAt(selected[i], 2).toString().isEmpty()) {
						line += "	" + "SHA-256:" + "	" + tableModel.getValueAt(selected[i], 2).toString();
					}
					if (!tableModel.getValueAt(selected[i], 3).toString().isEmpty()) {
						line += "	" + "SHA-384:" + "	" + tableModel.getValueAt(selected[i], 3).toString();
					}
					if (!tableModel.getValueAt(selected[i], 4).toString().isEmpty()) {
						line += "	" + "SHA-512:" + "	" + tableModel.getValueAt(selected[i], 4).toString();
					}
					if (!tableModel.getValueAt(selected[i], 5).toString().isEmpty()) {
						line += "	" + "MD2:" + "	" + tableModel.getValueAt(selected[i], 5).toString();
					}
					if (!tableModel.getValueAt(selected[i], 6).toString().isEmpty()) {
						line += "	" + "MD5:" + "	" + tableModel.getValueAt(selected[i], 6).toString();
					}
					//content += line + "\n";
				}
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(content.toString()), null);
			}
		});
		popupMenujTable.add(jTablePopupMenuItemCopy);
		getContentPane().setLayout(layout);
		setIconImage(Toolkit.getDefaultToolkit().getImage(iconUrl));
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Password Generator V" + Main.version);
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		java.awt.Dimension DefaultDimension = new java.awt.Dimension(600, 550);// original 330px x 550px
		setMinimumSize(new java.awt.Dimension(525, 310));
		setPreferredSize(DefaultDimension);
		setBounds((screenSize.width - DefaultDimension.width) / 2, (screenSize.height - DefaultDimension.height) / 2, DefaultDimension.width,
				DefaultDimension.height);
		currentBounds = getBounds();
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
		clearHintText();
		jTextFieldEnterOwnPW.setEnabled(false);
		jLabelSliderInt.setText("12");
		jProgressBar.setVisible(false);
		jLabelPleaseWait.setVisible(false);
		jButtonImport.setEnabled(false);
		jButtonImport.setVisible(false);
		jSpinnerCountOf.setValue(1);
		jButtonGenerate.requestFocus();
		setUpdateURL("https://dl.dropbox.com/u/27159788/PasswordGenerator/CurrentVersion.ini");
		worker = new workerCheckUpdateSilent();
		worker.execute();
	}

	private void reloadFrame() {
		currentBounds = getBounds();
		dispose();
		PasswordGui = new JFramePasswordGenerator();
		PasswordGui.setBounds(currentBounds);
		PasswordGui.setVisible(true);
		for (int i = 0; i < Password.getCount(); i++) {
			PasswordGui.tableModel.addRow(new Object[] { tableModel.getValueAt(i, 0).toString(), tableModel.getValueAt(i, 1).toString(),
					tableModel.getValueAt(i, 2).toString(), tableModel.getValueAt(i, 3).toString(), tableModel.getValueAt(i, 4).toString(),
					tableModel.getValueAt(i, 5).toString(), tableModel.getValueAt(i, 6).toString() });
			// pause(1);
		}
		pause(75);
		PasswordGui.jSpinnerCountOf.setValue(jSpinnerCountOf.getValue());
		pause(75);
		PasswordGui.fc = fc;
		PasswordGui.refreshPWCountLabel();
		pause(75);
		PasswordGui.jCheckBoxMD2.setSelected(jCheckBoxMD2.isSelected());
		pause(75);
		PasswordGui.jCheckBoxMD5.setSelected(jCheckBoxMD5.isSelected());
		pause(75);
		PasswordGui.jCheckBoxSHA1.setSelected(jCheckBoxSHA1.isSelected());
		pause(75);
		PasswordGui.jCheckBoxSHA256.setSelected(jCheckBoxSHA256.isSelected());
		pause(75);
		PasswordGui.jCheckBoxSHA384.setSelected(jCheckBoxSHA384.isSelected());
		pause(75);
		PasswordGui.jCheckBoxSHA512.setSelected(jCheckBoxSHA512.isSelected());
		pause(75);
		PasswordGui.jSliderPasswordLength.setValue(jSliderPasswordLength.getValue());
		pause(75);
		PasswordGui.jTextFieldEnterOwnPW.setText(jTextFieldEnterOwnPW.getText());
		pause(75);
		if (jRadioButtonGenOwnPW.isSelected()) {
			PasswordGui.jRadioButtonGenOwnPW.setSelected(true);
			pause(75);
			PasswordGui.jTextFieldEnterOwnPW.setEnabled(true);
			pause(75);
			PasswordGui.jCheckBoxNum.setEnabled(false);
			pause(75);
			PasswordGui.jCheckBoxaz.setEnabled(false);
			pause(75);
			PasswordGui.jCheckBoxAZ.setEnabled(false);
			pause(75);
			PasswordGui.jCheckBoxSpezial.setEnabled(false);
			pause(75);
			PasswordGui.jSliderPasswordLength.setEnabled(false);
			pause(75);
			PasswordGui.jLabelSliderInt.setEnabled(false);
			pause(75);
			PasswordGui.jSpinnerCountOf.setEnabled(false);
			pause(75);
		} else if (jRadioButtonGenPW.isSelected()) {
			PasswordGui.jRadioButtonGenPW.setSelected(true);
			pause(75);
			PasswordGui.jTextFieldEnterOwnPW.setEnabled(false);
			pause(75);
			PasswordGui.jCheckBoxNum.setEnabled(true);
			pause(75);
			PasswordGui.jCheckBoxaz.setEnabled(true);
			pause(75);
			PasswordGui.jCheckBoxAZ.setEnabled(true);
			pause(75);
			PasswordGui.jCheckBoxSpezial.setEnabled(true);
			pause(75);
			PasswordGui.jSliderPasswordLength.setEnabled(true);
			pause(75);
			PasswordGui.jLabelSliderInt.setEnabled(true);
			pause(75);
			PasswordGui.jSpinnerCountOf.setEnabled(true);
			pause(75);
		}
		PasswordGui.jCheckBoxNum.setSelected(jCheckBoxNum.isSelected());
		pause(75);
		PasswordGui.jCheckBoxaz.setSelected(jCheckBoxaz.isSelected());
		pause(75);
		PasswordGui.jCheckBoxAZ.setSelected(jCheckBoxAZ.isSelected());
		pause(75);
		PasswordGui.jCheckBoxSpezial.setSelected(jCheckBoxSpezial.isSelected());
	}

	private void pause(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * @return returns the JFramePasswordGenerator.
	 */
	public static JFramePasswordGenerator getPasswordGui() {
		return PasswordGui;
	}

	/**
	 * @param aPasswordGui the JFramePasswordGenerator to set.
	 */
	public static void setPasswordGui(JFramePasswordGenerator aPasswordGui) {
		PasswordGui = aPasswordGui;
	}

	private void clearHintText() {
		jLabelHint.setText(" ");
	}

	private boolean isAnyHashSelected() {
		boolean sel = false;
		if (jCheckBoxMD2.isSelected()) {
			sel = true;
		} else if (jCheckBoxMD5.isSelected()) {
			sel = true;
		} else if (jCheckBoxSHA1.isSelected()) {
			sel = true;
		} else if (jCheckBoxSHA256.isSelected()) {
			sel = true;
		} else if (jCheckBoxSHA384.isSelected()) {
			sel = true;
		} else if (jCheckBoxSHA512.isSelected()) {
			sel = true;
		}
		return sel;
	}

	/**
	 * compares two versions as string.
	 * 
	 * @param versionOld the first value.<br/>
	 * @param versionNew the second value.<br/>
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

	/**
	 * This method connecting to the Internet, check if a new version of this application is available and shows the user if his version is up to date
	 * or not.<br/>
	 * if its up to date a dialog will be shown to visual the user that there is no update.<br/>
	 * if its NOT up to date a dialog will be shown, inform the user that there is new version to download and if he want to download the new version<br/>
	 * - if the user want to download, a new updater will fired (JFrameDownloadUpdate)<br/>
	 * 
	 * @throws UnknownHostException if you entered a illegal URL
	 * @throws Exception if can't read from stream
	 * @see JFrameDownloadUpdate
	 */
	public void checkForUpdate() throws UnknownHostException, Exception {
		boolean versionCompare = false;
		try {
			versionCompare = checkUpdate();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(JFramePasswordGenerator.getPasswordGui(), currentLanguage.MessageCantConnectToServer, ex.getClass()
					.getSimpleName(), 0);
		}
		if ((!versionCompare) & (Main.newVersion != null)) {
			JOptionPane.showMessageDialog(getPasswordGui(), currentLanguage.MessageUpdateUpToDate, currentLanguage.MessageUpdateUpToDateTitle,
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * This method connecting to the Internet, check if a new version of this application is available and shows the user if his version IS NOT up to
	 * date.<br/>
	 * if its up to date nothing happens.<br/>
	 * if its NOT up to date a dialog will be shown, inform the user that there is new version to download and if he want to download the new version<br/>
	 * - if the user want to download, a new updater will fired (JFrameDownloadUpdate)<br/>
	 * 
	 * @see JFrameDownloadUpdate
	 */
	public void checkForUpdateSilent() {
		try {
			checkUpdate();
		} catch (Exception ex) {
			// a error occured... so dont disturb the user
		}
	}

	private boolean checkUpdate() throws MalformedURLException, IOException {
		Main.newVersion = getLastestVersion();
		int showOptionDialog;
		boolean versionCompare = versionCompare(Main.version, Main.newVersion);
		switch (Language.CURRENT_LANG) {
		case Language.ENGLISH:
			Main.currentLanguage.MessageUpdateNeedToUpdate = "Please update your version!!!\n\nYour version is:\n" + Main.version
					+ "\nNew version is:\n" + Main.newVersion + "\n\ndo you want to download the last version?";
			currentLanguage.MessageUpdateNeedToUpdate = "Please update your version!!!\n\nYour version is:\n" + Main.version + "\nNew version is:\n"
					+ Main.newVersion + "\n\ndo you want to download the last version?";
			break;
		case Language.GERMAN:
			Main.currentLanguage.MessageUpdateNeedToUpdate = "Bitte Speichere die Neue Version dieses Programmes!!!\n\nIhre momentane Version ist:\n"
					+ Main.version + "\nDie Neue Version ist:\n" + Main.newVersion + "\n\nWollen Sie die neue Version herunterladen?";
			currentLanguage.MessageUpdateNeedToUpdate = "Bitte Speichere die Neue Version dieses Programmes!!!\n\nIhre momentane Version ist:\n"
					+ Main.version + "\nDie Neue Version ist:\n" + Main.newVersion + "\n\nWollen Sie die neue Version herunterladen?";
			break;
		}
		if (versionCompare) {
			showOptionDialog = JOptionPane.showOptionDialog(getPasswordGui(), currentLanguage.MessageUpdateNeedToUpdate,
					currentLanguage.MessageUpdateNeedToUpdateTitle, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
			if (showOptionDialog == JOptionPane.OK_OPTION) {
				JFrameDownloadUpdate updater = new JFrameDownloadUpdate();
				updater.setUpdateURL("http://sourceforge.net/projects/java-pwgen/files/" + Main.newVersion + "/PasswordGenerator.jar");
				// updater.setDefaultBufferSize(1);
				updater.setSelectedFile(new File("PasswordGenerator" + Main.newVersion + ".jar"));
				updater.setVisible(true);
			}
		}
		return versionCompare;
	}

	/**
	 * @param url (as String) the URL to the update file.
	 */
	public void setUpdateURL(String url) {
		try {
			this.updateURL = new URL(url);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(getPasswordGui(), ex.getMessage(), ex.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * @param url (as URL) the URL to the update file.
	 */
	public void setUpdateURL(URL url) {
		this.updateURL = url;
	}

	/**
	 * to see in which syntax you must write the update file...<br/>
	 * see Properties<br/>
	 * this method is looking only in that update file for a Properties named "version"!!!
	 * 
	 * @return (as String) the latest version of this application.
	 * @throws MalformedURLException if you entered a illegal URL
	 * @throws IOException if can't read from stream
	 * @see Properties
	 */
	public String getLastestVersion() throws MalformedURLException, IOException {
		Properties propertie = new Properties();
		propertie.load(new BufferedReader(new InputStreamReader(updateURL.openStream())));
		return propertie.getProperty("version");
	}

	private void refreshPWCountLabel() {
		jLabelPWCount.setText(Integer.toString(Password.getCount()));
	}

	/**
	 * will verify some input and choose what to do, depending on user input, selected boxes etc...
	 */
	private void generate() {
		chars = "";
		if (!(Password.getCount() >= 2000000)) { // 2.0 Mio.
			if (jRadioButtonGenOwnPW.isSelected()) {
				if (!jTextFieldEnterOwnPW.getText().isEmpty()) {
					Password GenOwnpw = new Password(jTextFieldEnterOwnPW.getText());
					refreshPWCountLabel();
					String SHA1 = "";
					String SHA256 = "";
					String SHA384 = "";
					String SHA512 = "";
					String MD2 = "";
					String MD5 = "";
					if (isAnyHashSelected()) {
						if (jCheckBoxSHA1.isSelected()) {
							GenOwnpw.setSHA1();
							SHA1 = GenOwnpw.getSHA1();
						}
						if (jCheckBoxSHA256.isSelected()) {
							GenOwnpw.setSHA256();
							SHA256 = GenOwnpw.getSHA256();
						}
						if (jCheckBoxSHA384.isSelected()) {
							GenOwnpw.setSHA384();
							SHA384 = GenOwnpw.getSHA384();
						}
						if (jCheckBoxSHA512.isSelected()) {
							GenOwnpw.setSHA512();
							SHA512 = GenOwnpw.getSHA512();
						}
						if (jCheckBoxMD2.isSelected()) {
							GenOwnpw.setMD2();
							MD2 = GenOwnpw.getMD2();
						}
						if (jCheckBoxMD5.isSelected()) {
							GenOwnpw.setMD5();
							MD5 = GenOwnpw.getMD5();
						}
					}// isAnyHashSelected()
					tableModel.addRow(new Object[] { GenOwnpw.getPassword(), SHA1, SHA256, SHA384, SHA512, MD2, MD5 });
				}// !jTextFieldEnterOwnPW.getText().isEmpty()
				jTextFieldEnterOwnPW.setText("");
			}// jRadioButtonGenOwnPW.isSelected()
			if (jRadioButtonGenPW.isSelected()) {
				int count = Integer.parseInt(jSpinnerCountOf.getValue().toString());
				if (count > 2000000) {
					JOptionPane.showMessageDialog(getPasswordGui(), currentLanguage.MessageToMuchPasswords,
							currentLanguage.MessageToMuchPasswordsTitle, 2);
					jSpinnerCountOf.setValue(1000000);
				} else if (count < 0) {
					JOptionPane.showMessageDialog(getPasswordGui(), currentLanguage.MessageNegativeCount, currentLanguage.MessageNegativeCountTitle,
							2);
					jSpinnerCountOf.setValue(Math.abs(count));
				} else if (count == 0) {
					JOptionPane.showMessageDialog(getPasswordGui(), currentLanguage.MessageZero, currentLanguage.MessageZeroTitle, 2);
					jSpinnerCountOf.setValue(1);
				}
				if (jCheckBoxNum.isSelected()) {
					chars += Password.Numbers;
				}
				if (jCheckBoxaz.isSelected()) {
					chars += Password.AlphabetLOW;
				}
				if (jCheckBoxAZ.isSelected()) {
					chars += Password.AlphabetUP;
				}
				if (jCheckBoxSpezial.isSelected()) {
					chars += Password.Special; // !\"#$%&'()*+,-./:;<=>?@
				}
				if (Integer.parseInt(jSpinnerCountOf.getValue().toString()) >= 1000) {
					jLabelPleaseWait.setVisible(true);
					jButtonDelete.setVisible(false);
					jButtonExport.setVisible(false);
					jButtonSelect.setVisible(false);
					jButtonClear.setEnabled(false);
					jButtonGenerate.setText(currentLanguage.ButtonCancel);
					jButtonImport.setEnabled(false);
					jProgressBar.setVisible(true);
					jProgressBar.setValue(0);
					jProgressBar.setMinimum(0);
					jProgressBar.setMaximum(count);
					jMenuFile.setVisible(false);
					jMenuView.setVisible(false);
				}
				if (!chars.isEmpty()) {
					Password Genpw;
					String SHA1 = "";
					String SHA256 = "";
					String SHA384 = "";
					String SHA512 = "";
					String MD2 = "";
					String MD5 = "";
					while (Integer.parseInt(jSpinnerCountOf.getValue().toString()) >= 1) {
						try {
							if (Password.getCount() >= 2000000) { // 2.0 Mio.
								JOptionPane.showMessageDialog(getPasswordGui(), currentLanguage.MessageToMuchOverAllPasswords,
										currentLanguage.MessageToMuchOverAllPasswordsTitle, 2);
								break;
							}
							Genpw = new Password(chars.toCharArray(), jSliderPasswordLength.getValue());
							jSpinnerCountOf.setValue(Integer.parseInt(jSpinnerCountOf.getValue().toString()) - 1);
							refreshPWCountLabel();

							if (isAnyHashSelected()) {
								if (jCheckBoxSHA1.isSelected()) {
									Genpw.setSHA1();
									SHA1 = Genpw.getSHA1();
								}
								if (jCheckBoxSHA256.isSelected()) {
									Genpw.setSHA256();
									SHA256 = Genpw.getSHA256();
								}
								if (jCheckBoxSHA384.isSelected()) {
									Genpw.setSHA384();
									SHA384 = Genpw.getSHA384();
								}
								if (jCheckBoxSHA512.isSelected()) {
									Genpw.setSHA512();
									SHA512 = Genpw.getSHA512();
								}
								if (jCheckBoxMD2.isSelected()) {
									Genpw.setMD2();
									MD2 = Genpw.getMD2();
								}
								if (jCheckBoxMD5.isSelected()) {
									Genpw.setMD5();
									MD5 = Genpw.getMD5();
								}
							}// isAnyHashSelected()
							tableModel.addRow(new Object[] { Genpw.getPassword(), SHA1, SHA256, SHA384, SHA512, MD2, MD5 });
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
			jButtonImport.setEnabled(true);
			jProgressBar.setVisible(false);
			jButtonSelect.setVisible(true);
			jMenuFile.setVisible(true);
			jMenuView.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(getPasswordGui(), currentLanguage.MessageToMuchOverAllPasswords,
					currentLanguage.MessageToMuchOverAllPasswordsTitle, JOptionPane.ERROR_MESSAGE);
		}
		jButtonGenerate.setText(currentLanguage.ButtonGenerate);
	}// generate()

	private static JFramePasswordGenerator PasswordGui;
	private URL updateURL;
	private URL iconUrl = JFramePasswordGenerator.class.getResource("res/Password.png");
	private SwingWorker<Void, Void> worker;
	private String chars = "";
	private JFileChooser fc;
	private DefaultTableModel tableModel;
	private Language currentLanguage;
	private Rectangle currentBounds;

	private JPopupMenu popupMenujTable;
	private JRadioButtonMenuItem jRadioButtonMenuItemGerman;
	private JRadioButtonMenuItem jRadioButtonMenuItemEnglish;
	private javax.swing.JTextField jTextFieldEnterOwnPW;
	private javax.swing.JTable jTable;
	private javax.swing.JSpinner jSpinnerCountOf;
	private javax.swing.JSlider jSliderPasswordLength;
	private javax.swing.JScrollPane jScrollPane;
	private javax.swing.JRadioButton jRadioButtonGenPW;
	private javax.swing.JRadioButton jRadioButtonGenOwnPW;
	private javax.swing.JProgressBar jProgressBar;
	private javax.swing.JMenuItem jMenuFileMenuItemExit;
	private javax.swing.JMenuItem jMenuItemCheckUpdate;
	private javax.swing.JMenuItem jMenuItemAbout;
	private javax.swing.JMenuBar jMenuBar;
	private javax.swing.JMenu jMenuHelp;
	private javax.swing.JMenu jMenuFile;
	private javax.swing.JMenu jMenuChangeLanguage;
	private javax.swing.JLabel jLabelSliderInt;
	private javax.swing.JLabel jLabelPWCount;
	private javax.swing.JLabel jLabelPleaseWait;
	private javax.swing.JLabel jLabelPasswordCount;
	private javax.swing.JLabel jLabelHint;
	private javax.swing.JCheckBox jCheckBoxSpezial;
	private javax.swing.JCheckBox jCheckBoxNum;
	private javax.swing.JCheckBox jCheckBoxAZ;
	private javax.swing.JCheckBox jCheckBoxaz;
	private javax.swing.JButton jButtonSelect;
	private javax.swing.JButton jButtonImport;
	private javax.swing.JButton jButtonGenerate;
	private javax.swing.JButton jButtonExport;
	private javax.swing.JButton jButtonDelete;
	private javax.swing.JButton jButtonClear;
	private javax.swing.ButtonGroup buttonGroupLang;
	private javax.swing.ButtonGroup buttonGroupChars;
	private JPopupMenu popupMenuExport;
	private JMenuItem jButtonExportPopupMenuItemAsText;
	private JMenuItem jTablePopupMenuItemCopy;
	private JMenuItem mntmNews;
	private JMenuItem jMenuFileMenuItemExport;
	private JCheckBox jCheckBoxSHA256;
	private JCheckBox jCheckBoxSHA512;
	private JCheckBox jCheckBoxSHA384;
	private JCheckBox jCheckBoxSHA1;
	private JCheckBox jCheckBoxMD2;
	private JCheckBox jCheckBoxMD5;
	private JMenu jMenuView;
	private JMenu jMenuWindowStyle;
	private JMenuItem mntmCommandline;
	private JMenuItem mntmChangeLog;

	// End of variables declaration

	private class workerDeleteAll extends SwingWorker<Void, Void> {

		@Override
		public Void doInBackground() {
			int count = Password.getCount();
			if (tableModel.getRowCount() <= 100000) {
				jButtonGenerate.setEnabled(false);
				jButtonClear.setEnabled(false);
				jButtonExport.setVisible(false);
				jButtonDelete.setVisible(false);
				jButtonSelect.setVisible(false);
				jMenuFile.setVisible(false);
				jMenuView.setVisible(false);
				// Vector<Password> pws = Password.getAllPasswords();
				// for (int i = 1; !pws.isEmpty(); i++) {
				// tableModel.removeRow(0);
				// Password.remove(i);
				// refreshPWCountLabel();
				// }
				for (int i = 0; i < count; i++) {
					tableModel.removeRow(0);
					Password.setCount(Password.getCount() - 1);
					refreshPWCountLabel();
				}
			} else if (tableModel.getRowCount() > 100000) { // 100.000
				tableModel.getDataVector().removeAllElements();
				Password.resetCount();
				refreshPWCountLabel();
			}
			jLabelPleaseWait.setVisible(false);
			jButtonExport.setVisible(true);
			jButtonDelete.setVisible(true);
			jButtonClear.setEnabled(true);
			jButtonGenerate.setEnabled(true);
			jButtonSelect.setVisible(true);
			jMenuFile.setVisible(true);
			jMenuView.setVisible(true);
			return null;
		}
	}

	private class workerExport extends SwingWorker<Void, Void> {
		int count = 0;
		File file;

		@Override
		public Void doInBackground() {
			fc = new JFileChooser();
			fc.setDragEnabled(true);
			fc.setFileFilter(new FileNameExtensionFilter("Text (.txt)", "txt"));
			fc.setSelectedFile(new File("passwords"));
			count = Password.getCount();
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
					jMenuFile.setVisible(false);
					jMenuView.setVisible(false);
				}
				int showSaveDialog = fc.showSaveDialog(rootPane);
				if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
					file = fc.getSelectedFile();
					if (!file.getPath().toLowerCase().endsWith(".txt")) {
						file = new File(file.getPath() + ".txt");
					}
					if (file != null) {
						if (file.exists()) {
							int showConfirmDialog = JOptionPane.showConfirmDialog(getPasswordGui(), currentLanguage.MessageFileExists,
									currentLanguage.MessageFileExistsTitle, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
							if (showConfirmDialog == JOptionPane.YES_OPTION) {
								file.delete();
								export();
							} else if (showConfirmDialog == JOptionPane.NO_OPTION) {
								lineWrite("");
								write(file);
								export();
							}
						} else {
							export();
						}
					}
				}
			}

			jLabelPleaseWait.setVisible(false);
			jProgressBar.setVisible(false);
			jButtonExport.setVisible(true);
			jButtonDelete.setVisible(true);
			jButtonSelect.setVisible(true);
			jMenuFile.setVisible(true);
			jMenuView.setVisible(true);
			// jButtonImport.setVisible(false);
			return null;
		}

		private void export() {
			String line;
			for (int i = 0; i < count; i++) {
				line = tableModel.getValueAt(i, 0).toString();
				if (!tableModel.getValueAt(i, 1).toString().isEmpty()) {
					line += "	" + "SHA-1:" + "	" + tableModel.getValueAt(i, 1).toString();
				}
				if (!tableModel.getValueAt(i, 2).toString().isEmpty()) {
					line += "	" + "SHA-256:" + "	" + tableModel.getValueAt(i, 2).toString();
				}
				if (!tableModel.getValueAt(i, 3).toString().isEmpty()) {
					line += "	" + "SHA-384:" + "	" + tableModel.getValueAt(i, 3).toString();
				}
				if (!tableModel.getValueAt(i, 4).toString().isEmpty()) {
					line += "	" + "SHA-512:" + "	" + tableModel.getValueAt(i, 4).toString();
				}
				if (!tableModel.getValueAt(i, 5).toString().isEmpty()) {
					line += "	" + "MD2:" + "	" + tableModel.getValueAt(i, 5).toString();
				}
				if (!tableModel.getValueAt(i, 6).toString().isEmpty()) {
					line += "	" + "MD5:" + "	" + tableModel.getValueAt(i, 6).toString();
				}
				lineWrite(line);
				jProgressBar.setValue(jProgressBar.getValue() + 1);
			}
			write(file);
			dialogWritten(file);
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
				JOptionPane.showMessageDialog(getPasswordGui(), currentLanguage.MessageCantConnectToServer, ex.getClass().getSimpleName(),
						JOptionPane.ERROR_MESSAGE);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(getPasswordGui(), ex.getMessage(), ex.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
			}
			return null;
		}
	}

	private class workerDeleteSelected extends SwingWorker<Void, Void> {

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
					jMenuFile.setVisible(false);
					jMenuView.setVisible(false);
					// for (int i = 0; i < rows.length; i++) {
					// Password.remove(tableModel.getValueAt(rows[0], 0).toString());
					// tableModel.removeRow(rows[0]);
					// refreshPWCountLabel();
					// }
					for (int i = 0; i < rows.length; i++) {
						tableModel.removeRow(rows[0]);
						Password.setCount(Password.getCount() - 1);
						refreshPWCountLabel();
					}
					jLabelPleaseWait.setVisible(false);
					jButtonExport.setVisible(true);
					jButtonDelete.setVisible(true);
					jButtonClear.setEnabled(true);
					jButtonGenerate.setEnabled(true);
					jButtonSelect.setVisible(true);
					jMenuFile.setVisible(true);
					jMenuView.setVisible(true);
				}
			}
			return null;
		}
	}

	private class workerReloadFrame extends SwingWorker<Void, Void> {

		@Override
		public Void doInBackground() {
			reloadFrame();
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
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
