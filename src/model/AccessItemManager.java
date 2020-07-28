package model;

/**
 * <p>
 * Title: AccessItemManager
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
 * @author sawan
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AccessItemManager {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


public void createAccessItem() {

}

public List<String> establishSortedAccessList (ActionItem ai, List<ActionItem> aiList) {
List<String> sortedList = new ArrayList<>();


for(ActionItem a : aiList) {
sortedList.add(a.getActionItemName().toString());
}


return sortedList;
}


public List<String> establishSortedAccessList2 (ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	if(a.getStatus() == "Open") {
	
	String i =a.getActionItemName();
sortedList3.add(i);
	}
}


return sortedList3;
}

public List<String> establishSortedAccessList3 (ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	if(a.getStatus() == "Closed") {
	
	String i =a.getActionItemName();
sortedList3.add(i);
	}
}


return sortedList3;
}









public List<String> establishSortedAccessList4 (ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	if(a.getStatus() == "Open") {
	
	String i =   a.getActionMemberName()+" : " +a.getActionItemName();
sortedList3.add(i);
	}
}


return sortedList3;
}



public List<String> establishSortedAccessList5 (ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	if(a.getStatus() == "Closed") {
	
	String i =   a.getActionMemberName()+" : " +a.getActionItemName();
sortedList3.add(i);
	}
}


return sortedList3;
}



public List<String> establishSortedAccessList6 (ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	if(a.getStatus() == "Open") {
	
	String i =   dateFormat.format(a.getCreatedDate())+" : " +a.getActionItemName();
sortedList3.add(i);
	}
}


return sortedList3;
}


public List<String> establishSortedAccessList7 (ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	if(a.getStatus() == "Open") {
	
	String i =   dateFormat.format(a.getDueDate())+" : " +a.getActionItemName();
sortedList3.add(i);
	}
}


return sortedList3;
}



public List<String> establishSortedAccessList8 (ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	if(a.getStatus() == "Closed") {
	
	String i =   dateFormat.format(a.getCreatedDate())+" : " +a.getActionItemName();
sortedList3.add(i);
	}
}


return sortedList3;
}


public List<String> establishSortedAccessList9 (ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	if(a.getStatus() == "Closed") {
	
	String i =   dateFormat.format(a.getDueDate())+" : " +a.getActionItemName();
sortedList3.add(i);
	}
}


return sortedList3;
}



public List<String> establishSortedAccessList10 (ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	if(a.getStatus() == "Open") {
	
	String i = a.getActionMemberName()  +" : "+dateFormat.format(a.getCreatedDate())+" : " +a.getActionItemName();
sortedList3.add(i);
	}
}


return sortedList3;
}

public List<String> establishSortedAccessList11 (ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	if(a.getStatus() == "Open") {
	
	String i = a.getActionMemberName()  +" : "+dateFormat.format(a.getDueDate())+" : " +a.getActionItemName();
sortedList3.add(i);
	}
}


return sortedList3;
}


public List<String> establishSortedAccessList12 (ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	if(a.getStatus() == "Closed") {
	
	String i = a.getActionMemberName()  +" : "+dateFormat.format(a.getCreatedDate())+" : " +a.getActionItemName();
sortedList3.add(i);
	}
}


return sortedList3;
}

public List<String> establishSortedAccessList13 (ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	if(a.getStatus() == "Closed") {
	
	String i = a.getActionMemberName()  +" : "+dateFormat.format(a.getDueDate())+" : " +a.getActionItemName();
sortedList3.add(i);
	}
}


return sortedList3;
}

public List<String> establishSortedAccessList14 (ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	
	
	String i = a.getActionMemberName()  +" : "+dateFormat.format(a.getCreatedDate())+" : " +a.getActionItemName();
sortedList3.add(i);
	
}


return sortedList3;
}

public List<String> establishSortedAccessList15(ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	
	
	String i = a.getActionMemberName()  +" : "+dateFormat.format(a.getDueDate())+" : " +a.getActionItemName();
sortedList3.add(i);
	
}


return sortedList3;
}

public List<String> establishSortedAccessList16(ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	
	
	String i = a.getActionMemberName()  +" : " +a.getActionItemName();
sortedList3.add(i);
	
}


return sortedList3;
}


public List<String> establishSortedAccessList17(ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	
	
	String i = dateFormat.format(a.getCreatedDate())+" : " +a.getActionItemName();
sortedList3.add(i);
	
}


return sortedList3;
}

public List<String> establishSortedAccessList18(ActionItem ai, List<ActionItem> aiList) {
	
	
	
List<String> sortedList3 = new ArrayList<>();
for(ActionItem a : aiList) {
	
	
	String i = dateFormat.format(a.getDueDate())+" : " +a.getActionItemName();
sortedList3.add(i);
	
}


return sortedList3;
}









}