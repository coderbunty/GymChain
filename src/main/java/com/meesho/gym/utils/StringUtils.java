package com.meesho.gym.utils;

public class StringUtils {

  public static boolean isInteger(String value) {
    try {
      Integer.parseInt(value);
      return true;
    } catch (NumberFormatException ex) {
      return false;
    }
  }

}
