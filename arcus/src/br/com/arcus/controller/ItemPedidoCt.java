package br.com.arcus.controller;

import java.util.List;

import br.com.arcus.dao.ItemPedidoDao;
import br.com.arcus.model.ItemPedido;

public class ItemPedidoCt {
	public List<ItemPedido> listaItens(){
		ItemPedidoDao dao = new ItemPedidoDao();
		return dao.select();
	}
	public ItemPedido select(ItemPedido ip) {
		ItemPedidoDao dao = new ItemPedidoDao();
		dao.select(ip);
		return ip;
	}
}
