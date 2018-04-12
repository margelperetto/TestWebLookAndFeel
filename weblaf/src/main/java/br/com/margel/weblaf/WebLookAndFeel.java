package br.com.margel.weblaf;

import java.awt.Insets;

import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

import br.com.margel.weblaf.uis.UIWebFileChooser;
import br.com.margel.weblaf.uis.UIWebButton;
import br.com.margel.weblaf.uis.UIWebCheckBox;
import br.com.margel.weblaf.uis.UIWebComboBox;
import br.com.margel.weblaf.uis.UIWebFormattedTextField;
import br.com.margel.weblaf.uis.UIWebLabel;
import br.com.margel.weblaf.uis.UIWebOptionPane;
import br.com.margel.weblaf.uis.UIWebPanel;
import br.com.margel.weblaf.uis.UIWebPasswordField;
import br.com.margel.weblaf.uis.UIWebProgressBar;
import br.com.margel.weblaf.uis.UIWebRadioButton;
import br.com.margel.weblaf.uis.UIWebRootPane;
import br.com.margel.weblaf.uis.UIWebScrollBar;
import br.com.margel.weblaf.uis.UIWebScrollPane;
import br.com.margel.weblaf.uis.UIWebSeparator;
import br.com.margel.weblaf.uis.UIWebSlider;
import br.com.margel.weblaf.uis.UIWebSpinner;
import br.com.margel.weblaf.uis.UIWebSplitPane;
import br.com.margel.weblaf.uis.UIWebTabbedPane;
import br.com.margel.weblaf.uis.UIWebTable;
import br.com.margel.weblaf.uis.UIWebTableHeader;
import br.com.margel.weblaf.uis.UIWebTextArea;
import br.com.margel.weblaf.uis.UIWebTextField;
import br.com.margel.weblaf.uis.UIWebToggleButton;
import br.com.margel.weblaf.utils.IconUtils;

@SuppressWarnings("serial")
public class WebLookAndFeel extends MetalLookAndFeel{

	@Override
	protected void initClassDefaults(UIDefaults table) {
		super.initClassDefaults(table);

		String metalPackageName = "javax.swing.plaf.metal.";

		Object[] uiDefaults = {
				"DesktopIconUI", metalPackageName + "MetalDesktopIconUI",
				"InternalFrameUI", metalPackageName + "MetalInternalFrameUI",
				"PopupMenuSeparatorUI", metalPackageName + "MetalPopupMenuSeparatorUI",
				"ToolBarUI", metalPackageName + "MetalToolBarUI",
				"ToolTipUI", metalPackageName + "MetalToolTipUI",
				"TreeUI", metalPackageName + "MetalTreeUI",
				
				"RootPaneUI", UIWebRootPane.class.getCanonicalName(),
				"TextFieldUI", UIWebTextField.class.getCanonicalName(),
				"PasswordFieldUI", UIWebPasswordField.class.getCanonicalName(),
				"ButtonUI", UIWebButton.class.getCanonicalName(),
				"LabelUI", UIWebLabel.class.getCanonicalName(),
				"PanelUI", UIWebPanel.class.getCanonicalName(),
				"CheckBoxUI", UIWebCheckBox.class.getCanonicalName(),
				"RadioButtonUI", UIWebRadioButton.class.getCanonicalName(),
				"ComboBoxUI", UIWebComboBox.class.getCanonicalName(),
				"ScrollBarUI", UIWebScrollBar.class.getCanonicalName(),
				"ScrollPaneUI", UIWebScrollPane.class.getCanonicalName(),
				"SeparatorUI", UIWebSeparator.class.getCanonicalName(),
				"FormattedTextFieldUI", UIWebFormattedTextField.class.getCanonicalName(),
				"ToggleButtonUI", UIWebToggleButton.class.getCanonicalName(),
				"SpinnerUI", UIWebSpinner.class.getCanonicalName(),
				"SliderUI", UIWebSlider.class.getCanonicalName(),
				"ProgressBarUI", UIWebProgressBar.class.getCanonicalName(),
				"TabbedPaneUI", UIWebTabbedPane.class.getCanonicalName(),
				"TextAreaUI", UIWebTextArea.class.getCanonicalName(),
				"SplitPaneUI", UIWebSplitPane.class.getCanonicalName(),
				"OptionPaneUI", UIWebOptionPane.class.getCanonicalName(),
				"TableHeaderUI", UIWebTableHeader.class.getCanonicalName(),
				"TableUI", UIWebTable.class.getCanonicalName(),
				"FileChooserUI", UIWebFileChooser.class.getCanonicalName(),

				/*
				"CheckBoxMenuItemUI", UIMinimalistCheckBoxMenuItem.class.getCanonicalName(),
				"RadioButtonMenuItemUI", UIMinimalistRadioButtonMenuItem.class.getCanonicalName(),
				*/
		};
		table.putDefaults(uiDefaults);
		
		UIManager.put("TabbedPane.tabInsets",new Insets(5, 8, 3, 8));
		UIManager.put("TabbedPane.tabAreaInsets",new Insets(3, 5, 0, 5));
		UIManager.put("TabbedPane.font", WebTheme.TABBED_FONT);
		
		UIManager.put("TextField.selectionBackground", WebTheme.TEXT_FIELD_SELECTION_BG);
		UIManager.put("TextField.selectionForeground", WebTheme.TEXT_FIELD_SELECTION_FG);
		
		UIManager.put("TextPane.font", WebTheme.TEXTPANE_FONT);
		UIManager.put("EditorPane.font", WebTheme.EDITORPANE_FONT);
		
		UIManager.put("PopupMenu.background", WebTheme.POPUPMENU_BG);
		UIManager.put("PopupMenu.border", WebTheme.POPUPMENU_BORDER);
		
		UIManager.put("OptionPane.errorIcon",IconUtils.getImageIcon("error_icon.png"));
		UIManager.put("OptionPane.questionIcon",IconUtils.getImageIcon("question_icon.png"));
		UIManager.put("OptionPane.warningIcon",IconUtils.getImageIcon("warning_icon.png"));
		UIManager.put("OptionPane.informationIcon",IconUtils.getImageIcon("information_icon.png"));
		UIManager.put("OptionPane.background", WebTheme.OPTIONPANE_BG);
		UIManager.put("OptionPane.messageForeground", WebTheme.TEXT_FIELD_FG);
		
		UIManager.put("Tree.openIcon", WebTheme.TREE_OPEN_ICON);
		UIManager.put("Tree.closedIcon", WebTheme.TREE_CLOSE_ICON);
		UIManager.put("Tree.leafIcon", WebTheme.TREE_LEAF_ICON);
		UIManager.put("Tree.expandedIcon", WebTheme.TREE_EXPANDED_ICON);
		UIManager.put("Tree.collapsedIcon", WebTheme.TREE_COLLAPSED_ICON);
		UIManager.put("Tree.hash", WebTheme.TREE_HASH);
		UIManager.put("Tree.selectionBackground", WebTheme.TREE_SELECTION_BG);
		UIManager.put("Tree.selectionForeground", WebTheme.TREE_SELECTION_FG);
		UIManager.put("Tree.selectionBorderColor", WebTheme.TREE_SELECTION_BORDER_COLOR);
		UIManager.put("Tree.background", WebTheme.TREE_BG);
		UIManager.put("Tree.textBackground", WebTheme.TREE_TEXT_BG);
		UIManager.put("Tree.line", WebTheme.TREE_LINE);
		UIManager.put("Tree.textForeground", WebTheme.TREE_TEXT_FG);
		UIManager.put("Tree.foreground", WebTheme.TREE_FG);
		
		UIManager.put("TitledBorder.border", WebTheme.TITLEDBORDER_BORDER);
		UIManager.put("TitledBorder.font", WebTheme.TITLEDBORDER_FONT);
		UIManager.put("TitledBorder.titleColor", WebTheme.TITLEDBORDER_FG);
		
		UIManager.put("Table.alternateRowColor", WebTheme.TABLE_ALTERNATE_ROW_COLOR);
		UIManager.put("Table.selectionBackground", WebTheme.TABLE_SELECTION_BG);
		UIManager.put("Table.selectionForeground", WebTheme.TABLE_SELECTION_FG);
		UIManager.put("Table.gridColor", WebTheme.TABLE_GRIDCOLOR);
		UIManager.put("Table.font", WebTheme.TABLE_FONT);
		UIManager.put("TableHeader.font", WebTheme.TABLE_HEADER_FONT);

		UIManager.put("TableHeader.background", WebTheme.TABLE_HEADER_BG);
		UIManager.put("TableHeader.foreground", WebTheme.TABLE_HEADER_FG);
		
		UIManager.put("FileChooser.upFolderIcon", WebTheme.FILECHOOSER_UP_ICON);
		UIManager.put("FileChooser.homeFolderIcon", WebTheme.FILECHOOSER_HOME_ICON);
		UIManager.put("FileChooser.newFolderIcon", WebTheme.FILECHOOSER_NEWFOLDER_ICON);
		UIManager.put("FileChooser.listViewIcon", WebTheme.FILECHOOSER_LIST_VIEW_ICON);
		UIManager.put("FileChooser.detailsViewIcon", WebTheme.FILECHOOSER_DETAIL_VIEW_ICON);

		/*

		List<Object> gradient = new ArrayList<Object>();
		gradient.add(new Float(0.3f));
		gradient.add(new Float(0f));
		gradient.add(MinimalistTheme.MENUBAR_GRADIENTE);
		gradient.add(MinimalistTheme.MENUBAR_GRADIENTE);
		gradient.add(MinimalistTheme.MENUBAR_GRADIENTE);

		UIManager.put("MenuBar.gradient", gradient);
		UIManager.put("MenuBar.borderColor", MinimalistTheme.MENUBAR_BORDER_COLOR);
		UIManager.put("MenuBar.border", MinimalistTheme.MENUBAR_BORDER);

		UIManager.put("Menu.foreground", MinimalistTheme.MENU_FG);
		UIManager.put("Menu.background", MinimalistTheme.MENU_BG);
		UIManager.put("Menu.selectionBackground", MinimalistTheme.MENU_SELECTION_BG);
		UIManager.put("Menu.selectionForeground", MinimalistTheme.MENU_SELECTION_FG);
		UIManager.put("Menu.borderPainted", MinimalistTheme.MENU_BORDER_PAINTED);
		UIManager.put("Menu.acceleratorForeground", MinimalistTheme.MENU_ACCELERATOR_FG);
		UIManager.put("Menu.acceleratorSelectionForeground", MinimalistTheme.MENU_SELECTION_FG);
		UIManager.put("Menu.font", MinimalistTheme.MENU_FONT);
		UIManager.put("Menu.border", MinimalistTheme.MENU_BORDER);

		UIManager.put("MenuItem.background", MinimalistTheme.MENUITEM_BG);
		UIManager.put("MenuItem.foreground", MinimalistTheme.MENUITEM_FG);
		UIManager.put("MenuItem.font", MinimalistTheme.MENUITEM_FONT);
		UIManager.put("MenuItem.selectionBackground", MinimalistTheme.MENUITEM_SELECTION_BG);
		UIManager.put("MenuItem.selectionForeground", MinimalistTheme.MENUITEM_FG);
		UIManager.put("MenuItem.acceleratorForeground", MinimalistTheme.MENUITEM_ACCELERATOR_FG);
		UIManager.put("MenuItem.acceleratorSelectionForeground", MinimalistTheme.MENUITEM_ACCELERATOR_SELECTION_FG);
		UIManager.put("MenuItem.borderPainted", MinimalistTheme.MENUITEM_BORDER_PAINTED);
		UIManager.put("MenuItem.border", MinimalistTheme.MENUITEM_BORDER);

		UIManager.put("CheckBoxMenuItem.background", MinimalistTheme.CHECKBOX_MENUITEM_BG);
		UIManager.put("CheckBoxMenuItem.foreground", MinimalistTheme.CHECKBOX_MENUITEM_FG);
		UIManager.put("CheckBoxMenuItem.font", MinimalistTheme.CHECKBOX_MENUITEM_FONT);
		UIManager.put("CheckBoxMenuItem.selectionBackground", MinimalistTheme.CHECKBOX_MENUITEM_SELECTION_BG);
		UIManager.put("CheckBoxMenuItem.selectionForeground", MinimalistTheme.CHECKBOX_MENUITEM_SELECTION_FG);
		UIManager.put("CheckBoxMenuItem.borderPainted", MinimalistTheme.CHECKBOX_MENUITEM_BORDER_PAINTED);
		UIManager.put("CheckBoxMenuItem.acceleratorForeground", MinimalistTheme.CHECKBOX_MENUITEM_ACCELERATOR_FG);
		UIManager.put("CheckBoxMenuItem.acceleratorSelectionForeground", MinimalistTheme.CHECKBOX_MENUITEM_ACCELERATOR_SELECTION_FG);
		UIManager.put("CheckBoxMenuItem.border", MinimalistTheme.CHECKBOX_MENUITEM_BORDER);

		UIManager.put("RadioButtonMenuItem.background", MinimalistTheme.RADIOBUTTON_MENUITEM_BG);
		UIManager.put("RadioButtonMenuItem.foreground", MinimalistTheme.RADIOBUTTON_MENUITEM_FG);
		UIManager.put("RadioButtonMenuItem.font", MinimalistTheme.RADIOBUTTON_MENUITEM_FONT);
		UIManager.put("RadioButtonMenuItem.selectionBackground", MinimalistTheme.RADIOBUTTON_MENUITEM_SELECTION_BG);
		UIManager.put("RadioButtonMenuItem.selectionForeground", MinimalistTheme.RADIOBUTTON_MENUITEM_SELECTION_FG);
		UIManager.put("RadioButtonMenuItem.borderPainted", MinimalistTheme.RADIOBUTTON_MENUITEM_BORDER_PAINTED);
		UIManager.put("RadioButtonMenuItem.acceleratorForeground", MinimalistTheme.RADIOBUTTON_MENUITEM_ACCELERATOR_FG);
		UIManager.put("RadioButtonMenuItem.acceleratorSelectionForeground", MinimalistTheme.RADIOBUTTON_MENUITEM_ACCELERATOR_SELECTION_FG);
		UIManager.put("RadioButtonMenuItem.border", MinimalistTheme.RADIOBUTTON_MENUITEM_BORDER);

		*/
	}
	
}