package passwordGenerator.windows;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import passwordGenerator.Language;
import passwordGenerator.Main;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Button;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JRadioButtonMenuItem;

/**
 * Author Kevin Weis<br>
 * Version 04.02.2013<br>
 * <p>
 * Here is the main GUI.
 * <p>
 */
public class JFrameMain extends JFrame {
	private static final long serialVersionUID = 3064390125678139335L;
	private JPanel contentPane;
	private Language currentLanguage;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnView;
	private JMenu mnHelp;
	private JMenuItem mntmExport;
	private JMenuItem mntmExit;
	private JMenu mnChangeLanguage;
	private JMenu mnWindowstyle;
	private JRadioButtonMenuItem rdbtnmntmEnglish;
	private JRadioButtonMenuItem rdbtnmntmGerman;
	private JMenuItem mntmCheckForUpdates;
	private JMenuItem mntmCommandline;
	private JMenuItem mntmChangeLog;
	private JMenuItem mntmNews;
	private JMenuItem mntmAbout;

	/**
	 * Create the frame.
	 */
	public JFrameMain() {
		currentLanguage = Main.currentLanguage;
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("res/Password.png")));
		setTitle("Password Generator V" + Main.version);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		java.awt.Dimension DefaultDimension = new java.awt.Dimension(600, 550);
		setMinimumSize(new java.awt.Dimension(525, 310));
		setBounds((screenSize.width - DefaultDimension.width) / 2, (screenSize.height - DefaultDimension.height) / 2, DefaultDimension.width,
				DefaultDimension.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.menuBar = new JMenuBar();
		setJMenuBar(this.menuBar);
		
		this.mnFile = new JMenu("File");
		this.menuBar.add(this.mnFile);
		
		this.mntmExport = new JMenuItem("Export...");
		this.mntmExport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		this.mnFile.add(this.mntmExport);
		
		this.mntmExit = new JMenuItem("Exit");
		this.mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		this.mnFile.add(this.mntmExit);
		
		this.mnView = new JMenu("View");
		this.menuBar.add(this.mnView);
		
		this.mnChangeLanguage = new JMenu("Change Language");
		this.mnView.add(this.mnChangeLanguage);
		
		this.rdbtnmntmEnglish = new JRadioButtonMenuItem("English");
		this.mnChangeLanguage.add(this.rdbtnmntmEnglish);
		
		this.rdbtnmntmGerman = new JRadioButtonMenuItem("German");
		this.mnChangeLanguage.add(this.rdbtnmntmGerman);
		
		this.mnWindowstyle = new JMenu("Window-Style");
		this.mnView.add(this.mnWindowstyle);
		
		this.mnHelp = new JMenu("Help");
		this.menuBar.add(this.mnHelp);
		
		this.mntmCheckForUpdates = new JMenuItem("Check for Updates");
		this.mnHelp.add(this.mntmCheckForUpdates);
		
		this.mntmCommandline = new JMenuItem("Commandline");
		this.mnHelp.add(this.mntmCommandline);
		
		this.mntmChangeLog = new JMenuItem("Change Log");
		this.mnHelp.add(this.mntmChangeLog);
		
		this.mntmNews = new JMenuItem("News");
		this.mnHelp.add(this.mntmNews);
		
		this.mntmAbout = new JMenuItem("About");
		this.mnHelp.add(this.mntmAbout);
		
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		GroupLayout gl_contentPane = new GroupLayout(this.contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0, 573, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0, 461, Short.MAX_VALUE));
		this.contentPane.setLayout(gl_contentPane);
	}

}
