package org.example.fpij.refactoring;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class Factorial {

  public BigInteger compute(long upTo) {
    return BigInteger.valueOf(
        LongStream.rangeClosed(1, upTo)
            .reduce((x, y) -> x * y)
            .orElse(0)
    );
  }
}
