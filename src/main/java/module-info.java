module com.aldrsze {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.aldrsze to javafx.fxml;
    exports com.aldrsze;
}
