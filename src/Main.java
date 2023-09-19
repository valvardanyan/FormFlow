import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            PDDocument document1 = PDDocument.load(new File("IncompleteFiles/Blank.pdf"));
            PDPageTree pages1 = document1.getPages();

            PDPage page1 = pages1.get(0);
            PDType0Font font = PDType0Font.load(document1, new File("libraries/Roboto-Regular.ttf"));
            PDPageContentStream contentStream1 = new PDPageContentStream(document1, page1);
            contentStream1.setFont(font, 12);
            contentStream1.beginText();
            contentStream1.newLineAtOffset(50, page1.getMediaBox().getHeight() - 50);
            contentStream1.showText("Hello World");
            contentStream1.endText();
            contentStream1.close();

            document1.save(new File("CompletedFiles/WrittenOn.pdf"));
            document1.close();

            System.out.println("Printed on PDF");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}