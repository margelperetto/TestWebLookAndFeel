package br.com.margel.weblaf.tests;

import java.awt.Color;
import java.awt.Window;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class OptionTest extends JDialog {

	public OptionTest(Window owner) {
		super(owner);

		JButton btnMsg = createButton("Message", JOptionPane.INFORMATION_MESSAGE);
		JButton btnWarning = createButton("Warning", JOptionPane.WARNING_MESSAGE);
		JButton btnErro = createButton("Error", JOptionPane.ERROR_MESSAGE);
		JButton btnQuestion = createButton("Question", JOptionPane.QUESTION_MESSAGE);

		setLayout(new MigLayout(new LC().insetsAll("50").gridGap("10", "10").wrapAfter(2).fill()));
		add(btnMsg, new CC().grow());
		add(btnWarning, new CC().grow());
		add(btnErro, new CC().grow());
		add(btnQuestion, new CC().grow());

		setTitle("Option Test");
		pack();
		setMinimumSize(getSize());
		setSize(getWidth()+100, getHeight()+100);
		setLocationRelativeTo(null);
	}

	private JButton createButton(String text, int optionType) {
		JButton btn = new JButton(text);
		btn.setOpaque(false);
		btn.addActionListener(evt -> JOptionPane.showConfirmDialog(OptionTest.this, 
				"This is a amazing OptionPane \nwith " + text + " type.",
				"Teste JOptionPane", JOptionPane.YES_NO_CANCEL_OPTION, optionType));
		switch (optionType) {
		case JOptionPane.INFORMATION_MESSAGE:
			btn.setForeground(Color.CYAN.darker()); break;
		case JOptionPane.WARNING_MESSAGE:
			btn.setForeground(Color.ORANGE.darker()); break;
		case JOptionPane.ERROR_MESSAGE:
			btn.setForeground(Color.RED.darker()); break;
		case JOptionPane.QUESTION_MESSAGE:
			btn.setForeground(Color.YELLOW.darker()); break;
		}
		return btn;
	}

}