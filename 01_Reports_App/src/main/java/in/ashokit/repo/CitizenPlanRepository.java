package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.CitizenPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Integer> {

    @Query("SELECT DISTINCT c.planName FROM CitizenPlan c")
    List<String> getPlanNames();
    
    @Query("SELECT DISTINCT c.planStatus FROM CitizenPlan c")
    List<String> getPlanStatus();
}
