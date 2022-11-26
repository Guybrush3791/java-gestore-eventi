package org.generation.italy.eventi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {

	private LocalTime ora;
	private BigDecimal prezzo;
	
	public Concerto(String titolo, LocalDate data, int postiTot, LocalTime ora, BigDecimal prezzo) {
		
		super(titolo, data, postiTot);
		
		setOra(ora);
		setPrezzo(prezzo);
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	public String getHumanDateTime() {
		
		return getHumanDate() + " @ " + getOra().format(DateTimeFormatter.ofPattern("H:m"));
	}
	
	public String getHumanPrice() {
		
		DecimalFormat df = new DecimalFormat("#,###.00€");
		
		return df.format(getPrezzo());
	}
	
	@Override
	public String toString() {
		
		return getHumanDateTime() + " - " + getTitolo() + " - " + getHumanPrice();
	}
}








