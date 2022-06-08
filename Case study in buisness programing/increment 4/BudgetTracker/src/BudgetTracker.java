
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;  
import javax.swing.JComboBox;


import java.sql.*;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/*
 * Malik Johnson
 * BudgetTracker
 */



public class BudgetTracker extends Application {
	//database connection
	private static Connection m_conn;
	
	//Buttons for main page UI.
		private Button createUser = new Button("Create User");
		private Button deleteUser = new Button("Delete User");
		private Button modifyUser = new Button("Modify User");
		private Button addBudget = new Button("Add Budget");
		private Button deleteBudget = new Button("Delete Budget");
		private Button modifyBudget = new Button("Modify Budget");
		private Button addItem = new Button("Add Item");
		private Button deleteItem = new Button("Delete Item");
		private Button modifyItem = new Button("Modify Item");
		private Button createDisplay = new Button("Create Display");
		private Button deleteDisplay = new Button("Delete Display");
		private Button displayBudget = new Button("Display Budget");
		private Button displayItems = new Button("Display Items");
		private Button displayUsers = new Button("Display Users");
		private Button setReminder = new Button("Set Reminder");
		private Button help = new Button("Help Info");
		private Button exitProgram = new Button("Exit Program");
		
		
		
		//Create user text fields
		private TextField username = new TextField();
		private TextField password = new TextField();
		private TextField firstName = new TextField();
		private TextField lastName = new TextField();
		private TextField budgetAmount = new TextField();
		private TextField incomeAmount = new TextField();
		private TextField savingsAmount = new TextField();
		private TextField numberOfBankAccounts = new TextField();
		private TextField bankAccountTotal = new TextField();
		
		
		//Create user labels
		Label usernameLabel = new Label("Username: ");
		Label passwordLabel = new Label("Password: ");
		Label firstNameLabel = new Label("First Name: ");
		Label lastNameLabel = new Label("Last Name: ");
		Label budgetAmountLabel = new Label("Budget Amount: ");
		Label incomeAmountLabel = new Label("Income Amount: ");
		Label savingsAmountLabel = new Label("Savings Amount: ");
		Label numberOfBankAccountsLabel = new Label("# of Bank Accounts: ");
		Label bankAccountTotalLabel = new Label("Bank Account Total: ");
		
		
		//Buttons for create user
		private Button submitButtonUser = new Button("SUBMIT");
		private Button clearButtonUser = new Button("CLEAR");
		private Button backButtonUser = new Button("BACK");
		
		//Delete user text fields
		private TextField username2 = new TextField();
		private TextField password2 = new TextField();
		
		//Delete user button
		private Button deleteUserPerm = new Button("Delete User");
		private Button backButtonDelete = new Button("BACK");
		
		//Delete user labels
		Label usernameLabel2 = new Label("Username: ");
		Label passwordLabel2 = new Label("Password: ");
		
		//Modify user text fields
		private TextField modifyUsername = new TextField();
		private TextField modifyNewUsername = new TextField();
		private TextField modifyPassword = new TextField();
		private TextField modifyNewPassword = new TextField();
		private TextField modifyFirstName = new TextField();
		private TextField modifyLastName = new TextField();
		private TextField modifyBudgetAmount = new TextField();
		private TextField modifyIncomeAmount = new TextField();
		private TextField modifySavingsAmount = new TextField();
		private TextField modifyNumberOfBankAccounts = new TextField();
		private TextField modifyBankAccountTotal = new TextField();
		
		
		//Modify user labels
		Label modifyUsernameLabel = new Label("Old Username: ");
		Label modifyNewUsernameLabel = new Label("New Username: ");
		Label modifyPasswordLabel = new Label("Old Password: ");
		Label modifyNewPasswordLabel = new Label("New Password: ");
		Label modifyFirstNameLabel = new Label("First Name: ");
		Label modifyLastNameLabel = new Label("Last Name: ");
		Label modifyBudgetAmountLabel = new Label("Budget Amount: ");
		Label modifyIncomeAmountLabel = new Label("Income Amount: ");
		Label modifySavingsAmountLabel = new Label("Savings Amount: ");
		Label modifyNumberOfBankAccountsLabel = new Label("# of Bank Accounts: ");
		Label modifyBankAccountTotalLabel = new Label("Bank Account Total: ");
		
		
		//Buttons for modify user
		private Button modifySubmitButtonUser = new Button("SUBMIT");
		private Button modifyClearButtonUser = new Button("CLEAR");
		private Button modifyBackButtonUser = new Button("BACK");
		
		
		//Buttons for add Budget
		private String budgetType;
		private RadioButton rbWeekly = new RadioButton("Weekly");
		private RadioButton rbMonthly = new RadioButton("Monthly");
		private RadioButton rbYearly = new RadioButton("Yearly");
		private ToggleGroup testGroup = new ToggleGroup();
		private Button backButtonBudget = new Button("BACK");
		private Button submitButtonBudget = new Button("SUBMIT");
		private Button clearButtonBudget = new Button("CLEAR");
		
		//Add Budget Labels
		Label budgetAmountTotalLabel = new Label("Enter budget amount: ");
		Label budgetNameLabel = new Label("Enter budget name: ");
		Label userNameBudgetLabel = new Label("Enter username budget belongs to: ");
		
		
		//Add Budget Text Fields
		private TextField budgetAmountTotal = new TextField();
		private TextField budgetName = new TextField();
		private TextField userNameBudget = new TextField();
		
		//Buttons for modify Budget
		private String modifyBudgetType;
		private RadioButton modifyRbWeekly = new RadioButton("Weekly");
		private RadioButton modifyRbMonthly = new RadioButton("Monthly");
		private RadioButton modifyRbYearly = new RadioButton("Yearly");
		private ToggleGroup modifyTestGroup = new ToggleGroup();
		private Button modifyBackButtonBudget = new Button("BACK");
		private Button modifySubmitButtonBudget = new Button("SUBMIT");
		private Button modifyClearButtonBudget = new Button("CLEAR");
				
		//Modify Budget Labels
		Label modifyBudgetAmountTotalLabel = new Label("Enter budget amount: ");
		Label modifyBudgetNameLabel = new Label("Enter old budget name: ");
		Label modifyNewBudgetNameLabel = new Label("Enter new budget name: ");
		Label modifyUserNameBudgetLabel = new Label("Enter username budget belongs to: ");
				
				
		//Modify Budget Text Fields
		private TextField modifyBudgetAmountTotal = new TextField();
		private TextField modifyBudgetName = new TextField();
		private TextField modifyNewBudgetName = new TextField();
		private TextField modifyUserNameBudget = new TextField();
		
		//Buttons for delete Budget
		private Button deleteBackButtonBudget = new Button("BACK");
		private Button deleteSubmitButtonBudget = new Button("DELETE BUDGET");
				
		//Delete Budget Labels
		Label deleteBudgetNameLabel = new Label("Enter budget name: ");
		Label deleteUserNameBudgetLabel = new Label("Enter username budget belongs to: ");
				
				
		//Delete Budget Text Fields
		private TextField deleteBudgetName = new TextField();
		private TextField deleteUserNameBudget = new TextField();
		
		//Add Item Buttons
		private Button submitButtonItem = new Button("SUBMIT");
		private Button clearButtonItem = new Button("CLEAR");
		private Button backButtonItem = new Button("BACK");
		
		//Add Item Combo Box Variables
		private String[] itemCategories = {"Applicances","Automotive and Vehicals", "Beauty Products","Bills and Loans", "Books and CDS","Clothing and Jewlery", "Electronics and Apps", "Entertainment","Food and Groceries", "Movies and Tv","Pets","Miscellaneous","Office Products and Home Improvement", "Toys and Children"};
		//JComboBox itemCategoriesList = new JComboBox(itemCategories);
		private ComboBox<String> itemCombo = new ComboBox<>();
		ObservableList<String>items = FXCollections.observableArrayList(itemCategories);
		String itemChoice="";
		
		//Add Item Date Box Variables
		private String[] itemDateMonths = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		private ComboBox<String> itemComboMonths = new ComboBox<>();
		ObservableList<String>Months = FXCollections.observableArrayList(itemDateMonths);
		String monthChoice="";
		private String[] itemDateDays = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		private ComboBox<String> itemComboDays = new ComboBox<>();
		ObservableList<String>Days = FXCollections.observableArrayList(itemDateDays);
		String dayChoice="";
		
		//Add Item Labels
		Label itemNameLabel = new Label("Enter item name: ");
		Label itemPriceLabel = new Label("Enter item price: ");
		Label itemQuantityLabel = new Label("Enter item quantity: ");
		Label itemDateLabel = new Label("Enter purchase date: DD/MMM/YYYY");
		Label itemBudgetNameLabel = new Label("Enter budget to add item to: ");
		Label itemCategoryLabel = new Label("Enter item category: ");
	
		
		
		
		//Add Item Text Fields
		private TextField itemName = new TextField();
		private TextField itemPrice = new TextField();
		private TextField itemQuantity = new TextField();
		private TextField itemDate = new TextField();
		private TextField itemBudgetName = new TextField();
		private TextField itemCategory = new TextField();
		
		//Delete Item Date Box Variables
		private String[] deleteItemDateMonths = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		private ComboBox<String> deleteItemComboMonths = new ComboBox<>();
		ObservableList<String>deleteMonths = FXCollections.observableArrayList(deleteItemDateMonths);
		String deleteMonthChoice="";
		private String[] deleteItemDateDays = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		private ComboBox<String> deleteItemComboDays = new ComboBox<>();
		ObservableList<String>deleteDays = FXCollections.observableArrayList(deleteItemDateDays);
		String deleteDayChoice="";
		
		//Delete Item Buttons
		private Button deleteSubmitButtonItem = new Button("DELETE ITEM");
		private Button deleteBackButtonItem = new Button("BACK");
		private Button deleteClearButtonItem = new Button("CLEAR");
		
		//Delete Item Labels
		Label deleteItemNameLabel = new Label("Enter item name: ");
		Label deleteItemBudgetNameLabel = new Label("Enter budget to delete item from: ");
		Label deleteItemCategoryLabel = new Label("Enter item category: ");
		Label deleteItemDateLabel = new Label("Enter purchase date: DD/MMM/YYYY");
	
		
		//Delete Item Text Fields
		private TextField deleteItemName = new TextField();
		private TextField deleteItemDate = new TextField();
		private TextField deleteItemBudgetName = new TextField();
		
		//Modify Item Combo Box Variables
		private String[] modifyItemCategories = {"Appliances","Automotive and Vehicals", "Beauty Products","Bills and Loans", "Books and CDS","Clothing and Jewlery", "Electronics and Apps", "Entertainment","Food and Groceries", "Movies and Tv","Pets","Miscellaneous","Office products and Home Improvement", "Toys and Children"};
		//JComboBox itemCategoriesList = new JComboBox(itemCategories);
		private ComboBox<String> modifyItemCombo = new ComboBox<>();
		ObservableList<String>modifyItems = FXCollections.observableArrayList(modifyItemCategories);
		String modifyItemChoice="";
				
		//Modify Item Date Box Variables
		private String[] modifyItemDateMonths = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		private ComboBox<String> modifyItemComboMonths = new ComboBox<>();
		ObservableList<String>modifyMonths = FXCollections.observableArrayList(modifyItemDateMonths);
		String modifyMonthChoice="";
		private String[] modifyItemDateDays = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		private ComboBox<String> modifyItemComboDays = new ComboBox<>();
		ObservableList<String>modifyDays = FXCollections.observableArrayList(modifyItemDateDays);
		String modifyDayChoice="";
		
		//Modify new Item Date Box Variables
		private String[] modifyNewItemDateMonths = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		private ComboBox<String> modifyNewItemComboMonths = new ComboBox<>();
		ObservableList<String>modifyNewMonths = FXCollections.observableArrayList(modifyNewItemDateMonths);
		String modifyNewMonthChoice="";
		private String[] modifyNewItemDateDays = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		private ComboBox<String> modifyNewItemComboDays = new ComboBox<>();
		ObservableList<String>modifyNewDays = FXCollections.observableArrayList(modifyNewItemDateDays);
		String modifyNewDayChoice="";
		
		
		//Modify Item Buttons
		private Button modifySubmitButtonItem = new Button("SUBMIT");
		private Button modifyClearButtonItem = new Button("CLEAR");
		private Button modifyBackButtonItem = new Button("BACK");
		
		//Modify Item Labels
		Label modifyItemNameLabel = new Label("Enter item name: ");
		Label modifyNewItemNameLabel = new Label("Enter new item name: ");
		Label modifyItemPriceLabel = new Label("Enter new item price: ");
		Label modifyItemQuantityLabel = new Label("Enter new item quantity: ");
		Label modifyItemDateLabel = new Label("Enter purchase date: DD/MMM/YYYY");
		Label modifyNewItemDateLabel = new Label("Enter new purchase date: DD/MMM/YYYY");
		Label modifyItemBudgetNameLabel = new Label("Enter budget item belongs to: ");
		Label modifyItemCategoryLabel = new Label("Enter new item category: ");
			
				
		//Modify Item Text Fields
		private TextField modifyItemName = new TextField();
		private TextField modifyNewItemName = new TextField();
		private TextField modifyItemPrice = new TextField();
		private TextField modifyItemQuantity = new TextField();
		private TextField modifyItemDate = new TextField();
		private TextField modifyNewItemDate = new TextField();
		private TextField modifyItemBudgetName = new TextField();
		private TextField modifyItemCategory = new TextField();
		
		//Display Items fields and buttons
		private TextArea itemNames = new TextArea();
		private Label userBudgetLabel = new Label("Enter a budget name to display the items attached to it: ");
		private TextField userBudgetName = new TextField();
		private Button submitItemQuery = new Button("Submit");
		
		//Create Display Textfields
		private TextField displayName = new TextField();
		private TextField budgetNameDisplay = new TextField();
		
		//Create Display Labels
		Label displayNameLabel = new Label("Enter display name: ");
		Label budgetNameDisplayLabel = new Label("Enter budget name for display: ");
		
		
		//Create Display Buttons
		private String displayTypeGraph;
		private String displayTypeVert;
		private RadioButton rbPieChart = new RadioButton("Pie Chart");
		private RadioButton rbBarGraph = new RadioButton("Bar Graph");
		private RadioButton rbVertical = new RadioButton("Vertical");
		private RadioButton rbHorizontal = new RadioButton("Horizontal");
		private ToggleGroup testGroupDisplayGraph = new ToggleGroup();
		private ToggleGroup testGroupDisplayVert = new ToggleGroup();
		private Button backButtonDisplay = new Button("BACK");
		private Button submitButtonDisplay = new Button("SUBMIT");
				
				
		//Display Budget fields and buttons
		
		private Label enterDisplayName = new Label("Enter a display name for a budget: ");
		private TextField enterDisplay = new TextField();
		private Button submitDisplayBudget = new Button("Submit");
        
		//stages used
		Stage stageUserCreation = new Stage();
		Stage stageUserDeletion = new Stage();
		Stage stageUserModification = new Stage();
		Stage stageAddBudget = new Stage();
		Stage stageDeleteBudget = new Stage();
		Stage stageModifyBudget = new Stage();
		Stage stageAddItem = new Stage();
		Stage stageDeleteItem = new Stage();
		Stage stageModifyItem = new Stage();
		Stage stageDisplayItem = new Stage();
		Stage stageDisplayUser = new Stage();
		Stage stageDisplayBudget = new Stage();
		Stage stageDisplayBudgetGraph = new Stage();
		Stage stageCreateDisplay = new Stage();
		
		
	public void start(Stage primaryStage)
	{
		
		        //create main pane
				GridPane paneMain = new GridPane();
				paneMain.setAlignment(Pos.CENTER);
				paneMain.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
				paneMain.setHgap(5.5);
				paneMain.setVgap(5.5);
				paneMain.add(createUser, 0, 0);
				paneMain.add(deleteUser, 1, 0);
				paneMain.add(modifyUser, 2, 0);
				paneMain.add(addBudget, 0, 1);
				paneMain.add(deleteBudget, 1, 1);
				paneMain.add(modifyBudget, 2, 1);
				paneMain.add(addItem, 0, 2);
				paneMain.add(deleteItem, 1, 2);
				paneMain.add(modifyItem, 2, 2);
				paneMain.add(createDisplay, 0, 3);
				paneMain.add(deleteDisplay, 1, 3);
				paneMain.add(displayBudget, 2, 3);
				paneMain.add(displayItems, 0, 4);
				paneMain.add(displayUsers, 1, 4);
				paneMain.add(setReminder, 2, 4);
				paneMain.add(help, 0, 5);
				paneMain.add(exitProgram, 1, 5);
				
				//create main scene
				Scene sceneMain = new Scene(paneMain, 400, 400);
				
				//Add items to comboBox on create Item page
				itemCombo.getItems().addAll(items);
				itemComboMonths.getItems().addAll(Months);
				itemComboDays.getItems().addAll(Days);
				
				//Delete items to comboBox on delete Item page
				deleteItemComboMonths.getItems().addAll(deleteMonths);
				deleteItemComboDays.getItems().addAll(deleteDays);
				
				//Modify items to comboBox on modify item page
				modifyItemCombo.getItems().addAll(modifyItems);
				modifyItemComboMonths.getItems().addAll(modifyMonths);
				modifyItemComboDays.getItems().addAll(modifyDays);
				
				//Modify new items to comboBox on modify item page
				modifyNewItemComboMonths.getItems().addAll(modifyNewMonths);
				modifyNewItemComboDays.getItems().addAll(modifyNewDays);
				
				//actions for buttons
				itemCombo.setOnAction(e->setChoice(items.indexOf(itemCombo.getValue())));
				itemComboMonths.setOnAction(e->setMonth(Months.indexOf(itemComboMonths.getValue())));
				itemComboDays.setOnAction(e->setDay(Days.indexOf(itemComboDays.getValue())));
				deleteItemComboMonths.setOnAction(e->deleteSetMonth(deleteMonths.indexOf(deleteItemComboMonths.getValue())));
				deleteItemComboDays.setOnAction(e->deleteSetDay(deleteDays.indexOf(deleteItemComboDays.getValue())));
				modifyItemCombo.setOnAction(e->modifySetChoice(modifyItems.indexOf(modifyItemCombo.getValue())));
				modifyItemComboMonths.setOnAction(e->modifySetMonth(modifyMonths.indexOf(modifyItemComboMonths.getValue())));
				modifyItemComboDays.setOnAction(e->modifySetDay(modifyDays.indexOf(modifyItemComboDays.getValue())));
				//For new date
				modifyNewItemComboMonths.setOnAction(e->modifyNewSetMonth(modifyNewMonths.indexOf(modifyNewItemComboMonths.getValue())));
				modifyNewItemComboDays.setOnAction(e->modifyNewSetDay(modifyNewDays.indexOf(modifyNewItemComboDays.getValue())));
				
				clearButtonUser.setOnAction(e->clearButton());
				modifyClearButtonUser.setOnAction(e->modifyUserClearButton());
				clearButtonBudget.setOnAction(e->clearButtonBudget());
				modifyClearButtonBudget.setOnAction(e->modifyClearButtonBudget());
				clearButtonItem.setOnAction(e->clearButtonItem());
				modifyClearButtonItem.setOnAction(e->modifyClearButtonItem());
				deleteClearButtonItem.setOnAction(e->deleteClearButtonItem());
				backButtonUser.setOnAction(e->backButtonUser());
				modifyBackButtonUser.setOnAction(e->modifyBackButtonUser());
				backButtonDelete.setOnAction(e->backButtonDelete());
				backButtonBudget.setOnAction(e->backButtonBudget());
				modifyBackButtonBudget.setOnAction(e->modifyBackButtonBudget());
				deleteBackButtonBudget.setOnAction(e->backButtonDeleteBudget());
				backButtonItem.setOnAction(e->backButtonItem());
				modifyBackButtonItem.setOnAction(e->modifyBackButtonItem());
				deleteBackButtonItem.setOnAction(e->deleteBackButtonItem());
				backButtonDisplay.setOnAction(e->backButtonCreateDisplay());
				exitProgram.setOnAction(e->{
					try {
						exitButton();
					} catch (SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
				});
				//User button set on action
				createUser.setOnAction(e->createUserButton());
				deleteUser.setOnAction(e->deleteUserButton());
				modifyUser.setOnAction(e->modifyUserButton());
				//Budget button set on action
				addBudget.setOnAction(e->addBudgetButton());
				deleteBudget.setOnAction(e->deleteBudgetButton());
				modifyBudget.setOnAction(e->modifyBudgetButton());
				displayBudget.setOnAction(e->displayBudget());
				//Item button set on action
				addItem.setOnAction(e->addItemButton());
				modifyItem.setOnAction(e->modifyItemButton());
				deleteItem.setOnAction(e->deleteItemButton());
				//Displays
				createDisplay.setOnAction(e->createDisplayButton());
				
				displayUsers.setOnAction(e->{
					try {
						displayUsers();
					} catch (SQLException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}
				});
				displayItems.setOnAction(e->{
					try {
						displayItems();
					} catch (SQLException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}
				});
				deleteSubmitButtonItem.setOnAction(e->{
					try {
						deleteSubmitButtonItem();
					} catch (SQLException | ParseException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
				});
				deleteUserPerm.setOnAction(e->{
					try {
						deleteUserPermButton();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				});
				submitButtonUser.setOnAction(e->{
					try {
						submitButtonUser();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				modifySubmitButtonUser.setOnAction(e->{
					try {
						submitButtonModifyUser();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				submitButtonBudget.setOnAction(e->{
					try {
						submitButtonBudget();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				modifySubmitButtonBudget.setOnAction(e->{
					try {
						submitButtonModifyBudget();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				deleteSubmitButtonBudget.setOnAction(e->{
					try {
						submitButtonDeleteBudget();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				submitDisplayBudget.setOnAction(e->{
					try {
						submitButtonDisplayBudget();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				
				submitButtonItem.setOnAction(e->{
					try {
						submitButtonItem();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				});
				
				modifySubmitButtonItem.setOnAction(e->{
					try {
						modifySubmitButtonItem();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				});
				
				submitItemQuery.setOnAction(e->{
					try {
						submitButtonDisplayItems();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				submitButtonDisplay.setOnAction(e->{
					try {
						submitButtonCreateDisplay();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				rbWeekly.setOnAction(e->{
					if(rbWeekly.isSelected())
					{
						budgetType = "Weekly";
					}
				});
				
				rbMonthly.setOnAction(e->{
					if(rbMonthly.isSelected())
					{
						budgetType = "Monthly";
					}
				});
				
				rbYearly.setOnAction(e->{
					if(rbYearly.isSelected())
					{
						budgetType = "Yearly";
					}
				});
				
				rbBarGraph.setOnAction(e->{
					if(rbBarGraph.isSelected())
					{
						displayTypeGraph = "Bar Graph";
					}
				});
				
				rbPieChart.setOnAction(e->{
					if(rbPieChart.isSelected())
					{
						displayTypeGraph = "Pie Chart";
					}
				});
				
				rbVertical.setOnAction(e->{
					if(rbVertical.isSelected())
					{
						displayTypeVert = "Vertical";
					}
				});
				
				rbHorizontal.setOnAction(e->{
					if(rbHorizontal.isSelected())
					{
						displayTypeVert = "Horizontal";
					}
				});
				
				modifyRbWeekly.setOnAction(e->{
					if(modifyRbWeekly.isSelected())
					{
						modifyBudgetType = "Weekly";
					}
				});
				
				modifyRbMonthly.setOnAction(e->{
					if(modifyRbMonthly.isSelected())
					{
						modifyBudgetType = "Monthly";
					}
				});
				
				modifyRbYearly.setOnAction(e->{
					if(modifyRbYearly.isSelected())
					{
						modifyBudgetType = "Yearly";
					}
				});
				// old scene(200,250)
				
				primaryStage.setTitle("BudgetTracker");
				primaryStage.setScene(sceneMain);
				primaryStage.show();
				
	    
		
	}
	private void createUserButton()
	{
		//create pane
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.TOP_LEFT);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		
		//Place create user nodes in pane.
		pane.add(usernameLabel, 0, 0);
		pane.add(username, 0, 1);
		pane.add(passwordLabel, 0, 2);
		pane.add(password, 0, 3);
		pane.add(firstNameLabel, 0, 4);
		pane.add(firstName, 0, 5);
		pane.add(lastNameLabel, 0, 6);
		pane.add(lastName, 0, 7);
		pane.add(budgetAmountLabel, 0, 8);
		pane.add(budgetAmount, 0, 9);
		pane.add(incomeAmountLabel, 0, 10);
		pane.add(incomeAmount, 0, 11);
		pane.add(savingsAmountLabel, 0, 12);
		pane.add(savingsAmount, 0, 13);
		pane.add(numberOfBankAccountsLabel, 0, 14);
		pane.add(numberOfBankAccounts, 0, 15);
		pane.add(bankAccountTotalLabel, 0, 16);
		pane.add(bankAccountTotal, 0, 17);
		pane.add(submitButtonUser, 0, 18);
		pane.add(clearButtonUser, 0, 19);
		pane.add(backButtonUser, 0, 20);
		
		Scene scene = new Scene(pane, 300, 600);
		stageUserCreation.setScene(scene);
		stageUserCreation.setTitle("User Creation");
		stageUserCreation.show();
		
	}
	private void submitButtonUser() throws SQLException
	{
		String userName = username.getText();
		String passWord = password.getText();
		String firstNameT = firstName.getText();
		String lastNameT = lastName.getText();
		double budgetAmountT=0;
		double incomeAmountT=0;
		double savingsAmountT=0;
		double numberOfBankAccountsT=0;
		double bankAccountTotalT=0;
		
		try
		{
			budgetAmountT = Double.parseDouble(budgetAmount.getText());
			if (budgetAmountT<=0)
			{
				budgetAmount.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			budgetAmount.setText("enter a number");
		}
		
		try
		{
			incomeAmountT = Double.parseDouble(incomeAmount.getText());
			if (incomeAmountT<=0)
			{
				incomeAmount.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			incomeAmount.setText("enter a number");
		}
		
		try
		{
			savingsAmountT = Double.parseDouble(savingsAmount.getText());
			if (savingsAmountT<=0)
			{
				savingsAmount.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			savingsAmount.setText("enter a number");
		}
		
		try
		{
			numberOfBankAccountsT = Double.parseDouble(numberOfBankAccounts.getText());
			if (numberOfBankAccountsT<=0)
			{
				numberOfBankAccounts.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			numberOfBankAccounts.setText("enter a number");
		}
		
		try
		{
			bankAccountTotalT = Double.parseDouble(bankAccountTotal.getText());
			if (bankAccountTotalT<=0)
			{
				bankAccountTotal.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			bankAccountTotal.setText("enter a number");
		}
		
		if(budgetAmountT>0 && incomeAmountT>0 && savingsAmountT>0 && numberOfBankAccountsT>0 && bankAccountTotalT>0 &&  userName.length()!=0 && passWord.length()!=0 && firstNameT.length()!=0 && lastNameT.length()!=0)
		{
			try
			{
				Statement selectStmt2 = m_conn.createStatement();
				String sql2 = "SELECT seq_userId.nextval FROM DUAL";
				ResultSet rs = selectStmt2.executeQuery(sql2);
				int seqValue=0;
				while(rs.next())
				{
					seqValue = rs.getInt(1);
				}
				
				// the mysql insert statement
			      String query = " insert into MJ_USER (USERID, USERNAME, PASSWORD, FIRSTNAME, LASTNAME, BUDGETAMOUNT, INCOMEAMOUNT, SAVINGSAMOUNT, NUMBEROFBANKACCOUNTS, BANKACCOUNTTOTAL)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = m_conn.prepareStatement(query);
			      preparedStmt.setInt (1, seqValue);
			      preparedStmt.setString (2, userName);
			      preparedStmt.setString (3, passWord);
			      preparedStmt.setString (4, firstNameT);
			      preparedStmt.setString (5, lastNameT);
			      preparedStmt.setDouble(6, budgetAmountT);
			      preparedStmt.setDouble(7, incomeAmountT);
			      preparedStmt.setDouble(8, savingsAmountT);
			      preparedStmt.setDouble (9, numberOfBankAccountsT);
			      preparedStmt.setDouble(10, bankAccountTotalT);
			     

			      // execute the preparedstatement
			      preparedStmt.execute();
				
				clearButton();
			}
			catch(SQLException ex)
			{
				
			}
		}
	
	}
	private void deleteUserButton()
	{
		        //create pane
				GridPane paneDelete = new GridPane();
				paneDelete.setAlignment(Pos.TOP_LEFT);
				paneDelete.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
				paneDelete.setHgap(5.5);
				paneDelete.setVgap(5.5);
				
				//Place create user nodes in pane.
				paneDelete.add(usernameLabel2, 0, 0);
				paneDelete.add(username2, 0, 1);
				paneDelete.add(passwordLabel2, 0, 2);
				paneDelete.add(password2, 0, 3);
				paneDelete.add(deleteUserPerm, 0, 4);
				paneDelete.add(backButtonDelete, 0, 5);
				
				Scene sceneDelete = new Scene(paneDelete, 300, 600);
				stageUserDeletion.setScene(sceneDelete);
				stageUserDeletion.setTitle("User Deletion");
				stageUserDeletion.show();
	}
	private void deleteUserPermButton() throws SQLException
	{
	//for permanent deletion from database from delete user button
		
		String userName = username2.getText();
		String passWord = password2.getText();
		if(userName.length()!=0 && passWord.length()!=0)
		{
			try
			{
			//Statement selectStmt2 = m_conn.createStatement();
			String query = "DELETE FROM MJ_USER WHERE USERNAME=? AND PASSWORD=?";
			//selectStmt2.executeQuery(query);
			PreparedStatement preparedStmt = m_conn.prepareStatement(query);
			preparedStmt.setString(1, userName);
			preparedStmt.setString(2, passWord);
			preparedStmt.execute();
			username2.setText("");
			password2.setText("");
			}
			catch(SQLException ex)
			{
				
			}
			
		}
		
	}
	private void modifyUserButton()
	{
		//create pane
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.TOP_LEFT);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setHgap(5.5);
		pane.setVgap(5.5);
		
		//Place create user nodes in pane.
		pane.add(modifyUsernameLabel, 0, 0);
		pane.add(modifyUsername, 0, 1);
		pane.add(modifyNewUsernameLabel, 0, 2);
		pane.add(modifyNewUsername, 0, 3);
		pane.add(modifyPasswordLabel, 0, 4);
		pane.add(modifyPassword, 0, 5);
		pane.add(modifyNewPasswordLabel, 0, 6);
		pane.add(modifyNewPassword, 0, 7);
		pane.add(modifyFirstNameLabel, 0, 8);
		pane.add(modifyFirstName, 0, 9);
		pane.add(modifyLastNameLabel, 0, 10);
		pane.add(modifyLastName, 0, 11);
		pane.add(modifyBudgetAmountLabel, 0, 12);
		pane.add(modifyBudgetAmount, 0, 13);
		pane.add(modifyIncomeAmountLabel, 0, 14);
		pane.add(modifyIncomeAmount, 0, 15);
		pane.add(modifySavingsAmountLabel, 0, 16);
		pane.add(modifySavingsAmount, 0, 17);
		pane.add(modifyNumberOfBankAccountsLabel, 0, 18);
		pane.add(modifyNumberOfBankAccounts, 0, 19);
		pane.add(modifyBankAccountTotalLabel, 0, 20);
		pane.add(modifyBankAccountTotal, 0, 21);
		pane.add(modifySubmitButtonUser, 0, 22);
		pane.add(modifyClearButtonUser, 0, 23);
		pane.add(modifyBackButtonUser, 0, 24);
		
		Scene scene = new Scene(pane, 300, 720);
		stageUserModification.setScene(scene);
		stageUserModification.setTitle("User Modification");
		stageUserModification.show();
		
	}
	private void submitButtonModifyUser() throws SQLException
	{
		String userName = modifyUsername.getText();
		String passWord = modifyPassword.getText();
		String newUserName = modifyNewUsername.getText();
		String newPassWord = modifyNewPassword.getText();
		String firstNameT = modifyFirstName.getText();
		String lastNameT = modifyLastName.getText();
		double budgetAmountT=0;
		double incomeAmountT=0;
		double savingsAmountT=0;
		double numberOfBankAccountsT=0;
		double bankAccountTotalT=0;
		
		try
		{
			budgetAmountT = Double.parseDouble(modifyBudgetAmount.getText());
			if (budgetAmountT<=0)
			{
				modifyBudgetAmount.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			modifyBudgetAmount.setText("enter a number");
		}
		
		try
		{
			incomeAmountT = Double.parseDouble(modifyIncomeAmount.getText());
			if (incomeAmountT<=0)
			{
				modifyIncomeAmount.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			modifyIncomeAmount.setText("enter a number");
		}
		
		try
		{
			savingsAmountT = Double.parseDouble(modifySavingsAmount.getText());
			if (savingsAmountT<=0)
			{
				modifySavingsAmount.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			modifySavingsAmount.setText("enter a number");
		}
		
		try
		{
			numberOfBankAccountsT = Double.parseDouble(modifyNumberOfBankAccounts.getText());
			if (numberOfBankAccountsT<=0)
			{
				modifyNumberOfBankAccounts.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			modifyNumberOfBankAccounts.setText("enter a number");
		}
		
		try
		{
			bankAccountTotalT = Double.parseDouble(modifyBankAccountTotal.getText());
			if (bankAccountTotalT<=0)
			{
				modifyBankAccountTotal.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			modifyBankAccountTotal.setText("enter a number");
		}
		
		if(budgetAmountT>0 && incomeAmountT>0 && savingsAmountT>0 && numberOfBankAccountsT>0 && bankAccountTotalT>0 &&  userName.length()!=0 && passWord.length()!=0 && firstNameT.length()!=0 && lastNameT.length()!=0 && newUserName.length()!=0&& newPassWord.length()!=0)
		{
			try
			{
				
				/*
				UPDATE MJ_USER
				SET username = ?, password= ?, firstname =?, lastname=?, budgetamount=?, incomeamount=?, savingsamount=?, numberofbankaccounts=?, bankaccounttotal=?
				WHERE username = ?; */
				// the mysql insert statement
			      String query = ("UPDATE MJ_USER SET username = ?, password= ?, firstname =?, lastname=?, budgetamount=?, incomeamount=?, savingsamount=?, numberofbankaccounts=?, bankaccounttotal=? WHERE username=? AND password=?");
			      
			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = m_conn.prepareStatement(query);
			      preparedStmt.setString (1, newUserName);
			      preparedStmt.setString (2, newPassWord);
			      preparedStmt.setString (3, firstNameT);
			      preparedStmt.setString (4, lastNameT);
			      preparedStmt.setDouble(5, budgetAmountT);
			      preparedStmt.setDouble(6, incomeAmountT);
			      preparedStmt.setDouble(7, savingsAmountT);
			      preparedStmt.setDouble (8, numberOfBankAccountsT);
			      preparedStmt.setDouble(9, bankAccountTotalT);
			      preparedStmt.setString (10, userName);
			      preparedStmt.setString (11, passWord);
			     

			      // execute the preparedstatement
			      preparedStmt.execute();
				
				modifyUserClearButton();
			}
			catch(SQLException ex)
			{
				
			}
		}
	
	}
	private void addBudgetButton()
	{
		//create pane for radio buttons
		HBox paneForRadioButtons = new HBox(20);
		paneForRadioButtons.setPadding(new Insets(5,5,5,5));
		paneForRadioButtons.getChildren().addAll(rbWeekly,rbMonthly,rbYearly);
		
		//add radio buttons to toggle group
		rbWeekly.setToggleGroup(testGroup);
		rbMonthly.setToggleGroup(testGroup);
		rbYearly.setToggleGroup(testGroup);
		
		//create pane
		GridPane paneAddBudget = new GridPane();
		paneAddBudget.setAlignment(Pos.TOP_LEFT);
		paneAddBudget.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		paneAddBudget.setHgap(5.5);
		paneAddBudget.setVgap(5.5);
		
		//Place add budget nodes in pane.
		paneAddBudget.add(paneForRadioButtons, 0, 0);
		paneAddBudget.add(budgetAmountTotalLabel, 0, 1);
		paneAddBudget.add(budgetAmountTotal, 0, 2);
		paneAddBudget.add(budgetNameLabel, 0, 3);
		paneAddBudget.add(budgetName, 0, 4);
		paneAddBudget.add(userNameBudgetLabel, 0, 5);
		paneAddBudget.add(userNameBudget, 0, 6);
		paneAddBudget.add(submitButtonBudget, 0, 7);
		paneAddBudget.add(clearButtonBudget, 0, 8);
		paneAddBudget.add(backButtonBudget, 0, 9);
		
		
		Scene sceneAddBudget = new Scene(paneAddBudget, 300, 600);
		stageAddBudget.setScene(sceneAddBudget);
		stageAddBudget.setTitle("Add Budget");
		stageAddBudget.show();
	}
	private void submitButtonBudget() throws SQLException
	{
		
		String budgetNameT = budgetName.getText();
		String userNameOwner = userNameBudget.getText();
		double budgetAmount = 0;
		
		
		try
		{
			budgetAmount = Double.parseDouble(budgetAmountTotal.getText());
			if (budgetAmount<=0)
			{
				budgetAmountTotal.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			budgetAmountTotal.setText("enter a number");
		}
		
		
		
		if(budgetAmount>0 && budgetNameT.length()!=0 && userNameOwner.length()!=0 && budgetType.length()!=0)
		{
			try
			{
				
				//Get userId from user table
				String queryId = "SELECT USERID FROM MJ_USER WHERE USERNAME=?";
				PreparedStatement preparedStmtId = m_conn.prepareStatement(queryId);
				preparedStmtId.setString(1, userNameOwner);
				ResultSet rs = preparedStmtId.executeQuery();
				int idValue=0;
				while(rs.next())
				{
					idValue = rs.getInt(1);
				}
				
				
				//Get budgetId from sequence
				Statement selectStmt2 = m_conn.createStatement();
				String sql2 = "SELECT seq_budgetId.nextval FROM DUAL";
				ResultSet rsBudgetId = selectStmt2.executeQuery(sql2);
				int seqValue=0;
				while(rsBudgetId.next())
				{
					seqValue = rsBudgetId.getInt(1);
				}
				
				
				
				// the mysql insert statement
			      String query = " insert into MJ_BUDGET (BUDGETID, BUDGETTYPE, BUDGETNAME, USERID, BUDGETAMOUNT, BUDGETTOTAL, OVERBUDGET)"
			        + " values (?, ?, ?, ?, ?, ?, ?)";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = m_conn.prepareStatement(query);
			      preparedStmt.setInt (1, seqValue);
			      preparedStmt.setString (2, budgetType);
			      preparedStmt.setString (3, budgetNameT);
			      preparedStmt.setInt(4, idValue);
			      preparedStmt.setDouble(5, budgetAmount);
			      preparedStmt.setDouble(6, 0);
			      preparedStmt.setString(7, "FALSE");
			     

			      // execute the preparedstatement
			      preparedStmt.execute();
				
				clearButtonBudget();
			}
			catch(IllegalArgumentException ex)
			{
				
			}
		}
	
	}
	private void deleteBudgetButton()
	{
		//create pane
		GridPane paneAddBudget = new GridPane();
		paneAddBudget.setAlignment(Pos.TOP_LEFT);
		paneAddBudget.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		paneAddBudget.setHgap(5.5);
		paneAddBudget.setVgap(5.5);
		
		//Place add budget nodes in pane.
		paneAddBudget.add(deleteBudgetNameLabel, 0, 0);
		paneAddBudget.add(deleteBudgetName, 0, 1);
		paneAddBudget.add(deleteUserNameBudgetLabel, 0, 2);
		paneAddBudget.add(deleteUserNameBudget, 0, 3);
		paneAddBudget.add(deleteSubmitButtonBudget, 0, 4);
		paneAddBudget.add(deleteBackButtonBudget, 0, 5);
		
		
		Scene sceneDeleteBudget = new Scene(paneAddBudget, 300, 600);
		stageDeleteBudget.setScene(sceneDeleteBudget);
		stageDeleteBudget.setTitle("Delete Budget");
		stageDeleteBudget.show();
	}
	private void submitButtonDeleteBudget() throws SQLException
	{	
		String budgetName = deleteBudgetName.getText();
		String userNameDelete = deleteUserNameBudget.getText();
		
		if(userNameDelete.length()!=0 && budgetName.length()!=0)
		{
			try
			{
			//Get userId from user table
			String queryId = "SELECT USERID FROM MJ_USER WHERE USERNAME=?";
			PreparedStatement preparedStmtId2 = m_conn.prepareStatement(queryId);
			preparedStmtId2.setString(1, userNameDelete);
			ResultSet rs = preparedStmtId2.executeQuery();
			int idValue=0;
			while(rs.next())
			{
				idValue = rs.getInt(1);
			}	
			preparedStmtId2.close();
			
			String query = "DELETE FROM MJ_BUDGET WHERE BUDGETNAME=? AND USERID=?";
			PreparedStatement preparedStmt = m_conn.prepareStatement(query);
			preparedStmt.setString(1, budgetName);
			preparedStmt.setInt(2, idValue);
			preparedStmt.execute();
			deleteBudgetName.setText("");
			deleteUserNameBudget.setText("");
			
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
			
		}
		
	}
	private void modifyBudgetButton()
	{
		//create pane for radio buttons
				HBox paneForRadioButtons = new HBox(20);
				paneForRadioButtons.setPadding(new Insets(5,5,5,5));
				paneForRadioButtons.getChildren().addAll(modifyRbWeekly,modifyRbMonthly,modifyRbYearly);
				
				//add radio buttons to toggle group
				modifyRbWeekly.setToggleGroup(modifyTestGroup);
				modifyRbMonthly.setToggleGroup(modifyTestGroup);
				modifyRbYearly.setToggleGroup(modifyTestGroup);
				
				//create pane
				GridPane paneModifyBudget = new GridPane();
				paneModifyBudget.setAlignment(Pos.TOP_LEFT);
				paneModifyBudget.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
				paneModifyBudget.setHgap(5.5);
				paneModifyBudget.setVgap(5.5);
				
				//Place add budget nodes in pane.
				paneModifyBudget.add(paneForRadioButtons, 0, 0);
				paneModifyBudget.add(modifyBudgetAmountTotalLabel, 0, 1);
				paneModifyBudget.add(modifyBudgetAmountTotal, 0, 2);
				paneModifyBudget.add(modifyBudgetNameLabel, 0, 3);
				paneModifyBudget.add(modifyBudgetName, 0, 4);
				paneModifyBudget.add(modifyNewBudgetNameLabel, 0, 5);
				paneModifyBudget.add(modifyNewBudgetName, 0, 6);
				paneModifyBudget.add(modifyUserNameBudgetLabel, 0, 7);
				paneModifyBudget.add(modifyUserNameBudget, 0, 8);
				paneModifyBudget.add(modifySubmitButtonBudget, 0, 9);
				paneModifyBudget.add(modifyClearButtonBudget, 0, 10);
				paneModifyBudget.add(modifyBackButtonBudget, 0, 11);
				
				
				Scene sceneModifyBudget = new Scene(paneModifyBudget, 300, 600);
				stageModifyBudget.setScene(sceneModifyBudget);
				stageModifyBudget.setTitle("Modify Budget");
				stageModifyBudget.show();
	}
	private void submitButtonModifyBudget() throws SQLException
	{
		String budgetNameT = modifyBudgetName.getText();
		String budgetNewNameT = modifyNewBudgetName.getText();
		String userNameOwner = modifyUserNameBudget.getText();
		double budgetAmount = 0;
		
		
		try
		{
			budgetAmount = Double.parseDouble(modifyBudgetAmountTotal.getText());
			if (budgetAmount<=0)
			{
				modifyBudgetAmountTotal.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			modifyBudgetAmountTotal.setText("enter a number");
		}
		
		
		
		if(budgetAmount>0 && budgetNameT.length()!=0 && userNameOwner.length()!=0 && modifyBudgetType.length()!=0 && budgetNewNameT.length()!=0)
		{
			try
			{
				
				//Get userId from user table
				String queryId = "SELECT USERID FROM MJ_USER WHERE USERNAME=?";
				PreparedStatement preparedStmtId2 = m_conn.prepareStatement(queryId);
				preparedStmtId2.setString(1, userNameOwner);
				ResultSet rs = preparedStmtId2.executeQuery();
				int idValue=0;
				while(rs.next())
				{
					idValue = rs.getInt(1);
				}
				preparedStmtId2.close();
				
				
			      // update query for budget  
			      String query = ("UPDATE MJ_BUDGET SET BUDGETTYPE= ?, BUDGETNAME= ?, BUDGETAMOUNT=? WHERE BUDGETNAME=? AND USERID=?");
			      
			      
			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = m_conn.prepareStatement(query);
			      preparedStmt.setString (1, modifyBudgetType);
			      preparedStmt.setString (2, budgetNewNameT);
			      preparedStmt.setDouble(3, budgetAmount);
			      preparedStmt.setString(4, budgetNameT);
			      preparedStmt.setInt(5, idValue);
			      
			     

			      // execute the preparedstatement
			      preparedStmt.execute();
			      
			      
			      
			    //Get budget total
				    String queryId3 = "SELECT BUDGETTOTAL, BUDGETAMOUNT FROM MJ_BUDGET WHERE BUDGETNAME=?";
					PreparedStatement preparedStmtId3 = m_conn.prepareStatement(queryId3);
					preparedStmtId3.setString(1, budgetNewNameT);
					ResultSet rs2 = preparedStmtId3.executeQuery();
				    double bTotal=0;
				    double bAmount=0;
					while(rs2.next())
					{
						bTotal = rs2.getDouble(1);
						bAmount = rs2.getDouble(2);
					}
			      
			    //Set if overbalance
					if(bAmount>bTotal)
					{
						String query7 = ("UPDATE MJ_BUDGET SET OVERBUDGET = ? WHERE BUDGETNAME=?");
					      
					      // create the mysql insert preparedstatement
					      PreparedStatement preparedStmt7 = m_conn.prepareStatement(query7);
					      preparedStmt7.setString (1, "FALSE");
					      preparedStmt7.setString (2, budgetNewNameT);
					     

					      // execute the preparedstatement
					      preparedStmt7.execute();
					}
					else if(bAmount<bTotal)
					{
						String query2 = ("UPDATE MJ_BUDGET SET OVERBUDGET = ? WHERE BUDGETNAME=?");
					      
					      // create the mysql insert preparedstatement
					      PreparedStatement preparedStmt6 = m_conn.prepareStatement(query2);
					      preparedStmt6.setString (1, "TRUE");
					      preparedStmt6.setString (2, budgetNewNameT);
					     

					      // execute the preparedstatement
					      preparedStmt6.execute();
					}
			      
				
				modifyClearButtonBudget();
			}
			catch(IllegalArgumentException ex)
			{
				
			}
		}
	
	}
	private void addItemButton()
	{
			    //create pane
				GridPane paneAddItem = new GridPane();
				paneAddItem.setAlignment(Pos.TOP_LEFT);
				paneAddItem.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
				paneAddItem.setHgap(5.5);
				paneAddItem.setVgap(5.5);
				
				//Place create user nodes in pane.
				paneAddItem.add(itemNameLabel, 0, 0);
				paneAddItem.add(itemName, 0, 1);
				paneAddItem.add(itemPriceLabel, 0, 2);
				paneAddItem.add(itemPrice, 0, 3);
				paneAddItem.add(itemQuantityLabel, 0, 4);
				paneAddItem.add(itemQuantity, 0, 5);
				paneAddItem.add(itemDateLabel, 0, 6);
				paneAddItem.add(itemComboDays, 0, 7);
				paneAddItem.add(itemComboMonths, 0, 8);
				paneAddItem.add(itemDate, 0, 9);
				paneAddItem.add(itemBudgetNameLabel, 0, 10);
				paneAddItem.add(itemBudgetName, 0, 11);
				paneAddItem.add(itemCategoryLabel, 0, 12);
				paneAddItem.add(itemCombo, 0, 13);
				paneAddItem.add(submitButtonItem, 0, 14);
				paneAddItem.add(clearButtonItem, 0, 15);
				paneAddItem.add(backButtonItem, 0, 16);
				
				Scene scene = new Scene(paneAddItem, 300, 600);
				stageUserCreation.setScene(scene);
				stageUserCreation.setTitle("Add Item");
				stageUserCreation.show();
	}
	private void submitButtonItem() throws SQLException, ParseException
	{
		
		String itemNameT = itemName.getText();
		String itemBudgetNameT = itemBudgetName.getText();
		String itemYear = itemDate.getText();
		String itemDateT;
		double itemPriceT = 0;
		double itemQuantityT = 0;
		
		
		try
		{
			itemPriceT = Double.parseDouble(itemPrice.getText());
			if (itemPriceT<=0)
			{
				itemPrice.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			itemPrice.setText("enter a number");
		}
		
		try
		{
			itemQuantityT = Double.parseDouble(itemQuantity.getText());
			if (itemQuantityT<=0)
			{
				itemQuantity.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			itemQuantity.setText("enter a number");
		}
		//year parse test
		try
		{
			int yearTest=0;
			yearTest = Integer.parseInt(itemDate.getText());
			if (yearTest<=0)
			{
				itemDate.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			itemYear="";
			itemDate.setText("enter a valid year");
		}
		
		
		
		if(itemQuantityT>0 &&itemPriceT>0 && itemNameT.length()!=0  && itemBudgetNameT.length()!=0 && itemYear.length()!=0&&monthChoice.length()!=0&&dayChoice.length()!=0&&itemChoice.length()!=0)
		{
			try
			{
				itemDateT =dayChoice+"/"+monthChoice+"/"+itemYear;
				double quanTimesPrice = itemPriceT * itemQuantityT;
				
			    Date itemDateFormat=new SimpleDateFormat("dd/MMM/yyyy").parse(itemDateT);  
			    java.sql.Date date=new java.sql.Date(5);  
			    date = new java.sql.Date(itemDateFormat.getTime());
			    
			    //Get budget total and amount
			    String queryId3 = "SELECT BUDGETTOTAL, BUDGETAMOUNT FROM MJ_BUDGET WHERE BUDGETNAME=?";
				PreparedStatement preparedStmtId3 = m_conn.prepareStatement(queryId3);
				preparedStmtId3.setString(1, itemBudgetNameT);
				ResultSet rs2 = preparedStmtId3.executeQuery();
			    double bTotal=0;
			    double bAmount=0;
				while(rs2.next())
				{
					bTotal = rs2.getDouble(1);
					bAmount = rs2.getDouble(2);
				}
				
				//Set if overbalance
				if(bAmount<(bTotal+quanTimesPrice))
				{
					String query = ("UPDATE MJ_BUDGET SET OVERBUDGET = ? WHERE BUDGETNAME=?");
				      
				      // create the mysql insert preparedstatement
				      PreparedStatement preparedStmt = m_conn.prepareStatement(query);
				      preparedStmt.setString (1, "TRUE");
				      preparedStmt.setString (2, itemBudgetNameT);
				     

				      // execute the preparedstatement
				      preparedStmt.execute();
				}
			   
			    //Update budgetTotal in budget table
				String queryId2 = "UPDATE MJ_Budget SET BUDGETTOTAL = ?+? WHERE BUDGETNAME=?";
				PreparedStatement preparedStmtId2 = m_conn.prepareStatement(queryId2);
				preparedStmtId2.setDouble(1, quanTimesPrice);
				preparedStmtId2.setDouble(2, bTotal);
				preparedStmtId2.setString(3, itemBudgetNameT);
				preparedStmtId2.executeQuery();
				
				
			    
				//Get userId from user table
				String queryId = "SELECT BUDGETID FROM MJ_BUDGET WHERE BUDGETNAME=?";
				PreparedStatement preparedStmtId = m_conn.prepareStatement(queryId);
				preparedStmtId.setString(1, itemBudgetNameT);
				ResultSet rs = preparedStmtId.executeQuery();
				int budgetIdValue=0;
				while(rs.next())
				{
					budgetIdValue = rs.getInt(1);
				}
				
				
				//Get itemId from sequence
				Statement selectStmt2 = m_conn.createStatement();
				String sql2 = "SELECT seq_itemId.nextval FROM DUAL";
				ResultSet rsBudgetId = selectStmt2.executeQuery(sql2);
				int seqValue=0;
				while(rsBudgetId.next())
				{
					seqValue = rsBudgetId.getInt(1);
				}
				
				
				
				// the mysql insert statement
			      String query = " insert into MJ_ITEM (ITEMID, ITEMNAME, ITEMTYPE, ITEMPRICE, ITEMQUANTITY, PURCHASEDATE, BUDGETID)"
			        + " values (?, ?, ?, ?, ?,?,?)";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = m_conn.prepareStatement(query);
			      preparedStmt.setInt (1, seqValue);
			      preparedStmt.setString (2, itemNameT);
			      preparedStmt.setString (3, itemChoice);
			      preparedStmt.setDouble(4, itemPriceT);
			      preparedStmt.setDouble(5, itemQuantityT);
			      preparedStmt.setDate(6, date);
			      preparedStmt.setDouble(7, budgetIdValue);
			     

			      // execute the preparedstatement
			      preparedStmt.execute();
				
				  clearButtonItem();
			}
			catch(IllegalArgumentException ex)
			{
				
			}
		}
	
	}
	private void deleteItemButton()
	{
			    //create pane
				GridPane paneDeleteItem = new GridPane();
				paneDeleteItem.setAlignment(Pos.TOP_LEFT);
				paneDeleteItem.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
				paneDeleteItem.setHgap(5.5);
				paneDeleteItem.setVgap(5.5);
				
				//Place create user nodes in pane.
				paneDeleteItem.add(deleteItemNameLabel, 0, 0);
				paneDeleteItem.add(deleteItemName, 0, 1);
				paneDeleteItem.add(deleteItemDateLabel, 0, 2);
				paneDeleteItem.add(deleteItemComboDays, 0, 3);
				paneDeleteItem.add(deleteItemComboMonths, 0, 4);
				paneDeleteItem.add(deleteItemDate, 0, 5);
				paneDeleteItem.add(deleteItemBudgetNameLabel, 0, 6);
				paneDeleteItem.add(deleteItemBudgetName, 0, 7);
				paneDeleteItem.add(deleteSubmitButtonItem, 0, 8);
				paneDeleteItem.add(deleteClearButtonItem, 0, 9);
				paneDeleteItem.add(deleteBackButtonItem, 0, 10);
				
				Scene scene = new Scene(paneDeleteItem, 300, 600);
				stageDeleteItem.setScene(scene);
				stageDeleteItem.setTitle("Delete Item");
				stageDeleteItem.show();
	}
	private void deleteSubmitButtonItem() throws SQLException, ParseException
	{
		
		String itemNameT = deleteItemName.getText();
		String itemBudgetNameT = deleteItemBudgetName.getText();
		String itemYear = deleteItemDate.getText();
		String itemDateT;
		
		//year parse test
		try
		{
			int yearTest=0;
			yearTest = Integer.parseInt(deleteItemDate.getText());
			if (yearTest<=0)
			{
				deleteItemDate.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			itemYear="";
			deleteItemDate.setText("enter a valid year");
		}
		
		
		
		if(itemNameT.length()!=0  && itemBudgetNameT.length()!=0 && itemYear.length()!=0&&deleteMonthChoice.length()!=0&&deleteDayChoice.length()!=0)
		{
			try
			{
				itemDateT =deleteDayChoice+"/"+deleteMonthChoice+"/"+itemYear;
				
				
				
			    Date itemDateFormat=new SimpleDateFormat("dd/MMM/yyyy").parse(itemDateT);  
			    java.sql.Date date=new java.sql.Date(5);  
			    date = new java.sql.Date(itemDateFormat.getTime());
			    
			    //Get budgetId from budget table
				String queryId = "SELECT BUDGETID FROM MJ_BUDGET WHERE BUDGETNAME=?";
				PreparedStatement preparedStmtId = m_conn.prepareStatement(queryId);
				preparedStmtId.setString(1, itemBudgetNameT);
				ResultSet rs = preparedStmtId.executeQuery();
				int budgetIdValue=0;
				while(rs.next())
				{
					budgetIdValue = rs.getInt(1);
				}
				
			    
			    //Get the budget total and amount
			    String queryId3 = "SELECT BUDGETTOTAL, BUDGETAMOUNT FROM MJ_BUDGET WHERE BUDGETNAME=?";
				PreparedStatement preparedStmtId3 = m_conn.prepareStatement(queryId3);
				preparedStmtId3.setString(1, itemBudgetNameT);
				ResultSet rs2 = preparedStmtId3.executeQuery();
			    double budgetTotal=0;
			    double budgetAmount=0;
				while(rs2.next())
				{
					budgetTotal = rs2.getDouble(1);
					budgetAmount = rs2.getDouble(2);
				}
				
				//Get the price, quantity of the item to be deleted
				String queryId4 = "SELECT ITEMPRICE, ITEMQUANTITY FROM MJ_ITEM WHERE ITEMNAME=? AND BUDGETID=? AND PURCHASEDATE=?";
				PreparedStatement preparedStmtId4 = m_conn.prepareStatement(queryId4);
				preparedStmtId4.setString(1, itemNameT);
				preparedStmtId4.setInt(2, budgetIdValue);
				preparedStmtId4.setDate(3, date);
				ResultSet rs4 = preparedStmtId4.executeQuery();
				double itemPrice=0;
				int itemQuantity=0;
				while(rs4.next())
				{
					itemPrice = rs4.getDouble(1);
					itemQuantity = rs4.getInt(2);
				}
				// Multiple price * Quantity
				itemPrice = itemPrice*itemQuantity;
			   
				//Set if underbalance
				if(budgetAmount>(budgetTotal-itemPrice))
				{
					String query = ("UPDATE MJ_BUDGET SET OVERBUDGET = ? WHERE BUDGETNAME=?");
				      
				      // create the mysql insert preparedstatement
				      PreparedStatement preparedStmt = m_conn.prepareStatement(query);
				      preparedStmt.setString (1, "FALSE");
				      preparedStmt.setString (2, itemBudgetNameT);
				     

				      // execute the preparedstatement
				      preparedStmt.execute();
				}
				
			    //Update budgetTotal in budget table. When an item is deleted from a budget budgdet total needs to be altered
				String queryId2 = "UPDATE MJ_Budget SET BUDGETTOTAL = ?-? WHERE BUDGETNAME=?";
				PreparedStatement preparedStmtId2 = m_conn.prepareStatement(queryId2);
				preparedStmtId2.setDouble(1, budgetTotal);
				preparedStmtId2.setDouble(2, itemPrice);
				preparedStmtId2.setString(3, itemBudgetNameT);
				preparedStmtId2.executeQuery();
				
				
				
			      
			      String query = "DELETE FROM MJ_ITEM WHERE ITEMNAME=? AND BUDGETID=? AND PURCHASEDATE=?";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = m_conn.prepareStatement(query);
			      preparedStmt.setString (1, itemNameT);
			      preparedStmt.setInt (2, budgetIdValue);
			      preparedStmt.setDate(3, date);
			     

			      // execute the preparedstatement
			      preparedStmt.execute();
			      
				  deleteClearButtonItem();
			}
			catch(IllegalArgumentException ex)
			{
				
			}
		}
	
	}
	private void modifyItemButton()
	{
			    //create pane
				GridPane paneModifyItem = new GridPane();
				paneModifyItem.setAlignment(Pos.TOP_LEFT);
				paneModifyItem.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
				paneModifyItem.setHgap(5.5);
				paneModifyItem.setVgap(5.5);
				
				//Place create user nodes in pane.
				paneModifyItem.add(modifyItemNameLabel, 0, 0);
				paneModifyItem.add(modifyItemName, 0, 1);
				paneModifyItem.add(modifyNewItemNameLabel, 0, 2);
				paneModifyItem.add(modifyNewItemName, 0, 3);
				paneModifyItem.add(modifyItemPriceLabel, 0, 4);
				paneModifyItem.add(modifyItemPrice, 0, 5);
				paneModifyItem.add(modifyItemQuantityLabel, 0, 6);
				paneModifyItem.add(modifyItemQuantity, 0, 7);
				paneModifyItem.add(modifyItemDateLabel, 0, 8);
				paneModifyItem.add(modifyItemComboDays, 0, 9);
				paneModifyItem.add(modifyItemComboMonths, 0, 10);
				paneModifyItem.add(modifyItemDate, 0, 11);
				paneModifyItem.add(modifyNewItemDateLabel, 0, 12);
				paneModifyItem.add(modifyNewItemComboDays, 0, 13);
				paneModifyItem.add(modifyNewItemComboMonths, 0, 14);
				paneModifyItem.add(modifyNewItemDate, 0, 15);
				paneModifyItem.add(modifyItemBudgetNameLabel, 0, 16);
				paneModifyItem.add(modifyItemBudgetName, 0, 17);
				paneModifyItem.add(modifyItemCategoryLabel, 0, 18);
				paneModifyItem.add(modifyItemCombo, 0, 19);
				paneModifyItem.add(modifySubmitButtonItem, 0, 20);
				paneModifyItem.add(modifyClearButtonItem, 0, 21);
				paneModifyItem.add(modifyBackButtonItem, 0, 22);
				
				Scene scene = new Scene(paneModifyItem, 300, 700);
				stageModifyItem.setScene(scene);
				stageModifyItem.setTitle("Modify Item");
				stageModifyItem.show();
	}
	private void modifySubmitButtonItem() throws SQLException, ParseException
	{
		
		String itemNameT = modifyItemName.getText();
		String itemNewNameT = modifyNewItemName.getText();
		String itemBudgetNameT = modifyItemBudgetName.getText();
		String itemYear = modifyItemDate.getText();
		String itemNewYear = modifyNewItemDate.getText();
		String itemDateT;
		String itemNewDateT;
		double itemPriceT = 0;
		double itemQuantityT = 0;
		
		
		try
		{
			itemPriceT = Double.parseDouble(modifyItemPrice.getText());
			if (itemPriceT<=0)
			{
				modifyItemPrice.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			modifyItemPrice.setText("enter a number");
		}
		
		try
		{
			itemQuantityT = Double.parseDouble(modifyItemQuantity.getText());
			if (itemQuantityT<=0)
			{
				modifyItemQuantity.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			modifyItemQuantity.setText("enter a number");
		}
		//year parse test
		try
		{
			int yearTest=0;
			yearTest = Integer.parseInt(modifyItemDate.getText());
			if (yearTest<=0)
			{
				modifyItemDate.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			itemYear="";
			modifyItemDate.setText("enter a valid year");
		}
		//For the new date
		try
		{
			int yearNewTest=0;
			yearNewTest = Integer.parseInt(modifyNewItemDate.getText());
			if (yearNewTest<=0)
			{
				modifyNewItemDate.setText("enter a number > 0");
			}
		}
		catch(NumberFormatException ex)
		{
			itemNewYear="";
			modifyNewItemDate.setText("enter a valid year");
		}
		
		
		
		if(itemQuantityT>0 &&itemPriceT>0 && itemNameT.length()!=0  && itemBudgetNameT.length()!=0 && itemYear.length()!=0&&modifyMonthChoice.length()!=0&&modifyDayChoice.length()!=0&&modifyItemChoice.length()!=0)
		{
			try
			{
				itemDateT =modifyDayChoice+"/"+modifyMonthChoice+"/"+itemYear;
			    Date itemDateFormat=new SimpleDateFormat("dd/MMM/yyyy").parse(itemDateT);  
			    java.sql.Date date=new java.sql.Date(5);  
			    date = new java.sql.Date(itemDateFormat.getTime());
			    //For the new date
			    itemNewDateT =modifyNewDayChoice+"/"+modifyNewMonthChoice+"/"+itemNewYear;
			    Date itemNewDateFormat=new SimpleDateFormat("dd/MMM/yyyy").parse(itemNewDateT);  
			    java.sql.Date dateNew=new java.sql.Date(5);  
			    dateNew = new java.sql.Date(itemNewDateFormat.getTime());
			    
				//need to check if budget overbalance before adding
			    
			    //Get budget total
			    String queryId3 = "SELECT BUDGETTOTAL, BUDGETAMOUNT FROM MJ_BUDGET WHERE BUDGETNAME=?";
				PreparedStatement preparedStmtId3 = m_conn.prepareStatement(queryId3);
				preparedStmtId3.setString(1, itemBudgetNameT);
				ResultSet rs2 = preparedStmtId3.executeQuery();
			    double bTotal=0;
			    double bAmount=0;
				while(rs2.next())
				{
					bTotal = rs2.getDouble(1);
					bAmount = rs2.getDouble(2);
				}
			   
				
				//Get budgetId from budget table
				String queryId = "SELECT BUDGETID FROM MJ_BUDGET WHERE BUDGETNAME=?";
				PreparedStatement preparedStmtId = m_conn.prepareStatement(queryId);
				preparedStmtId.setString(1, itemBudgetNameT);
				ResultSet rs = preparedStmtId.executeQuery();
				int budgetIdValue=0;
				while(rs.next())
				{
					budgetIdValue = rs.getInt(1);
				}
				
				//Get old item price. compare to new item price and quantity. If lower add the difference to the budgetTotal. If greater subtract the difference
				String queryId4 = "SELECT ITEMPRICE, ITEMQUANTITY FROM MJ_ITEM WHERE ITEMNAME=? AND PURCHASEDATE=? AND BUDGETID=?";
				PreparedStatement preparedStmtId4 = m_conn.prepareStatement(queryId4);
				preparedStmtId4.setString(1, itemNameT);
				preparedStmtId4.setDate(2, date);
				preparedStmtId4.setInt(3, budgetIdValue);
				ResultSet rsPrice = preparedStmtId4.executeQuery();
				double itemPriceValue=0;
				int itemQuantity=0;
				while(rsPrice.next())
				{
					itemPriceValue = rsPrice.getDouble(1);
					itemQuantity = rsPrice.getInt(2);
				}
				//If the price of the new item is greater than the old price. Update the budget table with the new total. itemPriceT is new value. itemPriceValue is old value
				if((itemPriceT*itemQuantityT)>(itemPriceValue*itemQuantity))
				{
					double difference = (itemPriceT*itemQuantityT)-(itemPriceValue*itemQuantity);
					String queryId2 = "UPDATE MJ_Budget SET BUDGETTOTAL = ?+? WHERE BUDGETNAME=?";
					PreparedStatement preparedStmtId2 = m_conn.prepareStatement(queryId2);
					preparedStmtId2.setDouble(1, difference);
					preparedStmtId2.setDouble(2, bTotal);
					preparedStmtId2.setString(3, itemBudgetNameT);
					preparedStmtId2.executeQuery();
				}
				//If the price of the new item is less than the old price. Update the budget table iwth the new total
				else if((itemPriceT*itemQuantityT)<(itemPriceValue*itemQuantity))
				{
					double differenceLess = (itemPriceValue*itemQuantity)-(itemPriceT*itemQuantityT);
					String queryId5 = "UPDATE MJ_Budget SET BUDGETTOTAL = ?-? WHERE BUDGETNAME=?";
					PreparedStatement preparedStmtId5 = m_conn.prepareStatement(queryId5);
					preparedStmtId5.setDouble(1, bTotal);
					preparedStmtId5.setDouble(2, differenceLess);
					preparedStmtId5.setString(3, itemBudgetNameT);
					preparedStmtId5.executeQuery();
				}
				
			    
				//Just get bugdtet total and amount again and compare them < > it's not that hard
				//Get budget total again after it has been modified
			    String queryIdTotal = "SELECT BUDGETTOTAL FROM MJ_BUDGET WHERE BUDGETNAME=?";
				PreparedStatement preparedStmtIdTotal = m_conn.prepareStatement(queryIdTotal);
				preparedStmtIdTotal.setString(1, itemBudgetNameT);
				ResultSet rsTotal = preparedStmtIdTotal.executeQuery();
			    double bTotal2=0;
				while(rsTotal.next())
				{
					bTotal2 = rsTotal.getDouble(1);
				}
				
				
				//Set if overbalance
				if(bTotal2 > bAmount)
				{
					String query7 = ("UPDATE MJ_BUDGET SET OVERBUDGET = ? WHERE BUDGETNAME=?");
				      
				      // create the mysql insert preparedstatement
				      PreparedStatement preparedStmt7 = m_conn.prepareStatement(query7);
				      preparedStmt7.setString (1, "TRUE");
				      preparedStmt7.setString (2, itemBudgetNameT);
				     

				      // execute the preparedstatement
				      preparedStmt7.execute();
				}
				else if(bTotal2 < bAmount)
				{
					String query2 = ("UPDATE MJ_BUDGET SET OVERBUDGET = ? WHERE BUDGETNAME=?");
				      
				      // create the mysql insert preparedstatement
				      PreparedStatement preparedStmt6 = m_conn.prepareStatement(query2);
				      preparedStmt6.setString (1, "FALSE");
				      preparedStmt6.setString (2, itemBudgetNameT);
				     

				      // execute the preparedstatement
				      preparedStmt6.execute();
				}
				
				
			    //The mySql update statement  
			      String query = ("UPDATE MJ_ITEM SET ITEMNAME = ?, ITEMTYPE= ?, ITEMPRICE =?, ITEMQUANTITY=?, PURCHASEDATE=? WHERE ITEMNAME=? AND PURCHASEDATE=? AND BUDGETID=?");
			      

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = m_conn.prepareStatement(query);
			      preparedStmt.setString (1, itemNewNameT);
			      preparedStmt.setString (2, modifyItemChoice);
			      preparedStmt.setDouble(3, itemPriceT);
			      preparedStmt.setDouble(4, itemQuantityT);
			      preparedStmt.setDate(5, dateNew);
			      preparedStmt.setString (6, itemNameT);
			      preparedStmt.setDate(7, date);
			      preparedStmt.setDouble(8, budgetIdValue);
			     

			      // execute the preparedstatement
			      preparedStmt.execute();
				
				  modifyClearButtonItem();
			}
			catch(IllegalArgumentException ex)
			{
				
			}
		}
	
	}
	private void displayUsers() throws SQLException
	{
		GridPane paneDisplayUser = new GridPane();
		paneDisplayUser.setAlignment(Pos.TOP_LEFT);
		paneDisplayUser.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		paneDisplayUser.setHgap(5.5);
		paneDisplayUser.setVgap(5.5);
		
		TextArea userNames = new TextArea();
		Label userNameLabel = new Label("This is a list of users on the system: ");
		
		userNames.setWrapText(true);
		userNames.setEditable(false);
		
		ScrollPane scrollPane = new ScrollPane(userNames);
		
		paneDisplayUser.add(userNameLabel, 0, 0);
		paneDisplayUser.add(scrollPane, 0, 1);
		
		//Display list of users in database
	    String queryId3 = "SELECT USERNAME FROM MJ_USER";
		PreparedStatement preparedStmtId3 = m_conn.prepareStatement(queryId3);
		ResultSet rs2 = preparedStmtId3.executeQuery();
	    String userNameQuery="";
		while(rs2.next())
		{
			userNameQuery = userNameQuery + rs2.getString(1) +"\n";
		}
		
		userNames.setText(userNameQuery);
		
		
		Scene scene = new Scene(paneDisplayUser, 300, 400);
		stageDisplayUser.setScene(scene);
		stageDisplayUser.setTitle("Display Users");
		stageDisplayUser.show();
	}
	private void displayItems() throws SQLException
	{
		GridPane paneDisplayItems = new GridPane();
		paneDisplayItems.setAlignment(Pos.TOP_LEFT);
		paneDisplayItems.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		paneDisplayItems.setHgap(5.5);
		paneDisplayItems.setVgap(5.5);
		
		
		
		itemNames.setWrapText(true);
		itemNames.setEditable(false);
		
		ScrollPane scrollPaneItems = new ScrollPane(itemNames);
		
		paneDisplayItems.add(userBudgetLabel, 0, 0);
		paneDisplayItems.add(userBudgetName, 0, 1);
		paneDisplayItems.add(scrollPaneItems, 0, 2);
		paneDisplayItems.add(submitItemQuery, 0, 3);
		
	
		
		
		Scene scene = new Scene(paneDisplayItems, 550, 600);
		stageDisplayItem.setScene(scene);
		stageDisplayItem.setTitle("Display Items");
		stageDisplayItem.show();
	}
	private void submitButtonDisplayItems() throws SQLException
	{
		String budgetSearchName = userBudgetName.getText();
		itemNames.setText("");
		//Get budgetId from budget table
		String queryId = "SELECT BUDGETID FROM MJ_BUDGET WHERE BUDGETNAME=?";
		PreparedStatement preparedStmtId = m_conn.prepareStatement(queryId);
		preparedStmtId.setString(1, budgetSearchName);
		ResultSet rs = preparedStmtId.executeQuery();
		int budgetIdValue=0;
		while(rs.next())
		{
			budgetIdValue = rs.getInt(1);
		}
		
		
		//Display list of items from a budget
	    String queryId3 = "SELECT ITEMNAME, ITEMTYPE, ITEMPRICE, ITEMQUANTITY, PURCHASEDATE FROM MJ_ITEM WHERE BUDGETID=?";
		PreparedStatement preparedStmtId3 = m_conn.prepareStatement(queryId3);
		preparedStmtId3.setInt(1, budgetIdValue);
		ResultSet rs2 = preparedStmtId3.executeQuery();
	    String itemQuery="";
	    
		while(rs2.next())
		{
			itemQuery = itemQuery + "Item Name: "+rs2.getString(1)+" Item Category: "+rs2.getString(2)+" Item Price: "+rs2.getDouble(3)+" Item Quantity: "+rs2.getInt(4)+" Purchase Date: "+rs2.getDate(5)+"\n";
		}
		
		itemNames.setText(itemQuery);
	}
	private void createDisplayButton()
	{
		//create pane for radio buttons bar graph pie chart
		HBox paneForRadioButtons = new HBox(20);
		paneForRadioButtons.setPadding(new Insets(5,5,5,5));
		paneForRadioButtons.getChildren().addAll(rbBarGraph,rbPieChart);
		
		//add radio buttons to toggle group
		rbBarGraph.setToggleGroup(testGroupDisplayGraph);
		rbPieChart.setToggleGroup(testGroupDisplayGraph);
		
		//create pane for 2nd group of radio buttons vertical horizontal
		HBox paneForRadioButtonsVert = new HBox(20);
		paneForRadioButtonsVert.setPadding(new Insets(5,5,5,5));
		paneForRadioButtonsVert.getChildren().addAll(rbVertical,rbHorizontal);
		
		//
		rbVertical.setToggleGroup(testGroupDisplayVert);
		rbHorizontal.setToggleGroup(testGroupDisplayVert);
		
		//create pane
		GridPane paneCreateDisplay = new GridPane();
		paneCreateDisplay.setAlignment(Pos.TOP_LEFT);
		paneCreateDisplay.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		paneCreateDisplay.setHgap(5.5);
		paneCreateDisplay.setVgap(5.5);
		
		//Place add budget nodes in pane.
		paneCreateDisplay.add(displayNameLabel, 0, 0);
		paneCreateDisplay.add(displayName, 0, 1);
		paneCreateDisplay.add(budgetNameDisplayLabel, 0, 2);
		paneCreateDisplay.add(budgetNameDisplay, 0, 3);
		paneCreateDisplay.add(paneForRadioButtons, 0, 4);
		paneCreateDisplay.add(paneForRadioButtonsVert, 0, 5);
		paneCreateDisplay.add(submitButtonDisplay, 0, 6);
		paneCreateDisplay.add(backButtonDisplay, 0, 7);
		
		
		Scene sceneCreateDisplay = new Scene(paneCreateDisplay, 300, 600);
		stageCreateDisplay.setScene(sceneCreateDisplay);
		stageCreateDisplay.setTitle("Create Display");
		stageCreateDisplay.show();
	}
	private void submitButtonCreateDisplay() throws SQLException
	{
		
		String budgetNameT = budgetNameDisplay.getText();
		String displayNameT = displayName.getText();
		
		
		if(budgetNameT.length()!=0 && displayNameT.length()!=0 && displayTypeGraph.length()!=0 && displayTypeVert.length()!=0)
		{
			try
			{
				
				//Get budgetId from user table
				String queryId = "SELECT BUDGETID FROM MJ_BUDGET WHERE BUDGETNAME=?";
				PreparedStatement preparedStmtId = m_conn.prepareStatement(queryId);
				preparedStmtId.setString(1, budgetNameT);
				ResultSet rs = preparedStmtId.executeQuery();
				int budgetIdValue=0;
				while(rs.next())
				{
					budgetIdValue = rs.getInt(1);
				}
				
				
				//Get displayId from sequence
				Statement selectStmt2 = m_conn.createStatement();
				String sql2 = "SELECT seq_displayId.nextval FROM DUAL";
				ResultSet rsDisplayId = selectStmt2.executeQuery(sql2);
				int seqValue=0;
				while(rsDisplayId.next())
				{
					seqValue = rsDisplayId.getInt(1);
				}
				
				
				
				// the mysql insert statement
			      String query = " insert into MJ_DISPLAY (DISPLAYID, DISPLAYNAME, BUDGETID, DISPLAYLAYOUT, GRAPHTYPE)"
			        + " values (?, ?, ?, ?, ?)";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = m_conn.prepareStatement(query);
			      preparedStmt.setInt (1, seqValue);
			      preparedStmt.setString (2, displayNameT);
			      preparedStmt.setInt (3, budgetIdValue);
			      preparedStmt.setString(4, displayTypeGraph);
			      preparedStmt.setString(5, displayTypeVert);
			     
			      // execute the preparedstatement
			      preparedStmt.execute();
			      
			      budgetNameDisplay.clear();
				  displayName.clear(); 
				  rbBarGraph.setSelected(false);
				  rbPieChart.setSelected(false);
				  rbVertical.setSelected(false);
				  rbHorizontal.setSelected(false);
				  displayTypeGraph="";
				  displayTypeVert="";

			      
			}
			catch(IllegalArgumentException ex)
			{
				
			}
		}
	
	}
	private void displayBudget()
	{
		GridPane paneDisplayBudget = new GridPane();
		paneDisplayBudget.setAlignment(Pos.TOP_LEFT);
		paneDisplayBudget.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		paneDisplayBudget.setHgap(5.5);
		paneDisplayBudget.setVgap(5.5);
		
        paneDisplayBudget.add(enterDisplayName, 0, 0);
        paneDisplayBudget.add(enterDisplay, 0, 1);
		paneDisplayBudget.add(submitDisplayBudget, 0, 2);
		
		Scene scene = new Scene(paneDisplayBudget, 550, 600);
		stageDisplayBudget.setScene(scene);
		stageDisplayBudget.setTitle("Display Budget");
		stageDisplayBudget.show();
	}
	private void submitButtonDisplayBudget() throws SQLException
	{
		String displaySearchName = enterDisplay.getText();
		String Appliances = "Appliances";
	    String Automotive = "Automotive and Vehicals";
	    String Beauty = "Beauty Products";
	    String Bills = "Bills and Loans";
	    String Books = "Books and CDS";
		String Clothing = "Clothing and Jewlery";
	    String Electronics = "Electronics and Apps";
	    String Entertainment = "Entertainment";
	    String Food = "Food and Groceries";
	    String Movies = "Movies and Tv";
	    String Pets = "Pets";
	    String Miscellaneous = "Miscellaneous";
	    String Office = "Office Products and Home Improvement";
	    String Toys = "Toys and Children";
	    //Create bar graph vertical
	    final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        xAxis.setLabel("Category");       
        yAxis.setLabel("Cost");
        
        //Create bar graph horizontal
        final NumberAxis xAxisH = new NumberAxis();
        final CategoryAxis yAxisH = new CategoryAxis();
        final BarChart<Number,String> bcH = 
            new BarChart<Number,String>(xAxisH,yAxisH);
        xAxisH.setLabel("Cost");  
        xAxisH.setTickLabelRotation(90);
        yAxisH.setLabel("Category");
		
		//Get budgetId from display table
		String queryId = "SELECT BUDGETID, DISPLAYLAYOUT, GRAPHTYPE FROM MJ_DISPLAY WHERE DISPLAYNAME=?";
		PreparedStatement preparedStmtId = m_conn.prepareStatement(queryId);
		preparedStmtId.setString(1, displaySearchName);
		ResultSet rs = preparedStmtId.executeQuery();
		int budgetIdValue=0;
		String displayLayout="";
		String graphType="";
		while(rs.next())
		{
			budgetIdValue = rs.getInt(1);
			displayLayout = rs.getString(2);
			graphType = rs.getString(3);
		}
		
		//Get budgetAmount from budget table
		String queryId2 = "SELECT BUDGETAMOUNT, BUDGETTOTAL, OVERBUDGET, BUDGETTYPE FROM MJ_BUDGET WHERE BUDGETID=?";
		PreparedStatement preparedStmtId2 = m_conn.prepareStatement(queryId2);
		preparedStmtId2.setInt(1, budgetIdValue);
		ResultSet rsAmount = preparedStmtId2.executeQuery();
		double budgetAmount=0;
		double budgetTotal=0;
		String overBudget="";
		String budgetTypeQuery="";
		int divideBy=1;
		DecimalFormat f = new DecimalFormat("##.00");
		while(rsAmount.next())
		{
			budgetAmount = rsAmount.getDouble(1);
			budgetTotal = rsAmount.getDouble(2);
			overBudget = rsAmount.getString(3);
			budgetTypeQuery = rsAmount.getString(4);
		}
		
		if(budgetTypeQuery.equals("Weekly"))
		{
			//7 days per week
			divideBy=7;
			
		}
		else if(budgetTypeQuery.equals("Monthly"))
		{
			//31 days per month
			divideBy=31;
		}
		else if(budgetTypeQuery.equals("Yearly"))
		{
			//365 days per month
			divideBy=365;
		}
		//Set the title with the new information
		bc.setTitle("Goal="+budgetAmount+" Currently="+budgetTotal+" Overbudget="+overBudget+" Spend: "+f.format(budgetAmount/divideBy)+" per day");
		// Set horizontal graph
		bcH.setTitle("Goal="+budgetAmount+" Currently="+budgetTotal+" Overbudget="+overBudget+" Spend: "+f.format(budgetAmount/divideBy)+" per day");
		
		//Display list of items from a budget
	    String queryId3 = "SELECT ITEMTYPE, ITEMPRICE, ITEMQUANTITY FROM MJ_ITEM WHERE BUDGETID=?";
		PreparedStatement preparedStmtId3 = m_conn.prepareStatement(queryId3);
		preparedStmtId3.setInt(1, budgetIdValue);
		ResultSet rs2 = preparedStmtId3.executeQuery();
		
	    double appliancesTotal = 0;
	    double automotiveTotal = 0;
	    double beautyTotal = 0;
	    double billsTotal = 0;
	    double booksTotal = 0;
	    double clothingTotal = 0;
	    double electronicsTotal = 0;
	    double entertainmentTotal = 0;
	    double foodTotal = 0;
	    double moviesTotal = 0;
	    double petsTotal = 0;
	    double miscellaneousTotal = 0;
	    double officeTotal = 0;
	    double toysTotal = 0;
	    
		while(rs2.next())
		{
			
			//String, Double, Int
			if(rs2.getString(1).equals("Appliances"))
			{
				appliancesTotal = appliancesTotal + (rs2.getDouble(2) * rs2.getInt(3));
			}
			else if(rs2.getString(1).equals("Automotive and Vehicals"))
			{
				automotiveTotal = automotiveTotal + (rs2.getDouble(2) * rs2.getInt(3));
			}
			else if(rs2.getString(1).equals("Beauty Products"))
			{
				beautyTotal = beautyTotal + (rs2.getDouble(2) * rs2.getInt(3));
			}
			else if(rs2.getString(1).equals("Bills and Loans"))
			{
				billsTotal = billsTotal + (rs2.getDouble(2) * rs2.getInt(3));
			}
			else if(rs2.getString(1).equals("Books and CDS"))
			{
				booksTotal = booksTotal + (rs2.getDouble(2) * rs2.getInt(3));
			}
			else if(rs2.getString(1).equals("Clothing and Jewlery"))
			{
				clothingTotal = clothingTotal + (rs2.getDouble(2) * rs2.getInt(3));
			}
			else if(rs2.getString(1).equals("Electronics and Apps"))
			{
				electronicsTotal = electronicsTotal + (rs2.getDouble(2) * rs2.getInt(3));
			}
			else if(rs2.getString(1).equals("Entertainment"))
			{
				entertainmentTotal = entertainmentTotal + (rs2.getDouble(2) * rs2.getInt(3));
			}
			else if(rs2.getString(1).equals("Food and Groceries"))
			{
				foodTotal = foodTotal + (rs2.getDouble(2) * rs2.getInt(3));
			}
			else if(rs2.getString(1).equals("Movies and Tv"))
			{
				moviesTotal = moviesTotal + (rs2.getDouble(2) * rs2.getInt(3));
			}
			else if(rs2.getString(1).equals("Pets"))
			{
				petsTotal = petsTotal + (rs2.getDouble(2) * rs2.getInt(3));
			}
			else if(rs2.getString(1).equals("Miscellaneous"))
			{
				miscellaneousTotal = miscellaneousTotal + (rs2.getDouble(2) * rs2.getInt(3));
			}
			else if(rs2.getString(1).equals("Office Products and Home Improvement"))
			{
				officeTotal = officeTotal + (rs2.getDouble(2) * rs2.getInt(3));
			}
			else if(rs2.getString(1).equals("Toys and Children"))
			{
				toysTotal = toysTotal + (rs2.getDouble(2) * rs2.getInt(3));
			}
			
		}
		
		XYChart.Series series1 = new XYChart.Series();
        series1.setName("test");       
        series1.getData().add(new XYChart.Data(Appliances, appliancesTotal));
        series1.getData().add(new XYChart.Data(Automotive, automotiveTotal));
        series1.getData().add(new XYChart.Data(Beauty, beautyTotal));
        series1.getData().add(new XYChart.Data(Bills, billsTotal));
        series1.getData().add(new XYChart.Data(Books, booksTotal));   
        series1.getData().add(new XYChart.Data(Clothing, clothingTotal));
        series1.getData().add(new XYChart.Data(Electronics, electronicsTotal));
        series1.getData().add(new XYChart.Data(Entertainment, entertainmentTotal));
        series1.getData().add(new XYChart.Data(Food, foodTotal));
        series1.getData().add(new XYChart.Data(Movies, moviesTotal)); 
        series1.getData().add(new XYChart.Data(Pets, petsTotal));
        series1.getData().add(new XYChart.Data(Miscellaneous, miscellaneousTotal));
        series1.getData().add(new XYChart.Data(Office, officeTotal));
        series1.getData().add(new XYChart.Data(Toys, toysTotal));
        
        bc.getData().addAll(series1);
        
        if(graphType.equals("Horizontal"))
        {
        	XYChart.Series series2 = new XYChart.Series();
            series2.setName("test");       
            series2.getData().add(new XYChart.Data(appliancesTotal,Appliances));
            series2.getData().add(new XYChart.Data(automotiveTotal,Automotive));
            series2.getData().add(new XYChart.Data(beautyTotal, Beauty));
            series2.getData().add(new XYChart.Data(billsTotal,Bills));
            series2.getData().add(new XYChart.Data(booksTotal, Books));   
            series2.getData().add(new XYChart.Data(clothingTotal, Clothing));
            series2.getData().add(new XYChart.Data(electronicsTotal, Electronics));
            series2.getData().add(new XYChart.Data(entertainmentTotal, Entertainment));
            series2.getData().add(new XYChart.Data(foodTotal, Food));
            series2.getData().add(new XYChart.Data(moviesTotal, Movies)); 
            series2.getData().add(new XYChart.Data(petsTotal, Pets));
            series2.getData().add(new XYChart.Data(miscellaneousTotal, Miscellaneous));
            series2.getData().add(new XYChart.Data(officeTotal, Office));
            series2.getData().add(new XYChart.Data(toysTotal, Toys));
        	bcH.getData().addAll(series2);
        }
        
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data(Appliances, appliancesTotal),
                new PieChart.Data(Automotive, automotiveTotal),
                new PieChart.Data(Beauty, beautyTotal),
                new PieChart.Data(Bills, billsTotal),
                new PieChart.Data(Books, booksTotal),
                new PieChart.Data(Clothing, clothingTotal),
                new PieChart.Data(Electronics, electronicsTotal),
                new PieChart.Data(Entertainment, entertainmentTotal),
                new PieChart.Data(Food, foodTotal),
                new PieChart.Data(Movies, moviesTotal),
                new PieChart.Data(Pets, petsTotal),
                new PieChart.Data(Miscellaneous, miscellaneousTotal),
                new PieChart.Data(Office, officeTotal),
                new PieChart.Data(Toys, toysTotal));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Goal="+budgetAmount+" Currently="+budgetTotal+" Overbudget="+overBudget+" Spend: "+f.format(budgetAmount/divideBy)+" per day");
        
        
        if(displayLayout.equals("Pie Chart"))
        {
        	Scene scenePie = new Scene(chart, 550, 600);
        	stageDisplayBudget.setScene(scenePie);
        }
        
        
        else if(displayLayout.equals("Bar Graph"))
        {
        	if(graphType.equals("Vertical"))
        	{
        		Scene sceneBar = new Scene(bc, 550, 600);
            	stageDisplayBudget.setScene(sceneBar);
        	}
        	else if(graphType.equals("Horizontal"))
        	{
        		Scene sceneBar = new Scene(bcH, 550, 600);
            	stageDisplayBudget.setScene(sceneBar);
        	}
        }
        
		
	}
	private void backButtonUser()
	{
		stageUserCreation.close();
		stageUserModification.close();
		stageUserDeletion.close();
		stageAddBudget.close();
		stageDeleteBudget.close();
		stageAddItem.close();
	}
	private void modifyBackButtonUser()
	{
		stageUserCreation.close();
		stageUserModification.close();
		stageUserDeletion.close();
		stageAddBudget.close();
		stageDeleteBudget.close();
		stageAddItem.close();
	}
	private void backButtonDelete()
	{
		stageUserCreation.close();
		stageUserModification.close();
		stageUserDeletion.close();
		stageAddBudget.close();
		stageDeleteBudget.close();
		stageAddItem.close();
	}
	private void backButtonBudget()
	{
		stageUserCreation.close();
		stageUserModification.close();
		stageUserDeletion.close();
		stageAddBudget.close();
		stageDeleteBudget.close();
		stageAddItem.close();
	}
	private void modifyBackButtonBudget()
	{
		stageUserCreation.close();
		stageUserModification.close();
		stageUserDeletion.close();
		stageAddBudget.close();
		stageModifyBudget.close();
		stageDeleteBudget.close();
		stageAddItem.close();
	}
	private void backButtonDeleteBudget()
	{
		stageUserCreation.close();
		stageUserModification.close();
		stageUserDeletion.close();
		stageAddBudget.close();
		stageDeleteBudget.close();
		stageAddItem.close();
	}
	private void backButtonItem()
	{
		stageUserCreation.close();
		stageUserModification.close();
		stageUserDeletion.close();
		stageAddBudget.close();
		stageAddItem.close();
	}
	private void modifyBackButtonItem()
	{
		stageUserCreation.close();
		stageUserModification.close();
		stageUserDeletion.close();
		stageAddBudget.close();
		stageAddItem.close();
		stageModifyItem.close();
	}
	private void deleteBackButtonItem()
	{
		stageUserCreation.close();
		stageUserModification.close();
		stageUserDeletion.close();
		stageAddBudget.close();
		stageAddItem.close();
		stageDeleteItem.close();
	}
	private void deleteClearButtonItem()
	{
		deleteItemName.clear();
	    deleteItemBudgetName.clear();
		deleteItemDate.clear();
	}
	private void backButtonCreateDisplay()
	{
		stageUserCreation.close();
		stageUserModification.close();
		stageUserDeletion.close();
		stageAddBudget.close();
		stageAddItem.close();
		stageCreateDisplay.close();
	}
	private void clearButton()
	{
		//need a clear for each of the 4 buttons
		username.clear();
		password.clear();
		firstName.clear();	
		lastName.clear();	
		budgetAmount.clear();	
		incomeAmount.clear();	
		savingsAmount.clear();	
		numberOfBankAccounts.clear();	
		bankAccountTotal.clear();	
	
	}
	private void modifyUserClearButton()
	{
		//need a clear for each of the 4 buttons
		modifyUsername.clear();
		modifyNewUsername.clear();
		modifyPassword.clear();
		modifyNewPassword.clear();
		modifyFirstName.clear();	
		modifyLastName.clear();	
		modifyBudgetAmount.clear();	
		modifyIncomeAmount.clear();	
		modifySavingsAmount.clear();	
		modifyNumberOfBankAccounts.clear();	
		modifyBankAccountTotal.clear();	
	
	}
	private void clearButtonBudget()
	{
		 budgetAmountTotal.clear();
		 budgetName.clear(); 
		 userNameBudget.clear();
		 rbWeekly.setSelected(false);
		 rbMonthly.setSelected(false);
		 rbYearly.setSelected(false);
		 budgetType="";
	
	}
	private void modifyClearButtonBudget()
	{
		 modifyBudgetAmountTotal.clear();
		 modifyBudgetName.clear(); 
		 modifyNewBudgetName.clear(); 
		 modifyUserNameBudget.clear();
		 modifyRbWeekly.setSelected(false);
		 modifyRbMonthly.setSelected(false);
		 modifyRbYearly.setSelected(false);
		 modifyBudgetType="";
	
	}
	private void clearButtonItem()
	{
		
		itemName.clear();
		itemPrice.clear();
		itemBudgetName.clear();	
		itemQuantity.clear();	
		itemDate.clear();	
		
	
	}
	private void modifyClearButtonItem()
	{
		
		modifyItemName.clear();
		modifyNewItemName.clear();
		modifyItemPrice.clear();
		modifyItemBudgetName.clear();	
		modifyItemQuantity.clear();	
		modifyItemDate.clear();
		modifyNewItemDate.clear();
		
	
	}
	private void exitButton() throws SQLException
	{
		m_conn.close();
		System.exit(0);			
	}
	private void setChoice(int index)
	{
		itemChoice = itemCategories[index];
	}
	private void setMonth(int index)
	{
		monthChoice = itemDateMonths[index];
	}
	private void setDay(int index)
	{
		dayChoice = itemDateDays[index];
	}
	private void deleteSetMonth(int index)
	{
		deleteMonthChoice = deleteItemDateMonths[index];
	}
	private void deleteSetDay(int index)
	{
		deleteDayChoice = deleteItemDateDays[index];
	}
	private void modifySetChoice(int index)
	{
		modifyItemChoice = modifyItemCategories[index];
	}
	private void modifySetMonth(int index)
	{
		modifyMonthChoice = modifyItemDateMonths[index];
	}
	private void modifySetDay(int index)
	{
		modifyDayChoice = modifyItemDateDays[index];
	}
	//
	private void modifyNewSetMonth(int index)
	{
		modifyNewMonthChoice = modifyNewItemDateMonths[index];
	}
	private void modifyNewSetDay(int index)
	{
		modifyNewDayChoice = modifyNewItemDateDays[index];
	}
	public static void main(String[] args) throws SQLException {
		
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				m_conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM",
						"password");
				
			}
			catch(Exception ex)
			{
				throw new SQLException ("Falied to initalize", ex);
			}
	
			
		Application.launch(args);
		
	}

}
