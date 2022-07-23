package controller;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;

public class RegisterFormController {
    public Label txtLoginHere;
    public AnchorPane neRegisterForm;
    public TextField txtNIC;
    public Label lblNicStatus;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtAddress;
    public Button btnRegister;

    private void setDisableCmp(boolean disable){
        txtFirstName.setDisable(disable);
        txtLastName.setDisable(disable);
        txtAddress.setDisable(disable);
        btnRegister.setDisable(disable);
    }

    public void initialize(){
        Platform.runLater(txtNIC::requestFocus);
        txtNIC.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldText, String currentText) {
                setDisableCmp(true);
                if(currentText.isBlank()){
                    lblNicStatus.setText("Please Enter Valid NIC to Proceed");
                    lblNicStatus.setTextFill(Color.BLACK);
                }else{
                    if(isValidNIC(currentText)){
                        setDisableCmp(false);
                        lblNicStatus.setText("Valid NIC ");
                        lblNicStatus.setTextFill(Color.GREEN);
                    }else{
                        lblNicStatus.setText("Invalid NIC ");
                        lblNicStatus.setTextFill(Color.RED);
                    }
                }



            }
        });
    }

    private boolean isValidNIC(String input){
        if (input.length() != 10) return false;
        if(!(input.endsWith("v") || input.endsWith("V"))) return false;
        if(!(input.substring(0,9).matches("\\d+")))return false;
        return true;
    }

    public void txtLoginHere_OnMenuClicked(MouseEvent mouseEvent) throws IOException {
        AnchorPane loginForm = FXMLLoader.load(this.getClass().getResource("/LoginForm.fxml"));
        AnchorPane pneContainer = (AnchorPane) neRegisterForm.getParent();
        pneContainer.getChildren().clear();

        pneContainer.getChildren().add(loginForm);
        AnchorPane.setRightAnchor(loginForm,0.0);
        AnchorPane.setLeftAnchor(loginForm,0.0);
        AnchorPane.setTopAnchor(loginForm,0.0);
        AnchorPane.setBottomAnchor(loginForm,0.0);
    }

}
