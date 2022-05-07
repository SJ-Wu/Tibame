import java.util.Scanner;

public class HomeWorkWeek4 {
    final int YEAR = 0;
    final int MONTH = 1;
    final int DAY = 2;
    public static void main(String[] args) {
        HomeWorkWeek4 hw = new HomeWorkWeek4();
        // 1. 請寫出一隻程式能輸出此陣列所有元素的平均值與大於平均值的元素
        System.out.println("========1. 輸出此陣列所有元素的平均值與大於平均值的元素 ========");
        hw.question1();
        // 2. 請建立一個字串，經過程式執行後，輸入結果是反過來的
        System.out.println("========2. 請建立一個字串，經執行後，輸入結果是反過來的 ========");
        hw.question2();
        // 3. 請用程式計算出這陣列裡面共有多少個母音(a, e, i, o, u)
        System.out.println("========3. 請用計算出這陣列共有多少個母音(a,e,i,o,u)  ========");
        hw.question3();
        // 4. 請設計一個程式,可以讓阿文輸入欲借的金額後,便會顯示哪些員工編號的同事 有錢可借他;並且統計有錢可借的總人數
        System.out.println("========4. 讓阿文輸入欲借的金額後,顯示哪些員工編號的同事有錢可借他，並且統計有錢可借的總人數 ========");
        hw.question4();
        // 5. 請設計由鍵盤輸入三個整數，分別代表西元yyyy年，mm月，dd日，執行後會顯示是該年的第幾天
        System.out.println("========5. 請設計由鍵盤輸入三個整數，分別代表西元yyyy年，mm月，dd日，執行後會顯示是該年的第幾天  ========");
        hw.question5();
        // 6. 請算出每位同學考最高分的次數
        System.out.println("========6. 請算出每位同學考最高分的次數 ========");
        hw.question6();

    }

    public void question1() {
        int[] arr = {29, 100, 39, 41, 50, 8, 66, 77, 95, 15};
        double arrAvg;
        int arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
        } 
        arrAvg = arrSum / arr.length;
        System.out.println("The average is " + arrAvg);
        System.out.print("The elements over average are: ");
        for (int item: arr) {
            if (item > arrAvg) {
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }

    public void question2() {
        String str = "Hello World";
        String disOrder = "";
        for (int i = 0; i < str.length(); i++) {
            disOrder += str.charAt(str.length()- i - 1);
        }
        System.out.println(str + " -> " + disOrder);
    }

    public void question3() {
        String[] planets = {"mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune"};
        String vowels = "aeiou";
        int vowelsCount = 0;
        for (String planet: planets) {
            for (int i = 0; i < planet.length(); i++) {
                for (int j = 0; j < vowels.length(); j++) {
                    char planetChar = planet.charAt(i);
                    if (planetChar == vowels.charAt(j)) {
                        vowelsCount++;
                        break;
                    }
                }
            }
        }
        System.out.println("The total vowel counts in the names of planet are " + vowelsCount);
    }

    public void question4() {
        final int COLLEAGUE_ID = 0;
        final int COLLEAGUE_CASH = 1;

        int[][] colleaguesInfos= {
            {25, 32, 8, 19, 27},
            {2500, 800, 500, 1000, 1200}
        };
        int needMoney = 0;
        int richManCnt = 0;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            needMoney = sc.nextInt();
        }
        System.out.print("有錢可借的員工編號：");
        for (int i = 0; i < colleaguesInfos[COLLEAGUE_ID].length; i++) {
            int money = colleaguesInfos[COLLEAGUE_CASH][i];
            if (money >= needMoney) {
                System.out.print(colleaguesInfos[COLLEAGUE_ID][i] + " ");
                richManCnt++;
            }
        }
        System.out.println("共" + richManCnt + "人！");
    }
    public void question5() {
        Scanner sc = new Scanner(System.in);
        int[] date = new int[3];
        int totalDays = 0;
        int d = 0;
        boolean leapYear = false;
        while(d < 3) {
            if (sc.hasNextInt()) date[d] = sc.nextInt();
            if (date[d] < 0 || date[MONTH] > 12) {
                System.out.println("請輸入合法的資料");
                return;
            }
            d++;
        }
        if ((date[YEAR] % 4 == 0 && date[YEAR] % 100 != 0) || (date[YEAR] % 400 == 0)) {
            leapYear = true;
        }

        if (!validDate(date, leapYear)) return;

        for (int i = 1; i < date[MONTH]; i++) {
            int monthDays = 0;
            if (i % 2 == 1 || i == 8) {
                monthDays = 31;
            } else if (i % 2 == 0 && i != 2 && i != 8) {
                monthDays = 30;
            } else if (i == 2 && leapYear) {
                monthDays = 29;
            } else {
                monthDays = 28;
            }
            // System.out.println(i + " " + monthDays);
            totalDays += monthDays;
        }
        totalDays += date[DAY];
        System.out.println("輸入的日期為該年第" + totalDays + "天");
    }

    public boolean validDate(int[] date, boolean leapYear) {
        if ((date[MONTH] % 2 == 1 || date[MONTH] == 8) && date[DAY] > 31) {
            System.out.println("請輸入合法的資料");
            return false;
        } else if (date[MONTH] % 2 == 0 && date[MONTH] != 8 && date[DAY] > 30) {
            System.out.println("請輸入合法的資料");
            return false;
        } else if (!leapYear && date[MONTH] == 2 && date[DAY] > 28) {
            System.out.println("請輸入合法的資料");
            return false;
        } else if (leapYear && date[MONTH] == 2 && date[DAY] > 29) {
            System.out.println("請輸入合法的資料");
            return false;
        }
        return true;
    }
    public void question6() {
        int[][] scoreList = {
            {10,  35, 40,  100, 90, 85, 75, 70},
            {37,  75, 77,  89,  64, 75, 70, 95}, 
            {100, 70, 79,  90,  75, 70, 79, 90}, 
            {77,  95, 70,  89,  60, 75, 85, 89},
            {98,  70, 89,  90,  75, 90, 89, 90},
            {90,  80, 100, 75,  50, 20, 99, 75}
        };
        int[] times1st = {0,0,0,0,0,0,0,0};
        for (int i = 0; i < scoreList.length; i++) {
            int highestScore = 0;
            int studentID = -1;
            for (int j = 0; j < scoreList[i].length; j++) {
                if (scoreList[i][j] > highestScore) {
                    highestScore = scoreList[i][j];
                    studentID = j;
                }
            }
            times1st[studentID]++;
        }
        System.out.println("每位同學考最高分的次數如下：");
        for (int i = 0; i < times1st.length; i++) {
            System.out.println(i+1 + "號同學考最高分" + times1st[i] + "次");
        }
    }
}
