package sample;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Home implements Initializable {
    private userDaoImpl u;
    @FXML
    private TextField userNameHome;

    @FXML
    private PasswordField passwordHome;

    @FXML
    private Button signUpHome;
    @FXML
    private Button loginHome;

    @FXML
    private Label titleHome;

    @FXML
    void pushsignUpHome(MouseEvent event)  throws IOException {
        long startTime = System.currentTimeMillis();
        String H = "SignUp.fxml";
        String signUp = signUpHome.getText();
        if(u.signUp(signUp, H))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Button's text expecting SignUp\nactual: " + signUp + "\nFunction Transfer scene to "+H+"\nTC(0,1) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Button's text expecting SignUp\nactual: " + signUp + "\nFunction Transfer scene to "+H+"TC(0,1) Failed").showAndWait();
        }
        Main m = new Main();
        m.changeScene(H);
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }
    @FXML
    void pushloginHome(MouseEvent event) throws IOException {
        long startTime = System.currentTimeMillis();
        String H = "FirstPage.fxml";
        boolean found = true;
        String UserName = userNameHome.getText();
        String password = passwordHome.getText();
        String Title = titleHome.getText();
        String btn = loginHome.getText();
        if(u.login(UserName, password, Title, btn,H))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"expecting Mario := actual: " + userNameHome.getText() + "\nexpecting 123 := actual: "+passwordHome.getText()+"\nexpecting Login := actual: "+loginHome.getText()+"\nFunction change scene expecting FirstPage actual := "+H+"\nexpecting Welcome to our Banking System := actual: "+titleHome.getText()+"\nTC(0,0) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"expecting Mario := actual: " + userNameHome.getText() + "\nexpecting 123 := actual: "+passwordHome.getText()+"\nexpecting Login := actual: "+loginHome.getText()+"\nFunction change scene expecting FirstPage actual := "+H+"\nexpecting Welcome to our Banking System := actual: "+titleHome.getText()+"\nTC(0,0) Failed").showAndWait();
        }
        Main m = new Main();
        if (userNameHome.getText().isEmpty() || passwordHome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "The username or password is empty", "Why Empty", JOptionPane.PLAIN_MESSAGE);
        }
        else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from client where Name = '" + userNameHome.getText() + "' and password = '" + passwordHome.getText() + "'");
                while (rs.next()) {
                    found = false;
                    m.changeScene(H);
                }
                stmt.executeUpdate("update client set flag = '1' where Name = '" + userNameHome.getText() + "'");
                con.close();
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        if(found)
        {
            JOptionPane.showMessageDialog(null, "Account not founded", "Rejection", JOptionPane.PLAIN_MESSAGE);

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
