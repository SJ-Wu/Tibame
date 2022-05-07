import java.math.BigInteger;
import java.util.*;

public class HomeWorkWeek8 {
    public static void main(String[] args) {
        HomeWorkWeek8 hw8 = new HomeWorkWeek8();
        System.out.println("========Question1========");
        hw8.question1();
        System.out.println("\n========Question2========");
        Train[] trains = {
                new Train(202, "普悠瑪", "樹林", "花蓮", 400),
                new Train(1254, "區間", "屏東", "基隆", 700),
                new Train(118, "自強", "高雄", "台北", 500),
                new Train(1288, "區間", "新竹", "基隆", 400),
                new Train(122, "自強", "台中", "花蓮", 600),
                new Train(1222, "區間", "樹林", "七堵", 300),
                new Train(1254, "區間", "屏東", "基隆", 700)
        };
        hw8.question2(trains);
    }

    void question1() {
        //請建立一個Collection物件並將以下資料加入:
        // Integer(100)、Double(3.14)、Long(21L)、Short("100")、Double(5.1)、
        //"Kitty"、Integer(100)、Object物件、"Snoopy"、BigInteger("1000")
        List lists = new ArrayList();
        lists.add(new Integer(100));
        lists.add(new Double(3.14));
        lists.add(new Long(21L));
        lists.add(new Short("100"));
        lists.add(new Double(5.1));
        lists.add("Kitty");
        lists.add(new Integer(100));
        lists.add(new Object());
        lists.add("Snoopy");
        lists.add(new BigInteger("1000"));
        // 印出這個物件裡的所有元素(使用Iterator, 傳統for與foreach)
        // 1. Iterator
        System.out.print("Iterator: ");
        Iterator it = lists.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
        System.out.println();
        System.out.print("For-loop: ");
        // 2. for loop
        for (int i = 0; i < lists.size(); i++) {
            System.out.print(lists.get(i) + ", ");
        }
        System.out.println();
        System.out.print("For-each: ");
        // 3. for-each
        for (Object item : lists) {
            System.out.print(item + ", ");
        }
        System.out.println();
        // 移除不是java.lang.Number相關的物件
        // 1. 記錄不是number的物件
        List notNums = new ArrayList();
        for (int i = 0; i < lists.size(); i++) {
            if (!(lists.get(i) instanceof Number)) {
                notNums.add(lists.get(i));
            }
        }
        // 2. 將list中不是number的物件刪除
        for (Object item : notNums) {
            lists.remove(item);
        }
        // 再次印出這個集合物件的所有元素，觀察是否已將非Number相關的物件移除成功
        System.out.print("Remove non-number objects: ");
        for (Object item : lists) {
            System.out.print(item + ", ");
        }
    }

    void question2(Train[] trains) {
        System.out.println("// 1. 請寫一隻程式，能印出不重複的Train物件");
        Set<Train> setTrain = new HashSet<>();
        for (Train t : trains) {
            setTrain.add(t);
        }
        Iterator<Train> it = setTrain.iterator();
        while (it.hasNext()) {
            it.next().getTrainInfo();
        }
        System.out.println("// 2. 請寫一隻程式，讓Train物件印出時，能以班次編號由大到小印出");
        List<Train> listTrain = new ArrayList<>();
        for (Train t : trains) {
            listTrain.add(t);
        }
        Collections.sort(listTrain);
        for (int i = 0; i < listTrain.size(); i++) {
            listTrain.get(i).getTrainInfo();
        }
        System.out.println("// 3. 不僅能讓班次編號由大排到小印出， 還可以不重複印出Train物件");
        Set<Train> treeSetTrain = new TreeSet<>();
        for (Train t : trains) {
            treeSetTrain.add(t);
        }
        for (Train t : treeSetTrain) {
            t.getTrainInfo();
        }
    }
}

class Train implements Comparable<Train> {
    private int number;
    private String type;
    private String start;
    private String dest;
    private double price;

    Train(int number, String type, String start, String dest, double price) {
        setTrainInfo(number, type, start, dest, price);
    }

    void setTrainInfo(int number, String type, String start, String dest, double price) {
        this.number = number;
        this.type = type;
        this.start = start;
        this.dest = dest;
        this.price = price;
    }

    void getTrainInfo() {
        System.out.println("車次: " + number + "\t車種: " + type + "\t起站: " + start + "\t迄站: " + dest + "\t票價: " + price);
    }

    public int compareTo(Train train) {
        if (this.number > train.number) {
            return -1;
        } else if (this.number == train.number) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj != null && obj.getClass() == this.getClass()) {
            Train t = (Train) obj;
            return (t.number == this.number && t.type.equals(this.type) && t.start.equals(this.start) && t.dest.equals(this.dest) && t.price == this.price);
        }
        return false;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = result * prime + number;
        result = result * prime + (int) price;
        result = result * prime + ((type != null) ? type.hashCode() : 0);
        result = result * prime + ((start != null) ? start.hashCode() : 0);
        result = result * prime + ((dest != null) ? dest.hashCode() : 0);
        return result;
    }
}
