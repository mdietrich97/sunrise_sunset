import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ui extends JFrame {

    private JPanel panel1;
    private JTextField tfLatitude;
    private JTextField tfLongitude;
    private JButton bCalculate;
    private JLabel tfOutput;
    private JComboBox Year;
    private JComboBox Month;
    private JComboBox Day;
    private JSpinner tfLat;
    private JSpinner tfLong;

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
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
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

        SpinnerNumberModel modelx = new SpinnerNumberModel(0.0,-99999,9999,1.0);
        SpinnerNumberModel modely = new SpinnerNumberModel(0.0,-99999,9999,1.0);

        tfLat = new JSpinner(modelx);
        tfLong = new JSpinner(modely);
        panel4.add(tfLat);

        final JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel5.setPreferredSize(new Dimension(300, 47));
        panel3.add(panel5);
        final JLabel label3 = new JLabel();
        label3.setHorizontalAlignment(2);
        label3.setText("Longitude:");
        panel5.add(label3);
        panel5.add(tfLong);

        final JPanel panel7 = new JPanel();
        panel7.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel7.setPreferredSize(new Dimension(300, 47));
        panel3.add(panel7);
        String [] years = { "2009","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018", "2019" };

        Year = new JComboBox(years);
        String [] Months = { "01","02","03","04","05","06","07","08","09","12" };
        Month = new JComboBox(Months);
        String [] Days = { "01","02","03","04","05","06","07","08","09","12","13","14","15",
                "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31" };

        Day = new JComboBox(Days);

        JLabel yeartext = new JLabel("Year: ");
        JLabel monthttext = new JLabel("Month: ");
        JLabel daytext = new JLabel("Day: ");

        panel7.add(daytext);
        panel7.add(Day);
        panel7.add(monthttext);
        panel7.add(Month);
        panel7.add(yeartext);
        panel7.add(Year);

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

            bCalculate.addActionListener(new ActionListener(){
                @Override

                public void actionPerformed(ActionEvent e){
                    Connection connection = new Connection(
                            tfLat.getValue().toString(),
                            tfLong.getValue().toString(),
                            Year.getSelectedItem().toString(),
                            Month.getSelectedItem().toString(),
                            Day.getSelectedItem().toString()
                    );
                    String jsonData = connection.request();
                    Sunrise sunrise = Parser.parse(jsonData);
                    tfOutput.setText("The sun rises at "+sunrise.results.sunrise);
                }
            });
    }
}
