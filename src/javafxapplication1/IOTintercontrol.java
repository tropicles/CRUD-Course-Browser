package javafxapplication1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class IOTintercontrol implements Initializable
{

    @FXML
    Button butt_logout2;
    @FXML
    Button itbegin;
    @FXML
    Button itadv2;
    @FXML
    Button it;
    @FXML
    Button web;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        butt_logout2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    DButils.changescene(event, "login.fxml", "Login");
                } catch (IOException ex) {
                    Logger.getLogger(loginhuacontrol.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        itbegin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    DButils.changescene(event, "IOTbegin.fxml", "IOT Beginner");
                } catch (IOException ex) {
                    Logger.getLogger(loginhuacontrol.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        itadv2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    DButils.changescene(event, "IOTadv.fxml", "IOT Advanced");
                } catch (IOException ex) {
                    Logger.getLogger(loginhuacontrol.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        it.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    DButils.changescene(event, "loginhua.fxml", "IT Beginner");
                } catch (IOException ex) {
                    Logger.getLogger(loginhuacontrol.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        web.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    DButils.changescene(event, "webbegin.fxml", "Web Beginner");
                } catch (IOException ex) {
                    Logger.getLogger(loginhuacontrol.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });




    }
}
