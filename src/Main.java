import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ui();
                Sunrise sunrise = Parser.parse(Parser.testingJson);
                System.out.println(sunrise.results.sunrise);
            }
        });
    }
}
