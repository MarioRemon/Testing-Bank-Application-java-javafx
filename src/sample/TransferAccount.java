package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class TransferAccount implements Initializable {
    @FXML
    private Label titleTransfer;
    private userDaoImpl u;

    @FXML
    private TextField toAccountTransfer;

    @FXML
    private CheckBox account1TransferAccounts;

    @FXML
    private CheckBox account2TransferAccounts;

    @FXML
    private TextField amountTransferAccount;

    @FXML
    private Button transferTransferAccount;

    @FXML
    private Button backTransferAccounts;

    @FXML
    void pushbackTransferAccounts(MouseEvent event) throws IOException {
        long startTime = System.currentTimeMillis();
        String H = "FirstPage.fxml";
        if(u.testBackTransfer(backTransferAccounts,H, titleTransfer))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"expecting Bank Statement actual := "+titleTransfer.getText()+"\nexpecting Back actual := "+backTransferAccounts.getText()+"\nTransfer scene to FirstScene actual := "+H+"\nTC(6,0) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"expecting Bank Statement actual := "+titleTransfer.getText()+"\nexpecting Back actual := "+backTransferAccounts.getText()+"\nTransfer scene to FirstScene actual := "+H+"\nTC(6,0) Failed").showAndWait();
        }

        Main m = new Main();
        m.changeScene(H);
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushtransferTransferAccount(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        boolean found1 = false;
        boolean found2 = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE account1 = '"+toAccountTransfer.getText()+"'");
            if (rs.next()) {
                found1 = true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE account2 = '"+toAccountTransfer.getText()+"'");
            if (rs.next()) {
                found2 = true;

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        if(account1TransferAccounts.isSelected())
        {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("update client set amount1 = amount1 -'"+parseInt(amountTransferAccount.getText())+"'where flag = '1'");
                JOptionPane.showMessageDialog(null, "you have successfully Transferred", "Confirmation", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        else if(account2TransferAccounts.isSelected())
        {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("update client set amount2 = amount2 - '"+parseInt(amountTransferAccount.getText())+"' where flag = '1'");
                JOptionPane.showMessageDialog(null, "you have successfully Transferred", "Confirmation", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
        if(found1)
        {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("update client set amount1 = amount1 + '"+parseInt(amountTransferAccount.getText())+"' where account1 = '"+toAccountTransfer.getText()+"'");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        else if(found2)
        {
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("update client set amount2 = amount2 + '"+parseInt(amountTransferAccount.getText())+"' where account2 = '"+toAccountTransfer.getText()+"'");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

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
