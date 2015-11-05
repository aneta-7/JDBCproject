package aneta.aneta;

import aneta.aneta.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




// x - Flower 
// y - Bouqet
public class posredniczaca {
	
	private Connection connection;
	private String url = "jdbc:hsqldb:hsql://localhost/abc";

	private PreparedStatement addFlowerStmt;
	private PreparedStatement addBouqetStmt;
	private PreparedStatement getAllFlowerStmt;
	private PreparedStatement getAllBouqetStmt;
	private PreparedStatement getFlowerFromBouqet;
	private PreparedStatement getBouqetFlowerStmt;
	private PreparedStatement getBouqetStmt;

	
	private Statement statement;
	
	FlowerManager flowerManager = new FlowerManager();
	BouqetManager bouqetManager = new BouqetManager();
		
	public posredniczaca(){
			try{
				Class.forName("org.hsqldb.jdbcDriver");
				
				connection = DriverManager.getConnection(url);
				statement = connection.createStatement();
				
				ResultSet rs = connection.getMetaData().getTables(null,null,null, null);
				
				boolean tableExists = false;
						while (rs.next()){
							if("Flower".equalsIgnoreCase(rs.getString("TABLE_NAME"))){
								tableExists = true;
								break;
							}
						}
			
						if(!tableExists)
						
						addFlowerStmt =  connection.prepareStatement("INSERT INTO Flower(flowerName, flowerPrice)VALUES(?,?)");
						addBouqetStmt = connection.prepareStatement("INSERT INTO Bouqet (bouqetName) VALUES (?)");
						getAllBouqetStmt = connection.prepareStatement("SELECT idBouqet, bouqetName FROM Bouqet");
						getAllFlowerStmt = connection.prepareStatement("SELECT idFlower, flowerName, flowerPrice FROM Flower");
						getBouqetFlowerStmt = connection.prepareStatement("SELECT  flowerIdFlower, bouqetIdBouqet FROM BouqetFlower");
						getBouqetStmt = connection.prepareStatement("SELECT flowerIdFlower, bouqetIdBouqet FROM BouqetFlower WHERE  flowerIdFlower= ? ");
					}
			catch(SQLException e){
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	 public Connection getConnection(){
		return connection;
	}
		
	//dodanie do tabeli x
	public int dodajDoX(Flower flower){
		int count = 0;
		try{
			addFlowerStmt.setString(1, flower.getFlowerName());
			addFlowerStmt.setString(2, flower.getFlowerPrice());
			
			count = addFlowerStmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	
	}
	//dodanie do tabeli y
	public int dodajDoY(Bouqet bouqet){
		int count = 0;
		try{
			addBouqetStmt.setString(1, bouqet.getBouqetName());
			
			count = addBouqetStmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
		
	}
	//pobranie wszystkich y
		public List<Bouqet> getAllBouqet(){
			 List<Bouqet> bouqet = new ArrayList<Bouqet>(); 		 
			 
			 try{
				 ResultSet rs = getAllBouqetStmt.executeQuery();
				 
				 while(rs.next()){
					 Bouqet b = new Bouqet();
					 b.setIdBouqet(rs.getInt("idBouqet"));
					 b.setBouqetName(rs.getString("bouqetName"));
					 bouqet.add(b);
				 }
			 }
			 catch(SQLException e ){
				 e.printStackTrace();
			 }
			 return bouqet;
		 }

	//przypisanie x do y
		public List<BouqetFlower> getBouqetFlower(){
			List<BouqetFlower> flowerBouqet = new ArrayList<BouqetFlower>();
			
			try{
				ResultSet rs = getBouqetFlowerStmt.executeQuery();
				
				while(rs.next()){
					BouqetFlower fb = new BouqetFlower();
					fb.setBouqetIdBouqet(rs.getLong("bouqetIdBouqet"));
					fb.setFlowerIdFlower(rs.getLong("flowerIdFlower"));
					
					flowerBouqet.add(fb);
				}
			} catch(SQLException e){
				e.printStackTrace();
			}
			return flowerBouqet;
		}
		
		
		
		public Flower getFlower(Flower flower) {
			Flower flowers = new Flower();
			try {
				getBouqetStmt.setLong(1, flower.getIdFlower());
				ResultSet rs = getBouqetStmt.executeQuery();
				rs.next();
				flowers.setIdFlower(rs.getLong("idFlower"));
				flowers.setFlowerName(rs.getString("flowerName"));
				flowers.setFlowerPrice(rs.getString("flowerPrice"));
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return flowers;
		}
		
		
		
		public List<Flower> getFlowerFromBouqet(BouqetFlower bf) {
			List<Flower> flowers = new ArrayList<Flower>();

			try {

				getFlowerFromBouqet.setLong(1, bf.getFlowerIdFlower());

				ResultSet rs = getFlowerFromBouqet.executeQuery();

				while (rs.next()) {
					Flower flower = new Flower();
					flower.setIdFlower(rs.getLong("idFlower"));
					flower.setFlowerName(rs.getString("flowerName"));
					flower.setFlowerPrice(rs.getString("flowerPrice"));
					flowers.add(flower);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return flowers;
		}
}
