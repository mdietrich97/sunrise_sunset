import javax.swing.*;
import java.awt.*;

public class Ui extends JFrame {

    private JPanel panel1;
    private JTextField tfLatitude;
    private JTextField tfLongitude;
    private JButton bCalculate;
    private JLabel tfOutput;

    public Ui() {
        initializeGui();
    }

    private void initializeGui() {
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel1.setPreferredSize(new Dimension(600, 400));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel1.add(panel2);
        final JLabel label1 = new JLabel();
        label1.setText("Sunrise Calculator");
        panel2.add(label1);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel3.setPreferredSize(new Dimension(600, 200));
        panel1.add(panel3);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel4.setPreferredSize(new Dimension(300, 47));
        panel3.add(panel4);
        final JLabel label2 = new JLabel();
        label2.setHorizontalAlignment(2);
        label2.setText("Latitude:");
        panel4.add(label2);
        tfLatitude = new JTextField();
        tfLatitude.setBackground(new Color(-1));
        tfLatitude.setEditable(false);
        tfLatitude.setMinimumSize(new Dimension(120, 37));
        tfLatitude.setPreferredSize(new Dimension(120, 37));
        tfLatitude.setText("40,416775");
        panel4.add(tfLatitude);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel5.setPreferredSize(new Dimension(300, 47));
        panel3.add(panel5);
        final JLabel label3 = new JLabel();
        label3.setHorizontalAlignment(2);
        label3.setText("Longitude:");
        panel5.add(label3);
        tfLongitude = new JTextField();
        tfLongitude.setPreferredSize(new Dimension(120, 37));
        tfLongitude.setText("-3.703790");
        panel5.add(tfLongitude);
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel3.add(panel6);
        tfOutput = new JLabel();
        tfOutput.setPreferredSize(new Dimension(300, 47));
        tfOutput.setText("The sun rises at: ");
        panel6.add(tfOutput);
        bCalculate = new JButton();
        bCalculate.setLabel("Calculate");
        bCalculate.setText("Calculate");
        panel1.add(bCalculate);

        add(panel1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Sunrise Calculator");
        setSize(700, 400);
        setVisible(true);
    }
}
