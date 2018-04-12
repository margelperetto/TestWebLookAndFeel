package br.com.margel.weblaf.tests;

import java.awt.Window;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class FileChooserTest extends JDialog {
	
	JButton btn = new JButton("Choose File");
	JTextField jtf = new JTextField();
	JLabel fileName = new JLabel("File Name: ");
	JLabel fileSize = new JLabel("File Size: ");
	JLabel fileDate = new JLabel("File Date: ");
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public FileChooserTest(Window owner) {
		super(owner);
		
		btn.addActionListener(evt->openChooser());
		jtf.setEditable(false);
		
		setLayout(new MigLayout(new LC().insetsAll("50")));
		add(new JLabel("FileChooserTest"), new CC().wrap());
		add(jtf, new CC().width("600:100%:"));
		add(btn, new CC().growY().wrap());
		add(fileName, new CC().wrap());
		add(fileSize, new CC().wrap());
		add(fileDate, new CC().wrap());
		
		setTitle("FileChoose Test");
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}

	private void openChooser() {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("FileChooser Test");
		if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			jtf.setText(file.getAbsolutePath());
			fileName.setText(file.getName());
			fileSize.setText(file.length()+" bytes");
			fileDate.setText(sdf.format(new Date(file.lastModified())));
		}
	}
	
}