package ru.mazarkov.professions;

import ru.mazarkov.professions.*;

class Doctor extends Professions {
	public void treat(Patient patient) {
	
	}
	
	public Diagnose heal(Patient patient) {
		return new Diagnose(patient);
	}
}