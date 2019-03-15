




import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AtmGUI extends Application {
Stage window;
Scene login, menu, withdrawscene, depositscene, balancescene;
Button submit;
TextField txt;
int i=0;
public static void main (String args[]) {

launch(args);
}

Account acc=new Account();

@Override
public void start(Stage primaryStage) throws Exception {
	window = primaryStage;
	//login scene
	
Label cardnumberlabel = new Label("Enter Your Card Number:");
TextField cardnumberField = new TextField();
Label error=new Label();
Button loginbutton = new Button(">Login<");

 
loginbutton.setOnAction(e ->{
	String cardnumber = cardnumberField.getText();
	boolean checker=Account.check(cardnumber);
	if(checker)

window.setScene(menu);
	else
		error.setText("Wrong Card Number, Try Again.");
	cardnumberField.setText("");
});   

VBox layout1 = new VBox(20);
   layout1.getChildren().addAll(cardnumberlabel, cardnumberField,loginbutton,error);
login = new Scene(layout1, 200,200);
 //menu scene
   Label welcome = new Label("Welcome To Main Menu:");
   Button withdraw = new Button("Withdraw");
   Button deposit = new Button("Deposit");
   Button balance = new Button("Balance Inquiry");
   Button prev = new Button("<-- Previous");
   Button next = new Button("Next -->");   
   Button logout = new Button("<Logout>");
   logout.setOnAction(e -> {
	   cardnumberField.setText("");
	   error.setText("");
	   window.setScene(login);	
	   }); 
  
   withdraw.setOnAction( e -> window.setScene(withdrawscene));
  Label label2 = new Label("Enter Amount You Want To Withdraw:");
  TextField txt1 = new TextField();
  Button submit1 = new Button("Enter");
  Button prev3 = new  Button("<-- Previous");
  VBox scene1 = new VBox(20);
  Label error3=new Label();

  scene1.getChildren().addAll(label2, txt1, submit1,prev3,error3);
  withdrawscene = new Scene(scene1, 400, 300);
 prev3.setOnAction(e->
 {
 window.setScene(menu);
error3.setText("");
 txt1.setText("");
 
 });
 
 submit1.setOnAction(e->{
	 if(txt1.getText().trim().isEmpty())
		{
	  error3.setText("Please Enter The Amount First.");
		}
	 else
	 {
	 String bal=txt1.getText();
  double x=Double.valueOf(bal);
 boolean valid2=acc.Withdraw(x);
 if(valid2)
 { acc.navigation("WithDrawal Of " +txt1.getText());
 error3.setText("WithDrawal Successfully Done, Enter Again If You Want.");
 txt1.setText(""); 
 }
 else
	 error3.setText("Error, Please Enter Again.");
 txt1.setText("");

	    }});
 
  
  deposit.setOnAction( e -> window.setScene(depositscene));
   Label label1 = new Label("Enter Amount You Want To Deposit:");
   TextField txt = new TextField();
   Button submit = new Button("Enter");
   Button prev2 = new  Button("<-- Previous");
   Label error2=new Label();
   VBox scene = new VBox(20);
   
   scene.getChildren().addAll(label1, txt, submit,prev2,error2);
   depositscene = new Scene(scene,400, 300);
  prev2.setOnAction(e->
  { 
  window.setScene(menu);
  error2.setText("");
  txt.setText("");

  });
  


submit.setOnAction(e->{
	if(txt.getText().trim().isEmpty())

	{
  error2.setText("Please Enter The Amount First");

	}
  
	else {
	String bal2=txt.getText();
double y=Double.valueOf(bal2);
  boolean valid=acc.deposit(y);
  if(valid) {
	  acc.navigation("Deposit Of " +txt.getText());
  error2.setText("Amount Sucsessfully Deposited, Enter Again If You Want.");
  txt.setText("");
  
  
}
  else
	  error2.setText("Error, Please Enter Again.");
  txt.setText("");

	
	}}	  );
 
   

  Label label3 = new Label ("Your Balance Is ");
Button prev4 =  new Button ("<-- Previous");   
Label balance1 = new Label();

   balance.setOnAction( e -> {window.setScene(balancescene);
balance1.setText(Double.toString(acc.getBalance()));   
   });
VBox layout3=new VBox();
layout3.getChildren().addAll(label3,balance1,prev4);
prev4.setOnAction(e->window.setScene(menu));


Label navigationhistory=new Label();
balancescene=new Scene(layout3,200,200);
VBox layout2 = new VBox();
Label history=new Label("Click On Next Or Previous To Navigate Your Transaction:");
layout2.getChildren().addAll(welcome, withdraw, deposit, balance, prev, next,history,navigationhistory,logout);
menu = new Scene(layout2, 600, 300);

 
 prev.setOnAction(e->{if(i!=0)
	{navigationhistory.setText(acc.navigation[i-1]);
i--;}

});
next.setOnAction(e->{if(i<5) {
	navigationhistory.setText(acc.navigation[i]);
i++;}
});







window.setScene(login);
	  window.setTitle("ATM");
	  window.show();
   


}




}




