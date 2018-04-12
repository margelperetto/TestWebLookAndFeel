package br.com.margel.weblaf.tests;

import java.awt.Color;
import java.awt.Window;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class RadioCheckTest extends JDialog {
	
	public RadioCheckTest(Window owner) {
		super(owner);
		
		JCheckBox ckb0 = new JCheckBox("check test 0");
		JCheckBox ckb1 = new JCheckBox("check test 1");
		JCheckBox ckb2 = new JCheckBox("check test 2");
		JCheckBox ckb3 = new JCheckBox("check test 3");
		JCheckBox ckb4 = new JCheckBox("check test 4");
		
		JRadioButton rb0 = new JRadioButton("check test 0");
		JRadioButton rb1 = new JRadioButton("check test 1");
		JRadioButton rb2 = new JRadioButton("check test 2");
		JRadioButton rb3 = new JRadioButton("check test 3");
		JRadioButton rb4 = new JRadioButton("check test 4");
		
		ckb1.setForeground(Color.RED);
		rb1.setForeground(Color.RED);
		
		ckb2.setEnabled(false);
		rb2.setEnabled(false);
		
		ckb3.setOpaque(true);
		rb3.setOpaque(true);
		ckb3.setBackground(Color.CYAN.darker());
		rb3.setBackground(Color.CYAN.darker());
		
		ckb4.setOpaque(true);
		rb4.setOpaque(true);
		ckb4.setBackground(Color.DARK_GRAY);
		rb4.setBackground(Color.DARK_GRAY);
		ckb4.setForeground(Color.WHITE);
		rb4.setForeground(Color.WHITE);
		ckb4.setFocusable(false);
		rb4.setFocusable(false);
		ckb4.setBorderPainted(true);
		rb4.setBorderPainted(true);
		ckb4.setBorder(BorderFactory.createEtchedBorder());
		rb4.setBorder(BorderFactory.createEtchedBorder());
		
		setLayout(new MigLayout(new LC().insetsAll("50")));
		add(ckb0);
		add(ckb1);
		add(ckb2);
		add(ckb3);
		add(ckb4);
		add(new JLabel(), new CC().wrap());
		add(rb0);
		add(rb1);
		add(rb2);
		add(rb3);
		add(rb4);
		
		setTitle("App Test");
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}
	
}