package br.com.margel.weblaf.tests;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.margel.weblaf.borders.ParcialBorder;
import br.com.margel.weblaf.borders.WebBorder;
import br.com.margel.weblaf.components.PlaceHolderTextField;
import br.com.margel.weblaf.utils.IconUtils;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class ComplexFormTest extends JFrame{
	
	private JPanel panelContent = new JPanel(new BorderLayout(0,0));
	
	public ComplexFormTest(JFrame owner) {
		panelContent.setBackground(Color.decode("#f7f9fb"));
		
		setLayout(new MigLayout(new LC().insetsAll("0").gridGap("0", "0")));
		add(createPanelProfile(), new CC().grow());
		add(createPanelCompanyName(), new CC().width("100%").growY().wrap());
		add(createPanelMenus(), new CC().height("100%").growX());
		add(createScrollContent(panelContent), new CC().grow());
		
		setTitle("ComplexForm Test");
		pack();
		int sh = Toolkit.getDefaultToolkit().getScreenSize().height-80;
		setSize(new Dimension(getWidth()+20, Math.min(getHeight(), sh)));
		setMinimumSize(new Dimension(800, 500));
		setLocationRelativeTo(null);
	}
	
	private JPanel createPanelProfile() {
		JPanel panel = new JPanel(new MigLayout(new LC().insetsAll("20").gridGap("10", "0")));
		panel.setBorder(new ParcialBorder().color(Color.decode("#e1e6eb")).right().bottom());
		
		panel.add(new JLabel(IconUtils.getImageIcon("profile30x30.png")), new CC().spanY());
		panel.add(createLabel("User Test", Color.decode("#04b7a8"), 12f), new CC().wrap());
		panel.add(createLabel("user.test@test.com", Color.decode("#afbcc2"), 12f), new CC().alignY("top"));
		
		return panel;
	}
	
	private JPanel createPanelCompanyName() {
		JPanel panel = new JPanel(new MigLayout(new LC().insetsAll("20").gridGapX("7")));
		panel.setBorder(new ParcialBorder().color(Color.decode("#e1e6eb")).bottom());
		
		panel.add(createLabel("My Company", Color.decode("#aebbc2"), 22f));
		panel.add(createLabel("/", Color.decode("#b8e8e4"), 22f));
		panel.add(createLabel("Company Profile", Color.decode("#203543"), 22f));
		
		return panel;
	}
	
	private JPanel createPanelMenus() {
		JPanel pMenu = new JPanel(new MigLayout(new LC().wrapAfter(1).insets("12.5", "0", "0", "0").gridGapY("0").fillX()));
		pMenu.setBorder(new ParcialBorder().color(Color.decode("#e1e6eb")).right());
		
		pMenu.add(createPanelItemMenu("dashboard25x25.PNG", "Dashboard", true, createPanelDashboard()), new CC().growX());
		pMenu.add(createPanelItemMenu("analytics25x25.PNG", "Analytics", false, new JLabel("Analytics")), new CC().growX());
		pMenu.add(createPanelItemMenu("business25x25.PNG", "Business", false, new JLabel("Business")), new CC().growX());
		pMenu.add(createPanelItemMenu("company25x25.PNG", "My Company", false, createPanelMyCompany()), new CC().growX());
		pMenu.add(createPanelItemMenu("admin25x25.PNG", "Admin", false, new JLabel("Admin")), new CC().growX());

		pMenu.add(new JLabel(""), new CC().height("100%"));
		pMenu.add(createPanelItemCredits(), new CC().growX());
		
		return pMenu;
	}
	
	private Component createPanelItemCredits() {
		JPanel pCredits = createPanelItemMenu("help25x25.PNG", "Help / Credits", false, new JLabel("Help"));
		pCredits.setToolTipText("<html>This layout was inspired by an example presented in <br>"
				+ "<b style=\"color=#b8e8e4\">https://www.yummygum.com</b>.</html>");
		return pCredits;
	}

	private JPanel createPanelItemMenu(String icon, String text, boolean selected, JComponent component) {
		
		MouseListener mouseListener = new ItemMenuMouseListener(Color.decode("#f7f9fb"), panelContent, component);
		JPanel pItemMenu = createNonOpaquePanel(new LC().insets("12.5", "25", "12.5", "25").gridGapX("15"));
		pItemMenu.setBorder(new ParcialBorder().color(Color.WHITE).stroke(5).left());
		pItemMenu.add(new JLabel(IconUtils.getImageIcon(icon)));
		pItemMenu.add(createLabel(text, Color.decode("#5b7583"), 12f));
		pItemMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pItemMenu.addMouseListener(mouseListener);
		
		if(selected){
			MouseEvent e = new MouseEvent(pItemMenu, 0, 0, 0, 0, 0, 0, false);
			mouseListener.mousePressed(e);
		}
		return pItemMenu;
	}
	
	private JPanel createPanelDashboard() {
		JPanel pDashboard = new JPanel(new MigLayout(new LC().insetsAll("20").gridGap("20", "20").wrapAfter(3)));
		for (int i = 1; i <= 6; i++) {
			pDashboard.add(createCardDashboard(i), new CC().growY());
		}
		pDashboard.setOpaque(false);
		
		JPanel panelDash = new JPanel(new GridBagLayout());
		panelDash.setBackground(Color.decode("#f7f9fb"));
		panelDash.add(pDashboard);
		return panelDash;
	}
	
	private Component createCardDashboard(int index) {
		JPanel pCardDash = new JPanel(new MigLayout(new LC().insetsAll("20").wrapAfter(1)));
		pCardDash.setBackground(Color.WHITE);
		pCardDash.setBorder(new WebBorder());
		pCardDash.add(new JLabel(IconUtils.getImageIcon("item_dash"+index+"_50x50.PNG")), new CC().alignX("center").gapBottom("20"));
		pCardDash.add(createLabel("Item dashboard "+index, Color.decode("#04b7a8"), Font.BOLD, 12f), new CC().alignX("center"));
		pCardDash.add(createLabel("This is a simple text description for a ", Color.decode("#bdbdbf"), 12f), new CC().alignX("center"));
		pCardDash.add(createLabel("dashboard card. Dothing will happend", Color.decode("#bdbdbf"), 12f), new CC().alignX("center"));
		pCardDash.add(createLabel("when you click here, it's just a test.", Color.decode("#bdbdbf"), 12f), new CC().alignX("center"));
		pCardDash.add(createItemDashboardBtn(), new CC().alignX("center").gapTop("20").width("150").height("50"));
		pCardDash.setPreferredSize(new Dimension(290, 0));
		return pCardDash;
	}

	private Component createItemDashboardBtn() {
		JButton btn = new JButton("Button");
		btn.setOpaque(false);
		btn.setForeground(Color.decode("#5b7583"));
		btn.setBackground(Color.decode("#04b7a8"));
		return btn;
	}

	private JComponent createPanelMyCompany() {
		JPanel pContent = new JPanel(new MigLayout(new LC().insetsAll("25").gridGapY("25").wrapAfter(1)));
		pContent.setBackground(Color.decode("#f7f9fb"));
		pContent.add(createPanelInfos());
		pContent.add(createPanelBranch());
		return pContent;
	}

	private Component createPanelInfos() {
		
		JPanel pCompanyName = createNonOpaquePanel(new LC().insetsAll("0").gridGapX("15"));
		pCompanyName.add(new JLabel(IconUtils.getImageIcon("info_icon64x64.PNG")));
		pCompanyName.add(createLabelForPanel("COMPANY NAME", "Your Company Name"), new CC().width("100%").alignY("bottom"));
		
		int width = 320;
		JPanel pInfos = createPanelCardContent();
		pInfos.add(createPanelCardTitle("Company information"), new CC().spanX().wrap());
		pInfos.add(pCompanyName, new CC().width(width+""));
		pInfos.add(createLabelForPanel("DOMAIN", "http://domain.com"), new CC().width(width+"").alignY("bottom").wrap());
		pInfos.add(createLabelForPanel("CONTACT EMAIL", "contact@domain.com"), new CC().width(width+""));
		pInfos.add(createLabelForPanel("INVOICE EMAIL", "invoice@domain.com"), new CC().width(width+"").wrap());
		pInfos.add(createLabelForPanel("PROPERTIES", new JSpinner(new SpinnerNumberModel(0, 0, 9999, 1))), new CC().width(((width/2)-12.5)+"").split(2));
		pInfos.add(createLabelForPanel("EMPLOYEES", new JSpinner(new SpinnerNumberModel(0, 0, 9999, 1))), new CC().width(((width/2)-12.5)+"").gapLeft("25").wrap());
		pInfos.add(createPanelSaveButton(), new CC().spanX().growX());
		
		return pInfos;
	}
	
	private Component createPanelBranch() {
		
		String[] cityes = {"Rio de Janeiro", "São Paulo", "Florianópolis", "Porto Alegre", "Curitiba"};
		int width = 320;
		JPanel pBranch = createPanelCardContent();
		pBranch.add(createPanelCardTitle("Branch Information"), new CC().spanX().wrap());
		pBranch.add(createLabelForPanel("BRANCH ADDRESS", "Your full address"), new CC().width(width+""));
		pBranch.add(createLabelForPanel("BRANCH EMAIL", "branch@domain.com"), new CC().width(width+"").wrap());
		pBranch.add(createLabelForPanel("CITY", new JComboBox<String>(cityes)), new CC().width(((width/2)-12.5)+"").split(2));
		pBranch.add(createLabelForPanel("ZIP CODE", createZipTextField()), new CC().width(((width/2)-12.5)+"").gapLeft("25").wrap());
		pBranch.add(createPanelSaveButton(), new CC().spanX().growX());
		
		return pBranch;
	}
	
	private JPanel createPanelCardContent() {
		JPanel pCard = new JPanel(new MigLayout(new LC().insets("25", "25", "15", "25").gridGap("25", "25")));
		pCard.setBorder(new WebBorder(new Insets(0, 0, 0, 0)).color(Color.decode("#e1e6eb")).arcSize(5));
		return pCard;
	}
	
	private JFormattedTextField createZipTextField() {
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter("#####-###");
		} catch (ParseException e) {}
		JFormattedTextField ftf = new JFormattedTextField(mask);
		ftf.setText("00000000");
		return ftf;
	}
	
	private Component createPanelCardTitle(String text) {
		JPanel pCardTitle = createNonOpaquePanel(new LC().insetsAll("0").wrapAfter(1).gridGapY("5"));
		pCardTitle.add(createLabel(text, Color.decode("#304451"), Font.BOLD, 16f));
		pCardTitle.add(createLabel("There is a little line below this heading that explains what information you can put in this section.", Color.decode("#5b7583"), 12f));
		return pCardTitle;
	}
	
	private JPanel createPanelSaveButton() {
		JPanel pButton = createNonOpaquePanel(new LC().insets("15", "25", "0", "0").gridGapX("15").fill());
		pButton.setBorder(new ParcialBorder().color(Color.decode("#bac5cb")).top());
		pButton.add(createBtn("Save"), new CC().alignX("right"));
		return pButton;
	}

	private JButton createBtn(String text) {
		JButton btn = new JButton(text);
		btn.setBackground(Color.decode("#04b7a8"));
		btn.setForeground(Color.WHITE);
		btn.setBorder(new WebBorder(new Insets(10, 20, 10, 20)));
		btn.setFont(btn.getFont().deriveFont(Font.BOLD));
		return btn;
	}

	private Component createLabelForPanel(String text, String placeHolder) {
		return createLabelForPanel(text, new PlaceHolderTextField(placeHolder));
	}
	
	private Component createLabelForPanel(String text, JComponent comp) {
		JPanel pLabelFor = createNonOpaquePanel(new LC().insetsAll("0").gridGapY("5").wrapAfter(1));
		pLabelFor.add(createLabel(text, Color.decode("#bac5cb"), Font.BOLD, 11f));
		pLabelFor.add(comp, new CC().width("0:100%:"));
		return pLabelFor;
	}

	private JPanel createNonOpaquePanel(LC lc) {
		JPanel panelNonOpaque = new JPanel(new MigLayout(lc));
		panelNonOpaque.setOpaque(false);
		return panelNonOpaque;
	}

	private JComponent createScrollContent(JPanel panel) {
		JScrollPane scroll = new JScrollPane(panel);
		scroll.setBorder(new EmptyBorder(0, 0, 0, 0));
		scroll.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scroll.getVerticalScrollBar().setUnitIncrement(20);
		return scroll;
	}
	
	private JLabel createLabel(String text, Color fg, int type, float size) {
		JLabel label = new JLabel(text);
		label.setForeground(fg);
		label.setFont(label.getFont().deriveFont(type, size));
		return label;
	}
	
	private JLabel createLabel(String text, Color fg, float size) {
		return createLabel(text, fg, Font.PLAIN, size);
	}
	
	//----------LISTENERS
	
	public static class ItemMenuMouseListener extends MouseAdapter{
		
		private final Color mouseEnteredBgColor;
		private Boolean opaque;
		private Color mouseExitedBgColor;
		
		private final JPanel content;
		private final JComponent component;
		protected static Map<JPanel, Component> LAST_CLICKED = new HashMap<>();
		
		public ItemMenuMouseListener(Color mouseEnteredBgColor, JPanel content, JComponent component) {
			this.mouseEnteredBgColor = mouseEnteredBgColor;
			this.content = content;
			this.component = component;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JComponent comp = (JComponent) e.getComponent();
			if(opaque == null) opaque = comp.isOpaque();
			if(mouseExitedBgColor==null) mouseExitedBgColor = comp.getBackground();
			comp.setOpaque(true);
			comp.setBackground(mouseEnteredBgColor);
			comp.repaint();
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			JComponent comp = (JComponent) e.getComponent();
			comp.setOpaque(opaque);
			comp.setBackground(mouseExitedBgColor);
			comp.repaint();
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			JComponent last = getLastComponentClicked();
			if(last!=null){
				((ParcialBorder)last.getBorder()).setColor(Color.WHITE);
				last.repaint();
			}
			JComponent itemComp = (JComponent) e.getComponent();
			((ParcialBorder)itemComp.getBorder()).setColor(Color.decode("#04b7a8"));
			content.removeAll();
			content.add(component);
			content.revalidate();
			
			LAST_CLICKED.put(content, itemComp);
			itemComp.repaint();
		}
		
		public JComponent getLastComponentClicked(){
			return (JComponent)LAST_CLICKED.get(content);
		}
	}
	
}