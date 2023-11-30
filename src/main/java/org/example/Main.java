package org.example;

import java.util.Scanner;

import static org.example.Decoder.decodeWord;

public class Main {
    public static void main(String[] args) {

        String encodedMessage1 = "t2st3ng";
        String encodedMessage2 = "vetviph";

        System.out.println("Decoded Message 1: " + decodeWord(encodedMessage1));
        System.out.println("Decoded Message 2: " + decodeWord(encodedMessage2));

        Scanner scanner = new Scanner(System.in);

        System.out.print("Write your word: ");
        String encodedMessage = scanner.nextLine();

        System.out.println("Decoded Message: " + decodeWord(encodedMessage));

        scanner.close();
    }
}