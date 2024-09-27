package br.com.fiap.profileregistration.dao;

import br.com.fiap.profileregistration.model.BasicInformation;
import br.com.fiap.profileregistration.model.Professional;

public interface BasicInformationDAO {

	public void includesInformation(Professional professional, BasicInformation information);
	
	public void searchIDByCPF(Professional professional, int id);
}
