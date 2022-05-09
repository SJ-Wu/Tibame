public class HomeWorkWeek9 {
    public static void main(String[] args) {
        HomeWorkWeek9 hw9 = new HomeWorkWeek9();
//        hw9.question1();
        hw9.question2();
    }

    void question1() {
        Candidate[] cd = {
                new Candidate("饅頭人"),
                new Candidate("詹姆士")
        };
        for (int i = 0; i < cd.length; i++) {
            cd[i].start();
        }
        System.out.println("----大胃王快食比賽開始！----");
        Candidate.ready = true;
        try {
            cd[0].join();
            cd[1].join();
        } catch (InterruptedException ie) {
        }
        System.out.println("----大胃王快食比賽結束！----");
    }

    void question2() {
        BankCount bank = new BankCount(0);
        Mom mom = new Mom(bank);
        Son son = new Son(bank);

        mom.start();
        son.start();
    }
}

class Candidate extends Thread {
    public static boolean ready = false;

    Candidate(String name) {
        super(name);
    }

    public void run() {
        while (!ready) ;
        for (int count = 1; count <= 10; count++) {
            try {
                int time = (int) (Math.random() * 2500 + 500);
                Thread.sleep(time);
                System.out.println(getName() + "吃第" + count + "碗飯！");
            } catch (Exception e) {
            }
        }
        System.out.println(getName() + "吃完了！");
    }
}

class BankCount {
    private int saving = 0;

    public BankCount(int amount) {
        saving += amount;
    }

    synchronized public void deposit(int amount) throws InterruptedException {
        while (saving > 3000) {
            System.out.println("媽媽看到餘額在3000以上，暫停匯款");
            wait();
        }
        saving += amount;
        System.out.println("媽媽存了2000，帳戶共有" + saving);
        notify();
    }

    synchronized public void withdraw(int amount) throws InterruptedException {
        while (saving == 0) {
            System.out.println("熊大看到帳戶沒錢，暫停提款");
            wait();
        }
        saving -= amount;
        System.out.println("熊大領了1000，帳戶共有" + saving);
        if (saving <= 2000) {
            System.out.println("熊大看到餘額在2000以下，要求匯款");
            notify();
        }
    }
}

class Mom extends Thread {
    final BankCount bank;

    public Mom(BankCount bank) {
        this.bank = bank;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (bank) {
                try {
                    bank.deposit(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

class Son extends Thread {
    final BankCount bank;

    public Son(BankCount bank) {
        this.bank = bank;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (bank) {
                try {
                    bank.withdraw(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
