package Primes;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*	Class:		    Primes
*	File:		    PrimeNumbers.java
*	Description:	Displays prime numbers, tests for primeness, prime
*                       decomposition, and range of primes.
*	@author:	    Caitlin McMurchie
*	Environment:	PC, Windows 10, jdk1.8.0_151, NetBeans 8.2
*	Date:		    2/26/2018
*	@version	    1.0
*   @see           	javax.swing.JOptionPane
*	History Log:	2/26/18, 2/28/18
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;

public class PrimeNumbers extends JFrame 
{
    // Class instance field    
    private int whichRadio = 0;
    final int MAX_INPUT = 1000000;  // maximum number for prime test
    
    /** Creates new form PrimeNumbers */
    public PrimeNumbers() 
    {
        initComponents();
         //set as default the calculateJButton
        this.getRootPane().setDefaultButton(calculateJButton);
        //set as image the pi.pjg
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/Primes/PI.jpg"));
        //center the form
        this.setLocationRelativeTo(null);
        listAllJTextField.requestFocus();        
    }                    

    private void lowJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              
      // Call calculateJButtonActionPerformed
        calculateJButtonActionPerformed(evt);
    }                                             

    private void highJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                               
       // Call calculateJButtonActionPerformed
        calculateJButtonActionPerformed(evt);
    }                                              

    private void factorizationJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                        
       // Call calculateJButtonActionPerformed
        calculateJButtonActionPerformed(evt);
    }                                                       

    private void isPrimeJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                  
       // Call calculateJButtonActionPerformed
        calculateJButtonActionPerformed(evt);
    }                                                 

    private void listAllJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // Call calculateJButtonActionPerformed
        calculateJButtonActionPerformed(evt);
    }                                                 

    private void calculateJButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // Find primes for each selection
        displayJTextArea.setText("");    // clear display area
        int whichButton = getButton();  // decide which radio button is selected
        switch(whichButton)
        {
            case 1:         //display the first n primes
                listPrimes();
                break;
            case 2:         //display yes or no for test of primness
                testIfPrime();    
                break;
            case 3:         //display the prime factoriazation of a composite
                //primeFactoriazation();    //TO DO
                break;
            case 4:         //display a range of primes
                //rangePrimes();        //TO DO
                break;
            case 5:         //goldbach's congecture
                //goldbachPrimes();
                break;
        }
    }                                                

    private void listPrimes()// display the first n prime numbers
    {
        String message = "Illegal type--enter an integer >= 1 and < " +
                    MAX_INPUT;
        try
        {            
            int max = Integer.parseInt(listAllJTextField.getText());
            message = "Illegal range--enter an integer >= 1 and < " +
                    MAX_INPUT;
            
            if(max < 1 || max > MAX_INPUT)
            {
                throw new NumberFormatException();
            }
        int[] primes = new int[max];
        primes[0] = 2;      //2 is a unicorn
        int count = 1;      //keeps track of primes counted
        int trialNumber = 1;
        boolean isPrime = false;
        StringBuffer output = new StringBuffer();
        
        while (count < max)
        {
            trialNumber +=2;
            isPrime = testPrime(trialNumber);
            if(isPrime)
            {
                primes[count] = trialNumber;
                count++;
            }
        }
        
        //output the content of the array into the jtextarea
        if(count == 1)
            output.append("The first prime number is: \n\n");
        else
            output.append("The first " + max + " prime numbers are: \n\n");
        
        for(int i = 0; i< max; i++)
        {
            output.append(primes[i] + "\t");
            if((i + 1)% 5 == 0)
            {
                output.append("\n");
            }
        }
        displayJTextArea.setText(output.toString());
        
        }
        catch(NumberFormatException numexp)// display error message
        {
            JOptionPane.showMessageDialog( null,
               message,"Illegal Input", JOptionPane.WARNING_MESSAGE );
            listAllJTextField.requestFocus();
            listAllJTextField.selectAll();
        }
    }//end of listPrimes
    
  private void testIfPrime()
  {
      String message = "Illegal type--enter an integer >= 1 and < " +
                    MAX_INPUT;
        try
        {            
            int trialNumber = Integer.parseInt(isPrimeJTextField.getText());
            message = "Illegal range--enter an integer >= 1 and < " +
                    MAX_INPUT;
            
            if(trialNumber < 1 || trialNumber > MAX_INPUT)
            {
                throw new NumberFormatException();
            }
        boolean isPrime = testPrime(trialNumber);
        if(isPrime)
            displayJTextArea.setText(trialNumber + " is a prime number");
        else
            displayJTextArea.setText(trialNumber + " is not a prime number");
        }//end try
        
        catch(NumberFormatException numexp)// display error message
        {
            JOptionPane.showMessageDialog( null,
               message,"Illegal Input", JOptionPane.WARNING_MESSAGE );
            isPrimeJTextField.requestFocus();
            isPrimeJTextField.selectAll();
        }//end catch
  }
    
   //method to determin if a positive integer > 1 is a prime number
   private boolean testPrime(int n)
    {
       boolean isFactor = false;      
        if(n == 2)
            return true;
        else
        {
            if((n % 2) == 0)// n is even
                return false;           
            else//check for the odd positive integers if there is a factor
            {
                for(int i = 3; !isFactor && i <= Math.sqrt(n); i += 2)
                {
                    if(n % i == 0)
                        isFactor = true;
                }//end for 
                return !isFactor;
            }//end else       
        }//end else     
    }//end testPrime
    
    // method to return integer for which radio button is selected
    private int getButton()
    {
        if (listAllJRadioButton.isSelected())
            return 1;       // first radio button selected
        else if (isPrimeJRadioButton.isSelected())
            return 2;       // second radio button selected
        else if (factorizationJRadioButton.isSelected())
            return 3;       // third radio button selected
        else if (rangeJRadioButton.isSelected())
            return 4;       // fourth radio button selected
        else
            return 5;             
    } 
    
    private void clearJButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // Clear all, set focus on listAllJRadioButton
        listAllJRadioButton.setSelected(true);
        displayJTextArea.setText("");
    }                                            

    private void rangeJRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {                                                   
        // Enable corresponding text field
        if (rangeJRadioButton.isSelected())
        {
            whichRadio = 4;
            lowJTextField.setEditable(true);
            highJTextField.setEditable(true);
            lowJTextField.requestFocus();
        }
        else
        {
            lowJTextField.setText("");
            highJTextField.setText("");
            lowJTextField.setEditable(false);
            highJTextField.setEditable(false);
            displayJTextArea.setText("");
        }        
    }                                                  

    private void factorizationJRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {                                                           
        // Enable corresponding text field
        if (factorizationJRadioButton.isSelected())
        {
            whichRadio = 3;
            factorizationJTextField.setEditable(true);
            factorizationJTextField.requestFocus();
        }
        else
        {
            factorizationJTextField.setText("");
            factorizationJTextField.setEditable(false);
            displayJTextArea.setText("");
        }        
    }                                                          

    private void isPrimeJRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {                                                     
        // Enable corresponding text field
        if (isPrimeJRadioButton.isSelected())
        {
            whichRadio = 2;
            isPrimeJTextField.setEditable(true);
            isPrimeJTextField.requestFocus();
        }
        else
        {
            isPrimeJTextField.setText("");
            isPrimeJTextField.setEditable(false);
            displayJTextArea.setText("");
        }
    }                                                    

    private void listAllJRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {                                                     
        // Enable corresponding text field
        if (listAllJRadioButton.isSelected())
        {
            whichRadio = 1;
            listAllJTextField.setEditable(true);
            listAllJTextField.requestFocus();
        }
        else
        {
            listAllJTextField.setText("");
            listAllJTextField.setEditable(false);
            displayJTextArea.setText("");
        }
    }                                                    

    private void QuitJButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // Quit the program
        System.exit(0);
    }                                           
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {                          
        System.exit(0);
    }                         

    private void listAllJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        
        // Select the corresponding menu choice
        listPrimesJRadioButtonMenuItem.setSelected(true);
    }                                                   

    private void isPrimeJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // Select the corresponding menu choice
        testForPrimeJRadioButtonMenuItem.setSelected(true);
    }                                                   

    private void factorizationJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        // Select the corresponding menu choice
        primeFactorizationJRadioButtonMenuItem.setSelected(true);
    }                                                         

    private void rangeJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // Select the corresponding menu choice
        rangeOfPrimesJRadioButtonMenuItem.setSelected(true);
    }                                                 

    private void listPrimesJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                               
        // Select the corresponding radio button
        isPrimeJRadioButton.setSelected(true);
    }                                                              

    private void testForPrimeJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                                 
        /// Select the corresponding radio button
        isPrimeJRadioButton.setSelected(true);
    }                                                                

    private void primeFactorizationJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                                       
        // Select the corresponding radio button
        factorizationJRadioButton.setSelected(true);
    }                                                                      

    private void rangeOfPrimesJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                                  
        // Select the corresponding radio button
        rangeJRadioButton.setSelected(true);
    }                                                                 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
       // Show main form centered
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	PrimeNumbers myPrimes = new PrimeNumbers();
        int x = (screen.width - myPrimes.getWidth())/2;
        int y = (screen.height - myPrimes.getHeight())/2;
        myPrimes.setBounds(x, y ,myPrimes.getWidth(), myPrimes.getHeight());

        myPrimes.setVisible(true);

    }
