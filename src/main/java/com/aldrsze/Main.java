package com.aldrsze;

import com.aldrsze.frontend.TopBar;
import com.aldrsze.frontend.MainView;
import com.aldrsze.frontend.AboutView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private BorderPane root;

    @Override
    public void start(Stage stage) {
        root = new BorderPane();

        // Pass the 'showAbout' method as a reference to the menu
        TopBar menuBar = new TopBar(this::showAbout);
        root.setTop(menuBar);

        // Set initial content
        showMainContent();

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Project Delos");
        stage.setScene(scene);
        stage.show();
    }

    private void showMainContent() {
        root.setCenter(new MainView("PDF Reader Content Goes Here"));
    }

    private void showAbout() {
        // Pass the 'showMainContent' method to the AboutView back button
        root.setCenter(new AboutView(this::showMainContent));
    }

    public static void main(String[] args) {
        launch();
    }
}