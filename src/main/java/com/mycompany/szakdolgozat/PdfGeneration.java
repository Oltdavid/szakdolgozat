package com.mycompany.szakdolgozat;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javafx.collections.ObservableList;

public class PdfGeneration {

    public void pdfGeneration(String fileName, ObservableList<Person> data) {
        Document document = new Document();

        try {
            //Céges logó
            PdfWriter.getInstance(document, new FileOutputStream(fileName + ".pdf"));
            document.open();
            Image image1 = Image.getInstance(getClass().getResource("/logo.jpg"));
            image1.scaleToFit(400, 172);
            image1.setAbsolutePosition(170f, 650f);
            document.add(image1);

            //Sortörések
            document.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n\n\n\n"));

            //Táblázat
            float[] columnWidths = {4, 4, 4, 4, 4, 4, 4, 4};
            PdfPTable table = new PdfPTable(columnWidths);
            table.setWidthPercentage(100);
            PdfPCell cell = new PdfPCell(new Phrase("Sportolók"));
            cell.setBackgroundColor(GrayColor.GRAYWHITE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(9);
            table.addCell(cell);

            table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            //table.addCell("Szám");
            table.addCell("Vezetéknév");
            table.addCell("Keresztnév");
            table.addCell("E-mail cím");
            table.addCell("Anyja neve");
            table.addCell("Lakcím");
            table.addCell("TAJ");
            table.addCell("Születési idő");
            table.addCell("Telefon");
            table.setHeaderRows(1);

            table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

            for (int i = 1; i <= data.size(); i++) {
                Person actualPerson = data.get(i - 1);

                //table.addCell(""+i);
                table.addCell(actualPerson.getLastName());
                table.addCell(actualPerson.getFirstName());
                table.addCell(actualPerson.getEmail());
                table.addCell(actualPerson.getAnyjaNeve());
                table.addCell(actualPerson.getLakcim());
                table.addCell(actualPerson.getTajszam());
                table.addCell(actualPerson.getSzido());
                table.addCell(actualPerson.getTelefon());
            }

            document.add(table);

        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
    }

}
