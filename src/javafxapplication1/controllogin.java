package javafxapplication1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class controllogin implements Initializable{
    @FXML
    private Button butt_signup;
    
  @FXML
 private Button butt_login;
 @FXML
 private TextField tf_username ;
 @FXML
 private TextField tf_password ;

    public controllogin() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        butt_login.setOnAction((ActionEvent event) -> {
            try {
                DButils.logInUser(event, tf_username.getText(),tf_password.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
        butt_signup.setOnAction((ActionEvent event) -> {
            try {
                DButils.changescene(event, "signup.fxml", "signup");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    
    
}
