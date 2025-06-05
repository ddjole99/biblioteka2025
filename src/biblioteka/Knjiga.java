package biblioteka;

import java.util.List;

public class Knjiga {

	private String naslov;
	private long isbn;
	private List<Autor> autori;
	private String izdavac;
	private String izdanje;

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public List<Autor>  getAutori() {
		return autori;
	}

	public void setAutori(List<Autor> autori) {
		this.autori = autori;
	}

	public String getIzdavac() {
		return izdavac;
	}

	public void setIzdavac(String izdavac) {
		this.izdavac = izdavac;
	}

	public String getIzdanje() {
		return izdanje;
	}

	public void setIzdanje(String izdanje) {
		this.izdanje = izdanje;
	}

}
