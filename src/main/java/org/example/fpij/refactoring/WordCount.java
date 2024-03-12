package org.example.fpij.refactoring;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {

  public int countInFile(String keyword, String filePath) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(filePath));
    int count = 0;
    String line = null;
    while ((line = br.readLine()) != null) {
      String[] words = line.split(" ");
      for (String w: words) {
        if(w.equals(keyword)) count++;
      }
    }
    return count;
  }
}
