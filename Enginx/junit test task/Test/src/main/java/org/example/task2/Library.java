package org.example.task2;

import java.util.HashSet;
import java.util.Set;

class Library {

  private final Set<String> books = new HashSet<>();

  void addBook(String title) {
    books.add(title);
  }

  void removeBook(String title) {
    books.remove(title);
  }

  boolean hasBook(String title) {
    return books.contains(title);
  }

}
