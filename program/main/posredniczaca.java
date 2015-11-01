package main;

import main.FlowerManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import main.BouqetFlowerManager;



// x - Flower 
// y - Bouqet
public class posredniczaca {
	
	private Connection connection;
	private String url = "jdbc:hsqldb:hsql://localhost/abc";

	private PreparedStatement addFlowerStmt;
	private PreparedStatement addBouqetStmt;
	private PreparedStatement getAllFlowerStmt;
	private PreparedStatement getAllBouqetStmt;
	
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
		
	//pobierz x nalezacych do y
	
	public void wezXzY(){
		//trzeba pobrac BouqetIdBouqet i FlowerIdFlower
		//wyswietlic idFlower = FlowerIdFlower
	}
	
	//pobranie wszystkich y
	public void wszystkieY(){
		List<Bouqet> bouqets = bouqetManager.getAllBouqet();		
	}
		
	//przypisanie x do y
	public void przypiszXdoY(){
		
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
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
		
	}
}
