package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstPage implements Initializable {

    @FXML
    private Button buyItems;

    private userDaoImpl u;

    @FXML
    private Button payBilss;


    @FXML
    private Label titleFirstPage;

    @FXML
    private Button transferAccounts;

    @FXML
    private Button seeStatements;

    @FXML
    private Button backFirstPage;

    @FXML
    private Button exitFirstPage;

    @FXML
    void pushbackFirstPage(MouseEvent event) throws IOException {
        long startTime = System.currentTimeMillis();
        String H = "Home.fxml";
        if(u.backFirstPage(backFirstPage.getText(), H, titleFirstPage))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Test Button expecting Back\nactual:= "+backFirstPage.getText()+"Function to transfer to scene Home actual := "+H+"\nLabel expected to Services actual := "+titleFirstPage+"\nTC(2,0) passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Test Button expecting Back\nactual:= "+backFirstPage.getText()+"\nTest passed").showAndWait();
        }
        Main m = new Main();
        m.changeScene(H);
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushbuyItems(MouseEvent event) throws IOException{
        long startTime = System.currentTimeMillis();
        String H = "BuyItem.fxml";
        if(u.buyItemsSignUp(buyItems.getText(),H))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Test Button expecting Buy Items\nactual:= "+buyItems.getText()+"\nFunction to transfer scene to BuyItems actual:= "+H+"\nTC(2,2) passed").showAndWait();

        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Test Button expecting Buy Items\nactual:= "+buyItems.getText()+"\nFunction to transfer scene to BuyItems actual:= "+H+"\nTC(2,2) Failed").showAndWait();
        }
        Main m = new Main();
        m.changeScene(H);
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushexitFirstPage(MouseEvent event){
        long startTime = System.currentTimeMillis();
        System.exit(0);
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushpayBilss(MouseEvent event) throws IOException{
        long startTime = System.currentTimeMillis();
        String H = "Bills.fxml";
        if(u.payBillsFirstPage(payBilss.getText(), H))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Test Button expecting Pay  Bills\nactual:= "+payBilss.getText()+"\nFunction transfer scene to Bills actual := "+H+"\nTC(2,1) passed").showAndWait();
        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Test Button expecting Pay  Bills\nactual:= "+payBilss.getText()+"\nFunction transfer scene to Bills actual := "+H+"\nTC(2,1) Failed").showAndWait();
        }
        Main m = new Main();
        m.changeScene(H);
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushseeStatements(MouseEvent event) throws IOException{
        long startTime = System.currentTimeMillis();
        String H = "Statement.fxml";
        if(u.pushSeeStatements(seeStatements.getText(),H))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Test Button expecting See Statements\nactual:= "+seeStatements.getText()+"\nFunction Transfer scene to Statement actual:= "+H+"\nTC(2,3) passed").showAndWait();

        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Test Button expecting See Statements\nactual:= "+seeStatements.getText()+"\nFunction Transfer scene to Statement actual:= "+H+"\nTC(2,3) Failed").showAndWait();
        }
        Main m = new Main();
        m.changeScene(H);
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @FXML
    void pushtransferAccounts(MouseEvent event)throws IOException {
        long startTime = System.currentTimeMillis();
        String H = "TransferAccounts.fxml";
        if(u.pushTransferAccounts(transferAccounts.getText(),H))
        {
            viewUtil.createAlert(Alert.AlertType.INFORMATION,"Test Button expecting Transfer Accounts nactual:= "+transferAccounts.getText()+"\nTransfer scene to TransferAccounts actual:= "+H+"\nTC(2,4) passed").showAndWait();

        }
        else
        {
            viewUtil.createAlert(Alert.AlertType.ERROR,"Test Button expecting Transfer Accounts nactual:= "+transferAccounts.getText()+"\nTransfer scene to TransferAccounts actual:= "+H+"\nTC(2,4) Failed").showAndWait();
        }
        Main m = new Main();
        m.changeScene(H);
        long stopTime = System.currentTimeMillis();
        long reactionTime = stopTime - startTime;
        System.out.println("Performance of The button" + reactionTime + "ms");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        u = new userDaoImpl();
    }
}
