package com.example.gui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class NotebookController {
    private UserLoginService service;

    public NotebookController(UserLoginService service){
        this.service = service;
    }
    public Scene setScene(){
        System.out.println("dziala");
        GridPane grid = new GridPane();
        GridSetter.setGridRowsWithSameHeight(grid, 10);
        GridSetter.setGridColumnsWithSameWidth(grid, 10);

        Label heading = new Label("Witaj " + service.getUsername());
        heading.setFont(Font.font(18));

        GridPane.setConstraints(heading, 0, 0);
        GridPane.setColumnSpan(heading,3);

        grid.getChildren().addAll(heading);

        return new Scene(grid);
    }
}
