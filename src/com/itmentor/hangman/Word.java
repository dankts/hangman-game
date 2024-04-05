package com.itmentor.hangman;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Word {
    private final List<String> wordSecret = new ArrayList<>();

    public Word() {
        readFile();
    }

    private void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))){
            String line;
            while ((line = reader.readLine()) != null) {
                wordSecret.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public String getWordSecret() {
        return wordSecret.get((int) (Math.random() * wordSecret.size()));
    }
}
