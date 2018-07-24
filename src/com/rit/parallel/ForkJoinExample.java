package com.rit.parallel;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class ForkJoinExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ForkJoinPool pool = new ForkJoinPool(4);
		System.out.println("Paralelism is " + pool.getParallelism());
		ArrayList<RitForkJoinTask> list = new ArrayList<RitForkJoinTask>();
		for (int i = 0; i < 50; i++) {
			RitForkJoinTask task = new RitForkJoinTask("Task" + i);
			list.add(task);
			pool.execute(task);
			

		}
		for (RitForkJoinTask task : list) {
			String str=null;
			try {
//				while(!task.isDone()) {
//					Thread.sleep(100);
//				}				
				str=task.get();
				//str = task.get();
				System.out.println(str);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
					
				}
			}
			
			
		
		try {
			pool.awaitTermination(5, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class RitForkJoinTask extends ForkJoinTask<String> {
	String name;

	public RitForkJoinTask(String thatname) {
		name = thatname;
	}


	@Override
	public String getRawResult() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	protected void setRawResult(String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean exec() {
		try {
			setRawResult(name);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return true;
	}

}
