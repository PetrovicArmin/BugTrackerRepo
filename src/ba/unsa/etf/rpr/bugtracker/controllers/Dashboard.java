package ba.unsa.etf.rpr.bugtracker.controllers;

import ba.unsa.etf.rpr.bugtracker.common.database.Database;
import ba.unsa.etf.rpr.bugtracker.common.other.Showable;
import ba.unsa.etf.rpr.bugtracker.models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard extends AbstractController implements Showable, Initializable {
    private User currentUser;
    public Label testLabel;
    private ResourceBundle resourceBundle;
    private Database database;

    public Dashboard(User currentUser) {
        database = Database.getInstance();
        this.setCurrentUser(currentUser);
    }

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        testLabel.setText("Hello, " + currentUser);
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void onProfile(ActionEvent actionEvent) {
        Stage stage = new Stage();
        Profile controller = new Profile(currentUser);
        showStage(stage, "/views/profile.fxml", "app.profile.title", 400, 500, controller);
    }

    public void onLogout(ActionEvent actionEvent) {
        ((Stage)testLabel.getScene().getWindow()).close();
    }
}
