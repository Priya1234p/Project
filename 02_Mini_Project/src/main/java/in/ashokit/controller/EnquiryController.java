package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnquiryController {

    // Show Add Enquiry Page
    @GetMapping("/add-enquiry")
    public String addEnquiryPage(Model model) {
        // Optionally, you can pass empty form for new enquiry
        return "add-enquiry";
    }

    // Edit Enquiry Page
    @GetMapping("/edit-enquiry/{id}")
    public String editEnquiryPage(@PathVariable("id") String id, Model model) {
        // For now, fetch enquiry by id from static list
        // In real scenario, fetch from DB via service
        java.util.List<java.util.Map<String,String>> enquiries = new java.util.ArrayList<>();
        java.util.Map<String,String> e1 = new java.util.HashMap<>();
        e1.put("id", "1");
        e1.put("studentName", "Mark");
        e1.put("course", "Java Fullstack");
        e1.put("contactNumber", "+91-79797979");
        e1.put("enquiryDate", "13-Mar-2025");
        e1.put("status", "New");
        enquiries.add(e1);

        java.util.Map<String,String> e2 = new java.util.HashMap<>();
        e2.put("id", "2");
        e2.put("studentName", "Lucy");
        e2.put("course", "Python Fullstack");
        e2.put("contactNumber", "+91-898989898");
        e2.put("enquiryDate", "10-Oct-2025");
        e2.put("status", "Enrolled");
        enquiries.add(e2);

        // find enquiry by id
        java.util.Map<String,String> enqToEdit = enquiries.stream()
            .filter(enq -> enq.get("id").equals(id))
            .findFirst()
            .orElse(null);

        model.addAttribute("enquiry", enqToEdit);

        return "add-enquiry"; // reuse the same template
    }

    // Handle Enquiry Submission
    @PostMapping("/enquiry")
    public String saveEnquiry(
            @RequestParam String studentName,
            @RequestParam String contactNumber,
            @RequestParam String classMode,
            @RequestParam String course,
            @RequestParam String status,
            Model model) {

        // Here you can save to DB (for now, we just print)
        System.out.println("Enquiry Saved: " + studentName + ", " + contactNumber + ", " + classMode + ", " + course + ", " + status);

        model.addAttribute("msg", "Enquiry saved successfully!");
        return "add-enquiry";
    }

    // View Enquiries
    @GetMapping("/view-enquiries")
    public String viewEnquiriesPage(Model model) {

        java.util.List<java.util.Map<String,String>> enquiries = new java.util.ArrayList<>();

        java.util.Map<String,String> e1 = new java.util.HashMap<>();
        e1.put("id", "1");
        e1.put("studentName", "Mark");
        e1.put("course", "Java Fullstack");
        e1.put("contactNumber", "+91-79797979");
        e1.put("enquiryDate", "13-Mar-2025");
        e1.put("status", "New");
        enquiries.add(e1);

        java.util.Map<String,String> e2 = new java.util.HashMap<>();
        e2.put("id", "2");
        e2.put("studentName", "Lucy");
        e2.put("course", "Python Fullstack");
        e2.put("contactNumber", "+91-898989898");
        e2.put("enquiryDate", "10-Oct-2025");
        e2.put("status", "Enrolled");
        enquiries.add(e2);

        model.addAttribute("enquiries", enquiries);
        return "view-enquiries";
    }
}
