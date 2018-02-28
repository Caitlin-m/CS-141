/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class               DiceGUI
* File                DiceGUI.java
* Description 	      dice game idk
* @author             Caitlin McMurchie
* Environment 	      PC, Windows 10, jdk1.8.0_151, NetBeans 8.2
* Date                2/12/2018
* @version            1.0
* @see                javax.swing.JOptionPane
* History Log         2/12/2018, 2/14/2018
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package lab5;

import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DiceGUI extends javax.swing.JFrame {

    //class instance variables
    int total = 0, 
        freq1 = 0, 
        freq2 = 0, 
        freq3 = 0, 
        freq4 = 0, 
        freq5 = 0, 
        freq6 = 0;
    
    double perc1 = 0,
           perc2 = 0,
           perc3 = 0,
           perc4 = 0,
           perc5 = 0,
           perc6 = 0;
    
    Die die1 = new Die(Die.roll());
    Die die2 = new Die(Die.roll());
    
    /**
     * Default constructor--creates a new instance of Die
     */
    public DiceGUI() 
    {
        initComponents();
    }

    private void otherJRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) 
    {                                               
        // 
        if(otherJRadioButton.isSelected())
        {
            
        }
        
    }                                              

    private void otherJRadioButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {                                                  
        // TODO add your handling code here:
        otherJTextField.setEditable(rootPaneCheckingEnabled);
    }                                                 

    private void rollJButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {                                            
        // TODO add your handling code here:
        final int MAX = 1000000;
        try
        {
            int counter = getCount();
            if (counter < 1 ||counter > MAX)
                throw new NumberFormatException();
            for (int i = 0; i < counter; i++)
            {
                total += 2;
                die1.setFace(Die.roll());
                die2.setFace(Die.roll());
                setFrequency(die1.getFace());
                setFrequency(die2.getFace());
            }// end for
            
            //sets images to labels by calling a method
            setLabel(dieOneJLabel, "src/Images/", die1.getFace());
            setLabel(dieTwoJLabel, "src/Images/", die2.getFace());
            
            
            //set percentages
            perc1 = (double)freq1/total;
            perc2 = (double)freq2/total;
            perc3 = (double)freq3/total;
            perc4 = (double)freq4/total;
            perc5 = (double)freq5/total;
            perc6 = (double)freq6/total;
            
            //output results
            displayResults();
        }
        catch(java.lang.NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Enter a positive integer",
                "Input Error!", JOptionPane.ERROR_MESSAGE);
            otherJTextField.requestFocus();
            otherJTextField.selectAll();
        }
    }                                           

    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {                                            
        System.exit(0);
    }                                           
   
    public void displayResults()
    {
        DecimalFormat percent = new DecimalFormat("#,##0.00%");
        StringBuffer output = new StringBuffer("Face  Frequency  Percentage\n");
        output.append(" 1.      " + freq1 + "\t  " + percent.format(perc1 )+ '\n');
        output.append(" 2.      " + freq2 + "\t  " + percent.format(perc2 )+ '\n');
        output.append(" 3.      " + freq3 + "\t  " + percent.format(perc3 )+ '\n');
        output.append(" 4.      " + freq4 + "\t  " + percent.format(perc4 )+ '\n');
        output.append(" 5.      " + freq5 + "\t  " + percent.format(perc5 )+ '\n');
        output.append(" 6.      " + freq6 + "\t  " + percent.format(perc6 )+ '\n');
        resultsJTextArea.setText(output.toString());
    }
    
    private void setLabel(JLabel dieLabel, String folder, int face) 
    {
        String image = folder + "die" + face + ".png";
        dieLabel.setIcon(new ImageIcon(image));
    }
    public void setFrequency(int value)
    {
    switch(value)
    {
        case 1:
            freq1 ++;
             break;
        case 2:
            freq2 ++;
             break;
        case 3:
            freq3 ++;
             break;
        case 4:
            freq4 ++;
             break;
        case 5:
            freq5 ++;
             break;
        case 6:
            freq6 ++;
             break;
    }
}
    
    private int getCount()
{
    if (oneJRadioButton.isSelected())
            return 5;
    if (tenJRadioButton.isSelected())
        return 10;
    if (hundredJRadioButton.isSelected())
        return 100;
    if (otherJRadioButton.isSelected())
        return Integer.parseInt(otherJTextField.getText());
    else
        return 1; 
}
