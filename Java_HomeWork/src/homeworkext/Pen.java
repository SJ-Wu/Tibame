package homeworkext;

public abstract class Pen {
	private String brand;
	private double price;
	
	public Pen() {
		
	}
	
	public Pen(String brand, double price) {
		setBrand(brand);
		setPrice(price);
	}
	
	public String getBrand() {
		return brand;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
		
	public abstract void write();
}

class Pencil extends Pen {
	
	public Pencil() {
		
	}
	
	public Pencil(String brand, double price) {
		setBrand(brand);
		setPrice(price);
	}
	
	public void setPrice(double price) {
		super.setPrice(price * 0.8);
	}
	
	public void write() {
		System.out.println("削鉛筆再寫");
	}
}

class InkBrush extends Pen {
	
	public InkBrush() {
		
	}
	
	public InkBrush(String brand, double price) {
		setBrand(brand);
		setPrice(price);
	}
	
	public void setPrice(double price) {
		super.setPrice(price * 0.9);
	}
	
	public void write() {
		System.out.println("沾墨汁再寫");
	}
}