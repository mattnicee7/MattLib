package com.github.mattnicee7.mattlib.password;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PasswordVerifierBuilder {

    private final PasswordVerifier passwordVerifier = new PasswordVerifier();

    public PasswordVerifierBuilder symbolsPattern(char[] symbolsPattern) {
        passwordVerifier.setSymbolsPattern(symbolsPattern);
        return this;
    }

    public PasswordVerifierBuilder lowerLettersPattern(char[] lowerLettersPattern) {
        passwordVerifier.setLowerLettersPattern(lowerLettersPattern);
        return this;
    }

    public PasswordVerifierBuilder upperLettersPattern(char[] upperLettersPattern) {
        passwordVerifier.setUpperLettersPattern(upperLettersPattern);
        return this;
    }

    public PasswordVerifierBuilder minLength(int minLength) {
        passwordVerifier.setMinLength(minLength);
        return this;
    }

    public PasswordVerifierBuilder maxLength(int maxLength) {
        passwordVerifier.setMaxLength(maxLength);
        return this;
    }

    public PasswordVerifierBuilder minSymbols(int minSymbols) {
        passwordVerifier.setMinSymbols(minSymbols);
        return this;
    }

    public PasswordVerifierBuilder minLowerLetter(int minLowerLetter) {
        passwordVerifier.setMinLowerLetter(minLowerLetter);
        return this;
    }

    public PasswordVerifierBuilder minUpperLetter(int minUpperLetter) {
        passwordVerifier.setMinUpperLetter(minUpperLetter);
        return this;
    }

    public PasswordVerifierBuilder repeatedCharacters(boolean repeatedCharacters) {
        passwordVerifier.setRepeatedCharacters(repeatedCharacters);
        return this;
    }

    public PasswordVerifierBuilder removeBlankSpaces(boolean removeBlankSpaces) {
        passwordVerifier.setRemoveBlankSpaces(removeBlankSpaces);
        return this;
    }

    public PasswordVerifier build() {
        return passwordVerifier;
    }

}
