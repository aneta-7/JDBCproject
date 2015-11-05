package aneta.aneta;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.List;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hsqldb.jdbcDriver;

public class BouqetManager {
	private Connection connection;
	
	private String url = "jdbc:hsqldb:hsql://localhost/abc";
	
	private String createTableBouqet = "CREATE TABLE Bouqet(idBouqet bigint GENERATED BY DEFAULT AS IDENTITY, bouqetName varchar(50))";
	private PreparedStatement addBouqetStmt;
	private PreparedStatement deleteAllBouqetStmt;

	
	private PreparedStatement getAllBouqetStmt;
	private PreparedStatement updateBouqetStmt;
	private PreparedStatement deleteBouqetStmt;
	
	private Statement statement;
	public BouqetManager(){
		try{
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();			
		
			ResultSet rs = connection.getMetaData().getTables(null, null, null, null);
			
			boolean tableExists = false;
			while(rs.next()){
				if("Bouqet".equalsIgnoreCase(rs.getString("TABLE_NAME"))){
					tableExists = true;
					break;
				}
			}
			if (!tableExists)
				statement.executeUpdate(createTableBouqet);
			
			addBouqetStmt = connection.prepareStatement("INSERT INTO Bouqet(bouqetName) VALUES (?)");
			deleteAllBouqetStmt = connection.prepareStatement("DELETE FROM Bouqet");		
			getAllBouqetStmt = connection.prepareStatement("SELECT idBouqet, bouqetName FROM Bouqet");
			updateBouqetStmt = connection.prepareStatement("UPDATE Bouqet SET bouqetName = ? WHERE idBouqet = ?");
			deleteBouqetStmt = connection.prepareStatement("DELETE FROM Bouqet WHERE idBouqet =?");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		return connection;
	}
	
	public void clearBouqet(){
		try{
			deleteAllBouqetStmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public int deleteBouqet(Bouqet bouqet)
	{
		int count = 0;
		try{
			deleteBouqetStmt.setLong(1, bouqet.getIdBouqet());
			
			count = deleteBouqetStmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return count;
	}
	public int updateBouqet(Bouqet bouqet){
		int count = 0;
		try{
			updateBouqetStmt.setString(1, bouqet.getBouqetName());
			updateBouqetStmt.setLong(2, bouqet.getIdBouqet());
			
			count = updateBouqetStmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return count;
		
	}
	 public int addBouqet(Bouqet bouqet){
		int count = 0;
		try{
			addBouqetStmt.setString(1, bouqet.getBouqetName());
			
			count = addBouqetStmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}
	
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
	
	}
