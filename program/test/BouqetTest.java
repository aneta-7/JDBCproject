package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.Bouqet;
import main.BouqetManager;


public class BouqetTest {

BouqetManager bouqetManager = new BouqetManager();
	
	private final static String NAME_1 = "mieszanka";
	
	@Test
	public void checkConnection(){
		assertNotNull(bouqetManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Bouqet bouqet = new Bouqet(NAME_1);
		
		bouqetManager.clearBouqet();
		assertEquals(1,bouqetManager.addBouqet(bouqet));
		
		List<Bouqet> bouqets = bouqetManager.getAllBouqet();
		Bouqet bouqetRetrieved = bouqets.get(0);
		
		assertEquals(NAME_1, bouqetRetrieved.getBouqetName());
		
		
	}
	

}
