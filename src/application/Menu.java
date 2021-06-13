package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.CarsDao;
import enitity.Car;

public class Menu {
	
	private Scanner scanner = new Scanner(System.in);
	private CarsDao CarsDao = new CarsDao();
	private List<String> options = Arrays.asList("Display Car Listings",
			"Create a Listing",
			"Update a Listing",
			"Delete a Listing");
			
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			try {
				if (selection.equals("1")) {
					displayListings();
				} else if (selection.equals("2")) {
					createListing();
				} else if (selection.equals("3")) {
					updateListing();
				} else if (selection.equals("4")) {
					deleteListing();
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue....");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
	private void printMenu() {
		System.out.println("Please select an option\n---------------------------------");
		for(int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ": " + options.get(i));
		}
	}
	private void displayListings() throws SQLException {
		List<Car> cars = CarsDao.getListing();
		for(Car car : cars) {
			System.out.println(car.getCarId() + ": " + car.getName() + " $" + car.getPrice());
		}
	}
	private void createListing() throws SQLException {
		System.out.println("Enter name of car: ");
		String carName = scanner.nextLine();
		System.out.println("Enter desired price: ");
		int priceOfCar = Integer.parseInt(scanner.nextLine());
		CarsDao.createNewListing(carName, priceOfCar);
	}
	private void updateListing() throws SQLException {
		System.out.println("Enter id of car you with to edit: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter the new name of the listing: ");
		String newName = scanner.nextLine();
		System.out.println("Enter the new price of the listing: ");
		int newPrice = Integer.parseInt(scanner.nextLine());
		CarsDao.updateListing(newName, newPrice, id);
	}
	private void deleteListing() throws SQLException {
		System.out.println("Enter the id of the listing you with to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		CarsDao.deleteListing(id);
	}
	

}
