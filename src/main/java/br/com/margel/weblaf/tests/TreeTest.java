package br.com.margel.weblaf.tests;

import java.awt.Dimension;
import java.awt.Window;
import java.util.Hashtable;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class TreeTest extends JDialog {
	
	public TreeTest(Window owner) {
		super(owner);
		
		setLayout(new MigLayout(new LC()));
		add(createTree(), new CC().width("300:100%:").height("200:100%:").wrap());
		
		setTitle("Tree Test");
		pack();
		setMinimumSize(new Dimension(getWidth(), 50));
		setLocationRelativeTo(null);
	}
	
	private JScrollPane createTree(){
		JTree tree = new JTree(new Hashtable<String, Object>(){
			{
				put("Parent 1",new Object[]{"Leaf 1.1","Leaf 1.2"});
				put("Parent 2",new Object[]{"Leaf 2.1","Leaf 2.2","Leaf 2.3","Leaf 2.4"});
				put("Parent 3",new Object[]{"Leaf 3.1","Leaf 3.2","Leaf 3.3"});
				put("Parent 4",new Object[]{"Leaf 4.1","Leaf 4.2"});
				put("Parent 5",new Hashtable<String, Object>(){{
					put("Parent 5.1",new Object[]{"Leaf 5.1.1","Leaf 5.1.2"});
					put("Parent 5.2",new Object[]{"Leaf 5.2.1","Leaf 5.2.2"});
				}});
			}
		});	
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
		return new JScrollPane(tree);
	}
	
}