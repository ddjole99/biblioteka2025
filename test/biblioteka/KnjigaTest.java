package biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KnjigaTest {

    private Knjiga knjiga;

    @BeforeEach
    void setUp() {
        knjiga = new Knjiga();
    }
    
    @AfterEach 
    void tearDown() {
    	knjiga=null;
    }

    @Test
    void testSetNaslovValidan() {
        knjiga.setNaslov("Proba");
        assertEquals("Proba", knjiga.getNaslov());
    }

    @Test
    void testSetNaslovNull() {
        assertThrows(NullPointerException.class, () -> knjiga.setNaslov(null));
    }

    @Test
    void testSetNaslovPrazan() {
        assertThrows(IllegalArgumentException.class, () -> knjiga.setNaslov(""));
    }

    @Test
    void testSetIsbnValidan() {
        knjiga.setIsbn(1234567890123L);
        assertEquals(1234567890123L, knjiga.getIsbn());
    }

    @Test
    void testSetIsbnNevalidanNula() {
        assertThrows(IllegalArgumentException.class, () -> knjiga.setIsbn(0));
    }
    
    @Test
    void testSetIsbnNevalidanNegativan() {
        assertThrows(IllegalArgumentException.class, () -> knjiga.setIsbn(-1));
    }

    @Test
    void testSetIzdavac() {
        knjiga.setIzdavac("Laguna");
        assertEquals("Laguna", knjiga.getIzdavac());
    }

    @Test
    void testSetIzdavacNull() {
        assertThrows(NullPointerException.class, () -> knjiga.setIzdavac(null));
    }

    @Test
    void testSetIzdavacPrazno() {
        assertThrows(IllegalArgumentException.class, () -> knjiga.setIzdavac(""));
    }

    @Test
    void testSetIzdanjeValidno() {
        knjiga.setIzdanje(1);
        assertEquals(1, knjiga.getIzdanje());
    }
    
    @Test
    void testSetIzdanjeValidno2() {
        knjiga.setIzdanje(2);
        assertEquals(2, knjiga.getIzdanje());
    }

    @Test
    void testSetIzdanjeNevalidno() {
        assertThrows(IllegalArgumentException.class, () -> knjiga.setIzdanje(0));
    }

    @Test
    void testSetAutori() {
        Autor autor = new Autor("Ime", "Prezime");
        knjiga.setAutori(Collections.singletonList(autor));
        assertEquals(1, knjiga.getAutori().size());
        assertEquals("Ime", knjiga.getAutori().get(0).getIme());
    }

    @ParameterizedTest
    @CsvSource({
    	"111, 111, true",
    	"111, 222, false"
    })
    void testEqualsTrue(long isbn1, long isbn2, boolean isti) {
        Knjiga k1 = new Knjiga();
        k1.setIsbn(isbn1);

        Knjiga k2 = new Knjiga();
        k2.setIsbn(isbn2);

        assertEquals(isti, k1.equals(k2));
    }


    @Test
    void testHashCode() {
        Knjiga k1 = new Knjiga();
        k1.setIsbn(999);
        Knjiga k2 = new Knjiga();
        k2.setIsbn(999);

        assertEquals(k1.hashCode(), k2.hashCode());
    }

    @Test
    void testToString() {
        knjiga.setNaslov("Naslov");
        knjiga.setIsbn(123);
        knjiga.setAutori(Arrays.asList(new Autor("Pera", "Peric")));
        knjiga.setIzdavac("Zavod");
        knjiga.setIzdanje(2);

        String rezultat = knjiga.toString();

        assertTrue(rezultat.contains("Naslov"));
        assertTrue(rezultat.contains("123"));
        assertTrue(rezultat.contains("Zavod"));
        assertTrue(rezultat.contains("2"));
        assertTrue(rezultat.contains("Pera"));
        assertTrue(rezultat.contains("Peric"));
        
    }
}

