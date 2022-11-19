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
 * @author Erik Page 
 * @version 19/11/22
 */
public class Entry
{  
    private String term;
    private String definition;
    
    /**
     * No-arg constructor for objects of class Entry.
     */
    public Entry()
    {
    
    }
    
    /**
     * One-arg constructor for objects of class Entry.
     */
    public Entry(String term)
    {
        this.term = term;
    }
    
    /**
     * Two-arg constructor for objects of class Entry.
     */    
    public Entry(String term, String definition)
    {
        this.term = term;
        this.definition = definition;
    }
    
    //set methods
    /**
     * Method setTerm.
     *
     * @param term entry term
     */    
    public void setTerm(String term)
    {
        this.term = term;
    }
    
    /**
     * Method setDefinition.
     *
     * @param definition entry definition
     */    
    public void setDefinition(String definition)
    {
        this.definition = definition;
    }
    
    //get methods
    /**
     * Method getTerm.
     *
     * @return The entry term
     */    
    public String getTerm()
    {
        return term;
    }
    
    /**
     * Method getDefinition.
     *
     * @return The entry definition
     */    
    public String getDefinition()
    {
        return definition;
    }
    
    /**
     * Method toString.
     *
     * @return The string representation of entry
     */    
    public String toString()
    {
        return term + " - " + definition + ".\n";
    }
    
    /**
     * Method equals.
     *
     * @param entry entry to compare to
     * @return true if this entry and param entry are the same
     */    
    public boolean equals(Entry entry)
    {
        if (entry == null)
        {
            return false;
        }
        if (entry == this)
        {
            return true;
        }
        return this.getDefinition().equals(entry.getDefinition());
    }
}
