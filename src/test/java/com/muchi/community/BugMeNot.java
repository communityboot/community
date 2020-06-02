package com.muchi.community;

public class BugMeNot {
  public static boolean isJavaClass(Class<?> clz) {    

    return clz != null && clz.getClassLoader() == null;
  }    
      
  public static void main(String... args) {    
    System.out.println(isJavaClass(Integer.class)); // true    
    System.out.println(isJavaClass(char.class)); // true
    System.out.println(isJavaClass(DictNotNullTest.class)); // false
  }    
} 