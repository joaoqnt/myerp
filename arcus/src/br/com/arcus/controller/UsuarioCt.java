package br.com.arcus.controller;

import br.com.arcus.dao.UsuarioDao;
import br.com.arcus.model.Usuario;

public class UsuarioCt {
	public void insert(Usuario u) {
		UsuarioDao dao = new UsuarioDao();
		dao.insert(u);
	}
	
	public void update (Usuario u) {
		UsuarioDao dao = new UsuarioDao();
		dao.update(u);
	}
	
	public Usuario select(Usuario u) {
		UsuarioDao dao = new UsuarioDao();
		dao.select(u);
		return u;
	}
}
