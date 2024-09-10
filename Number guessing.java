
import java.util.Random;
import java.util.Scanner;

public class MysteryNumberGame {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 50;
    private static final int MAX_GUESSES = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;
        int roundsPlayed = 0;
        String playAgain = "y";

        while (playAgain.equalsIgnoreCase("y")) {
            roundsPlayed++;
            System.out.println("Round " + roundsPlayed);
            int attempts = playRound(scanner);
            totalScore += calculateScore(attempts);
            System.out.println("Your score: " + totalScore);
            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next();
        }

        System.out.println("Game over! You played " + roundsPlayed + " rounds with a total score of " + totalScore + ".");
        scanner.close();
    }

    private static int playRound(Scanner scanner) {
        int mysteryNumber = generateMysteryNumber(MIN_NUMBER, MAX_NUMBER);
        int attempts = 0;

        while (attempts < MAX_GUESSES) {
            int guess = getGuess(scanner);
            attempts++;
            String feedback = getFeedback(guess, mysteryNumber);
            System.out.println(feedback);

            if (feedback.equals("You got it!")) {
                return attempts;
            }
        }

        System.out.println("Sorry, you've used all " + MAX_GUESSES + " attempts. The mystery number was " + mysteryNumber + ".");
        return MAX_GUESSES + 1;
    }

    private static int generateMysteryNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private static int getGuess(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter your guess: ");
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    private static String getFeedback(int guess, int mysteryNumber) {
        if (guess < mysteryNumber) {
            return "Too low!";
        } else if (guess > mysteryNumber) {
            return "Too high!";
        } else {
            return "You got it!";
        }
    }

    private static int calculateScore(int attempts) {
        return MAX_GUESSES - attempts + 1;
    }
}
