package Primes;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*	Class:		Primes
*	File:		PrimeNumbers.java
*	Description:	Displays prime numbers, tests for primeness, prime
*                       decomposition, and range of primes.
*	@author:	Caitlin McMurchie
*	Environment:	PC, Windows 10, jdk1.8.0_151, NetBeans 8.2
*	Date:		2/26/2018
*	@version	1.0
*       @see           	javax.swing.JOptionPane
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
    
        //set up image icon for JFrame
        Image imageJFrame = Toolkit.getDefaultToolkit().getImage("src/walker.jpg");
        
        //set image for JFrame
        setIconImage(imageJFrame);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });                     

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
        displayTextArea.setText("");    // clear display area
        int whichButton = getButton();  // decide which radio button is selected
        switch(whichButton)
        {
            case 1:         //display the first n primes
                listPrimes();
                break;
            case 2:         //display yes or no for test of primness
                //testPrimes();     //TO DO
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
    // listPrimes();
    // display the first n prime numbers
    private void listPrimes()
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
        StringBuffer ouput = new StringBuffer();
        
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
        }
        catch(NumberFormatException numexp)
        {
             // display error message
             JOptionPane.showMessageDialog( null,
               message,"Illegal Input", JOptionPane.WARNING_MESSAGE );
             listAllJTextField.requestFocus();
             listAllJTextField.selectAll();
        }
    }
    boolean testPrime(int n)
    {
        //TO DO
    }
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
        displayTextArea.setText("");
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
            displayTextArea.setText("");
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
            displayTextArea.setText("");
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
            displayTextArea.setText("");
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
            displayTextArea.setText("");
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
