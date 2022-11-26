package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {

	private String title;
	private List<Evento> eventi;
	
	public ProgrammaEventi(String title) {
		
		setTitle(title);
//		this.eventi = new ArrayList<>();
		setEventi(new ArrayList<>());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	public void addEvento(Evento evento) {
		
		getEventi().add(evento);
	}
	
	public List<Evento> getEventiByDate(LocalDate date) {
		
		List<Evento> res = new ArrayList<>();
		
		for (Evento e : getEventi()) {
			
			if (e.getData().isEqual(date))
				res.add(e);
		}
		
		return res;
	}
	
	public int getEventiCount() {
		
		return getEventi().size();
	}
	
	public boolean clearEventi() {
		
		if (getEventiCount() < 1) return false;
		
		getEventi().clear();
		
		return true;
	}
	
	@Override
	public String toString() {
		
		String res = getTitle() + "\n";
		
		for (Evento e : getEventi()) 
			res += e.toString() + "\n";
		
		return res;
	}
	
	private void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}
}
