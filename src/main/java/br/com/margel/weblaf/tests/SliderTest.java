package br.com.margel.weblaf.tests;

import java.awt.Window;
import java.text.DateFormatSymbols;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class SliderTest extends JDialog {
	
	static String[] months = new DateFormatSymbols().getMonths();
	
	public SliderTest(Window owner) {
		super(owner);
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		JSlider slider0 = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		JSlider slider1 = new JSlider(JSlider.VERTICAL, 0, 100, 50);
		JSlider slider2 = new JSlider(JSlider.VERTICAL, 0, 100, 60);
		JSlider slider3 = new JSlider(JSlider.VERTICAL, 0, 100, 40);
		JSlider slider4 = new JSlider(JSlider.VERTICAL, 0, 100, 20);
		JSlider slider5 = new JSlider(JSlider.VERTICAL, 0, 100, 80);
		JSlider slider6 = new JSlider(JSlider.VERTICAL, 0, 100, 70);
		slider0.setEnabled(false);
		
		setLayout(new MigLayout(new LC().insetsAll("50")));
		add(new JLabel("Move focus here for test"), new CC().spanX());
		add(new JTextField(), new CC().spanX().growX().wrap());
		add(new JLabel("Slider Tests"), new CC().spanX().wrap());
		add(slider, new CC().width("300").wrap());
		add(slider0, new CC().width("300").wrap());
		
		add(slider1, new CC().height("100").spanX().split());
		add(slider2, new CC().height("100").gapLeft("40"));
		add(slider3, new CC().height("100").gapLeft("40"));
		add(slider4, new CC().height("100").gapLeft("40"));
		add(slider5, new CC().height("100").gapLeft("40"));
		add(slider6, new CC().height("100").gapLeft("40"));
		
		setTitle("App Test");
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}
	
}