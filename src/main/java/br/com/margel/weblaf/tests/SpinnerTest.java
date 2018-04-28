package br.com.margel.weblaf.tests;

import java.awt.Window;
import java.text.DateFormatSymbols;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class SpinnerTest extends JDialog {
	
	static String[] months = new DateFormatSymbols().getMonths();
	
	public SpinnerTest(Window owner) {
		super(owner);
		
		JSpinner tb0 = new JSpinner(new SpinnerNumberModel(100, 0, 9999, 1));
		JSpinner tb1 = new JSpinner(new SpinnerListModel(months));
		JSpinner tb2 = new JSpinner(new SpinnerNumberModel(10.5, 0, 9999, 0.01));
		JSpinner tb3 = new JSpinner(new SpinnerNumberModel(100, 0, 9999, 1));
		tb3.setEnabled(false);
		JSpinner tb4 = new JSpinner(new SpinnerNumberModel(2000, 0, 9999, 100));
		tb4.setEditor(new JSpinner.NumberEditor(tb4, "0000"));
		JSpinner tb5 = new JSpinner(new SpinnerNumberModel(2000, 0, 9999, 100));
		JSpinner tb6 = new JSpinner(new SpinnerDateModel());
		tb6.setEditor(new JSpinner.DateEditor(tb6, "HH:mm dd/MM/yyyy"));
		JSpinner tb7 = new JSpinner(new SpinnerDateModel());
		
		setLayout(new MigLayout(new LC().insetsAll("50")));
		add(new JLabel("Move focus here for test"), new CC().spanX());
		add(new JTextField(), new CC().spanX().growX().wrap());
		add(new JLabel("Spinner Tests"), new CC().spanX().wrap());
		add(tb0, new CC());
		add(tb1, new CC());
		add(tb2, new CC());
		add(tb6, new CC().wrap());
		add(tb3, new CC());
		add(tb4, new CC());
		add(tb5, new CC());
		add(tb7, new CC());
		
		setTitle("Spinner Test");
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}
	
}