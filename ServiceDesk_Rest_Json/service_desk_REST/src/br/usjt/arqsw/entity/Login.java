package br.usjt.arqsw.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Ant�nio Amadeu Freire Lucena 816117925
 *
 */

@Entity
public class Login implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final String LOGADO = "logado";
					
		@NotNull(message="O usuario não pode ser vazio")
		@Min(value=10, message="O user não pode ser vazia")
		private String username;
		
		@NotNull(message="O usuario não pode ser vazio")
		@Min(value=10, message="O user não pode ser vazia")		
		private String password;
	
	public String getUsername() {
		return username;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Login [username=" + username+ ", password=" + password + "]";
	}
}
