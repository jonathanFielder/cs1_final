//Put required imports here
import java.util.Scanner;
/**
 * The VocabQuiz class.
 * 
 * @author Jonathan Fielder
 * @version 11/22/22
 */
public class VocabQuiz
{
    /**
     * Method main.
     *
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        GamePlay game = new GamePlay("VocabList.txt");
        do
        {
            System.out.print("Select a number from the menu below.\n1 - Print "
                + "All Entries\n2 - Play Short Round\n3 - Play Long Round\n4 - Continuous "
                + "Play\n5 - EXIT");
            int choice = keyboard.nextInt();
            keyboard.nextLine();
            game.makeSelection(choice);
        }
        while(true);
    }
}