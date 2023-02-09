package br.com.arcus.controller;

import java.util.List;

import br.com.arcus.dao.CidadeDao;
import br.com.arcus.model.Cidade;

public class CidadeCt {
	public List<Cidade> listagem(){
		CidadeDao dao = new CidadeDao();
		return dao.select();
		//asdfasdasasdfasfasd
	}
}
