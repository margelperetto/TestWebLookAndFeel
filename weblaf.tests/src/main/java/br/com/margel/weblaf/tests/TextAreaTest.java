package br.com.margel.weblaf.tests;

import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class TextAreaTest extends JDialog {
	
	public TextAreaTest(Window owner) {
		super(owner);
		
		JTextArea jta = new JTextArea("Line wrap test");
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		
		setLayout(new MigLayout(new LC().minWidth("300").wrapAfter(2).gridGapY("20").insetsAll("50")));
		add(new JScrollPane(jta), new CC().width("300:100%:").height("150").wrap());
		add(new JScrollPane(new JTextArea("Horizontal scroll test")), new CC().width("300:100%:").height("150").wrap());
		
		setTitle("TextArea Test");
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}
	
}