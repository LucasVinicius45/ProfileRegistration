package br.com.fiap.profileregistration.dao;

import br.com.fiap.profileregistration.model.Email;
import br.com.fiap.profileregistration.model.Professional;

public interface EmailDAO {
	
	public void includesEmail(Professional professional, Email email);
	
	public void searchIDByCPF(Professional professional, int id);
}
