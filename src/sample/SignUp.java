package sample;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.cert.Extension;
import java.sql.*;
import java.sql.DriverManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SignUp implements Initializable {

    @FXML
    private TextField am1;

    @FXML
    private TextField am2;

    @FXML
    private Label titleSignUp;

    @FXML
    private TextField account1;

    @FXML
    private TextField SecuirtyNumber1;

    @FXML
    private TextField account2;

    @FXML
    private TextField SecuirtyNumber2;
    @FXML
    private TextField userNameSignUp;

    @FXML
    private TextField addressSignUp;

    @FXML
    private TextField ageSignUp;

    @FXML
    private PasswordField passwordSignUp;

    @FXML
    private TextField phoneNumberSignUp;

    @FXML
    private Button backSignUp;

    private userDaoImpl u;

    @FXML
    private Button submitSignUp;

    @FXML
    void pushbackSignUp(MouseEvent event) throws IOException {
        long startTime = System.currentTimeMillis();
        String H =  "Home.fxml";
        if(u.backSignUpPage(backSignUp.getText(),H))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Test Button expecting Back\nactual:= "+backSignUp.getText()+"\nFunction Transfer to Home actual := "+H+"\nTC(1,0) passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Test Button expecting Back\nactual:= "+backSignUp.getText()+"\nFunction Transfer to Home actual := "+H+"\nTC(1,0) passed").showAndWait();
        }
        Main m = new Main();
        m.changeScene(H);
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }
    @FXML
    void pushsubmitSignUp(MouseEvent event)throws IOException {
        long startTime = System.currentTimeMillis();
        String H = "FirstPage.fxml";
        String Username = userNameSignUp.getText();
        String Password  = passwordSignUp.getText();
        String phoneNumber = phoneNumberSignUp.getText();
        String address = addressSignUp.getText();
        String age = ageSignUp.getText();
        if(u.SignUpPage(Username, Password, phoneNumber, address, age, titleSignUp.getText(),H,account1,SecuirtyNumber1,account2,SecuirtyNumber2,am1,am2))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Label expecting Sign Up actual := "+titleSignUp.getText()+"\ntextfield1 expecting Super actual:= "+userNameSignUp.getText()+"\ntextfield2 expecting masr actual:= "+addressSignUp.getText()+"\ntextfield3 expecting 22 actual:= "+ageSignUp.getText()+"\ntextfield4 expecting 123 actual:= "+passwordSignUp.getText()+"\ntextfield5 expecting 123 actual:= "+phoneNumberSignUp.getText()+"\ntextfield6 expected a1 actual := "+account1.getText()+"\ntextfield7 expected s1 actual := "+SecuirtyNumber1.getText()+"\ntextfield8 expected a2 actual := "+account2.getText()+"\ntextfield9 expected s2 actual := "+SecuirtyNumber2.getText()+"\ntextfield10 expected 1000 actual := "+am1.getText()+"\ntextfield11 expected 1001 actual := "+am2.getText()+"\nButton text expecting Submit actual := "+submitSignUp.getText()+"\nFunction transfer to FirstPage actual := "+H+"\nTC(1,1) Passed").showAndWait();
        }
        else
        {
            //viewUtil.createAlert(Alert.AlertType.ERROR,"Label expecting Sign Up actual := "+titleSignUp.getText()+"\ntextfield1 expecting Super actual:= "+userNameSignUp.getText()+"\ntextfield2 expecting masr actual:= "+addressSignUp.getText()+"\ntextfield3 expecting 22 actual:= "+ageSignUp.getText()+"\ntextfield4 expecting 123 actual:= "+passwordSignUp.getText()+"\ntextfield5 expecting 123 actual:= "+phoneNumberSignUp.getText()+"\nButton text expecting Submit actual := "+submitSignUp.getText()+"\nFunction transfer to FirstPage actual := "+H+"\nTC(1,1) Failed").showAndWait();

            viewUtil.createAlert(Alert.AlertType.ERROR,"Label expecting Sign Up actual := "+titleSignUp.getText()+"\ntextfield1 expecting Super actual:= "+userNameSignUp.getText()+"\ntextfield2 expecting masr actual:= "+addressSignUp.getText()+"\ntextfield3 expecting 22 actual:= "+ageSignUp.getText()+"\ntextfield4 expecting 123 actual:= "+passwordSignUp.getText()+"\ntextfield5 expecting 123 actual:= "+phoneNumberSignUp.getText()+"\ntextfield6 expected a1 actual := "+account1.getText()+"\ntextfield7 expected s1 actual := "+SecuirtyNumber1.getText()+"\ntextfield8 expected a2 actual := "+account2.getText()+"\ntextfield9 expected s2 actual := "+SecuirtyNumber2.getText()+"\ntextfield10 expected 1000 actual := "+am1.getText()+"\ntextfield11 expected 1001 actual := "+am2.getText()+"\nButton text expecting Submit actual := "+submitSignUp.getText()+"\nFunction transfer to FirstPage actual := "+H+"\nTC(1,1) Failed").showAndWait();
        }
        Main m = new Main();
        try {
            ResultSet rs = null;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
            Statement stmt = con.createStatement();
            String sql = "INSERT IGNORE INTO client (Name,Address,Age, password ,phoneNumber ,account1,amount1,account2,amount2,SecurityNumber1,SecurityNumber2, flag) VALUES('"+ userNameSignUp.getText() + "','" + addressSignUp.getText() + "','" + ageSignUp.getText() + "','" + passwordSignUp.getText() + "','" + phoneNumberSignUp.getText() +"','" + account1.getText() +"','"+am1.getText()+"','" + account2.getText() +"','"+am2.getText()+"','" + SecuirtyNumber1.getText() +"','" + SecuirtyNumber2.getText() +"','0')";
            stmt.executeUpdate(sql);
            m.changeScene(H);
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        u = new userDaoImpl();
    }
}
