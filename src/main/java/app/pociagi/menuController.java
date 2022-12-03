package app.pociagi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;
//import javafx.scene.control.Label;

public class menuController implements Initializable {
    RideSingleton ride = RideSingleton.getInstance();
    UserSingleton user = UserSingleton.getInstance();


    @FXML
    private Button logInButton, findConnectionButton;
    public AutoCompleteTextField fromText;

    @FXML
    private TextField fromWhereTextField, ToWhereTextField;

    @FXML
    private Label helloLabel;



    @FXML
    public void logInButtonPushed(ActionEvent event) {
            if(ValidateSingletons.checkUser() == true) {
                user.setUser(null);
                logInButton.setText("LOG IN");
                SceneChanger.changeScene(event, "main_menuv2.fxml");
            } else {
                SceneChanger.changeScene(event, "login_menu.fxml");
            }
    }
    @FXML
    public void findConnectionButtonPushed(ActionEvent event)
    {
        ride.setRide(new Ride(fromWhereTextField.getText().toString(), ToWhereTextField.getText().toString()));
        SceneChanger.changeScene(event,"available_rides.fxml" );

    }
    public void onKeyTyped(KeyEvent event) {
        DatabaseHandler handler = DatabaseHandler.getInstance();
        String sql = "SELECT * FROM STATIONS";
        ResultSet rs = handler.executeQuery(sql);
        ArrayList<String> arr = handler.returnDataArray(rs, 2);
        AutoCompleteTextField field = (AutoCompleteTextField) event.getSource();
        field.getEntries().addAll(arr);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(ValidateSingletons.checkUser() == false) {
            helloLabel.setText("Hello, unknown!");
            logInButton.setText("LOG IN");
        } else {
            helloLabel.setText(String.format("Hello, %s", user.getUser().getName().toString()));
            logInButton.setText("LOG OUT");
        }
    }
}