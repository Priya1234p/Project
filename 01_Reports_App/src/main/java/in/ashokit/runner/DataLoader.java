package in.ashokit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private CitizenPlanRepository repo;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // ✅ Insert sample data only when table is empty
        if (repo.count() == 0) {

            CitizenPlan c1 = new CitizenPlan();
            c1.setCitizenName("Johan");
            c1.setGender("Male");
            c1.setPlanName("Cash");
            c1.setPlanStatus("Approved");
            c1.setPlanStartDate(LocalDate.now());
            c1.setPlanEndDate(LocalDate.now().plusMonths(3));
            c1.setBenefitAmt(5000.00);

            CitizenPlan c2 = new CitizenPlan();
            c2.setCitizenName("Stallin");
            c2.setGender("Male");
            c2.setPlanName("Food");
            c2.setPlanStatus("Denied");
            c2.setDenialReason("Rent Income");

            CitizenPlan c3 = new CitizenPlan();
            c3.setCitizenName("Radha");
            c3.setGender("Female");
            c3.setPlanName("Employment");
            c3.setPlanStatus("Terminated");
            c3.setPlanStartDate(LocalDate.now().minusMonths(1));
            c3.setPlanEndDate(LocalDate.now().plusMonths(9));
            c3.setBenefitAmt(5000.00);
            c3.setTerminatedDate(LocalDate.now());
            c3.setTerminationRsn("Employed");

            List<CitizenPlan> list = Arrays.asList(c1, c2, c3);
            repo.saveAll(list);

            System.out.println("✅ 3 sample records inserted successfully!");
        } else {
            System.out.println("ℹ️ Records already exist, skipping data insertion.");
        }
    }
}
