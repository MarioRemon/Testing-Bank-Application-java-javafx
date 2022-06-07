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

public class Bills implements Initializable {
    private userDaoImpl u;
    @FXML
    private Label b1;

    @FXML
    private Label a1;
    @FXML
    private Label titleBills;
    @FXML
    private Label b2;

    @FXML
    private Label b3;

    @FXML
    private Label b4;

    @FXML
    private Label b5;

    @FXML
    private Label b6;

    @FXML
    private Label a2;

    @FXML
    private Label a3;

    @FXML
    private Label a4;

    @FXML
    private Label a5;

    @FXML
    private Label a6;

    @FXML
    private PasswordField securityNumber;

    @FXML
    private TextField visaNumber;

    @FXML
    private Button showBills;

    @FXML
    private Button pay1;

    @FXML
    private Button pay2;

    @FXML
    private Button pay3;

    @FXML
    private Button pay4;

    @FXML
    private Button pay5;

    @FXML
    private Button pay6;

    @FXML
    private Button backBills;

    @FXML
    private RadioButton visaCardBills;

    @FXML
    private RadioButton cashBills;

    @FXML
    private Label toBills;

    @FXML
    private Label amountBills;

    @FXML
    private Button confirmPaymentBills;

    @FXML
    private Button selectedBills;

    @FXML
    void pushbackBills(MouseEvent event) throws IOException {
        long startTime = System.currentTimeMillis();
        String H = "FirstPage.fxml";
        if(u.testBackBills(backBills,H))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Test expecting Back actual :="+backBills.getText()+"\n All labels are visible\nTC(3,0) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Test expecting Back actual :="+backBills.getText()+"\n All labels are visible\nTC(3,0) Failed").showAndWait();
        }
        Main m = new Main();
        m.changeScene(H);
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushconfirmPaymentBills(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        if (visaNumber.getText().isEmpty() || securityNumber.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "The visaNumber or Security Number is empty", "Why Empty", JOptionPane.PLAIN_MESSAGE);
        } else {
            boolean found1 = false;
            boolean found2 = false;
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
                java.sql.Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE account1 = '" + visaNumber.getText() + "' and SecurityNumber1 = '"+securityNumber.getText()+"'");
                if (rs.next()) {
                    found1 = true;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE account2 = '" + visaNumber.getText() + "' and SecurityNumber1 = '"+securityNumber.getText()+"'");
                if (rs.next()) {
                    found2 = true;
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            if (found1) {
                boolean balance = true;
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE flag = '" + 1 + "'");
                    if (rs.next()) {
                        int amount = Integer.valueOf((rs.getString("amount1")));
                        if (amount < Integer.parseInt(amountBills.getText())) {
                            balance = false;
                            JOptionPane.showMessageDialog(null, "No enough in your Account", "Rejection", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                if (balance) {
                    try {

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("update client set amount1 = amount1 - '" + Integer.parseInt(amountBills.getText()) + "' where flag = '1'");
                        JOptionPane.showMessageDialog(null, "you have successfully paid bills", "Confirmation", JOptionPane.PLAIN_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            } else if (found2) {
                boolean balance = true;
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE flag = '" + 1 + "'");
                    if (rs.next()) {
                        int amount = Integer.valueOf((rs.getString("amount2")));
                        if (amount < Integer.parseInt(amountBills.getText())) {
                            balance = false;
                            JOptionPane.showMessageDialog(null, "No enough in your Account", "Rejection", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                if (balance) {
                    try {

                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("update client set amount2 = amount2 - '" + Integer.parseInt(amountBills.getText()) + "' where flag = '1'");
                        JOptionPane.showMessageDialog(null, "you have successfully paid bills", "Confirmation", JOptionPane.PLAIN_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
            if(!found1 && !found2)
            {
                JOptionPane.showMessageDialog(null, "wrong Account Name or Security Number", "Rejection", JOptionPane.PLAIN_MESSAGE);

            }
        }
        if(u.testConfirmPayment(visaNumber, securityNumber))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"expecting mario actual := "+visaNumber.getText()+"\n expecting 55 actual:= "+securityNumber.getText()+"\nTC(3,9) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"expecting mario actual := "+visaNumber.getText()+"\n expecting 55 actual:= "+securityNumber.getText()+"\nTC(3,9) Passed").showAndWait();
        }
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");

    }
    @FXML
    void pushselectedBills(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        if(visaCardBills.isSelected())
        {
            selectedBills.setVisible(true);
            visaNumber.setVisible(true);
            securityNumber.setVisible(true);
            confirmPaymentBills.setVisible(true);
            toBills.setVisible(true);
            amountBills.setVisible(true);
            if(u.testSelectedBills(visaNumber, securityNumber, toBills, amountBills, confirmPaymentBills))
            {
                viewUtil.createAlert(Alert.AlertType.INFORMATION,"All labels are visible \nTC(3,8) Passed").showAndWait();
            }
            else
            {
                viewUtil.createAlert(Alert.AlertType.ERROR,"All labels are visible\nTC(3,8) Failed").showAndWait();
            }

        }
        else if(cashBills.isSelected())
        {
            JOptionPane.showMessageDialog(null, toBills.getText(), "Cash Payment", JOptionPane.PLAIN_MESSAGE);
        }
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushshowBills(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        b1.setVisible(true);
        b2.setVisible(true);
        b3.setVisible(true);
        b4.setVisible(true);
        b5.setVisible(true);
        b6.setVisible(true);
        a1.setVisible(true);
        a2.setVisible(true);
        a3.setVisible(true);
        a4.setVisible(true);
        a5.setVisible(true);
        a6.setVisible(true);
        pay1.setVisible(true);
        pay2.setVisible(true);
        pay3.setVisible(true);
        pay4.setVisible(true);
        pay5.setVisible(true);
        pay6.setVisible(true);
        if(u.testShowBills(showBills,titleBills,a1,a2,a3,a4,a5,a6,b1,b2,b3,b4,b5,b6,pay1,pay2,pay3,pay4,pay5,pay6))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Test expecting Show Bills actual :="+showBills.getText()+"\nexpecting Bills actual:= "+titleBills.getText()+"\n All labels are visible\nTC(3,1) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Test expecting Show Bills actual :="+showBills.getText()+"\nexpecting Bills actual:= "+titleBills.getText()+"\n All labels are visible\nTC(3,1) Failed").showAndWait();
        }
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushpay1(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        visaCardBills.setVisible(true);
        cashBills.setVisible(true);
        selectedBills.setVisible(true);
        toBills.setText(b1.getText());
        amountBills.setText(a1.getText());
        if(u.testPay(pay1,visaCardBills, cashBills, selectedBills))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Button expecting pay actual:= "+pay1.getText()+"\nradioButton expecting Visa Card actual:= "+visaCardBills.getText()+"\nradioButton expecting Cash actual := "+cashBills.getText()+"\nButton expecting Selected actual := "+selectedBills.getText()+"\nAll labels are visible \nTC(3,2) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Button expecting pay actual:= "+pay1.getText()+"\nradioButton expecting Visa Card actual:= "+visaCardBills.getText()+"\nradioButton expecting Cash actual := "+cashBills.getText()+"\nButton expecting Selected actual := "+selectedBills.getText()+"\nAll labels are visible \nTC(3,2) Failed").showAndWait();
        }
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushpay2(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        visaCardBills.setVisible(true);
        cashBills.setVisible(true);
        selectedBills.setVisible(true);
        toBills.setText(b1.getText());
        amountBills.setText(a1.getText());
        if(u.testPay(pay2,visaCardBills, cashBills, selectedBills))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Button expecting pay actual:= "+pay2.getText()+"\nradioButton expecting Visa Card actual:= "+visaCardBills.getText()+"\nradioButton expecting Cash actual := "+cashBills.getText()+"\nButton expecting Selected actual := "+selectedBills.getText()+"\nAll labels are visible \nTC(3,3) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Button expecting pay actual:= "+pay2.getText()+"\nradioButton expecting Visa Card actual:= "+visaCardBills.getText()+"\nradioButton expecting Cash actual := "+cashBills.getText()+"\nButton expecting Selected actual := "+selectedBills.getText()+"\nAll labels are visible \nTC(3,3) Failed").showAndWait();
        }
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushpay3(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        visaCardBills.setVisible(true);
        cashBills.setVisible(true);
        selectedBills.setVisible(true);
        toBills.setText(b1.getText());
        amountBills.setText(a1.getText());
        if(u.testPay(pay3,visaCardBills, cashBills, selectedBills))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Button expecting pay actual:= "+pay3.getText()+"\nradioButton expecting Visa Card actual:= "+visaCardBills.getText()+"\nradioButton expecting Cash actual := "+cashBills.getText()+"\nButton expecting Selected actual := "+selectedBills.getText()+"\nAll labels are visible \nTC(3,4) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Button expecting pay actual:= "+pay3.getText()+"\nradioButton expecting Visa Card actual:= "+visaCardBills.getText()+"\nradioButton expecting Cash actual := "+cashBills.getText()+"\nButton expecting Selected actual := "+selectedBills.getText()+"\nAll labels are visible \nTC(3,4) Failed").showAndWait();
        }
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushpay4(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        visaCardBills.setVisible(true);
        cashBills.setVisible(true);
        selectedBills.setVisible(true);
        toBills.setText(b1.getText());
        amountBills.setText(a1.getText());
        if(u.testPay(pay4,visaCardBills, cashBills, selectedBills))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Button expecting pay actual:= "+pay4.getText()+"\nradioButton expecting Visa Card actual:= "+visaCardBills.getText()+"\nradioButton expecting Cash actual := "+cashBills.getText()+"\nButton expecting Selected actual := "+selectedBills.getText()+"\nAll labels are visible \nTC(3,5) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Button expecting pay actual:= "+pay4.getText()+"\nradioButton expecting Visa Card actual:= "+visaCardBills.getText()+"\nradioButton expecting Cash actual := "+cashBills.getText()+"\nButton expecting Selected actual := "+selectedBills.getText()+"\nAll labels are visible \nTC(3,5) Failed").showAndWait();
        }
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushpay5(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        visaCardBills.setVisible(true);
        cashBills.setVisible(true);
        selectedBills.setVisible(true);
        toBills.setText(b1.getText());
        amountBills.setText(a1.getText());
        if(u.testPay(pay5,visaCardBills, cashBills, selectedBills))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Button expecting pay actual:= "+pay5.getText()+"\nradioButton expecting Visa Card actual:= "+visaCardBills.getText()+"\nradioButton expecting Cash actual := "+cashBills.getText()+"\nButton expecting Selected actual := "+selectedBills.getText()+"\nAll labels are visible \nTC(3,6) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Button expecting pay actual:= "+pay5.getText()+"\nradioButton expecting Visa Card actual:= "+visaCardBills.getText()+"\nradioButton expecting Cash actual := "+cashBills.getText()+"\nButton expecting Selected actual := "+selectedBills.getText()+"\nAll labels are visible \nTC(3,6) Failed").showAndWait();
        }
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushpay6(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        visaCardBills.setVisible(true);
        cashBills.setVisible(true);
        selectedBills.setVisible(true);
        toBills.setText(b1.getText());
        amountBills.setText(a1.getText());
        if(u.testPay(pay6,visaCardBills, cashBills, selectedBills))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Button expecting pay actual:= "+pay6.getText()+"\nradioButton expecting Visa Card actual:= "+visaCardBills.getText()+"\nradioButton expecting Cash actual := "+cashBills.getText()+"\nButton expecting Selected actual := "+selectedBills.getText()+"\nAll labels are visible \nTC(3,7) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Button expecting pay actual:= "+pay6.getText()+"\nradioButton expecting Visa Card actual:= "+visaCardBills.getText()+"\nradioButton expecting Cash actual := "+cashBills.getText()+"\nButton expecting Selected actual := "+selectedBills.getText()+"\nAll labels are visible \nTC(3,7) Failed").showAndWait();
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

