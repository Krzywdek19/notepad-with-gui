package com.example.gui;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class LoginController {
    UserLoginService service;

    Stage stage;
    public LoginController(UserLoginService service, Stage stage){
        this.stage = stage;
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


        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Podaj hasło");
        passwordInput.setFont(Font.font(20));
        GridPane.setColumnSpan(passwordInput, 2);

        Hyperlink hyperLink = new Hyperlink("Mam już konto");

        Button button = new Button("Zarejestruj się");
        GridPane.setHalignment(button, HPos.CENTER);

        setActionOnButton(button, loginInput, passwordInput, service);
        setActionOnHyperlink(hyperLink, title, button);

        GridSetter.setGridRowsWithSameHeight(GridSetter.setGridColumnsWithSameWidth(grid, 5), 8);

        GridPane.setConstraints(title, 1, 1);
        GridPane.setConstraints(loginLabel, 1,3);
        GridPane.setConstraints(loginInput, 2, 3);
        GridPane.setConstraints(passwordLabel, 1, 4);
        GridPane.setConstraints(passwordInput, 2, 4);
        GridPane.setConstraints(hyperLink,2,5 );
        GridPane.setConstraints(button, 2,6);

        grid.getChildren().addAll(title,loginLabel,loginInput,passwordLabel,passwordInput,button, hyperLink);


        return new Scene(grid);
    }


    private void setActionOnButton(Button btn, TextField login, TextField pass, UserLoginService service){
        btn.setOnAction(
                e->{
                    if(service.handleAuthorization(login.getText(), pass.getText())){
                        this.stage.setWidth(700);
                        this.stage.setHeight(500);
                        this.stage.setScene(new NotebookController(this.service).setScene());
                    }
                    btn.getParent().requestLayout();
                    login.clear();
                    pass.clear();
                }
        );
    }

    private void setActionOnHyperlink(Hyperlink hyperlink, Label heading, Button button){
        hyperlink.setOnAction(
                e->{
                    if(this.service.isRegistrationScene()){
                        heading.setText("Logowanie");
                        hyperlink.setText("Nie mam konta");
                        button.setText("Zaloguj się");
                    }else {
                        heading.setText("Rejestracja");
                        hyperlink.setText("Mam już konto");
                        button.setText("Zarejestruj się");
                    }
                    this.service.setRegistrationScene(!this.service.isRegistrationScene());
                    hyperlink.getParent().requestLayout();
                }
        );
    }
}
