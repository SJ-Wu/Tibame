package first_java;

public class HomeworkWeek2 {
	public static void main(String[] args) {
//===== 計算1~1000的偶數和 (2+4+6+8+...+1000)
		int sum = 0;
		for (int i = 0; i <= 1000; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
// 方法 2，從０開始累加2即可求出偶數
//		int sum = 0;
//		for (int i = 0; i <= 1000; i += 2) {
//				sum += i;
//		}
		System.out.println("1. 1~1000的偶數和＝" + sum);
		
//===== 計算1~10的連乘積 (1*2*3*...*10) (用for迴圈)
		int product = 1;
		for (int i = 1; i <= 10; i++) {
			product *= i;
		}
		System.out.println("2. (for)1~10的連乘積＝" + product);
//===== 計算1~10的連乘積 (1*2*3*...*10) (用while迴圈)
		product = 1;
		int j = 1;
		while (j <= 10) {
			product *= j++;
		}
		System.out.println("3. (while)1~10的連乘積＝" + product);
//===== 請設計一隻Java程式,輸出結果為以下:1 4 9 16 25 36 49 64 81 100
		System.out.print("4. ");
		for (int k = 1; k <= 10; k++) {
			System.out.print(k * k + " ");
		}
//方法2 其他同學的想法
/*
*  num: 1 4 9 16 25 36 49 64 81 100 
*  diff: 3 5 7 9 11 13 15 17 19 ... (2N-1)   
*/
//		int num = 1;
//		for (int i = 1; i <= 10; i++) {
//			if (i != 1) {
//				num += 2 * i - 1;
//			} 
//			System.out.print(num + " ");
//		}
 
		System.out.println();
//===== 輸出結果為阿文可以選擇的數字有哪些? 總共有幾個?
		System.out.println("5. 阿文可選擇0~49的: ");
		int digit = 0, digitTen = 0;
		int totalCount = 0;
		for (int num = 1; num <= 49; num++) {
			digit = num % 10;
			digitTen = num / 10;
			if (digit != 4 && digitTen != 4) {
				System.out.print(num + " ");
				totalCount++;
			}
		}
		System.out.println("總共有"+ totalCount+"個");
//===== 請顯示出下列數列 
//		1 2 3 4 5 6 7 8 9 10 
//		1 2 3 4 5 6 7 8 9 
//		1 2 3 4 5 6 7 8 
//		1 2 3 4 5 6 7 
//		1 2 3 4 5 6 
//		1 2 3 4 5 
//		1 2 3 4 
//		1 2 3 
//		1 2 
//		1 
		System.out.println("6. ");
		int numCount = 10;
		while (numCount >= 1) {
			int i = 1;
			while (i <= numCount) {
				System.out.print(i++ + " ");
			}
			System.out.println();
			numCount--;
		}
//===== 請顯示出下列字串 
//		A
//		BB
//		CCC
//		DDDD
//		EEEEE
//		FFFFFF
		System.out.println("7. ");
		char c = 'A';
		int charCount = 0;
		while (charCount < 6) {
			for (int i = 0; i < charCount + 1; i++) {
				System.out.print((char) (c + charCount));
			}
			System.out.println();
			charCount++;
		}
	}

}
