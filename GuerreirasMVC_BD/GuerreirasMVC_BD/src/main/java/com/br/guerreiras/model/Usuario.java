package com.br.guerreiras.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Email    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String senha;
    
    @Column(nullable = false)
    private String user;  

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, name = "data_nascimento")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String cpf;
    
    @Column(nullable = false)
    private String telefone;
    
    @Column(nullable = false)
    private String redeSocial;
    
    
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRedeSocial() {
		return redeSocial;
	}

	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Usuario() {
		
	}
	

//    public Usuario(long id, @Email String email, String senha, String nome, LocalDate dataNascimento, String cpf,
//			String telefone, String redeSocial) {
//		super();
//		this.id = id;
//		this.email = email;
//		this.senha = senha;
//		this.nome = nome;
//		this.dataNascimento = dataNascimento;
//		this.cpf = cpf;
//		this.telefone = telefone;
//		this.redeSocial = redeSocial;
//	}
//
//	
//	@Override
//	public String toString() {
//		return "Usuario [id=" + id + ", email=" + email + ", senha=" + senha + ", nome=" + nome + ", dataNascimento="
//				+ dataNascimento + ", cpf=" + cpf + ", telefone=" + telefone + ", redeSocial=" + redeSocial + "]";
//	}
//    
    
}
