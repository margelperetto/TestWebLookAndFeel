package br.com.margel.weblaf.tests;

import java.awt.Component;
import java.awt.Font;
import java.awt.Window;
import java.text.DateFormatSymbols;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class SizesTest extends JDialog {

	static String[] months = new DateFormatSymbols().getMonths();

	public SizesTest(Window owner) {
		super(owner);
		try {
			setLayout(new MigLayout(new LC().insetsAll("50").gridGapX("15").wrapAfter(5).debug(100)));
			add(new JLabel("TEXTFIELD"));
			add(new JLabel("JSPINNER"));
			add(new JLabel("JCOMBOBOX"));
			add(new JLabel("FORMATTEDTEXT"));
			add(new JLabel("PASSWORFIELD"));

			add(new JTextField("Text field"), new CC().growX().alignY("top"));
			add(new JSpinner(new SpinnerNumberModel(999, 0, 9999, 1)), new CC().growX().alignY("top"));
			add(new JComboBox<>(months), new CC().growX().alignY("top"));
			add(new JFormattedTextField(new MaskFormatter("#####-###")), new CC().growX().alignY("top"));
			add(new JPasswordField("123456"), new CC().growX().alignY("top"));

			add(new JLabel("TEXTFIELD"));
			add(new JLabel("JSPINNER"));
			add(new JLabel("JCOMBOBOX"));
			add(new JLabel("FORMATTEDTEXT"));
			add(new JLabel("PASSWORFIELD"));

			add(c(12, new JTextField("Text field")), new CC().growX().alignY("top"));
			add(c(12, new JSpinner(new SpinnerNumberModel(999, 0, 9999, 1))), new CC().growX().alignY("top"));
			add(c(12, new JComboBox<>(months)), new CC().growX().alignY("top"));
			add(c(12, new JFormattedTextField(new MaskFormatter("#####-###"))), new CC().growX().alignY("top"));
			add(c(12, new JPasswordField("123456")), new CC().growX().alignY("top"));

			setTitle("Sizes Test");
			pack();
			setMinimumSize(getSize());
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Component c(float fontSize, JComponent comp) {
		comp.setFont(comp.getFont().deriveFont(Font.PLAIN, fontSize));
		if (comp instanceof JSpinner) {
			JSpinner s = (JSpinner)comp;
			s.getEditor().setFont(comp.getFont());
			s.getEditor().getComponent(0).setFont(comp.getFont());
		}
		return comp;
	}

	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		if (b) {
			for (Component c : getContentPane().getComponents()) {
				if (!(c instanceof JLabel)) {
					add(new JLabel(c.getWidth() + "x" + c.getHeight()));
					if (c instanceof JFormattedTextField) {
						((JFormattedTextField) c).setText("98900000");
					}
				}
			}
		}
	}

}