package aneta.aneta;

import static org.junit.Assert.*;

import java.util.List;
import org.hsqldb.auth.JaasAuthBean.UPCallbackHandler;
import org.junit.Test;
import org.junit.*;


public class BouqetTest {

BouqetManager bouqetManager = new BouqetManager();
	


	private final static String NAME_1 = "mieszanka";
	private final static String NEW_NAME = "wiazanka";
	
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
		
		bouqetRetrieved.setBouqetName(NAME_1);
		
		assertEquals(NAME_1, bouqetRetrieved.getBouqetName());
	
	}
	
	@Test
	public void checkUpdate(){
		Bouqet bouqet = new Bouqet(NAME_1);
		
		bouqetManager.clearBouqet();
		assertEquals(1,bouqetManager.addBouqet(bouqet));
		
		List<Bouqet> bouqets = bouqetManager.getAllBouqet();
		Bouqet bouqetRetrieved = bouqets.get(0);
		
		
		bouqetRetrieved.setBouqetName(NEW_NAME);
		assertEquals(1, bouqetManager.updateBouqet(bouqetRetrieved));
		
		List<Bouqet> bouqets2 = bouqetManager.getAllBouqet();
		Bouqet bouqetRetrieved2 = bouqets2.get(0);
		
		assertEquals(NEW_NAME, bouqetRetrieved2.getBouqetName());
		

	}
	@Test
	public void checkDelete(){
		Bouqet bouqet = new Bouqet(NAME_1);
		
		bouqetManager.clearBouqet();
		assertEquals(1,bouqetManager.addBouqet(bouqet));
		List<Bouqet> bouqets = bouqetManager.getAllBouqet();
	    
		int k=bouqetManager.getAllBouqet().size();

		
		assertEquals(k-1, bouqetManager.deleteBouqet(bouqet));
		
		
		
	}

}
