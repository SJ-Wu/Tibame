public class HomeWorkWeek1 {
    public static void main (String[] args) {
        //======== #1 ========
        int sum = 12 + 6;
        double product = 12 * 6;

        System.out.printf("#1. The sum of 12 and 6 is %d and the product of 12 and 6 is %.0f\n", sum, product); 
        //======== #2 ========
        int dozen = 200 / 12;
        int mod = 200 % 12;   

        System.out.printf("#2. 200 eggs is %d dozens and %d eggs\n", dozen, mod);
        //======== #3 ========
        int totalSeconds = 256559;
        int days = totalSeconds / (60 * 60 * 24);
        int remainSeconds = totalSeconds % (60 * 60 * 24);
        int hours =  remainSeconds / (60 * 60);
        remainSeconds = remainSeconds % (60 * 60);
        int minutes = remainSeconds / 60;
        remainSeconds = remainSeconds % 60;

        System.out.printf("#3. %d seconds is %d days, %d hours, %d minutes and %d seconds\n", totalSeconds, days, hours, minutes, remainSeconds);
        //======== #4 ========
        final double PI = 3.1415;
        int radius = 5;
        double perimeter = 2 * PI * radius;
        double area = PI * radius * radius;

        System.out.printf("#4. The circle raius is %d, Perimeter is %.4f, area is %.4f\n", radius, perimeter, area);  
        //======== #5 ========  
        double totalMoney = 1500000;
        double rate = 0.02;
        int years = 10;
        for (int i = 0; i < 10; i++) {
            totalMoney = (int)(totalMoney * (1+rate));
        }
        
        System.out.printf("#5. After 10 years, you have %.0f now.\n", totalMoney);
        //======== #6 ========  
        System.out.println("========================");
        System.out.println(5 + 5);   // 1. 兩個5都是整數類別，直接相加後顯示整數10
        System.out.println(5 + '5'); // 2. 字元'5'的ascii code值是53, 當整數與字元相加時, 字元被轉態為整數行別後相加, 相加後顯示整數58
        System.out.println((char)(5 + '5')); // 2.1 試著再將int轉型成char後顯示ascii 字元':'
        System.out.println(5 + "5"); // 3. 整數5直接被轉成字串'5'後成為字串串連
    }
}