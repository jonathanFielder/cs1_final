import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * The Game class.
 *
 * @author Jonathan Fielder
 * @version 11/18/22
 */
public class GamePlay
{
    //Put constants here
    final int TEMO_LIST_COUNT = 4;
    //Put instance variables here
    private Glossary glossary;
    private Random generator;
    private Scanner keyboard;
    private int correct;
    private int incorrect;
    /**
     * No-arg GamePlay Constructor.
     *
     */
    public GamePlay() throws FileNotFoundException
    {
        glossary = new Glossary();
        generator = new Random();
        keyboard = new Scanner(System.in);
        glossary.readFile("VocabList.txt");
        correct = 0;
        incorrect = 0;
    }

    /**
     * Two-arg GamePlay Constructor.
     *
     * @param filename filename of terms and definitions to read
     * @param selection menu option of user for game choice
     */
    public GamePlay(String filename)
    {
        glossary = new Glossary();
        generator = new Random();
        keyboard = new Scanner(System.in);
        glossary.readFile(filename);
        correct = 0;
        incorrect = 0;
    }

    /**
     * Method makeSelection.
     *
     * @param selection menu choice of user
     */
    public void makeSelection(int selection)
    {
        switch (selection)
        {
            case 1: playLimitedGame(5);
                break;   
            case 2: playLimitedGame(20);
                break;  
            case 3: System.out.println("See ya next time");
                break;  
            default: System.out.println("out of bounds");
        }
    }

    /**
     * Method playRound.
     *
     */
    public void playRound()
    {
        //make temp array of consat size
        //deside what index correct definition will be at randomly
        //randomly select index in glossary to be term
        //retrieve entry from glossary
        //randomly select entries from glossary (no repeats) to fill rest of array
        //call displayRound -> takes array and index that stores correct answer
        //collect user's answer from keyboard
        //check answer and increase respective field
    }

    /**
     * Method playLimitedGame.
     *
     * @param rounds number of rounds to play
     */
    public void playLimitedGame(int rounds)
    {
        int i = 0;
        while (i < rounds)
        {
            playRound();
            i++;
        }
    }

    /**
     * Method playContinuousGame.
     *
     */
    public void playContinuousGame()
    {

    }

    /**
     * Method displayRound.
     *
     * @param entries entries to build question
     * @param index index of the term to find the correct definition
     */
    public void displayRound(Entry[] entries, int index)
    {
        System.out.println("Select the correct definition"
            + " for the following term: ");
    }

    /**
     * Method printResults.
     *
     */
    public void printResults()
    {

    }
}