package aneta.aneta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import aneta.aneta.*;

public class main {
		public static void main(String []args){
			
			FlowerManager flowerManager = new FlowerManager();
					
			List<Flower> flowers = flowerManager.getAllFlower();
			
			for(Flower flower : flowers){
				System.out.println(flower.bouqets.size());
			}
			
			for(int i=0;i<flowers.size();i++){
			System.out.println("id: " + flowers.get(i).getIdFlower()+ " nazwa: "+flowers.get(i).getFlowerName()+" cena: " +flowers.get(i).getFlowerPrice());
			}
			}
		}

