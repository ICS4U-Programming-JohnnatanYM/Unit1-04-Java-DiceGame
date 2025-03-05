import java.util.Random;
import java.util.Scanner;

/**
 *The program generates a random number between 1 and 6.
 *The user will guess a number, and the
 *program gives hints if it is less or more than.
 *It tracks the number of attempts until the correct answer.
 *
 * @author Johnnatan Yasin Medina
 * @version 1.0
 * @since 2025-03-04
 */
public final class DiceGame {

    /** Constant for the minimum number. */
    private static final int MIN_NUMBER = 1;
    /** Constant for the maximum number. */
    private static final int MAX_NUMBER = 6;

    /**
     * This is to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private DiceGame() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Main Method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {
    // Create a random number generator
    final Random random = new Random();
    final int randomNumber = random.nextInt(MAX_NUMBER
     - MIN_NUMBER + 1) + MIN_NUMBER;

    // Scanner for user input
    final Scanner scanner = new Scanner(System.in);
    int userGuess = 0;
    int attempts = 0;

    //Ask user for the input
    System.out.print("Guess a number between ");
    System.out.println(MIN_NUMBER + " and " + MAX_NUMBER + ":");

    // Loop until the correct answer
    do {
        try {
            // Read user input and add onto the attempts it took
            userGuess = Integer.parseInt(scanner.nextLine());
            attempts++;

            // If guess is out between 1 and 6
            if (userGuess < MIN_NUMBER || userGuess > MAX_NUMBER) {
                    System.out.println("Please enter a number between "
                     + MIN_NUMBER + " and " + MAX_NUMBER + ".");
                //If number is lower than random number
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low, try again.");
                //If number is higher than random number
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high, try again.");
                //If number is correct and equal to random number
                } else {
                System.out.print("Congratulations! ");
                System.out.print("You guessed the correct number in ");
                //Amount of attempts it took
                System.out.println(attempts + " attempts.");
                }
            //Try..catch for non integer values
            } catch (NumberFormatException error) {
            System.out.print("Invalid input. Please enter a number between ");
            System.out.println(MIN_NUMBER + " and " + MAX_NUMBER + ".");
            }
        } while (userGuess != randomNumber);

        scanner.close();
        }
    }
