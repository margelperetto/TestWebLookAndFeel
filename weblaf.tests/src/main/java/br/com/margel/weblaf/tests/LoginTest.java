package br.com.margel.weblaf.tests;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.margel.weblaf.borders.WebBorder;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class LoginTest extends JDialog{
	
	private JTextField textField = new JTextField("margel.peretto@gmail.com");
	private JPasswordField passwordField = new JPasswordField("123456");
	private JCheckBox checkBox = new JCheckBox("Remember my credentials", true);
	private JButton buttonLogin = new JButton("Log in");
	private JButton buttonCancel = new JButton("Cancel");
	private JButton buttonForgotPass = new JButton("Forgot your password?");

	public LoginTest(JFrame owner) {
		super(owner);
		
		buttonCancel.setBackground(Color.decode("#6c757d"));
		
		buttonForgotPass.setContentAreaFilled(false);
		buttonForgotPass.setForeground(Color.BLUE);
		buttonForgotPass.setBorderPainted(false);
		buttonForgotPass.setBorder(new WebBorder(new Insets(2, 2, 2, 2)));
		buttonForgotPass.setToolTipText("An email will be sent with a temporary password");
		
		WebBorder webBorder = new WebBorder(new Insets(50, 50, 50, 50));
		webBorder.setArcHeight(50);
		webBorder.setArcWidth(50);
		webBorder.setColor(Color.decode("#0288D1"));

		JPanel panel = new JPanel(new MigLayout(new LC().fillX()));
		panel.setBorder(webBorder);
		panel.add(new JLabel("Enter with your username or e-mail"), new CC().spanX().wrap());
		panel.add(textField, new CC().spanX().width("300").wrap());
		panel.add(new JLabel("Password (6 digits)"), new CC().spanX().gapTop("20").wrap());
		panel.add(passwordField, new CC().spanX().width("300").wrap());
		panel.add(checkBox, new CC().spanX().width("300").gapBottom("20").wrap());
		panel.add(buttonLogin);
		panel.add(buttonCancel);
		panel.add(buttonForgotPass, new CC().alignX("right").alignY("top"));
		
		setLayout(new GridBagLayout());
		add(panel);
		((JPanel)getContentPane()).setOpaque(true);
		((JPanel)getContentPane()).setBackground(Color.decode("#CFD8DC"));
		
		setTitle("Login Test");
		pack();
		setMinimumSize(getSize());
		setSize(800, 600);
		setLocationRelativeTo(null);
	}
}
