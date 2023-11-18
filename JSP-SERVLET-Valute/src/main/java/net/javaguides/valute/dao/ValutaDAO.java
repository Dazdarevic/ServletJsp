package net.javaguides.valute.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.valute.model.Valuta;

//data access object
//CRUD database operations for table valute_db in the database
public class ValutaDAO {
	
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "admin";
	
	private static final String INSERT_VALUTA_SQL = 
	"Insert into valute_drzave" + " (naziv, drzava, vrednost) values" + "(?,?,?);";
	
	private static final String SELECT_VALUTA_BY_ID = "Select * from valute_drzave where id=?;";
	private static final String SELECT_ALL_VALUTE = "Select * from valute_drzave;";
	private static final String DELETE_VALUTA_SQL = "Delete from valute drzave where id = ?;";
	private static final String UPDATE_VALUTE_SQL = "Update valute_drzave set naziv = ?, drzava = ?, "
			+ "vrednost = ? where id=?";
	
	protected Connection getConnection() throws ClassNotFoundException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL,jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	// INSERT
	public void insertValuta (Valuta valuta) throws SQLException, ClassNotFoundException {
		try(Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VALUTA_SQL)) 
		{
			preparedStatement.setString(1, valuta.getNaziv());
			preparedStatement.setString(2, valuta.getDrzava());
			preparedStatement.setString(3, valuta.getVrednost());
			preparedStatement.executeUpdate();
;		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// UPDATE
	public boolean updateValuta (Valuta valuta) throws SQLException {
		boolean rowUpdated = false;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_VALUTE_SQL)) 
		{
			statement.setString(1, valuta.getNaziv());
			statement.setString(2, valuta.getDrzava());
			statement.setString(3, valuta.getVrednost());
			statement.setInt(4, valuta.getId());
			
			rowUpdated = statement.executeUpdate() > 0;
			
;		} catch(Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}
	
	// SELECT by ID
	public Valuta selectValuta(int id) {
		Valuta valuta = null;
		
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_VALUTA_BY_ID)) 
		{
			statement.setInt(1, id);
			System.out.println(statement);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				String naziv = rs.getString("naziv");
				String drzava = rs.getString("drzava");
				String vrednost = rs.getString("vrednost");
				
				valuta = new Valuta(id, naziv, drzava, vrednost);
			}
			
;		} catch(Exception e) {
			e.printStackTrace();
		}
		return valuta;
	}
	
	// SELECT *
	public List<Valuta> selectAll() {
		List<Valuta> valuta_drzave = new ArrayList<>();
		
		try(Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(SELECT_ALL_VALUTE)) 
		{
			
			System.out.println(statement);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String naziv = rs.getString("naziv");
				String drzava = rs.getString("drzava");
				String vrednost = rs.getString("vrednost");
				
				valuta_drzave.add(new Valuta(id, naziv, drzava, vrednost));
			}
			
;		} catch(Exception e) {
			e.printStackTrace();
		}
		return valuta_drzave;
	}
	
	// DELETE 
	public boolean deleteValuta (int id) throws SQLException {
		boolean rowDeleted = false;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_VALUTE_SQL)) 
		{
			statement.setInt(1, id);
			
			rowDeleted = statement.executeUpdate() > 0;
			
;		} catch(Exception e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}
	
}
