package com.caresoft.models;

import java.util.ArrayList;
import java.util.Date;

import com.caresoft.interfaces.HIPAACompliantUser;

public class Physician extends User implements HIPAACompliantUser {

	public Physician(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean assignPin(int pin) {
		if(String.valueOf(pin).length() == 4) {
			return true;
		}
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID == id) {
			return true;
		}
		return false;
	}

	// Inside class:    
    private ArrayList<String> patientNotes;
	
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    

}
