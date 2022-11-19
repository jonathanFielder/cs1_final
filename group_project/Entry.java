/**
 * Entry.java
 * 
 */


//Put any imports below this line.
 
 
/**
 * Short, one-line description of Entry class here.
 * 
 * Optionally, include a paragraph that provides a more 
 * detailed description.
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entry
{
    //Put instance variables below this line.  
    private String term;
    private String definition;
    
    /**
     * No parameter constructor for objects of class Entry.
     */
    public Entry()
    {
        
    }
    
    public Entry(String term)
    {
        this.term = term;
    }
    
    public Entry(String term, String definition)
    {
        this.term = term;
        this.definition = definition;
    }
    
    public void setTerm(String term)
    {
        this.term = term;
    }
    
    public void setDefinition(String definition)
    {
        this.definition = definition;
    }
    
    public String getTerm()
    {
        return term;
    }
    
    public String getDefinition()
    {
        return definition;
    }
    
    
    public String toString()
    {
        return term + " - " + definition + ".\n";
    }
    
    public boolean equals(Entry obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (obj == this)
        {
            return true;
        }
        return this.getDefinition().equals(obj.getDefinition());
    }
}
