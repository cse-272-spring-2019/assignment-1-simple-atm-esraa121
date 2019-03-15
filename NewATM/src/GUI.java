import java.util.Scanner;
	import javafx.application.Application;
	import javafx.scene.control.Label;
	import javafx.stage.Stage;
	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.GridPane;
	import javafx.scene.layout.StackPane;
	import javafx.stage.Stage;
	import javafx.geometry.Insets;
	import javafx.geometry.Pos;

	
public class GUI extends Application {
	
		CreditData data;
		Transactions currentBalance;
		
		Stage stage;
		Scene scene,scene1,sceneWithdraw,sceneWithdraw1,sceneDeposit;
		Scene sceneDeposit1,sceneCurrentBalance,sceneCurrentBalance1,sceneExit;
		String withdrawnAmount;
		double bal ;
		
		public static void main(String[] args) {
			launch(args);
		}
		
		public void start(Stage primaryStage) throws Exception  {
			stage = primaryStage;
			data = new CreditData();
			currentBalance = new Transactions();
		
			bal=currentBalance.getCurrentBalance();
			primaryStage.setTitle("ATM Machine");
			
			GridPane grid = new GridPane();			
			Label label1=new Label ("Welcome to the ATM machine");
			grid.add(label1, 0, 0);
			
			Label userName = new Label("credit card:");
			grid.add(userName, 0, 1);
			
			Scene scene = new Scene(grid, 400, 200);
			
			TextField userTextField = new TextField();
			grid.add(userTextField, 1, 1);
			
			
			Label pw = new Label("Pass code:");
			grid.add(pw, 0, 2);
			PasswordField pwBox = new PasswordField();
			grid.add(pwBox, 1, 2);
			
			
			Button enter = new Button("Enter");
			
			 grid.add(enter, 1, 4);
			
			
			String username = data.getcreditNum();
			String password = data.getpinCode();
			
			Label invalid = new Label("incorrect information..");
			
		
			// second scene components
			GridPane grid1 = new GridPane();
			
			Label label2=new Label("Welcome to the main menu");
			grid1.add(label2, 2, 0);
			Scene scene1 = new Scene(grid1, 600, 200);
			
			Button withdraw = new Button("Withdraw");
			
			grid1.add(withdraw, 0, 3);

			
			
			Button deposit = new Button("Deposit");
			deposit.setOnAction(new EventHandler<ActionEvent>() {
				 
			    @Override
			    public void handle(ActionEvent e) {
			    primaryStage.setScene(sceneDeposit);
			    
			   
			    }
			});
			
			
			grid1.add(deposit, 0, 5);

			Button balance = new Button("Balance inquire");

			grid1.add(balance, 0, 7);

			// prev &next label
			GridPane grid10=new GridPane ();
			Button prev = new Button("Previous transaction");
			
			grid1.add(prev, 0, 11);
			
			Label previousNext= new Label();

			grid1.add(previousNext, 10, 11);
			
			
			Button gomenu2 = new Button("go to the main menu");
			
				grid10.add(gomenu2, 7, 11);
				Label gomenu3=new Label();
				grid10.add(gomenu3, 2, 0);
				gomenu2.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						 primaryStage.setScene(scene1);					
					}
				});
			
			prev.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					
					currentBalance.prev();
					previousNext.setText(currentBalance.getString());
	
				}
			});

			GridPane grid11=new GridPane ();
			Button next = new Button("Next transaction");
			
			grid1.add(next, 0, 12);

			next.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					
					currentBalance.next();
					previousNext.setText(currentBalance.getString());
	
				}
			});
	
			Button gomenu = new Button("go to the main menu");
		
			grid11.add(gomenu, 7, 11);
			Label gomenu1=new Label();
			grid11.add(gomenu1, 2, 0);
			gomenu.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					 primaryStage.setScene(scene1);					
				}
			});
			
			
			Button exit = new Button("Exit");
			
			grid1.add(exit, 7, 15);

			//------------------------------------------------------------------------------------------------------------------------
			
			//withdraw scene 
			GridPane grid2 = new GridPane();
			
			grid2.setPadding(new Insets(100, 50, 100, 100));
			Label label3=new Label("Enter the value you want to withdraw :");
			grid2.add(label3, 0, 0);
			Scene sceneWithdraw = new Scene(grid2, 700, 200);
			
			Label amount = new Label ("Withdraw amount");
			grid2.add(amount, 0, 1);
			TextField amountText = new TextField();
			grid2.add(amountText, 1, 1);
			
			
			Button enter1 = new Button("Enter");
			
			grid2.add(enter1, 7, 11);
			Label notEnough =new Label() ;
			grid2.add(notEnough, 0, 10);


			//____  internal withdraw scene
			
			GridPane grid6 = new GridPane();
			
			Label charValidate1 = new Label ();
			
			grid6.add(charValidate1, 0, 7);
			Scene sceneWithdraw1 = new Scene(grid6, 300, 300);
			
			Button menu = new Button("go to the main menu");
			
			grid6.add(menu, 7, 11);
			
			
			menu.setOnAction(new EventHandler<ActionEvent>() {
				 
			    @Override
			    public void handle(ActionEvent e) {
			    primaryStage.setScene(scene1);
			    
			   
			    }
			});

			//_______________________________________________
			//deposit scene
			
			
			Label label4=new Label("Enter the value you want to deposit");
			Label amountd = new Label ("Deposit amount");
			TextField amountTextd = new TextField();
			Label label11=new Label();
			
			Label charValidate = new Label ();
			
			Button enter2 = new Button("Enter");
			GridPane grid7 = new GridPane();
			grid7.add(label11, 0, 2);
			grid7.add(charValidate, 0, 7);
			
			
			sceneDeposit1 = new Scene(grid7, 300, 300);
			enter2.setOnAction(new EventHandler<ActionEvent>() {
				 
			    @Override
			    public void handle(ActionEvent e) {
			    
				    
				    	primaryStage.setScene(sceneDeposit1);
				    	try { 
				    		
				    		
				    		currentBalance.deposit(Double.parseDouble(amountTextd.getText()));
					    	
					    	label11.setText("the balance is : " + currentBalance.getCurrentBalance());
				    		}
				    	catch (NumberFormatException n )
				    	{
				    		label11.setText("");
				    		charValidate.setText("please enter a number\n not letters ");
				    		
				    		
				    	}				    	
				    	
			    }
			});
			GridPane grid3 = new GridPane();
			
			
			grid3.add(label4, 2, 0);
			grid3.add(amountd, 0, 5);
			grid3.add(amountTextd, 1, 5);
			grid3.add(enter2, 4, 5);
			sceneDeposit = new Scene(grid3, 500, 400);

					Button menu1 = new Button("go to the main menu");
					grid7.add(menu1, 7, 11);
				
					
					menu1.setOnAction(new EventHandler<ActionEvent>() {
						 
					    @Override
					    public void handle(ActionEvent e) {
					    primaryStage.setScene(scene1);
					    
					   
					    }
					});
				
			
			//exit scene
			GridPane grid5 = new GridPane();
			
			grid5.setPadding(new Insets(100, 50, 100, 100));
			Label label6=new Label("Thank you for using our ATM Machine..");
			grid5.add(label6, 2, 0);
			Scene sceneExit = new Scene(grid5, 500, 400);
			
			
			// the action of enter button 
			
			enter.setOnAction(new EventHandler<ActionEvent>() {
				 
			    @Override
			    public void handle(ActionEvent e) {
			    
			    	if (username.equals(userTextField.getText()) && password.equals(pwBox.getText()))
					{	
			  
			    		primaryStage.setScene(scene1);
						
					}
					else {
						grid.add(invalid, 0, 5);
					}
			    }
			});
			
			//_________________________________________________
			
			//the action of withdraw button
			withdraw.setOnAction(new EventHandler<ActionEvent>() {
				 
			    @Override
			    public void handle(ActionEvent e) {
			    primaryStage.setScene(sceneWithdraw);
			   
			    
			    }
			});
			Label labels = new Label();
    		grid6.add(labels, 0, 5);
			
			//______action of enter 1 button
			
			enter1.setOnAction(new EventHandler<ActionEvent>() {
				 
			    @Override
			    public void handle(ActionEvent e) {
			    	primaryStage.setScene(sceneWithdraw1);
			    	
			    	try { 
			    		 if(currentBalance.withDraw( Double.parseDouble(amountText.getText() ) ) )
				    		{
				    		
				    		labels.setText("your current balance is : " + currentBalance.getCurrentBalance() );
				    		}
				    else
				    	
				    	notEnough.setText("The current balance is not enough to withdraw");
				    	
				    
			    		}
			    	catch (NumberFormatException n )
			    	{
			    		//label11.setText("");
			    		charValidate1.setText("please enter a number\n not letters ");
			    		
			    		
			    	}				    	

			    }
			});

			//__________________________________________________-
			
			
					//current balance scene
					GridPane grid4 = new GridPane();
					 sceneCurrentBalance = new Scene(grid4, 500, 400);
					
					Button menu3 = new Button("go to the main menu");
				
					grid4.add(menu3, 7, 11);
					Label label5=new Label();
					grid4.add(label5, 2, 0);
					menu3.setOnAction(new EventHandler<ActionEvent>() {
						 
					    @Override
					    public void handle(ActionEvent e) {
					    primaryStage.setScene(scene1);
					    
					   
					    }
					});
					
				
		//__________________________________________________________
					
			// the action of current balance button
					balance.setOnAction(new EventHandler<ActionEvent>() {
						 
					    @Override
					    public void handle(ActionEvent e) {
					    primaryStage.setScene(sceneCurrentBalance);
					    currentBalance.inquiure();
					    label5.setText("The current Balance is .."+currentBalance.getCurrentBalance());
					    
					   
					    }
					});
			
			//______________________________________________________-
					// the action of exit button
					exit.setOnAction(new EventHandler<ActionEvent>() {
						 
					    @Override
					    public void handle(ActionEvent e) {
					    primaryStage.setScene(sceneExit);
		
					    }
					});
				
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}
	}

