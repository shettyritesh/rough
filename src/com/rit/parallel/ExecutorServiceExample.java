package com.rit.parallel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService service = Executors.newFixedThreadPool(5);
		List<Future<String>> tasklist = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) {
			RiteshTask task = new RiteshTask("Task" + i);

			Future<String> future = service.submit(task);
			tasklist.add(future);
		}
		try {
			for (Future<String> task : tasklist) {
				try {
					while (!task.isDone()) {
						Thread.sleep(200);
					}
					String str = task.get();
					System.out.println("Return from callable " + str);
				} catch (ExecutionException exp) {
					System.out.println("Exception in get" + exp);

				}
			}
			service.awaitTermination(1, TimeUnit.SECONDS);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.shutdown();
	}

}

class RiteshTask implements Callable<String> {
	String name;

	public RiteshTask(String thename) {
		name = thename;
	}

	public String call() throws Exception {


			// try {
			if (name.equals("Task5")) {
				throw new ExecutionException(new Exception("Helloooooo this is the exception"));
			}
			// Thread.sleep(50);
			// } catch (InterruptedException exp) {
			// exp.printStackTrace();
			// }

		return name;
	}

}