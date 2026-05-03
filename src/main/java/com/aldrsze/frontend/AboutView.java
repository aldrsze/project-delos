package com.aldrsze.frontend;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class AboutView extends VBox {

    public AboutView(Runnable onBack) {
        this.setSpacing(15);
        this.setPadding(new Insets(30));
        this.setAlignment(Pos.CENTER);

        // Header Section
        Label title = new Label("Project Delos");
        title.setFont(Font.font("Calibri", FontWeight.BOLD, 28));
        
        Label slogan = new Label("Reading made simple, code made clear.");
        slogan.setFont(Font.font("Calibri", 14));

        // Description Section
        Text description = new Text(
            "A lightweight, open-source PDF reader built entirely with Java. " +
            "Designed to bridge the gap between heavy software and simple viewing needs."
        );
        description.setWrappingWidth(500);
        description.setTextAlignment(TextAlignment.CENTER);

        // Tech Stack Section
        Label techHeader = new Label("Tech Stack");
        techHeader.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
        Label techDetails = new Label("Java 21 • JavaFX • SQLite • Maven");

        // Developer Section
        Label devInfo = new Label("Developer: aldrsze");
        devInfo.setStyle("-fx-font-style: italic;");

        // Back Button
        Button backButton = new Button("Back to Home");
        backButton.setPrefWidth(150);
        backButton.setOnAction(e -> onBack.run());

        // Add all components to this VBox
        this.getChildren().addAll(
            title, slogan, description, 
            new Label("---"), 
            techHeader, techDetails, 
            devInfo, 
            new Label("Distributed under the MIT License"),
            backButton
        );
    }
}