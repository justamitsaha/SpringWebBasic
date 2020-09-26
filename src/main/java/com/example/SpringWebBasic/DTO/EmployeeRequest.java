package com.example.SpringWebBasic.DTO;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

public class EmployeeRequest {
	
	@NotNull																				//Can Not be null
	@Pattern(regexp = "^[A-z]*$", message = "Emplloyee ID can only have Alphabets")  		//accept only number
	@Size (min=3, message ="Employee Id must be greater than 2 digits")
	private String empId;
	
	@NotNull
	@Size(min=2, max=15, message="Name should be between 2 and 16 characters")
	private String fName;
	
	@NotNull (message="Last Name cannot be Null")																				//The field has to be passed but will allow ""																															
	private String lName;
	
	@Email(message="Must be a Valid Email Id")																				//If @NotNull is not present then we can choose to not pass the argument but if passed must have valid email
	private String email;
	
	private String department;
	
	@NotNull(message="Addrress cannot be Null")
	private String address;
	
	@DecimalMin("1.5") @DecimalMax("10") 
	private double increment;
	
	
	@Digits (integer = 5, fraction = 2)      //Will allow 5 digits before fraction and 2 after fraction
	private Double salary;
	
	@Future(message = "Retirement Date Can't be in past")
	private Date retirementDate;
	
	@FutureOrPresent(message = "Next Promotion Date can't be in Past")
	private Date nextPromotionDate;
	
	@Negative(message="Should be less than zero")
	private Integer efficiency;
	
	@NegativeOrZero(message="Should be less negatiove or zero") 
	private Integer output;
	
	@NotBlank(message="Can't be blank")								// Trims the string and checks if length is not zero will not allow blank space
	private String comments;
	
	@NotEmpty(message="Can't be blank will allow blank spaces")									// Will allow blank space
	private String comments2;
	
	@Past(message="Should be a date in Past")	
	private Date dob;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getIncrement() {
		return increment;
	}

	public void setIncrement(double increment) {
		this.increment = increment;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getRetirementDate() {
		return retirementDate;
	}

	public void setRetirementDate(Date retirementDate) {
		this.retirementDate = retirementDate;
	}

	public Date getNextPromotionDate() {
		return nextPromotionDate;
	}

	public void setNextPromotionDate(Date nextPromotionDate) {
		this.nextPromotionDate = nextPromotionDate;
	}

	public Integer getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(Integer efficiency) {
		this.efficiency = efficiency;
	}

	public Integer getOutput() {
		return output;
	}

	public void setOutput(Integer output) {
		this.output = output;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getComments2() {
		return comments2;
	}

	public void setComments2(String comments2) {
		this.comments2 = comments2;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}
