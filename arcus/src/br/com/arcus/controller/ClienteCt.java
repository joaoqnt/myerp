package br.com.arcus.controller;


import java.util.List;

import br.com.arcus.dao.ClienteDao;
import br.com.arcus.model.Cliente;

public class ClienteCt {
	public void insert(Cliente c) {
		ClienteDao dao = new ClienteDao();
		dao.insert(c);
	}
	
	public void update(Cliente c) {
		ClienteDao dao = new ClienteDao();
		dao.update(c);
	}
	
	public void delete(Cliente c) {
		ClienteDao dao = new ClienteDao();
		dao.delete(c);
	}
	
	public Cliente select(Cliente c) {
		ClienteDao dao = new ClienteDao();
		dao.select(c);
		return c;
	}
	
	public List<Cliente> listagem() {
		ClienteDao dao = new ClienteDao();
		
		return dao.select();
	}
}
