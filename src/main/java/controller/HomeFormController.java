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
import util.Navigation;
import util.Routes;

import java.io.IOException;
import java.net.URL;

public class HomeFormController {

    public AnchorPane pneContainer;
    public ImageView imgHome;
    public AnchorPane pneLogin;

    public void initialize() throws IOException {

        Platform.runLater(() ->{
            try {
                Navigation.navigate(Routes.WELCOME);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void imgHome_OnMouseClicked(MouseEvent mouseEvent) throws IOException {
        pneContainer.getChildren().clear();
        initialize();
    }

    public void pneLogin_OnMouseClicked(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.ADMIN_LOGIN);


    }

    public void pneLogin_OnKeyReleased(KeyEvent keyEvent) throws IOException {
        if(keyEvent.getCode()== KeyCode.ENTER || keyEvent.getCode()==KeyCode.SPACE){
            pneLogin_OnMouseClicked(null);
        }
    }
}
