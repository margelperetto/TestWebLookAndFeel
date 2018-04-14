package br.com.margel.weblaf.tests;

import java.awt.Window;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import br.com.margel.weblaf.utils.IconUtils;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class MenuBarTest extends JDialog {
	
	public MenuBarTest(Window owner) {
		super(owner);
		
		configureMenuBar();
		
		setLayout(new MigLayout(new LC().insetsAll("50")));
		add(new JLabel("Move focus here for test"), new CC().wrap());
		add(new JTextField(), new CC().width("300:100%:").wrap());
		add(new JButton("Be happy :)"), new CC().gapTop("20"));
		
		setTitle("MenuBar Test");
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}
	
	private void configureMenuBar() {
		JMenu m = new JMenu("Menu1");
		JMenuItem item1 = new JMenuItem("Item 1", KeyEvent.VK_A);
	    item1.setAccelerator(KeyStroke.getKeyStroke("control A"));
	    JMenuItem item2 = new JMenuItem("Item 2", KeyEvent.VK_B);
	    item2.setAccelerator(KeyStroke.getKeyStroke("control B"));
	    JMenuItem item3 = new JMenuItem("Item 3", KeyEvent.VK_C);
	    item3.setAccelerator(KeyStroke.getKeyStroke("control C"));
		m.add(item1);
		m.add(item2);
		m.add(item3);
		JMenu si = new JMenu("SubItem");
		si.add(new JMenuItem("Sub Item 1",IconUtils.getImageIcon("open_folder_yellow20x20.png")));
		si.add(new JMenuItem("Sub Item 2",IconUtils.getImageIcon("open_folder_dark20x20.png")));
		m.add(si);
		
		JMenu m4 = new JMenu("SubMenus2");
		m4.add(new JMenuItem("Item 1"));
		m4.add(new JMenuItem("Item 2"));
		m4.add(new JMenuItem("Item 3"));
		
		JMenu m3 = new JMenu("SubMenus");
		m3.setIcon(IconUtils.getImageIcon("open_folder_dark20x20.png"));
		m3.add(new JRadioButtonMenuItem("RadioButton"));
		m3.add(new JCheckBoxMenuItem("CheckBox"));
		m3.add(new JRadioButtonMenuItem("RadioButton",true));
		m3.add(new JCheckBoxMenuItem("CheckBox",true));
		m3.add(m4);
		
		JMenu m2 = new JMenu("Menu2");
		m2.setIcon(IconUtils.getImageIcon("plus10x10.png"));
		m2.add(new JCheckBoxMenuItem("Teste Check",IconUtils.getImageIcon("close_folder_yellow20x20.png"),true));
		m2.add(new JRadioButtonMenuItem("Teste Radio",IconUtils.getImageIcon("close_folder_yellow20x20.png"),true));
		m2.add(m3);

		JMenuBar mb = new JMenuBar();
		mb.add(m);
		mb.add(m2);
		setJMenuBar(mb);
	}
}