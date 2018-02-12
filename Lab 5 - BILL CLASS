import java.text.NumberFormat;

public class DentalBill 
{
    
    // class constants
            final double CLEANING = 35.0,
                         CAVITY   = 150.0,
                         XRAY     = 85.0,
                         FLOURIDE = 50.0,
                         ROOT     = 225.0;
            
            double total = 0.0;
            
            StringBuffer display = new StringBuffer();
            
            private String patientName;
            private boolean cleaning;
            private boolean cavity;
            private boolean xray;
            private boolean flouride;
            private boolean rootCanal;
            private boolean other;
            private double amount = 0.0;
            
    //Java docs for default constructor
            public DentalBill()
            {
                patientName = "";
                cleaning = false;
                cavity = false;
                xray = false;
                flouride = false;
                rootCanal = false;
                other = false;
                amount = 0;
            }
            
    //overloaded constructor--needs Javadocs
            public DentalBill(String Name,boolean Cleaning,
                    boolean Cavity, boolean Xray, boolean Flouride, 
                    boolean RootCanal, boolean Other, double otherAmount)
            {
                patientName = Name;
                cleaning = Cleaning;
                cavity = Cavity;
                xray = Xray;
                flouride = Flouride;
                rootCanal = RootCanal;
                other = Other;
                amount = otherAmount;     
            }

    @Override
    public String toString() 
    {
        return "DentalBill{" + "patientName=" + patientName + '}';
    }
            
    //Javadocs needed
    public double getAmount() 
    {
        return amount;
    }
    
    //Javadocs needed
    public double calculateDentalBill()
    {
        total = 0;
        if (cleaning = true)
        {
            total += CLEANING;
        }
        if (cavity = true)
        {
            total += CAVITY;
        }
        if (xray = true)
        {
            total +=XRAY;
        }
        if (flouride = true)
        {
            total += FLOURIDE;
        }
        if (rootCanal = true)
        {
            total += ROOT;
        }
        if (other  = true)
        {
            total += amount;
        }
        return total;
    }
    
    //displays bill
    public StringBuffer displayBill()
    {
        NumberFormat dollars = NumberFormat.getCurrencyInstance();
        display.append(padSpaces("Patient", patientName + '\n'));
        display.append('\n');
        
        if (cleaning = true){
            display.append(padSpaces("Cleaning", dollars.format(CLEANING) 
                    + '\n'));}
        
        if (cavity){
            display.append(padSpaces("Cavity", dollars.format(CAVITY) 
                    + '\n'));}
        
        if (xray){
            display.append(padSpaces("XRay", dollars.format(XRAY) 
                    + '\n'));}
        
        if (flouride){
            display.append(padSpaces("Flouride", dollars.format(FLOURIDE) 
                    + '\n'));}

        if (rootCanal){
            display.append(padSpaces("Root Canal", dollars.format(ROOT) 
                    + '\n'));}
        
        if (other){
            display.append(padSpaces("Other", dollars.format(amount) 
                    + '\n'));}
        
        display.append("-----------------------------------" + '\n');
        display.append(padSpaces("Total", 
                dollars.format((calculateDentalBill())) + '\n'));
        return display;
    }
        private StringBuffer padSpaces(String first, String second){

            final int MAX_SPACES = 35;
            StringBuffer line = new StringBuffer(first);
            
            int numSpaces = MAX_SPACES - first.length() - second.length();
            for (int i = 0; i< numSpaces; i++)
                line.append(" ");
                line.append(second);
                return line;               
}
                    
}
