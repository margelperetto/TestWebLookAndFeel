package br.com.margel.weblaf.tests;

import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class JListTest extends JDialog {
	
	public JListTest(Window owner) {
		super(owner);
		
		setLayout(new MigLayout(new LC().insetsAll("10").fill()));
		add(new JScrollPane(createList()), new CC().grow());
		
		setTitle("JList Test");
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}
	
	private JList<String> createList(){
		JList<String> list = new JList<>();
		list.setListData(new String[]{"Value 1","Value 2","Value 3", "Value 4"});
		return list;
	}
	
}