package javafxapplication1;


import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class IOTadvcontrol implements Initializable
{
    @FXML
    Button butt_logout2;
    @FXML
    Button itbegin;
    @FXML
    Button itinter;
    @FXML
    Button it;
    @FXML
    Button web;


    @FXML
    ImageView courseimg;
    @FXML
     Hyperlink courseurl;
    @FXML
      Label coursename;
    @FXML
     Label type;

    @FXML
    ImageView courseimg1;
    @FXML
    Hyperlink courseurl1;
    @FXML
    Label coursename1;
    @FXML
    Label type1;






    static String name1;
    static String corurl1;
    static String paid1;

    static String name2,name3,name4,name5,name6;
    static String corurl2,corurl3,corurl4,corurl5,corurl6;
    static String paid2,paid3,paid4,paid6;

    public void course1()
    {

        name1 = DButils.coursedataname(1, "iot_adv");
        corurl1 = DButils.coursedataurl(1, "iot_adv");
        paid1 = DButils.coursedatatype(1, "iot_adv");

        coursename.setText(name1);
        type.setText(paid1);
        courseurl.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Desktop.getDesktop().browse(new URI(corurl1));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void course2()
    {

        name2 = DButils.coursedataname(2, "iot_adv");
        corurl2 = DButils.coursedataurl(2, "iot_adv");
        paid2 = DButils.coursedatatype(2, "iot_adv");

        coursename1.setText(name2);
        type1.setText(paid2);
        courseurl1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    Desktop.getDesktop().browse(new URI(corurl2));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }













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

        course1();
        course2();




























    }

}
