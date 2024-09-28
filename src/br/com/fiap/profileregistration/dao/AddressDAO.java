package br.com.fiap.profileregistration.dao;

import br.com.fiap.profileregistration.model.Address;
import br.com.fiap.profileregistration.model.Professional;

public interface AddressDAO {
	public void includesAdress(Professional professional, Address adress);
	
	public void searchIDByCPF(Professional professional, int id);
}
