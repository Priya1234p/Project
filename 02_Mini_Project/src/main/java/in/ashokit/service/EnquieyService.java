package in.ashokit.service;

import java.util.List;

import in.ashokit.binding.DashboardResponse;
import in.ashokit.binding.EnquiryForm;
import in.ashokit.binding.EnquirySearchCriteria;

public interface EnquieyService {
	
	public List<String> getCourseData();
	public List<String> getEnqStatus();
	
	public DashboardResponse getDashboardData(Integer userId);
	public String addEnquiry(EnquiryForm form);
	public List<EnquiryForm> getEnquires(Integer userId, EnquirySearchCriteria criteria);
	
	public EnquiryForm getEnquiry(Integer enqId);

}
