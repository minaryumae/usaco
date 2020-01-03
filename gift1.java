/*
PROG: gift1
LANG: JAVA
 */
// COMPLETE (TRAINING SECT 1.2)
import java.util.Scanner;
import java.io.*;
public class gift1 {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner(new File("gift1.in"));
		PrintWriter output = new PrintWriter(new File("gift1.out"));
		
		int np = input.nextInt();
		String[][] peopleMoney = new String[np][2];
		int[] peopleIntMoney = new int[np];
		
		for (int i=0; i<np; i++) {
			peopleMoney[i][0] = input.next();
		}
		
		for (int i=0; i<np; i++) {
			String nameGive = input.next();
			for (int k=0; k<np; k++) {
				if (peopleMoney[k][0].contains(nameGive)) {
					int totalMoney = input.nextInt();
					int numPeople = input.nextInt();
					
					if (numPeople != 0) {
						peopleIntMoney[k] -= totalMoney;
						peopleIntMoney[k] += totalMoney % numPeople;
						
						for (int j=0; j<numPeople; j++) {
							String nameRecieve = input.next();
							
							for (int l=0; l<np; l++) {
								if (peopleMoney[l][0].contains(nameRecieve)) {
									peopleIntMoney[l] += totalMoney / numPeople;
								}
							}
							
						}
					}
				}
			}
			
		}
		
		for (int i=0; i<np; i++) {
			peopleMoney[i][1] = Integer.toString(peopleIntMoney[i]);
		}
		
		for (int i=0; i<np; i++) {
			output.println(peopleMoney[i][0] + " " + peopleMoney[i][1]);
		}
		
		input.close();
		output.close();
	}
}
