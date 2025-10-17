package in.ashokit.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.ashokit.entity.CitizenPlan;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Pdfgenerator {

    public void generate(HttpServletResponse response, List<CitizenPlan> plans, File f) throws Exception {

        // ✅ Set PDF response type and file name
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=plans.pdf");

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        
        PdfWriter.getInstance(document, new FileOutputStream(f));
        
        document.open();

        // ✅ Title
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitle.setSize(20);
        Paragraph paragraph = new Paragraph("Citizen Plans Report", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph);

        // ✅ Create Table with 6 Columns
        PdfPTable table = new PdfPTable(6);
        table.setSpacingBefore(10);
        table.addCell("ID");
        table.addCell("Citizen Name");
        table.addCell("Plan Name");
        table.addCell("Plan Status");
        table.addCell("Start Date");
        table.addCell("End Date");

        // ✅ Add Data Rows
        for (CitizenPlan plan : plans) {
            table.addCell(String.valueOf(plan.getCitizenId()));
            table.addCell(plan.getCitizenName() != null ? plan.getCitizenName() : "");
            table.addCell(plan.getPlanName() != null ? plan.getPlanName() : "");
            table.addCell(plan.getPlanStatus() != null ? plan.getPlanStatus() : "");
            table.addCell(plan.getPlanStartDate() != null ? plan.getPlanStartDate().toString() : "");
            table.addCell(plan.getPlanEndDate() != null ? plan.getPlanEndDate().toString() : "");
        }

        // ✅ Add table to PDF and close document
        document.add(table);
        document.close();
    }
}
