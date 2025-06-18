package biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BibliotekaTest extends BibliotekaInterfaceTest{

	@Override
	public BibliotekaInterface getInstance() {
		return new Biblioteka();
	}

	

}
