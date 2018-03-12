package service;

import java.util.ArrayList;

import dao.ChamadoDAO;
import model.Chamado;

public class FilaService {
	ChamadoDAO dao;
	
	public FilaService(){
		dao = new ChamadoDAO();
	}
	public ArrayList<Chamado> listarChamado(){
		return dao.listarChamado();
	}
	public ArrayList<Chamado> listarChamado(String chave){
		return dao.listarChamado(chave);
	}

}
