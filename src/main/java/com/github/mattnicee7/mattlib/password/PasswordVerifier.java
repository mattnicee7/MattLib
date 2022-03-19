package com.github.mattnicee7.mattlib.password;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
public class PasswordVerifier {

    private char[] symbolsPattern = "!@#$%¨&*()-=+".toCharArray();
    private char[] lowerLettersPattern = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private char[] upperLettersPattern = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private int minLength;
    private int maxLength;
    private int minSymbols;
    private int minLowerLetter;
    private int minUpperLetter;

    private boolean repeatedCharacters;
    private boolean removeBlankSpaces = true;

    public boolean verify(@NotNull String password) {
        if (removeBlankSpaces)
            password = password.replace(" ", "");

        if (!checkIfHasMinLength(password))
            return false;

        if (checkIfHasMaxLength(password))
            return false;

        if (getPatternCount(symbolsPattern, password) < minSymbols)
            return false;

        if (getPatternCount(lowerLettersPattern, password) < minLowerLetter)
            return false;

        if (getPatternCount(upperLettersPattern, password) < minUpperLetter)
            return false;

        if (repeatedCharacters && hasRepeatedCharacters(password))
            return false;

        return true;
    }

    private boolean checkIfHasMinLength(@NotNull String password) {
        return password.length() >= minLength;
    }

    private boolean checkIfHasMaxLength(@NotNull String password) {
        return maxLength > 0 && password.length() >= maxLength;
    }

    private int getPatternCount(char[] pattern, @NotNull String password) {
        return (int) password.chars().mapToObj(it -> (char) it).filter(it -> equals(it, pattern)).count();
    }

    private boolean hasRepeatedCharacters(@NotNull String password) {
        final List<Character> characters = new ArrayList<>();
        char[] passwordArray = password.toCharArray();

        for (char character : passwordArray) {
            if (characters.contains(character))
                return false;

            characters.add(character);
        }

        return false;
    }

    private boolean equals(char character, char[] array) {
        for (char element : array)
            if (element == character)
                return true;

        return false;
    }

}
