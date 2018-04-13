package br.com.margel.weblaf.utils;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

public class ComponentUtils {

	public static <T extends JComponent> List<T> searchAssignableFrom(Class<T> clazz, Container container, boolean nested) {
		List<T> tList = new ArrayList<>();
		for (Component component : container.getComponents()) {
			if (clazz.isAssignableFrom(component.getClass())) {
				tList.add(clazz.cast(component));
			}
			if (nested || !clazz.isAssignableFrom(component.getClass())) {
				tList.addAll(searchAssignableFrom(clazz, (Container) component, nested));
			}
		}
		return tList;
	}
}
