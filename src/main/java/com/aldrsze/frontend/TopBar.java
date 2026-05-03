package com.aldrsze.frontend;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.application.Platform;

public class TopBar extends MenuBar {

    public TopBar(Runnable onShowAbout) {
        // 1. File Menu
        Menu fileMenu = new Menu("File");
        MenuItem openItem = new MenuItem("Open PDF...");
        MenuItem exitItem = new MenuItem("Exit");
        
        exitItem.setOnAction(e -> Platform.exit());
        
        fileMenu.getItems().addAll(openItem, new SeparatorMenuItem(), exitItem);

        // 2. View Menu (For Zoom and Navigation features)
        Menu viewMenu = new Menu("View");
        MenuItem zoomIn = new MenuItem("Zoom In");
        MenuItem zoomOut = new MenuItem("Zoom Out");
        
        viewMenu.getItems().addAll(zoomIn, zoomOut);

        // 3. Help Menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutItem = new MenuItem("About Project Delos");

        aboutItem.setOnAction(e -> onShowAbout.run());
        
        helpMenu.getItems().add(aboutItem);

        // Add all menus to the bar
        this.getMenus().addAll(fileMenu, viewMenu, helpMenu);
    }
}