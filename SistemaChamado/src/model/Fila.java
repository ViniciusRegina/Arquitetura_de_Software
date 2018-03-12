package model;

import java.io.Serializable;

public class Fila implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private int nm_fila;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNm_fila() {
		return nm_fila;
	}
	public void setNm_fila(int nm_fila) {
		this.nm_fila = nm_fila;
	}
	
	
}
