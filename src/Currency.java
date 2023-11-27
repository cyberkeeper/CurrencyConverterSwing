import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class contains the Java Swing components for the GUI. The methods which handle the events generated are
 * handled here.
 */
public class Currency {
    private JTextField txtFrom;
    private JComboBox cbFrom;
    private JComboBox cbDestination;
    private JButton btnConvert;
    // changed the default private access modifier to public so that it can be used in the Main.java class.
    public JPanel currencyForm;
    private JLabel labelOutput;

    //an array containing 3 currencies for conversion. Make it final as it won't be changed after being initialised.
    private final String[] currency = {"GBP", "EUR", "USD"};

    /* A 2D array for converting from one currency to any other currency. The first row takes the format
        GBP to GBP, GBP to EUR, GBP to USD
        EUR to GBP, EUR to EUR, EUR to USD
        USD to GBP, USD to EUR, USD to USD
     Other currencies could be added by expanding the currency and convert arrays.
     Make it final as it won't be changed after being initialised.
     */
    private final double[][] convert = {
            {1, 1.15, 1.3},
            {0.87, 1, 1.13},
            {0.77, 0.88, 1}};

    /**
     * Constructor for this class. This method is called whenever a new Currency class instance is created i.e.
     * <code>Currency demo = new Currency();</code><br>
     * All classes have constructor methods, and they are used to set up the bits and pieces within the class.
     */
    public Currency() {


        // When the convert button is pressed this method will be called.
        btnConvert.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //call the method which will do the conversion and update what is shown in screen
                convertCurrency();
            }
        });
    }

    /**
     * This method contains the code the convert from one currency to another currency
     */
    private void convertCurrency() {
        //the try statement is required because the user might be an idiot and enter a non-number in the input field!
        try {
            //get the selected items from the combo boxes. The indexes are zero based like arrays.
            int from = cbFrom.getSelectedIndex();
            int dest = cbDestination.getSelectedIndex();

            //get the amount to be converted
            double amount = Double.parseDouble(txtFrom.getText());

            //check if the user entered a number less than 0. If it was throw an exception
            if(amount < 0)
                throw new Exception("The initial amount must be greater than 0");

            //get the conversion rate
            double convRate = convert[from][dest];

            //do the conversion
            double result = convRate * amount;

            //update the screen with the result
            String output = String.format("You will receive %.2f %s", result, cbDestination.getSelectedItem());
            labelOutput.setText(output);
        }catch (NumberFormatException nfe)
        {
            //the Double.parseDouble throws this type of exception so deal with it.
            JOptionPane.showMessageDialog(null,"The input must be a number","Conversion error",JOptionPane.ERROR_MESSAGE);
        }catch (Exception e)
        {
            //in the code above an exception is thrown if the initial amount entered is < 0, deal with it.
            JOptionPane.showMessageDialog(null, e.getMessage(),"Conversion error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called only when the "Custom create" option is ticked on the GUI form designer.
     * This option has been ticked for the two JCombo boxes so that the currencies can be added before anything is
     * shown on screen.
     */
    private void createUIComponents() {
        cbFrom = new JComboBox();
        cbDestination = new JComboBox();

        //add the currencies to the combo box. A normal for loop or a while loop would also work here.
        for (String curr : currency) {
            cbFrom.addItem(curr);
            cbDestination.addItem(curr);
        }
        //set the default currencies that will be displayed in the combo boxes
        cbFrom.setSelectedIndex(0);
        cbDestination.setSelectedIndex(1);
    }
}
