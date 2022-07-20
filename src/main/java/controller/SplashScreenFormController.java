package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class SplashScreenFormController {
    public Label lblLoad;
    public Rectangle pgbContainer;
    public Rectangle pgbBlock;

    public void initialize(){
        Timeline t = new Timeline();
        KeyFrame keyFrame1 = new KeyFrame(Duration.millis(250), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoad.setText("Connecting with DB..");
                pgbBlock.setWidth(pgbBlock.getWidth() + 30);
            }
        });
        KeyFrame keyFrame2 = new KeyFrame(Duration.millis(750), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoad.setText("Loading Data..");
                pgbBlock.setWidth(pgbBlock.getWidth() + 30);
            }
        });
        KeyFrame keyFrame3 = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoad.setText("Setting Up UI..");
                pgbBlock.setWidth(pgbContainer.getWidth());
            }
        });
        KeyFrame keyFrame4 = new KeyFrame(Duration.millis(1250), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Parent load = FXMLLoader.load(this.getClass().getResource("/HomeForm.fxml"));
                    Scene scene = new Scene(load);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    stage.setTitle("National Fuel Pass");
                    stage.show();
                    lblLoad.getScene().getWindow().hide();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.getKeyFrames().addAll(keyFrame1,keyFrame2,keyFrame3,keyFrame4);
        t.playFromStart();

    }
}
