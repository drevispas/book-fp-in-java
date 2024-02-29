package org.example.hackerrank;

import com.sun.source.tree.Tree;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class CommerceTest {

  @Test
  void teset1() {
//    List<String> words=List.of("aba", "ba", "bbba", "bc", "cccb", "abc");
//    List<String> words=List.of("a","b","c");
//    List<String> words=List.of("aba", "abaca", "baab", "cba");
    List<String> words = List.of("aba", "aba", "ba", "ab");
    countSimilarPairs(words);
  }

  public long countSimilarPairs(List<String> words) {
    Map<String, Long> wordCount = new HashMap<>();
    for (String s : words) {
      Set<Character> compressedWord = s.chars().mapToObj(i -> (char) i).sorted()
          .collect(Collectors.toSet());
      String key = compressedWord.stream().map(String::valueOf).collect(Collectors.joining());
      wordCount.put(key, wordCount.getOrDefault(key, 0L) + 1);
    }
    System.out.println(wordCount);
    long numPairs = wordCount.values().stream().reduce(0L, (p, q) -> p + q * (q - 1) / 2);
    System.out.println(numPairs);
    return numPairs;
  }

  @Test
  void test2() {
    List<Integer> list1 = List.of(1, 2, 3, 123322020);
    List<Integer> list2 = List.of(3, 3, 5, 123322020);
    getMinCores(list1, list2);
  }

  int getMinCores(List<Integer> start, List<Integer> end) {
//    int n = end.stream().mapToInt(v->v).max().orElse(0)+1;
//    List<Integer> requiredCores = new ArrayList<>(n);
//    for(int i=0;i<=n;i++) requiredCores.add(0);
//    for(int i=0;i<start.size();i++){
//      int startTime=start.get(i), endTime=end.get(i);
//      requiredCores.set(startTime, requiredCores.get(startTime)+1);
//      if (endTime+1 <= n)
//        requiredCores.set(endTime+1, requiredCores.get(endTime+1)-1);
//    }
//    int maxCores=0, cores=0;
//    for(int i=1;i<=n;i++){
//      cores += requiredCores.get(i);
//      maxCores = Math.max(maxCores, cores);
//    }
//    return maxCores;
//  }

    Map<Integer, Integer> jobCount = new HashMap<>();
    for (int s : start) {
      jobCount.put(s, jobCount.getOrDefault(s, 0) + 1);
    }
    for (int e : end) {
      jobCount.put(e + 1, jobCount.getOrDefault(e + 1, 0) - 1);
    }
    System.out.println("jobCount=" + jobCount);
    List<Integer> spotCores = jobCount.entrySet().stream()
        .sorted(Comparator.comparingInt(Map.Entry::getKey))
        .map(x -> x.getValue())
        .collect(Collectors.toList());
    System.out.println("spotCores=" + spotCores);
    int maxCores = 0, acc = 0;
    for (int c : spotCores) {
      acc += c;
      maxCores = Math.max(maxCores, acc);
    }
//    System.out.println("maxCores="+maxCores);
    return maxCores;
  }
}
