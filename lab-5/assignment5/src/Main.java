
    import javax.swing.SwingUtilities;
    import java.sql.SQLException;

    public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                    GUI gui = new GUI();
                    gui.display();

            }
        });
    }
}


