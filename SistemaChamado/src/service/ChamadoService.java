package service;

import dao.ChamadoDAO;
import model.Chamado;


public class ChamadoService {

		ChamadoDAO dao = new ChamadoDAO();
		
		public int criar(Chamado chamado) {
			return dao.criar(chamado);
		}
		
		public void atualizar(Chamado chamado){
			dao.atualizar(chamado);
		}
		
		public void excluir(int id){
			dao.excluir(id);
		}
		
		public Chamado carregar(int id){
			return dao.carregar(id);
		}

	

}
