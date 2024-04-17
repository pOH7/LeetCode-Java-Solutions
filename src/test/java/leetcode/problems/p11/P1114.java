package leetcode.problems.p11;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @link https://leetcode.com/problems/print-in-order/
 * @link https://stackoverflow.com/questions/44512768/java-semaphore-cause-deadlock-on-multithread
 * @author zhanglei
 * @version 2021/7/26
 */
public class P1114 {

    public static void main(String[] args) throws Exception {

        //    }
        //    @Test
        //    void test() throws Exception {
        CountDownLatch latch = new CountDownLatch(3);
        Foo foo = new Foo();
        Thread b =
                new Thread(
                        () -> {
                            try {
                                foo.second(() -> System.out.println("second"));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                System.out.println("second finally");
                                latch.countDown();
                            }
                        });
        b.setName("b");
        Thread a =
                new Thread(
                        () -> {
                            try {
                                foo.first(() -> System.out.println("first"));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                System.out.println("first finally");
                                latch.countDown();
                            }
                        });
        a.setName("a");
        Thread c =
                new Thread(
                        () -> {
                            try {
                                foo.third(() -> System.out.println("third"));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } finally {
                                System.out.println("third finally");
                                latch.countDown();
                            }
                        });
        c.setName("c");
        c.start();
        b.start();
        Thread.sleep(1000L * 5);
        a.start();
        latch.await();
    }
}

// class Foo {
//
//    private final Semaphore first = new Semaphore(0);
//    private final Semaphore second = new Semaphore(0);
//
//
//    public Foo() {
//
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//        first.release();
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        first.acquire();
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//        second.release();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        second.acquire();
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }
// }

@Slf4j
class Foo {

    private final Semaphore semaphore = new Semaphore(0);

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore.release();
        log.info("semaphore.release");
    }

    public void second(Runnable printSecond) throws InterruptedException {
        log.info("semaphore.acquire");
        semaphore.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore.release(2);
        log.info("semaphore.release");
    }

    public void third(Runnable printThird) throws InterruptedException {
        log.info("semaphore.acquire");
        semaphore.acquire(2);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
