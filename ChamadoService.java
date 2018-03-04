package service;

public class ChamadoService {
	
	public void abrirChamado() {
		
		dao.abrirChamado();
		
		
	}
	
	public String fecharChamado(String status) {
		
		dao.fecharChamado(status);
		
	}
	
	public int consultarChamado(int nro) {
		
		dao.consultarChamado(nro);
		
	}
	
    public ArrayList<Chamado> listarChamados() {
    	
    	dao.listarChamados();
    	
    }
    
}
	


