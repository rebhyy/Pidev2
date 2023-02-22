
package com.xemacscode;

import entite.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.ServicePersonne;


public class Launcher extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));        
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    public static void main(String[] args) {
               
        launch(args);
        User newUser = new User("John", "rebhi", 123456789, "johndofde@example.com", "admin", "password123");
ServicePersonne service = new ServicePersonne();
service.insertPst(newUser);
    }
    
}
