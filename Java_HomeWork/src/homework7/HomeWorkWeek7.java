package homework7;

import java.io.*;

public class HomeWorkWeek7 {

    public static void main(String[] args) {
        HomeWorkWeek7 hw7 = new HomeWorkWeek7();
        try {
            System.out.println("請寫一個程式讀取這個Sample.txt檔案，並輸出以下訊息: Sample.txt檔案共有xxx個位元組，yyy個字元，zzz列資料");
            hw7.question1();
            System.out.println("請寫一隻程式，能夠亂數產生10個1~1000的整數，並寫入一個名為Data.txt的檔案裡 (請使用 append功能讓每次執行結果都能被保存起來)");
            hw7.question2();
            System.out.println("請從無到有試著完成一個方法名為copyFile，這個方法有兩個參數。呼叫此方法時，第一個參數所 代表的檔案會複製到第二個參數代表的檔案");
            hw7.question3();
            System.out.println("請寫一支程式，利用老師提供的Dog與Cat類別分別產生兩個物件，寫到C:\\data\\Object.ser裡。注意物件寫入需注意的事項，若C:\\內沒有data資料夾，請用程式新增這個資料夾");
            hw7.question4();
        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();
        }

    }

    void question1() throws IOException {
        // 1. Create a file constructor and load file
        File file = new File("/Users/coder/TibameGit/Java_HomeWork/file/Sample.txt");
        // 2. Check if the file exists
        if (file.exists()) {
            long bytesOfFile = file.length();
            System.out.println("1. The bytes of the file are " + bytesOfFile + ".");
            // 3. Create File Reader and buffer reader
            FileReader in = new FileReader(file);
            BufferedReader br = new BufferedReader(in);
            // 4. Add variables for counting data. cnt: counting chars, lines: counting lines in the text.
            int cnt = 0, lines = 0;
            String str;
            while ((str = br.readLine()) != null) {
                cnt += str.length();
                lines++;
            }
            System.out.println("2. The count of the chars is " + cnt + ".");
            System.out.println("3. There are " + lines + " lines.");
            br.close();
            in.close();
        } else {
            System.err.println("The file does not exist.");
        }
    }

    void question2() throws IOException {
        // 1. Get 10 random numbers between 1 to 1000
        // 2. Create a file
        File file = new File("/Users/coder/TibameGit/Java_HomeWork/file/Data.txt");
        FileWriter out = new FileWriter(file, true); // Set append flag
        BufferedWriter bw = new BufferedWriter(out);
        PrintWriter pw = new PrintWriter(bw);
        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 1000 + 1);
            pw.print(num + " ");
            System.out.print(num + " ");
        }
        System.out.println();
        pw.println();
        pw.close();
        bw.close();
        out.close();
    }

    void question3() throws IOException {
        File src = new File("/Users/coder/TibameGit/Java_HomeWork/file/lenna.jpeg");
        File destination = new File("/Users/coder/TibameGit/Java_HomeWork/file/copy.jpeg");
        CopyFile(src, destination);
        System.out.println("Copy data completed.");
    }

    void CopyFile(File src, File destination) throws IOException {
        // 1. Get Reader and Writer
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(destination);
        // 2. Get RW buffer
        BufferedInputStream br = new BufferedInputStream(in);
        BufferedOutputStream bw = new BufferedOutputStream(out);
        // 3. Copy data
        int c;
        while ((c = br.read()) != -1) {
            bw.write(c);
        }
        bw.flush();
        // 4. Close IO stream
        bw.close();
        br.close();
        out.close();
        in.close();
    }

    void question4() throws IOException, ClassNotFoundException {
        ObjectWrite();
        ObjectRead();
    }

    void ObjectWrite() throws IOException {
        Animal[] obj = new Animal[2];
        obj[0] = new Dog("Kevin");
        obj[1] = new Cat("Kitty");
        //TODO: Need to implement adding directory "data" if not found.
        File file = new File("/Users/coder/TibameGit/Java_HomeWork/data", "Object.ser");
        System.out.println(file.getName());
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        // Write object
        for (Object o : obj) {
            oos.writeObject(o);
        }
        oos.close();
        fos.close();
    }

    void ObjectRead() throws IOException, ClassNotFoundException {
        File file = new File("/Users/coder/TibameGit/Java_HomeWork/data/Object.ser");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            while (true) {
                ((Animal) ois.readObject()).speak();
                System.out.println("--------------------");
            }
        } catch (EOFException e) {
            System.out.println("資料讀取完畢！");
        }
    }
}
