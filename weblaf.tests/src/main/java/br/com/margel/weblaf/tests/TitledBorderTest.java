package br.com.margel.weblaf.tests;

import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class TitledBorderTest extends JDialog {
	
	public TitledBorderTest(Window owner) {
		super(owner);
		
		JPanel panel = new JPanel(new MigLayout());
		panel.setBorder(new TitledBorder(" Titled Border "));
		panel.add(new JLabel("Move focus here for test"), new CC().wrap());
		panel.add(new JTextField(), new CC().width("300:100%:"));
		
		setLayout(new MigLayout(new LC().fill().insetsAll("50")));
		add(panel, new CC().grow());
		
		setTitle("TitledBorder Test");
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}
	
}