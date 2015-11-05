package aneta.aneta;

import static org.junit.Assert.*;

import java.util.List;
import org.hsqldb.auth.JaasAuthBean.UPCallbackHandler;
import org.junit.Test;
 
import aneta.aneta.*;


public class FlowerBouqetTest {
	private final static long ID_1 = 1;
	private final static long ID_2 = 1;
	private final static String NAME_1 = "mieszanka";
	private final static String NEW_NAME = "wiazanka";
	private final static String NAME_2 = "tulipan";
	private final static String PRICE_1 = "4";

	BouqetFlowerManager bouqetFlowerManager = new BouqetFlowerManager();
	FlowerManager flowerManager = new FlowerManager();
	BouqetManager bouqetManager = new BouqetManager();
	
		@Test
		public void checkConnection(){
			assertNotNull(bouqetFlowerManager.getConnection());
		}
		
		
		
		@Test
		public void checkAdd(){
			Flower flower = new Flower(NAME_2, PRICE_1);
			
			flowerManager.clearFlower();
			assertEquals(1, flowerManager.addFlower(flower));
			
			List<Flower> flowers = flowerManager.getAllFlower();
			Flower flowerRetrieved = flowers.get(0);
			
			Bouqet bouqet = new Bouqet(NAME_1);
			
			bouqetManager.clearBouqet();
			assertEquals(1,bouqetManager.addBouqet(bouqet));
			
			List<Bouqet> bouqets = bouqetManager.getAllBouqet();
			Bouqet bouqetRetrieved = bouqets.get(0);

			assertEquals(1, bouqetFlowerManager.addFlowerBouqet(flowerRetrieved,bouqetRetrieved));
			
		}
		@Test
		public void checkUpdate(){
			BouqetFlower bf = new BouqetFlower(ID_1,ID_2);
			Flower f = new Flower(NAME_2, PRICE_1);
			Bouqet b = new Bouqet(NAME_1);
			
			bouqetFlowerManager.clearBouqetFlower();
			assertEquals(1,bouqetFlowerManager.addFlowerBouqet(f, b));
			
			List<BouqetFlower> bfs = bouqetFlowerManager.getAllFlowerBouqet();
			BouqetFlower bfRetrieved = bfs.get(0);
			
			bfRetrieved.setFlowerIdFlower(ID_1);
			bfRetrieved.setBouqetIdBouqet(ID_2);
			
			assertEquals(0, bouqetFlowerManager.updateBouqetFlower(bfRetrieved));
			
			List<BouqetFlower> bfs2 = bouqetFlowerManager.getAllFlowerBouqet();
			BouqetFlower bfRetrieved2 = bfs2.get(0);
			
			assertEquals(0, bfRetrieved2.getFlowerIdFlower());
			assertEquals(0, bfRetrieved2.getBouqetIdBouqet());
		}
	
		@Test 
		public void checkDelete(){
			BouqetFlower bf = new BouqetFlower(ID_1,ID_2);
					
			List<BouqetFlower> bfs = bouqetFlowerManager.getAllFlowerBouqet();
			BouqetFlower bfRetrieved = bfs.get(0);
			
			assertEquals(1, bouqetFlowerManager.deleteBouqetFlower(bfRetrieved));
		}
		

}
