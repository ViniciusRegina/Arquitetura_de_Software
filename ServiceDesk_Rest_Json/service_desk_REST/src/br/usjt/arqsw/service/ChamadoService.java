package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

//TODO  Faça o ChamadoService na package servisse com um método para listar os chamados 
//      recebendo como parâmetro um objeto Fila
/**
 * 
 * @author Antônio Amadeu Freire Lucena 816117925
 *
 */

@Service
public class ChamadoService {		
	private ChamadoDAO dao;
		
	@Autowired
	public ChamadoService(ChamadoDAO dao){
		this.dao = dao;
	}
	
	public void criarChamado(Chamado chamado) throws IOException{
				
		chamado.setStatus(Chamado.ABERTO);
		chamado.setDT_ABERTURA(new Date());
		chamado.setDT_FECHAMENTO(null);

		dao.criarChamado(chamado);
	}
	
	
	public List<Chamado> listarChamados(Fila fila) throws IOException{
		
		List<Chamado> listaChamados = new ArrayList<>();								
		listaChamados = dao.listarChamados(fila);			
		return listaChamados;					 
					
	}
	
	}

	
	

