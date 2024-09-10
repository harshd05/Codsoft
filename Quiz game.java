
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class CricketQuizApp {
    private static String[] questions = {
        "Ques 1: Who is the highest run-scorer in international cricket?",
        "Ques 2: Which team won the first Cricket World Cup in 1975?",
        "Ques 3: Who took the first hat-trick in IPL history?"
    };

    private static String[][] options = {
        {"A. Sachin Tendulkar", "B. Virat Kohli", "C. Brian Lara", "D. Jacques Kallis"},
        {"A. West Indies", "B. Australia", "C. England", "D. Pakistan"},
        {"A. Lakshmipathy Balaji", "B. Amit Mishra", "C. Yuvraj Singh", "D. Harbhajan Singh"}
    };

    private static char[] answers = {'A', 'A', 'A'};
    private static int current = 0;
    private static int score = 0;
    private static boolean answered = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n<---------You have only 10 seconds to answer every ques.---------->\n");
        for (current = 0; current < questions.length; current++) {
            askQues(scanner);
        }
        System.out.println("Game Over..........");
        result();
        scanner.close();
    }

    private static void askQues(Scanner scanner) {
        System.out.println(questions[current]);
        for (String option : options[current]) {
            System.out.println(option);
        }
        answered = false;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!answered) {
                    System.out.println("Your Time's up!");
                    checkAnswer(' ');
                }
            }
        }, 10000);
        String answer = scanner.nextLine().toUpperCase();
        if (!answered) {
            timer.cancel();
            checkAnswer(answer.length() > 0 ? answer.charAt(0) : ' ');
        }
    }

    private static void checkAnswer(char answer) {
        answered = true;
        if (answer == answers[current]) {
            score++;
        }
    }

    private static void result() {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.length);
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i] + " - Correct Answer: " + answers[i]);
        }
    }
}
