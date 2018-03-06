/*
Write a compleate java console program that prompts the user for 
how many randome integers to generate in the range [-12,67], stores
them in an array of integers and preform the following:
[X]    1) display the array by calling displayArray() method 
[X]    2) finds the min/max in the array
[X]    3) copies the array into another array in at least two diffrent methods
[X]    4) sorts the array vie insertion/selection method
[]    5) finds mean, median, and standard deviation
[X]    6) prompt user for key then search the array for the key using a linear 
            or binary search algorithm, if the key is found return the position
                else return -1.
*/
package finalexamquestions;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FinalExamQuestions {

    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        Random myRandom = new Random();
        System.out.println("How many random integers in the"
                + " range of [-12, 67] do you want?");
        int count = keyboard.nextInt();
        
        //declare an integer array with max numbers
        int[] myArray = new int[count];
        
        //generate random integers and put them in tha array
        for(int i = 0; i < myArray.length; i++)
        {
            myArray[i] = myRandom.nextInt(80) - 12;
        }
        
        //display the array by calling method
        displayArray(myArray);
        System.out.println();
        //make a copy array
        //Case 1: no new memory created
        //int[] copyArray = myArray;
        //Case 2:
        int[] copyArray= new int[myArray.length];
        System.out.println("The copy array is: ");
        displayArray(copyArray);
        System.out.println();
        System.arraycopy(myArray, 0, copyArray, 0, myArray.length);
        for(int i = 0; i < myArray.length; i++)
        {
            copyArray[i] = myArray[i];
        }
        System.out.println("The copy array is: ");
        displayArray(copyArray);
        System.out.println();
        
    //find max and min element in array
    int max = findMax(myArray);
    System.out.println("The largest value in the array is: " + max);
    int min = findMin(myArray);
    System.out.println("The smalles value in the array is: " + min);
    
    //search the array for a given key
        System.out.println("Search for what? ");
        int key = keyboard.nextInt();
        int posistion = linearSearch(myArray, key);
        if(posistion < 0)
            System.out.println(key + " is not in the array");
        else
            System.out.println(key + " is in the array at index " + posistion);
     
    //sort the array in ascending order -- by "cheating"
    //selectionSort(myArray);
    //bubbleSort(myArray);
    //array.sort(myArray);
    insertionSort(myArray);
        System.out.println("The original array sorted is: ");
        displayArray(myArray);
        System.out.println("");
    }
    
//insertion sort
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

    //selection sort
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
    //buble sort -- not a good one
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
    
        public static int findMin(int[] anArray)
    {
        int minimum = anArray[0];
        for (int i = 1; i< anArray.length;i++)
        {
            if(minimum > anArray[i])
            {
                minimum = anArray[i];
            }
        }    
        return minimum;
    }
    
    private static void displayArray(int[] anArray) 
    {
        for(int i = 0; i< anArray.length; i++)
        {
            System.out.print(anArray[i] + " ");
            if((i+1) % 10 == 0)
                System.out.println();
        }
    }
}
