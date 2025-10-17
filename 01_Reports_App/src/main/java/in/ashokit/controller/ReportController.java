package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.request.SearchRequest;
import in.ashokit.service.ReportService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {

    @Autowired
    private ReportService service;
    
    @GetMapping("/pdf")
    public void pdfExport(HttpServletResponse response) throws Exception {
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=plans.pdf");
        service.exportPdf(response); 
    }
    
    @GetMapping("/excel")
    public void excelExport(HttpServletResponse response) throws Exception {
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", "attachment; filename=plans.xlsx");
        service.exportExcel(response);
    }
    
    @PostMapping("/search")
    public String handleSearch(SearchRequest search , Model model) {
        List<CitizenPlan> plans = service.search(search);
        model.addAttribute("plans", plans);
        model.addAttribute("search", search);
        init(model);
        return "index";
    }
    
    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("search", new SearchRequest());
        init(model);
        return "index";
    }

    private void init(Model model) {
        model.addAttribute("names", service.getPlanNames());
        model.addAttribute("statuses", service.getPlanStatuses());
    }
}
