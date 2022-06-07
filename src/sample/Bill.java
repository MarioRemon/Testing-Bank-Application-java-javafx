package sample;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.lang.constant.ConstantDescs.NULL;

public class Bill
{
    String ToBill;
    int  amountToBePaid;
    Account a;
    public Bill(String AccountName, String ToBill, int amountToBePaid)
    {
        a = new Account(AccountName);
        this.ToBill = ToBill;
        this.amountToBePaid = amountToBePaid;
        }
    public String showBills()
    {
           return("The Bill to " +this.ToBill + " and amount to be paid is "+ this.amountToBePaid);
    }
    public String getToBill() {
        return ToBill;
    }

    public void setToBill(String toBill) {
        ToBill = toBill;
    }

    public int getAmountToBePaid() {
        return amountToBePaid;
    }
    public int increaseAmountToBePaid(int amount)
    {
        return(this.amountToBePaid + amount);
    }

    public void setAmountToBePaid(int amountToBePaid) {
        this.amountToBePaid = amountToBePaid;
    }
    public boolean pay(Account a, int price)
    {
        if(price <= a.amount)
        {
            this.amountToBePaid -= price;
            this.a.amount += price;
            a.amount -= price;
            return true;
        }
        else if(price >= this.amountToBePaid && price <= a.amount)
        {
            this.amountToBePaid = 0;
            this.a.amount += this.amountToBePaid;
            a.amount -= this.amountToBePaid;
        }
        return false;
    }
    public Account getA() {
        return a;
    }

    public void setA(Account a) {
        this.a = a;
    }
}
//    boolean found1 = false;
//    boolean found2 = false;
//        try {
//                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
//                java.sql.Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE account1 = '" + a.Name + "'");
//                if (rs.next()) {
//                found1 = true;
//                }
//                } catch (Exception ex) {
//                }
//                try {
//                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
//                java.sql.Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE account2 = '" + a.Name + "'");
//                if (rs.next()) {
//                found2 = true;
//                }
//                } catch (Exception ex) {
//                }
//                if (found1) {
//                boolean balance = true;
//                try {
//                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
//                java.sql.Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE flag = '" + 1 + "'");
//                if (rs.next()) {
//                if (a.amount < this.amountToBePaid) {
//        balance = false;
//        }
//        }
//        } catch (Exception ex) {
//        JOptionPane.showMessageDialog(null, ex.getMessage());
//        }
//        if (balance) {
//        try {
//
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
//        java.sql.Statement stmt = con.createStatement();
//        stmt.executeUpdate("update client set amount1 = amount1 - '" +b.amountToBePaid+ "' where flag = '1'");
//        } catch (Exception ex) {
//
//        }
//        }
//        } else if (found2) {
//        boolean balance = true;
//        try {
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
//        java.sql.Statement stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery("SELECT * FROM client WHERE flag = '" + 1 + "'");
//        if (rs.next()) {
//        if (a.amount < this.amountToBePaid) {
//        balance = false;
//        }
//        }
//        } catch (Exception ex) {
//        ;
//        }
//        if (balance) {
//        try {
//
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "123456");
//        Statement stmt = con.createStatement();
//        stmt.executeUpdate("update client set amount2 = amount2 - '" + this.amountToBePaid + "' where flag = '1'");
//        } catch (Exception ex) {
//        ;
//        }
//        }
//        }
