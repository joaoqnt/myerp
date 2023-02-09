package br.com.arcus.model;

public class Usuario {
	private Integer id_usuario;
	private String nome_usuario;
	private String senha_usuario;
	private String cpf_usuario;
	private Integer empresa_usuario;
	private String cnpjEmp_usuario;
	private String perfil_usuario;
		
	
	public Integer getEmpresa_usuario() {
		return empresa_usuario;
	}
	public void setEmpresa_usuario(Integer empresa_usuario) {
		this.empresa_usuario = empresa_usuario;
	}
	public String getPerfil_usuario() {
		return perfil_usuario;
	}
	public void setPerfil_usuario(String perfil_usuario) {
		this.perfil_usuario = perfil_usuario;
	}
	public String getCnpjEmp_usuario() {
		return cnpjEmp_usuario;
	}
	public void setCnpjEmp_usuario(String cnpjEmp_usuario) {
		this.cnpjEmp_usuario = cnpjEmp_usuario;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	public String getSenha_usuario() {
		return senha_usuario;
	}
	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}
	public String getCpf_usuario() {
		return cpf_usuario;
	}
	public void setCpf_usuario(String cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	}
	
}
