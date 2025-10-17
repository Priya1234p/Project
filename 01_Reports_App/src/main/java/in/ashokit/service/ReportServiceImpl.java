package in.ashokit.service;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;
import in.ashokit.request.SearchRequest;
import in.ashokit.util.EmailUtils;
import in.ashokit.util.ExcelGenerator;
import in.ashokit.util.Pdfgenerator;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private CitizenPlanRepository planRepo;

    @Autowired
    private ExcelGenerator excelGenerator;

    @Autowired
    private Pdfgenerator pdfGenerator;

    @Autowired
    private EmailUtils emailUtils;

    @Override
    public List<String> getPlanNames() {
        return planRepo.findAll()
                       .stream()
                       .map(CitizenPlan::getPlanName)
                       .distinct()
                       .collect(Collectors.toList());
    }

    @Override
    public List<String> getPlanStatuses() {
        return planRepo.findAll()
                       .stream()
                       .map(CitizenPlan::getPlanStatus)
                       .distinct()
                       .collect(Collectors.toList());
    }

    @Override
    public List<CitizenPlan> search(SearchRequest request) {
        CitizenPlan entity = new CitizenPlan();

        if (request.getPlanName() != null && !request.getPlanName().isEmpty()) {
            entity.setPlanName(request.getPlanName());
        }

        if (request.getPlanStatus() != null && !request.getPlanStatus().isEmpty()) {
            entity.setPlanStatus(request.getPlanStatus());
        }

        if (request.getGender() != null && !request.getGender().isEmpty()) {
            entity.setGender(request.getGender());
        }

        if (request.getStartDate() != null) {
            entity.setPlanStartDate(request.getStartDate());
        }

        if (request.getEndDate() != null) {
            entity.setPlanEndDate(request.getEndDate());
        }

        return planRepo.findAll(Example.of(entity));
    }

    @Override
    public Boolean exportExcel(HttpServletResponse response) throws Exception {

        File f = new File("Plans.xls");
        List<CitizenPlan> plans = planRepo.findAll();

        // ✅ FIXED: Added the File argument (no other change)
        excelGenerator.generate(response, plans, f);

        String subject = "Test mail subject";
        String body = "<h1> Test mailbody </h1>";
        String to = "priyakumariyadav99@gmail.com";

        emailUtils.sendEmail(subject, body, to, f);

        f.delete();

        return true;
    }

    @Override
    public Boolean exportPdf(HttpServletResponse response) throws Exception {
    	
    	File f = new File("Plans.pdf");
    	
        List<CitizenPlan> plans = planRepo.findAll();
        pdfGenerator.generate(response, plans, f);
        String subject = "Test mail subject";
        String body = "<h1> Test mailbody </h1>";
        String to = "priyakumariyadav99@gmail.com";

        emailUtils.sendEmail(subject, body, to, f);
        
        f.delete();

        return true;
    }
}
