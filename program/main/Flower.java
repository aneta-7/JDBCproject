package aneta.aneta;

import java.util.ArrayList;
import java.util.List;

public class Flower {
	private long idFlower;
	private String flowerName;
	private String flowerPrice;
	
	public List<Bouqet> bouqets = new ArrayList<Bouqet>();
	
	
	
	public Flower(){
		
	}
	
	public Flower(String flowerName, String flowerPrice) {
		super();
		this.flowerName = flowerName;
		this.flowerPrice = flowerPrice;
	}
	
	public long getIdFlower() {
		return idFlower;
		
	}
	public void setIdFlower(long idFlower) {
		this.idFlower = idFlower;
	}
	public String getFlowerName() {
		return flowerName;
	}
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	public String getFlowerPrice() {
		return flowerPrice;
	}
	public void setFlowerPrice(String flowerPrice) {
		this.flowerPrice = flowerPrice;
	}
	
}
