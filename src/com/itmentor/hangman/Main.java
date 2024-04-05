package com.itmentor.hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputAnswer;
        while (true){
            System.out.println("Добро пожаловать в игру HangMan");
            System.out.println("Чтобы начать игру введите: [YES] - to start game or [END] - to exit");
            inputAnswer = scanner.next();
            switch (inputAnswer) {
                case "YES":
                    Word word = new Word();
                    HangmanGame gameService = new HangmanGame(word);
                    gameService.processGame();
                    break;
                case "END":
                    System.exit(0);
                default:
                    System.out.println("Неверный ввод команды. Попробуйте еще раз!");
            }
        }
    }
}
