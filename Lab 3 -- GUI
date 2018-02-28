
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class 		    
* File  		    ShippingGUI.java
* Description               calculates shipping rates for different regions
* @author		    Caitlin McMurchie
* Environment               PC, Windows 10, jdk1.8, NetBeans 8.2
* Date 			    1/22/2018
* @version                  1.0
* @see 			    javax.swing.JOptionPane
* History Log 	
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
 //Package Lab3;
/*
 * @author Caitlin McMurchie
 */
public class ShippingGUI extends javax.swing.JFrame {

    /**
     * Default constructor--Creates new form ShippingGUI
     * sets date
     * centers form
     * sets icon
     * sets calculate button to default
     */
    private void setDate()
    {   
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date now = new Date();
        this.setTitle("Loan Calculator--" + dateFormat.format(now));
    }
    public ShippingGUI()
    {
        initComponents();
        //sets calculate button as default
        this.getRootPane().setDefaultButton(CalculateJButton);
        //sets icon
        //this.setIconImage(Toolkit.getDefaultToolKit().getImage(" .jpg"));
        //centers the form
        setLocationRelativeTo(null);
                // makes JSpinners read-only (not edatable)
                ((JSpinner.DefaultEditor) PoundsJSpinner.getEditor()).getTextField().setEditable(false);
                ((JSpinner.DefaultEditor) OuncesJSpinner.getEditor()).getTextField().setEditable(false);
    }                       

    private void PrintJButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // Use the PrintUtilities class to print the GUI
       // PrintUtilities.printComponents(this);
    }                                            

    private void PrintJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // Call printJButtonActionPreformed
        // PrintJMenuItemActionPerformed(evt);
        PrintJButton.doClick();
    }                                              

    private void QuitJButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // Ends the application
        System.exit(0);       
    }                                           

    private void ExitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // Calls the QuitJButtonActionPerformed
        QuitJButton.doClick();
    }                                             

    private void CalculateJButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // calculates the shipping charges
        
        //region charges
        final double REGION_1 = 0.37;
        final double REGION_2 = 0.38;
        final double REGION_3 = 0.41;
        final double REGION_4 = 0.51;
        final double REGION_5 = 0.56;
        final double REGION_6 = 0.61;
        final double REGION_7 = 0.67;
        final double REGION_8 = 0.93;
        
        // types of delivery charges
        final double NEXT_DAY = 20, EXPRESS = 10.0, PRIORITY = 5.0;
        try
        {
            //decleration of variables
            int id = 0, pounds = 0, ounces = 0, region = 1;
            String typeShipping = "Ground", idString = "";
            double charges = 0.0, rate = REGION_1;
            
            DecimalFormat dollars = new DecimalFormat("$#,##0.00");
            
            //read input from GUI
            if (idString.length() !=6)
                throw new NumberFormatException();
            pounds = Integer.parseInt(PoundsJSpinner.getValue().toString());
            ounces = Integer.parseInt(OuncesJSpinner.getValue().toString());
            region = Integer.parseInt(RegionJComboBox.getSelectedItem().toString());
            typeShipping = TypeJComboBox.getSelectedItem().toString();
            
        }   
        catch (NumberFormatException nexp)
        {
           JOptionPane.showMessageDialog(this, "Must have 6 digits for ID SKU");
           //idJFormattedTextField.requestFocus();
           //idJFormattedTextField.selectAll();
        }
    }                                                

    private void AboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // shows about form
        About myAbout = new About(this, true);
        myAbout.setVisible(true);
    }                                              

    private void CopyrightJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // shows copyright form
        Copyright myCopyright = new Copyright(this, true);
        myCopyright.setVisible(true);
    }                                                  
