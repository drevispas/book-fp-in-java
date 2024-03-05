package org.example.fpij.refactoring;

public class FirstRepeatedLetter {

  public char findIn(String word) {
    // imperative version
    char[] letters = word.toCharArray();
    for (int i=0; i<letters.length-1; i++) {
      char letter = letters[i];
      for (int j=i+1; j<letters.length; j++) {
        if (letters[j] == letter) return letter;
      }
    }
    return '\0';
  }
}
