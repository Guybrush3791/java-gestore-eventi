package org.generation.italy.eventi;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
//		es1();
//		es2();
		
		Concerto c = new Concerto(
			"java concert", LocalDate.now().plusDays(10), 10, 
			LocalTime.now(), BigDecimal.valueOf(100d)
		);
		
		System.out.println("Date time: " + c.getHumanDateTime());
		System.out.println("Prezzo: " + c.getHumanPrice());
		
		System.out.println(c);
	}
	
	private static void es2() {
		
		ProgrammaEventi pe = new ProgrammaEventi("Java party series");
		
		Evento e1 = new Evento("java-party", LocalDate.now().plusDays(10), 10);
		Evento e2 = new Evento("java-party advanced 1", LocalDate.now().plusDays(15), 5);
		Evento e3 = new Evento("java-party advanced 2", LocalDate.now().plusDays(15), 5);
		Evento e4 = new Evento("java-party lead", LocalDate.now().plusDays(20), 3);
		
		pe.addEvento(e1);
		pe.addEvento(e2);
		pe.addEvento(e3);
		pe.addEvento(e4);
		
		System.out.println(pe);
		
		List<Evento> eventiTra15gg = pe.getEventiByDate(LocalDate.now().plusDays(15));
		System.out.println(eventiTra15gg);
		
		int eventiCount = pe.getEventiCount();
		System.out.println("Numero eventi: " + eventiCount);
		
		boolean res = pe.clearEventi();
		res = pe.clearEventi();
		System.out.println("Eliminazione eventi: " + (res ? "OK" : "KO"));
		
		eventiCount = pe.getEventiCount();
		System.out.println("Numero eventi: " + eventiCount);
		
		System.out.println(pe);
	}
	private static void es1() {
		
		Scanner sc = new Scanner(System.in);
		
		Evento evento = new Evento("java-party", LocalDate.now().plusDays(10), 10);
		System.out.println(evento);
		
		System.out.println("Vuoi effettuare delle prenotazioni? y/n");
		String res = sc.nextLine();
		
		res = res.toLowerCase();
		
		if (res.equals("y")) {
			
			System.out.println("Quante prenotazioni vuoi effettuare?");
			String quantityStr = sc.nextLine();
			int quantity = Integer.parseInt(quantityStr);
			
			for (int x=0;x<quantity;x++) {
				
				try {
					
					evento.prenota();
				} catch (Exception e) {
					
					System.err.println("Prenotazione non effettuata: " + e.getMessage());
				}
			}
		}
		
		System.out.println("Il numero di posti e': " 
				+ evento.getPostiPrenotati() 
				+ "/" + evento.getPostiTot());
		
		System.out.println("Vuoi effettuare delle didette? y/n");
		res = sc.nextLine();
		
		res = res.toLowerCase();
		
		if (res.equals("y")) {
			
			System.out.println("Quante didette vuoi effettuare?");
			String quantityStr = sc.nextLine();
			int quantity = Integer.parseInt(quantityStr);
			
			for (int x=0;x<quantity;x++) {
				
				try {
					
					evento.disdici();
				} catch (Exception e) {
					
					System.err.println("Disdetta non effettuata: " + e.getMessage());
				}
			}
		}
		
		System.out.println("Il numero di posti e': " 
				+ evento.getPostiPrenotati() 
				+ "/" + evento.getPostiTot());
	}
}
