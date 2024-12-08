
package javafxapplication1;

import java.util.Objects;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class control extends Application {
   
    
    @Override
    public void start(Stage primarystage) throws Exception  {
        Parent root;
        root = FXMLLoader.load(Objects.requireNonNull(Objects.requireNonNull(getClass().getResource("login.fxml"))));
        primarystage.setTitle("Login");
        primarystage.setScene(new Scene(root , 800,600));
        primarystage.show();
        
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
