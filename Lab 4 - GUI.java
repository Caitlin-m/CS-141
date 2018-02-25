
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.lang.Object;
import java.awt.print.Printable;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class 		           
* File  		           
* Description 	      
* @author             Caitlin McMurchie
* Environment 	      PC, Windows 10, jdk1.8.0_151, NetBeans 8.2
* Date 			           
* @version            1.0
* @see                javax.swing.JOptionPane
* History Log 	
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class DentalGUI extends javax.swing.JFrame 
{
    //class leval instance variables
    String PatientsFile = "\\\\zeus\\profile$\\955331307\\My Documents\\CS 141\\DentalApplication\\src\\PatientNames.txt";
    String InvioceFile = "\\\\zeus\\profile$\\955331307\\My Documents\\CS 141\\DentalApplication\\src\\Invioce.txt";
    String ImageFile = "\\\\zeus\\profile$\\955331307\\My Documents\\CS 141\\DentalApplication\\src\\Parrot.jpg";
    NumberFormat dollars = NumberFormat.getCurrencyInstance();
    StringBuffer display = new StringBuffer("");
    double historyTotal = 0.0;      //Total bills

    /**
     * Default Constructor -- Creates new form DetalGUI
     */
    public DentalGUI() {
        initComponents();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(ImageFile));
        this.getRootPane().setDefaultButton(CalculateJButton);
        setLocationRelativeTo(null);
        readPatients(PatientsFile); 
    }
    public void readPatients(String file)
    {
        String inputLine, patientName;
        try
        {
            PatientJComboBox.removeAllItems();
            FileReader freader = new FileReader(file);
            BufferedReader inputFile = new BufferedReader(freader);
            //Alternativly, use scanner class for easier reading
            inputLine = inputFile.readLine();
            
            while (inputLine != null)
            {
                PatientJComboBox.addItem(inputLine);
                inputLine = inputFile.readLine();
            }
        inputFile.close();
        }
        catch(IOException exp)
        {
            exp.printStackTrace();
        }
    }

    //JAVADOCS
    private void CalculateJButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 

        final double MAX_OTHER = 10000000.0;    //max fee for other services
        double total;
        String message = "Please enter a name and check at least one item";
        Object patient = PatientJComboBox.getSelectedItem(); //gets patient name
        
        if ( ( patient == null) ||
                    ( !CleaningJCheckBox.isSelected() &&
                    !CavityJCheckBox.isSelected() &&
                    !XRayJCheckBox.isSelected() &&
                    !FlourideJCheckBox.isSelected() &&
                    !RootCanalJCheckBox.isSelected() &&
                    !OtherJCheckBox.isSelected() )
                )
        {
            JOptionPane.showMessageDialog( null, message, "Missing Information"
                    + "(No patient selected  or no operations selected)",
                    JOptionPane.WARNING_MESSAGE );   
        }
        else
        {
            try
            {
                message = "Illeagal type--must be a positive number";
                double OtherAmount = OtherJCheckBox.isSelected()?
                        Double.parseDouble(OtherJTextField.getText()):0.0;
                if(OtherJCheckBox.isSelected() && (OtherAmount <= 0.0 ||
                        OtherAmount > MAX_OTHER))
                {
                    message = "Illegal range -- please enter a positive "
                            + "less than" + dollars.format(MAX_OTHER);
                    throw new NumberFormatException();
                }
                DentalBill myBill = new DentalBill(patient.toString(), 
                        CleaningJCheckBox.isSelected(),
                        CavityJCheckBox.isSelected(), 
                        XRayJCheckBox.isSelected(),
                        FlourideJCheckBox.isSelected(), 
                        RootCanalJCheckBox.isSelected(),
                        OtherJCheckBox.isSelected(), 
                        OtherAmount); 
                total = myBill.calculateDentalBill();
                TotalJTextField.setText(dollars. format(total));
                display.delete(0, display.length());
                display = myBill.displayBill();
                InvioceJTextArea.setText(display.toString());
                
 
            }
            catch(NumberFormatException nume)
            {
                JOptionPane.showMessageDialog( null, message, "Invalid Data",
                    JOptionPane.WARNING_MESSAGE );
                OtherJTextField.requestFocus();
            }
        }
    }                                                

    private void SaveJButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        try
        {
            FileWriter fwrighter = new FileWriter(InvioceFile, false);
            PrintWriter outputFile = new PrintWriter(fwrighter);
            
            outputFile.println(display.toString());
            outputFile.close();
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, "File not saved", "File Write "
                    + "Error", JOptionPane.WARNING_MESSAGE);

        }
                
    }                                           

    private void PrintInvioceJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        try {
            // Print content of the JTextArea
            InvioceJTextArea.print();
        } catch (PrinterException ex) {
            Logger.getLogger(DentalGUI.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
    }                                                     

    private void PrintJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // Call Print Utilites class
        PrintUtilities.printComponent(this);
    }                                                         
}
