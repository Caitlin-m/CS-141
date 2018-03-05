
package Lab2;

import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class          Loan Calculator
* File           LoanCalculator.java
* Description    Calculates monthly payment given
*                loan amount, interest, and years of loan
* @author        Caitlin McMurchie
* Environment    PC, Windows 10, jdk 1.8.0_151, NetBeans 8.2
* Date           1/8/2018
* @version       1.0.0
* @see           java.io
* @see           javax.swing.JFrame
* History Log    
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
public class LoanCalculator extends javax.swing.JFrame {
        int counter =0; //class level variable for counter
    /**
     * Default Constructor Creates new form LoanCalculator
     */
    public LoanCalculator() {
        initComponents();
        this.setLocationRelativeTo(null);   //centers form
        this.getRootPane().setDefaultButton(CalculateJButton);
        
        // set icon for form
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("\\\\zeus\\profile$\\955331307\\my documents\\CS 141\\Lab 2\\Lab 2 -- Loan Calculator\\eclipse.png"));
        PrincipalJTextField.requestFocus();
        setDate();
    }
    //Needs JavaDocs
    private void setDate()
    {   
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        this.setTitle("Loan Calculator--" + dateFormat.format(date));
    }
     

    private void InterestJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
    }                                                  

    private void QuitJButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // Ends the application
        System.exit(0);
    }                                           

    private void ClearJButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // Clears all text
        CounterJTextField.setText(" ");
        InterestJTextField.setText(" ");
        PrincipalJTextField.setText(" ");
        YearsJTextField.setText(" ");
        PaymentJTextField.setText(" ");
        InterestJTextField.setText(" ");
        RateJTextField.setText(" ");
    }                                            

    private void CounterJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 
//Needs LOTS of JavaDocs
    private void CalculateJButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // read the inputs and calculate payment of loan
        //constants for max values, and number of comoundings per year
        final double MAX_AMOUNT = 100000000;
        final double MAX_INTEREST_RATE = 100;
        final int COUMPOUNDINGS = 12;
        final double MAX_YEARS = 50;
        final double PERIOD_INTEREST = COUMPOUNDINGS * 100;
        String errorMessage = "Please enter a positive number for all required fields"
                + "\nLoan amount must be in reange (0, " + MAX_AMOUNT + "]"
                + "\nInterest rate must be  in range [0, " + MAX_INTEREST_RATE + "]"
                + "\nYears must be in range [0, " + MAX_INTEREST_RATE + "]";
        
        counter++;
        CounterJTextField.setText(String.valueOf(counter));
        
        //get inputs
        double amount = Double.parseDouble(PrincipalJTextField.getText());
        double rate = Double.parseDouble(RateJTextField.getText());
        double years = Double.parseDouble(YearsJTextField.getText());
        
        //calculate paymets using formula
        double payment = (amount * rate/PERIOD_INTEREST)/
                (1 - Math.pow((1 + rate/PERIOD_INTEREST),
                        years * (-COUMPOUNDINGS)));
        double interest = years * COUMPOUNDINGS * payment - amount;
        
        //displays results
        DecimalFormat dollars = new DecimalFormat("$#,##0.00");

        PaymentJTextField.setText(dollars.format(payment));
        InterestJTextField.setText(dollars.format(interest));
        
    }                                                
    }

