package com.rit.parallel;
import java.util.*;
import java.util.concurrent.*;

class StringUtilForkJoin {// 1
	final static int CHUNKSIZE = 4;

	public static void main(String args[]) {
		String str = "ABCDEFGHI";
		String res = StringUtilForkJoin.reverse(str, 1);
		System.out.println(res);

	}

	public static String reverse(String str, int threads) {// 3
		ForkJoinPool pool = ForkJoinPool.commonPool();
		int cores = pool.getParallelism();
		int parallelTasks = threads;
		if (threads > cores || threads == 0) {
			parallelTasks = cores;
		}
		pool = new ForkJoinPool(parallelTasks);
		if (str.length() <= CHUNKSIZE) {
			StringBuilder sb = new StringBuilder(str);
			return sb.reverse().toString();
		}

		List<RitTaskForkJoin> list = submit(str, pool);
		StringBuilder builder = new StringBuilder(str.length());
		for (int i = list.size() - 1; i >= 0; i--) {

			RitTaskForkJoin task = list.get(i);
			try {
				String rev = task.get();
				builder.append(rev);
			} catch (ExecutionException exp) {
			} catch (InterruptedException exp) {
			}
		}
		try {
			pool.awaitTermination(50, TimeUnit.MILLISECONDS);
		} catch (InterruptedException exp) {

		}
		return builder.toString();

	}// 3

	private static List<RitTaskForkJoin> submit(String str, ForkJoinPool pool) {
		int totalchunks = str.length() / CHUNKSIZE;
		if (str.length() % CHUNKSIZE>0) {
			totalchunks++;
		}
		List<RitTaskForkJoin> list = new ArrayList<RitTaskForkJoin>();

		for (int i = 0; i < totalchunks; i++) {
			int tmpchunk=0;
			if(str.length()-i * CHUNKSIZE>CHUNKSIZE) {
				tmpchunk=CHUNKSIZE;
			}
			else {
				tmpchunk=(str.length()-i * CHUNKSIZE);
			}
			String taskcandidate = str.substring(i * CHUNKSIZE,i * CHUNKSIZE+ tmpchunk);
			RitTaskForkJoin task = new RitTaskForkJoin(taskcandidate);
			list.add(task);
			pool.execute(task);

		}
		int retry = 3;
		boolean dirty = false;
		while (retry > 0) {
			dirty = false;
			for (int i = 0; i < totalchunks; i++) {
				for (RitTaskForkJoin task : list) {
					try {
						task.get();
					} catch (InterruptedException exp) {

					} catch (ExecutionException exp) {
						pool.execute(task);
						dirty = true;
					}
				}
			}
			if (!dirty) {
				break;
			}

			retry--;
		}
		if (dirty && retry == 0) {
			throw new RuntimeException("Error in executing the threads");
		}
		return list;
	}

}// 1

class RitTaskForkJoin extends RecursiveTask<String> {
	private String str;

	public RitTaskForkJoin(String candidate) {
		str = candidate;
	}

	public String compute() {
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}
}