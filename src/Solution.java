public class Solution {
    public static void main(String[] args) {
        /*Thread firstThread = new Thread(new NumberGenerator(1));
        Thread secondThread = new Thread(new NumberGenerator(2));
        secondThread.setPriority(Thread.MAX_PRIORITY);
        firstThread.start();
        secondThread.start();*/

        /*Thread firstThread = new Thread(new OddNumber());
        Thread secondThread = new Thread(new EvenNumber());
        firstThread.start();
        try {
            firstThread.join(2000);
        } catch (Exception e) {
            System.out.println(e);
        }
        secondThread.start();*/

        Thread lazyPrimeFactorization = new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                for (int i = 0; i < 30; i++) {
                    if (isPrimeLazy(i)) {
                        System.out.println("lazyPrimeFactorization found a prime " + i + " in " + (System.currentTimeMillis() - startTime) + " milliseconds.");
                    }
                }
            }
        });
        Thread optimizedPrimeFactorization = new Thread(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                for (int i = 0; i < 30; i++) {
                    if (isPrimeOptimized(i)) {
                        System.out.println("optimizedPrimeFactorization found a prime " + i + " in " + (System.currentTimeMillis() - startTime) + " milliseconds.");
                    }
                }
            }
        });

        optimizedPrimeFactorization.start();
        lazyPrimeFactorization.start();
    }

    private static boolean isPrimeLazy(int number) {
        boolean result = true;
        if (number < 2) result = false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) result = false;
        }
        return result;
    }

    private static boolean isPrimeOptimized(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) return false;
        }
        return true;
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

class OddNumber implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) System.out.println(i);
                Thread.sleep(10);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class EvenNumber implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 1) System.out.println(i);
                Thread.sleep(10);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
