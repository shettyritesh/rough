package com.rit.parallel;
import java.util.*;
import java.util.concurrent.*;
class StringUtilExecutor{//1
	final static int CHUNKSIZE=4;
	public static void main(String args[]) {
		String str = "123456789";
		String res = StringUtilExecutor.reverse(str, 1);
		System.out.println(res);

	}	
	public static String reverse(String str, int threads){
		ExecutorService service = Executors.newFixedThreadPool(threads);
		if(str==null){
			throw new RuntimeException("String cannot be null");
		}
		StringBuilder sb= null;
		if(str.length()<=CHUNKSIZE){
			sb= new StringBuilder(str);
			return sb.reverse().toString();
		}
		int totalTasks=str.length()/CHUNKSIZE;
		if(str.length()%CHUNKSIZE>0){
			totalTasks++;
		}
		List<Future<String>> list = new ArrayList<Future<String>>();
		
		for(int i=0;i<totalTasks;i++){
			int tillindex=0;
			if(str.length()-i*CHUNKSIZE>CHUNKSIZE){
				tillindex=CHUNKSIZE;
			}
			else{
				tillindex=str.length()-i*CHUNKSIZE;
			}
			RitTaskExecutor task = new RitTaskExecutor(str.substring(i*CHUNKSIZE,i*CHUNKSIZE+tillindex));
			Future<String> future=service.submit(task);
			list.add(future);
		}
		sb= new StringBuilder(str.length());
		for(int i=totalTasks-1;i>=0;i--){
			try{
				Future<String> future= list.get(i);
				String rev=future.get();
				sb.append(rev);				
			
			}
			catch(ExecutionException exp){
			
			}
			catch(InterruptedException exp){
			
			}
		}
		try {
			service.awaitTermination(1,TimeUnit.SECONDS);
		}catch(InterruptedException exp) {
			
		}
		return sb.toString();
	}
}//1


class RitTaskExecutor implements Callable<String>{
	private String str;
	public RitTaskExecutor(String rev){
		str=rev;
	}
	public String call(){
		StringBuilder sb= new StringBuilder(str);
		return sb.reverse().toString();

	}

} 