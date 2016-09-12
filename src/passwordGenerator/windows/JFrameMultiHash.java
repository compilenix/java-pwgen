package passwordGenerator.windows;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;

import passwordGenerator.Language;
import passwordGenerator.Main;
import passwordGenerator.Main.HashAlgos;
import passwordGenerator.Password;

import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.JLabel;

/**
 * Author Compilenix<br>
 * Version 2013-10-08<br>
 * <p>
 * 
 * <p>
 */
public class JFrameMultiHash extends JFrame {
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

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JFrameMultiHash() {
		currentLanguage = Main.currentLanguage;
		countsHashed = 0;
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
		this.comboBox.setModel(new DefaultComboBoxModel(HashAlgos.values()));
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
				comboBox.setSelectedIndex(5);
				txtResult.setText(currentLanguage.WindowToolsMultiHashResult);
				spinner.setValue(1);
				lblCount.setText("");
			}
		});
		this.btnClear.setText(currentLanguage.ButtonWindowToolsMultiHashClear);
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(this.txtPassword, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(this.spinner, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(this.comboBox, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
							.addComponent(this.btnClear)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(this.btnCalculate))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(this.txtResult, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(this.lblCount)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(this.txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(this.spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(this.btnCalculate)
						.addComponent(this.comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(this.btnClear))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(this.txtResult, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(this.lblCount))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		this.contentPane.setLayout(gl_contentPane);
		this.contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { this.btnCalculate, this.txtPassword, this.spinner,
				this.comboBox, this.txtResult }));

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		java.awt.Dimension DefaultDimension = new java.awt.Dimension(450, 130);
		setBounds((screenSize.width - DefaultDimension.width) / 2, (screenSize.height - DefaultDimension.height) / 2, 450, 130);
	}

	private class workerCalculate extends SwingWorker<Void, Void> {

		@Override
		public Void doInBackground() {
			String tmpTxtPassword = txtPassword.getText();
			String tmpTxtResult = txtResult.getText();
			String tmp = tmpTxtPassword;

			if (!tmpTxtResult.equals(currentLanguage.WindowToolsMultiHashResult)) {
				tmp = txtResult.getText();
			}

			try {
				for (int i = (Integer) spinner.getValue(); i > 0; i--) {
					tmp = Password.calculcateHash(tmp.getBytes(Charset.forName("UTF-8")), comboBox.getSelectedIndex());
					txtResult.setText(tmp);
					spinner.setValue(i);
					lblCount.setText(new DecimalFormat("###" + Main.DecimalSeparator + "###").format(++countsHashed));
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(JFramePasswordGenerator.getPasswordGui(), ex.getMessage(), ex.getClass().getSimpleName(), 0);
				ex.printStackTrace();
			}
			return null;
		}
	}
}
