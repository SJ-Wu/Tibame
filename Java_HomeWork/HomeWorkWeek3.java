import java.util.Scanner;
import java.util.Arrays;

public class HomeWorkWeek3 {
    public static void main(String[] args) {
        HomeWorkWeek3 hw = new HomeWorkWeek3();
        hw.Problem1();
        hw.problem2();
        hw.problem3();

    }

    public void Problem1() {
        // Get lengths from user.
        int[] lengths = new int[3];
        System.out.println("請輸入三個整數：");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            lengths[i] = sc.nextInt();
        }

        // 1. Verify the lengths to check if it is a triangle.
        if (isTriangle(lengths)){
            // 2. Check triangle type
            triangleType(lengths);
        } else {
            System.out.println("不是三角形");
        }
    }
    
    public boolean isTriangle(int[] side) {
        int[] sortSide = Arrays.copyOf(side, side.length);
        Arrays.sort(sortSide);
        return ((sortSide[0] > sortSide[2] - sortSide[1]) && (sortSide[0] < sortSide[1] + sortSide[2]));
    }

    public void triangleType(int[] side) {
        if (side[0] == side[1] && side[1] == side[2]) {
            System.out.println("正三角形");
        } else if (side[0] == side[1] || side[1] == side[2] || side[0] == side[2]) {
            System.out.println("等腰三角形");
        } else {
            int[] powSide = new int[3];
            // take squares from the sides
            for (int i = 0; i < 3; i++) {
                powSide[i] = side[i] * side[i];
            }
            Arrays.sort(powSide); // to sort the pows for easily calculating
            if (powSide[0] + powSide[1] == powSide[2]) {
                System.out.println("直角三角形");
            } else {
                System.out.println("其他三角形");
            }
        }
    }

    public void problem2() {
        int answer = (int)(Math.random() * 100);
        // System.out.println("開始猜數字吧(" + answer + ")"); // GM mode
        System.out.println("開始猜數字吧");
        Scanner sc = new Scanner(System.in);
        int quess;
        do {
            quess = sc.nextInt();
            if (quess == answer) {
                System.out.println("答對了，答案就是" + answer + "!");
            } else {
                String str = (quess > answer) ? "大於正確答案" : "小於正確答案";
                System.out.println("猜錯囉，" + str);
            }
        } while(quess != answer);
    }

    public void problem3() {
        int[] goodChoice = new int[49];
        System.out.println("阿文...請輸入你討厭的數字");
        Scanner sc = new Scanner(System.in);
        int hateNum = sc.nextInt();
        int count = 0;
        for (int i = 1; i <= 49; i++) {
            int tens = i / 10;   // get tens of the number
            int digits = i % 10; // get digits of the number
            if (tens != hateNum && digits != hateNum) {
                goodChoice[count] = i; // add to the filter list
                System.out.print(i + "\t");
                count++;
            }
            if (count % 6 == 0) System.out.println();
        }
        System.out.println("總共有"+ count + "個數字可選");
        System.out.print("你的幸運數字是: ");
        // Get 6 number to buy
        int countDown = 0; // To count how many number you have chosed
        int[] luckyNumbers = new int[6]; // Pick 6 lucky number to buy
        getNewNumber:
        while (countDown < 6) {
            int random = (int)(Math.random()*count);
            if (countDown != 0) { // Do need to compare the first picked.
                for (int i = 0; i < countDown; i++) {
                    // Do not choose the same number
                    if (luckyNumbers[i] == goodChoice[random]) {
                        continue getNewNumber; // return to the while loop
                    }
                }
            }
            luckyNumbers[countDown] = goodChoice[random]; // Add the lucky number to list
            System.out.print(luckyNumbers[countDown] + "\t");
            countDown++;
        }
        System.out.println();
    }
}