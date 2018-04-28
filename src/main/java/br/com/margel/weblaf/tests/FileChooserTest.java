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
	JTextField filePath = new JTextField();
	JTextField fileName = new JTextField();
	JTextField fileSize = new JTextField();
	JTextField fileDate = new JTextField();
	JLabel icon = new JLabel();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public FileChooserTest(Window owner) {
		super(owner);
		
		btn.addActionListener(evt->openChooser());
		filePath.setEditable(false);
		fileName.setEditable(false);
		fileSize.setEditable(false);
		fileDate.setEditable(false);
		
		setLayout(new MigLayout(new LC().insetsAll("50")));
		add(new JLabel("Selected file"), new CC().wrap());
		add(filePath, new CC().width("600:100%:"));
		add(btn, new CC().growY().wrap());
		add(new JLabel("File Name: "), new CC().gapTop("15").wrap());
		add(fileName, new CC().growX());
		add(icon, new CC().wrap());
		add(new JLabel("File Size: "), new CC().wrap());
		add(fileSize, new CC().width("200").wrap());
		add(new JLabel("File Date: "), new CC().wrap());
		add(fileDate, new CC().width("200"));
		
		setTitle("FileChoose Test");
		pack();
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
	}

	private void openChooser() {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Open file");
		if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			filePath.setText(file.getAbsolutePath());
			fileName.setText(file.getName());
			fileSize.setText(file.length()+" bytes");
			fileDate.setText(sdf.format(new Date(file.lastModified())));
			icon.setIcon(chooser.getFileSystemView().getSystemIcon(file));
			icon.setToolTipText(chooser.getFileSystemView().getSystemTypeDescription(file));
		}
	}
	
}