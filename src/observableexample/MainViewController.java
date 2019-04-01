/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observableexample;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import observableexample.bll.DataObservable;

/**
 *
 * @author pgn
 */
public class MainViewController implements Initializable, Observer
{

    @FXML
    private Label label;

    private DataObservable dobs = new DataObservable();

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        dobs.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg)
    {
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                String updatedString = (String) arg;
                label.setText(updatedString);
            }
        });
    }

}
