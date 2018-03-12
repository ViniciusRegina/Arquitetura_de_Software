package br.usjt.arqsw.model.service;

import java.io.IOException;
import java.util.ArrayList;

import br.usjt.arqsw.model.dao.ChamadoDAO;
import br.usjt.arqsw.model.entity.Chamado;

public class ChamadoService {
	
		private ChamadoDAO dao;
		
		public ChamadoService(){
			dao = new ChamadoDAO();
			
		}
		public ArrayList<Chamado> ListarChamado() throws IOException{
			return null;
			
		}
		
		public Chamado carregar (int numFila) throws IOException{
			return null;
			
		}
}
