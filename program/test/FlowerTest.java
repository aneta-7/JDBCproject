package aneta.aneta;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.hsqldb.auth.JaasAuthBean.UPCallbackHandler;
import aneta.aneta.*;

public class FlowerTest {

	

FlowerManager flowerManager = new FlowerManager();
	
	private final static long ID_1 = 1;
	private final static String NAME_1 = "roza";
	private final static String NEW_NAME = "tulipan";
	private final static String PRICE_1 = "4";
	private final static String NEW_PRICE = "3";
	
	@Test
	public void checkConnection(){
		assertNotNull(flowerManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Flower flower = new Flower(NAME_1, PRICE_1);
		
		flowerManager.clearFlower();
		assertEquals(1,flowerManager.addFlower(flower));
		
		List<Flower> flowers = flowerManager.getAllFlower();
		Flower flowerRetrieved = flowers.get(0);
		
		assertEquals(NAME_1, flowerRetrieved.getFlowerName());
		assertEquals(PRICE_1, flowerRetrieved.getFlowerPrice());
	}
	
	@Test
	public void checkUpdate(){
		Flower flower = new Flower(NAME_1, PRICE_1);	
	
		flowerManager.clearFlower();
		assertEquals(1, flowerManager.addFlower(flower));
		
		List<Flower> flowers = flowerManager.getAllFlower();
		Flower flowerRetrieved = flowers.get(0);
		
		flowerRetrieved.setFlowerName(NEW_NAME);
		flowerRetrieved.setFlowerPrice(NEW_PRICE);
		
		assertEquals(1, flowerManager.updateFlower(flowerRetrieved));
		
		List<Flower> flowers2 = flowerManager.getAllFlower();
		Flower flowerRetrieved2 = flowers2.get(0);
		
		assertEquals(NEW_NAME, flowerRetrieved2.getFlowerName());
		assertEquals(NEW_PRICE, flowerRetrieved2.getFlowerPrice());
	}
	
	@Test
	public void checkDelete(){
	
		Flower flower = new Flower(NAME_1, PRICE_1);
		
		flowerManager.clearFlower();
		assertEquals(1,flowerManager.addFlower(flower));
		List<Flower> bouqets = flowerManager.getAllFlower();
	    
		int k=flowerManager.getAllFlower().size();

		
		assertEquals(k-1, flowerManager.deleteFlower(flower));
		assertEquals(0,flowerManager.deleteFlower(flower));
		
	}
		
	
	
	
	
	
	
}
