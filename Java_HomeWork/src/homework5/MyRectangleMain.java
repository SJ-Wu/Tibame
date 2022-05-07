package homework5;

public class MyRectangleMain {

	public static void main(String[] args) {
		MyRectangle myRec1 = new MyRectangle();
		myRec1.setWidth(10);
		myRec1.setDepth(20);
		System.out.println("rectangle 1's area = " + myRec1.getArea());
		
		MyRectangle myRec2 = new MyRectangle(10, 20);
		System.out.println("rectangle 2's area = " + myRec2.getArea());

		

	}

}
