package in.ashokit.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {
	
	@Autowired
	private CitizenPlanRepository planRepo;
	
	public void generate(HttpServletResponse response, List<CitizenPlan> record, File file) throws Exception {
		
		List<CitizenPlan> records = planRepo.findAll();

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("plans_data");
        
        // Header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Citizen Name");
        headerRow.createCell(2).setCellValue("Plan Name");
        headerRow.createCell(3).setCellValue("Plan Status");
        headerRow.createCell(4).setCellValue("Plan Start Date");
        headerRow.createCell(5).setCellValue("Plan End Date");
        headerRow.createCell(6).setCellValue("Benefit Amt");

        int dataRowIndex = 1;

        for (CitizenPlan plan : records) {
            Row dataRow = sheet.createRow(dataRowIndex++);
            dataRow.createCell(0).setCellValue(plan.getCitizenId());
            dataRow.createCell(1).setCellValue(plan.getCitizenName());
            dataRow.createCell(2).setCellValue(plan.getPlanName());
            dataRow.createCell(3).setCellValue(plan.getPlanStatus());
            dataRow.createCell(4).setCellValue(
                plan.getPlanStartDate() != null ? plan.getPlanStartDate().toString() : "");
            dataRow.createCell(5).setCellValue(
                plan.getPlanEndDate() != null ? plan.getPlanEndDate().toString() : "");
            dataRow.createCell(6).setCellValue(
                plan.getBenefitAmt() != null ? plan.getBenefitAmt() : 0);
        }
        // It basically send to Email
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();

        // ✅ Write directly to HTTP response (It basically send it browser)
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    
	}

}
