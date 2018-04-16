package br.com.margel.weblaf.tests;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.ParseException;

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
	
	public ComplexFormTest(JFrame owner) {
		setLayout(new MigLayout(new LC().insetsAll("0").gridGap("0", "0")));
		add(createPanelProfile(), new CC().grow());
		add(createPanelCompanyName(), new CC().width("100%").growY().wrap());
		add(createPanelMenus(), new CC().height("100%").growX());
		add(createPanelContent(), new CC().grow());
		
		setTitle("ComplexForm Test");
		pack();
		setSize(new Dimension(getWidth()+20, Toolkit.getDefaultToolkit().getScreenSize().height-80));
		setMinimumSize(new Dimension(getWidth(), 600));
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
		JPanel pMenu = new JPanel(new MigLayout(new LC().wrapAfter(1).insets("12.5", "0", "0", "0").gridGapY("0")));
		pMenu.setBorder(new ParcialBorder().color(Color.decode("#e1e6eb")).right());
		
		pMenu.add(createPanelItemMenu("dashboard25x25.PNG", "Dashboard", "#5b7583", false));
		pMenu.add(createPanelItemMenu("analytics25x25.PNG", "Analytics", "#5b7583", false));
		pMenu.add(createPanelItemMenu("business25x25.PNG", "Business", "#5b7583", false));
		pMenu.add(createPanelItemMenu("company25x25.PNG", "My Company", "#04b7a8", true));
		pMenu.add(createPanelItemMenu("admin25x25.PNG", "Admin", "#5b7583", false));

		pMenu.add(new JLabel(""), new CC().height("100%"));
		pMenu.add(createPanelCredits());
		
		return pMenu;
	}
	
	private Component createPanelCredits() {
		JPanel pCredits = createPanelItemMenu("help25x25.PNG", "Help / Credits", "#5b7583", false);
		pCredits.setToolTipText("<html>This layout was inspired by an example presented in <br>"
				+ "<b style=\"color=#b8e8e4\">https://www.yummygum.com</b>.</html>");
		return pCredits;
	}

	private JPanel createPanelItemMenu(String icon, String text, String fg, boolean selected) {
		JPanel pItemMenu = createNonOpaquePanel(new LC().insets("12.5", "25", "12.5", "25").gridGapX("15"));
		pItemMenu.add(new JLabel(IconUtils.getImageIcon(icon)));
		pItemMenu.add(createLabel(text, Color.decode(fg), 12f));
		pItemMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		if(selected) pItemMenu.setBorder(new ParcialBorder().color(Color.decode(fg)).stroke(5).left());
		return pItemMenu;
	}
	
	private JComponent createPanelContent() {
		JPanel pContent = new JPanel(new MigLayout(new LC().insetsAll("25").gridGapY("25").wrapAfter(1)));
		pContent.setBackground(Color.decode("#f7f9fb"));
		pContent.add(createPanelInfos());
		pContent.add(createPanelBranch());
		return createScrollContent(pContent);
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
	
}