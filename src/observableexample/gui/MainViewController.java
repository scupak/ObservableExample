/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observableexample.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * @author pgn
 */
public class MainViewController implements Initializable {

    @FXML
    private Label label;

    private RandomNumberModel model;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new RandomNumberModel();
        label.textProperty().bind(model.getRandomTextProperty());
    }

    public void handleButtonAction(ActionEvent actionEvent) {
        model.startObserving();
    }
}
