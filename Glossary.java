/**
 * The Glossary class.
 *
 * @author Sean Choi
 * @version 11/18/22
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Glossary
{
    //Put constants here
    public static final int WORD_COUNT = 210;
    private int numEntries;
    private Entry[] entries;

    /**
     * No-arg constructor for objects of class Glossary.
     */
    public Glossary()
    {
        numEntries = 0;
        entries = new Entry[WORD_COUNT];
    }

    /**
     * N-arg constructor for objects of class Glossary.
     * 
     * @param initialSize size of entry array for glossary
     */
    public Glossary(int initialSize)
    {
        numEntries = 0;
        entries = new Entry[initialSize];
    }

    /**
     * Method getNumEntries.
     *
     * @return The number of enries in glossary
     */
    public int getNumEntries()
    {

        return numEntries;
    }

    /**
     * Method getEntries.
     *
     * @return The entries in the glossary
     */
    public Entry[] getEntries()
    {
        return entries;
    }

    /**
     * Method readFile.
     *
     * @param filename name of file to read
     */
    public void readFile(String filename) 
    {
        try
        {
            File file = new File(filename);
            Scanner input = new Scanner(file);
            while (input.hasNext())
            {
                String[] line = input.nextLine().split(":");
                addEntry(new Entry(line[0].trim(), line[1].trim()));
            }

            input.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found.");
        }
    }

    /**
     * Method addEntry.
     *
     * @param entry to be added
     */
    public void addEntry(Entry entry)
    {

        entries[numEntries] = entry;
        // check this
        numEntries += 1;

    }
        
    /**
     * Method removeEntry.
     *
     * @param entry to be added
     */
    public void removeEntry(String term)
    {
        int index = -1;
        for (int i = 0; i < numEntries; i++)
        {
            if (entries[i].getTerm().equals(term) == true)
            {
                entries[i] = null;
                index = i;                
            }
        }
        numEntries--;
        shift(index);
    }

    /**
     * Shift index.
     * 
     * @param index - int
     */
    public void shift(int index)
    {
        if (index != -1)
        {
            for (int i = index; i < entries.length - 1; i++)
            {
                entries[i] = entries[i + 1];
            }
        }
    }

    
    /**
     * Method toString.
     *
     * @return The string representation of the glossary
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < entries.length; i++)
        {
            if (entries[i] != null)
            {
                builder.append(entries[i].toString() +"\n");
            }
        }
        return builder.toString();

    }
}