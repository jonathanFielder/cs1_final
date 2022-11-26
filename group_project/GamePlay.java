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
    final int TEMP_LIST_COUNT = 4;
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

    // getters
    /**
     * returns correct.
     * @return correct - int
     */
    public int getCorrect()
    {
        return correct;
    }

    /**
     * returns incorrect.
     * @return incorrect - int
     */
    public int getIncorrect()
    {
        return incorrect;
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
            case 1: System.out.print(glossary.toString());
                break;
            case 2: playLimitedGame(5);
                break;   
            case 3: playLimitedGame(20);
                break;  
            case 4: playContinuousGame();
                break;  
            default: System.out.println("See ya next time");
        }
    }

    /**
     * Method playRound.
     *
     */
    public void playRound()
    {
        // array of entries that will be passed to displayRound()
        Entry[] gameArray = new Entry[TEMP_LIST_COUNT];
        // array that stores indexes that have been used from glossary in gameArray
        int[] indexArray = new int[TEMP_LIST_COUNT];

        for (int q = 0; q < indexArray.length; q++)
        {
            indexArray[q] = -1; // inits confirmation array all to -1
        }
        //deside what index correct definition will be at randomly
        int correctIndex = generator.nextInt(TEMP_LIST_COUNT);
        //randomly select index in glossary to be term
        int termIndex = generator.nextInt(glossary.getNumEntries());
        //retrieve entry from glossary
        gameArray[correctIndex] = glossary.getEntries()[termIndex];
        //randomly select entries from glossary (no repeats) to fill rest of array
        int i = 0;
        int randomIndex = 0;
        boolean pass = false;
        while (i < gameArray.length)
        {
            // make sure i is not the correct answer space
            if (i != correctIndex) 
            {
                randomIndex = generator.nextInt(glossary.getNumEntries());
                while (randomIndex == termIndex)
                {
                    // make sure random index is not same as answer index
                    randomIndex = generator.nextInt(glossary.getNumEntries());
                }

                gameArray[i] = glossary.getEntries()[randomIndex];

            }
            i++;
        }

        //call displayRound -> takes array and index that stores correct answer
        displayRound(gameArray, correctIndex);
        //collect user's answer from keyboard
        int userAnswer = keyboard.nextInt();
        keyboard.nextLine();
        //check answer and increase respective field
        if (userAnswer - 1 == correctIndex)
        {
            correct += 1;
        }
        else
        {
            incorrect += 1;
        }
        //show how the round effected the score
        printResults();
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
        int cont = 0;
        while(cont == 0)
        {
            playRound();
            System.out.println("Would you like to play another round " 
                + "(enter 0 to continue or -1 to quit)\t");
            cont = keyboard.nextInt();
            keyboard.nextLine();
        }
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
        System.out.println(entries[index].getTerm());
        for (int i = 0; i < entries.length; i++)
        {
            System.out.printf("%d %s%n", i+1, entries[i].getDefinition());
        }
    }

    /**
     * Method printResults.
     *
     */
    public void printResults()
    {
        System.out.printf("Correct:%t%-8d%nIncorrect:%t%-8d", 
            getCorrect(), getIncorrect());
    }

}