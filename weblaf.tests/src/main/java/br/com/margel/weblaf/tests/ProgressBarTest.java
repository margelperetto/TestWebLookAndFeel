package br.com.margel.weblaf.tests;

import java.awt.Window;
import java.text.DateFormatSymbols;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class ProgressBarTest extends JDialog {
	
	static String[] months = new DateFormatSymbols().getMonths();
	
	public ProgressBarTest(Window owner) {
		super(owner);
		
		JProgressBar pbH1 = animateProgress();
		JProgressBar pbH2 = new JProgressBar();
		JProgressBar pbH3 = animateProgress(JProgressBar.HORIZONTAL, false, 50);
		pbH2.setIndeterminate(true);
		
		JProgressBar pbV1 = animateProgress(JProgressBar.VERTICAL, true, 100);
		JProgressBar pbV2 = new JProgressBar(JProgressBar.VERTICAL);
		JProgressBar pbV3 = animateProgress(JProgressBar.VERTICAL, false, 50);
		pbV2.setIndeterminate(true);
		
		setLayout(new MigLayout(new LC().insetsAll("50")));
		add(new JLabel("Progress Tests"), new CC().spanX().wrap());
		add(pbH1, new CC().width("300").wrap());
		add(pbH2, new CC().width("300").wrap());
		add(pbH3, new CC().width("300").wrap());
		
		add(pbV1, new CC().height("150").gapLeft("40").spanX().split());
		add(pbV2, new CC().height("150").gapLeft("40"));
		add(pbV3, new CC().height("150").gapLeft("40"));
		
		setTitle("ProgressBar Test");
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}
	
	private JProgressBar animateProgress() {
		return animateProgress(JProgressBar.HORIZONTAL, true, 100);
	}

	private JProgressBar animateProgress(int orientarion, boolean stringPainted, int max){
		final JProgressBar pb = new JProgressBar(orientarion, 0, max);
		pb.setStringPainted(stringPainted);
		
		new SwingWorker<Void, Void>() {
			int add = 1;
			@Override
			protected Void doInBackground() throws Exception {
				while (true) {
					publish();
					Thread.sleep(50);
				}
			}
			@Override
			protected void process(List<Void> chunks) {
				pb.setValue(pb.getValue()+add);
				if(pb.getValue()>=max|| pb.getValue()<=0){
					add = add*-1;
				}
			}
		}.execute();
		
		return pb;
	}
	
}