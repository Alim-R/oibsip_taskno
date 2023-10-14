import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int attempts = 10;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Guess the Number game!");

        while (playAgain) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int remainingAttempts = attempts;

            System.out.println("I've picked a number between " + lowerBound + " and " + upperBound + ". You have " + attempts + " attempts.");

            while (remainingAttempts > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                remainingAttempts--;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the number: " + targetNumber);
                    score += remainingAttempts; // Give points based on the number of attempts left.
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Try a higher number. Remaining attempts: " + remainingAttempts);
                } else {
                    System.out.println("Try a lower number. Remaining attempts: " + remainingAttempts);
                }

                if (remainingAttempts == 0) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
                }
            }

            System.out.println("Your current score: " + score);

            System.out.print("Play again? (yes/no): ");
            String playAgainResponse = sc.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Thank you for playing!");
    }
}
