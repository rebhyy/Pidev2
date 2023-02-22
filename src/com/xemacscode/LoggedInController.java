/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemacscode;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Rebhy
 */
public class LoggedInController implements Initializable {
    
    @FXML
    private Button btn_logout;
    
    @FXML 
    private Label welcomeLab;

    public void initialize(URL url, ResourceBundle rb) {
        
                } 
    
    public void setUserInformation(String nom, String role) {
        welcomeLab.setText("Welcome " + nom + "!");
    }
    
}
