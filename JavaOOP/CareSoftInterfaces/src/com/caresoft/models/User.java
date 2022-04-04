package com.caresoft.models;

import java.util.ArrayList;

import com.caresoft.interfaces.HIPAACompliantAdmin;
import com.caresoft.interfaces.HIPAACompliantUser;

public class User implements HIPAACompliantAdmin, HIPAACompliantUser {
	protected Integer id;
	protected int pin;
	public User(Integer id) {
		this.id = id;
	}

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public int getPin() {
		return this.pin;
	}

}
