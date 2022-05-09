import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class HomeWorkWeek10 {
    public static void main(String[] args) {
        HomeWorkWeek10 hw10 = new HomeWorkWeek10();
        hw10.question1();
        hw10.question2();
        hw10.question3();
    }

    /*
     *  請設計一隻程式，用亂數產生5個介於1~100之間的整數，而輸出結果可以判斷出這5個整數為是否為質數 (提示:Math類別)
     */
    void question1() {
        NextNumber:
        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * 100 + 1);
            int randomSqrt = (int) Math.sqrt(random);
            for (int j = 2; j <= randomSqrt; j++) {
                if (random % j == 0) {
                    System.out.println(random + "不是質數");
                    continue NextNumber;
                }
            }
            System.out.println(random + "是質數");
        }
    }

    /*
    請設計一隻程式，讓使用者可以輸入一個任意數後，可以選擇要以下列何種表示方法顯示(1)千分位(2)百分比(3)科學記號，而輸入非任意數會顯示提示訊息
    (提示: TestFormatter.java, Java API 文件, 判斷數字可用正規表示法)
     */
    void question2() {
        String in = "";
        double number = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入數字：");
        End:
        while (sc.hasNext()) {
            in = sc.next();
            if (in.matches("^\\d+[.]?\\d*$")) {
                System.out.print("格式化成(1)千分位(2)百分比(3)科學記號：");
                number = Double.parseDouble(in);
                while (sc.hasNextInt()) {
                    int format = sc.nextInt();
                    NumberFormat nf;
                    switch (format) {
                        case 1:
                            nf = new DecimalFormat(",000");
                            System.out.println(nf.format(number));
                            break End;
                        case 2:
                            nf = new DecimalFormat("0.0%");
                            System.out.println(nf.format(number));
                            break End;
                        case 3:
                            nf = new DecimalFormat("0.00E0");
                            System.out.println(nf.format(number));
                            break End;
                        default:
                            System.out.println("請再輸入一次(1)千分位(2)百分比(3)科學記號！");
                            break;
                    }
                }
                break;
            } else {
                System.out.println("數字格式不正確，請再輸入一次：");
            }
        }
        sc.close();
    }

    /*
    請設計一隻程式，讓使用者輸入日期(年月日，例如:20110131)後，可以轉成想要的輸出格式化成(1) 年/月/日(2)月/日/年(3)日/月/年三選一
     */
    final int YEAR = 0;
    final int MONTH = 1;
    final int DAY = 2;

    void question3() {
        String in;
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入日期年月日(例如20220509): ");
        End:
        while (sc.hasNext()) {
            in = sc.next();
            if (in.matches("^\\d{8}$")) {
                int[] date = {
                        Integer.parseInt(in.substring(0, 4)),
                        Integer.parseInt(in.substring(4, 6)),
                        Integer.parseInt(in.substring(6, 8))
                };
                if (VerifyDate(date)) {
                    System.out.print("欲格式化成(1)年/月/日(2)月/日/年(3)日/月/年：");
                    while (sc.hasNextInt()) {
                        int format = sc.nextInt();
                        switch (format) {
                            case 1:
                                System.out.printf("%d/%d/%d%n", date[YEAR], date[MONTH], date[DAY]);
                                break End;
                            case 2:
                                System.out.printf("%d/%d/%d%n", date[MONTH], date[DAY], date[YEAR]);
                                break End;
                            case 3:
                                System.out.printf("%d/%d/%d%n", date[DAY], date[MONTH], date[YEAR]);
                                break End;
                            default:
                                System.out.println("請再輸入一次欲格式化形式！");
                                break;
                        }
                    }
                    break;
                }
            }
            System.out.println("日期格式不正確，請再輸入一次！");
        }
    }

    /*
    Reference from Homework4
    */
    public boolean VerifyDate(int[] date) {
        GregorianCalendar cal = new GregorianCalendar();
        boolean leapYear = cal.isLeapYear(date[YEAR]);
        if (date[MONTH] > 12) {
            System.out.println("請輸入正確的月份");
            return false;
        } else if ((date[MONTH] % 2 == 1 || date[MONTH] == 8) && date[DAY] > 31) {
            System.out.println("請輸入合法的日期");
            return false;
        } else if (date[MONTH] % 2 == 0 && date[MONTH] != 8 && date[DAY] > 30) {
            System.out.println("請輸入合法的日期");
            return false;
        } else if (!leapYear && date[MONTH] == 2 && date[DAY] > 28) {
            System.out.println("請輸入合法的日期");
            return false;
        } else if (leapYear && date[MONTH] == 2 && date[DAY] > 29) {
            System.out.println("請輸入合法的日期");
            return false;
        }
        return true;
    }
}
