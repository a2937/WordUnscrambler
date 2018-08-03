package edu.wvup.acottri9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordUnscrambler
{
    private Scanner scanner;
    private String fileName;
    private static final Logger LOGGER = Logger.getLogger(WordUnscrambler.class.getName() );
    private List<String> linesList;
    public WordUnscrambler()
    {

    }


    public WordUnscrambler(String fileName)
    {
        setFileName(fileName);
    }


    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        if(!fileName.isEmpty())
        {

            this.fileName = fileName;
            try {
                scanner = new Scanner(new File(fileName));
                initializeDictionary();
            } catch (FileNotFoundException e)
            {
                LOGGER.log( Level.SEVERE,e.toString());
            }
        }

    }

    private void initializeDictionary()
    {
        StringBuilder completeString = new StringBuilder();
        while ( scanner.hasNextLine( ) )
        {
            completeString.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        String[] lines = completeString.toString().split("\n");
        linesList = new ArrayList<String>(lines.length);
        linesList.addAll(Arrays.asList(lines));
        Collections.sort(linesList);
    }

    public String findUnScrambledWord(String scrambledWord)
    {
        if(scrambledWord.isEmpty())
        {
            return "";
        }
        String realWord = "";
        for(String word : linesList)
        {

            if(word.length() == scrambledWord.length())
            {
                boolean leftNaturally = true;
                for(char character : scrambledWord.toCharArray())
                {
                    if(!word.contains(Character.toString(character).trim()))
                    {
                        leftNaturally = false;
                        break;
                    }
                }
                if(leftNaturally)
                {
                    realWord = word;
                    break;
                }
            }
        }
        return realWord;
    }
}
