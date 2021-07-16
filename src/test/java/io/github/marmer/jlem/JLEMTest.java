package io.github.marmer.jlem;

import static com.google.common.truth.Truth.assertThat;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.google.common.truth.Truth8;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import lombok.SneakyThrows;
import lombok.experimental.ExtensionMethod;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@ExtensionMethod(JLEM.class)
class JLEMTest {

  @Test
  @DisplayName("Stream can be converted to a list")
  @SneakyThrows
  void toList_stream_StreamCanBeConvertedToAList() {
    // Execution
    final List<String> result = Stream.of("a", "b", "c")._toList();

    // Assertion
    assertAll(
        () -> assertThat(result).isInstanceOf(List.class),
        () -> assertThat(result).containsExactly("a", "b", "c").inOrder()
    );
  }

  @Test
  @DisplayName("Stream can be converted to a set")
  @SneakyThrows
  void toSet_stream_StreamCanBeConvertedToASet() {
    // Execution
    final Set<String> result = Stream.of("a", "b", "c")._toSet();

    // Assertion
    assertAll(
        () -> assertThat(result).isInstanceOf(Set.class),
        () -> assertThat(result).containsExactly("a", "b", "c")
    );
  }

  @Test
  @DisplayName("Stream can be flattened")
  @SneakyThrows
  void flatten_stream_StreamCanBeFlattened() {
    // Execution
    final Stream<String> result = Stream.of(Stream.of("a"), Stream.of("b"), Stream.of("c"))
        ._flatten();
    // Assertion
    assertAll(
        () -> assertThat(result).isInstanceOf(Stream.class),
        () -> Truth8.assertThat(result).containsExactly("a", "b", "c").inOrder()
    );
  }

  @Test
  @DisplayName("Should return the last element")
  @SneakyThrows
  void last_stream_ShouldReturnTheLastElement() {
    // Execution
    final Optional<String> result = Stream.of("a", "b", "c")._findLast();
    // Assertion
    Truth8.assertThat(result).hasValue("c");
  }

  @Test
  @DisplayName("Should return the first element")
  @SneakyThrows
  void first_collection_ShouldReturnTheFirstElement() {
    // Preparation
    final List<String> strings = asList("a", "b", "c");
    // Execution
    final Optional<String> result = strings._findFirst();
    // Assertion
    Truth8.assertThat(result).hasValue("a");
  }

  @Test
  @DisplayName("Should return the last element")
  @SneakyThrows
  void last_collection_ShouldReturnTheLastElement() {
    // Preparation
    final Collection<String> strings = asList("a", "b", "c");
    // Execution
    final Optional<String> result = strings._findLast();
    // Assertion
    Truth8.assertThat(result).hasValue("c");
  }

  @Test
  @DisplayName("Should filter correctly")
  @SneakyThrows
  void filter_set_ShouldReturnTheLastElement() {
    // Preparation
    final Set<String> strings = new HashSet<>(asList("a", "b", "c"));
    // Execution
    final Set<String> result = strings._filter(it -> "a".equals(it) || "c".equals(it));
    // Assertion
    assertThat(result).containsExactly("a", "c").inOrder();
  }

  @Test
  @DisplayName("Should filter correctly")
  @SneakyThrows
  void filter_list_ShouldReturnTheLastElement() {
    // Preparation
    final List<String> strings = asList("a", "b", "c");
    // Execution
    final List<String> result = strings._filter(it -> "a".equals(it) || "c".equals(it));
    // Assertion
    assertThat(result).containsExactly("a", "c").inOrder();
  }

  @Test
  @DisplayName("Should filter correctly")
  @SneakyThrows
  void filter_collection_ShouldReturnTheLastElement() {
    // Preparation
    final Collection<String> strings = asList("a", "b", "c");
    // Execution
    final List<String> result = strings
        ._filter(it -> "a".equals(it) || "c".equals(it), ArrayList::new);
    // Assertion
    assertThat(result).containsExactly("a", "c").inOrder();
  }

  // TODO: marmer 17.07.2021 CI
  // TODO: marmer 17.07.2021 Sonar
  // TODO: marmer 17.07.2021 Javadoc
  // TODO: marmer 17.07.2021 Linting
  // TODO: marmer 17.07.2021 Stream Zipping
  // TODO: marmer 17.07.2021 License
  // TODO: marmer 17.07.2021 Release

}
