package br.com.margel.weblaf.tests;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import br.com.margel.weblaf.utils.IconUtils;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class TabbedIconTest extends JDialog {
	
	public TabbedIconTest(Window owner) {
		super(owner);
		
		setLayout(new MigLayout(new LC().insetsAll("0").gridGap("0", "0").fill().wrapAfter(1)));
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
		tab.addTab("Tab 1", IconUtils.getImageIcon("admin25x25.PNG"), createContent(new Color(240, 240, 240), "Tab 1"));
		tab.addTab("Tab 2", IconUtils.getImageIcon("dashboard25x25.PNG"), createContent(new Color(200, 240, 200), "Tab 2"));
		tab.addTab("Tab 3", IconUtils.getImageIcon("business25x25.PNG"), createContent(new Color(200, 200, 240), "Tab 3"));
		tab.addTab("Tab 4", IconUtils.getImageIcon("analytics25x25.PNG"), createContent(new Color(240, 200, 200), "Tab 4"));
		tab.setSelectedIndex(selectedIndex);
		tab.setPreferredSize(new Dimension(400, 180));
		return tab;
	}

	private Component createContent(Color bg, String text) {
		JLabel label = new JLabel(text, JLabel.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(label.getFont().deriveFont(22f));
		label.setOpaque(true);
		label.setBackground(bg);
		return label;
	}
	
}