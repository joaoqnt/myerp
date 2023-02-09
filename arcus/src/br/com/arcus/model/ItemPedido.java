package br.com.arcus.model;

public class ItemPedido {
	private Integer id;
	private Integer produto;
	private Integer quantidade;
	private Integer pedido;
	private Double preco_unitario;
	private Double frete_unitario;
	private Double desco_unitario;
	private Double adici_unitario;
	private Double peso_unitario;
	private String unid_unitario;
	private String grupo_produto;
	
	public Integer getPedido() {
		return pedido;
	}
	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProduto() {
		return produto;
	}
	public void setProduto(Integer produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco_unitario() {
		return preco_unitario;
	}
	public void setPreco_unitario(Double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}
	public Double getAdici_unitario() {
		return adici_unitario;
	}
	public void setAdici_unitario(Double adici_unitario) {
		this.adici_unitario = adici_unitario;
	}
	public Double getFrete_unitario() {
		return frete_unitario;
	}
	public void setFrete_unitario(Double frete_unitario) {
		this.frete_unitario = frete_unitario;
	}
	public Double getDesco_unitario() {
		return desco_unitario;
	}
	public void setDesco_unitario(Double desco_unitario) {
		this.desco_unitario = desco_unitario;
	}
	public Double getPeso_unitario() {
		return peso_unitario;
	}
	public void setPeso_unitario(Double peso_unitario) {
		this.peso_unitario = peso_unitario;
	}
	public String getUnid_unitario() {
		return unid_unitario;
	}
	public void setUnid_unitario(String unid_unitario) {
		this.unid_unitario = unid_unitario;
	}
	public String getGrupo_produto() {
		return grupo_produto;
	}
	public void setGrupo_produto(String grupo_produto) {
		this.grupo_produto = grupo_produto;
	}
}
