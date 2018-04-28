package br.com.margel.weblaf.tests;

import java.awt.Color;
import java.awt.Window;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class ToggleButtonTest extends JDialog {
	
	public ToggleButtonTest(Window owner) {
		super(owner);
		
		JToggleButton tb0 = new JToggleButton("ToggleButton 1", true);
		JToggleButton tb1 = new JToggleButton("ToggleButton 2");
		JToggleButton tb2 = new JToggleButton("ToggleButton 3");
		ButtonGroup bg = new ButtonGroup();
		bg.add(tb0);
		bg.add(tb1);
		bg.add(tb2);
		
		JToggleButton tbg0 = new JToggleButton("ToggleButton 1");
		JToggleButton tbg1 = new JToggleButton("ToggleButton 2", true);
		JToggleButton tbg2 = new JToggleButton("ToggleButton 3");
		tbg0.setBackground(Color.decode("#dc3545"));
		tbg1.setBackground(Color.decode("#dc3545"));
		tbg2.setBackground(Color.decode("#dc3545"));
		ButtonGroup bgg = new ButtonGroup();
		bgg.add(tbg0);
		bgg.add(tbg1);
		bgg.add(tbg2);
		
		JToggleButton tbr0 = new JToggleButton("ToggleButton 1");
		JToggleButton tbr1 = new JToggleButton("ToggleButton 2");
		JToggleButton tbr2 = new JToggleButton("ToggleButton 3", true);
		tbr0.setBackground(Color.decode("#28a745"));
		tbr1.setBackground(Color.decode("#28a745"));
		tbr2.setBackground(Color.decode("#28a745"));
		ButtonGroup bgr = new ButtonGroup();
		bgr.add(tbr0);
		bgr.add(tbr1);
		bgr.add(tbr2);
		
		setLayout(new MigLayout(new LC().insetsAll("50")));
		add(new JLabel("Move focus here for test"), new CC().spanX());
		add(new JTextField(), new CC().spanX().growX().wrap());
		add(new JLabel("ToggleButton Tests"), new CC().spanX().wrap());
		add(tb0, new CC());
		add(tb1, new CC());
		add(tb2, new CC().wrap());
		add(tbg0, new CC());
		add(tbg1, new CC());
		add(tbg2, new CC().wrap());
		add(tbr0, new CC());
		add(tbr1, new CC());
		add(tbr2, new CC());
		
		setTitle("App Test");
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}
	
}