import javax.swing.JOptionPane;
import java.util.Random;
public class Test {
    private int correctCount;
    private int incorrectCount;
    private Random randomizer;

    public Test() {
        this.correctCount = 0;
        this.incorrectCount = 0;
        this.randomizer = new Random();
    }

    public void simulateQuestion(String prompt, String[] options, int rightOption) {
        String userInput = JOptionPane.showInputDialog(null, prompt + "\n" +
                "A. " + options[0] + "\n" +
                "B. " + options[1] + "\n" +
                "C. " + options[2] + "\n" +
                "D. " + options[3] + "\n" +
                "Choose the best answer (A/B/C/D):");

        int userSelection = convertAnswer(userInput);
        if (userSelection == rightOption) {
            String response = generateMessage(true);
            JOptionPane.showMessageDialog(null, response);
            correctCount++;
        } else {
            String response = generateMessage(false);
            String actualAnswer = choiceToLetter(rightOption);
            JOptionPane.showMessageDialog(null, response + "\n" +
                    "The right answer is: " + actualAnswer);
            incorrectCount++;
        }
    }

    private int convertAnswer(String answer) {
        answer = answer.toUpperCase();
        switch (answer) {
            case "A":
                return 1;
            case "B":
                return 2;
            case "C":
                return 3;
            case "D":
                return 4;
            default:
                return 0;
        }
    }

    private String choiceToLetter(int choice) {
        switch (choice) {
            case 1:
                return "A";
            case 2:
                return "B";
            case 3:
                return "C";
            case 4:
                return "D";
            default:
                return "Invalid";
        }
    }

    private String generateMessage(boolean isCorrect) {
        int choice = randomizer.nextInt(4);
        if (isCorrect) {
            switch (choice) {
                case 0:
                    return "Excellent!";
                case 1:
                    return "Good!";
                case 2:
                    return "Keep up the good work!";
                case 3:
                    return "Nice work!";
                default:
                    return "Well done!";
            }
        } else {
            switch (choice) {
                case 0:
                    return "No. Please try again";
                case 1:
                    return "Wrong. Try once more";
                case 2:
                    return "Don't give up!";
                case 3:
                    return "No. Keep trying..";
                default:
                    return "Oops! Try again.";
            }
        }
    }

    public void inputAnswer() {
        simulateQuestion("Which planet is known as the 'Red Planet'?", new String[]{"Venus", "Mercury", "Mars", "Jupiter"}, 3);
        simulateQuestion("Which animal is the largest mammal in the world?", new String[]{"Elephant", "Whale Shark", "Giraffe", "Blue Whale"}, 4);
        simulateQuestion("What is the capital of France?", new String[]{"Berlin", "Madrid", "Rome", "Paris"}, 4);
        simulateQuestion("Which famous physicist developed the theory of general relativity?", new String[]{"Isaac Newton", "Nikola Tesla", "Albert Einstein", "Galileo Galilei"}, 3);
        simulateQuestion("The Taj Mahal is located in which country?", new String[]{"India", "Turkey", "Indonesia", "Pakistan"}, 1);

        double score = (double) correctCount / (correctCount + incorrectCount) * 100;
        JOptionPane.showMessageDialog(null, "Thanks for participating in the quiz!\n" +
                "Correct answers: " + correctCount + "\n" +
                "Wrong answers: " + incorrectCount + "\n" +
                "Your Score: " + score + "%");
    }

}
