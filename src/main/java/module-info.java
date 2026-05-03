module com.aldrsze {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    // Required for SwingFXUtils (converting PDF pages to FX Images)
    requires javafx.swing;
    requires java.desktop;

    // The PDFBox engine
    requires org.apache.pdfbox;

    exports com.aldrsze;
    exports com.aldrsze.frontend;
    exports com.aldrsze.backend;
}
