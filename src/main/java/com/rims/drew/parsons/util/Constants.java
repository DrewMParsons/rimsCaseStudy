package com.rims.drew.parsons.util;

/**
 * Class contains custom String Constants
 * 
 * @author Drew
 *
 */

public class Constants
{
	/*
	 * String for custom search query
	 */
	public static final String SEARCH_QUERY = "SELECT m FROM MenuItem m WHERE m.title LIKE '%' || :keyword || '%'"
			+ "OR m.description LIKE '%' || :keyword || '%'";

	
	/*
	 * String names of jsp files for Request mapping
	 */
	public static final String INDEX = "index";
	public static final String LOGIN_PAGE = "login";
	public static final String REGISTER_PAGE = "register";
	public static final String MENU_PAGE = "menu_index";
	public static final String NEW_MENU_ITEM_PAGE ="new_menu_item";
	public static final String EDIT_MENU_ITEM_PAGE = "edit_menu_item";
	public static final String ORDER_PAGE = "order";
	public static final String ORDER_DETAIL_PAGE ="order_details";
	public static final String ORDER_COMPLETE_PAGE ="order_complete";
}
