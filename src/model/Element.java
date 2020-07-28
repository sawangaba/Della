package model;


/**
 * <p>
 * Title: Element
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
public class Element {

	//---------------------------------------------------------------------------------------------------------------------
	// Attributes

	private String Members;
	private String Team_Name;
	
	//---------------------------------------------------------------------------------------------------------------------

	/**
	 * The ActionItem class constructors.
	 *
	 */
	public Element() {
		Members  = "";
		Team_Name  = "";
		
		
	}
	
	
	

	public Element(String ai, String ai1) {

		Members = ai;
		Team_Name = ai1;
		
	}

	// Just the usual getters and setters
	public String getMemberName() { return Members; }

	

	public void setMemberName(String x) { Members = x; }
	
public String getTeamName() { return Team_Name; }

	

	public void setTeamName(String x) { Team_Name = x; }
}

	
