package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.posredniczaca;
import main.FlowerManager;
import main.Bouqet;
import main.BouqetManager;
import main.Flower;

public class posredniczacaTest {

	
posredniczaca posred = new posredniczaca();
FlowerManager flowerManager = new FlowerManager();
BouqetManager bouqetManager = new BouqetManager();
	

private final static String NAME_1 = "mieszanka";
private final static String NAME_2 = "tulipan";
private final static String PRICE_1 = "4";

	@Test
	//test pobierz x nalezacych do y
	public void test1() {
	
	}

	@Test
	//test dodanie do tabeli y
	public void test2(){
		Bouqet bouqet = new Bouqet(NAME_1);
		
		assertEquals(1,bouqetManager.addBouqet(bouqet));
		
	}
	
	@Test
	//test pobranie wszystkich y
	public void test3(){
		List<Bouqet> bouqets = bouqetManager.getAllBouqet();
		Bouqet bouqetRetrieved = bouqets.get(0);
		
		assertEquals(NAME_1, bouqetRetrieved.getBouqetName());
	}
	
	@Test 
	//test przypisanie x do y
	public void test4(){
		
		
	}
	
	@Test
	//test dodanie do tabeli x
	public void test5(){
		Flower flower = new Flower(NAME_2, PRICE_1);
		
		flowerManager.clearFlower();
		assertEquals(1,flowerManager.addFlower(flower));
	}
	
	
	
}

