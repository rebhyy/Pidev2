/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemacscode;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rebhy
 */
public class SignInController implements Initializable {

    @FXML
    private TextField emailField;
    @FXML
    private TextField pswField;
    @FXML
    private Button Signin_btn;
    
    public void textfield(MouseEvent event) {
        if (event.getSource() == emailField     ) {
            emailField.setStyle("-fx-background-color:#fff"
                    + "-fx-border-width:3px;");
            pswField.setStyle("-fx-background-color:#eef3ff"
                    + "-fx-border-width:1px;");
            
        }        else if (event.getSource() == pswField     ) {
            emailField.setStyle("-fx-background-color:#eef3ff"
                    + "-fx-border-width:1px;");
            pswField.setStyle("-fx-background-color:#fff"
                    + "-fx-border-width:3px;");
            
        }
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO
    }


    
}
