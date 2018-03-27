package br.usjt.arqsw.entity;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class Fila implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@NotNull(message="A fila n�o pode ser vazia")
	@Min(value=1, message="A fila n�o pode ser vazia")
	private int id;
	
	@NotNull
	@Size(min=5, max=45, message="O nome da fila deve estar entre 5 e 45 caracteres.")
	private String nome;
	public Fila selecionar(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	public Fila(EntityManager manager) {
		return ;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Fila [id=" + id + ", nome=" + nome + "]";
	}
	
}
