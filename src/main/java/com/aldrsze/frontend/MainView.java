package com.aldrsze.frontend;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import java.util.List;

public class MainView extends ScrollPane {
    private VBox container;

    public MainView() {
        container = new VBox(10); // 10px spacing between pages
        container.setAlignment(Pos.CENTER);
        this.setContent(container);
        this.setFitToWidth(true);
    }

    public void displayPages(List<Image> pages) {
        container.getChildren().clear();
        for (Image page : pages) {
            ImageView imageView = new ImageView(page);
            imageView.setPreserveRatio(true);
            // Bind width to ScrollPane width for responsiveness
            imageView.fitWidthProperty().bind(this.widthProperty().subtract(30));
            container.getChildren().add(imageView);
        }
    }
}