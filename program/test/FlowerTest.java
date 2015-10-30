package test;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

import main.Flower;
import main.FlowerManager;

public class FlowerTest {

	

FlowerManager flowerManager = new FlowerManager();
	
	private final static long ID_1 = 1;
	private final static String NAME_1 = "roza";
	private final static String PRICE_1 = "4";
	
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
		Flower flower = new Flower(NAME_1, ID_1);	
		
		List<Flower> flowers = flowerManager.getAllFlower();
		Flower flowerRetrieved = flowers.get(0);
		
	//	assertEquals(1,flowerManager.updateFlower(flower));
		
	}
	
	

	@Test
	public void checkDelete(){
		
	}
	
	@Test
	public void checkSelect(){
		
	}
	
	
	
	
	
	
	
}
