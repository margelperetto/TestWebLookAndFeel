package br.com.margel.weblaf.uis;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTableHeaderUI;

public class UIWebTableHeader extends BasicTableHeaderUI{

	public static ComponentUI createUI(JComponent c){
		return new UIWebTableHeader();
	}
}
