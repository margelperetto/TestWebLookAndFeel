package br.com.margel.weblaf.tests;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class TabbedTest extends JDialog {
	
	public TabbedTest(Window owner) {
		super(owner);
		
		setLayout(new MigLayout(new LC()));
		add(createTab(JTabbedPane.TOP, 0), new CC());
		add(createTab(JTabbedPane.LEFT, 1), new CC().wrap());
		add(createTab(JTabbedPane.RIGHT, 2), new CC().alignY("top"));
		add(createTab(JTabbedPane.BOTTOM, 3), new CC());
		
		((JPanel)getContentPane()).setOpaque(true);
		((JPanel)getContentPane()).setBackground(Color.DARK_GRAY);
		
		setTitle("Tab Test");
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}

	private JTabbedPane createTab(int place, int selectedIndex) {
		JTabbedPane tab = new JTabbedPane(place);
		tab.addTab("Tab 1", createContent(new Color(240, 240, 240), "Tab 1"));
		tab.addTab("Tab 2", createContent(new Color(200, 240, 200), "Tab 2"));
		tab.addTab("Tab 3", createContent(new Color(200, 200, 240), "Tab 3"));
		tab.addTab("Tab 4", createContent(new Color(240, 200, 200), "Tab 4"));
		tab.setSelectedIndex(selectedIndex);
		tab.setPreferredSize(new Dimension(300, 200));
		return tab;
	}

	private Component createContent(Color bg, String text) {
		JLabel label = new JLabel(text, JLabel.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(label.getFont().deriveFont(Font.BOLD, 22f));
		label.setOpaque(true);
		label.setBackground(bg);
		return label;
	}
	
}