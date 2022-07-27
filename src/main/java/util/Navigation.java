package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class Navigation {
    private static AnchorPane pneContainer;

    public static void init(AnchorPane pneContainer){
        Navigation.pneContainer=pneContainer;
    }

    public static void navigate(Routes routes) throws IOException {
        pneContainer.getChildren().clear();
        URL resource;
        switch (routes){
            case WELCOME:
                resource = Navigation.class.getResource("/WelcomeForm.fxml");
                break;
            case LOGIN:
                resource = Navigation.class.getResource("/LoginForm.fxml");
                break;
            case REGISTRATION:
                resource = Navigation.class.getResource("/RegisterForm.fxml");
                break;
            case ADMIN_LOGIN:
                resource = Navigation.class.getResource("/AdminLoginForm.fxml");
                break;
            case DASHBOARD:
                resource = Navigation.class.getResource("/UserDashBoard.fxml");
                break;
            default:
                resource = Navigation.class.getResource("/ControlCenterForm.fxml");
        }
        Parent container = FXMLLoader.load(resource);
        pneContainer.getChildren().add(container);
        AnchorPane.setBottomAnchor(container,0.0);
        AnchorPane.setTopAnchor(container,0.0);
        AnchorPane.setLeftAnchor(container,0.0);
        AnchorPane.setRightAnchor(container,0.0);
    }
}
