package javafxapplication1;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class controlsignup implements Initializable{
    @FXML
    private Button butt_finish ;
    
    @FXML
    private Button buttbacktologin;
    
    @FXML
    private RadioButton it;
    

     
      @FXML
    private RadioButton web;
      
       @FXML
    private RadioButton iot;

        
         @FXML
    private RadioButton begin;
          @FXML
    private RadioButton inter;
           @FXML
    private RadioButton advanced;
           
           @FXML
           private TextField tf_username;
           
           @FXML
           private TextField tf_password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       ToggleGroup toggleGroup1 = new ToggleGroup();
       ToggleGroup toggleGroup2 = new ToggleGroup();
       it.setToggleGroup(toggleGroup1);

        web.setToggleGroup(toggleGroup1);
        iot.setToggleGroup(toggleGroup1);

        begin.setToggleGroup(toggleGroup2);
         inter.setToggleGroup(toggleGroup2);
          advanced.setToggleGroup(toggleGroup2);
          it.setSelected(true);
          begin.setSelected(true);
          
          butt_finish.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               String togglename1 = ((RadioButton)toggleGroup1.getSelectedToggle()).getText();
               String togglename2 = ((RadioButton)toggleGroup2.getSelectedToggle()).getText();
               if(!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty())
               {
                   try {
                       DButils.signUp(event, tf_username.getText(), tf_password.getText(), togglename1, togglename2);
                   } catch (SQLException ex) {
                       ex.printStackTrace();
                   } catch (IOException ex) {
                       ex.printStackTrace();
                   }
               }
               
               else
               {
                   System.out.println("Please Fill all details");
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setContentText("Please Fill all information to continue");
                   alert.show();
                   
               }
           }
       }
          );
          buttbacktologin.setOnAction(new EventHandler<ActionEvent>()
          {
           @Override
           public void handle(ActionEvent event) {
               try {
                   DButils.changescene(event, "login.fxml", "Login");
               } catch (IOException ex) {
                   ex.printStackTrace();
               }
           }
              
          });
    }

}
