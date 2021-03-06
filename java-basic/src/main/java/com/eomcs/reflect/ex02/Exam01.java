// 클래스 정보 추출 - 클래스 이름 알아내기
package com.eomcs.reflect.ex02;

public class Exam01 {

  public static void main(String[] args) throws Exception {
    Class clazz = Class.forName("java.lang.String");

    System.out.println(clazz.getSimpleName()); // String 클래스명만
    System.out.println(clazz.getName()); // java.lang.String 패키지 명을 포함한 명
    System.out.println(clazz.getCanonicalName()); // java.lang.String
    System.out.println(clazz.getTypeName()); // java.lang.String


  }

}
