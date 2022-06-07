package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class BuyItem implements Initializable {

    @FXML
    private Button buyCurrenciesBuyItems;
    private userDaoImpl u;

    @FXML
    private TextField amountCertificatesBuyItems;

    @FXML
    private RadioButton dollarBuyItems;

    @FXML
    private RadioButton eurBuyItems;

    @FXML
    private RadioButton rubBuyItems;

    @FXML
    private TextField amountCurrencyBuyItems;

    @FXML
    private Label totalCurrencyBuyItem;

    @FXML
    private Button buyBuyItems;

    @FXML
    private RadioButton account1BuyItems;

    @FXML
    private RadioButton account2BuyItems;

    @FXML
    private Button buyCertificatesBuyItems;

    @FXML
    private RadioButton Certificate18BuyItems;

    @FXML
    private RadioButton certificate20BuyItems;

    @FXML
    private Label pointsAmountBuyItems;

    @FXML
    private Button buyCertificateBuyItem;

    @FXML
    private Button rewardsBuyItems;

    @FXML
    private Label PointsBuyItems;

    @FXML
    private RadioButton points100BuyItems;

    @FXML
    private RadioButton points50BuyItems;

    @FXML
    private RadioButton points30BuyItems;

    @FXML
    private Button RedeemBuyItems;

    @FXML
    private Button BackBuyItem;

    @FXML
    private ImageView photot1BuyItems;

    @FXML
    private ImageView photot2BuyItems;

    @FXML
    private ImageView photot3BuyItems;

    @FXML
    private Label le1;

    @FXML
    private Label le2;

    @FXML
    private Label le3;

    @FXML
    void pushBackBuyItem(MouseEvent event) throws IOException {
        long startTime = System.currentTimeMillis();
        String H = "FirstPage.fxml";
        if(u.testBackBuyItems(BackBuyItem,H))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"expecting Back actual := "+BackBuyItem.getText()+"\nFunction Transfer to scene FirstPage"+H+"\nTC(4,0) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"expecting Back actual := "+BackBuyItem.getText()+"\nFunction Transfer to scene FirstPage"+H+"\nTC(4,0) Failed").showAndWait();
        }
        Main m = new Main();
        m.changeScene(H);
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushBuyCertificateBuyItem(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        certificate20BuyItems.setVisible(true);
        Certificate18BuyItems.setVisible(true);
        amountCertificatesBuyItems.setVisible(true);
        buyCertificateBuyItem.setVisible(true);
        JOptionPane.showMessageDialog(null, "Successfully bought a certificate", "Confirmation", JOptionPane.PLAIN_MESSAGE);
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushRedeemBuyItems(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        int amounfOfPoints = 0;
        if(points100BuyItems.isSelected())
        {
            amounfOfPoints = 100;
        }
        else if(points50BuyItems.isSelected())
        {
            amounfOfPoints = 50;
        }
        else if(points30BuyItems.isSelected())
        {
            amounfOfPoints = 30;
        }
        boolean balance = true;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE flag = '" + 1 + "'");
            if (rs.next()) {
                int points = Integer.valueOf((rs.getString("points")));
                if (points < (amounfOfPoints)) {
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
                stmt.executeUpdate("update client set points = points - '" +amounfOfPoints + "' where flag = '1'");
                JOptionPane.showMessageDialog(null, "you have successfully bought Money", "Confirmation", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE flag = '" + 1 + "'");
                if (rs.next()) {
                    int points = Integer.valueOf((rs.getString("points")));
                    pointsAmountBuyItems.setText(String.valueOf(points));
                }
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushamountCertificatesBuyItems(MouseEvent event) {

    }

    @FXML
    void pushamountCurrencyBuyItems(MouseEvent event) {

    }

    @FXML
    void pushbuyBuyItems(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        int money = Integer.parseInt(amountCurrencyBuyItems.getText());
        int totalAmount = Integer.parseInt(le1.getText());
        if (dollarBuyItems.isSelected()) {
            totalAmount = Integer.parseInt(le1.getText());
            totalCurrencyBuyItem.setText(String.valueOf(money * totalAmount));
        } else if (eurBuyItems.isSelected()) {
            totalAmount = Integer.parseInt(le2.getText());
            totalCurrencyBuyItem.setText(String.valueOf(money * totalAmount));
        } else if (rubBuyItems.isSelected()) {
            totalAmount = Integer.parseInt(le3.getText());
            totalCurrencyBuyItem.setText(String.valueOf(money * totalAmount));
        }
        if (account1BuyItems.isSelected()) {
            boolean balance = true;
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE flag = '" + 1 + "'");
                if (rs.next()) {
                    int amount = Integer.valueOf((rs.getString("amount1")));
                    if (amount < (totalAmount * money)) {
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
                    stmt.executeUpdate("update client set amount1 = amount1 - '" + totalAmount * money+ "' where flag = '1'");
                    JOptionPane.showMessageDialog(null, "you have successfully bought Money", "Confirmation", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        } else if (account2BuyItems.isSelected()) {
            boolean balance = true;
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE flag = '" + 1 + "'");
                if (rs.next()) {
                    int amount = Integer.valueOf((rs.getString("amount2")));
                    if (amount < (totalAmount * money)) {
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
                    stmt.executeUpdate("update client set amount2 = amount2 - '" + totalAmount * money+ "' where flag = '1'");
                    JOptionPane.showMessageDialog(null, "you have successfully bought Money", "Confirmation", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "you have to select any of your accounts to complete process", "Rejection", JOptionPane.PLAIN_MESSAGE);

        }
        if(u.testpushbuyBuyItems(dollarBuyItems,amountCurrencyBuyItems,totalCurrencyBuyItem))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"expecting $ radiobutton isChecked: actual := Checked\ntextField expecting 1 actual: " +amountCurrencyBuyItems.getText()  + "\nLabel expecting 1 * 18 = 18  actual := 18\nTesting function of this button\nTC(4,2) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"expecting $ radiobutton isChecked: actual := Checked\ntextField expecting 1 actual: " +amountCurrencyBuyItems.getText()  + "\nLabel expecting 1 * 18 = 18  actual := 18\nTesting function of this button\nTC(4,2) Failed").showAndWait();
        }
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }
    @FXML
    void pushbuyCertificatesBuyItems(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        certificate20BuyItems.setVisible(true);
        Certificate18BuyItems.setVisible(true);
        buyCertificateBuyItem.setVisible(true);
        amountCertificatesBuyItems.setVisible(true);
        dollarBuyItems.setVisible(false);
        eurBuyItems.setVisible(false);
        rubBuyItems.setVisible(false);
        le1.setVisible(false);
        le2.setVisible(false);
        le3.setVisible(false);
        amountCurrencyBuyItems.setVisible(false);
        totalCurrencyBuyItem.setVisible(false);
        buyBuyItems.setVisible(false);
        points30BuyItems.setVisible(false);
        points50BuyItems.setVisible(false);
        points100BuyItems.setVisible(false);
        PointsBuyItems.setVisible(false);
        pointsAmountBuyItems.setVisible(false);
        RedeemBuyItems.setVisible(false);
        photot1BuyItems.setVisible(false);
        photot2BuyItems.setVisible(false);
        photot3BuyItems.setVisible(false);
        if(u.testpushbuyCertificatesBuyItems(buyCertificateBuyItem, certificate20BuyItems, Certificate18BuyItems,amountCertificatesBuyItems, buyCertificateBuyItem))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Button's text expecting Buy Certificate actual: " +buyCertificateBuyItem.getText()  + "\nTesting function of this button to get certain labels, textfield and buttons visible and test their text\nand other unnecessary items are not visible\nTC(4,3) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Button's text expecting Buy Certificate actual: " +buyCertificateBuyItem.getText()  + "\nTesting function of this button to get certain labels, textfield and buttons visible and test their text\nand other unnecessary items are not visible\nTC(4,3) Failed").showAndWait();
        }
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushbuyCurrenciesBuyItems(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        dollarBuyItems.setVisible(true);
        eurBuyItems.setVisible(true);
        rubBuyItems.setVisible(true);
        le1.setVisible(true);
        le2.setVisible(true);
        le3.setVisible(true);
        amountCurrencyBuyItems.setVisible(true);
        totalCurrencyBuyItem.setVisible(true);
        buyBuyItems.setVisible(true);
        points30BuyItems.setVisible(false);
        points50BuyItems.setVisible(false);
        points100BuyItems.setVisible(false);
        PointsBuyItems.setVisible(false);
        pointsAmountBuyItems.setVisible(false);
        RedeemBuyItems.setVisible(false);
        photot1BuyItems.setVisible(false);
        photot2BuyItems.setVisible(false);
        photot3BuyItems.setVisible(false);
        certificate20BuyItems.setVisible(false);
        Certificate18BuyItems.setVisible(false);
        buyCertificateBuyItem.setVisible(false);
        amountCertificatesBuyItems.setVisible(false);
        if(u.testpushbuyCurrenciesBuyItems(buyCurrenciesBuyItems.getText(),dollarBuyItems, eurBuyItems, rubBuyItems,le1,le2,le3,amountCurrencyBuyItems,totalCurrencyBuyItem,buyBuyItems))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Button's text expecting Buy currencies actual: " +buyCurrenciesBuyItems.getText()  + "\nTesting function of this button to get certain labels, textfield and buttons visible and test their text\nand other unnecessary items are not visible\nTC(4,1) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Button's text expecting Buy currencies actual: " +buyCurrenciesBuyItems.getText()  + "\nTesting function of this button to get certain labels, textfield and buttons visible\nand other unnecessary items are not visible\nTC(4,1) Failed").showAndWait();
        }
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");

    }

    @FXML
    void pushrewardsBuyItems(MouseEvent event) {
        long startTime = System.currentTimeMillis();
        points30BuyItems.setVisible(true);
        points50BuyItems.setVisible(true);
        points100BuyItems.setVisible(true);
        PointsBuyItems.setVisible(true);
        pointsAmountBuyItems.setVisible(true);
        RedeemBuyItems.setVisible(true);
        photot1BuyItems.setVisible(true);
        photot2BuyItems.setVisible(true);
        photot3BuyItems.setVisible(true);
        dollarBuyItems.setVisible(false);
        eurBuyItems.setVisible(false);
        rubBuyItems.setVisible(false);
        le1.setVisible(false);
        le2.setVisible(false);
        le3.setVisible(false);
        amountCurrencyBuyItems.setVisible(false);
        totalCurrencyBuyItem.setVisible(false);
        buyBuyItems.setVisible(false);
        certificate20BuyItems.setVisible(false);
        Certificate18BuyItems.setVisible(false);
        buyCertificateBuyItem.setVisible(false);
        amountCertificatesBuyItems.setVisible(false);

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE flag = '1'");
            if (rs.next()) {
                pointsAmountBuyItems.setText(String.valueOf((rs.getString("points"))));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        if(u.testpushRewardsBuyItems(rewardsBuyItems,points30BuyItems, points50BuyItems, points100BuyItems,photot1BuyItems, photot2BuyItems, photot3BuyItems,PointsBuyItems,pointsAmountBuyItems, RedeemBuyItems))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Button's text expecting Rewards actual: " +rewardsBuyItems.getText()  + "\nTesting function of this button to get certain labels, textfield and buttons visible and test their text\nand other unnecessary items are not visible\nTC(4,4) Passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Button's text expecting Rewards actual: " +rewardsBuyItems.getText()  + "\nTesting function of this button to get certain labels, textfield and buttons visible and test their text\nand other unnecessary items are not visible\nTC(4,4) Failed").showAndWait();
        }
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushtotalCurrencyBuyItem(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        u = new userDaoImpl();
    }
}