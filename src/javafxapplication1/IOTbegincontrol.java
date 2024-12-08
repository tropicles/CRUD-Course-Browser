
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


public class IOTbegincontrol implements Initializable {


    @FXML
    Button butt_logout;

    @FXML
    Button itinter;

    @FXML
    Button itadv;
    @FXML
    Button it;
    @FXML
    Button web;


    static String name1;
    static String corurl1;
    static String paid1;
    public static void data(String name, String corurl, String paid)
    {
        name1=name;
        corurl1=corurl;
        paid1=paid;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        butt_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    DButils.changescene(event, "login.fxml", "Login");
                } catch (IOException ex) {
                    Logger.getLogger(loginhuacontrol.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        itinter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    DButils.changescene(event, "IOTinter.fxml", "IOT Intermediate");
                } catch (IOException ex) {
                    Logger.getLogger(loginhuacontrol.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        itadv.setOnAction(new EventHandler<ActionEvent>() {
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
