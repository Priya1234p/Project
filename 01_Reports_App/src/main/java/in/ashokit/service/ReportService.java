package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.request.SearchRequest;
import jakarta.servlet.http.HttpServletResponse;


public interface ReportService {
	
	public List<String> getPlanNames();
	public List<String> getPlanStatuses();
	
	public List<CitizenPlan> search (SearchRequest request);
	
	public Boolean exportExcel (HttpServletResponse response) throws Exception;
	public Boolean exportPdf (HttpServletResponse response) throws Exception;

}
