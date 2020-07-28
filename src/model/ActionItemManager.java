package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gui.ActionItemScreen;

import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * <p>
 * Title: ActionItemManager
 * </p>
 *
 * <p>
 * Description: A class to organize and manage all known action items
 * </p>
 *
 * <p>
 * Copyright: Copyright � 2007
 * </p>
 *
 * @author Lynn Robert Carter
 * @version 1.00 
 * @author Sawan
 * 
 */
public class ActionItemManager {

	// ---------------------------------------------------------------------------------------------------------------------
	// Constants

	private transient SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private boolean editChangesPending;

	// ---------------------------------------------------------------------------------------------------------------------
	// Attributes
	public static final int statusOpen = 0; // The constants for Open and Close
	public static final int statusClosed = 1;
	public static final String[] statusStrings = { "Open", "Closed" };
	private ActionItem currentActionItem = null; 
	
	
	private ActionItem emptyActionItem = null; // The standard empty action item
	List<ActionItem> ailist = new ArrayList<ActionItem>();
	List<Element> mem = new ArrayList<Element>();
	
	private AccessItemManager aiM = new AccessItemManager();
	
	
	

	// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * The ActionItemManager class constructor.
	 * 
	 */
	public ActionItemManager() {
		currentActionItem = new ActionItem();
		
		emptyActionItem = new ActionItem();
		emptyActionItem.setCreatedDate(null);
	}

	/**
	 * Update an existing action item based on the parameters pass to the routine
	 * 
	 * @param name        String
	 * @param description String
	 * @param resolution  String
	 * @param status      String
	 * @param dueDateStr  String
	 * @return ActionItem
	 */

	public ActionItemScreen combovalue(String name) throws Exception {

		return null;

	}

	public ActionItem updateActionItem(String name, String Member ,String team,String description, String resolution, String status,
			String dueDateStr ) throws Exception {
		// Just allocate a new action item and save it. The inner workings of
		// this method will change drastically in Task 01 so I don't care about
		// being wasteful now.
		ActionItem ai = new ActionItem(name, Member,team, description, resolution, status);

		// Check if there are problems with the modifications.
		validateActionItem(ai, name, dueDateStr);

		// We passed the tests so it's ok to set the new current action item
		setCurrentActionItem(ai);
		
		
		return ai;
		
		
	}

	/**
	 * Check the parameters to see if the action item can be added to the list of
	 * action items.
	 * 
	 * @param name       String
	 * @param dueDateStr String
	 * @return boolean
	 * @throws an exception if there are any problems with the input.
	 */
	private void validateActionItem(ActionItem ai, String name, String dueDateStr) throws Exception {
		
		if (name.trim().length() == 0) {
			throw new Exception("The Action Item Name must not be empty!   ");
		}

		Date dueDate = null;
	
		if (dueDateStr.length() != 0) {
			try {
				
				
				dueDate = dateFormat.parse(dueDateStr);
				
			} catch (ParseException ex) {
				throw new Exception("Please use the requested date format!   ");
			}
		}
		ai.setDueDate(dueDate);
	}
	
	
	
	

	public ActionItem createActionItem(String name, String Member,String team,String description, String resolution, String status,
			String dueDateStr) throws Exception {
		ActionItem ai = new ActionItem(name,Member,team, description, resolution, status);
		
		
		validateActionItem(ai, name, dueDateStr);
	
		
				
				setCurrentActionItem(ai);
			ailist.add(ai);
		
		
		
		return ai;

	}

	
	
	
	
	


	// The usual getters and setters

	/**
	 * Get the current action item
	 * 
	 * @return - The current action item
	 */
	public ActionItem getCurrentActionItem() {
		if (currentActionItem == null)
			return emptyActionItem;
		return currentActionItem;
	}

	public void setCurrentActionItem(ActionItem x) {
		currentActionItem = x;
		
		
	}
	
	
	
	

	public void clearCurrentActionItem() {
		currentActionItem = emptyActionItem;
	}

	public void setDateFormatChecker() {
		dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	}

	public void setEditChangesPending(boolean flag) {
		editChangesPending = flag;
	}

	public boolean getEditChangesPending() {
		return editChangesPending;
	}

	public List<String> getActionItemNames(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList(ai, ailist);
		return namesList;
	}
	
	
	
	
	
	
	
	
	
	public List<String> getActionItemstatusopen(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList2(ai, ailist);
		return namesList;
	}
	
	public List<String> getActionItemstatusclosed(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList3(ai, ailist);
		return namesList;
	}
	
	public List<String> getActionItemmemberopen(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList4(ai, ailist);
		return namesList;
	}
	public List<String> getActionItemmemberclosed(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList5(ai, ailist);
		return namesList;
	}
	
	public List<String> getActionItemcreatedateopen(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList6(ai, ailist);
		return namesList;
	}
	
	public List<String> getActionItemduedateopen(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList7(ai, ailist);
		return namesList;
	}
	
	public List<String> getActionItemcreatedateclosed(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList8(ai, ailist);
		return namesList;
	}
	public List<String> getActionItemduedateclosed(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList9(ai, ailist);
		return namesList;
	}
	
	public List<String> getActionItemcreatedatememberopen(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList10(ai, ailist);
		return namesList;
	}
	
	public List<String> getActionItemduedatememberopen(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList11(ai, ailist);
		return namesList;
	}
	
	public List<String> getActionItemcreatedatememberclosed(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList12(ai, ailist);
		return namesList;
	}
	
	public List<String> getActionItemduedatememberclosed(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList13(ai, ailist);
		return namesList;
	}
	
	public List<String> getActionItemcreatedatemember(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList14(ai, ailist);
		return namesList;
	}
	public List<String> getActionItemduedatemember(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList15(ai, ailist);
		return namesList;
	}

	public List<String> getActionItemmember(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList16(ai, ailist);
		return namesList;
	}
	
	public List<String> getActionItemcreatedate(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList17(ai, ailist);
		return namesList;
	}
	
	public List<String> getActionItemduedate(ActionItem ai) {
		List<String> namesList = new ArrayList<>();
		namesList = aiM.establishSortedAccessList18(ai, ailist);
		return namesList;
	}
	

	public ActionItem setActionItem(String actionItemName) {
		
		for (ActionItem x : ailist) {
			if (x.getActionItemName().equalsIgnoreCase(actionItemName.trim()) )
			
			{
				
				currentActionItem = x;
				return x;
			}
		}
		return emptyActionItem;
	}

}
