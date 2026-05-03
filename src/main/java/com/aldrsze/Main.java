package com.aldrsze;

import com.aldrsze.frontend.MainView; // Import from frontend folder
import com.aldrsze.backend.PdfService;  // Import from backend folder
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        // 1. Get data from the backend
        PdfService backend = new PdfService();
        String info = backend.getDocumentInfo();

        // 2. Pass that data to the frontend
        MainView ui = new MainView(info);

        Scene scene = new Scene(ui, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Project Delos");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}