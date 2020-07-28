package gui;

import control.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Element;
import model.Elementlist;

/**
 * <p>
 * Title: MemberScreen
 * </p>
 *
 * <p>
 * Description: The Della Member Screen code
 * </p>
 *
 * <p>
 * Copyright: Copyright � 2007
 * </p>
 *
 * @author Lynn Robert Carter, Modified by Sawan Gaba
 * @version 1.01 Many thanks to Harry Sameshima for his original work.
 */

public class MemberScreen {
	private Label Name = new Label("Name of someone new(Last, First Middle)");
	private Label AddName = new Label("To add a name to the list:");
	private Label Click = new Label("1. Click on the box above.");
	private Label Type = new Label("2.Type the name.");
	private Label Addlist = new Label("3.Click to \u201C Add to list\u201D Button.");
	public static TextField text1 = new TextField();
	private Label RemoveName = new Label("To remove a name to the list:");
	private Label ClickName = new Label("1. Click on the name to remove.");
	private Label Removelist = new Label("2. Click on \u201C Remove from list\u201D Button.");
	private Button Add = new Button("Add to List ->");
	private Button Remove = new Button("<- Remove from List");

	private Button Addaf = new Button("Add affiliation ->");
	private Button Removeaf = new Button("<-Remove affiliation");
	private Label Affiliation = new Label("To add a team affiliation for an individual.");
	private Label Affiliation1 = new Label("1.Click on the name of the individual above right.");
	private Label Affiliation2 = new Label("2.Click on a team name in the list below.");
	private Label Affiliation3 = new Label("3.Click on \u201C Add affiliation \u201C button. ");
	private Label Affiliation4 = new Label("Available teams for ");
	private Label Affiliation44 = new Label("Current teams for ");
	private Label Affiliation6 = new Label("Click on a individual's name " + "\n" + "to see team affiliation ");
	private Label removeAffiliation = new Label("To remove a team affiliation for an individual:");
	private Label removeAffiliation1 = new Label("1. Click on the name of the individual above.");
	private Label removeAffiliation2 = new Label("2. Click on a team name in the list below.");
	private Label removeAffiliation3 = new Label("3. Click on \"Remove affiliation\" button.");

	private Label Affiliation5 = new Label();
	private Label Affiliation55 = new Label();
	public static ListView<String> teamlist = new ListView<String>();

	public static ListView<String> Memberlist = new ListView<String>();

	public static ListView<String> currentteam = new ListView<String>();

	private Boolean updatingGUI = false;

	public static ObservableList<String> selectActionItemOptions1 = FXCollections.observableArrayList();
	public static ObservableList<String> selectActionItemOptions33 = FXCollections.observableArrayList();
	public static ObservableList<String> selectActionItemOptions333 = FXCollections.observableArrayList();

	private Label LxtName = new Label("Individuals known by Della");
	private Elementlist ei = null;

	private Controller theController = null;

	public MemberScreen(Group mainGroup) {

		theController = Controller.getInstance();
		ei = theController.getElementlist();
		loadScreen();
		Name.setLayoutX(15);
		Name.setLayoutY(120);
		Name.setStyle("-fx-font-weight: bold");

		text1.setLayoutX(15);
		text1.setLayoutY(140);
		text1.setPrefWidth(200);

		AddName.setLayoutX(15);
		AddName.setLayoutY(180);
		AddName.setStyle("-fx-font-weight: bold");

		Click.setLayoutX(15);
		Click.setLayoutY(200);

		Type.setLayoutX(15);
		Type.setLayoutY(220);

		Addlist.setLayoutX(15);
		Addlist.setLayoutY(240);

		RemoveName.setLayoutX(15);
		RemoveName.setLayoutY(300);
		RemoveName.setStyle("-fx-font-weight: bold");

		removeAffiliation.setLayoutX(420);
		removeAffiliation.setLayoutY(330);
		removeAffiliation.setStyle("-fx-font-weight: bold");

		removeAffiliation1.setLayoutX(420);
		removeAffiliation1.setLayoutY(350);

		removeAffiliation2.setLayoutX(420);
		removeAffiliation2.setLayoutY(370);

		removeAffiliation3.setLayoutX(420);
		removeAffiliation3.setLayoutY(390);

		ClickName.setLayoutX(15);
		ClickName.setLayoutY(320);

		Removelist.setLayoutX(15);
		Removelist.setLayoutY(340);

		Add.setLayoutX(250);
		Add.setLayoutY(200);
		Add.setPrefWidth(150);
		Add.setOnAction(e -> {

			try {
				crtscreen();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});

		Remove.setLayoutX(250);
		Remove.setLayoutY(250);
		Remove.setPrefWidth(150);
		Remove.setOnAction(e -> {

			final int selectedIdx = Memberlist.getSelectionModel().getSelectedIndex();
			if (selectedIdx != -1) {
				@SuppressWarnings("unused")
				final int newSelectedIdx = (selectedIdx == Memberlist.getItems().size() - 1) ? selectedIdx - 1
						: selectedIdx;

				Memberlist.getItems().remove(selectedIdx);

			}
		});

		Memberlist.setLayoutX(430);
		Memberlist.setLayoutY(140);
		Memberlist.setPrefHeight(150);
		Memberlist.setPrefWidth(200);

		LxtName.setLayoutX(450);
		LxtName.setLayoutY(120);
		LxtName.setStyle("-fx-font-weight: bold");

		Affiliation.setLayoutX(15);
		Affiliation.setLayoutY(380);
		Affiliation.setStyle("-fx-font-weight: bold");

		Affiliation1.setLayoutX(15);
		Affiliation1.setLayoutY(400);

		Affiliation2.setLayoutX(15);
		Affiliation2.setLayoutY(420);

		Affiliation3.setLayoutX(15);
		Affiliation3.setLayoutY(440);

		Affiliation4.setLayoutX(15);
		Affiliation4.setLayoutY(460);
		Affiliation4.setStyle("-fx-font-weight: bold");

		Affiliation6.setLayoutX(250);
		Affiliation6.setLayoutY(300);
		Affiliation6.setStyle("-fx-font-weight: bold");

		Affiliation44.setLayoutX(450);
		Affiliation44.setLayoutY(460);
		Affiliation44.setStyle("-fx-font-weight: bold");

		Affiliation5.setLayoutX(15);
		Affiliation5.setLayoutY(480);

		Affiliation55.setLayoutX(450);
		Affiliation55.setLayoutY(480);

		teamlist.setLayoutX(15);
		teamlist.setLayoutY(510);
		teamlist.setPrefHeight(80);
		teamlist.setPrefWidth(200);

		currentteam.setLayoutX(450);
		currentteam.setLayoutY(510);
		currentteam.setPrefHeight(80);
		currentteam.setPrefWidth(200);

		Addaf.setLayoutX(250);
		Addaf.setLayoutY(450);
		Addaf.setPrefWidth(150);
		Addaf.setOnAction(e -> {
			crtscreen1();
		});

		Removeaf.setLayoutX(250);
		Removeaf.setLayoutY(500);
		Removeaf.setPrefWidth(150);
		
		Removeaf.setOnAction(e ->{
			final int selectedIdx = currentteam.getSelectionModel().getSelectedIndex();
			if (selectedIdx != -1) {
				@SuppressWarnings("unused")
				final int newSelectedIdx = (selectedIdx == currentteam.getItems().size() - 1) ? selectedIdx - 1
						: selectedIdx;

				currentteam.getItems().remove(selectedIdx);
			}
		});

		Memberlist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue)
					throws NullPointerException {
				selectActionItem(observableValue, oldValue, newValue);
			}

		});
		;

		mainGroup.getChildren().addAll(Name, text1, AddName, Click, Type, Addlist, RemoveName, ClickName, Removelist,
				Add, Remove, Memberlist, LxtName, Affiliation, Affiliation1, Affiliation2, Affiliation3, Affiliation4,
				Affiliation5, removeAffiliation, removeAffiliation1, removeAffiliation2, removeAffiliation3, teamlist,
				currentteam, Affiliation44, Affiliation55, Addaf, Removeaf, Affiliation6);

	}

	public void loadScreen() {

		Element e = ei.getCurrentActionItem();
		selectActionItemOptions33.clear();
		selectActionItemOptions333.clear();
		currentteam.getItems().clear();
		selectActionItemOptions333.addAll(ei.getActionItemNames(e));
		Affiliation55.setText(e.getMemberName());
		selectActionItemOptions33.addAll(ei.getActionItemNames1(e));
		currentteam.getItems().addAll(selectActionItemOptions33);
		setUpdatingGUI(true);

		// Fetch the current action item. If there isn't one, leave now

		selectActionItemOptions1.clear();
		Memberlist.getItems().clear();
		selectActionItemOptions1.addAll(ei.getActionItemNames(e));
		Memberlist.getItems().addAll(selectActionItemOptions1);
		teamlist.getItems().addAll(ei.getActionItemNames1(e));

		// Define the text fields
		setUpdatingGUI(true);

	}

	private void crtscreen() throws NullPointerException {

		System.out.println(text1.getText());

		Memberlist.getItems().add(text1.getText());

		try {

			ei.createActionItem1(text1.getText());

		} catch (Exception e) {
			e.printStackTrace();
		}

		theController.setDirtyFlag(true);

	}

	private void crtscreen1() throws NullPointerException {

		currentteam.getItems().add(text1.getText());

		try {

			ei.createActionItem33(Memberlist.getSelectionModel().getSelectedItem().toString(),
					teamlist.getSelectionModel().getSelectedItem().toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		theController.setDirtyFlag(true);

	}

	void selectActionItem(ObservableValue<? extends String> ov, String oldValue, String newValue)
			throws NullPointerException {
		Affiliation5.setText(Memberlist.getSelectionModel().getSelectedItem().toString());
	}

	public Boolean getUpdatingGUI() {
		return updatingGUI;
	}

	public void setUpdatingGUI(Boolean updatingGUI) {
		this.updatingGUI = updatingGUI;
	}
}