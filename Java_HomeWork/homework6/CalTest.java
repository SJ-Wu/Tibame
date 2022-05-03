package homework6;
import java.util.Scanner;

public class CalTest {
	public static void main(String[] args) {
		int x = 0, y = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入X的值");
		if (sc.hasNextInt()) x = sc.nextInt(); 
		System.out.println("請輸入Y的值");
		if (sc.hasNextInt()) y = sc.nextInt();
		Calculator cal = new Calculator();
		try {
			System.out.println(x + "的" + y + "次方等於" + cal.powerXY(x, y));
		} catch(CalException ce) {
			System.out.println(ce.getMessage());
		}
		sc.close();
	}
}
