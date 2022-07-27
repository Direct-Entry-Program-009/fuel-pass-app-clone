package controller;

import db.InMemoryDB;
import db.User;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
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

    public static boolean isValidNIC(String input){
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
    public boolean isName(String input){
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            if((!Character.isLetter(aChar)) && (aChar!=' '))return false;
        }
        return true;
    }

    public void btnRegister_OnAction(ActionEvent actionEvent) throws IOException {
        //validate FirstName
        if(txtFirstName.getText().isBlank()){
            new Alert(Alert.AlertType.ERROR,"First Name Field is Empty").showAndWait();
            txtFirstName.requestFocus();
            return;
        }
        if(!isName(txtFirstName.getText())){
            new Alert(Alert.AlertType.ERROR,"First Name is Invalid").showAndWait();
            txtFirstName.requestFocus();
            return;
        }
        if(!isName(txtLastName.getText())){
            new Alert(Alert.AlertType.ERROR,"Last Name is Invalid").showAndWait();
            txtLastName.requestFocus();
            return;
        }


        //Validate Address
        if(txtAddress.getText().trim().length()<3){
            new Alert(Alert.AlertType.ERROR,"Address Field is Empty").showAndWait();
            txtAddress.requestFocus();
            return;
        }
        String lastName;
        if(txtLastName.getText().isBlank()){
            lastName="";
        }else{
            lastName=txtAddress.getText();
        }

        User user = new User(txtNIC.getText(),txtFirstName.getText(),lastName,txtAddress.getText());

        boolean result = InMemoryDB.registerUser(user);
        if(result){
            new Alert(Alert.AlertType.INFORMATION,"You have Successfully Registered..\nYou are redirected to Login form").showAndWait();
            txtLoginHere_OnMenuClicked(null);
        }else{
            new Alert(Alert.AlertType.ERROR,"NIC is already Registered, Please check the NIC again").showAndWait();
            txtNIC.requestFocus();
        }
    }
}
