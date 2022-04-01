import java.io.*;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		
	}
	
	public static int factorial(int N) {
		if(N <= 1) return 1;	// 재귀 종료조건
		return N * factorial(N - 1);		
	}
 
}