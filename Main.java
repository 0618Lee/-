package com.JL;

public class Main {
	/* 0 1 1 2 3 5 8 13 21 ...*/
	
	//1 < logn < n < nlogn < n^2 < n^3 < 2^n < n! < n^n
	
	//效率非常低,时间复杂度O(2^n) 
	//1 + 2 + 4 + 8 + 16 + ...+ 2^(n - 2) = 2^(n - 1) - 1 = O(2^n)
	public static long fib1(int n) {
		if(n <= 1)	return n;
		return fib1(n - 1) + fib1(n - 2);
	}
	
	//效率高，时间复杂度O(n)
	public static int fib2(int n) {
		if(n <= 1) return n;
		int first = 0;
		int second = 1;
		for(int i = 0; i < n - 1; i++) {
			second = first + second;
			first = second - first;
		}
		return second;
	}
	
	public static void main(String[] args){
		int i = 1;
		while(true) {
			System.out.println(i + ":" + fib1(i++));
		}	
	}
}
