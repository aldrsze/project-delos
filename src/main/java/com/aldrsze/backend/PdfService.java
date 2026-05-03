package com.aldrsze.backend;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PdfService {
    
    public List<Image> loadPdfPages(File file) throws IOException {
        List<Image> images = new ArrayList<>();
        try (PDDocument document = Loader.loadPDF(file)) {
            PDFRenderer renderer = new PDFRenderer(document);
            for (int i = 0; i < document.getNumberOfPages(); i++) {
                // Render page at 150 DPI for decent clarity
                BufferedImage bImage = renderer.renderImageWithDPI(i, 150);
                images.add(SwingFXUtils.toFXImage(bImage, null));
            }
        }
        return images;
    }
}