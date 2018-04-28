package br.com.margel.weblaf.tests;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class ColorChooserTest extends JDialog {
	
	public ColorChooserTest(Window owner) {
		super(owner);
		
		JButton btn = new JButton("Open color chooser");
		btn.addActionListener(new ActionListener() {
			final JColorChooser chooser = new JColorChooser();
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionListener a = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						btn.setBackground(chooser.getColor());
					}
				};
				JColorChooser.createDialog(
						ColorChooserTest.this, 
						"ColorTest", true, chooser, a, null
						).setVisible(true);
			}
		});
		
		setLayout(new MigLayout(new LC().insetsAll("150").fill()));
		add(btn, new CC().alignX("center").alignY("center"));
		
		setTitle("ColorChooser Test");
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}
	
}