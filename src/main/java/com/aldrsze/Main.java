package com.aldrsze;

import com.aldrsze.frontend.TopBar;
import com.aldrsze.frontend.MainView;

import java.io.File;
import java.util.List;

import com.aldrsze.backend.PdfService;
import com.aldrsze.frontend.AboutView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private BorderPane root;

    @Override
    public void start(Stage stage) {
        root = new BorderPane();

        // Pass the 'showAbout' method as a reference to the menu
        TopBar menuBar = new TopBar(this::showAbout, this::openFile);
        root.setTop(menuBar);

        // Set initial content
        showMainContent();

        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Project Delos");
        stage.setScene(scene);
        stage.show();
    }

    private MainView mainView;
    private PdfService pdfService = new PdfService();

    private void showMainContent() {
        mainView = new MainView();
        root.setCenter(mainView);
    }

    public void openFile(File file) {
        if (file != null) {
            try {
                List<Image> pages = pdfService.loadPdfPages(file);
                mainView.displayPages(pages);
            } catch (Exception e) {
                e.printStackTrace(); // In a real app, show an Alert dialog here
            }
        }
    }

    private void showAbout() {
        // Pass the 'showMainContent' method to the AboutView back button
        root.setCenter(new AboutView(this::showMainContent));
    }

    public static void main(String[] args) {
        launch();
    }
}