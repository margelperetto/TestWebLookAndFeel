package br.com.margel.weblaf.tests;

import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class TableTest extends JDialog {
	
	public TableTest(Window owner) {
		super(owner);
		
		setLayout(new MigLayout(new LC().insetsAll("10").gridGapY("10")));
		add(new JLabel("Double click to edit"), new CC().wrap());
		add(new JScrollPane(createTable()), new CC().width("800:100%:").height("400:100%:"));
		
		setTitle("Table Test");
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}
	
	private JTable createTable(){
		int rows = 50;
		int cols = 8;
		String[] colsData = new String[cols];
		String[][] data = new String[rows][colsData.length];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				data[row][col] = "Row "+(row+1)+" Column "+(col+1);
			}
		}
		for (int col = 0; col < cols; col++) {
			colsData[col] = "Column "+(col+1);
		}
		JTable table = new JTable(data, colsData);
		for (int i = 0; i < cols; i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(150);
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		return table;
	}
	
}