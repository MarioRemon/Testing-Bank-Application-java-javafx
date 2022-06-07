package sample;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class userDaoImpl {
    public boolean login(String UserName, String Password, String Title,String btn, String H)
    {
        return UserName.equals("Mario") && Password.equals("123") && Title.equals("Welcome to our Banking System") && btn.equals("Login") && H.equals("FirstPage.fxml");
    }
    public boolean signUp(String signUpText,String H)
    {
        return signUpText.equals("SignUp") && H.equals("SignUp.fxml");
    }
    public boolean SignUpPage(String Username, String Password, String phoneNumber, String address, String age, String title, String H, TextField a1, TextField s1, TextField a2, TextField s2, TextField am1, TextField am2)
    {
        System.out.println(a1.getText());
        System.out.println(s1.getText());
        System.out.println(a2.getText());
        System.out.println(s2.getText());
        System.out.println(am1.getText());
        System.out.println(am2.getText());
        return title.equals("Sign Up") && Username.equals("Super") && Password.equals("123") && phoneNumber.equals("123") && address.equals("masr") && age.equals("22") && H.equals("FirstPage.fxml") ;//&& a1.equals("a1") && s1.equals("s1") && a2.equals("a2") && s2.equals("s2") && am1.equals("1000") && am2.equals("1001");
    }
    public boolean backSignUpPage(String text, String H)
    {
        return text.equals("Back") && H.equals("Home.fxml") ;
    }

    public boolean backFirstPage(String text,String H, Label l)
    {
        return text.equals("Back") && H.equals("Home.fxml") && l.getText().equals("Services");
    }

    public boolean buyItemsSignUp(String text,String H)
    {
        return text.equals("Buy Items") && H.equals("BuyItem.fxml") ;
    }
    public boolean payBillsFirstPage(String text, String H)
    {
        return text.equals("Pay  Bills") && H.equals("Bills.fxml") ;
    }
    public boolean pushTransferAccounts(String text, String H)
    {
        return text.equals("Transfer Accounts") && H.equals("TransferAccounts.fxml") ;
    }
    public boolean pushSeeStatements(String text, String H)
    {
        return text.equals("See Statements") && H.equals("Statement.fxml");
    }

    public boolean testpushbuyCurrenciesBuyItems(String text,RadioButton l1, RadioButton l2, RadioButton l3, Label l4, Label l5, Label l6, TextField l7, Label l8, Button l9)
    {
        return (text.equals("Buy currencies") && l1.isVisible() && l1.getText().equals("$Dollars") && l2.isVisible() && l2.getText().equals("€ EUR") && l3.isVisible() && l3.getText().equals("₽ RUB")&& l4.isVisible() && l4.getText().equals("18")&& l5.isVisible() && l5.getText().equals("19")&& l6.isVisible() && l6.getText().equals("1") && l7.isVisible() && l7.getText().equals("")&& l8.isVisible()  && l8.getText().equals("Total Money Needed")&& l9.isVisible() && l9.getText().equals("Buy") );
    }
    public boolean testpushbuyBuyItems(RadioButton r,TextField t, Label l)
    {
        return r.getText().equals("$Dollars") && r.isSelected() && t.getText().equals("1") && l.getText().equals("18");
    }
    public boolean testpushbuyCertificatesBuyItems(Button b1, RadioButton r1, RadioButton r2, TextField t1, Button b2)
    {
        return b1.getText().equals("Buy Certificate") && r1.isVisible() && r1.getText().equals("20% Certificate") && r2.isVisible() && r2.getText().equals("18% Certificate") && t1.isVisible() && t1.getText().equals("") && b2.getText().equals("Buy Certificate") && b2.isVisible();
    }
    public boolean testpushRewardsBuyItems(Button b1,RadioButton r1, RadioButton r2, RadioButton r3, ImageView i1, ImageView i2, ImageView i3,Label l2, Label l1, Button b2)
    {
        return  b1.getText().equals("Rewards") && i1.isVisible() && i2.isVisible() && i3.isVisible() && l1.isVisible() && l2.isVisible() && l2.getText().equals("Points") && b2.isVisible() && b2.getText().equals("Redeem") && r1.isVisible() && r1.getText().equals("30 Points") && r2.isVisible() && r2.getText().equals("50 Points") && r3.isVisible() && r3.getText().equals("100 Points");
    }
    public boolean testShowBills(Button btn,Label title,Label a1,Label a2, Label a3, Label a4, Label a5, Label a6, Label b1, Label b2, Label b3, Label b4, Label b5,Label b6, Button p1, Button p2, Button p3, Button p4, Button p5, Button p6)
    {
        return btn.getText().equals("Show Bills") && title.getText().equals("Bills") && a1.isVisible() && b1.getText().equals("Kahraba") && a2.isVisible()  && b2.getText().equals("egar") && a3.isVisible() && b3.getText().equals("labn")&& a4.isVisible() && b4.getText().equals("la7ma") && a5.isVisible()  && b5.getText().equals("maya") && a6.isVisible() && b6.getText().equals("") && b1.isVisible() && a1.getText().equals("250")&& b2.isVisible() && a2.getText().equals("100") && b3.isVisible()  && a3.getText().equals("120") && b4.isVisible() && a4.getText().equals("4300") && b5.isVisible() && a5.getText().equals("200") && b6.isVisible() && a6.getText().equals("") && p1.isVisible() && p1.getText().equals("Pay") && p2.getText().equals("Pay")&& p3.getText().equals("Pay") && p4.getText().equals("Pay") && p5.getText().equals("Pay") && p6.getText().equals("Pay") && p2.isVisible() && p3.isVisible() && p4.isVisible() && p5.isVisible() && p6.isVisible();
    }
    public boolean testPay(Button btn,RadioButton r1, RadioButton r2, Button b1)
    {
        return btn.getText().equals("Pay") && r1.isVisible() && r1.getText().equals("Visa Card") && r2.isVisible() && r2.getText().equals("Cash") && b1.isVisible() && b1.getText().equals("Selected");
    }
    public boolean testBackBills(Button Btn, String H)
    {
        return Btn.getText().equals("Back") && H.equals("FirstPage.fxml");
    }
    public boolean testSelectedBills( TextField t1, TextField t2, Label l1, Label l2, Button btn)
    {
        return t1.isVisible() && t2.isVisible() && l1.isVisible() && l2.isVisible() && btn.isVisible() && btn.getText().equals("Confirm Payment");
    }
    public boolean testConfirmPayment(TextField t1, TextField t2)
    {
        return t1.getText().equals("mario") && t2.getText().equals("55");
    }
    public boolean testBackBuyItems(Button btn,String H)
    {
        return btn.getText().equals("Back") && H.equals("FirstPage.fxml");
    }
    public boolean testBackStatement(Button btn, String H, Label l1)
    {
        return btn.getText().equals("Back") && H.equals("FirstPage.fxml") && l1.getText().equals("Bank Statement");
    }
    public boolean testShowStatement(Label l1, Label l2, Label l3, Label l4)
    {
        return l1.isVisible() && l2.isVisible() && l3.isVisible() && l4.isVisible();
    }
    public boolean testBackTransfer(Button btn, String H, Label l1)
    {
        return btn.getText().equals("Back") && H.equals("FirstPage.fxml") && l1.getText().equals("Transfer Accounts");
    }
}
