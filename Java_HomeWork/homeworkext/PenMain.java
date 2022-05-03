package homeworkext;

public class PenMain {

	public static void main(String[] args) {
		Pen[] ps = new Pen[2];
		ps[0] = new Pencil("Penel", 30);
		ps[1] = new InkBrush("MontBlonc", 1000);
		
		for (int i = 0; i < ps.length; i++) {
			ps[i].write();
			System.out.println("售價為: " + ps[i].getPrice());
		}
	}

}
