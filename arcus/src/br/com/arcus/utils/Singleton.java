package br.com.arcus.utils;

import java.sql.Connection;

import br.com.arcus.model.Cliente;
import br.com.arcus.model.Endereco;
import br.com.arcus.model.ItemPedido;
import br.com.arcus.model.Pedido;
import br.com.arcus.model.Usuario;

public class Singleton {
	
	private static Singleton instance;
	private Usuario user;
	private Cliente cli;
	private Pedido ped;
	private ItemPedido item;
	private String cnpj;
	private String ddd;
	private Endereco endereco;
	private String busca;
	private String op;
	private Connection conn;
	
	public static Singleton getInstance() {
		if(instance == null)
			instance = new Singleton();
		return instance;
	}
	
	public ItemPedido getItem() {
		return item;
	}	
	
	public void setItem(ItemPedido item) {
		this.item = item;
	}
	
	public void setUser(Usuario u) {
		this.user = u;
	}
	
	public Usuario getUser() {
		return user;
	}
	
	public void setCli (Cliente c) {
		this.cli = c;
	}
	
	public Cliente getCli() {
		return cli;
	}
	public void setPed(Pedido p) {
		this.ped = p;
	}
	public Pedido getPed() {
		return ped;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
