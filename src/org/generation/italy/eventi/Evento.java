package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	private String titolo;
	private LocalDate data;
	private int postiTot;
	private int postiPrenotati;
	
	public Evento(String titolo, LocalDate data, int postiTot) throws IllegalArgumentException {
		
		setTitolo(titolo);
		setData(data);
		setPostiTot(postiTot);
		
		setPostiPrenotati(0);
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) throws IllegalArgumentException {
		
		if (LocalDate.now().isAfter(data))
			throw new IllegalArgumentException("La data non puo' essere nel passato");
		
		this.data = data;
	}
	
	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	public void setPostiPrenotati(int postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
	}

	public String getTitolo() {
		return titolo;
	}

	public int getPostiTot() {
		return postiTot;
	}
	
	public void prenota() throws Exception {
		
		if (!hasPostiDisponibili() || !isInTheFuture())
			throw new Exception("Non ci sono posti disponibili o l'evento e' gia' passato");
		
		postiPrenotati++;
	}
	public void disdici() throws Exception {
		
		if (!hasPostiPrenotati() || !isInTheFuture())
			throw new Exception("Non ci sono posti disponibili o l'evento e' gia' passato");
		
		postiPrenotati--;
	}

	@Override
	public String toString() {
		
		return getHumanDate() + " - " + getTitolo();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Evento)) return false;
		
		Evento e = (Evento) obj;
		
		return getTitolo().equals(e.getTitolo())
			&& getData().equals(e.getData());
	}
	
	protected String getHumanDate() {
		
		return getData().format(DateTimeFormatter.ofPattern("d-M-Y"));
	}
	
	private void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	private void setPostiTot(int postiTot) throws IllegalArgumentException {
		
		if (postiTot <= 0) 
			throw new IllegalArgumentException("I posti totali devono essere strettamente positivi");
		
		this.postiTot = postiTot;
	}
	
	private boolean hasPostiPrenotati() {
		
		return postiPrenotati > 0;
	}
	private boolean hasPostiDisponibili() {
		
//		if (postiTot - postiPrenotati > 0) 
//			return true;
//		else return false;
		
		return postiTot - postiPrenotati > 0;
	}
	private boolean isInTheFuture() {
		
		return LocalDate.now().isBefore(getData());
	}
}
