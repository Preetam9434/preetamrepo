package com.pcsgpl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pcsgpl.entity.EmpProfesionDetail;
import com.pcsgpl.service.EmployeService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeService empserv;
	
	@GetMapping("/empdetails")
	public List<EmpProfesionDetail> getAllEmp(){
		
	  return empserv.getAllemployee();
		
	}
	
	@PostMapping("/empdetails")
	public void addEmp(@RequestBody EmpProfesionDetail emPrfDtails) 
	{
	    empserv.addEmpDetails(emPrfDtails);
	  
	}
	
	@GetMapping("/empdetails/{id}")
	public ResponseEntity<EmpProfesionDetail> getEmpId(@PathVariable("id") Integer id1) {
		
		ResponseEntity<EmpProfesionDetail> employeeId = this.empserv.getEmployeeId(id1);
		
		return employeeId;
	}
	
	
	@PutMapping("/empdetails/{id}")
	public EmpProfesionDetail updateEmp(@PathVariable int id,@RequestBody EmpProfesionDetail emply){
		
		
		this.empserv.updateEmployee(id, emply);
		
		return emply;
	}
	
	
	@DeleteMapping("/empdetails/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id){
		
		 ResponseEntity<Map<String, Boolean>> deleteEmp = this.empserv.deleteEmployee(id);
		
		 return deleteEmp;
	}
	
}

