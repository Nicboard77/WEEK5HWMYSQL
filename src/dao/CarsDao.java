package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enitity.Car;

public class CarsDao {
	
	private Connection connection;
	private final String GET_CAR_LISTINGS_QUERY = "SELECT * FROM cars";
	private final String CREATE_CAR_LISTING = "INSERT INTO cars (name, price) values (?,?)";
	private final String UPDATE_CAR_LISTING = "UPDATE cars set name = ?, price = ? where id = ?";
	private final String DELETE_CAR_LISTING = "DELETE FROM cars WHERE id = ?";
	public CarsDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Car> getListing() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_CAR_LISTINGS_QUERY).executeQuery();
		List<Car> cars = new ArrayList<Car>();
		while (rs.next()) {
			cars.add(createCar(rs.getInt(1), rs.getString(2), rs.getInt(3)));
		}
		return cars;
	}
	public void createNewListing(String name, int price) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_CAR_LISTING);
		ps.setString(1, name);
		ps.setInt(2, price);
		ps.executeUpdate();
	}
	public void updateListing(String name, int price, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_CAR_LISTING);
		ps.setString(1, name);
		ps.setInt(2, price);
		ps.setInt(3, id);
		ps.executeUpdate();
	}
	public void deleteListing(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CAR_LISTING);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	private Car createCar(int id, String name, int price) {
		return new Car(id, name, price);
	}

}
