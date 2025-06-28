import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        int userChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter a number between 3 and 27:"));
        boolean userWins = false;


        for (int i = 0; i < 5; ++i) {
            Lotto lotto = new Lotto();
            int sum = 0;


            for (int num : lotto.getNumbers()) {
                sum += num;
            }


            if (sum == userChoice) {
                userWins = true;
                break;
            }
        }


        if (userWins) {
            JOptionPane.showMessageDialog(null, "Congratulations! You won!");
        } else {
            JOptionPane.showMessageDialog(null, "Computer wins! Better luck next time.");
        }
    }
}






