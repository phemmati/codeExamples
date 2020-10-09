package concurrency.waitNotify;

import java.util.Random;

/**
 * Class demonstrating the use of the BlockingQueue by two threads: Producer and Consumer
 * From http://tutorials.jenkov.com/java-concurrency/blocking-queues.html
 */
public class BlockingQueueExample {

	/** Consumer thread removes elements from the queue */
	public static class Consumer implements Runnable {
		private BlockingQueueSolution queue;

		Consumer(BlockingQueueSolution q) {
			queue = q;
		}

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				try {
					int elem = queue.dequeue();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/** Producer thread adds elements to the queue */
	public static class Producer implements Runnable {
		private BlockingQueueSolution queue;
		private Random r;

		Producer(BlockingQueueSolution q) {
			queue = q;
			r = new Random();
		}

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				try {
					int elem = r.nextInt(10);
					queue.enqueue(elem);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		BlockingQueueSolution q = new BlockingQueueSolution(5);
		Thread thread1 = new Thread(new Consumer(q), "Consumer");
		Thread thread2 = new Thread(new Producer(q), "Producer");

		thread1.start();
		thread2.start();
	}
}
