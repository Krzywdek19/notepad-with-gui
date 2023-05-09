package com.example.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.controlsfx.control.spreadsheet.Grid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HelloApplication extends Application {
    Stage primaryStage;
    int width = 500;
    int height = 450;

    UserLoginService service = new UserLoginService();
    LoginController loginController = new LoginController(service);

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        primaryStage.setTitle("Students");
        primaryStage.setMinHeight(height);
        primaryStage.setMinWidth(width);
        primaryStage.setMaxHeight(height);
        primaryStage.setMaxWidth(width);
        primaryStage.setScene(loginController.setScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}