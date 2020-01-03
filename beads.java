/*
PROG: beads
LANG: JAVA
 */
// COMPLETE
import java.util.Scanner;
import java.io.*;
public class beads {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("beads.in"));
		PrintWriter output = new PrintWriter(new File("beads.out"));
		
		int n = input.nextInt();
		String beads = input.next();
		int highestCnt = 0;
		
		for (int i=0; i<n; i++) {
			int leftCnt = 0;
			int rightCnt = 0;
			int leftIndexInit, rightIndexInit;
			if (i==0) {
				leftIndexInit = n-1;
				rightIndexInit = 0;
			} else {
				leftIndexInit = i-1;
				rightIndexInit = i;
			}
			
			int leftIndex = leftIndexInit;
			int rightIndex = rightIndexInit;
			
			char leftColor = beads.charAt(leftIndex);
			char rightColor = beads.charAt(rightIndex);
			
			
			if (rightColor == 'w') {
				while(beads.charAt(rightIndex) == 'w') {
					rightCnt++;
					if (rightIndex == n-1) {
						rightIndex = 0;
					} else {
						rightIndex++;
					}
					
					if (rightIndex == rightIndexInit) {
						break;
					}
				}
				
				char tmpColor = beads.charAt(rightIndex);
				
				while (beads.charAt(rightIndex) == tmpColor || beads.charAt(rightIndex) == 'w') {
					if (rightIndex == rightIndexInit) {
						break;
					}
					rightCnt++;
					if (rightIndex == n-1) {
						rightIndex = 0;
					} else {
						rightIndex++;
					}
				}
			} else {
				while(beads.charAt(rightIndex) == rightColor || beads.charAt(rightIndex) == 'w') {
					rightCnt++;
					if (rightIndex == n-1) {
						rightIndex = 0;
					} else {
						rightIndex++;
					}
					if (rightIndex == rightIndexInit) {
						break;
					}
				}
			}
			
			if (rightCnt != beads.length()) {
				if (leftColor == 'w') {
					while(beads.charAt(leftIndex) == 'w') {
						leftCnt++;
						if (leftIndex == 0) {
							leftIndex = n-1;
						} else {
							leftIndex--;
						}
						if (leftIndex == leftIndexInit) {
							break;
						}
					}
					
					char tmpColor = beads.charAt(leftIndex);
					
					while (beads.charAt(leftIndex) == tmpColor || beads.charAt(leftIndex) == 'w') {
						if (leftIndex == leftIndexInit) {
							break;
						}
						leftCnt++;
						if (leftIndex == 0) {
							leftIndex = n-1;
						} else {
							leftIndex--;
						}
					}
				} else {
					while((beads.charAt(leftIndex) == leftColor || beads.charAt(leftIndex) == 'w') && leftIndex != (rightIndex-1)) {
						leftCnt++;
						if (leftIndex == 0) {
							leftIndex = n-1;
						} else {
							leftIndex--;
						}
						if (leftIndex == leftIndexInit) {
							break;
						}
					}
				}
			}
			
			
			int tmpCnt = rightCnt + leftCnt;
			
			if (tmpCnt > highestCnt) {
				highestCnt = tmpCnt;
			}
		}
		
		output.println(highestCnt);
		
		
		input.close();
		output.close();
		
	}
}
