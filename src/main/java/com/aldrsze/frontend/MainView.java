package com.aldrsze.frontend;

import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.geometry.Pos;

public class MainView extends VBox {
    public MainView(String message) {
        Label label = new Label(message);
        this.getChildren().add(label);
        this.setAlignment(Pos.CENTER);
    }
}