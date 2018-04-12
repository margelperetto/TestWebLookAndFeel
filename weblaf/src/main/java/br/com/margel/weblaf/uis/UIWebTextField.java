package br.com.margel.weblaf.uis;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalTextFieldUI;
import javax.swing.text.JTextComponent;

import br.com.margel.weblaf.WebTheme;
import br.com.margel.weblaf.borders.WebBorder;
import br.com.margel.weblaf.utils.RepaintUtils;

public class UIWebTextField extends MetalTextFieldUI{

	public static ComponentUI createUI(JComponent c){
		return new UIWebTextField();
	}

	private JComponent c;

	@Override
	public void installUI(JComponent comp) {
		this.c = comp;
		super.installUI(c);
		if(c instanceof JTextComponent){
			c.addPropertyChangeListener( evt -> {
				if("foreground".equals(evt.getPropertyName())){
					((JTextComponent)c).setCaretColor(c.getForeground());
				}
			});
		}
		WebBorder webBorder = new WebBorder();
		webBorder.setPaintFocus(true);
		webBorder.setFocusColor(WebTheme.TEXT_FIELD_FOCUS_COLOR);
		webBorder.setColor(WebTheme.TEXT_FIELD_BORDER_COLOR);
		c.setBorder(webBorder);
		c.setFont(WebTheme.TEXT_FIELD_FONT);
		c.setBackground(WebTheme.TEXT_FIELD_BG);
		c.setForeground(WebTheme.TEXT_FIELD_FG);
		RepaintUtils.installListeners(c);
	}
	
	@Override
	protected void paintBackground(Graphics g) {
		if(!(c.getBorder() instanceof WebBorder)){
			super.paintBackground(g);
			return;
		}
		if(!c.isOpaque()){
			return;
		}
		WebBorder b = (WebBorder)c.getBorder();
		paintCustomBackgroud(g, c.getWidth(), c.getHeight(), b.getArcWidth(), b.getArcHeight());
	}
	
	private void paintCustomBackgroud(Graphics g, int w, int h, int aw, int ah) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(c.getBackground());
		g2d.fillRoundRect(0, 0, w-1, h-1, aw, ah);
		g2d.dispose();
	}
	
}