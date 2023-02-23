package com.xemacscode;

import entite.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import service.LoggedInUser;

public class LoggedInController implements Initializable {

    @FXML
     Label fnamelabel1;

    @FXML
     Label lnamelabel;

    private User user;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user = LoggedInUser.getInstance().getUser();
        fnamelabel1.setText(user.getFirstName());
        lnamelabel.setText(user.getLastName());
    }

            void setUser(User user) {
        this.user = user;    }

    
}
