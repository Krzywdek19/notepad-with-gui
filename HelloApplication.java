package com.example.gui;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    Stage primaryStage;
    int width = 500;
    int height = 450;

    UserLoginService service = new UserLoginService();

    NotebookController notebookController = new NotebookController(service);

    @Override
    public void start(Stage stage) throws IOException {

        this.primaryStage = stage;
        LoginController loginController = new LoginController(service, primaryStage);
        primaryStage.setTitle("Students");
        primaryStage.setMinHeight(height);
        primaryStage.setMinWidth(width);
        primaryStage.setMaxHeight(height);
        primaryStage.setMaxWidth(width);
        primaryStage.setResizable(false);
        primaryStage.setScene(loginController.setScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}