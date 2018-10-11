package ru.ifmo.cet.javabasics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class WarAndPeaceExercise {

    public static String warAndPeace() {
        final Path tome12Path = Paths.get("src", "main", "resources", "WAP12.txt");
        final Path tome34Path = Paths.get("src", "main", "resources", "WAP34.txt");

        // TODO map lowercased words to its amount in text and concatenate its entries.
        // TODO Iff word "котик" occurred in text 23 times then its entry would be "котик - 23\n".
        // TODO Entries in final String should be also sorted by amount and then in alphabetical order iff needed.
        // TODO Also omit any word with lengths less than 4 and frequency less than 10
        Map<String, Integer> words = new HashMap<>();
        List<String> list = new ArrayList<>();

        Stream<String> stream = null;
        try {
            stream = Files.lines(tome12Path, Charset.forName("windows-1251"));
            stream = Stream.concat(stream, Files.lines(tome34Path, Charset.forName("windows-1251")));
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        stream.forEach(str -> list.add(str));
        String text = list.toString();
        text = text.toLowerCase().replaceAll("[^а-яА-Яa-zA-Z]", " ");
        Stream<String> stream1 = Stream.of(text.split(" "));
        stream1
                .filter(word -> word.length() >= 4)
                .forEach(word -> words.put(word,words.getOrDefault(word, 0) + 1));


        List<Map.Entry<String, Integer>> entryWords = new ArrayList(words.entrySet());
        entryWords.sort(Map.Entry.comparingByKey());
        entryWords.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        StringBuffer buf = new StringBuffer();

        Stream<Map.Entry<String, Integer>> stream2 = entryWords.stream();
        stream2
                .filter(enrty -> enrty.getValue() >= 10)
                .forEach(entry -> buf.append(entry.getKey() + " - " + entry.getValue() + "\n"));
        buf.deleteCharAt(buf.length()-1);
        return buf.toString();
        //throw new UnsupportedOperationException();
    }

}