package p1;

import java.util.Iterator;

public class TriangleStar {
	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			for(int j=0 ;j<= i;j++) {
				if(i==4 && j==3) {
					System.out.print("  ");
				}
				System.out.print("* ");
			}
			System.out.println();
		}
		for(int i=0;i<4;i++) {
			for(int j=i;j<4;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}

}
