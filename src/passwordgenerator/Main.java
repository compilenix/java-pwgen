package passwordGenerator;

import javax.swing.JOptionPane;

/**
 * Doing nothing else create a new JFramePasswordGenerator and shows the GUI :)<br/>
 * 
 * @version 2.3b4
 * @author Kevin Weis
 */
public final class Main {
	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(
					null, ex.getMessage(), ex.getClass().getSimpleName(), 0);
		}
		JFramePasswordGenerator.setPasswordGui(new JFramePasswordGenerator());
		JFramePasswordGenerator.getPasswordGui().setVisible(
				true);
	}
}
