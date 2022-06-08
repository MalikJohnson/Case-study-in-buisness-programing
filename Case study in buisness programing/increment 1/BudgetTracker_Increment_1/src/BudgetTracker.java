
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
		private Button addBudget = new Button("Add Budget");
		private Button addItem = new Button("Add Item");
		private Button displayBudget = new Button("Display Budget");
		private Button displayItems = new Button("Display Items");
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
		
		//Add Item Buttons
		private Button submitButtonItem = new Button("SUBMIT");
		private Button clearButtonItem = new Button("CLEAR");
		private Button backButtonItem = new Button("BACK");
		
		//Add Item Combo Box Variables
		private String[] itemCategories = {"Applicances","Automotive and Vehicals", "Beauty Products","Bills and Loans", "Books and CDS","Clothing and Jewlery", "Electronics and Apps", "Entertainment","Food and Groceries", "Movies and Tv","Pets","Miscellaneous","Office products and Home Improvement", "Toys and Children"};
		//JComboBox itemCategoriesList = new JComboBox(itemCategories);
		private ComboBox<String> itemCombo = new ComboBox<>();
		ObservableList<String>items = FXCollections.observableArrayList(itemCategories);
		String itemChoice="";
		
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
		
		
		
		
		
		//stages used
		Stage stageUserCreation = new Stage();
		Stage stageUserDeletion = new Stage();
		Stage stageAddBudget = new Stage();
		Stage stageAddItem = new Stage();
		
		
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
				paneMain.add(addBudget, 2, 0);
				paneMain.add(addItem, 0, 1);
				paneMain.add(displayBudget, 1, 1);
				paneMain.add(displayItems, 2, 1);
				paneMain.add(setReminder, 0, 2);
				paneMain.add(help, 1, 2);
				paneMain.add(exitProgram, 2, 2);
				
				//create main scene
				Scene sceneMain = new Scene(paneMain, 400, 400);
				
				//Add items to comboBox on create Item page
				itemCombo.getItems().addAll(items);
				itemComboMonths.getItems().addAll(Months);
				itemComboDays.getItems().addAll(Days);
				
				//actions for buttons
				itemCombo.setOnAction(e->setChoice(items.indexOf(itemCombo.getValue())));
				itemComboMonths.setOnAction(e->setMonth(Months.indexOf(itemComboMonths.getValue())));
				itemComboDays.setOnAction(e->setDay(Days.indexOf(itemComboDays.getValue())));
				clearButtonUser.setOnAction(e->clearButton());
				clearButtonBudget.setOnAction(e->clearButtonBudget());
				clearButtonItem.setOnAction(e->clearButtonItem());
				backButtonUser.setOnAction(e->backButtonUser());
				backButtonDelete.setOnAction(e->backButtonDelete());
				backButtonBudget.setOnAction(e->backButtonBudget());
				backButtonItem.setOnAction(e->backButtonItem());
				exitProgram.setOnAction(e->{
					try {
						exitButton();
					} catch (SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
				});
				createUser.setOnAction(e->createUserButton());
				deleteUser.setOnAction(e->deleteUserButton());
				addBudget.setOnAction(e->addBudgetButton());
				addItem.setOnAction(e->addItemButton());
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
				
				submitButtonBudget.setOnAction(e->{
					try {
						submitButtonBudget();
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
			catch(IllegalArgumentException ex)
			{
				
			}
		}
	
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
					System.out.println(idValue);
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
				
				
				
			    Date itemDateFormat=new SimpleDateFormat("dd/MMM/yyyy").parse(itemDateT);  
			    java.sql.Date date=new java.sql.Date(5);  
			    date = new java.sql.Date(itemDateFormat.getTime());
				//need to check if budget overbalance before adding
			    
			    //Get budget total
			    String queryId3 = "SELECT BUDGETTOTAL FROM MJ_BUDGET WHERE BUDGETNAME=?";
				PreparedStatement preparedStmtId3 = m_conn.prepareStatement(queryId3);
				preparedStmtId3.setString(1, itemBudgetNameT);
				ResultSet rs2 = preparedStmtId3.executeQuery();
			    double bTotal=0;
				while(rs2.next())
				{
					bTotal = rs2.getDouble(1);
				}
			   
			    //Update budgetTotal in budget table
				String queryId2 = "UPDATE MJ_Budget SET BUDGETTOTAL = ?+? WHERE BUDGETNAME=?";
				PreparedStatement preparedStmtId2 = m_conn.prepareStatement(queryId2);
				preparedStmtId2.setDouble(1, itemPriceT);
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
	private void clearButtonItem()
	{
		
		itemName.clear();
		itemPrice.clear();
		itemBudgetName.clear();	
		itemQuantity.clear();	
		itemDate.clear();	
		
	
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
			String query = "DELETE FROM MJ_USER WHERE USERNAME=?";
			//selectStmt2.executeQuery(query);
			PreparedStatement preparedStmt = m_conn.prepareStatement(query);
			preparedStmt.setString(1, userName);
			
			
			//preparedStmt.setString(2, passWord);
			preparedStmt.execute();
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
	private void backButtonUser()
	{
		stageUserCreation.close();
		stageUserDeletion.close();
		stageAddBudget.close();
		stageAddItem.close();
	}
	private void backButtonDelete()
	{
		stageUserCreation.close();
		stageUserDeletion.close();
		stageAddBudget.close();
		stageAddItem.close();
	}
	private void backButtonBudget()
	{
		stageUserCreation.close();
		stageUserDeletion.close();
		stageAddBudget.close();
		stageAddItem.close();
	}
	private void backButtonItem()
	{
		stageUserCreation.close();
		stageUserDeletion.close();
		stageAddBudget.close();
		stageAddItem.close();
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
