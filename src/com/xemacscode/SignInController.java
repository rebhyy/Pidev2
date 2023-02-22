package com.xemacscode;

import entite.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import service.UserManagement;
import utils.DataSource;

public class SignInController implements Initializable {

    @FXML
    private TextField emailField;

    @FXML
    private TextField pswField;

    @FXML
    private Button signinBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void signIn() {
        String email = emailField.getText();
        String password = pswField.getText();
        
         if (email.isEmpty() || password.isEmpty()) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Missing credentials");
        alert.setContentText("Please enter both email and password.");
        alert.showAndWait();
        return;
    }

        Connection conn = DataSource.getInstance().getCnx();
        UserManagement userManager = new UserManagement(conn);
        User user = null;   

        try {
            user = userManager.getUserByEmailAndPassword(email, password);
        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText("There was a problem accessing the database. Please try again later.");
            alert.showAndWait();
            return;
        }

        if (user == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid credentials");
            alert.setContentText("The email or password is incorrect.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Welcome");
            alert.setHeaderText("Welcome " + user.getFirstName() + " " + user.getLastName() + "!");
            alert.setContentText("You have successfully logged in.");
            alert.showAndWait();
        }
    }
}
