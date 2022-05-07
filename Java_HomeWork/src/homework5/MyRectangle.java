package homework5;

public class MyRectangle {
	private double width, depth;
	public MyRectangle() {
		
	}
	public MyRectangle(double width, double depth) {
		setWidth(width);
		setDepth(depth);
		
	}
	
	void setWidth(double width) {
		this.width = width;
	}
	
	void setDepth(double depth) {
		this.depth = depth;
	}
	
	double getArea() {
		return width * depth;
	}
}
