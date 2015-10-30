package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.BouqetFlower;
import main.BouqetFlowerManager;

public class FlowerBouqetTest {
	private final static long ID_1 = 1;
	
	
	
	
	
	
	yeytyetryrtyrtytry
	private final static long ID_2 = 1;

	
BouqetFlowerManager bouqetFlowerManager = new BouqetFlowerManager();
	
	@Test
	public void checkConnection(){
		assertNotNull(bouqetFlowerManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		BouqetFlower bf = new BouqetFlower(ID_1, ID_2);
		
		BouqetFlowerManager.clearBouqetFlower();
		assertEquals(1,BouqetFlowerManager.addFlowerBouqet(bf));
		
		List<BouqetFlower> bfs = BouqetFlowerManager.getAllFlowerBouqet();
		BouqetFlower bfRetrieved = bfs.get(0);
		
		assertEquals(ID_1, bfRetrieved.getFlowerIdFlower());
		assertEquals(ID_2, bfRetrieved.getBouqetIdBouqet());
	}
}
