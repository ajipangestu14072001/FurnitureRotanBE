package com.example.furniturerotanbe.pdf;

import com.example.furniturerotanbe.models.MasterData;
import com.example.furniturerotanbe.models.MasterTransaksi;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class BarangMasukReport {
    private final List<MasterData> listUsers;

    public BarangMasukReport(List<MasterData> listUsers) {
        this.listUsers = listUsers;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(6);

        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Harga", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Kategori", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Nama Barang", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Stock", font));
        table.addCell(cell);

    }

    private void writeTableData(PdfPTable table) {
        for (MasterData user : listUsers) {
            table.addCell(String.valueOf(user.getId()));
            table.addCell(user.getHarga().toString());
            table.addCell(user.getKategori());
            table.addCell(user.getNamaBarang());
            table.addCell(String.valueOf(user.getStock()));
        }

    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Laporan Barang Masuk", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}
