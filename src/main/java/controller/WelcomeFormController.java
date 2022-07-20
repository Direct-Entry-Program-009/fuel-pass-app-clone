package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class WelcomeFormController {
    public Button btnRegister;
    public Button btnLogin;
    public AnchorPane pneWelcome;

    public void btnRegister_OnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/RegisterForm.fxml");
        AnchorPane registerForm = FXMLLoader.load(resource);
        AnchorPane pneContainer = (AnchorPane) pneWelcome.getParent();
        pneContainer.getChildren().clear();
        pneContainer.getChildren().add(registerForm);
        AnchorPane.setBottomAnchor(registerForm,0.0);
        AnchorPane.setTopAnchor(registerForm,0.0);
        AnchorPane.setLeftAnchor(registerForm,0.0);
        AnchorPane.setRightAnchor(registerForm,0.0);

    }

    public void btnLogin_OnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane loginForm = FXMLLoader.load(this.getClass().getResource("/LoginForm.fxml"));
        AnchorPane pneContainer = (AnchorPane) pneWelcome.getParent();
        pneContainer.getChildren().clear();
        pneContainer.getChildren().add(loginForm);
        AnchorPane.setBottomAnchor(loginForm,0.0);
        AnchorPane.setTopAnchor(loginForm,0.0);
        AnchorPane.setLeftAnchor(loginForm,0.0);
        AnchorPane.setRightAnchor(loginForm,0.0);
    }
}
