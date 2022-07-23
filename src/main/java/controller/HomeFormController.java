package controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

public class HomeFormController {

    public AnchorPane pneContainer;
    public ImageView imgHome;
    public AnchorPane pneLogin;

    public void initialize() throws IOException {

        AnchorPane welcomeForm = FXMLLoader.load(this.getClass().getResource("/WelcomeForm.fxml"));
        pneContainer.getChildren().add(welcomeForm);
        AnchorPane.setBottomAnchor(welcomeForm,0.0);
        AnchorPane.setTopAnchor(welcomeForm,0.0);
        AnchorPane.setLeftAnchor(welcomeForm,0.0);
        AnchorPane.setRightAnchor(welcomeForm,0.0);
    }

    public void imgHome_OnMouseClicked(MouseEvent mouseEvent) throws IOException {
        pneContainer.getChildren().clear();
        initialize();
    }

    public void pneLogin_OnMouseClicked(MouseEvent mouseEvent) throws IOException {
        pneContainer.getChildren().clear();
        URL resource = this.getClass().getResource("/AdminLoginForm.fxml");
        AnchorPane adminLoginForm = FXMLLoader.load(resource);
        pneContainer.getChildren().add(adminLoginForm);


        AnchorPane.setRightAnchor(adminLoginForm,0.0);
        AnchorPane.setLeftAnchor(adminLoginForm,0.0);
        AnchorPane.setTopAnchor(adminLoginForm,0.0);
        AnchorPane.setBottomAnchor(adminLoginForm,0.0);


    }

    public void pneLogin_OnKeyReleased(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode()== KeyCode.ENTER || keyEvent.getCode()==KeyCode.SPACE){
            pneLogin_OnMouseClicked(null);
        }
    }
}
