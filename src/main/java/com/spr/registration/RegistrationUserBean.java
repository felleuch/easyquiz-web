package com.spr.registration;

import com.spr.model.Shop;

import com.spr.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Registration user JSF bean.
 * 
 * @author itcuties
 *
 */
@Component
@ManagedBean
@SessionScoped
public class RegistrationUserBean {
	


	@Autowired
	private ShopService shopService;


	
	private String firstname;
	private String lastname;

	public Integer getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(Integer employeeNum) {
		this.employeeNum = employeeNum;
	}

	private String email;

	private Integer employeeNum;
	
	/**
	 * Method registers user
	 */
	public void register() {
		// Output some info
		System.out.println("RegistrationUserBean:: Registering user " + firstname + " " + lastname + ", with email " + email);
		
		// Call the business object to register the user
		//registrationBo.registerUser(firstname, lastname, email);
		Shop shop = new Shop();
		shop.setName(firstname);
		shop.setEmplNumber(employeeNum);
		shopService.create(shop) ;
		
		// Set the message here
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration success", "success");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}






	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
