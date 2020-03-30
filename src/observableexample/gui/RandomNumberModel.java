package observableexample.gui;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import observableexample.bll.DataObservable;
import observableexample.bll.DataObserver;

public class RandomNumberModel {

    private StringProperty randomTextProperty;
    private DataObservable bllComponent;

    public RandomNumberModel() {
        bllComponent = new DataObservable();
        randomTextProperty = new SimpleStringProperty();
    }

    public ObservableValue<String> getRandomTextProperty() {
        return randomTextProperty;
    }

    public void startObserving() {
        DataObserver observer = new DataObserver() {
            @Override
            public void update() {

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        randomTextProperty.setValue(bllComponent.getState());
                        //Do nothing
                    }

                });

            }
        };
        bllComponent.attatch(observer);
    }

}