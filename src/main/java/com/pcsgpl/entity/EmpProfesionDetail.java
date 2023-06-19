package com.pcsgpl.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="employee_professional_details")
public class EmpProfesionDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employee_id;
	private String employment_name;
	private String employment_duration;
	private String joining_date;
	private String release_date;
	
	public EmpProfesionDetail(int employee_id, String employment_name, String employment_duration, String joining_date,
			String release_date) {
		super();
		this.employee_id = employee_id;
		this.employment_name = employment_name;
		this.employment_duration = employment_duration;
		this.joining_date = joining_date;
		this.release_date = release_date;
	}
 
	public EmpProfesionDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployment_name() {
		return employment_name;
	}

	public void setEmployment_name(String employment_name) {
		this.employment_name = employment_name;
	}

	public String getEmployment_duration() {
		return employment_duration;
	}

	public void setEmployment_duration(String employment_duration) {
		this.employment_duration = employment_duration;
	}

	public String getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	
	
}
