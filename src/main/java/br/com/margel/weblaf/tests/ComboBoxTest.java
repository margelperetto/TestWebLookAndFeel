package br.com.margel.weblaf.tests;

import java.awt.Window;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class ComboBoxTest extends JDialog {
	
	public ComboBoxTest(Window owner) {
		super(owner);
		
		JComboBox<String> combo0 = new JComboBox<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"});
		JComboBox<String> combo1 = new JComboBox<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"});
		JComboBox<String> combo2 = new JComboBox<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"});
		
		combo1.setEditable(true);
		combo2.setEnabled(false);
		
		setLayout(new MigLayout(new LC().minWidth("300").wrapAfter(2).gridGapY("20").insetsAll("50")));
		add(new JTextField("Align ok"), new CC().width("100%"));
		add(new JTextField("Test focus here"), new CC().width("100%"));
		add(combo0, new CC().width("100%"));
		add(new JTextField("Test 1"), new CC().width("100%"));
		add(combo1, new CC().width("100%"));
		add(new JTextField("Test 2"), new CC().width("100%"));
		add(combo2, new CC().width("100%"));
		add(new JTextField("Test 3"), new CC().width("100%"));
		
		setTitle("App Test");
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}
	
}