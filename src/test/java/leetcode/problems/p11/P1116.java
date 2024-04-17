package leetcode.problems.p11;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author zhanglei
 * @version 2021/7/29
 * @link https://leetcode.com/problems/print-zero-even-odd/
 */
public class P1116 {
    public static void main(String[] args) {
        IntConsumer intConsumer = System.out::print;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(4);
        Thread a =
                new Thread(
                        () -> {
                            try {
                                zeroEvenOdd.zero(intConsumer);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
        a.setName("A");
        Thread b =
                new Thread(
                        () -> {
                            try {
                                zeroEvenOdd.even(intConsumer);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
        b.setName("B");
        Thread c =
                new Thread(
                        () -> {
                            try {
                                zeroEvenOdd.odd(intConsumer);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
        c.setName("C");

        a.start();
        b.start();
        c.start();
    }
}

class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    Semaphore zeroRun = new Semaphore(1);
    Semaphore evenRun = new Semaphore(0);
    Semaphore oddRun = new Semaphore(0);
    volatile int i = 0;

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            zeroRun.acquire();
            i++;
            if (i > n) {
                evenRun.release();
                oddRun.release();
                break;
            }
            printNumber.accept(0);
            if (i % 2 == 0) {
                evenRun.release();
            } else {
                oddRun.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            evenRun.acquire();
            if (i > n) {
                break;
            }
            printNumber.accept(i);
            zeroRun.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            oddRun.acquire();
            if (i > n) {
                break;
            }
            printNumber.accept(i);
            zeroRun.release();
        }
    }
}
