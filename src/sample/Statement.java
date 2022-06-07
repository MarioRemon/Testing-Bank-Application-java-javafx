package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Statement  implements Initializable {

    @FXML
    private Button showStatementStatement;

    @FXML
    private Label Account1Statement;

    @FXML
    private Label Amount1Statement;

    @FXML
    private Label account2Statement;

    @FXML
    private Label amount2Statement;

    private userDaoImpl u;
    @FXML
    private Label titleStatement;

    @FXML
    private Button backStatement;

    @FXML
    void pushbackStatement(MouseEvent event) throws IOException {
        long startTime = System.currentTimeMillis();
        String H = "FirstPage.fxml";
        if(u.testBackStatement(backStatement,H, titleStatement))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"expecting Bank Statement actual := "+titleStatement.getText()+"expecting Back actual := "+backStatement.getText()+"\nTransfer scene to FirstScene actual := "+H+"\nTC(5,0) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"expecting Bank Statement actual := "+titleStatement.getText()+"expecting Back actual := "+backStatement.getText()+"\nTransfer scene to FirstScene actual := "+H+"\nTC(5,0) Failed").showAndWait();
        }

        Main m = new Main();
        m.changeScene(H);
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushshowStatementStatement(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        Account1Statement.setVisible(true);
        Amount1Statement.setVisible(true);
        account2Statement.setVisible(true);
        amount2Statement.setVisible(true);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select* from client comments where flag = '1'");
            while (rs.next()) {
                Account1Statement.setText(String.valueOf((rs.getString("account1"))));
                account2Statement.setText(String.valueOf((rs.getString("account2"))));
                Amount1Statement.setText(String.valueOf((rs.getString("amount1"))));
                amount2Statement.setText(String.valueOf((rs.getString("amount2"))));
            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if(u.testShowStatement(Account1Statement,account2Statement,Amount1Statement,amount2Statement))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"expecting Labels visible\nTC(5,1) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"expecting Labels visible\nTC(5,1) Failed").showAndWait();
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