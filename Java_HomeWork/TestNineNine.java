package first_java;

public class TestNineNine {
	public static void main(String[] args) {
		// 1.Use for and while
		System.out.println("========Case 1========");
		for (int i = 1; i <= 9; i++) {
			int j = 1;
			while (j <= 9) {
				System.out.print(i + "*" + j + "=" + i * j + "\t");
				j++;
			}
			System.out.println();
		}
		// 2. Use for and doWhile
		System.out.println("========Case 2========");
		for (int i = 1; i <= 9; i++) {
			int j = 1;
			do {
				System.out.print(i + "*" + j + "=" + i * j + "\t");
			} while (j++ < 9);
			System.out.println();
		}
		// 3. Use while and doWhile
		System.out.println("========Case 3========");
		int i = 1;
		while (i <= 9) {
			int j = 1;
			do {
				System.out.print(i + "*" + j + "=" + i * j + "\t");
			} while (j++ < 9);
			System.out.println();
			i++;
		}
	}
}
