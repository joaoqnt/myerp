package br.com.arcus.model;

import java.sql.Date;

public class Pedido {
	private Integer id;
	private Integer usuario;
	private Integer cliente;
	private Double valor_liquido;
	private Double valor_bruto;
	private Date data;
	private Integer tipo_oper;
	private Integer forma_pgto;
	private Integer prazo_pgto;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Integer getTipo_oper() {
		return tipo_oper;
	}
	public void setTipo_oper(Integer tipo_oper) {
		this.tipo_oper = tipo_oper;
	}
	public Integer getForma_pgto() {
		return forma_pgto;
	}
	public void setForma_pgto(Integer forma_pgto) {
		this.forma_pgto = forma_pgto;
	}
	public Integer getPrazo_pgto() {
		return prazo_pgto;
	}
	public void setPrazo_pgto(Integer prazo_pgto) {
		this.prazo_pgto = prazo_pgto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	public Integer getCliente() {
		return cliente;
	}
	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}
	public Double getValorLiquido() {
		return valor_liquido;
	}
	public void setValorLiquido(Double valor_liquido) {
		this.valor_liquido = valor_liquido;
	}
	public Double getValorBruto() {
		return valor_bruto;
	}
	public void setValorBruto(Double valor_bruto) {
		this.valor_bruto = valor_bruto;
	}
}
