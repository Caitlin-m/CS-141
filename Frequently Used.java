this.setLocationRelativeTo(null);   //centers form
this.getRootPane().setDefaultButton(JButton); // sets default button
this.setIconImage(Toolkit.getDefaultToolkit().getImage("/src/Picture.jpg"));// set icon for form
 ------------------------------------------------------------------------------------------------------------------------
private void setDate()
{   
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    Date date = new Date();
    this.setTitle("project name --" + dateFormat.format(date));
}
------------------------------------------------------------------------------------------------------------------------
private StringBuffer padSpaces(String first, String second)
{

     final int MAX_SPACES = 35;
     StringBuffer line = new StringBuffer(first);
     
     int numSpaces = MAX_SPACES - first.length() - second.length();
      for (int i = 0; i< numSpaces; i++)
      {
         line.append(" ");
         line.append(second);
         return line;
       }
}
------------------------------------------------------------------------------------------------------------------------
catch(NumberFormatException numexp)// display error message
{
   JOptionPane.showMessageDialog( null,
        message,"Illegal Input", JOptionPane.WARNING_MESSAGE );
   listAllJTextField.requestFocus();
   listAllJTextField.selectAll();
}
---------------------------------------------------------------------------------------------------------------------------
    public static void insertionSort(int[] array)
    {
        int i,j;
        for ( i = 0; i < array.length; i ++)
        {
            int a = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > a)
            {
                array[j + 1] = array[j];
                j--;
            }
            array[j + i] = a;
        }
    }

---------------------------------------------------------------------------------------------------------------------------
    public static void selectionSort(int[] array)
    {
        for(int i = 0; i <array.length; i++)
        {
            int min = findMinimum(array, i);
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
---------------------------------------------------------------------------------------------------------------------------
    public static int findMinimum(int[] anArray , int i)
    {
        int j, min = i;
        for (j = i + 1; j < anArray.length; j++)
        {
           if( anArray[j] < anArray[min])
               min = j;
        }
        return  min;
    }
---------------------------------------------------------------------------------------------------------------------------
    public static void bubbleSort(int[] array, int len)
    {
        int temp;
        int high = len -1;
        for(int a  = 0; a < high - a; a++)
        {
            for (int b = 0; b < high - a; b++)
            {
                if(array[b] > array[b + 1])
                {
                    temp =array[b];
                    array[b] = array[b +1 ];
                    array[b + 1] = temp;
                }
            }
        }
    }
---------------------------------------------------------------------------------------------------------------------------
    private static int linearSearch(int[] anArray, int key) 
    {
        for (int i = 0; i < anArray.length; i++)
        {
            if(anArray[i] == key)
            {
                return i;
            }
        }
        return -1;
    }
----------------------------------------------------------------------------------------------------------------------------
    public static int binarySearch(int[] anArray, int key) 
    {
        int low = 0;
        int high = (anArray.length - 1);    //.length will give you how many 
        //items are in the array, not the index number
        int middle;
        while (low <= high)
        {
            middle  = (low + high)/2;
            if(key == anArray[middle])
                return middle;
            else if (key < anArray[middle])
                high = middle -1;
            else
                low = middle +1;
        }
        return -1;
    }
---------------------------------------------------------------------------------------------------------------------------
    public static int findMax(int[] anArray)
    {
        int maximum = anArray[0];
        for (int i = 1; i< anArray.length;i++)
        {
            if(maximum < anArray[i])
            {
                maximum = anArray[i];
            }
        }    
        return maximum;
    }
---------------------------------------------------------------------------------------------------------------------------
    private void AboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // shows about form
        About myAbout = new About(this, true);
        myAbout.setVisible(true);
    } 
------------------------------------------------------------------------------------------------------------------------
 Scanner input = new Scanner(new File("src/" + name)); // reads file
