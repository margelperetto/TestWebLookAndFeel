package br.com.margel.weblaf.tests;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class SplitTest extends JDialog {
	
	public SplitTest(Window owner) {
		super(owner);
		
		JSplitPane split1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
				createComp(new Color(255,225,225), "Slipt 1"), 
				createComp(new Color(225,255,225), "Slipt 2"));
		
		JSplitPane split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
				createComp(new Color(225,225,255), "Slipt 1"), 
				split1);
		
		setLayout(new MigLayout(new LC().fill().insetsAll("50")));
		add(split2, new CC().grow());
		
		setTitle("Split Test");
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}

	private Component createComp(Color bg, String text) {
		JLabel label = new JLabel(text, JLabel.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(label.getFont().deriveFont(Font.BOLD, 22f));
		label.setOpaque(true);
		label.setBackground(bg);
		label.setPreferredSize(new Dimension(200, 150));
		return label;
	}
	
}