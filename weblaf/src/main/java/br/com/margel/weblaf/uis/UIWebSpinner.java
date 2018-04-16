package br.com.margel.weblaf.uis;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.font.FontRenderContext;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSpinnerUI;

import br.com.margel.weblaf.WebTheme;
import br.com.margel.weblaf.utils.IconUtils;

public class UIWebSpinner extends BasicSpinnerUI {

	public static ComponentUI createUI(JComponent c){
		return new UIWebSpinner();
	}

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		spinner.setOpaque(false);
		spinner.setBorder(new EmptyBorder(0, 0, 0, 0));
		spinner.getEditor().setBorder(new EmptyBorder(0, 0, 0, 0));
		updatePrefferedSize();
	}

	private void updatePrefferedSize(){
		try {
			Font f = spinner.getEditor().getFont();
			FontRenderContext frc = new FontRenderContext(f.getTransform(),true,true);
			JFormattedTextField tf = ((DefaultEditor)spinner.getEditor()).getTextField();
			AbstractFormatter formatter = tf.getFormatter();
			int margin = 35;
			if(spinner.getModel() instanceof SpinnerNumberModel){
				SpinnerNumberModel model = (SpinnerNumberModel)spinner.getModel();
				Object obj = null;
				if(model.getMaximum() != null){
					obj = model.getMaximum();
				}else {
					obj = 999999;
				}
				String str = formatter.valueToString(obj);
				int w = (int)f.getStringBounds(str, frc).getWidth()+margin;
				spinner.setPreferredSize(new Dimension(w, tf.getPreferredSize().height-1));
			}else if(spinner.getModel() instanceof SpinnerListModel){
				int maxw = (int)f.getStringBounds(formatter.valueToString(spinner.getValue()), frc).getWidth();
				SpinnerListModel slm = (SpinnerListModel)spinner.getModel();
				for(Object obj : slm.getList()){
					int w = (int)f.getStringBounds(formatter.valueToString(obj), frc).getWidth();
					if(w>maxw){
						maxw = w;
					}
				}
				spinner.setPreferredSize(new Dimension(maxw+(margin*2), tf.getPreferredSize().height-1));
			}
			spinner.revalidate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Component createNextButton() {
		Component c = createButton(SwingConstants.NORTH);
		c.setName("Spinner.nextButton");
		installNextButtonListeners(c);
		return c;
	}

	@Override
	protected Component createPreviousButton() {
		Component c = createButton(SwingConstants.SOUTH);
		c.setName("Spinner.previousButton");
		installPreviousButtonListeners(c);
		return c;
	}

	protected JButton createButton(int orientation){
		JButton b = new JButton();
		b.setBorder(new EmptyBorder(0, 1, 0, 1));
		b.setFocusable(false);
		b.setBorderPainted(false);
		b.setContentAreaFilled(false);
		b.setIcon(IconUtils.arrowIcon(new Dimension(15, 14), orientation, 2, WebTheme.SPINNER_ARROW));
		return b;
	}

}