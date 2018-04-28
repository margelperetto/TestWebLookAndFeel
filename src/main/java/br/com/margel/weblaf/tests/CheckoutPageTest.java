package br.com.margel.weblaf.tests;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.MaskFormatter;

import br.com.margel.weblaf.WebTheme;
import br.com.margel.weblaf.borders.ParcialBorder;
import br.com.margel.weblaf.borders.WebBorder;
import br.com.margel.weblaf.utils.IconUtils;
import br.com.margel.weblaf.utils.LB;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class CheckoutPageTest extends JFrame {

	public CheckoutPageTest() {

		JPanel panelPrincipal = new JPanel(new MigLayout(new LC().insetsAll("20").gridGap("20", "20").fillX()));
		panelPrincipal.setOpaque(false);
		panelPrincipal.add(createTitleLabel(), new CC().alignX("center").spanX().wrap());
		panelPrincipal.add(createSubTitleLabel(), new CC().width("0:80%:").spanX().alignX("center").wrap());
		panelPrincipal.add(createPanelUserInfos(), new CC());
		panelPrincipal.add(createPanelCart(), new CC().alignY("top").wrap());
		panelPrincipal.add(new LB("© 2017-2018 Company Name").fg(Color.GRAY).font(16f), new CC().spanX().alignX("center").gapTop("80").wrap());

		JPanel panelScroll = new JPanel(new GridBagLayout());
		panelScroll.setBackground(Color.decode("#f7f9fb"));
		panelScroll.add(panelPrincipal);
		JScrollPane scroll = new JScrollPane(panelScroll);
		scroll.getVerticalScrollBar().setUnitIncrement(20);

		setLayout(new BorderLayout());
		add(scroll);

		setTitle("Checkout Test");
		setSize(new Dimension(1024, 700));
		setMinimumSize(new Dimension(900, 200));
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
	}

	private JPanel createPanelCart() {

		JPanel panelItens = new JPanel(new MigLayout(new LC().wrapAfter(1).gridGapY("0").insetsAll("0").fillX()));
		panelItens.setOpaque(true);
		panelItens.setBackground(Color.WHITE);
		panelItens.setBorder(new WebBorder(new Insets(1, 1, 1, 1)));
		panelItens.add(createPanelItem("Product Item 1", "$ 10,00", Color.BLACK, Color.GRAY, null), new CC().growX());
		panelItens.add(createPanelItem("Product Item 2", "$ 20,00", Color.BLACK, Color.GRAY, null), new CC().growX());
		panelItens.add(createPanelItem("Product Item 3", "$ 30,00", Color.BLACK, Color.GRAY, null), new CC().growX());
		panelItens.add(createPanelItem("Promo Code", "- $ 10,00", Color.GREEN.darker().darker(), Color.GREEN.darker(), new Color(241, 251, 241)), new CC().growX());
		panelItens.add(createTotalItem("$ 50,00"), new CC().growX());

		JButton btnPromoCode = new JButton("Redeem");
		btnPromoCode.setBackground(Color.decode("#6c757d"));
		btnPromoCode.setForeground(Color.WHITE);

		JPanel panelPromoCode = new JPanel(new MigLayout(new LC().fillX()));
		panelPromoCode.setOpaque(true);
		panelPromoCode.setBackground(Color.WHITE);
		panelPromoCode.setBorder(new WebBorder());
		panelPromoCode.add(new JLabel("Promo code"), new CC().wrap());
		panelPromoCode.add(new JTextField(), new CC().spanX().split().growX());
		panelPromoCode.add(btnPromoCode, new CC().growY());

		JPanel panelCart = new JPanel(new MigLayout(new LC()));
		panelCart.setOpaque(false);
		panelCart.add(new LB("Your cart").font(Font.BOLD, 24f), new CC());
		panelCart.add(createCartItemCountLabel(), new CC().width("30!").height("25!").alignY("center").alignX("right").wrap());
		panelCart.add(panelItens, new CC().width("300").spanX().wrap());
		panelCart.add(panelPromoCode, new CC().gapTop("10").spanX().growX());

		return panelCart;
	}

	private Component createPanelItem(String productName, String price, Color fg1, Color fg2, Color bg) {
		JLabel labelProduct = new JLabel(productName);
		labelProduct.setFont(labelProduct.getFont().deriveFont(16f));
		labelProduct.setForeground(fg1);

		JLabel labelPrice = new JLabel(price);
		labelPrice.setFont(labelProduct.getFont().deriveFont(16f));
		labelPrice.setForeground(fg2);

		JLabel labelDescription = new JLabel("Product description");
		labelDescription.setFont(labelProduct.getFont().deriveFont(14f));
		labelDescription.setForeground(fg2);

		JPanel panelItem = new JPanel(new MigLayout(new LC().insetsAll("15").gridGapY("10").fillX()));
		if (bg != null) {
			panelItem.setOpaque(true);
			panelItem.setBackground(bg);
			labelDescription.setText("Promo description");
		} else {
			panelItem.setOpaque(false);
		}
		panelItem.add(labelProduct);
		panelItem.add(labelPrice, new CC().alignX("right").wrap());
		panelItem.add(labelDescription, new CC().spanX());
		panelItem.setBorder(new ParcialBorder().bottom().color(WebTheme.TEXT_FIELD_BORDER_COLOR));
		return panelItem;
	}

	private Component createTotalItem(String price) {
		JLabel labelTotal = new JLabel("TOTAL (USD)");
		labelTotal.setFont(labelTotal.getFont().deriveFont(16f));
		labelTotal.setForeground(Color.BLACK);

		JLabel labelTotalPrice = new JLabel(price);
		labelTotalPrice.setForeground(Color.BLACK);
		labelTotalPrice.setFont(labelTotal.getFont().deriveFont(Font.BOLD, 16f));

		JPanel panelTotal = new JPanel(new MigLayout(new LC().insetsAll("15").fillX()));
		panelTotal.setOpaque(false);
		panelTotal.add(labelTotal);
		panelTotal.add(labelTotalPrice, new CC().alignX("right"));
		return panelTotal;
	}

	private JPanel createPanelUserInfos() {
		JPanel panelUserInfos = new JPanel(new MigLayout(new LC().gridGapX("20")));
		panelUserInfos.setOpaque(false);

		panelUserInfos.add(new LB("Billing address").font(Font.BOLD, 24f), new CC().spanX().wrap());

		panelUserInfos.add(new JLabel("First name"), new CC().gapTop("20"));
		panelUserInfos.add(new JLabel("Last name"), new CC().gapTop("20").wrap());

		panelUserInfos.add(new JTextField(), new CC().width("300"));
		panelUserInfos.add(new JTextField(), new CC().width("300").wrap());

		panelUserInfos.add(new JLabel("Username"), new CC().gapTop("20").wrap());
		panelUserInfos.add(new JTextField(), new CC().growX().spanX().wrap());

		panelUserInfos.add(new JLabel("Email"), new CC().gapTop("20").spanX().split());
		panelUserInfos.add(new LB(" (Optional)").fg(new Color(100, 150, 200)),new CC().gapTop("20").gapLeft("0").wrap());
		panelUserInfos.add(new JTextField(), new CC().growX().spanX().wrap());

		panelUserInfos.add(new JLabel("Address"), new CC().gapTop("20").wrap());
		panelUserInfos.add(new JTextField(), new CC().growX().spanX().wrap());

		panelUserInfos.add(new JLabel("Address2"), new CC().gapTop("20").wrap());
		panelUserInfos.add(new JTextField(), new CC().growX().spanX().wrap());

		JPanel panelLocale = new JPanel(new MigLayout(new LC().wrapAfter(3).fillX().insetsAll("0").gridGapX("20")));
		panelLocale.setOpaque(false);
		panelLocale.add(new JLabel("Country"), new CC());
		panelLocale.add(new JLabel("State"), new CC());
		panelLocale.add(new JLabel("Zip"), new CC());
		panelLocale.add(new JComboBox<>(new String[] {"", "Brazil", "Other" }), new CC().growX());
		panelLocale.add(new JComboBox<>(new String[] {"", "Rio Grande do Sul", "Santa Cataria", "Parana", "São Paulo", "Rio de Janeiro" }), new CC().growX());
		panelLocale.add(createZipTextField(), new CC().minWidth("110").growX());

		panelUserInfos.add(panelLocale, new CC().growX().gapTop("20").spanX());
		panelUserInfos.add(new JSeparator(), new CC().gapTop("20").growX().spanX().wrap());
		panelUserInfos.add(createCheck("Shipping address is the same as my billing address"),new CC().spanX().gapTop("20").wrap());
		panelUserInfos.add(createCheck("Save this information for next time"), new CC().spanX().gapTop("10").wrap());
		panelUserInfos.add(new JSeparator(), new CC().gapTop("20").growX().spanX().wrap());

		panelUserInfos.add(new LB("Payment").font(Font.BOLD, 24f), new CC().gapTop("20").wrap());
		ButtonGroup bg = new ButtonGroup();
		panelUserInfos.add(createPaymentCheck("Credit Card", true, bg), new CC().spanX().gapTop("10").wrap());
		panelUserInfos.add(createPaymentCheck("Debit card", false, bg), new CC().spanX().gapTop("10").wrap());
		panelUserInfos.add(createPaymentCheck("Paypal", false, bg), new CC().spanX().gapTop("10").wrap());

		panelUserInfos.add(new JLabel("Name on card"), new CC().gapTop("20"));
		panelUserInfos.add(new JLabel("Credit card number"), new CC().gapTop("20").wrap());
		panelUserInfos.add(new JTextField(), new CC().growX());
		panelUserInfos.add(new JTextField(), new CC().growX().wrap());
		panelUserInfos.add(new LB("Full name as displayed on card").fg(Color.GRAY), new CC().spanX().wrap());

		JPanel panelCardInfos = new JPanel(new MigLayout(new LC().wrapAfter(2).insetsAll("0").gridGapX("20")));
		panelCardInfos.setOpaque(false);
		panelCardInfos.add(new JLabel("Expiration (month / year)"), new CC());
		panelCardInfos.add(new JLabel("CVV"), new CC());
		panelCardInfos.add(new JSpinner(new SpinnerListModel(new DateFormatSymbols(Locale.US).getMonths())),new CC().split(2));
		panelCardInfos.add(createSpinnerYear(), new CC());
		panelCardInfos.add(new JTextField(), new CC().width("200"));

		panelUserInfos.add(panelCardInfos, new CC().growX().gapTop("20").spanX());
		panelUserInfos.add(new JSeparator(), new CC().gapTop("20").growX().spanX().wrap());

		JButton btnCheckout = new JButton("Continue to checkout");
		btnCheckout.setFont(btnCheckout.getFont().deriveFont(20f));
		panelUserInfos.add(btnCheckout, new CC().gapTop("20").growX().spanX());

		return panelUserInfos;
	}

	private Component createSpinnerYear() {
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(2020, 2017, 2999, 1));
		spinner.setEditor(new JSpinner.NumberEditor(spinner, "0000"));
		return spinner;
	}

	private Component createZipTextField() {
		try {
			return new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e) {}
		return new JTextField("Create zip mask error!");
	}

	private Component createCheck(String text) {
		JCheckBox check = new JCheckBox(text);
		check.setFont(check.getFont().deriveFont(16f));
		return check;
	}

	private Component createPaymentCheck(String text, boolean selected, ButtonGroup bg) {
		JRadioButton rb = new JRadioButton(text, selected);
		rb.setFont(rb.getFont().deriveFont(16f));
		bg.add(rb);
		return rb;
	}

	private Component createSubTitleLabel() {
		return new LB().html("<p style=\"text-align: center;\">"
						+ "Below is an example form using the WebLookAndFeel styles. "
						+ "The form was copied from an example of Bootstrap page, and was basically built with MigLayout. "
						+ "Note: It's just a demonstration, the buttons will not do anything."
						+ "</p>").font(16f);
	}

	private Component createTitleLabel() {
		return new LB("Checkout form")
				.icon(IconUtils.getImageIcon("checkout.png"))
				.font(Font.BOLD, 32f)
				.textPos(JLabel.CENTER, JLabel.BOTTOM);
	}
	
	private JLabel createCartItemCountLabel() {
		return new LB("3")
				.hAlign(JLabel.CENTER)
				.border(new WebBorder(1).color(Color.DARK_GRAY))
				.font(Font.BOLD, 24f)
				.bg(Color.DARK_GRAY)
				.fg(Color.WHITE);
	}

}