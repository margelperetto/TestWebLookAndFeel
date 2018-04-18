package br.com.margel.weblaf.tests;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import br.com.margel.weblaf.WebLookAndFeel;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class AppTest extends JFrame {
	
	public AppTest(){
		
		setLayout(new MigLayout(new LC().insetsAll("25").gridGap("25", "25").wrapAfter(4).fill()));
		add(createButton("Login test", e-> new LoginTest(this).setVisible(true)), new CC().grow());
		add(createButton("Checkout test", e-> new CheckoutPageTest().setVisible(true)), new CC().grow());
		add(createButton("ComplexForm test", e-> new ComplexFormTest(this).setVisible(true)), new CC().grow());
		add(createButton("Button test", e-> new ButtonTest(this).setVisible(true)), new CC().grow());
		add(createButton("Toggle test", e-> new ToggleButtonTest(this).setVisible(true)), new CC().grow());
		add(createButton("Radio & Check", e-> new RadioCheckTest(this).setVisible(true)), new CC().grow());
		add(createButton("Combo Box test", e-> new ComboBoxTest(this).setVisible(true)), new CC().grow());
		add(createButton("Spinners test", e-> new SpinnerTest(this).setVisible(true)), new CC().grow());
		add(createButton("Slider test", e-> new SliderTest(this).setVisible(true)), new CC().grow());
		add(createButton("ProgressBar test", e-> new ProgressBarTest(this).setVisible(true)), new CC().grow());
		add(createButton("Tabbed test", e-> new TabbedTest(this).setVisible(true)), new CC().grow());
		add(createButton("Tabbed Icon test", e-> new TabbedIconTest(this).setVisible(true)), new CC().grow());
		add(createButton("TextArea test", e-> new TextAreaTest(this).setVisible(true)), new CC().grow());
		add(createButton("SplitPane test", e-> new SplitTest(this).setVisible(true)), new CC().grow());
		add(createButton("Option test", e-> new OptionTest(this).setVisible(true)), new CC().grow());
		add(createButton("Tree test", e-> new TreeTest(this).setVisible(true)), new CC().grow());
		add(createButton("TitledBorder test", e-> new TitledBorderTest(this).setVisible(true)), new CC().grow());
		add(createButton("Table test", e-> new TableTest(this).setVisible(true)), new CC().grow());
		add(createButton("List test", e-> new JListTest(this).setVisible(true)), new CC().grow());
		add(createButton("MenuBar test", e-> new MenuBarTest(this).setVisible(true)), new CC().grow());
		add(createButton("FileChooser test", e-> new FileChooserTest(this).setVisible(true)), new CC().grow());
		add(createButton("ColorChooser test", e-> new ColorChooserTest(this).setVisible(true)), new CC().grow());
		add(createButton("Sizes test", e-> new SizesTest(this).setVisible(true)), new CC().grow());
		
		setTitle("App Test");
		pack();
		setMinimumSize(getSize());
		setSize(getWidth(), getHeight()+100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
    private Component createButton(String string, ActionListener listener) {
    	JButton btn = new JButton(string);
		btn.addActionListener(listener);
		btn.setOpaque(false);
		btn.setForeground(Color.BLACK);
		btn.setBackground(Color.GRAY);
    	return btn;
	}

	public static void main( String[] args ) {
    	try {
			UIManager.setLookAndFeel(new WebLookAndFeel());
    		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new AppTest().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
    }
    
}