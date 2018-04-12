package br.com.margel.weblaf.uis;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalFileChooserUI;

import com.sun.java.swing.plaf.windows.WindowsFileChooserUI;

public class UIWebFileChooser extends MetalFileChooserUI {

	public static ComponentUI createUI(JComponent c) {
		return new WindowsFileChooserUI((JFileChooser) c);
		//return new UIWebFileChooser((JFileChooser) c);
	}

	public UIWebFileChooser(JFileChooser filechooser) {
		super(filechooser);
	}

	private JFileChooser chooser;

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		chooser = (JFileChooser) c;
		chooser.setPreferredSize(new Dimension(800, 500));
		try {
			for (AbstractButton btn : getDescendantsOfType(AbstractButton.class, chooser, true)) {
				btn.setOpaque(false);
				btn.setBackground(Color.LIGHT_GRAY);
				btn.setForeground(Color.DARK_GRAY);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static <T extends JComponent> List<T> getDescendantsOfType(Class<T> clazz, Container container, boolean nested) {
		List<T> tList = new ArrayList<>();
		for (Component component : container.getComponents()) {
			if (clazz.isAssignableFrom(component.getClass())) {
				tList.add(clazz.cast(component));
			}
			if (nested || !clazz.isAssignableFrom(component.getClass())) {
				tList.addAll(getDescendantsOfType(clazz, (Container) component, nested));
			}
		}
		return tList;
	}

}