import javax.swing.JOptionPane;
import java.util.Random;

// Lotto class
class Lotto {
    private int[] numbers = new int[3];

    // Constructor that populates the array with random values
    public Lotto() {
        Random random = new Random();
        for (int i = 0; i < 3; ++i) {
            numbers[i] = 1 + random.nextInt(9);  // Random number between 1 and 9
        }
    }

    // Method to return the array
    public int[] getNumbers() {
        return numbers;
    }
}





