package edu.wvup.acottri9;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        WordUnscrambler wordUnscrambler = new WordUnscrambler("G:\\WordUnscrambler\\wordlist.txt");
        Scanner scanner = new Scanner(System.in);
       System.out.println("What is the word to unscramble?");

      String word = scanner.nextLine();
      String result = wordUnscrambler.findUnScrambledWord(word);

      if(result.isEmpty())
      {
          System.out.println("After searching, no matches for an unscrambled version of the word were found.");
      }
      else
      {
          System.out.println("For the word: " + word + " ; the unscrambled version is " + result + ".");
      }
    }
}
