package controller;

import db.InMemoryDB;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.Navigation;
import util.Routes;

import java.awt.*;
import java.io.IOException;

public class LoginFormController {
    public Label lblRegisterHere;
    public AnchorPane pneLoginForm;
    public TextField txtNIC;
    public Button btnLogin;

    public void initialize(){
        Platform.runLater(txtNIC::requestFocus);
    }

    public void lblRegisterHere_OnMenuClicked(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.REGISTRATION);
    }

    public void btnLogin_OnAction(ActionEvent actionEvent) throws IOException {

        if(!RegisterFormController.isValidNIC(txtNIC.getText()) || InMemoryDB.findUser(txtNIC.getText())==null){
            new Alert(Alert.AlertType.ERROR,"NIC cannot be empty").showAndWait();
            txtNIC.requestFocus();
            return;
        }else{
            Navigation.navigate(Routes.DASHBOARD);
        }
    }
}
