package leetcode.problems.p11;

import java.util.concurrent.Semaphore;

/**
 * @link https://leetcode.com/problems/print-foobar-alternately
 * @author zhanglei
 * @version 2021/7/28
 */
public class P1115 {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);
        Thread a =
                new Thread(
                        () -> {
                            try {
                                fooBar.foo(() -> System.out.println("foo"));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
        a.setName("A");

        Thread b =
                new Thread(
                        () -> {
                            try {
                                fooBar.bar(() -> System.out.println("bar"));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
        b.setName("B");

        a.start();
        b.start();
    }
}

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    Semaphore fooRun = new Semaphore(1);
    Semaphore barRun = new Semaphore(0);

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooRun.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barRun.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barRun.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooRun.release();
        }
    }
}
