package br.usjt.arqsw.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Ant�nio Amadeu Freire Lucena 816117925 
 *
 */
@Entity
@Table(name="Chamado")
public class Chamado implements Serializable {

	private static final long serialVersionUID = 1L;	
	public static final String ABERTO = "aberto";
	public static final String FECHADO = "fechado";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_chamado")	
	private int id;   
		
	@NotNull	
	@Column(name="Descricao")
	@Size(max=100,min=10, message="O tamanho da descrição deve estar entre 10 e 100 caracteres")
	private String Descricao;  
	
	@NotNull
	private String Status; 
	
	@NotNull
	@Column(name="Dt_abertura")	
	private Date DT_ABERTURA; 	
	
	@Column(name="Dt_fechamento")	
	private Date DT_FECHAMENTO;  
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_fila")
	private Fila fila;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Date getDT_ABERTURA() {
		return DT_ABERTURA;
	}

	public void setDT_ABERTURA(Date dT_ABERTURA) {
		DT_ABERTURA = dT_ABERTURA;
	}

	public Date getDT_FECHAMENTO() {
		return DT_FECHAMENTO;
	}

	public void setDT_FECHAMENTO(Date dT_FECHAMENTO) {
		DT_FECHAMENTO = dT_FECHAMENTO;
	}

	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}

	
	
}
