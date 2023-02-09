package br.com.arcus.controller;

import java.util.List;

import br.com.arcus.dao.PedidoDao;
import br.com.arcus.model.Pedido;

public class PedidoCt {
	public void insert(Pedido p) {
		PedidoDao dao = new PedidoDao();
		dao.insert(dao);
	}
	public void update(Pedido p) {
		PedidoDao dao = new PedidoDao();
		dao.update(dao);
	}
	public void delete(Pedido p) {
		PedidoDao dao = new PedidoDao();
		dao.delete(dao);
	}
	public List<Pedido> listaPedidos(){
		PedidoDao dao = new PedidoDao();
		return dao.select();
	}
}
