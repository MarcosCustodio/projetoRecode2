package com.spacetur.model;

public class Usuario {

	private int id;
	private String nome_usuario;
	private int cpf_usuario;
	private int telefone_usuario;
	private int senha_usuario;
	private String email_usuario;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	public int getCpf_usuario() {
		return cpf_usuario;
	}
	public void setCpf_usuario(int cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	}
	public int getTelefone_usuario() {
		return telefone_usuario;
	}
	public void setTelefone_usuario(int telefone_usuario) {
		this.telefone_usuario = telefone_usuario;
	}
	public int getSenha_usuario() {
		return senha_usuario;
	}
	public void setSenha_usuario(int senha_usuario) {
		this.senha_usuario = senha_usuario;
	}
	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
}