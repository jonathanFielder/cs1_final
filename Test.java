/**
 * Test.java
 * 
 */


//Put any imports below this line.
 
 
/**
 * Testing playground so we don't break things when we don't need to.
 * 
 * 
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    //Put instance variables below this line.  
    
    
    /**
     * No parameter constructor for objects of class Test.
     */
    public Test()
    {
    }
    
    public static void main(String[] args)
    {
        Glossary glossary = new Glossary();
        glossary.readFile("VocabList.txt");
        System.out.println(glossary.getNumEntries());
    }
    
    /**
     * An example of a method.  Describe this method here.
     * 
     * @param  y     A sample parameter for this method.
     * @return     Double the parameter and return it. 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return y * 2;
    }

}
