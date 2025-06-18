package biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import biblioteka.Knjiga;

public abstract class BibliotekaInterfaceTest {

	protected BibliotekaInterface biblioteka;
	
	public abstract BibliotekaInterface getInstance();
	
	private Knjiga k1;
	
	private Knjiga k2;
	
	@BeforeEach
	void setUp() throws Exception {
		biblioteka=getInstance();
		
		k1=new Knjiga();
		k1.setIsbn(111);
		
		k2=new Knjiga();
		k2.setIsbn(222);
	}

	@AfterEach
	void tearDown() throws Exception {
		biblioteka=null;
		
		k1=null;
		k2=null;
	}

	@Test
	void testDodajKnjigu() {
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		
		List<Knjiga> knjige=biblioteka.vratiSveKnjige();
		
		assertEquals(2, knjige.size());
		assertTrue(knjige.contains(k1));
		assertTrue(knjige.contains(k1));
	}
	@Test
	void testDodajKnjiguNull() {
		
		assertThrows(java.lang.NullPointerException.class, ()-> biblioteka.dodajKnjigu(null));
	}
	@Test
	void testDodajKnjiguDuplikat() {
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		
		assertThrows(java.lang.IllegalArgumentException.class, ()-> biblioteka.dodajKnjigu(k2));
	}

	@Test
	void testObrisiKnjigu() {
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		
		biblioteka.obrisiKnjigu(k2);
		
		List<Knjiga> knjige=biblioteka.vratiSveKnjige();
		
		assertEquals(1, knjige.size());
		assertTrue(knjige.contains(k1));
	}

	@Test
	void testObrisiKnjiguNull() {
		
		assertThrows(java.lang.NullPointerException.class, ()-> biblioteka.obrisiKnjigu(null));
	
	}
	
	@Test
	void testObrisiKnjiguNePostoji() {
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		
		Knjiga k3=new Knjiga();
		k3.setIsbn(999);
		
		assertThrows(java.lang.IllegalArgumentException.class, ()->biblioteka.obrisiKnjigu(k3));
		
	}

	@Test
	void testVratiSveKnjige() {
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		
		List<Knjiga> knjige=biblioteka.vratiSveKnjige();
		
		assertEquals(2,knjige.size());
		assertTrue(knjige.contains(k1));
		assertTrue(knjige.contains(k2));
	}

	@Test
	void testPronadjiKnjiguNema() {
		k1.setNaslov("Naslov 1");
		k2.setNaslov("Naslov 2");
		
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		
		List<Knjiga> rezultati=biblioteka.pronadjiKnjigu(null, 0, "Drina", null);
		
		assertEquals(0,rezultati.size());
	}
	
	@Test
	void testPronadjiKnjigu() {
		k1.setNaslov("Naslov 1");
		k2.setNaslov("Knjiga 2");
		
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		
		List<Knjiga> rezultati=biblioteka.pronadjiKnjigu(null, 0, "KNJI", null);
		
		assertEquals(1,rezultati.size());
		assertEquals(k2,rezultati.get(0));
	}
	
	@Test
	void testPronadjiKnjiguVise() {
		k1.setNaslov("Naslov 1");
		k2.setNaslov("Naslov 2");
		
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		
		List<Knjiga> rezultati=biblioteka.pronadjiKnjigu(null, 0, "SloV", null);
		
		assertEquals(2,rezultati.size());
		assertTrue(rezultati.contains(k1));
		assertTrue(rezultati.contains(k2));
	}

	@Test
	void testPronadjiKnjiguNemaParametara() {
		
		assertThrows(java.lang.IllegalArgumentException.class, ()->biblioteka.pronadjiKnjigu(null, 0, null, null));
	}
}
