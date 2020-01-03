/*
PROG: ride
LANG: JAVA
 */
// COMPLETE (TRAINING SECT 1.2)
import java.util.Scanner;
import java.io.*;

public class ride {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner(new File("ride.in"));
		PrintWriter output = new PrintWriter(new File("ride.out"));
		
		String input1 = input.next();
		String input2 = input.next();
		
		int input1Num = 1;
		int input2Num = 1;
		
		for (int i=0; i<input1.length(); i++) {
			int tmpNum = (int)input1.charAt(i) - 64;
			input1Num *= tmpNum;
		}
		
		input1Num = input1Num % 47;
		
		for (int i=0; i<input2.length(); i++) {
			int tmpNum = (int)input2.charAt(i) - 64;
			input2Num *= tmpNum;
		}
		
		input2Num = input2Num % 47;
		
		if (input1Num == input2Num) {
			output.println("GO");
		} else {
			output.println("STAY");
		}
		input.close();
		output.close();
	}
}
