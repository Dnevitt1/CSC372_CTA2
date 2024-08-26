import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.time.LocalDate;  
import java.time.Period;

public class AgeCalcFrame extends JFrame implements ActionListener {

    private JLabel bDayLabel;
    private JLabel ageLabel;
    private JTextField bDayField;
    private JTextField ageField; 

    AgeCalcFrame() { 
        GridBagConstraints layoutConst = null;

        setTitle("Birthday and Age");
        bDayLabel = new JLabel("Enter birthday:");
        ageLabel = new JLabel("Your age is:");

        bDayField = new JTextField(10);
        bDayField.setEditable(true);
        bDayField.setText("YYYY-MM-DD");
        bDayField.addActionListener(this);

        ageField = new JTextField(3);
        ageField.setEditable(false);

        setLayout(new GridBagLayout());
        
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(bDayLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(bDayField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(ageLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(ageField, layoutConst);
        }

        @Override
        public void actionPerformed(ActionEvent event) {
        String userInput;      
        LocalDate birthday; 
        LocalDate curDate = LocalDate.now();   
        
        userInput = bDayField.getText();
        birthday = LocalDate.parse(userInput);
        ageField.setText(Integer.toString(Period.between(birthday, curDate).getYears()));
    }
    public static void main(String[] args) {
        AgeCalcFrame myFrame = new AgeCalcFrame();
  
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);
     }
}