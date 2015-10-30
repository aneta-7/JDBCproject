package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.BouqetFlower;
import main.BouqetFlowerManager;
import main.Flower;

public class FlowerBouqetTest {
	private final static long ID_1 = 1;
	private final static long ID_2 = 1;

	
		BouqetFlowerManager bouqetFlowerManager = new BouqetFlowerManager();
	
		@Test
		public void checkConnection(){
			assertNotNull(bouqetFlowerManager.getConnection());
		}
		
		@Test
		public void checkAdding(){
			
			BouqetFlower bf = new BouqetFlower(ID_1, ID_2);
			
			bouqetFlowerManager.clearBouqetFlower();
			assertEquals(1,bouqetFlowerManager.addFlowerBouqet(bf));
			
			List<BouqetFlower> bfs = bouqetFlowerManager.getAllFlowerBouqet();
			BouqetFlower bfRetrieved = bfs.get(0);
			
			assertEquals(ID_1, bfRetrieved.getFlowerIdFlower());
			assertEquals(ID_2, bfRetrieved.getBouqetIdBouqet());
	}
		
	@Test
	public void checkUpdate(){
		
	}
	
	@Test 
	public void checkDelete(){
		
	}
	
	@Test
	public void checkSelect(){
		
	}
}
