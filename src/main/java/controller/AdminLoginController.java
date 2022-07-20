package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;

import javax.print.attribute.standard.Media;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

public class AdminLoginController {

    private static int attempts = 3;
    public PasswordField txtPassword;
    private static final String ADMIN_PASSWORD = "dep9@ADMIN";
    public AnchorPane pneAdminLoginForm;

    public void initialize(){
        Platform.runLater(txtPassword::requestFocus);
    }

    public void txtPassword_OnAction(ActionEvent actionEvent) throws IOException, URISyntaxException {

        if(!txtPassword.getText().equals(ADMIN_PASSWORD)){
            if(attempts==0){
                new Alert(Alert.AlertType.ERROR, "You have Reached Maximum attempts").showAndWait();
                Platform.exit();
                return;
            }


            URL resource1 = this.getClass().getResource("/mp3/Security-breach.mp3");
            /*Media media = new Media(resource1.toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();*/


            Alert alert = new Alert(Alert.AlertType.ERROR, "Password is Incorrect. Attempts Remaining :"+attempts);
            attempts--;

            InputStream resource = this.getClass().getResourceAsStream("/image/Lock.png");
            Image image = new Image(resource);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(48);
            imageView.setFitHeight(48);
            alert.setGraphic(imageView);
            alert.setHeaderText("Invalid Login Credentials");
            alert.setTitle("Access Denied");
            alert.showAndWait();
            /*mediaPlayer.dispose();*/
            txtPassword.clear();
            return;
        }
        AnchorPane controlCenter = FXMLLoader.load(this.getClass().getResource("/ControlCenterForm.fxml"));
        AnchorPane pneContainer = (AnchorPane) pneAdminLoginForm.getParent();
        pneContainer.getChildren().clear();
        pneContainer.getChildren().add(controlCenter);
        AnchorPane.setBottomAnchor(controlCenter,0.0);
        AnchorPane.setTopAnchor(controlCenter,0.0);
        AnchorPane.setRightAnchor(controlCenter,0.0);
        AnchorPane.setLeftAnchor(controlCenter,0.0);
    }
}
