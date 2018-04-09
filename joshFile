import java.util.Random;
import java.util.Scanner;

public class classProject {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in); // Initiate Scanner
		int coins = 0, wins = 0, winnings = 0; // Initiate ints
		char continuePlay; // Initiate char
		String slot1, slot2, slot3; // INitiate Strings

		do {
			System.out.print("Do you insert a coin(Y/N): "); // Ask user for input
			continuePlay = keyboard.next().charAt(0); // Take user input as a Char
			if (continuePlay == 'Y' || continuePlay == 'y') { // if Yes continue
				coins++; // increment coins spent
				System.out.println("Slot 1   Slot 2   Slot 3   "); // print out slots
				System.out.println("==========================="); // print a line to seperate results
				slot1 = findOutcome(); // get output for slot1
				slot2 = findOutcome(); // get output for slot2
				slot3 = findOutcome(); // get output for slot3

				System.out.printf("%-10s %-10s %-10s\n", slot1, slot2, slot3); // print results out

				winnings = getWinnings(slot1, slot2, slot3); // use function to calculate how much user won
				System.out.printf("Winnings: %-9s\n\n", winnings); // print out what they won

				wins += winnings; // add winnings to wins
			} else if (continuePlay == 'N' || continuePlay == 'n') { // If no
				System.out.println("Exiting now"); // Let user know loop is exiting
				System.out.println("You used " + coins + " quarters, and won " + wins + " back."); // Print their total
																									// winnings
			} else {
				System.out.println("Input not recognized"); // Tell user to fix their input
				continuePlay = 'Y'; // Redo loop
			}
		} while (continuePlay == 'Y' || continuePlay == 'y'); // continue while true
	}	
	
	public static String findOutcome() { // function to get string values
		Random rand = new Random(); // generate random number
		int r = rand.nextInt(8); // Initiate r as a random number
		String result = " "; // Initiate result
		if (r == 0) { // if 0
			result = "cherries"; // make result cherries
		} else if (r == 1) { // if 1
			result = "BAR"; // make result BAR
		} else if (r == 2) { // if 2
			result = "Diamond"; // make result Diamond
		} else if (r == 3) { // if 3
			result = "bell"; // make result bell
		} else if (r == 4) { // if 4
			result = "orange"; // make result orange
		} else if (r == 5) { // if 5
			result = "lemon"; // make result lemon
		} else if (r == 6) { // if 6
			result = "grape"; // make result grape
		} else if (r == 7) { // if 7
			result = "7"; // make result 7
		} else if (r == 8) { // if 8
			result = "horseshoe"; // make result horseshoe
		}
		return result; // return result
	}

	public static int getWinnings(String slot1, String slot2, String slot3) { // function get winnings. returns an int
		int result; // Initiate result
		if (slot1 == slot2 && slot2 == slot3 && slot1 == "cherries") { // if all 3 are cherries
			result = 20; // generate value
		} else { // if no scenarios are met
			result = 0; // generate value
		}
		return result; // return result
	}
} 

