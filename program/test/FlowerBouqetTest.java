package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.BouqetFlower;
import main.BouqetFlowerManager;

public class FlowerBouqetTest {
	private final static long NAME_1 = 1;
	private final static long PRICE_1 = 1;
	
	@Test
	public void checkConnection(){
		assertNotNull(BouqetFlowerManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		BouqetFlower bf = new BouqetFlower(NAME_1, PRICE_1);
		
		//BouqetFlowerManager.clearBouqetFlower();
		assertEquals(1,BouqetFlowerManager.addFlowerBouqet(bf));
		
		List<BouqetFlower> bfs = BouqetFlowerManager.getAllFlowerBouqet();
		BouqetFlower personRetrieved = bfs.get(0);
		
		assertEquals(NAME_1, personRetrieved.getFlowerIdFlower());
		assertEquals(PRICE_1, personRetrieved.getBouqetIdBouqet());
	}
}
