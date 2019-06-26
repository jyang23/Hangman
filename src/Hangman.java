import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {


    public static int randGenerator()
    {
        int value;
        Random r = new Random();
        value = r.nextInt(10);
        return value;
    }

    public static String initial_concatentation(String word, String guess,String current)
    {
        for (int i = 0; i < word.length(); i++)
        {
            if (!(String.valueOf(word.charAt(i))).equals(guess))
            {
                current += "_ ";
            } else {
                current += guess;
            }
        }
        return current;
    }

    public static String concatentation(String word, String guess,String current)
    {
        char[] letters = current.toCharArray();
        String output="";
        String w = "";

        for(int i = 0; i<word.length(); i++)
        {
            w += String.valueOf(word.charAt(i)) + " ";
        }

        char[] word_letters = w.toCharArray();


        for(int i = 0; i<letters.length; i++)
        {
            if(String.valueOf(word_letters[i]).equals(guess))
            {
               letters[i] = guess.charAt(0);
            }
        }

        for(int j = 0; j<letters.length;j++)
        {
            output+=String.valueOf(letters[j]);
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the game of Hangman! Lets PLAY!");

        Scanner in = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>();
        words.add("tree");
        words.add("rain");
        words.add("bear");
        words.add("encourage");
        words.add("promise");
        words.add("soup");
        words.add("chess");
        words.add("insurance");
        words.add("pancakes");
        words.add("stream");

        int pick = randGenerator();
        String word = "";
        String game_word = words.get(pick);
        int word_length = words.get(pick).length();
        String guess = "";
        int strike = 0;

        word = initial_concatentation(game_word, guess, word);

        System.out.println("Here is the word I am thinking of: "+ word);


        while(!guess.equals(game_word))
        {
            if(strike == 6)
            {
                break;
            }

            if(!word.contains("_"))
            {
                break;
            }

            System.out.print("Enter letter or word guess: ");
            guess = in.nextLine();

            if(!game_word.contains(guess))
            {
                strike++;
                System.out.println("You have guessed incorrectly "+strike+"/6 times.");
                if(strike != 6)
                {
                    System.out.println("Your guess so far: " + word+"\n");
                }
            }
            else
            {
                word = concatentation(game_word, guess, word);
                System.out.println("Your guess so far: "+word+"\n");

            }
        }

        if(strike == 6)
        {
            System.out.println("Sorry, you have no more guesses left. The word was " + game_word);
            System.out.println("Thank you for playing!!");
        }
        else
        {
            System.out.println("You've won! The word was " + game_word + "!");
            System.out.println("Thank you for playing!!");
        }
    }
}
