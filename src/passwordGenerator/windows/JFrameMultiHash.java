package passwordGenerator.windows;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

import passwordGenerator.Language;
import passwordGenerator.Main;
import passwordGenerator.Password;
import passwordGenerator.Password.Hash;

/**
 * Author Compilenix<br>
 * Version 2013-10-13<br>
 * <p>
 * 
 * <p>
 */
public class JFrameMultiHash extends JFrame {
	private static final long serialVersionUID = -3913150838174767405L;
	private JPanel contentPane;
	private JTextField txtPassword;
	private JSpinner spinner;
	private JButton btnCalculate;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private Language currentLanguage;
	private JTextField txtResult;
	private int countsHashed;
	private JLabel lblCount;
	private JButton btnClear;
	private byte[] tmp;
	private int calculateState = 0;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JFrameMultiHash() {
		currentLanguage = Main.currentLanguage;
		countsHashed = 0;
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFrameMultiHash.class.getResource("res/Password.png")));
		setTitle(Main.titlePrefix + "Multi Hash");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);

		this.btnCalculate = new JButton();
		this.btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new workerCalculate().execute();
			}
		});
		this.btnCalculate.setText(currentLanguage.ButtonWindowToolsMultiHashCalculate);
		this.btnCalculate.requestFocus();

		this.txtPassword = new JTextField();
		this.txtPassword.setColumns(10);

		this.spinner = new JSpinner();
		this.spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));

		this.comboBox = new JComboBox();
		this.comboBox.setModel(new DefaultComboBoxModel(Password.Hash.values()));
		this.comboBox.setSelectedIndex(5);

		this.txtResult = new JTextField();
		this.txtResult.setEditable(false);
		this.txtResult.setText(currentLanguage.WindowToolsMultiHashResult);
		this.txtResult.setColumns(10);

		this.lblCount = new JLabel();

		this.btnClear = new JButton();
		this.btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countsHashed = 0;
				// comboBox.setSelectedIndex(5); //Set to MD5
				txtResult.setText(currentLanguage.WindowToolsMultiHashResult);
				// spinner.setValue(1);
				lblCount.setText("");
			}
		});
		this.btnClear.setText(currentLanguage.ButtonWindowToolsMultiHashClear);
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(
						gl_contentPane
								.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										gl_contentPane
												.createParallelGroup(Alignment.TRAILING)
												.addComponent(this.txtPassword, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
												.addGroup(
														gl_contentPane
																.createSequentialGroup()
																.addComponent(this.spinner, GroupLayout.PREFERRED_SIZE, 100,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(this.comboBox, GroupLayout.PREFERRED_SIZE, 89,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
																.addComponent(this.btnClear).addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(this.btnCalculate))
												.addGroup(
														gl_contentPane.createSequentialGroup()
																.addComponent(this.txtResult, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
																.addPreferredGap(ComponentPlacement.RELATED).addComponent(this.lblCount)))
								.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_contentPane
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(this.txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_contentPane
												.createParallelGroup(Alignment.BASELINE)
												.addComponent(this.spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(this.btnCalculate)
												.addComponent(this.comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE).addComponent(this.btnClear))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(
										gl_contentPane
												.createParallelGroup(Alignment.BASELINE)
												.addComponent(this.txtResult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE).addComponent(this.lblCount))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		this.contentPane.setLayout(gl_contentPane);

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		java.awt.Dimension DefaultDimension = new java.awt.Dimension(450, 130);
		setBounds((screenSize.width - DefaultDimension.width) / 2, (screenSize.height - DefaultDimension.height) / 2, 450, 130);
	}

	private class workerCalculate extends SwingWorker<Void, Void> {
		int i;

		@Override
		public Void doInBackground() {
			calculateState = 1;
			String tmpTxtPassword = txtPassword.getText();
			String tmpTxtResult = txtResult.getText();
			workerCalculateDisplay workerCalculateDisplay;

			if (tmpTxtResult.equals(currentLanguage.WindowToolsMultiHashResult)) {
				tmp = new byte[tmpTxtPassword.length()];
				tmp = tmpTxtPassword.getBytes();
			}

			try {
				Hash hashAlgoToUse = (Password.Hash) comboBox.getItemAt(comboBox.getSelectedIndex());
				i = (Integer) spinner.getValue();
				workerCalculateDisplay = new workerCalculateDisplay(this);
				workerCalculateDisplay.execute();

				for (; i > 0; i--) {
					tmp = hashAlgoToUse.GetBytes(tmp);
					countsHashed++;
				}

				calculateState = 2;

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(JFramePasswordGenerator.GetPasswordGui(), ex.getMessage(), ex.getClass().getSimpleName(), 0);
				ex.printStackTrace();
			}
			return null;
		}
	}

	private class workerCalculateDisplay extends SwingWorker<Void, Void> {
		private workerCalculate worker;

		public workerCalculateDisplay(workerCalculate worker) {
			this.worker = worker;
		}

		@Override
		public Void doInBackground() throws InterruptedException {
			while (calculateState != 3) {
				Thread.sleep(250L);
				
				spinner.setValue(this.worker.i);
				
				if (calculateState == 2) {
					calculateState = 3;
					spinner.setValue(1);
				}
				
				lblCount.setText(new DecimalFormat("###" + Main.DecimalSeparator + "###").format(countsHashed));
				txtResult.setText(new BigInteger(1, tmp).toString(16));
			}
			return null;
		}
	}
}
