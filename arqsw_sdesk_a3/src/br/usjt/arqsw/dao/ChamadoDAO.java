package br.usjt.arqsw.dao;


import java.sql.Connection;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

@Repository
public class ChamadoDAO {


	public static class ListarChamados {
		public static void main(String[] args) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("lstrChamados");
			EntityManager manager = factory.createEntityManager();
			Chamado chamadoDAO = new Chamado();
			Fila filaDAO = new Fila(manager);

			Chamado chamados = chamadoDAO.selecionar(1);
			Fila fila = filaDAO.selecionar(1);
			
	
			chamadoDAO.setDataAbertura(null);
			chamadoDAO.setDataFechamento(null);
			chamadoDAO.setDescricao("ArqSw");
			chamadoDAO.setFila(fila);
			chamadoDAO.setNumero(1);
			chamadoDAO.setStatus("ABERTO");
			
			fila.setId(1);
			fila.setNome("Jheferson");
			
			manager.getTransaction().begin();
			chamadoDAO.criar(chamadoDAO);
			manager.getTransaction().commit();
			ArrayList<Chamado> lista = chamadoDAO.selecionarTodas();
			for (Chamado local : lista) {
				System.out.println(local);
			}
			manager.close();
			factory.close();

		}

	}

	/*
	 * 
	 * 
	 */
}
