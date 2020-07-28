package gui;

import java.util.Optional;

import control.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.ActionItemManager;

/**
 * <p>
 * Title: MainScreen
 * </p>
 *
 * <p>
 * Description: A manually generated screen for Della. The navagation buttons
 * are defined here and the other subordinate screens fill in the subscreen
 * details (e.g. ConsoleScreen and ActionItemScreen)
 * </p>
 *
 * <p>
 * Copyright: Copyright � 2005, 2006, 2007
 * </p>
 *
 * @author Harry Sameshima, Lynn Robert Carter, Modified by Sawan
 *         2020-01-25
 * @version 1.01
 */
public class MainScreen {
// ---------------------------------------------------------------------------------------------------------------------
// Main (common) Screen constants

// ---------------------------------------------------------------------------------------------------------------------
// Main (common) Screen attributes
	private Button consoleButton = new Button("Console");
	private Button actionItemsButton = new Button("Action Items");
	private Button membersButton = new Button("Members");
	private Button teamsButton = new Button("Teams");
	private Button quitButton = new Button("Quit");

	private Separator separator1 = new Separator(Orientation.HORIZONTAL);
	private Label mainLabel = new Label("   Console  ");
	private Separator separator2 = new Separator(Orientation.HORIZONTAL);

	private Controller theController = null;

	private Group groupMain = new Group();
	private Group actionItemGroup = new Group();
	private Group membersGroup = new Group();
	private Group teamGroup = new Group();
	private Group consoleGroup = new Group();

	private ActionItemScreen actionItemScreen = null;
	private ConsoleScreen consoleScreen = new ConsoleScreen(groupMain);
	private MemberScreen memberScreen = null;
	private TeamScreen teamScreen = null;

	/**
	 * The MainScreen class constructor
	 *
	 * @param mainPane
	 */
	public MainScreen(Pane mainPane) {
// Force a read of the controller from the persistent store
		theController = Controller.getInstance();

		guiInit(mainPane);
	}

	/**
	 * The GUI initialization.
	 *
	 * @param mainPane
	 */
	private void guiInit(Pane mainPane) {
		setupButtonUI(consoleButton, "Arial", 16, 100, Pos.BASELINE_CENTER, 50, 10);
		consoleButton.setOnAction(e -> {
			showConsole(consoleGroup, e);
		});

		setupButtonUI(actionItemsButton, "Arial", 16, 100, Pos.BASELINE_CENTER, 170, 10);
		actionItemsButton.setOnAction(e -> {
			showActionItems(actionItemGroup, e);
		});

		setupButtonUI(membersButton, "Arial", 16, 100, Pos.BASELINE_CENTER, 300, 10);
		membersButton.setOnAction(e -> {
			showMembers(membersGroup, e);
		});

		setupButtonUI(teamsButton, "Arial", 16, 100, Pos.BASELINE_CENTER, 420, 10);
		teamsButton.setOnAction(e -> {
			showTeams(teamGroup, e);
		});

		setupButtonUI(quitButton, "Arial", 16, 100, Pos.BASELINE_CENTER, 540, 10);
		quitButton.setOnAction(e -> {
			doQuit(e);
		});

		setupSeparatorUI(separator1, 700, 0, 60);
		setupLabelUI(mainLabel, "Arial", 18, 50, Pos.BASELINE_LEFT, 300, 60);
		setupSeparatorUI(separator2, 700, 0, 80);

		actionItemGroup.setVisible(false);
		membersGroup.setVisible(false);
		teamGroup.setVisible(false);
		consoleGroup.setVisible(true);

		consoleScreen = new ConsoleScreen(consoleGroup);
		mainPane.getChildren().addAll(consoleButton, actionItemsButton, membersButton, teamsButton, quitButton,
				separator1, mainLabel, separator2, actionItemGroup, membersGroup, teamGroup, consoleGroup);

	}

	/**
	 * Private local method to initialize the standard fields for a Button
	 *
	 * @param b  Button
	 * @param ff Font-Family
	 * @param f  Font-Size
	 * @param w  Width
	 * @param p  Position
	 * @param x  X-Axis
	 * @param y  Y-Axis
	 */
	private void setupButtonUI(Button b, String ff, double f, double w, Pos p, double x, double y) {
		b.setFont(Font.font(ff, FontWeight.BOLD, f));
		b.setMinWidth(w);
		b.setAlignment(p);
		b.setLayoutX(x);
		b.setLayoutY(y);
	}

	/**
	 * Private local method to initialize the standard fields for a Label
	 *
	 * @param l  Label
	 * @param ff Font-Family
	 * @param f  Font-Size
	 * @param w  Width
	 * @param p  Position
	 * @param x  X-Axis
	 * @param y  Y-Axis
	 */
	private void setupLabelUI(Label l, String ff, double f, double w, Pos p, double x, double y) {
		l.setFont(Font.font(ff, FontWeight.BOLD, f));
		l.setMinWidth(w);
		l.setAlignment(p);
		l.setLayoutX(x);
		l.setLayoutY(y);
	}

	/**
	 * Private local method to initialize the standard fields for a Separator
	 *
	 * @param l Separator
	 * @param w Width
	 * @param x X-Axis
	 * @param y Y-Axis
	 */
	private void setupSeparatorUI(Separator l, double w, double x, double y) {
		l.setMinWidth(w);
		l.setLayoutX(x);
		l.setLayoutY(y);
	}

	/**
	 * This shared routine checks to see if edits are pending and warns the user if
	 * editing work might be lost.
	 *
	 * @return
	 */
	private boolean okayToChangeScreens() {
		ActionItemManager aiM = theController.getActionItemManager();
		if (aiM.getEditChangesPending()) {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Screen Change or Quit Requested with Pending Edits!");
			String s = "\n" + "A Screen Change or a Quit has been requested and there"
					+ " are pending edits to this Action Item!\n\n" + "Do you want to discard these edits?\n"
					+ "Click \"Yes\" to discard these edits.\n" + "Click \"No\" to return to Action Items Screen.\n";
			alert.setContentText(s);
			ButtonType okButton = new ButtonType("Yes");
			ButtonType noButton = new ButtonType("No");
			alert.getButtonTypes().setAll(okButton, noButton);
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == okButton) {
				aiM.setEditChangesPending(false);
				return true;
			} else
				return false;
		} else
			return true;
	}

	/**
	 * Code to handle the "Quit" button. If Della's state has changed, ask if we
	 * want to save it.
	 *
	 * @param e ActionEvent
	 */
	private void doQuit(ActionEvent e) {
		if (okayToChangeScreens()) {
			if (theController.getDirtyFlag()) {
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Quit requested with unsaved Action Item!");
				String s = " \n" + "A Quit has been requested and there are updated\n"
						+ "Action Items that have not been saved!\n\n" + "Do you want to save these Action Items?\n"
						+ "Click \"Yes\" to save the changed Action Items.\n" + "Click \"No\" to ignore the changes.";
				alert.setContentText(s);
				ButtonType okButton = new ButtonType("Yes");
				ButtonType noButton = new ButtonType("No");
				alert.getButtonTypes().setAll(okButton, noButton);
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == okButton) {
					theController.save();
				}
			}
			System.exit(0);
		}

	}

	/**
	 * Code to change over to the Member Screen
	 *
	 * @param g  Group
	 * @param ae
	 */
	private void showMembers(Group g, ActionEvent ae) {
		if (okayToChangeScreens()) {
			mainLabel.setText("   Members  ");
			if (memberScreen == null) {
				memberScreen = new MemberScreen(g);
			}
			actionItemGroup.setVisible(false);
			membersGroup.setVisible(true);
			teamGroup.setVisible(false);
			consoleGroup.setVisible(false);
		}
	}

	/**
	 * Code to change over to the Teams Screen
	 *
	 * @param g  Group
	 * @param ae
	 */
	private void showTeams(Group g, ActionEvent ae) {
		if (okayToChangeScreens()) {
			mainLabel.setText("    Teams   ");
			if (teamScreen == null) {
				teamScreen = new TeamScreen(g);
			}
			actionItemGroup.setVisible(false);
			membersGroup.setVisible(false);
			teamGroup.setVisible(true);
			consoleGroup.setVisible(false);
		}
	}

	/**
	 * Code to change over to the Action Items Screen
	 *
	 * @param g  Group
	 * @param ae
	 */
	private void showActionItems(Group g, ActionEvent ae) {
		mainLabel.setText("Action Items");
		if (actionItemScreen == null) {
			actionItemScreen = new ActionItemScreen(g);
		}
		actionItemScreen.loadScreen();
		actionItemGroup.setVisible(true);
		membersGroup.setVisible(false);
		teamGroup.setVisible(false);
		consoleGroup.setVisible(false);
	}

	/**
	 * Code to change over to the Teams Screen
	 *
	 * @param g  Group
	 * @param ae ActionEvent
	 */
	private void showConsole(Group g, ActionEvent ae) {
		if (okayToChangeScreens()) {
			mainLabel.setText("   Console  ");
			if (consoleScreen == null) {
				consoleScreen = new ConsoleScreen(g);
			}
			actionItemGroup.setVisible(false);
			membersGroup.setVisible(false);
			teamGroup.setVisible(false);
			consoleGroup.setVisible(true);
		}
	}

}