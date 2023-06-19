package com.pcsgpl.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pcsgpl.entity.EmpProfesionDetail;
import com.pcsgpl.excption.ResourceNotFoundException;
import com.pcsgpl.repository.EmpRepos;

@Service
public class EmployeService {

	@Autowired
	public EmpRepos empRepository;
	
	public List<EmpProfesionDetail> getAllemployee()
	{
		List<EmpProfesionDetail> empdetails=new ArrayList<EmpProfesionDetail>();
		
		empRepository.findAll().forEach(empdetails::add);
	  	
		return empdetails;
	}

	public void addEmpDetails(EmpProfesionDetail emPrfDtails) {
		
		empRepository.save(emPrfDtails);
		
	}

	
	
	public ResponseEntity<EmpProfesionDetail> getEmployeeId(Integer id1) {
		
		EmpProfesionDetail emplo=empRepository.findById(id1)
				.orElseThrow();
		
		return ResponseEntity.ok(emplo);
	}
	
	
	
	public ResponseEntity<EmpProfesionDetail> updateEmployee( int id,EmpProfesionDetail emply){
		
		EmpProfesionDetail emploDetail=empRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("employee not update"+id));
		
		
		
		emploDetail.setEmployment_name(emply.getEmployment_name());
		emploDetail.setEmployment_duration(emply.getEmployment_duration());
		emploDetail.setJoining_date(emply.getJoining_date());
		emploDetail.setRelease_date(emply.getRelease_date());
		
	
		
		EmpProfesionDetail updateEmpDetails = empRepository.save(emploDetail);
		return ResponseEntity.ok(updateEmpDetails);
		
	}
	
	
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(int id){
		
		EmpProfesionDetail employDetail=empRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("employee not update"+id));
		
		
		empRepository.delete(employDetail);
		Map<String, Boolean> empResponse=new HashMap<>();
		empResponse.put("deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(empResponse);
		
		
	}
	 
	
}
