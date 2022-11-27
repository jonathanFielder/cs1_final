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
    final int WORD_COUNT = 210;
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
        numEntries = initialSize;
        entries = new Entry[WORD_COUNT];
    }

    /**
     * Method getNumEntries.
     *
     * @return The number of enries in glossary
     */
    public int getNumEntries()
    {
        if (numEntries >= 1)
        {
            return numEntries;
        }
        else
        {
            return 0;
        }
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
                String[] line = new String[2];
                line = input.nextLine().split(": ");
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
        if (numEntries == entries.length)
        {
            Entry[] largerEntries = new Entry[numEntries + 1];
            entries = largerEntries;
            entries[numEntries + 1] = entry;
        }

    }

    /**
     * Method removeEntry.
     *
     * @param entry to be added
     */
    public void removeEntry(String term)
    {
        for (int i = 0; i < entries.length; i++)
        {
            if (entries[i].getTerm().equals(term) == true)
            {
                entries[i] = new Entry();
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
            if (entries[i].getTerm() != null)
            {
                builder.append(entries[i].getTerm() +"\n");
            }
        }
        return builder.toString();
    }
}