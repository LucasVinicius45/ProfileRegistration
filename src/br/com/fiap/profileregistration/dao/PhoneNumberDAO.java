package br.com.fiap.profileregistration.dao;

import br.com.fiap.profileregistration.model.PhoneNumber;
import br.com.fiap.profileregistration.model.Professional;

public interface PhoneNumberDAO {

	public void includesPhone(Professional professional, PhoneNumber number);
	
	public void searchIDByCPF(Professional professional, int id);
}
