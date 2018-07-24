package com.rit.parallel;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//import java.util.concurrent.Lock;
public class MyLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter counter = new Counter();
		final ReentrantLock lock = new ReentrantLock();
		for (int i = 0; i < 5; i++) {
			MyLockExample a = new MyLockExample(counter, lock);
			Thread thread = new Thread(a);
			thread.start();

		}
	}

}

class Counter {
	int count = 0;

	public void increment() {
		count++;
	}

	public int getCounter() {
		return count;
	}
}

class MyLockExample implements Runnable {
	ReentrantLock  lock;
	Counter counter;

	public MyLockExample(Counter thatcounter, ReentrantLock thatlock) {
		lock = thatlock;
		counter = thatcounter;
	}

	public int incrementCount() {

		try {

			lock.lock();
			counter.increment();
			Thread.sleep(1000);

		} catch (Exception exp) {
			exp.printStackTrace();

		} finally {
			System.out.println(counter.getCounter());
			lock.unlock();
			
		}
		return counter.getCounter();
	}

	public void run() {

		int c = this.incrementCount();

	}

}