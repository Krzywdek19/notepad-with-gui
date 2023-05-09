package com.example.gui;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.controlsfx.control.spreadsheet.Grid;

import java.util.function.UnaryOperator;

public class LoginController {
    UserLoginService service;
    public LoginController(UserLoginService service){
        this.service = service;
    }

    public Scene setScene(){
        GridPane grid = new GridPane();

        Label title = new Label("Tworzenie konta");
        title.setFont(Font.font(25));
        GridPane.setColumnSpan(title, 3);
        GridPane.setHalignment(title, HPos.CENTER);

        Label loginLabel = new Label("Login: ");
        loginLabel.setFont(Font.font(20));
        Label passwordLabel = new Label("Password: ");


        TextField loginInput = new TextField();
        loginInput.setPromptText("Podaj login");
        loginInput.setFont(Font.font(20));
        GridPane.setColumnSpan(loginInput, 2);


        TextField passwordInput = new TextField();
        passwordInput.setPromptText("Podaj hasło");
        passwordInput.setFont(Font.font(20));
        GridPane.setColumnSpan(passwordInput, 2);

        Button button = new Button("Zarejestruj się");
        GridPane.setHalignment(button, HPos.CENTER);
        button.onActionProperty();

        GridSetter.setGridRowsWithSameHeight(GridSetter.setGridColumnsWithSameWidth(grid, 5), 8);

        GridPane.setConstraints(title, 1, 1);
        GridPane.setConstraints(loginLabel, 1,3);
        GridPane.setConstraints(loginInput, 2, 3);
        GridPane.setConstraints(passwordLabel, 1, 4);
        GridPane.setConstraints(passwordInput, 2, 4);
        GridPane.setConstraints(button, 2,6);

        grid.getChildren().addAll(title,loginLabel,loginInput,passwordLabel,passwordInput,button);

        setActionOnButton(button, loginInput, passwordInput, service);

        return new Scene(grid);
    }


    private void setActionOnButton(Button btn, TextField login, TextField pass, UserLoginService service){
        btn.setOnAction(
                e->{
                    service.createAccount(login.getText(), pass.getText());
                    login.clear();
                    pass.clear();
                }
        );
    }
}
