package gui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import control.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import model.ActionItem;
import model.ActionItemManager;
import model.Element;
import model.Elementlist;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * <p>
 * Title: ActionItemScreen
 * </p>
 * 
 * <p>
 * Description: A manually generated Action Item Screen for Della
 * </p>
 * 
 * <p>
 * Copyright: Copyright � 2007
 * </p>
 * 
 * @author Lynn Robert Carter, Modified by Sawan 2020-01-25
 * @version 1.01 Many thanks to Harry Sameshima for his original work.
 */

public class ActionItemScreen {
	private Label ActionItems = new Label("Action Items:");
	private Label combolabel = new Label(
			"Select an Action Item from the pull-down list to examine" + " and update it.");
	ComboBox<String> myComboBox = new ComboBox<String>();
	public static ObservableList<String> selectActionItemOptions = FXCollections.observableArrayList();
	public static ObservableList<String> selectActionItemOptions1 = FXCollections.observableArrayList();
	public static ObservableList<String> selectActionItemOptions2 = FXCollections.observableArrayList();
	private Label SelActionItem = new Label("Selected Action Item:");
	private Label name = new Label("Name:");
	private TextField text1 = new TextField();
	private Label description = new Label("Description:");
	private TextArea area = new TextArea();
	private Label resolution = new Label("Resolution:");
	private TextArea nxtarea = new TextArea();
	private Button Update = new Button("Update This Action Form");
	private Button Clear = new Button("Clear This Form");
	private Button Create = new Button("Create a New Action Item");
	private Label dates = new Label("Dates");
	private Label creation = new Label("Creation:");
	private Label newdate = new Label();
	private Label due = new Label("Due:");
	private TextField datefield = new TextField();
	private Label timeformat = new Label("Use yyyy-mm-dd format");
	private Label Actionitem = new Label("Action Item");
	private Label status = new Label("Status:");
	private Label sorting = new Label("Sorting Direction:");
	private Label firstsorting = new Label("First Sorting Factor:");
	private Label secondsorting = new Label("Second Sorting Factor:");
	private Label thirdsorting = new Label("third Sorting Factor:");
	private Label Assigned= new Label("Assigned Members:");
	private Label Assigned_Team= new Label("Assigned Team:");
	ComboBox<String> sortcombo = new ComboBox<String>();
	ComboBox<String> firstcombo = new ComboBox<String>();
	ComboBox<String> secondcombo = new ComboBox<String>();
	ComboBox<String> thirdcombo = new ComboBox<String>();
	ComboBox<String> Members= new ComboBox<String>();
	ComboBox<String> team= new ComboBox<String>();
	public List<ActionItem> aiList = new ArrayList<>();

	private Label unsavedChanges = new Label();
	ComboBox<String> dateComboBox = new ComboBox<String>();
	ObservableList<String> date = FXCollections.observableArrayList(ActionItemManager.statusStrings);

	private Boolean updatingGUI = false;
	private Controller theController = null;
	private ActionItemManager aiM;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	ActionItem ai;
	Element e;
	Elementlist ei;

	public void actionPerformed(ActionEvent ae) {
		checkForUnsavedUpdates();
	}

	public ActionItemScreen(Group actionItemGroup) {

		dateComboBox.getItems().addAll("open", "closed");

		updatingGUI = true;

		// Use a modified singleton pattern to access the application's state
		theController = Controller.getInstance();
		aiM = theController.getActionItemManager();
		ei = theController.getElementlist();
		
		loadScreen();

		ActionItems.setLayoutX(10);
		ActionItems.setLayoutY(110);
		ActionItems.setStyle("-fx-font-weight: bold");

		combolabel.setLayoutX(10);
		combolabel.setLayoutY(160);
		combolabel.setStyle("-fx-font-weight: bold");

		SelActionItem.setLayoutX(10);
		SelActionItem.setLayoutY(250);
		SelActionItem.setStyle("-fx-font-weight: bold");

		myComboBox.setLayoutX(10);
		myComboBox.setLayoutY(130);
		myComboBox.setPrefWidth(620);
		myComboBox.setEditable(false);

		name.setLayoutX(10);
		name.setLayoutY(270);
		name.setStyle("-fx-font-weight: bold");

		area.setLayoutX(10);
		area.setLayoutY(320);
		area.setPrefWidth(410);
		area.setPrefHeight(80);
		area.textProperty().addListener(e -> {
			checkForUnsavedUpdates();
		});

		description.setLayoutX(10);
		description.setLayoutY(300);
		description.setStyle("-fx-font-weight: bold");

		resolution.setLayoutX(10);
		resolution.setLayoutY(410);
		resolution.setStyle("-fx-font-weight: bold");

		text1.setLayoutX(50);
		text1.setLayoutY(270);
		text1.setPrefWidth(370);
		text1.textProperty().addListener(e -> {
			checkForUnsavedUpdates();
		});

		nxtarea.setLayoutX(10);
		nxtarea.setLayoutY(440);
		nxtarea.setPrefWidth(410);
		nxtarea.setPrefHeight(80);
		area.textProperty().addListener(e -> {
			checkForUnsavedUpdates();
		});

		Update.setLayoutX(20);
		Update.setLayoutY(550);

		Clear.setLayoutX(180);
		Clear.setLayoutY(550);

		Create.setLayoutX(300);
		Create.setLayoutY(550);

		unsavedChanges.setLayoutY(580);
		unsavedChanges.setLayoutX(230);
		unsavedChanges.setTextFill(Color.web("red"));
		unsavedChanges.setVisible(true);

		dates.setLayoutX(430);
		dates.setLayoutY(280);
		dates.setStyle("-fx-font-weight: bold");

		creation.setLayoutX(450);
		creation.setLayoutY(300);
		creation.setStyle("-fx-font-weight: bold");

		newdate.setLayoutX(540);
		newdate.setLayoutY(300);
		newdate.setStyle("-fx-font-weight: bold");

		due.setLayoutX(480);
		due.setLayoutY(320);
		due.setStyle("-fx-font-weight: bold");

		datefield.setLayoutX(510);
		datefield.setLayoutY(320);
		datefield.setPrefWidth(100);

		timeformat.setLayoutX(480);
		timeformat.setLayoutY(350);

		Actionitem.setLayoutX(430);
		Actionitem.setLayoutY(370);
		Actionitem.setStyle("-fx-font-weight: bold");

		status.setLayoutX(460);
		status.setLayoutY(390);
		status.setStyle("-fx-font-weight: bold");

		Assigned.setLayoutX(460);
		Assigned.setLayoutY(430);
		Assigned.setStyle("-fx-font-weight: bold");
		
		
		Assigned_Team.setLayoutX(460);
		Assigned_Team.setLayoutY(490);
		Assigned_Team.setStyle("-fx-font-weight: bold");
		
		dateComboBox.setLayoutX(510);
		dateComboBox.setLayoutY(390);
		dateComboBox.setPrefWidth(100);
		dateComboBox.setEditable(false);
		dateComboBox.setItems(date);
		dateComboBox.setValue(ActionItemManager.statusStrings[0]);
		
		
		Members.setLayoutX(510);
		Members.setLayoutY(450);
		Members.setPrefWidth(100);
		
		team.setLayoutX(510);
		team.setLayoutY(510);
		team.setPrefWidth(100);
		
		
		sorting.setLayoutX(180);
		sorting.setLayoutY(200);

		firstsorting.setLayoutX(300);
		firstsorting.setLayoutY(200);

		secondsorting.setLayoutX(420);
		secondsorting.setLayoutY(200);
		
		thirdsorting.setLayoutX(560);
		thirdsorting.setLayoutY(200);
		
		

		sortcombo.setLayoutX(180);
		sortcombo.setLayoutY(220);
		sortcombo.setPrefWidth(100);
		sortcombo.getItems().addAll("None", "Small to Large", "Large to Small");

		sortcombo.getSelectionModel().selectedItemProperty();

		firstcombo.setLayoutX(300);
		firstcombo.setLayoutY(220);
		firstcombo.setPrefWidth(100);
		firstcombo.getItems().addAll("None", "Assigned Member");

		secondcombo.setLayoutX(420);
		secondcombo.setLayoutY(220);
		secondcombo.setPrefWidth(100);
		secondcombo.getItems().addAll("None", "Creation Date", "Due Date");
		
		thirdcombo.setLayoutX(560);
		thirdcombo.setLayoutY(220);
		thirdcombo.setPrefWidth(100);
		thirdcombo.getItems().addAll("None", "Closed", "Open");
		

		Update.setOnAction((event) -> {

			try {

				uptscreen(event);
			} catch (Exception e) {

				e.printStackTrace();
			}

		});

		Create.setOnAction((event) -> {
			crtscreen();

		});

		Clear.setOnAction((event) -> {
			clrscreen();

			theController.setDirtyFlag(true);
			checkForUnsavedUpdates();
		});

		myComboBox.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
				selectActionItem(observableValue, oldValue, newValue);

			}

		});
		;

		sortcombo.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
				sort1(observableValue, oldValue, newValue);

			}

		});
		;

		firstcombo.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
				sort1(observableValue, oldValue, newValue);

			}

		});
		;

		secondcombo.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
				sort1(observableValue, oldValue, newValue);

			}

		});
		
		thirdcombo.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
				sort1(observableValue, oldValue, newValue);

			}

		});
		;

		actionItemGroup.getChildren().addAll( ActionItems, myComboBox, combolabel,
				SelActionItem, name, text1, description, area, resolution, nxtarea, Update, Create, Clear, dates,
				creation, due, datefield, timeformat, Actionitem, status, dateComboBox, newdate, unsavedChanges,
				sorting, firstsorting, secondsorting, sortcombo,Assigned, firstcombo, secondcombo,Members,Assigned_Team,team,thirdsorting,thirdcombo);
	}

public void loadScreen() {
		

		
		updatingGUI = true;
		// Fetch the current action item.  If there isn't one, leave now
		ActionItem ai = aiM.getCurrentActionItem();
	
	
		
		if (ai.getActionItemName() == "" ) {
			clrscreen();
			updatingGUI = true;
			dateComboBox.setPromptText("Open");
			newdate.setText("");
			datefield.setText("");
			selectActionItemOptions1.clear();
			selectActionItemOptions2.clear();
			Members.getItems().clear();
			team.getItems().clear();
				selectActionItemOptions1.addAll(ei.getActionItemNames(e));
				selectActionItemOptions2.addAll(ei.getActionItemNames1(e));
				
				Members.getItems().addAll(selectActionItemOptions1);
				team.getItems().addAll(selectActionItemOptions2);
			
			
		}
		else {
		
			
	
			
			selectActionItemOptions.clear();
			myComboBox.getItems().clear();
			selectActionItemOptions.addAll(aiM.getActionItemNames(ai));
			
			
		
			
			
		if(sortcombo.getSelectionModel().getSelectedItem() == null ) {
			myComboBox.getItems().clear(); 
				 myComboBox.getItems().addAll(selectActionItemOptions);
			 }
			
					
					
		
			
		 	
			
			
			// Define the text fields
			updatingGUI = true;
			text1.setText(ai.getActionItemName());
			area.setText(ai.getDescription());
			nxtarea.setText(ai.getResolution());
			dateComboBox.setPromptText(ai.getStatus());
			
			Members.setPromptText(ai.getActionMemberName().toString());
			team.setPromptText(ai.getActionTeamName().toString());
			
			}
		// Define the status combobox value
		
		for (int i = 0; i < ActionItemManager.statusStrings.length; ++i)
			if (ai.getStatus().compareTo(ActionItemManager.statusStrings[i]) == 0) {
				dateComboBox.setValue(ActionItemManager.statusStrings[i]);
				break;
			}
		
		
// Define the creation and due dates
		if (ai.getCreatedDate() != null)
			newdate.setText(dateFormat.format(ai.getCreatedDate()));
		else
			newdate.setText("");
		if (ai.getDueDate() != null)
			datefield.setText(dateFormat.format(ai.getDueDate()));
		else
			datefield.setText("");
		
		updatingGUI = false;
		
		checkForUnsavedUpdates();
	}


	private void checkForUnsavedUpdates() {
		if (updatingGUI)
			return;
		if (text1.getText().equals(aiM.getCurrentActionItem().getActionItemName())
				&& area.getText().equals(aiM.getCurrentActionItem().getDescription())
				&& nxtarea.getText().equals(aiM.getCurrentActionItem().getResolution())
				&& datefield.getText()
						.equals(aiM.getCurrentActionItem().getDueDate() != null
								? dateFormat.format(aiM.getCurrentActionItem().getDueDate())
								: "")
				&& (aiM.getCurrentActionItem().getStatus().equals("")
						|| aiM.getCurrentActionItem().getStatus().equals("Open")
						|| aiM.getCurrentActionItem().getStatus().equals("Closed"))) {
			unsavedChanges.setText("");
			aiM.setEditChangesPending(false);
		} else {
			unsavedChanges.setText("There are unsaved changes!");
			aiM.setEditChangesPending(true);
		}}

	public void fetchdata() throws NullPointerException {
		ai = aiM.getCurrentActionItem();
			
		
	
		
		
		myComboBox.getItems().add(ai.getActionItemName());
	
	}
		
	

	private void uptscreen(ActionEvent e) throws NullPointerException {
	try {
			
			aiM.updateActionItem(text1.getText(),
					
					Members.getSelectionModel().getSelectedItem().toString(),
					team.getSelectionModel().getSelectedItem().toString(),
					
					
area.getText(),
nxtarea.getText(),
dateComboBox.getSelectionModel().getSelectedItem().toString(),
datefield.getText());
			
		} catch ( Exception ep) {
			
			ep.printStackTrace();
		}
		theController.setDirtyFlag(true);
		checkForUnsavedUpdates();
	newdate.setText(dateFormat.format(new Date()));

							
	}




	private void clrscreen()  {
		myComboBox.setValue(null);
		text1.setText("");
		area.setText("");
		nxtarea.setText("");
		dateComboBox.setValue("");
		datefield.setText("");
		newdate.setText("");
		Members.setValue("");
		team.setValue("");
		team.getItems().clear();
		Members.getItems().clear();
		selectActionItemOptions1.clear();
		
			selectActionItemOptions1.addAll(ei.getActionItemNames(e));
			Members.getItems().addAll(selectActionItemOptions1);
			selectActionItemOptions2.clear();
			
				selectActionItemOptions2.addAll(ei.getActionItemNames1(e));
				team.getItems().addAll(selectActionItemOptions2);
		checkForUnsavedUpdates();
	}
	
	

	
	private void selectActionItem(ObservableValue<? extends String> ov, String oldValue, String newValue) {
		try {

			if ((firstcombo.getSelectionModel().getSelectedItem() != null && firstcombo.getSelectionModel().getSelectedItem() != "None")
					&& (secondcombo.getSelectionModel().getSelectedItem() == null || secondcombo.getSelectionModel().getSelectedItem() == "None" ) ) {
				String[] h = myComboBox.getSelectionModel().getSelectedItem().toString().split(" : ");

				String i = h[1].trim();

				ActionItem ai = aiM.setActionItem(i);

				String name = ai.getActionItemName().toString();

				String description = ai.getDescription().toString();

				String resolution = ai.getResolution().toString();

				String status = ai.getStatus().toString();

				text1.setText(name);

				area.setText(description);

				nxtarea.setText(resolution);

				dateComboBox.setValue(status);

				datefield.setText(dateFormat.format(ai.getDueDate()));

				newdate.setText(dateFormat.format(ai.getCreatedDate()));

				Members.setValue(ai.getActionMemberName().toString());

				theController = Controller.getInstance();
				theController.setDirtyFlag(true);
				theController = Controller.getInstance();
				theController.setDirtyFlag(true);
			}
			
			else	if ((firstcombo.getSelectionModel().getSelectedItem() == null || firstcombo.getSelectionModel().getSelectedItem() == "None")  && secondcombo.getSelectionModel().getSelectedItem() != "None"
					&& secondcombo.getSelectionModel().getSelectedItem() != null  ) {
				String[] h = myComboBox.getSelectionModel().getSelectedItem().toString().split(" : ");

				String i = h[1].trim();

				ActionItem ai = aiM.setActionItem(i);

				String name = ai.getActionItemName().toString();

				String description = ai.getDescription().toString();

				String resolution = ai.getResolution().toString();

				String status = ai.getStatus().toString();

				text1.setText(name);

				area.setText(description);

				nxtarea.setText(resolution);

				dateComboBox.setValue(status);

				datefield.setText(dateFormat.format(ai.getDueDate()));

				newdate.setText(dateFormat.format(ai.getCreatedDate()));

				Members.setValue(ai.getActionMemberName().toString());

				theController = Controller.getInstance();
				theController.setDirtyFlag(true);
				theController = Controller.getInstance();
				theController.setDirtyFlag(true);
			}
			
			
			else	if ((firstcombo.getSelectionModel().getSelectedItem() != null && firstcombo.getSelectionModel().getSelectedItem() != "None")
					&& (secondcombo.getSelectionModel().getSelectedItem() != null  && secondcombo.getSelectionModel().getSelectedItem() != "None" )) {
				String[] h = myComboBox.getSelectionModel().getSelectedItem().toString().split(" : ");

				String i = h[2].trim();

				ActionItem ai = aiM.setActionItem(i);

				String name = ai.getActionItemName().toString();

				String description = ai.getDescription().toString();

				String resolution = ai.getResolution().toString();

				String status = ai.getStatus().toString();

				text1.setText(name);

				area.setText(description);

				nxtarea.setText(resolution);

				dateComboBox.setValue(status);

				datefield.setText(dateFormat.format(ai.getDueDate()));

				newdate.setText(dateFormat.format(ai.getCreatedDate()));

				Members.setValue(ai.getActionMemberName().toString());

				theController = Controller.getInstance();
				theController.setDirtyFlag(true);
				theController = Controller.getInstance();
				theController.setDirtyFlag(true);
			}
			else	 {
				

				ActionItem ai = aiM.setActionItem(myComboBox.getSelectionModel().getSelectedItem().toString());

				String name = ai.getActionItemName().toString();

				String description = ai.getDescription().toString();

				String resolution = ai.getResolution().toString();

				String status = ai.getStatus().toString();

				text1.setText(name);

				area.setText(description);

				nxtarea.setText(resolution);

				dateComboBox.setValue(status);

				datefield.setText(dateFormat.format(ai.getDueDate()));

				newdate.setText(dateFormat.format(ai.getCreatedDate()));

				Members.setValue(ai.getActionMemberName().toString());

				theController = Controller.getInstance();
				theController.setDirtyFlag(true);
				theController = Controller.getInstance();
				theController.setDirtyFlag(true);
			}
			
					} catch (Exception e) {

		}

	}

private void sort1(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
		
		String c1 = sortcombo.getSelectionModel().getSelectedItem();
		String c2 = firstcombo.getSelectionModel().getSelectedItem();
		String c3 = secondcombo.getSelectionModel().getSelectedItem();
		String c4 = thirdcombo.getSelectionModel().getSelectedItem();

		if (c1 == "Small to Large" && (c2 == "None" || c2 == null) && (c3 == null || c3 == "None") && (c4 == null || c4 == "None") ) {
		
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemNames(ai));

			FXCollections.sort(selectActionItemOptions);
			myComboBox.getItems().addAll(selectActionItemOptions);

		}

		else if (c1 == "Large to Small" && (c2 == "None" || c2 == null) && (c3 == null || c3 == "None") &&  (c4 == null || c4 == "None")) {
			
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemNames(ai));

			FXCollections.reverse(selectActionItemOptions);
			myComboBox.getItems().addAll(selectActionItemOptions);

		}

		else if ((c1 == "None" || c1== null) && (c2 == "None" || c2 == null) && (c3 == null || c3 == "None") && (c4 == null || c4 == "None")) {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemNames(ai));

			myComboBox.getItems().addAll(selectActionItemOptions);

		}

		else if ((c1 == "None" || c1 == null) && c2 == "Assigned Member" && (c3 == null || c3 == "None") && (c4 == null || c4 == "None")) {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemmember(ai));

			myComboBox.getItems().addAll(selectActionItemOptions);

		}

		else if (c1 == "Small to Large" && c2 == "Assigned Member" && (c3 == null || c3 == "None")&& (c4 == null || c4 == "None") ) {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemmember(ai));
			FXCollections.sort(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}

		else if (c1 == "Large to Small" && c2 == "Assigned Member" && (c3 == null || c3 == "None") && (c4 == null || c4 == "None")) {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemmember(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		else if (c1 == "Small to Large" && c2 == "Assigned Member" && (c3 == null || c3 == "None") && (c4 == "Open")) {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemmemberopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && c2 == "Assigned Member" && (c3 == null || c3 == "None") && (c4 == "Open")) {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemmemberopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Small to Large" && c2 == "Assigned Member" && (c3 == null || c3 == "None") && (c4 == "Closed")) {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemmemberclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && c2 == "Assigned Member" && (c3 == null || c3 == "None") && (c4 == "Closed")) {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemmemberclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}

		else if (c1 == "Small to Large" && c2 == "Assigned Member" && c3 == "Creation Date" && (c4 == null || c4 == "None")) {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedatemember(ai));
			FXCollections.sort(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}

		else if (c1 == "Large to Small" && c2 == "Assigned Member" && c3 == "Creation Date" && (c4 == null || c4 == "None")) {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedatemember(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		else if (c1 == "Small to Large" && c2 == "Assigned Member" && c3 == "Creation Date" && c4 == "Open") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedatememberopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && c2 == "Assigned Member" && c3 == "Creation Date" &&   c4 == "Open") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedatememberopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		
		else if (c1 == "Small to Large" && c2 == "Assigned Member" && c3 == "Creation Date" && c4 == "Closed") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedatememberclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && c2 == "Assigned Member" && c3 == "Creation Date" &&   c4 == "Closed") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedatememberclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		
		
		
		
		else if (c1 == "Small to Large" && c2 == "Assigned Member" && c3 == "Due Date" && c4 == "Open") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedatememberopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && c2 == "Assigned Member" && c3 == "Due Date" &&   c4 == "Open") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedatememberopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		
		else if (c1 == "Small to Large" && c2 == "Assigned Member" && c3 == "Due Date" && c4 == "Closed") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedatememberclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && c2 == "Assigned Member" && c3 == "Due Date" &&   c4 == "Closed") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedatememberclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		
		
		
		
		
		
		
		
		else if ((c1 == null || c1 == "None") && (c2 == null || c2 == "None") && c3 == "Creation Date" && (c4 == null || c4 == "None")) {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedate(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if ((c1 == null || c1 == "None") && (c2 == null || c2 == "None") && c3 == "Due Date" && (c4 == null || c4 == "None")) {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedate(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Small to Large" && (c2 == null || c2 == "None") && c3 == "Creation Date" && (c4 == null || c4 == "None")) {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedate(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && (c2 == null || c2 == "None") && c3 == "Due Date" && (c4 == null || c4 == "None")) {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedate(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		
		
		
		else if (c1 == "Small to Large" && (c2 == null || c2 == "None") && c3 == "Creation Date" && c4 == "Open") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedateopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && (c2 == null || c2 == "None") && c3 == "Creation Date" && c4 == "Open") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedateopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Small to Large" && (c2 == null || c2 == "None") && c3 == "Creation Date" && c4 == "Closed") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedateclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && (c2 == null || c2 == "None") && c3 == "Creation Date" && c4 == "Closed") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedateclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		
		
		else if (c1 == "Large to Small" && (c2 == null || c2 == "None") && c3 == "Due Date" && c4 == "Closed") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedateclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Small to Large" && (c2 == null || c2 == "None") && c3 == "Due Date" && c4 == "Closed") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedateclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && (c2 == null || c2 == "None") && c3 == "Due Date" && c4 == "Open") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedateopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Small to Large" && (c2 == null || c2 == "None") && c3 == "Due Date" && c4 == "Open") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedateopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		
		
		else if ((c1 == null || c1 == "None") && (c2 == null || c2 == "None") && c3 == "Due Date" && c4 == "Open") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedateopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if ((c1 == null || c1 == "None") && (c2 == null || c2 == "None") && c3 == "Due Date" && c4 == "Closed") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedateclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		
		else if ((c1 == null || c1 == "None") && (c2 == null || c2 == "None") && c3 == "Creation Date" && c4 == "Open") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedateopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if ((c1 == null || c1 == "None") && (c2 == null || c2 == "None") && c3 == "Creation Date" && c4 == "Closed") {
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedateclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		else if ((c1 == "None" || c1 == null) && (c2 == "None" || c2 == null) && (c3 == null || c3 == "None") && c4 == "Closed" ) {
			
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemstatusclosed(ai));

			FXCollections.sort(selectActionItemOptions);
			myComboBox.getItems().addAll(selectActionItemOptions);

		}
else if ((c1 == "None" || c1 == null) && (c2 == "None" || c2 == null) && (c3 == null || c3 == "None") && c4 == "Open" ) {
			
			myComboBox.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemstatusopen(ai));

			FXCollections.sort(selectActionItemOptions);
			myComboBox.getItems().addAll(selectActionItemOptions);

		}
		
		
else if ((c1 == "None" || c1 == null) && c2 == "Assigned Member" && (c3 == null || c3 == "None") && c4=="Open") {
	myComboBox.getItems().clear();
	selectActionItemOptions.clear();
	selectActionItemOptions.addAll(aiM.getActionItemmemberopen(ai));

	myComboBox.getItems().addAll(selectActionItemOptions);

}
		
else if ((c1 == "None" || c1 == null) && c2 == "Assigned Member" && (c3 == null || c3 == "None") && c4=="Closed") {
	myComboBox.getItems().clear();
	selectActionItemOptions.clear();
	selectActionItemOptions.addAll(aiM.getActionItemmemberclosed(ai));

	myComboBox.getItems().addAll(selectActionItemOptions);

}



		

	}

	
	
	
	

	private void crtscreen()throws NullPointerException {
		
		try {
			
			aiM.createActionItem(text1.getText(),
					Members.getSelectionModel().getSelectedItem().toString(),  	
					team.getSelectionModel().getSelectedItem().toString(),
area.getText(),

nxtarea.getText(),
dateComboBox.getSelectionModel().getSelectedItem().toString(),
datefield.getText().trim()
);
			
		} catch ( Exception ep) {
			
			ep.printStackTrace();
		}
		
		
	newdate.setText(dateFormat.format(new Date()));
	theController.setDirtyFlag(true);
	
	

fetchdata();


}
}
