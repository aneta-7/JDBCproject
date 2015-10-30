package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BouqetFlowerManager {

		
		private Connection connection;
		
		private String url = "jdbc:hsqldb:hsql://localhost/workdb";
		
		private String createTableBouqetFlower = "CREATE TABLE BouqetFlower(flowerIdFlower bigint, bouqetIdBouqet bigint)";


		
		private PreparedStatement addFlowerBouqetStmt;
		private PreparedStatement deleteAllFlowerBouqetStmt;
		private PreparedStatement getAllFlowerBouqetStmt;
		private PreparedStatement updateFlowerBouqetStmt;
		
		private Statement statement;
		public BouqetFlowerManager(){
			try{
					
					Class.forName("org.hsqldb.jdbcDriver");
					
					connection = DriverManager.getConnection(url);
					statement = connection.createStatement();
					
					ResultSet rs = connection.getMetaData().getTables(null,null,null, null);
					
				
				boolean tableExists = false;
						while (rs.next()){
							if("BouqetFlower".equalsIgnoreCase(rs.getString("TABLE_NAME"))){
								tableExists = true;
								break;
							}
							
						}
			
						if(!tableExists)
							statement.executeUpdate(createTableBouqetFlower);
						
						addFlowerBouqetStmt =  connection.prepareStatement("INSERT INTO BouqetFlower(flowerIdFlower, bouqetIdBouqet)VALUES(?,?)");
						deleteAllFlowerBouqetStmt = connection.prepareStatement("DELETE FROM BouqetFlower");
						getAllFlowerBouqetStmt = connection.prepareStatement("SELECT flowerIdFlower, bouqetIdBouqet FROM BouqetFlower");
					//	updateFlowerBouqetStmt = connection.prepareStatement("UPDATE BouqetFlower SET ");
			
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
			public  Connection getConnection(){
				return connection;
			}
			public  void clearBouqetFlower(){
				try{
					deleteAllFlowerBouqetStmt.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
			}
			
			public int addFlowerBouqet(BouqetFlower bf){
				int count = 0;
				try{
					addFlowerBouqetStmt.setLong(1, bf.getFlowerIdFlower());
					addFlowerBouqetStmt.setLong(2, bf.getBouqetIdBouqet());
					
					count = addFlowerBouqetStmt.executeUpdate();
				}catch(SQLException e){
					e.printStackTrace();
				}
				return count;
			}
		
			public List<BouqetFlower> getAllFlowerBouqet(){
				List<BouqetFlower> bouqetFlower = new ArrayList<BouqetFlower>();
				
				try{
					ResultSet rs = getAllFlowerBouqetStmt.executeQuery();
					
					while(rs.next()){
						BouqetFlower bf = new BouqetFlower();
						bf.setFlowerIdFlower(rs.getLong("flowerIdFlower"));
						bf.setBouqetIdBouqet(rs.getLong("bouqetIdBouqet"));
						bouqetFlower.add(bf);
						
					}
				}
				catch(SQLException e){
					e.printStackTrace();
				}
				return bouqetFlower;
			}
		
		
	
}
