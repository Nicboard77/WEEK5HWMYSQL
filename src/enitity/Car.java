package enitity;

public class Car {
	private int carId;
	private String name = "";
	private int price;
	
	public Car(int carId, String name, int price) {
		this.carId = carId;
		this.name = name;
		this.price = price;
	}
	
	
	
	
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
