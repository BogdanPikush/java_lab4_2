package org.example;

public class Decoder {

    private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static String decodeWord(String encodedWord) {
        if (checkWordOnNumber(encodedWord)) {
            return decodeVowels(encodedWord);
        } else {
            if (isValidWord(encodedWord)) {
                return decodeLetters(encodedWord);
            } else {
                return "Word is not correct";
            }
        }
    }

    public static String decodeVowels(String encodedWord) {
        encodedWord = encodedWord.replaceAll("1", "a");
        encodedWord = encodedWord.replaceAll("2", "e");
        encodedWord = encodedWord.replaceAll("3", "i");
        encodedWord = encodedWord.replaceAll("4", "o");
        encodedWord = encodedWord.replaceAll("5", "u");
        return encodedWord;
    }

    public static String decodeLetters(String encodedWord) {
        StringBuilder decodedWord = new StringBuilder();
        for (int i = 0; i < encodedWord.length(); i++) {
            char c = encodedWord.charAt(i);
            boolean isUpperCase = Character.isUpperCase(c);
            c = Character.toLowerCase(c);
            int j = 25;
            while (j >= 0) {
                if (c == alphabet[j] && !isVowel(c)) {
                    char checkVowel = alphabet[j - 1];
                    if (isVowel(checkVowel)) {
                        j -= 2;
                    } else {
                        j--;
                    }
                    break;
                }
                j--;
            }
            if (j >= 0) {
                char resultChar = alphabet[j];
                if (isUpperCase) {
                    resultChar = Character.toUpperCase(resultChar);
                }
                decodedWord.append(resultChar);
            } else {
                decodedWord.append(encodedWord.charAt(i));
            }
        }
        return decodedWord.toString();
    }

    private static boolean checkWordOnNumber(String word) {
        return word.matches(".*\\d.*");
    }

    private static boolean isVowel(char c) {
        return new String(vowels).indexOf(Character.toLowerCase(c)) != -1;
    }

    public static boolean isValidWord(String word) {
        return !word.contains(" ");
    }

}
