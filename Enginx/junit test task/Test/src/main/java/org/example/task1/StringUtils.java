package org.example.task1;

class StringUtils {

  boolean startsWithIgnoreCase(String str, String prefix) {
    return str.toLowerCase().startsWith(prefix.toLowerCase());
  }

}
