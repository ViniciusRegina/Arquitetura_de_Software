package br.usjt.arqsw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.LoginDAO;

/**
 * 
 * @author Antônio Amadeu Freire Lucena 816117925
 *
 */


@Service
public class LoginService {
	private LoginDAO dao;
	
	@Autowired
	public LoginService(LoginDAO dao){
		this.dao = dao;
	}

}


