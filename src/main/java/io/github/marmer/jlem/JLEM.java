package io.github.marmer.jlem;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JLEM {

  public static <T> List<T> _toList(final Stream<T> extensionPoint) {
    return extensionPoint.collect(Collectors.toList());
  }

  public static <T> Set<T> _toSet(final Stream<T> extensionPoint) {
    return extensionPoint.collect(Collectors.toSet());
  }

  public static <T> Stream<T> _flatten(final Stream<Stream<T>> extensionPoint) {
    return extensionPoint.flatMap(it -> it);
  }

  public static <T> Optional<T> _findLast(final Stream<T> extensionPoint) {
    return extensionPoint.reduce((first, second) -> second);
  }

  public static <T> Optional<T> _findLast(final Collection<T> extensionPoint) {
    return extensionPoint.stream().reduce((first, second) -> second);
  }

  public static <T> Optional<T> _findFirst(final Collection<T> extensionPoint) {
    return extensionPoint.stream().findFirst();
  }

  public static <T> List<T> _filter(final List<T> extensionPoint, final Predicate<T> filter) {
    return extensionPoint.stream().filter(filter).collect(Collectors.toList());
  }

  public static <T> Set<T> _filter(final Set<T> extensionPoint, final Predicate<T> filter) {
    return extensionPoint.stream().filter(filter).collect(Collectors.toSet());
  }

  public static <T, C extends Collection<T>> C _filter(final Collection<T> extensionPoint,
      final Predicate<T> filter, final Supplier<C> collectionFactory) {
    return extensionPoint.stream().filter(filter)
        .collect(Collectors.toCollection(collectionFactory));
  }
}
