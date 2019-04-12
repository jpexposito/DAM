package es.formacion.cip.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import es.formacion.cip.model.entity.Tarea;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class CreatePdf {
    Document document = null;

    public void crearDocumento() {

        try {
            document = new Document();
            PdfWriter pdfWriter = PdfWriter.getInstance(document,
                    new FileOutputStream("HelloWorld.pdf"));
            document.open();
            Paragraph paragraph = new Paragraph();
            paragraph.add("Hello World Jacobo y Jorge!");
            document.add(paragraph);

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }

    }

    public void crearDocumento(String tituloStr, String nombreArchivo, List<Tarea> listaTareas ) {

        try {
            document = new Document();
            PdfWriter pdfWriter = PdfWriter.getInstance(document,
                    new FileOutputStream(nombreArchivo+".pdf"));
            document.open();
            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            titulo.setFont(FontFactory.getFont("Times New Roman", 24, Font.BOLD, BaseColor.BLACK));
            titulo.add(tituloStr);
            document.add(titulo);
            int numColumns = 2;
            PdfPTable table = new PdfPTable(numColumns);
            // Now we fill the PDF table
            // Ahora llenamos la tabla del PDF
            PdfPCell columnId;
            columnId = new PdfPCell(new Phrase("ID "));
            PdfPCell columnNombre;
            columnNombre = new PdfPCell(new Phrase("NOMBRE "));
            table.addCell(columnId);
            table.addCell(columnNombre);

            for (int i = 0; i < listaTareas.size(); i++) {
                Tarea tarea = listaTareas.get(i);
                PdfPCell cellID;
                cellID = new PdfPCell(new Phrase(tarea.getId()));
                cellID.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cellID);
                PdfPCell cellNombre;
                cellNombre = new PdfPCell(new Phrase(tarea.getNombre()));
                cellNombre.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cellNombre);

            }

            document.add(table);

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }

    }

}
