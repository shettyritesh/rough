package com.rit.fibo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fib {
	private Map<Long, Long> resultMap= new HashMap<Long,Long>();
	public static void main(String args[]) {

		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			long fibindex = scanner.nextLong();

			Fib fib = new Fib();
			long start= new Date().getTime();
			System.out.println("Matrix mutiply result=" + fib.getFib(fibindex));
			long end= new Date().getTime();
			System.out.println("Time taken is "+(end-start));
			start= new Date().getTime();
			System.out.println("Usual Approach result=" + fib.getUsualFib(fibindex));
			end= new Date().getTime();
			System.out.println("Time taken is "+(end-start));
			
		} catch (Exception exp) {
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}

	public long getFib(long fibindex) {

		long[][] result = { { 1, 0 }, { 0, 1 } };
		long[][] fibM = { { 1, 1 }, { 1, 0 } };

		if (fibindex <= 1) {
			return fibindex;
		}
		while (fibindex > 0) {
			if (fibindex % 2 == 1) {
				matrixMultiply(result, fibM);
			}

			fibindex = fibindex / 2;

			matrixMultiply(fibM, fibM);

		}

		return result[1][0];

	}

	public void matrixMultiply(long[][] m, long[][] n) {

		long a = m[0][0] * n[0][0] + m[0][1] * n[1][0];
		long b = m[0][0] * n[0][1] + m[0][1] * n[1][1];
		long c = m[1][0] * n[0][0] + m[1][1] * n[0][1];
		long d = m[1][0] * n[0][1] + m[1][1] * n[1][1];

		m[0][0] = a;
		m[0][1] = b;
		m[1][0] = c;
		m[1][1] = d;

	}

	public long getUsualFib(long fibindex) {

		if (fibindex <= 1) {
			return fibindex;
		}
		
		long n1=fibindex - 1;
		long n2=fibindex - 2;
		long resultn1 = resultMap.get(n1)==null?getUsualFib(n1):(Long)resultMap.get(n1);
		long resultn2= resultMap.get(n2)==null?getUsualFib(n2):(Long)resultMap.get(n2);
		if(resultMap.get(n1)==null){
			resultMap.put(n1, resultn1);
		}
		
		if(resultMap.get(n2)==null){
			resultMap.put(n2, resultn2);
		}
		return resultn1 + resultn2;

	}

}