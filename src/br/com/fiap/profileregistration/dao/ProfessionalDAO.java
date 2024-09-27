package br.com.fiap.profileregistration.dao;

import br.com.fiap.profileregistration.model.Professional;

public interface ProfessionalDAO {
	
	public void includesProfessional(Professional professional);
	
	public void searchIDByCPF(Professional professional, int id);
}
