package br.com.margel.weblaf.tests;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import br.com.margel.weblaf.utils.IconUtils;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class ButtonTest extends JDialog{
	
	private JButton btn = new JButton("Custom Button");
	private JButton btnBorderCustom = new JButton("Custom Border");
	private JCheckBox ckbEnabled;
	private JCheckBox ckbContentAreaFilled;
	private JCheckBox ckbOpaque;
	private JCheckBox ckbBorderPainted;
	private JCheckBox ckbFocusPainted;
	private JCheckBox ckbFocusable;

	public ButtonTest(JFrame owner) {
		super(owner);
		
		ckbEnabled = createCheckBox("Enabled", value-> btn.setEnabled((Boolean)value));
		ckbContentAreaFilled = createCheckBox("ContentAreaFilled", value-> btn.setContentAreaFilled((Boolean)value));
		ckbOpaque = createCheckBox("Opaque", value->btn.setOpaque((Boolean)value));
		ckbBorderPainted = createCheckBox("BorderPainted", value->btn.setBorderPainted((Boolean)value));
		ckbFocusPainted = createCheckBox("FocusPainted", value->btn.setFocusPainted((Boolean)value));
		ckbFocusable = createCheckBox("Focusable", value->btn.setFocusable((Boolean)value));
		populateChecks();

		ColorSelect colorSelectBg = new ColorSelect(btn.getBackground(), "Background", value->btn.setBackground((Color)value));
		ColorSelect colorSelectFg = new ColorSelect(btn.getForeground(), "Foreground", value->btn.setForeground((Color)value));
		
		btnBorderCustom.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		setLayout(new MigLayout(new LC().noGrid()));
		add(ckbEnabled, new CC());
		add(ckbOpaque, new CC());
		add(ckbBorderPainted, new CC());
		add(ckbFocusPainted, new CC());
		add(ckbContentAreaFilled, new CC());
		add(ckbFocusable, new CC().wrap());
		add(colorSelectBg, new CC().wrap());
		add(colorSelectFg, new CC().wrap());
		add(btn, new CC().gapTop("50"));
		add(new JButton("Default Buttom"), new CC().gapTop("50"));
		add(new JButton("Icon 15x15", IconUtils.arrowIcon(new Dimension(15, 15), SwingConstants.NORTH, 2, Color.WHITE)), new CC().gapTop("50"));
		add(new JButton("Icon Buttom", IconUtils.getImageIcon("home25x25.png")), new CC().gapTop("50"));
		add(btnBorderCustom, new CC().gapTop("50"));
		
		setTitle("Button Test");
		pack();
		setMinimumSize(getSize());
		setSize(800, 600);
		setLocationRelativeTo(null);
	}
	
	private JCheckBox createCheckBox(String text, ActionValueChange action) {
		JCheckBox ckb = new JCheckBox(text);
		ckb.setFocusable(false);
		ckb.addActionListener(evt->populateChecks());
		ckb.addActionListener(evt->action.valueChange(ckb.isSelected()));
		return ckb;
	}
	
	private void populateChecks() {
		ckbEnabled.setSelected(btn.isEnabled());
		ckbContentAreaFilled.setSelected(btn.isContentAreaFilled());
		ckbOpaque.setSelected(btn.isOpaque());
		ckbBorderPainted.setSelected(btn.isBorderPainted());
		ckbFocusPainted.setSelected(btn.isFocusPainted());
		ckbFocusable.setSelected(btn.isFocusable());
	}

	private interface ActionValueChange {
		public void valueChange(Object value);
	}

	private class ColorSelect extends JPanel {
		private ButtonGroup group = new ButtonGroup();
		private ActionListener action;
		private Color defaultColor;
		
		public ColorSelect( Color defaultColor, String label, ActionValueChange action) {
			this.action = evt->action.valueChange(((JToggleButton)evt.getSource()).getBackground());
			this.defaultColor = defaultColor;
					
			setLayout(new MigLayout(new LC().insetsAll("0").gridGap("0", "0")));
			add(new JLabel(label), new CC().spanX().wrap());
			add(createToggle(btn.getBackground()));
			add(createToggle(Color.decode("#28a745")));
			add(createToggle(Color.decode("#dc3545")));
			add(createToggle(Color.decode("#ffc107")));
			add(createToggle(Color.decode("#17a2b8")));
			add(createToggle(Color.decode("#343a40")));
			add(createToggle(Color.decode("#ffffff")));
			add(createToggle(btn.getForeground()));
		}
		
		private JToggleButton createToggle(Color color) {
			JRadioButton btn = new JRadioButton("            ", color.equals(defaultColor));
			btn.setOpaque(true);
			btn.setBackground(color);
			btn.addActionListener(action);
			btn.setBorderPainted(true);
			btn.setFocusable(false);
			btn.setBorder(BorderFactory.createEtchedBorder());
			group.add(btn);
			return btn;
		}
	}
}
