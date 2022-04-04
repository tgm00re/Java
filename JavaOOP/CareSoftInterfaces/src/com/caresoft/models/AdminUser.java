package com.caresoft.models;

import java.util.ArrayList;
import java.util.Date;

import com.caresoft.interfaces.HIPAACompliantAdmin;
import com.caresoft.interfaces.HIPAACompliantUser;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {

	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser( Integer id,  String role) {
    	super(id);
    	this.employeeID = id;
    	this.role = role;
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.employeeID, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.employeeID, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

	@Override
	public boolean assignPin(int pin) {
		if(pin <= 99999) {
			return false;
		}
		this.pin = pin;
		return true;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(id == confirmedAuthID) {
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return null;
	}
    
    // TO DO: Setters & Getters
	
	public Integer getEmployeeId() {
		return this.employeeID;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public String getRole() {
		return this.role;
	}

}
