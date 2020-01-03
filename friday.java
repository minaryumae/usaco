/*
PROG: friday
LANG: JAVA
 */
// COMPLETE

import java.util.Scanner;
import java.io.*;

public class friday {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("friday.in"));
		PrintWriter output = new PrintWriter(new File("friday.out"));
		
		int n = input.nextInt();
		int[] dayCounter = new int[7];
		
		int[] checkDay = {1,1,1900,2};
		
		for (int i=1900; i<(1900 + n); i++) {
			checkDay[2] = i;
			for (int j=1; j<=12; j++) {
				checkDay[0] = j;
				for (int k=1; k<=findMonthDays(checkDay); k++) {
					checkDay[1] = k;
					
					if (k == 13) {
						switch (checkDay[3]) {
							case 0: dayCounter[0]++; break;
							case 1: dayCounter[1]++; break;
							case 2: dayCounter[2]++; break; 
							case 3: dayCounter[3]++; break;
							case 4: dayCounter[4]++; break;
							case 5: dayCounter[5]++; break;
							case 6: dayCounter[6]++; break;
						}
					}
					if (checkDay[3] != 6) {
						checkDay[3]++;
					} else {
						checkDay[3]  = 0;
					}
				}
			}
		}
		
		
		for (int i=0; i<dayCounter.length; i++) {
			if (i != (dayCounter.length - 1)) {
				output.print(dayCounter[i] + " ");
			} else {
				output.print(dayCounter[i]);
				output.println();
			}
			
		}
		
		input.close();
		output.close();
	}
	
	public static int findMonthDays(int[] checkDay) {
		switch (checkDay[0]) {
			case 1: return 31;
			case 2:
				if(isLeap(checkDay[2])) {
					return 29;
				} else {
					return 28;
				}
			case 3: return 31;
			case 4: return 30;
			case 5: return 31;
			case 6: return 30;
			case 7: return 31;
			case 8: return 31;
			case 9: return 30;
			case 10: return 31;
			case 11: return 30;
			case 12: return 31;
				
		}
		return 0;
	}
	
	public static boolean isLeap(int year) {
		if (year % 4 == 0 ) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				} else {
					return false;
				}
			}
			return true;
		}
		
		return false;
	}
}
