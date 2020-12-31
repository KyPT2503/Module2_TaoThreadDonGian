import java.sql.SQLOutput;

public class Solution {
    public static void main(String[] args) {
        Thread firstThread = new Thread(new NumberGenerator(1));
        Thread secondThread = new Thread(new NumberGenerator(2));
        /*Thread thirdThread = new Thread(new NumberGenerator(3));*/
        secondThread.setPriority(Thread.MAX_PRIORITY);
        firstThread.start();
        secondThread.start();
    }
}

class NumberGenerator implements Runnable {
    private int n;

    public NumberGenerator(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "_" + this.n);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
