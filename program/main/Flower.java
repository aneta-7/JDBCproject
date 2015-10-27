package main;

public class Flower {
	private long idFlower;
	private String flowerName;
	private String flowerPrice;
	
	private long flowerIdFlower;
	private long bouqetIdBouqet;
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
	public long getFlowerIdFlower() {
		return flowerIdFlower;
	}
	public void setFlowerIdFlower(long flowerIdFlower) {
		this.flowerIdFlower = flowerIdFlower;
	}
	public long getBouqetIdBouqet() {
		return bouqetIdBouqet;
	}
	public void setBouqetIdBouqet(long bouqetIdBouqet) {
		this.bouqetIdBouqet = bouqetIdBouqet;
	}
}
