package gui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import control.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.ActionItem;
import model.ActionItemManager;

/**
 * <p>
 * Title: ConsoleScreen
 * </p>
 *
 * <p>
 * Description: A manually generated action item screen for Della
 * </p>
 *
 * <p>
 * Copyright: Copyright � 2007
 * </p>
 *
 * @author Lynn Robert Carter, Modified by Sawan 2020-01-25 Many thanks to
 *         Harry Sameshima for his original work.
 * @version 1.01
 */

public class ConsoleScreen {

	private Label ActionItems = new Label("Action Items:");
	private Label Name = new Label("Name:");
	private Label SelActionItem = new Label("Selected Action Item:");
	private TextField ItemName = new TextField();
	private Label Description = new Label("Description:");
	private TextArea Area = new TextArea();
	private Label Resolution = new Label("Resolution:");
	private TextArea nxtArea = new TextArea();
	private Label sorting = new Label("Sorting Direction:");
	private Label firstsorting = new Label("First Sorting Factor:");
	private Label secondsorting = new Label("Second Sorting Factor:");
	private Label thirdsorting = new Label("third Sorting Factor:");
	ComboBox<String> sortcombo = new ComboBox<String>(
	FXCollections.observableArrayList("Small to Large", "Large to Small"));
	ComboBox<String> firstcombo = new ComboBox<String>(
			FXCollections.observableArrayList("None", "Assigned Member"));
	ComboBox<String> secondcombo = new ComboBox<String>(
			FXCollections.observableArrayList("None", "Creation Date", "Due Date"));
	ComboBox<String> thirdcombo = new ComboBox<String>(
			FXCollections.observableArrayList("None", "Open", "Closed"));
	private Label dates = new Label("Dates");
	private Label creation = new Label("Creation:");
	private Label members = new Label("Members:");
	private Label Team_Name = new Label("Team Name:");
	private Label member = new Label();
	private Label team = new Label();
	private Label newdate = new Label();
	private Label duedate = new Label();
	
	private Label due = new Label("Due:");
	private Label Actionitem = new Label("Action Item");
	private Label Status = new Label("Status:");
	private Label ActiveStatus = new Label();
	private Label Copyright = new Label("Copyright \u24B8 2020 Sawan Gaba");
	ActionItemScreen Item = null;
	public static ListView<String> newlist = new ListView<String>();
	private Controller theController = null;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	ActionItemManager aiM;
	ActionItem ai;

	private Boolean updatingGUI = false;
	public static List<ActionItem> ailist = new ArrayList<ActionItem>();
	List<String> sortedList = new ArrayList<>();
	public static ObservableList<String> selectActionItemOptions = FXCollections.observableArrayList();

	public ConsoleScreen(Group consoleGroup) {
		theController = Controller.getInstance();
		aiM = theController.getActionItemManager();
		loadScreen();

		ActionItems.setLayoutX(15);
		ActionItems.setLayoutY(110);
		ActionItems.setStyle("-fx-font-weight: bold");

		newlist.setLayoutX(10);
		newlist.setLayoutY(140);
		newlist.setPrefWidth(410);
		newlist.setPrefHeight(200);

		SelActionItem.setLayoutX(10);
		SelActionItem.setLayoutY(350);
		SelActionItem.setStyle("-fx-font-weight: bold");

		Name.setLayoutX(10);
		Name.setLayoutY(370);
		Name.setStyle("-fx-font-weight: bold");

		ItemName.setLayoutX(50);
		ItemName.setLayoutY(370);
		ItemName.setPrefWidth(350);

		Description.setLayoutX(10);
		Description.setLayoutY(400);
		Description.setStyle("-fx-font-weight: bold");

		Area.setLayoutX(10);
		Area.setLayoutY(420);
		Area.setPrefWidth(410);
		Area.setPrefHeight(80);

		Resolution.setLayoutX(10);
		Resolution.setLayoutY(500);
		Resolution.setStyle("-fx-font-weight: bold");

		nxtArea.setLayoutX(10);
		nxtArea.setLayoutY(520);
		nxtArea.setPrefWidth(410);
		nxtArea.setPrefHeight(60);

		sorting.setLayoutX(450);
		sorting.setLayoutY(110);

		firstsorting.setLayoutX(450);
		firstsorting.setLayoutY(160);

		secondsorting.setLayoutX(450);
		secondsorting.setLayoutY(210);
		
		thirdsorting.setLayoutX(450);
		thirdsorting.setLayoutY(270);

		sortcombo.setLayoutX(450);
		sortcombo.setLayoutY(130);
		sortcombo.setPrefWidth(100);

		firstcombo.setLayoutX(450);
		firstcombo.setLayoutY(180);
		firstcombo.setPrefWidth(100);

		secondcombo.setLayoutX(450);
		secondcombo.setLayoutY(240);
		secondcombo.setPrefWidth(100);
		
		thirdcombo.setLayoutX(450);
		thirdcombo.setLayoutY(290);
		thirdcombo.setPrefWidth(100);

		dates.setLayoutX(430);
		dates.setLayoutY(370);
		dates.setStyle("-fx-font-weight: bold");

		creation.setLayoutX(450);
		creation.setLayoutY(390);
		creation.setStyle("-fx-font-weight: bold");

		newdate.setLayoutX(510);
		newdate.setLayoutY(390);
		newdate.setStyle("-fx-font-weight: bold");

		due.setLayoutX(480);
		due.setLayoutY(410);
		due.setStyle("-fx-font-weight: bold");

		duedate.setLayoutX(510);
		duedate.setLayoutY(410);
		duedate.setStyle("-fx-font-weight: bold");

		Actionitem.setLayoutX(450);
		Actionitem.setLayoutY(430);
		Actionitem.setStyle("-fx-font-weight: bold");

		Status.setLayoutX(470);
		Status.setLayoutY(450);
		Status.setStyle("-fx-font-weight: bold");
		
		
		members.setLayoutX(470);
		members.setLayoutY(480);
		members.setStyle("-fx-font-weight: bold");
		
		Team_Name.setLayoutX(470);
		Team_Name.setLayoutY(510);
		Team_Name.setStyle("-fx-font-weight: bold");
		
		member.setLayoutX(550);
		member.setLayoutY(480);
		member.setStyle("-fx-font-weight: bold");
		
		team.setLayoutX(550);
		team.setLayoutY(510);
		team.setStyle("-fx-font-weight: bold");

		ActiveStatus.setLayoutX(510);
		ActiveStatus.setLayoutY(450);
		ActiveStatus.setStyle("-fx-font-weight: bold");

		Copyright.setLayoutX(440);
		Copyright.setLayoutY(580);
		Copyright.setStyle("-fx-font-weight: bold");

		newlist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue)
					throws NullPointerException {
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
		;
		thirdcombo.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
				sort1(observableValue, oldValue, newValue);

			}

		});
		;
		
		
		
		
		

		consoleGroup.getChildren().addAll(ActionItems, newlist, SelActionItem, Name, ItemName, Description, Area,
				Resolution, nxtArea, firstcombo, firstsorting, sorting, secondsorting, secondcombo, sortcombo, dates,
				creation, newdate, due, duedate, Actionitem, Status, ActiveStatus,member,members, Copyright,Team_Name,team,thirdsorting,thirdcombo);

	}

	public void loadScreen() {

		setUpdatingGUI(true);

		// Fetch the current action item. If there isn't one, leave now
		ActionItem ai = aiM.getCurrentActionItem();

		if (ai == null) {

			setUpdatingGUI(true);

			newdate.setText("");
			newdate.setText("");
		} else {

			selectActionItemOptions.clear();
			newlist.getItems().clear();

			selectActionItemOptions.addAll(aiM.getActionItemNames(ai));

			// Define the text fields
			setUpdatingGUI(true);
			newlist.getItems().addAll(selectActionItemOptions);
			ItemName.setText(ai.getActionItemName());
			Area.setText(ai.getDescription());
			nxtArea.setText(ai.getResolution());
			ActiveStatus.setText(ai.getStatus());
			member.setText(ai.getActionMemberName());
			team.setText(ai.getActionTeamName());
		}
		// Define the status combobox value

//Define the creation and due dates
		if (ai.getCreatedDate() != null)
			newdate.setText(dateFormat.format(ai.getCreatedDate()));
		else
			newdate.setText("");
		if (ai.getDueDate() != null)
			duedate.setText(dateFormat.format(ai.getDueDate()));
		else
			duedate.setText("");

		setUpdatingGUI(false);

	}

	private void selectActionItem(ObservableValue<? extends String> ov, String oldValue, String newValue) {
		try {

			if ((firstcombo.getSelectionModel().getSelectedItem() != null && firstcombo.getSelectionModel().getSelectedItem() != "None")
					&& (secondcombo.getSelectionModel().getSelectedItem() == null || secondcombo.getSelectionModel().getSelectedItem() == "None" ) ) {
				String[] h = newlist.getSelectionModel().getSelectedItem().toString().split(" : ");

				String i = h[1].trim();

				ActionItem ai = aiM.setActionItem(i);

				String name = ai.getActionItemName().toString();

				String description = ai.getDescription().toString();

				String resolution = ai.getResolution().toString();

				String status = ai.getStatus().toString();

				ItemName.setText(name);

				Area.setText(description);

				nxtArea.setText(resolution);

				ActiveStatus.setText(status);

				duedate.setText(dateFormat.format(ai.getDueDate()));

				newdate.setText(dateFormat.format(ai.getCreatedDate()));

				member.setText(ai.getActionMemberName());
				team.setText(ai.getActionTeamName());
				theController = Controller.getInstance();
				theController.setDirtyFlag(true);
			}
			
			else	if ((firstcombo.getSelectionModel().getSelectedItem() == null || firstcombo.getSelectionModel().getSelectedItem() == "None")  && secondcombo.getSelectionModel().getSelectedItem() != "None"
					&& secondcombo.getSelectionModel().getSelectedItem() != null  ) {
				String[] h = newlist.getSelectionModel().getSelectedItem().toString().split(" : ");

				String i = h[1].trim();

				ActionItem ai = aiM.setActionItem(i);

				String name = ai.getActionItemName().toString();

				String description = ai.getDescription().toString();

				String resolution = ai.getResolution().toString();

				String status = ai.getStatus().toString();

				ItemName.setText(name);

				Area.setText(description);

				nxtArea.setText(resolution);

				ActiveStatus.setText(status);

				duedate.setText(dateFormat.format(ai.getDueDate()));

				newdate.setText(dateFormat.format(ai.getCreatedDate()));

				member.setText(ai.getActionMemberName());
				team.setText(ai.getActionTeamName());
				theController = Controller.getInstance();
				theController.setDirtyFlag(true);
			}
			
			
			else	if ((firstcombo.getSelectionModel().getSelectedItem() != null && firstcombo.getSelectionModel().getSelectedItem() != "None")
					&& (secondcombo.getSelectionModel().getSelectedItem() != null  && secondcombo.getSelectionModel().getSelectedItem() != "None" )) {
				String[] h = newlist.getSelectionModel().getSelectedItem().toString().split(" : ");

				String i = h[2].trim();

				ActionItem ai = aiM.setActionItem(i);

				String name = ai.getActionItemName().toString();

				String description = ai.getDescription().toString();

				String resolution = ai.getResolution().toString();

				String status = ai.getStatus().toString();

				ItemName.setText(name);

				Area.setText(description);

				nxtArea.setText(resolution);

				ActiveStatus.setText(status);

				duedate.setText(dateFormat.format(ai.getDueDate()));

				newdate.setText(dateFormat.format(ai.getCreatedDate()));

				member.setText(ai.getActionMemberName());
				team.setText(ai.getActionTeamName());
				theController = Controller.getInstance();
				theController.setDirtyFlag(true);
			}
			else	 {
				

				ActionItem ai = aiM.setActionItem(newlist.getSelectionModel().getSelectedItem().toString());

				String name = ai.getActionItemName().toString();

				String description = ai.getDescription().toString();

				String resolution = ai.getResolution().toString();

				String status = ai.getStatus().toString();

				ItemName.setText(name);

				Area.setText(description);

				nxtArea.setText(resolution);

				ActiveStatus.setText(status);

				duedate.setText(dateFormat.format(ai.getDueDate()));

				newdate.setText(dateFormat.format(ai.getCreatedDate()));

				member.setText(ai.getActionMemberName());
				team.setText(ai.getActionTeamName());
				theController = Controller.getInstance();
				theController.setDirtyFlag(true);
			}
			
					} catch (Exception e) {

		}

	}

	public Boolean getUpdatingGUI() {
		return updatingGUI;
	}

	public void setUpdatingGUI(Boolean updatingGUI) {
		this.updatingGUI = updatingGUI;
	}
	
	
	
private void sort1(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
		
		String c1 = sortcombo.getSelectionModel().getSelectedItem();
		String c2 = firstcombo.getSelectionModel().getSelectedItem();
		String c3 = secondcombo.getSelectionModel().getSelectedItem();
		String c4 = thirdcombo.getSelectionModel().getSelectedItem();

		if (c1 == "Small to Large" && (c2 == "None" || c2 == null) && (c3 == null || c3 == "None") && (c4 == null || c4 == "None") ) {
		
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemNames(ai));

			FXCollections.sort(selectActionItemOptions);
			newlist.getItems().addAll(selectActionItemOptions);

		}

		else if (c1 == "Large to Small" && (c2 == "None" || c2 == null) && (c3 == null || c3 == "None") &&  (c4 == null || c4 == "None")) {
			
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemNames(ai));

			FXCollections.reverse(selectActionItemOptions);
			newlist.getItems().addAll(selectActionItemOptions);

		}

		else if ((c1 == "None" || c1==null) && (c2 == "None" || c2 == null) && (c3 == null || c3 == "None") && (c4 == null || c4 == "None")) {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemNames(ai));

			newlist.getItems().addAll(selectActionItemOptions);

		}

		else if ((c1 == "None" || c1 == null) && c2 == "Assigned Member" && (c3 == null || c3 == "None") && (c4 == null || c4 == "None")) {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemmember(ai));

			newlist.getItems().addAll(selectActionItemOptions);

		}

		else if (c1 == "Small to Large" && c2 == "Assigned Member" && (c3 == null || c3 == "None")&& (c4 == null || c4 == "None") ) {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemmember(ai));
			FXCollections.sort(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}

		else if (c1 == "Large to Small" && c2 == "Assigned Member" && (c3 == null || c3 == "None") && (c4 == null || c4 == "None")) {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemmember(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		else if (c1 == "Small to Large" && c2 == "Assigned Member" && (c3 == null || c3 == "None") && (c4 == "Open")) {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemmemberopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && c2 == "Assigned Member" && (c3 == null || c3 == "None") && (c4 == "Open")) {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemmemberopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Small to Large" && c2 == "Assigned Member" && (c3 == null || c3 == "None") && (c4 == "Closed")) {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemmemberclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && c2 == "Assigned Member" && (c3 == null || c3 == "None") && (c4 == "Closed")) {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemmemberclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}

		else if (c1 == "Small to Large" && c2 == "Assigned Member" && c3 == "Creation Date" && (c4 == null || c4 == "None")) {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedatemember(ai));
			FXCollections.sort(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}

		else if (c1 == "Large to Small" && c2 == "Assigned Member" && c3 == "Creation Date" && (c4 == null || c4 == "None")) {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedatemember(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		else if (c1 == "Small to Large" && c2 == "Assigned Member" && c3 == "Creation Date" && c4 == "Open") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedatememberopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && c2 == "Assigned Member" && c3 == "Creation Date" &&   c4 == "Open") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedatememberopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		
		else if (c1 == "Small to Large" && c2 == "Assigned Member" && c3 == "Creation Date" && c4 == "Closed") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedatememberclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && c2 == "Assigned Member" && c3 == "Creation Date" &&   c4 == "Closed") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedatememberclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		
		
		
		
		else if (c1 == "Small to Large" && c2 == "Assigned Member" && c3 == "Due Date" && c4 == "Open") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedatememberopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && c2 == "Assigned Member" && c3 == "Due Date" &&   c4 == "Open") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedatememberopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		
		else if (c1 == "Small to Large" && c2 == "Assigned Member" && c3 == "Due Date" && c4 == "Closed") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedatememberclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && c2 == "Assigned Member" && c3 == "Due Date" &&   c4 == "Closed") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedatememberclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		
		
		
		
		
		
		
		
		else if ((c1 == null || c1 == "None") && (c2 == null || c2 == "None") && c3 == "Creation Date" && (c4 == null || c4 == "None")) {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedate(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if ((c1 == null || c1 == "None") && (c2 == null || c2 == "None") && c3 == "Due Date" && (c4 == null || c4 == "None")) {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedate(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Small to Large" && (c2 == null || c2 == "None") && c3 == "Creation Date" && (c4 == null || c4 == "None")) {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedate(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && (c2 == null || c2 == "None") && c3 == "Due Date" && (c4 == null || c4 == "None")) {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedate(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		
		
		
		else if (c1 == "Small to Large" && (c2 == null || c2 == "None") && c3 == "Creation Date" && c4 == "Open") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedateopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && (c2 == null || c2 == "None") && c3 == "Creation Date" && c4 == "Open") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedateopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Small to Large" && (c2 == null || c2 == "None") && c3 == "Creation Date" && c4 == "Closed") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedateclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && (c2 == null || c2 == "None") && c3 == "Creation Date" && c4 == "Closed") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemcreatedateclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		
		
		else if (c1 == "Large to Small" && (c2 == null || c2 == "None") && c3 == "Due Date" && c4 == "Closed") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedateclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Small to Large" && (c2 == null || c2 == "None") && c3 == "Due Date" && c4 == "Closed") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedateclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Large to Small" && (c2 == null || c2 == "None") && c3 == "Due Date" && c4 == "Open") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedateopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if (c1 == "Small to Large" && (c2 == null || c2 == "None") && c3 == "Due Date" && c4 == "Open") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedateopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		
		
		else if ((c1 == null || c1 == "None") && (c2 == null || c2 == "None") && c3 == "Due Date" && c4 == "Open") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedateopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if ((c1 == null || c1 == "None") && (c2 == null || c2 == "None") && c3 == "Due Date" && c4 == "Closed") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedateclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		
		else if ((c1 == null || c1 == "None") && (c2 == null || c2 == "None") && c3 == "Creation Date" && c4 == "Open") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedateopen(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		else if ((c1 == null || c1 == "None") && (c2 == null || c2 == "None") && c3 == "Creation Date" && c4 == "Closed") {
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemduedateclosed(ai));
			FXCollections.reverse(selectActionItemOptions);

			newlist.getItems().addAll(selectActionItemOptions);

		}
		

	else if ((c1 == "None" || c1 == null) && (c2 == "None" || c2 == null) && (c3 == null || c3 == "None") && c4 == "Closed" ) {
			
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemstatusclosed(ai));

			FXCollections.sort(selectActionItemOptions);
			newlist.getItems().addAll(selectActionItemOptions);

		}
else if ((c1 == "None" || c1 == null) && (c2 == "None" || c2 == null) && (c3 == null || c3 == "None") && c4 == "Open" ) {
			
			newlist.getItems().clear();
			selectActionItemOptions.clear();
			selectActionItemOptions.addAll(aiM.getActionItemstatusopen(ai));

			FXCollections.sort(selectActionItemOptions);
			newlist.getItems().addAll(selectActionItemOptions);

		}
		
		
else if ((c1 == "None" || c1 == null) && c2 == "Assigned Member" && (c3 == null || c3 == "None") && c4=="Open") {
	newlist.getItems().clear();
	selectActionItemOptions.clear();
	selectActionItemOptions.addAll(aiM.getActionItemmemberopen(ai));

	newlist.getItems().addAll(selectActionItemOptions);

}
		
else if ((c1 == "None" || c1 == null) && c2 == "Assigned Member" && (c3 == null || c3 == "None") && c4=="Closed") {
	newlist.getItems().clear();
	selectActionItemOptions.clear();
	selectActionItemOptions.addAll(aiM.getActionItemmemberclosed(ai));

	newlist.getItems().addAll(selectActionItemOptions);

}



		

	}
	
	
	
	
	
	
	
}
