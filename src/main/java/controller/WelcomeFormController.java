package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import util.Navigation;
import util.Routes;

import java.io.IOException;
import java.net.URL;

public class WelcomeFormController {
    public Button btnRegister;
    public Button btnLogin;
    public AnchorPane pneWelcome;

    public void btnRegister_OnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.REGISTRATION);

//        Platform.runLater(()->{
//            Window window = pneContainer.getScene().getWindow();
//            Stage s = (Stage) window;
//            s.setHeight(800);
//        });
//        Window window = pneContainer.getScene().getWindow();
//        Stage s = (Stage) window;
//        s.setHeight(800);

    }

    public void btnLogin_OnAction(ActionEvent actionEvent) throws IOException {

        Platform.runLater(()->{
            try {
                Navigation.navigate(Routes.LOGIN);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
