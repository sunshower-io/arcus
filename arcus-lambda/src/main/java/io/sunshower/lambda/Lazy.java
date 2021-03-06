package io.sunshower.lambda;

import io.sunshower.lambda.spliterators.TakeWhile;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Lazy {

  private Lazy() {}

  public static <T> Stream<T> takeWhile(Stream<T> stream, Predicate<T> f) {
    return StreamSupport.stream(new TakeWhile<>(stream.spliterator(), f), false);
  }
}
