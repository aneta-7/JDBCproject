package aneta.aneta;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.hsqldb.auth.JaasAuthBean.UPCallbackHandler;
import aneta.aneta.*;

public class posredniczacaTest {

	
posredniczaca posred = new posredniczaca();

FlowerManager flowerManager = new FlowerManager();
BouqetManager bouqetManager = new BouqetManager();
BouqetFlowerManager bouqetFlowerManager = new BouqetFlowerManager();
	

private final static String NAME_1 = "mieszanka";
private final static String NEW_NAME = "wiazanka";
private final static String NAME_2 = "tulipan";
private final static String PRICE_1 = "4";

	@Test
	//test dodanie do tabeli y
	public void checkAddY(){
		Bouqet bouqet = new Bouqet(NAME_1);
		
		assertEquals(1,bouqetManager.addBouqet(bouqet));
		
	}
	
	@Test
	//test pobranie wszystkich y
	public void checkSelectY(){
			
		Bouqet bouqet = new Bouqet(NAME_1);
		
		bouqetManager.clearBouqet();
		assertEquals(1,bouqetManager.addBouqet(bouqet));
		
		List<Bouqet> bouqets = bouqetManager.getAllBouqet();
		Bouqet bouqetRetrieved = bouqets.get(0);
		
		bouqetRetrieved.setBouqetName(NAME_1);
		assertEquals(NAME_1, bouqetRetrieved.getBouqetName());
		
		//assertEquals(2,bouqets.size());
	}
	
	@Test 
	//test przypisanie x do y
	public void checkXtoY(){
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
	//test dodanie do tabeli x
	public void checkAddX(){
		Flower flower = new Flower(NAME_2, PRICE_1);
		
		flowerManager.clearFlower();
		assertEquals(1,flowerManager.addFlower(flower));
	}
	
	
	
}
