package aneta.aneta;

public class BouqetFlower {
	private long flowerIdFlower;
	private long bouqetIdBouqet;
	
	public BouqetFlower(){
		
	}
	
	public BouqetFlower(long flowerIdFlower, long bouqetIdBouqet) {

		this.flowerIdFlower = flowerIdFlower;
		this.bouqetIdBouqet = bouqetIdBouqet;
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

