package com.example.gui;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GridSetter {

    public static GridPane setGridColumnsWithSameWidth(GridPane grid, int columnsCount){
        List<ColumnConstraints> columnList = new ArrayList<>(columnsCount);
        for(int i = 0; i < columnsCount; i++){
            columnList.add(new ColumnConstraints());
        }
        for (ColumnConstraints columnConstraints : columnList) {
            columnConstraints.setPercentWidth((double) 100 / columnsCount);
        }
        grid.getColumnConstraints().addAll(columnList);
        return grid;
    }

    public static GridPane setGridRowsWithSameHeight(GridPane grid, int rowsCount){
        List<RowConstraints> rowList = new ArrayList<>(rowsCount);
        for(int i = 0; i < rowsCount; i++){
            rowList.add(new RowConstraints());
        }
        for (RowConstraints rowConstraints : rowList) {
            rowConstraints.setPercentHeight((double) 100 / rowsCount);
        }
        grid.getRowConstraints().addAll(rowList);
        return grid;
    }

}
