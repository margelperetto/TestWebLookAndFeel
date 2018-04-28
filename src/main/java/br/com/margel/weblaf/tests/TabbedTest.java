package br.com.margel.weblaf.tests;

import java.awt.Color;
import java.awt.Component;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import br.com.margel.weblaf.borders.WebBorder;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class TabbedTest extends JDialog {
	
	public TabbedTest(Window owner) {
		super(owner);
		
		setLayout(new MigLayout(new LC().insetsAll("0").gridGap("0", "0").fill().wrapAfter(2)));
		add(createTab(JTabbedPane.TOP, 0), new CC().grow());
		add(createTab(JTabbedPane.RIGHT, 1), new CC().alignY("bottom").grow());
		add(createTab(JTabbedPane.LEFT, 2), new CC().alignY("top").grow());
		add(createTab(JTabbedPane.BOTTOM, 3), new CC().grow());
		
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
		return tab;
	}

	private Component createContent(Color bg, String text) {
		JLabel label = new JLabel(text, JLabel.CENTER);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(label.getFont().deriveFont(22f));
		label.setOpaque(true);
		label.setBackground(bg);
		label.setBorder(new WebBorder());
		String gap = "25";
		JPanel panel = new JPanel(new MigLayout(new LC().insetsAll(gap)));
		panel.add(label, new CC().spanY().width("150!").gapRight(gap).growY());
		panel.add(new JLabel("Name"), new CC().wrap());
		panel.add(new JTextField(text), new CC().width("180").wrap());
		panel.add(new JLabel("Address"), new CC().wrap());
		panel.add(new JTextField("Address "+text), new CC().width("180").gapBottom(gap).wrap());
		panel.add(createBtn("Save", Color.CYAN.darker()), new CC().split().spanX());
		panel.add(createBtn("Cancel", Color.GRAY), new CC());
		return panel;
	}

	private Component createBtn(String text, Color color) {
		JButton btn = new JButton(text);
		btn.setOpaque(false);
		btn.setBackground(color);
		btn.setForeground(color);
		return btn;
	}
	
}