package com.itmentor.hangman;

import java.util.*;

public class HangmanGame {
    private final Scanner scanner = new Scanner(System.in);
    private final char[] hiddenWord;
    private final Set<Character> guessLetters = new HashSet<>();
    private final String secretWord;
    private int errorsCount = 0;

    public HangmanGame(Word word) {
        this.secretWord = word.getWordSecret();
        this.hiddenWord = secretWord.toCharArray();
        Arrays.fill(hiddenWord, '_');
    }

    public void processGame() {
        System.out.println("Введите символ");
        while (!isWordGuessed() && errorsCount < 6) {
            PicHangman.printStage(errorsCount);
            char inputLetter = scanner.next().toLowerCase().charAt(0);
            if (guessLetters.contains(inputLetter)) {
                System.out.println("Вы уже вводили эту букву!");
            } else {
                guessLetters.add(inputLetter);
                if (secretWord.indexOf(inputLetter) != -1) {
                    revealLetter(inputLetter);
                } else {
                    System.out.println("Этой буквы нет в слове!");
                    System.out.println("-------------------------------------------");
                    errorsCount++;
                }
            }
            System.out.println("Ошибок - " + errorsCount);
            System.out.println("Слово - " + new String(hiddenWord));
        }

        printEndGame();
    }

    private void revealLetter(char c) {
        for (int i = 0; i < hiddenWord.length; i++) {
            if (secretWord.charAt(i) == c) {
                hiddenWord[i] = secretWord.charAt(i);
            }
        }
    }

    private boolean isWordGuessed() {
        return String.valueOf(hiddenWord).equals(secretWord);
    }

    private void printEndGame() {
        if (isWordGuessed()) {
            System.out.println("Вы выйграли!");
        } else {
            System.out.println("Вы проиграли (:");
            System.out.println("Правильно слово - " + secretWord);
        }
    }
}
