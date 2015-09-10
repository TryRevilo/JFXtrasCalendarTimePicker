package com.rev;

import java.util.Calendar;
import java.util.Locale;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jfxtras.scene.control.CalendarPicker;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        System.out.println("javafx.runtime.version: " + System.getProperties().get("javafx.runtime.version"));

        CalendarPicker dateTime = new CalendarPicker();
        dateTime.withCalendar(Calendar.getInstance());
        dateTime.withShowTime(Boolean.TRUE);
        dateTime.withLocale(Locale.ENGLISH);
        dateTime.calendarProperty().addListener(new ChangeListener<Calendar>() {

            @Override
            public void changed(ObservableValue<? extends Calendar> ov, Calendar t, Calendar t1) {
                System.out.println("Selected date: " + t1.getTime().toString());
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(dateTime);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Date & Time from JFXtras 2.2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
