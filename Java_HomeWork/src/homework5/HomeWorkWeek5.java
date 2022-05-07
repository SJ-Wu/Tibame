package homework5;
import java.util.Scanner;
public class HomeWorkWeek5 {
    public static void main(String[] args) {
        int[][] intArray = {
            {1, 6, 3},
            {9, 5, 2}
        };
        double[][] doubleArray = {
            {1.2, 3.5, 2.2},
            {7.4, 2.1, 8.2}
        };
        HomeWorkWeek5 hw = new HomeWorkWeek5();
        System.out.println("======== 1. ========");
        hw.starSquare();
        System.out.println("======== 2. ========");
        hw.randAvg();
        System.out.println("======== 3. ========");
        System.out.println(hw.maxElement(intArray));
        System.out.println(hw.maxElement(doubleArray));
        System.out.println("======== 5. ========");
//        for (int i = 0; i < 30; i++) 
        {
            hw.genAuthCode();
        }
    }
    public void starSquare() { 
        int[] side = new int[2];
        System.out.println("請輸入寬與高");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) side[0] = sc.nextInt();
        if (sc.hasNextInt()) side[1] = sc.nextInt();
        //System.out.println(side[0] + side[1]);
        for (int i = 0; i < side[1]; i++) {
            for (int j = 0; j < side[0]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
    public void randAvg(){
        System.out.println("本次亂數結果：");
        double avg = 0;
        for (int i = 0; i < 10; i++) {
            int num = (int)(Math.random() * 101);
            System.out.print(num + " ");
            avg += num;
        }
        System.out.println();
        System.out.println((int)(avg / 10));
    }
    public int maxElement(int x[][]) {
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                if (maxNum < x[i][j]) {
                    maxNum = x[i][j];
                }
            }
        }
        return maxNum;
    }
    public double maxElement(double x[][]) {
        double maxNum = Double.MIN_VALUE;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                if (maxNum < x[i][j]){
                    maxNum = x[i][j];
                }
            }
        }
        return maxNum;
    }
    public void genAuthCode() {
    	char[] captcha = new char[8];
    	// 字串長度8碼，英文大小寫加數字
    	int pwCnt = 0;
    	genCode:
    	while(pwCnt < 8) {
    		// step1. 決定產生數字還是英文
    		char temp = genRandWord((int)(Math.random() * 3));
    		// step2. 檢查有無重複
    		if (pwCnt == 0) {
    			captcha[pwCnt] = temp;
    		} else {
        		for (int i = 0; i < captcha.length; i++) {
        			if (captcha[i] == temp) {
        				continue genCode;
        			}
        		}
        		captcha[pwCnt] = temp;
    		}
    		pwCnt++;
    	}
    	System.out.print("本次隨機產生的驗證碼為: ");
    	for (int i = 0 ; i < captcha.length; i++) {
    		System.out.print(captcha[i]);
    	}
    	System.out.println();
    }
    char genRandWord(int type) {
    	char word = 0;
    	switch (type) {
		case 0: // 0 to 9: 48~57
			word = (char)(int)((Math.random() * 10) + 48);
			break;
		case 1: // A to Z : 65~90
			word = (char)(int)((Math.random() * 26) + 65);
			break;
		case 2: // a to z: 97~122
			word = (char)(int)((Math.random() * 26) + 97);
			break;
		}
    	return word;
    }
}
