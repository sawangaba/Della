package model;

import java.util.Date;

/**
 * <p>
 * Title: ActionItem
 * </p>
 *
 * <p>
 * Description: An entity to hold details about a particular action item
 * </p>
 *
 * <p>
 * Copyright: Copyright � 2005, 2006
 * </p>
 *
 * @author Sawan
 * @version 1.00
 */
public class ActionItem {

	//---------------------------------------------------------------------------------------------------------------------
	// Attributes

	private String actionItemName;
	private String MemberName;
	private String TeamName;
	private String description;
	private String resolution;
	private String status;
	private Date dueDate;
	private Date createdDate;
	//---------------------------------------------------------------------------------------------------------------------

	/**
	 * The ActionItem class constructors.
	 *
	 */
	public ActionItem() {
		 actionItemName = MemberName = TeamName  = description = resolution = status = "";
		dueDate = createdDate = null;
	}
	 
	
	

	public ActionItem(String ai,String mn,String tn, String desc, String res, String stat) {

		actionItemName = ai;
		MemberName = mn;
		TeamName = tn;
		description = desc;
		resolution = res;
		status = stat;
		createdDate = new Date();
	}

	// Just the usual getters and setters
	public String getActionItemName() { return actionItemName; }
	public String getActionMemberName() { return MemberName; }
	
	public String getActionTeamName() { return TeamName; }

	public String getDescription() { return description; }

	public String getResolution() { return resolution; }

	public String getStatus() { return status; }

	public Date getDueDate() { return dueDate; }

	public Date getCreatedDate() { return createdDate; }

	public void setActionItemName(String x) { actionItemName = x; }
	public void setActionMemberName(String x) { MemberName = x; }
	public void setActionTeamName(String x) { TeamName = x; }

	public void setDescription(String x) { description = x; }

	public void setResolution(String x) { resolution = x; }

	public void setStatus(String x) { status = x; }

	public void setDueDate(Date x) { dueDate = x; }

	public void setCreatedDate(Date x) { createdDate = x; }
}
