package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProgrammaEventiUnici {

	public static class EventoComp implements Comparator<Evento> {
		
		@Override
		public int compare(Evento o1, Evento o2) {
			
			return o2.getTitolo().length() - o1.getTitolo().length();
		}
	}
	
	String titolo;
	Set<Evento> eventi;
	
	public ProgrammaEventiUnici(String titolo) {
		
		setTitolo(titolo);
		setEventi(new HashSet<>());
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public Set<Evento> getEventi() {
		return eventi;
	}
	
	public void addEvento(Evento evento) {
		
		getEventi().add(evento);
	}
	
	public Set<Evento> getEventiByDate(LocalDate date) {
		
		Set<Evento> res = new HashSet<>();
		
		for (Evento e : getEventi()) {
			
			if (e.getData().equals(date)) 
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
	
	public Evento getMaxPostiTotaliEvento() {
		
		Evento maxE = null;
		int maxPosti = Integer.MIN_VALUE;		
		for (Evento e : getEventi()) {
			
			if (maxPosti < e.getPostiTot()) {
			
				maxPosti = e.getPostiTot();
				maxE = e;
			}				
		}
		
		return maxE;
	}
	public Evento getMinPostiTotaliEvento() {
		
		Evento minE = null;
		int minPosti = Integer.MAX_VALUE;
		for (Evento e : getEventi()) {
			
			if (minPosti > e.getPostiTot()) {
				
				minPosti = e.getPostiTot();
				minE = e;
			}
		}
		
		return minE;
	}
	public void printOrderedList() {
		
		List<Evento> eventi = new ArrayList<>(getEventi());
		
		eventi.sort(new Comparator<Evento>() {
			
			@Override
			public int compare(Evento o1, Evento o2) {
				
				return o2.getTitolo().length() - o1.getTitolo().length();
			}
		});
		
		System.out.println("Eventi in ordine di lunghezza del titolo");
		for (Evento e : eventi) {
			
			System.out.println(e);
		}
	}
	public Evento getFirstEvento() {
		
		LocalDate minDate = LocalDate.MAX;
		Evento minEvento  = null;
		
		for (Evento e : getEventi()) {
			
			if (minDate.isAfter(e.getData())) {
				
				minDate = e.getData();
				minEvento = e;
			}
		}
		
		return minEvento;
	}
	public Evento getLastEvent() {
		
		List<Evento> eventi = new ArrayList<>(getEventi());
		
		eventi.sort(new Comparator<Evento>() {
			
			@Override
			public int compare(Evento o1, Evento o2) {
				
				if (o1.getData().isBefore(o2.getData())) return -1;
				else if (o2.getData().isBefore(o1.getData())) return 1;
				
				return 0;
			}
		});
		
		return eventi.get(eventi.size() - 1);
	}
	
	@Override
	public String toString() {
		
		String res = getTitolo() + "\n";
		
		for (Evento e : getEventi()) 
			res += e + "\n";
		
		return res;
	}
	
	private void setEventi(Set<Evento> eventi) {
		this.eventi = eventi;
	}	
}









