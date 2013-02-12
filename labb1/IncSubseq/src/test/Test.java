package test;

import java.util.Random;

public class Test {
	public static void main(String[] args){
		System.out.println("1000");
		Random r = new Random();
		for(int i = 0; i < 1000; i++){
			System.out.print(r.nextInt() + " ");
		}
	}
}
