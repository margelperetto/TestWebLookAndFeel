package br.com.margel.weblaf;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import br.com.margel.weblaf.borders.WebBorder;
import br.com.margel.weblaf.utils.IconUtils;

public interface WebTheme {

	Font TEXT_FIELD_FONT = new Font("Arial", Font.PLAIN, 16);
	Color TEXT_FIELD_BG = Color.WHITE;
	Color TEXT_FIELD_FG = Color.DARK_GRAY;
	Color TEXT_FIELD_FOCUS_COLOR = Color.decode("#80bdff");
	Color TEXT_FIELD_BORDER_COLOR = Color.decode("#ced4da");
	Color TEXT_FIELD_SELECTION_BG = Color.DARK_GRAY;
	Color TEXT_FIELD_SELECTION_FG = Color.WHITE;
	
	Color LIST_BG = Color.WHITE;
	Color LIST_FG = Color.DARK_GRAY;
	Color LIST_SELECTION_BG = new Color(230, 240, 240);
	Color LIST_SELECTION_FG = Color.BLACK;
	Font LIST_FONT = new Font("Arial", Font.PLAIN, 12);
	
	Color TEXTAREA_FG = Color.DARK_GRAY;
	Color TEXTAREA_BG = Color.WHITE;
	Font TEXTAREA_FONT = new Font("Arial", Font.PLAIN, 12);
	Insets TEXTAREA_MARGIN = new Insets(10, 10, 10, 10);
	
	Font TEXTPANE_FONT = new Font("Arial", Font.PLAIN, 12);
	
	Font EDITORPANE_FONT = new Font("Arial", Font.PLAIN, 12);
	
	Color POPUPMENU_BG = Color.CYAN.darker();
	Color POPUPMENU_BORDER = Color.CYAN.darker();
	
	Color BUTTON_BG = Color.decode("#007bff");
	Color BUTTON_FG = new Color(245, 245, 245);
	Font BUTTON_FONT = new Font("Arial", Font.BOLD, 12);
	
	Font LABEL_FONT = new Font("Arial", Font.PLAIN, 12);
	Color LABEL_FG = Color.DARK_GRAY;
	
	Color PANEL_BG = Color.decode("#f8f9fa");

	Color OPTIONPANE_BG = Color.WHITE;
	
	Color CHECK_BG = Color.WHITE;
	Color CHECK_FG = Color.DARK_GRAY;
	Font CHECK_FONT = new Font("Arial", Font.PLAIN, 12);

	Color RADIO_BG = Color.WHITE;
	Color RADIO_FG = Color.DARK_GRAY;
	Font RADIO_FONT = new Font("Arial", Font.PLAIN, 12);
	
	Font COMBO_FONT = new Font("Arial", Font.PLAIN, 16);
	Color COMBO_FG = Color.DARK_GRAY;
	Color COMBO_BORDER = Color.decode("#ced4da");
	Color COMBO_BUTTON_BG = Color.DARK_GRAY;
	Color COMBO_SELECT_FG = Color.CYAN.darker();
	Color COMBO_SELECT_BG = new Color(240, 240, 240);
	Color COMBO_FOCO = Color.decode("#80bdff");
	Color COMBO_BG = Color.WHITE;
	Color COMBO_ARROW = Color.DARK_GRAY;
	
	Color SCROLLBAR_THUMB = Color.LIGHT_GRAY;
	Color SCROLLBAR_THUMB_LINES = Color.BLACK;
	Color SCROLLBAR_TRACK = Color.WHITE;
	Color SCROLLBAR_ARROW = Color.DARK_GRAY;
	
	Color SCROLL_BORDER = Color.decode("#ced4da");
	
	Color SEPARATOR_FOREGROUND = Color.decode("#ced4da");
	
	Color SPINNER_ARROW = Color.DARK_GRAY;
	
	Color SLIDER_BUTTON_BG = Color.DARK_GRAY;
	Color SLIDER_BUTTON_FG = Color.DARK_GRAY;
	Color SLIDER_FOCO = Color.decode("#80bdff");
	
	Color PROGRESS_BG = Color.WHITE;
	Color PROGRESS_FG = Color.DARK_GRAY;
	
	Color TABBED_UNSELECT = Color.WHITE;
	Color TABBED_SELECT = Color.WHITE;
	Color TABBED_SELECT_BORDER = Color.GRAY;
	Color TABBED_UNSELECT_BORDER = Color.WHITE;
	Color TABBED_FOCUS = Color.decode("#80bdff");
	Color TABBED_FG = Color.DARK_GRAY;
	Color TABBED_CONTENT_BORDER = Color.LIGHT_GRAY;
	Color TABBED_SEL_BORDER_UNDERLINE = Color.CYAN.darker();;
	Font TABBED_FONT = new Font("Arial", Font.PLAIN, 12);
	
	Color SEPARATOR_COLOR = Color.LIGHT_GRAY;
	
	Border TITLEDBORDER_BORDER = new WebBorder(new Insets(2, 10, 2, 10));
	Font TITLEDBORDER_FONT = new Font("Arial", Font.PLAIN, 16);
	Color TITLEDBORDER_FG = Color.DARK_GRAY;
	
	Color TREE_HASH = new Color(215, 225, 245);
	Color TREE_LINE = Color.LIGHT_GRAY;
	Color TREE_SELECTION_BG =  Color.CYAN.darker();
	Color TREE_SELECTION_FG = Color.WHITE;
	Color TREE_SELECTION_BORDER_COLOR = Color.LIGHT_GRAY;
	Color TREE_BG = Color.WHITE;
	Color TREE_FG = Color.BLACK;
	Color TREE_TEXT_BG = Color.WHITE;
	Color TREE_TEXT_FG = Color.BLACK;
	ImageIcon TREE_OPEN_ICON = IconUtils.getImageIcon("open_folder_yellow20x20.png");
	ImageIcon TREE_CLOSE_ICON = IconUtils.getImageIcon("close_folder_yellow20x20.png");
	ImageIcon TREE_LEAF_ICON = IconUtils.getImageIcon("leaf.png");
	ImageIcon TREE_EXPANDED_ICON = IconUtils.getImageIcon("minus10x10.png");
	ImageIcon TREE_COLLAPSED_ICON = IconUtils.getImageIcon("plus10x10.png");
	
	Font TABLE_FONT = new Font("Arial", Font.PLAIN, 12);
	Color TABLE_GRIDCOLOR = Color.LIGHT_GRAY;
	Color TABLE_CEL_FOCUS = Color.BLACK;
	Color TABLE_SELECTION_FG = Color.BLACK;
	Color TABLE_SELECTION_BG = Color.LIGHT_GRAY;
	Color TABLE_ALTERNATE_ROW_COLOR = new Color(245, 245, 245);
	
	Font TABLE_HEADER_FONT = new Font("Arial", Font.BOLD, 12);
	Color TABLE_HEADER_BG = Color.WHITE;
	Color TABLE_HEADER_FG = Color.BLACK;
	
	ImageIcon FILECHOOSER_DIR_ICON = IconUtils.getImageIcon("close_folder_yellow20x20.png");
	ImageIcon FILECHOOSER_FILE_ICON = IconUtils.getImageIcon("file20x20.png");
	ImageIcon FILECHOOSER_COMPUTER_ICON = IconUtils.getImageIcon("computer20x20.png");
	ImageIcon FILECHOOSER_HARD_DRIVE_ICON = IconUtils.getImageIcon("storage20x20.png");
	ImageIcon FILECHOOSER_FLOPPY_ICON = IconUtils.getImageIcon("floppy20x20.png");
	ImageIcon FILECHOOSER_UP_ICON = IconUtils.getImageIcon("folder_up25x25.png");
	ImageIcon FILECHOOSER_NEWFOLDER_ICON = IconUtils.getImageIcon("new_folder25x25.png");
	ImageIcon FILECHOOSER_HOME_ICON = IconUtils.getImageIcon("desktop25x25.png");
	ImageIcon FILECHOOSER_LIST_VIEW_ICON = IconUtils.getImageIcon("list_view25x25.png");
	ImageIcon FILECHOOSER_DETAIL_VIEW_ICON = IconUtils.getImageIcon("detail_view25x25.png");
	ImageIcon FILECHOOSER_VIEW_MENU_ICON = IconUtils.getImageIcon("detail_view25x25.png");
	
	Color TOOLTIP_BG = Color.WHITE;
	Color TOOLTIP_FG = Color.BLACK;
	Font TOOLTIP_FONT = new Font("Arial", Font.PLAIN, 12);
	Border TOOLTIP_BORDER = new WebBorder().arcSize(2);
	
// REFACTOR
//------------------------------------------------------------------------------------------------	
	
	/*PADRÕES GLOBAIS - APENAS AJUDAM A PADRONIZAR, MAS NÃO SÃO USADOS NOS COMPONENTES*/
	//--------------------------------------------------------------------------------------------
	public static Color BG = Color.WHITE;
	public static Color FG = Color.BLACK;
	public static Color FG2 = Color.DARK_GRAY;
	public static Color SHADOW = Color.GRAY;
	public static Color LINES = Color.LIGHT_GRAY;
	public static Color FOCUS = Color.CYAN.darker();
	public static Color SELECTED = Color.GREEN.darker();
	public static Font FONT_GLOBAL = new Font("Arial", Font.PLAIN, 12);
    //----------------------------------------------------------------------------------------------
	
	
	public static Border MENUS_BORDER = new EmptyBorder(6, 5, 5, 5);
	public static Color MENUITENS_BG = FG2;
	public static Color MENUITENS_FG = BG;
	public static Color MENUITENS_SELECT_BG = SELECTED.darker();
	public static Color MENUITENS_SELECT_FG = BG;
	
	public static Color MENUBAR_GRADIENTE =  FOCUS.darker();
	public static Color MENUBAR_BORDER_COLOR = FOCUS.darker();
	public static Border MENUBAR_BORDER = new EmptyBorder(0, 0, 0, 0);
	
	public static Color MENU_FG = BG;
	public static Color MENU_BG = FOCUS.darker();
	public static Color MENU_SELECTION_BG = FOCUS;
	public static Color MENU_SELECTION_FG = BG;
	public static Color MENU_ACCELERATOR_FG = BG;
	public static Color MENU_ACCELERATOR_SELECTION_FG = SELECTED;
	public static Boolean MENU_BORDER_PAINTED = Boolean.FALSE;
	public static Font MENU_FONT = FONT_GLOBAL;
	public static Border MENU_BORDER = MENUS_BORDER;
	
	public static Color MENUITEM_BG = MENUITENS_BG;
	public static Color MENUITEM_FG = MENUITENS_FG;
	public static Color MENUITEM_SELECTION_BG = MENUITENS_SELECT_BG;
	public static Color MENUITEM_SELECTION_FG = MENUITENS_FG;
	public static Color MENUITEM_ACCELERATOR_FG = BG;
	public static Color MENUITEM_ACCELERATOR_SELECTION_FG = BG;
	public static Boolean MENUITEM_BORDER_PAINTED = Boolean.FALSE;
	public static Border MENUITEM_BORDER = MENUS_BORDER;
	public static Font MENUITEM_FONT = FONT_GLOBAL;

	public static Color CHECKBOX_MENUITEM_BG = MENUITENS_BG;
	public static Color CHECKBOX_MENUITEM_FG = MENUITENS_FG;
	public static Color CHECKBOX_MENUITEM_SELECT = BG;
	public static Color CHECKBOX_MENUITEM_SELECTION_BG = MENUITENS_SELECT_BG;
	public static Color CHECKBOX_MENUITEM_SELECTION_FG = MENUITENS_FG;
	public static Color CHECKBOX_MENUITEM_ACCELERATOR_FG = FOCUS;
	public static Color CHECKBOX_MENUITEM_ACCELERATOR_SELECTION_FG = BG;
	public static Boolean CHECKBOX_MENUITEM_BORDER_PAINTED = Boolean.FALSE;
	public static Font CHECKBOX_MENUITEM_FONT = FONT_GLOBAL;
	public static Border CHECKBOX_MENUITEM_BORDER = MENUS_BORDER;
	
	public static Color RADIOBUTTON_MENUITEM_BG = MENUITENS_BG;
	public static Color RADIOBUTTON_MENUITEM_FG = MENUITENS_FG;
	public static Color RADIOBUTTON_MENUITEM_SELECT = BG;
	public static Color RADIOBUTTON_MENUITEM_SELECTION_BG = MENUITENS_BG;
	public static Color RADIOBUTTON_MENUITEM_SELECTION_FG = MENUITENS_FG;
	public static Color RADIOBUTTON_MENUITEM_ACCELERATOR_FG = FOCUS;
	public static Color RADIOBUTTON_MENUITEM_ACCELERATOR_SELECTION_FG = BG;
	public static Boolean RADIOBUTTON_MENUITEM_BORDER_PAINTED = Boolean.FALSE;
	public static Font RADIOBUTTON_MENUITEM_FONT = FONT_GLOBAL;
	public static Border RADIOBUTTON_MENUITEM_BORDER = MENUS_BORDER;
	
}
