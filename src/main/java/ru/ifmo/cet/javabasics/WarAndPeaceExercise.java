package ru.ifmo.cet.javabasics;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarAndPeaceExercise {

    public static String warAndPeace() {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO If word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order if needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10

        //throw new UnsupportedOperationException();

        Map<String, Integer> words = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tome12Path.toString()), "windows-1251")))
        {

            String s;
            while((s=br.readLine())!=null){
                for(String word: s.replaceAll("[^а-яА-Яa-zA-Z]", " ").split(" ")){
                    if (word.length() >= 4){
                        if(words.containsKey(word.toLowerCase())){
                            words.put(word.toLowerCase(), words.get(word.toLowerCase()) + 1);
                        } else{
                            words.put(word.toLowerCase(), 1);
                        }
                    }
                }
            }

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tome34Path.toString()), "windows-1251")))
        {

            String s;
            while((s=br.readLine())!=null){
                for(String word: s.replaceAll("[^а-яА-Яa-zA-Z]", " ").split(" ")){
                    if (word.length() >= 4){
                        if(words.containsKey(word.toLowerCase())){
                            words.put(word.toLowerCase(), words.get(word.toLowerCase()) + 1);
                        } else{
                            words.put(word.toLowerCase(), 1);
                        }
                    }
                }
            }

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        List<Map.Entry<String, Integer>> entryWords = new ArrayList(words.entrySet());
        entryWords.sort(Map.Entry.comparingByKey());
        entryWords.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        StringBuffer buf = new StringBuffer();
        for(Map.Entry<String, Integer> entry: entryWords) {
            if(entry.getValue() >= 10) {
                buf.append(entry.getKey() + " - " + entry.getValue() + "\n");
            }
        }
        buf.deleteCharAt(buf.length()-1);
        return buf.toString();


    }

}