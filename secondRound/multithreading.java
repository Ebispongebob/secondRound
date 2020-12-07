package WestTwo2020.secondRound;

public class multithreading {
    public static void main(String[] args) throws InterruptedException {

        long sum = 0;

        //创建十个线程start
        MyThread[] threads = new MyThread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new MyThread(100000000 * i);
            threads[i].start();
        }

        //每个线程得到的答案
        for (int i = 0; i < 10; i++) {
            threads[i].join();
//            System.out.println(i+". "+threads[i].toString());
        }

        //将十个线程的答案相加
        for (MyThread myThread : threads) {
            sum += myThread.getAns();
        }

        //答案
        //327813115672186884
        System.out.println(sum);

    }

    public static class MyThread extends Thread {
        private long ans;
        private long i;
        private static long counter = 100000000;
        private long j;

        public MyThread(long i) {
            this.i = i;
            this.j = counter;
            counter += +100000000;
        }

        public long getAns() {
            return ans;
        }

        @Override
        public void run() {

            int x = 9;
            long idx = i;
            for (; idx < j; idx++) {
                if (contain(idx, x)) ans += idx;
            }
        }

        private boolean contain(long num, int x) {
            return String.valueOf(num).contains(String.valueOf(x));
        }

        @Override
        public String toString() {
            return "answer= "+ans;
        }
    }
}