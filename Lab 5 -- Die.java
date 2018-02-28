/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class               Die
* File                Die.java
* Description 	      rolls the die
* @author             Caitlin McMurchie
* Environment 	      PC, Windows 10, jdk1.8.0_151, NetBeans 8.2
* Date                2/14/2018
* @version            1.0
* @see                javax.swing.JOptionPane
* History Log         2/14/2018
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package lab5;

public class Die 
{
    int face = 1;
    
//default constructor
    public Die() 
    {
        face = 6;
    }
    
//overloaded constructor
    public Die(int value)
    {
        face = value;
    }
    public static int roll()
    {
        return (int) (Math.random()*6) + 1;
    }

    public void setFace(int face) 
    {
        this.face = face;
    }

    public int getFace() 
    {
        return face;
    }

    @Override
    public String toString() 
    {
        return "Die{" + "face=" + face + '}';
    }  
}
